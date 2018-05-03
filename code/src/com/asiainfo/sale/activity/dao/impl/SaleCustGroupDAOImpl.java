package com.asiainfo.sale.activity.dao.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.asiainfo.costWarn.job.ConnectUtil;
import com.asiainfo.sale.activity.bo.BOSaleCustGroupEngine;
import com.asiainfo.sale.activity.dao.interfaces.ISaleCustGroupDAO;
import com.asiainfo.sale.activity.ivalues.IBOSaleCustGroupValue;
import com.asiainfo.sale.util.StringUtil;

public class SaleCustGroupDAOImpl implements ISaleCustGroupDAO {

	@Override
	public IBOSaleCustGroupValue[] getCustGroup(String cityId,
			String custGroupName, String createDateF, String createDateE,
			int startNum, int endNum) throws Exception {

		ArrayList<Object> cdAndParam = getConditionAndPare(cityId,
				custGroupName, createDateF, createDateE);
		String cd = String.valueOf(cdAndParam.get(0));
		Map<String, String> param = (Map<String, String>) cdAndParam.get(1);
		cd += " order by create_date desc";
		return BOSaleCustGroupEngine.getBeans(null, cd, param, startNum,
				endNum, false, null);
	}

	@Override
	public int getCustGroupCn(String cityId, String custGroupName,
			String createDateF, String createDateE) throws Exception {
		ArrayList<Object> cdAndParam = getConditionAndPare(cityId,
				custGroupName, createDateF, createDateE);
		String cd = String.valueOf(cdAndParam.get(0));
		Map<String, String> param = (Map<String, String>) cdAndParam.get(1);
		return BOSaleCustGroupEngine.getBeansCount(cd, param);
	}

	private ArrayList<Object> getConditionAndPare(String cityId,
			String custGroupName, String createDateF, String createDateE)
			throws UnsupportedEncodingException {

		String cd = " 1=1 ";
		ArrayList<Object> ret = new ArrayList<Object>();
		Map<String, String> param = new HashMap<String, String>();
		if (StringUtil.isNotBlank(cityId)) {
			cd += " and " + IBOSaleCustGroupValue.S_CityId + " = :cityId ";
			param.put("cityId", cityId);
		}
		if (StringUtil.isNotBlank(custGroupName)) {
			cd += " and " + IBOSaleCustGroupValue.S_CustGroupName
					+ " like :custGroupName ";
			param.put("custGroupName", "%"
					+ URLDecoder.decode(custGroupName, "utf-8") + "%");
		}
		if (StringUtil.isNotBlank(createDateF)) {
			cd += " and " + IBOSaleCustGroupValue.S_CreateDate
					+ " >= :createDateF";
			param.put("createDateF", createDateF);
		}
		if (StringUtil.isNotBlank(createDateE)) {
			cd += " and " + IBOSaleCustGroupValue.S_CreateDate
					+ " <= :createDateE";
			param.put("createDateE", createDateE);
		}
		ret.add(cd);
		ret.add(param);
		return ret;
	}

	@Override
	public void addCGroupSchedule(String orderId) throws Exception {

		Connection conn = null;
		PreparedStatement pst = null;
		// String sql =
		// "insert into hbsale.cgroup_trans_schedule(order_id,level_id,cgroup_table) "
		// + "SELECT DISTINCT so.ORDER_ID, sd.id, sd.CUST_GROUP_TAB "
		// +
		// "FROM HBSALE.SALE_DETAIL_T sd, hbsale.sale_main_t sm, HBSALE.SALE_order_t so "
		// + "   WHERE  sd.SALE_ID = sm.ID "
		// + "      AND so.ORDER_ID = sm.ORDER_ID "
		// + "      AND sd.CUST_GROUP_TAB IS NOT NULL "
		// + "      AND so.ORDER_ID NOT IN "
		// + "        (SELECT order_id FROM hbsale.cgroup_trans_schedule) "
		// + "      AND so.ORDER_ID = ?";
		String sql = "insert into hbsale.cgroup_trans_schedule(id, order_id, cgroup_table) "
				+ "select id, order_id, cgroup_tab from hbsale.sale_relat_cgroup where order_id=? "
				+ "and order_id not in (select order_id from hbsale.cgroup_trans_schedule)";
		try {
			conn = ConnectUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, orderId);
			pst.execute();
			pst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pst != null) {
				pst.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

}
