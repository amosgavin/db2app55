package com.asiainfo.sale.activity.web;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.appframe2.web.action.BaseAction;
import com.asiainfo.costWarn.job.ConnectUtil;
import com.asiainfo.sale.activity.bo.BOSaleDetailBean;
import com.asiainfo.sale.activity.ivalues.IBOSaleDetailValue;
import com.asiainfo.sale.activity.service.interfaces.IChannelRuleSV;
import com.asiainfo.sale.activity.service.interfaces.IRelateSaleWithGoodsSV;
import com.asiainfo.sale.activity.service.interfaces.ISaleDetailSV;
import com.asiainfo.sale.product.bo.BOSaleDetailExtBean;
import com.asiainfo.sale.product.ivalues.IBOSaleDetailExtValue;
import com.asiainfo.sale.product.services.interfaces.ISaleDetailExtSV;
import com.asiainfo.sale.util.StringUtil;

public class SaleDetailAction extends BaseAction {
	private transient static Log log = LogFactory
			.getLog(SaleDetailAction.class);

	public void saveSaleDetail(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { BOSaleDetailBean.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}

		IBOSaleDetailValue[] SaleDetailValues = null;// 前台提交的数据

		for (int i = 0; i < dcLists.length; i++) {
			Object[] obj = dcLists[i].getColDataContainerInterface(0);
			if (obj instanceof BOSaleDetailBean[]) {
				SaleDetailValues = (BOSaleDetailBean[]) obj;
			}
		}

		ISaleDetailSV SaleDetailSV = (ISaleDetailSV) ServiceFactory
				.getService(ISaleDetailSV.class);

		try {
			if (null == SaleDetailValues || 0 == SaleDetailValues.length) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else {
				String saleDetailId = SaleDetailSV
						.saveSaleDetail(SaleDetailValues);
				cp.set("LEVID", saleDetailId);
				cp.set("FLAG", "Y");
				cp.set("MESSAGE", "操作成功！");
			}
		} catch (Exception e) {
			// 操作失败
			log.error("保存营销案主信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void saveRelateGoodsWithSaleDetail(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String saleItemId = request.getParameter("saleDetailId");
		String detailid = request.getParameter("detailid");
		String goodsTagIds = request.getParameter("goodsTagIds");
		String isrows = request.getParameter("isrows");
		ISaleDetailSV SaleDetailSV = (ISaleDetailSV) ServiceFactory
				.getService(ISaleDetailSV.class);

		IRelateSaleWithGoodsSV iRelateSaleWithGoodsSV = (IRelateSaleWithGoodsSV) ServiceFactory
				.getService(IRelateSaleWithGoodsSV.class);

		try {

			if (StringUtil.isBlank(saleItemId) && StringUtil.isBlank(detailid)) {
				saleItemId = SaleDetailSV.getNewSaleDetailId();
			}
			if (StringUtil.isNotBlank(detailid)) {
				saleItemId = detailid;
			}
			iRelateSaleWithGoodsSV.savaRelateSaleWithGoods(saleItemId,
					goodsTagIds, isrows);
			cp.set("saleDetailId", saleItemId);
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			// 操作失败
			log.error("添加货品出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	public void deleteRelateGoodsWithSaleDetail(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String saleItemId = request.getParameter("saleItemId");
		String goodsTagIds = request.getParameter("goodsTagIds");

		IRelateSaleWithGoodsSV iRelateSaleWithGoodsSV = (IRelateSaleWithGoodsSV) ServiceFactory
				.getService(IRelateSaleWithGoodsSV.class);

		try {

			iRelateSaleWithGoodsSV.deleteRelateSaleWithGoods(saleItemId,
					goodsTagIds);
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			// 操作失败
			log.error("删除货品出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}
	}

	/**
	 * add by jiangxl 删除档次信息
	 * 
	 * @param request
	 * @param repsonse
	 * @throws Exception
	 */
	public void saveSaleDetailNew(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CustomProperty cp = CustomProperty.getInstance();

		String channelRulesIds = request.getParameter("channelRulesIds");
		System.out.println(channelRulesIds);
		String goodsTagIds = request.getParameter("goodsTagIds");
		String isrows = request.getParameter("isrows");
		String opType = request.getParameter("opType");
		String sts = HttpUtil.getAsString(request, "sts");
		// 前台传递的XML数据，后台接收方法
		DataContainerList[] dcLists = HttpUtil.getDataContainerLists(request
				.getInputStream(), new Class[] { DataContainer.class });

		if (dcLists.length == 0) {
			HttpUtil.showInfo(response, "操作对象为空！");
			return;
		}

		DataContainerInterface[] obj = null;
		List saleList = new ArrayList();
		List extList = new ArrayList();
		String saleDetailId = null;
		ISaleDetailSV SaleDetailSV = (ISaleDetailSV) ServiceFactory
				.getService(ISaleDetailSV.class);
		ISaleDetailExtSV extSv = (ISaleDetailExtSV) ServiceFactory
				.getService(ISaleDetailExtSV.class);

		for (int i = 0; i < dcLists.length; i++) {
			DataContainerInterface[] objs = (DataContainerInterface[]) dcLists[i]
					.getColDataContainerInterface(0);
			System.out.println(objs[0].getObjectType().getClassName());
			if ("save".equals(opType)) {
				if (i == 0) {
					for (DataContainerInterface d : objs) {

						if ("2".equals(sts)) {
							IBOSaleDetailExtValue tempExtValue = new BOSaleDetailExtBean();
							tempExtValue.copy(d);
							extList.add(tempExtValue);
						} else {
							IBOSaleDetailValue tempValue = new BOSaleDetailBean();
							tempValue.copy(d);
							saleList.add(tempValue);
						}
					}
				} else if (i == 1) {
					for (DataContainerInterface d : objs) {
						IBOSaleDetailExtValue tempExtValue = new BOSaleDetailExtBean();
						tempExtValue.copy(d);
						extList.add(tempExtValue);
					}

				}
			} else {
				obj = objs;
			}

			// if (obj instanceof DataContainer[]) {
			// saleExtValues = (BOSaleDetailExtQBean[]) obj;
			// }
		}

		try {
			if ((null == obj || 0 == obj.length)
					&& (null == saleList || saleList.size() == 0)
					&& (null == extList && extList.size() == 0)) {
				cp.set("FLAG", "N");
				cp.set("MESSAGE", "操作对象为空！");
			} else {
				IBOSaleDetailValue[] saleDetailValues = null;
				IBOSaleDetailExtValue[] saleDetailExtValues = null;
				if (null != obj && obj.length != 0) {
					saleDetailValues = new BOSaleDetailBean[obj.length];
					saleDetailExtValues = new BOSaleDetailExtBean[obj.length];
					int index = 0;
					int e_index = 0;
					for (int j = 0; j < obj.length; j++) {
						if (obj[j].isDeleted()) {
							IBOSaleDetailValue delValue = new BOSaleDetailBean();
							IBOSaleDetailExtValue delExtValue = new BOSaleDetailExtBean();
							delValue.setId(obj[j].getAsString("DETAIL_ID"));
							delExtValue.setEId(obj[j].getAsLong("E_ID"));
							delValue.setStsToOld();
							delValue.delete();
							delExtValue.setStsToOld();
							delExtValue.delete();

							saleDetailValues[index++] = delValue;
							saleDetailExtValues[e_index++] = delExtValue;

						}

					}
					saleDetailId = SaleDetailSV
							.saveSaleDetail(saleDetailValues);

					extSv.saveSaleDetailExtValue(saleDetailExtValues);
				}
				if (null != saleList && saleList.size() > 0) {
					saleDetailValues = (IBOSaleDetailValue[]) saleList
							.toArray(new BOSaleDetailBean[saleList.size()]);
					saleDetailId = SaleDetailSV
							.saveSaleDetail(saleDetailValues);
					saleDetailExtValues = (IBOSaleDetailExtValue[]) extList
							.toArray(new BOSaleDetailExtBean[extList.size()]);
					if (StringUtil.isNotBlank(saleDetailId)) {
						if (null == saleDetailExtValues
								|| saleDetailExtValues.length <= 0) {
							saleDetailExtValues = new BOSaleDetailExtBean[saleDetailValues.length];
						}

						for (int a = 0; a < saleDetailExtValues.length; a++) {
							if (null == saleDetailExtValues[a]) {
								saleDetailExtValues[a] = new BOSaleDetailExtBean();
							}
							saleDetailExtValues[a].setFDetailId(saleDetailId);
							if (saleDetailExtValues[a].isNew()) {
								saleDetailExtValues[a].setEId(extSv.getNewId());
								saleDetailExtValues[a]
										.setCreateDate(new Timestamp(System
												.currentTimeMillis()));
								saleDetailExtValues[a].setStatus("1");
								saleDetailExtValues[a].setStaffId(String
										.valueOf(SessionManager.getUser()
												.getID()));

							} else if (saleDetailExtValues[a].isModified()) {
								saleDetailExtValues[a]
										.setModifyDate(new Timestamp(System
												.currentTimeMillis()));
								saleDetailExtValues[a].setStaffId(String
										.valueOf(SessionManager.getUser()
												.getID()));
							}
						}
					}

					extSv.saveSaleDetailExtValue(saleDetailExtValues);

				}
				if (null != extList && extList.size() != 0 && "2".equals(sts)) {
					saleDetailExtValues = (IBOSaleDetailExtValue[]) extList
							.toArray(new BOSaleDetailExtBean[extList.size()]);
					for (int a = 0; a < saleDetailExtValues.length; a++) {
						if (saleDetailExtValues[a].isModified()) {
							saleDetailExtValues[a].setModifyDate(new Timestamp(
									System.currentTimeMillis()));
							saleDetailExtValues[a].setStaffId(String
									.valueOf(SessionManager.getUser().getID()));
						} else {
							continue;
						}
					}
					extSv.saveSaleDetailExtValue(saleDetailExtValues);
				}

				if (StringUtil.isNotBlank(channelRulesIds)
						&& StringUtil.isNotBlank(saleDetailId)) {
					IChannelRuleSV channelRuleSv = (IChannelRuleSV) ServiceFactory
							.getService(IChannelRuleSV.class);
					channelRuleSv.bindChannelRule2SaleDetailId(saleDetailId,
							channelRulesIds);
				}
			}
			cp.set("FLAG", "Y");
			cp.set("MESSAGE", "操作成功！");
		} catch (Exception e) {
			// 操作失败
			log.error("保存营销案主信息出错", e);
			cp.set("FLAG", "N");
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
		}

	}

	public  void queryres(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String city_id=request.getParameter("city_id");
		CustomProperty cp = CustomProperty.getInstance();
		Connection conn=null;
		ResultSet rs=null;
		Statement st=null;
		try {
			 conn=ConnectUtil.getConnection();
			String sql="SELECT a.CITY_ID," +
					"a.CITY_name," +
					"decimal((a.P_TERM-b.P_TERM/10000),9,2) " +
					"p_term_used," +
					"decimal((a.P_DISC-b.P_DISC/10000),9,2) " +
					"p_disc_used," +
					"decimal((a.P_POINTS-b.P_POINTS/10000),9,2) " +
					"p_points_used," +
					"decimal((a.P_PROMT-b.P_PROMT/10000),9,2) " +
					"p_promt_used," +
					"decimal((a.l_TERM-b.l_TERM/10000),9,2) " +
					"l_term_used," +
					"decimal((a.l_DISC-b.l_DISC/10000),9,2) " +
					"l_disc_used," +
					"decimal((a.l_POINTS-b.l_POINTS/10000),9,2) " +
					"l_points_used," +
					"decimal((a.l_PROMT-b.l_PROMT/10000),9,2) " +
					" l_promt_used               FROM hbsale.resource_allot a " +
					"LEFT JOIN" +
					"(SELECT value (city_code, 'HB') city_code," +
					"sum (p_term) p_term," +
					"sum (L_term) L_term," +
					"sum (p_disc) p_disc," +
					"sum (L_disc) L_disc," +
					"sum (p_points) p_points," +
					"sum (L_points) L_points," +
					"sum (p_promt) p_promt," +
					"sum (L_promt) L_promt " +
					"FROM (SELECT city_code," +
					"CASE WHEN createorg = 'HB' THEN terminal_cost_year ELSE 0 END " +
					"p_term," +
					"CASE WHEN createorg <> 'HB' THEN terminal_cost_year ELSE 0 END " +
					"L_term," +
					"CASE WHEN createorg = 'HB' THEN action_out_year ELSE 0 END " +
					"p_disc," +
					"CASE WHEN createorg <> 'HB' THEN action_out_year ELSE 0 END " +
					"L_disc," +
					"CASE WHEN createorg = 'HB' THEN promote_score_year ELSE 0 END " +
					"p_points," +
					"CASE WHEN createorg <> 'HB' THEN promote_score_year ELSE 0 END " +
					"L_points, " +
					"CASE " +
					"WHEN createorg = 'HB' THEN (cxp_cost_year) " +
					"ELSE 0 " +
					"END " +
					"p_promt, " +
					"CASE " +
					"WHEN createorg <> 'HB' THEN (cxp_cost_year) " +
					"ELSE 0 " +
					"END " +
					"L_promt " +
					"FROM " +
					"hbsale.priv_cost_new_201609 " +
					"WHERE city_code IS NOT NULL AND createorg IS NOT NULL) group " +
					"by city_code with rollup) b " +
					"on a.CITY_CODE=b.CITY_CODE where city_id="+city_id ;
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			String TERMINAL_COST="";
			String ACTION_OUT="";
			String PROMOTE_SCORE="";
			String SALE_POINT="";
			if(city_id.equals("10")){
			while(rs.next()){
				TERMINAL_COST=rs.getString("p_term_used");
				ACTION_OUT=rs.getString("p_disc_used");
				PROMOTE_SCORE=rs.getString("p_points_used");
				SALE_POINT=rs.getString("p_promt_used");
			}
			} else{
				while(rs.next()){
					TERMINAL_COST=rs.getString("l_term_used");
					ACTION_OUT=rs.getString("l_disc_used");
					PROMOTE_SCORE=rs.getString("l_points_used");
					SALE_POINT=rs.getString("l_promt_used");
				}
			}
			cp.set("TERMINAL_COST", TERMINAL_COST);
			cp.set("ACTION_OUT", ACTION_OUT);
			cp.set("PROMOTE_SCORE", PROMOTE_SCORE);
			cp.set("SALE_POINT", SALE_POINT);
		} catch (Exception e) {
			System.out.println(e.toString());
			// 操作失败
			cp.set("MESSAGE", "操作失败" + ":" + e.getMessage());
		} finally {
			HttpUtil.showInfo(response, cp);
			if(rs!=null){
				rs.close();
			}if(conn!=null){
				conn.close();
			}
		}
	}
	
}
