package com.asiainfo.sale.activity.dao.impl;

import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.collections.map.HashedMap;
import com.asiainfo.sale.activity.bo.BOSaleDetailEngine;
import com.asiainfo.sale.activity.bo.BOSaleMainEngine;
import com.asiainfo.sale.activity.bo.BOSaleOrderEngine;
import com.asiainfo.sale.activity.dao.interfaces.ISaleMainDAO;
import com.asiainfo.sale.activity.dao.interfaces.ISaleOrderDAO;
import com.asiainfo.sale.activity.ivalues.IBOSaleDetailValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleMainValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleOrderValue;

public class SaleOrderDAOImpl implements ISaleOrderDAO {

	@Override
	public int saveSaleOrderInfo(IBOSaleOrderValue saleOrderValue)
			throws Exception {

		int orderId = saleOrderValue.getOrderId();
		if (saleOrderValue != null) {
			if (saleOrderValue.isNew()) {
				orderId = BOSaleOrderEngine.getNewId().intValue();
				saleOrderValue.setOrderId(orderId);
				saleOrderValue.setState("1");
				saleOrderValue.setStsToNew();
			}
		}
		BOSaleOrderEngine.save(saleOrderValue);
		return orderId;
	}

	@Override
	public IBOSaleOrderValue[] getSaleOrderInfo(String orderId,
			String orderName, String pinciple, String staffName, String orgId,
			String orgName, String state, String beginTime, String endTime,
			int startNum, int endNum) throws Exception {

		return BOSaleOrderEngine.getBeans(null, getCondition(orderId,
				orderName, pinciple, staffName, orgId, orgName, state,
				beginTime, endTime)
				+ " order by create_date desc ", null, startNum, endNum, false);
	}

	private String getCondition(String orderId, String orderName,
			String pinciple, String staffName, String orgId, String orgName,
			String state, String beginTime, String endTime) throws Exception {

		String condition = " 1=1 ";
		if (orderId != null && !orderId.equals("")) {
			condition += " and " + IBOSaleOrderValue.S_OrderId + " = "
					+ orderId;
		}
		if (orderName != null && !orderName.equals("")) {
			condition += " and " + IBOSaleOrderValue.S_OrderName + " like '%"
					+ URLDecoder.decode(orderName, "utf-8") + "%'";
		}
		if (pinciple != null && !pinciple.equals("")) {
			condition += " and " + IBOSaleOrderValue.S_Principle + " = "
					+ pinciple;
		}
		if (staffName != null && !staffName.equals("")) {
			condition += " and " + IBOSaleOrderValue.S_PropName + " like '%"
					+ staffName + "%'";
		}
		if (orgId != null && !orgId.equals("") && !orgId.equals("0")) {
			if (orgId.equals("18")) {
				condition += " and substr(org_id,1,2) in (18, 27, 28)";
			} else {
				condition += " and substr(org_id,1,2) = " + orgId;
			}
		}
		if (orgName != null && !orgName.equals("")) {
			condition += " and " + IBOSaleOrderValue.S_OrgName + " like '%"
					+ orgName + "%'";
		}
		if (state != null && !state.equals("") && !state.equals("0")) {
			condition += " and " + IBOSaleOrderValue.S_State + " = " + state;
		}
		if (beginTime != null && !beginTime.equals("")) {
			condition += " and " + IBOSaleOrderValue.S_CreateDate + " >= '"
					+ beginTime + "'";
		}
		if (endTime != null && !endTime.equals("")) {
			condition += " and " + IBOSaleOrderValue.S_CreateDate + " <= '"
					+ endTime + "'";
		}
		condition = condition +" and ("+ IBOSaleOrderValue.S_IsDelete+ " != '1' or "+IBOSaleOrderValue.S_IsDelete+" is null)";
		return condition;
	}

	@Override
	public IBOSaleMainValue[] getSaleMainByOrderId(String orderId,
			int startNum, int endNum) throws Exception {

		String condition = " " + IBOSaleMainValue.S_OrderId + "=" + orderId
				+ " order by int(id)";
		return BOSaleMainEngine.getBeans(null, condition, null, startNum,
				endNum, false);
	}

	@Override
	public int getSaleMainCountByOrderId(String orderId) throws Exception {

		String condition = " " + IBOSaleMainValue.S_OrderId + "=" + orderId;
		return BOSaleMainEngine.getBeansCount(condition, null);
	}

	@Override
	public int getSaleOrderCount(String orderId, String orderName,
			String pinciple, String staffName, String orgId, String orgName,
			String state, String beginTime, String endTime) throws Exception {

		return BOSaleOrderEngine.getBeansCount(
				getCondition(orderId, orderName, pinciple, staffName, orgId,
						orgName, state, beginTime, endTime), null);
	}

	@Override
	public void cloneSaleOrder(String orderId, String operatorId,
			String staffName, String orgId, String orgName) throws Exception {

		// copy sale_order_t
		IBOSaleOrderValue cloneSaleOrder = BOSaleOrderEngine.getBean(Integer
				.parseInt(orderId));
		int newOrderId = BOSaleOrderEngine.getNewId().intValue();
		cloneSaleOrder.setOrderId(newOrderId);
		cloneSaleOrder.setState("1");
		cloneSaleOrder.setPrinciple(operatorId);
		cloneSaleOrder.setPropName(staffName);
		cloneSaleOrder.setOrgId(orgId);
		cloneSaleOrder.setOrgName(orgName);
		cloneSaleOrder.setCreateDate(new Timestamp((new Date()).getTime()));
		cloneSaleOrder.setStsToNew();
		BOSaleOrderEngine.save(cloneSaleOrder);
		// copy sale_main_t
		IBOSaleMainValue[] cloneSaleMains = getSaleMainByOrderId(orderId, 1,
				1000);
		for (IBOSaleMainValue saledMain : cloneSaleMains) {
			((ISaleMainDAO) ServiceFactory.getService(ISaleMainDAO.class))
					.cloneSaleMain(saledMain.getId(), String
							.valueOf(newOrderId));
		}
		// copy attach file
		/*
		 * ((INewAttachDAO) ServiceFactory.getService(INewAttachDAO.class))
		 * .cloneAttachByItemIdType(orderId, String.valueOf(newOrderId),
		 * "sale");
		 */
	}

	@Override
	public IBOSaleOrderValue getSaleOrderInfo(String orderId) throws Exception {

		return BOSaleOrderEngine.getBean(Integer.parseInt(orderId));
	}

	@Override
	public void changeStsTo(String orderId, String state) throws Exception,
			RuntimeException {

		IBOSaleOrderValue saleOrderValue = getSaleOrderInfo(orderId);
		saleOrderValue.setState(state);
		BOSaleOrderEngine.save(saleOrderValue);
	}

	@Override
	public void changeStsToAgreen(String orderId) throws Exception,
			RuntimeException {

		changeStsTo(orderId, "3");
	}

	@Override
	public void changeStsToNo(String orderId) throws Exception,
			RuntimeException {

		changeStsTo(orderId, "4");
	}

	@Override
	public IBOSaleDetailValue[] getSaleDetailByOrderId(String orderId,
			int startNum, int endNum) throws Exception {

		String condition = " " + IBOSaleDetailValue.S_SaleId
				+ " in (select sm.id from sale_main_t sm where order_id = '"
				+ orderId + "') order by int(id)";
		return BOSaleDetailEngine.getBeans(null, condition, null, startNum,
				endNum, false);
	}

	@Override
	public int getSaleDetailCountByOrderId(String orderId) throws Exception {

		String condition = " " + IBOSaleDetailValue.S_SaleId
				+ " in (select sm.id from sale_main_t sm where order_id = '"
				+ orderId + "')";
		return BOSaleDetailEngine.getBeansCount(condition, null);
	}

	@Override
	public IBOSaleOrderValue[] getRelatSaleOrderByWpId(String wpId,
			int startNum, int endNum) throws Exception, RuntimeException {

		String condition = " "
				+ IBOSaleOrderValue.S_OrderId
				+ " IN (SELECT value(sm.order_id,0) FROM SALE_MAIN_T sm WHERE id IN (SELECT sale_id FROM SALE_DETAIL_T WHERE WEAPON_ID = '"
				+ wpId + "')) ORDER BY CREATE_DATE DESC ";
		return BOSaleOrderEngine.getBeans(null, condition, null, startNum,
				endNum, false);
	}

	@Override
	public int getRelatSaleOrderCnByWpId(String wpId)
			throws Exception, RuntimeException {

		String condition = " "
				+ IBOSaleOrderValue.S_OrderId
				+ " IN (SELECT value(sm.order_id,0) FROM SALE_MAIN_T sm WHERE id IN (SELECT sale_id FROM SALE_DETAIL_T WHERE WEAPON_ID = '"
				+ wpId + "')) ";
		return BOSaleOrderEngine.getBeansCount(condition, null);
	}

	@Override
	public int getSaleOrderCountBySql(String orderId, String orderName,
			String pinciple, String staffName, String orgId, String orgName,
			String state, String beginTime, String endTime) throws Exception {
		return 0;
	}

	@Override
	public IBOSaleOrderValue[] getSaleOrderInfoBySql(String orderId,
			String orderName, String pinciple, String staffName, String orgId,
			String orgName, String state, String beginTime, String endTime,
			int startNum, int endNum) throws Exception {
		String Condition=getCondition2(orderId,
				orderName, pinciple, staffName, orgId, orgName, state,
				beginTime, endTime);
		 String sql="select distinct(m.order_id),m.* from sale_order_t m left join sale_main_t b on m.ORDER_ID=b.order_id " +
				"left join  sale_detail_t c on b.id=c.sale_id where RESERVE2 ='1' and "+Condition;
		 return BOSaleOrderEngine.getBeansFromSql(sql, null);
	}
	
	private String getCondition2(String orderId, String orderName,
			String pinciple, String staffName, String orgId, String orgName,
			String state, String beginTime, String endTime) throws Exception {

		String condition = " 1=1 ";
		if (orderId != null && !orderId.equals("")) {
			condition += " and m.order_id = "
					+ orderId;
		}
		if (orderName != null && !orderName.equals("")) {
			condition += " and m.order_name like '%"
					+ URLDecoder.decode(orderName, "utf-8") + "%'";
		}
		if (staffName != null && !staffName.equals("")) {
			condition += " and m.PROP_NAME like '%"
					+ URLDecoder.decode(staffName, "utf-8") + "%'";
		}
		if (orgId != null && !orgId.equals("") && !orgId.equals("0")) {
			if (orgId.equals("18")) {
				condition += " and substr(m.org_id,1,2) in (18, 27, 28)";
			} else {
				condition += " and substr(m.org_id,1,2) = " + orgId;
			}
		}
		if (state != null && !state.equals("") && !state.equals("0")) {
			condition += " and m.state = " + state;
		}
		if (beginTime != null && !beginTime.equals("")) {
			condition += " and m.CREATE_DATE >= '"
					+ beginTime + "'";
		}
		if (endTime != null && !endTime.equals("")) {
			condition += " and m.CREATE_DATE <= '"
					+ endTime + "'";
		}
		condition = condition +" and ("+ IBOSaleOrderValue.S_IsDelete+ " != '1' or "+IBOSaleOrderValue.S_IsDelete+" is null)";
		return condition;
	}

}
