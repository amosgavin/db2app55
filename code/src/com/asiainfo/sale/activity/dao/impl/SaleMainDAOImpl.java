package com.asiainfo.sale.activity.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.costWarn.job.ConnectUtil;
import com.asiainfo.sale.activity.bo.BOSaleDetailEngine;
import com.asiainfo.sale.activity.bo.BOSaleMainEngine;
import com.asiainfo.sale.activity.bo.BOSaleOrderEngine;
import com.asiainfo.sale.activity.dao.interfaces.ISaleChannelInfoDAO;
import com.asiainfo.sale.activity.dao.interfaces.ISaleDetailDAO;
import com.asiainfo.sale.activity.dao.interfaces.ISaleEitAppriseDAO;
import com.asiainfo.sale.activity.dao.interfaces.ISaleMainDAO;
import com.asiainfo.sale.activity.ivalues.IBOSaleDetailValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleMainValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleOrderValue;
import com.asiainfo.sale.util.StringUtil;

public class SaleMainDAOImpl implements ISaleMainDAO {

	public void delSaleMain(IBOSaleMainValue[] saleMainValues) throws Exception {
		for (int i = 0; i < saleMainValues.length; i++) {
			saleMainValues[i].delete();
		}
		BOSaleMainEngine.save(saleMainValues);
	}

	public int getCount(String name, String applicant, String org)
			throws Exception {
		Object[] objects = getCondition(name, applicant, org);
		return BOSaleMainEngine.getBeansCount((String) objects[0],
				(Map) objects[1]);
	}

	public IBOSaleMainValue[] getSaleMain(String name, String applicant,
			String org, int startNum, int endNum) throws Exception {
		String[] cols = null;
		boolean isShowFK = false;
		Object[] objects = getCondition(name, applicant, org);
		return BOSaleMainEngine.getBeans(cols, (String) objects[0],
				(Map) objects[1], startNum, endNum, isShowFK);
	}

	public IBOSaleMainValue getSaleMainById(String id) throws Exception {
		return BOSaleMainEngine.getBean(id);
	}

	public void saveSaleMain(IBOSaleMainValue[] saleMainValues)
			throws Exception {

		BOSaleMainEngine.save(saleMainValues);
	}

	public String saveSaleMain(IBOSaleMainValue saleMainValue) throws Exception {
		if (saleMainValue != null) {
			// 新增，需要取ID
			if (saleMainValue.isNew()) {
				saleMainValue.setId(BOSaleMainEngine.getNewId().toString());
				saleMainValue.setIsSubmit("1");
				saleMainValue.setSaleMainCode(getACTCode(saleMainValue));
				saleMainValue.setCreateTime(BOSaleMainEngine.getSysDate());
				saleMainValue.setStsToNew();
			} else {
				// System.out.println(saleMainValue.getId());
				IBOSaleMainValue saleMainTemp = BOSaleMainEngine
						.getBean(saleMainValue.getId());
				if (saleMainValue.getIsSubmit() != null
						&& !saleMainValue.getIsSubmit().equals("")) {
					saleMainTemp.setIsSubmit(saleMainValue.getIsSubmit());
					saleMainTemp.setExearea(saleMainValue.getExearea());
					saleMainTemp.setMarktype(saleMainValue.getMarktype());
					saleMainTemp.setBeginTime(saleMainValue.getBeginTime());
					IBOSaleOrderValue orderValue = BOSaleOrderEngine
							.getBean(Integer
									.parseInt(saleMainTemp.getOrderId()));
					if (orderValue.getState().equals("1")
							|| StringUtil.isBlank(saleMainValue
									.getSaleMainCode())) {
						String newMainCode = getACTCode(saleMainTemp);
						saleMainValue.setSaleMainCode(newMainCode);
						updateLevCode(saleMainValue);
					}
				}
				saleMainValue.setModifyTime(BOSaleMainEngine.getSysDate());
			}

			BOSaleMainEngine.save(saleMainValue);
			return saleMainValue.getId();
		}
		return null;
	}

	/**
	 * 查询参数拼装
	 * 
	 * @param name
	 * @param applicant
	 * @param org
	 * @return Object[] Object[0] String 查询条件; Object[1] Map 查询参数
	 */
	private Object[] getCondition(String name, String applicant, String org) {
		Map parameter = new HashMap();
		StringBuffer condition = new StringBuffer(" 1 = 1 ");
		if (name != null && !name.equals("")) {
			condition.append(" AND " + IBOSaleMainValue.S_SaleMainName
					+ " like :name");
			parameter.put("name", "%" + name + "%");
		}
		if (applicant != null && !applicant.equals("")) {
			condition.append(" AND " + IBOSaleMainValue.S_Principal
					+ " = :applicant");
			parameter.put("applicant", applicant);
		}
		if (org != null && !org.equals("")) {
			condition.append(" AND " + IBOSaleMainValue.S_PromoteDepart
					+ " = :org");
			parameter.put("org", org);
		}
		return new Object[] { condition.toString(), parameter };
	}

	@Override
	public void cloneSaleMain(String oldMainId, String orderId)
			throws Exception {

		ISaleChannelInfoDAO saleChannelDAO = ((ISaleChannelInfoDAO) ServiceFactory
				.getService(ISaleChannelInfoDAO.class));

		IBOSaleMainValue saleMainValue = getSaleMainById(oldMainId);
		String newMainId = BOSaleMainEngine.getNewId().toString();
		saleChannelDAO.cloneChannelInfoByRelaId("act", saleMainValue.getId(),
				newMainId);
		saleMainValue.setId(newMainId);
		saleMainValue.setDetailInfo(oldMainId);
		saleMainValue.setSaleMainName(saleMainValue.getSaleMainName());
		saleMainValue.setIsSubmit("1");
		saleMainValue.setCreateTime(BOSaleMainEngine.getSysDate());
		saleMainValue.setSaleMainCode(null);
		saleMainValue.setSaleMainCode(getACTCode(saleMainValue));
		saleMainValue.setPromoteManager(null);
		saleMainValue.setOrderId(orderId);
		saleMainValue.setStsToNew();
		BOSaleMainEngine.save(saleMainValue);
		// String mainIdString = saleMainValue.getId();

		ISaleDetailDAO saleDetailDAO = ((ISaleDetailDAO) ServiceFactory
				.getService(ISaleDetailDAO.class));
		IBOSaleDetailValue[] saleDetailValues = saleDetailDAO
				.getSaleDetailByMainId(oldMainId, -1, -1);
		for (int i = 0; i < saleDetailValues.length; ++i) {
			String newId = BOSaleDetailEngine.getNewId().toString();
			saleChannelDAO.cloneChannelInfoByRelaId("lev", saleDetailValues[i]
					.getId(), newId);
			saleDetailValues[i].setId(newId);
			saleDetailValues[i].setSaleId(newMainId);
			saleDetailValues[i].setCreateTime(BOSaleDetailEngine.getSysDate());
			// saleDetailValues[i].setSaleActiveCode(iSaleDetailDAO
			// .getSaleDetailCode(saleDetailValues[i]));
			saleDetailValues[i].setLevelCode(null);
			saleDetailValues[i].setStsToNew();
		}
		// copy eit_apprise
		saleDetailDAO.saveSaleDetail(saleDetailValues);
		ISaleEitAppriseDAO saleEitAppriseDAO = ((ISaleEitAppriseDAO) ServiceFactory
				.getService(ISaleEitAppriseDAO.class));
		saleEitAppriseDAO.cloneEitAppriseByMainId(oldMainId, newMainId);
	}

	@Override
	public void changeStsToAgreen(String mainId) throws Exception,
			RuntimeException {

		changeStsTo(mainId, "3");
	}

	@Override
	public void changeStsToNo(String mainId) throws Exception, RuntimeException {

		changeStsTo(mainId, "4");
	}

	@Override
	public void deleteSaleMainByMainId(String mainId) throws Exception {

		IBOSaleMainValue saleMain = getSaleMainById(mainId);
		if (null != saleMain) {

			// 刪除主表信息
			saleMain.delete();
			BOSaleMainEngine.save(saleMain);
			// 刪除档次信息
			ISaleDetailDAO saleDetailDao = (ISaleDetailDAO) ServiceFactory
					.getService(ISaleDetailDAO.class);
			saleDetailDao.deleteSaleDetailByMainId(mainId);
		}
	}

	@Override
	public void changeStsTo(String mainId, String state) throws Exception,
			RuntimeException {

		IBOSaleMainValue iboSaleMainValue = getSaleMainById(mainId);
		iboSaleMainValue.setIsSubmit(state);
		saveSaleMain(iboSaleMainValue);
	}

	private String getACTCode(IBOSaleMainValue saleMain) throws Exception,
			RuntimeException {

		String exeArea = saleMain.getExearea();
		String marketStr = saleMain.getMarktype();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
		String actBeginTime = dateFormat.format(saleMain.getBeginTime());
		String serialNo = actBeginTime + "0001";
		String marketCode = getMarketCode(marketStr);

		if (saleMain.getSaleMainCode() != null
				&& saleMain.getSaleMainCode().equals("0000")) {
			return "0000";
		}

		if (saleMain.getSaleMainCode() != null
				&& !saleMain.getSaleMainCode().equals("")
				&& actBeginTime.equals(saleMain.getSaleMainCode().substring(10,
						16))) {
			serialNo = saleMain.getSaleMainCode().substring(10);
			return "ACT" + exeArea + marketCode
					+ saleMain.getSaleMainCode().substring(8, 10) + serialNo;
		} else {

			try {
				Connection conn = ServiceManager.getSession().getConnection();
				/*
				 * String sql =
				 * "SELECT MAX(SERIALNO) serialno FROM (SELECT SUBSTR(SALE_MAIN_CODE,11,10) AS SERIALNO "
				 * +
				 * " FROM HBSALE.SALE_MAIN_T WHERE SUBSTR(SALE_MAIN_CODE,1,3) = 'ACT' AND SUBSTR(SALE_MAIN_CODE,11,6)='"
				 * + actBeginTime +
				 * "' UNION (SELECT SUBSTR(PROMOTE_MANAGER,11,10) AS SERIALNO FROM HBSALE.SALE_MAIN_T WHERE SUBSTR(PROMOTE_MANAGER,1,3) = 'ACT' "
				 * + " AND SUBSTR(PROMOTE_MANAGER,11,6)='" + actBeginTime +
				 * "'))";
				 */
				String sql = "select MAX(substr(SALE_MAIN_CODE,11,10)) as serialno from SALE_MAIN_T where substr(sale_main_code,1,3) = 'ACT' and substr(sale_main_code,11,6)="
						+ "'" + actBeginTime + "'";
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				if (rs.next()) {
					String serialNoTmp = rs.getString("serialno");
					if (null != serialNoTmp && !"".equals(serialNoTmp)) {
						serialNo = (Integer.parseInt(serialNoTmp) + 1) + "";
					}
				}
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "ACT" + exeArea + marketCode + "99" + serialNo;
	}

	@Deprecated
	public String getNewACTCode(IBOSaleMainValue saleMain) throws Exception,
			RuntimeException {

		if (saleMain.getSaleMainCode().equals("0000")) {
			return "0000";
		} else {

			String mainId = saleMain.getId();
			String actType = "";
			try {
				Connection conn = ServiceManager.getSession().getConnection();
				String sql = "select min(substr(sale_active_code,9,2)) actType from SALE_DETAIL_T where substr(sale_active_code,1,3)='LEV' AND sale_id = "
						+ "'" + mainId + "'";
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				if (rs.next()) {
					actType = rs.getString("actType");
					if (null == actType || "".equals(actType)) {
						actType = "99";
					}
				}
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return saleMain.getSaleMainCode().substring(0, 8) + actType
					+ saleMain.getSaleMainCode().substring(10);
		}
	}

	private void updateLevCode(IBOSaleMainValue saleMainValue) throws Exception {

		if (saleMainValue.getSaleMainCode().equals("0000")) {
			return;
		}
		ISaleDetailDAO saleDetailDAO = ((ISaleDetailDAO) ServiceFactory
				.getService(ISaleDetailDAO.class));
		IBOSaleDetailValue[] saleDetailValues = saleDetailDAO
				.getSaleDetailByMainId(saleMainValue.getId(), 1, 100);
		if (saleDetailValues != null && saleDetailValues.length > 0) {
			String saleMainCode = saleMainValue.getSaleMainCode();
			for (int i = 0; i < saleDetailValues.length; ++i) {
				String saleDetailCode = saleDetailValues[i].getSaleActiveCode();
				saleDetailCode = "LEV" + saleMainCode.substring(3, 6)
						+ saleDetailCode.substring(6, 10)
						+ saleMainCode.substring(10)
						+ saleDetailCode.substring(20);
				saleDetailValues[i].setSaleActiveCode(saleDetailCode);
			}
			BOSaleDetailEngine.save(saleDetailValues);
		}
	}

	private String getMarketCode(String marketStr) {

		String[] regMarket = { "所有", "大众", "家庭", "流动", "农村", "校园", "集团", "中高端" };
		for (int i = 0; i < 8; ++i) {
			Pattern pattern = Pattern.compile(regMarket[i]);
			Matcher matcher = pattern.matcher(marketStr);
			if (matcher.find())
				return "0" + i;
		}
		return "99";
	}

	@Override
	public boolean IsHasSameBossId(String actBossid, String orderId)
			throws Exception {

		String condition = " " + IBOSaleMainValue.S_PromoteManager + " in ("
				+ actBossid + ")" + " and order_id <>" + orderId;
		return BOSaleMainEngine.getBeansCount(condition, null) > 0;
	}

	@Override
	public boolean hasEmptyExplantStatistic(String orderId) throws Exception {

		String condition = " " + IBOSaleMainValue.S_OrderId + " = '" + orderId
				+ "' and (BUSINESSCHECKPLAN is null or BUSINESSCHECKPLAN ='')";
		return BOSaleMainEngine.getBeansCount(condition, null) > 0;
	}

	@Override
	public boolean hasEitAppriseToWrite(String orderId) throws Exception {

		String condition = "SELECT * FROM SALE_WEAPON_T WHERE id IN "
				+ "(SELECT weapon_id FROM SALE_DETAIL_T WHERE sale_id IN "
				+ "(SELECT id FROM hbsale.sale_main_t WHERE order_id = '"
				+ orderId
				+ "' AND id NOT IN (SELECT mid FROM hbsale.SALE_EIT_APPRISE_T))) AND "
				+ "(SALE_FLAG = '12' OR (present_busi2_amount IS NOT NULL AND present_busi2_amount <> 0))";
		return BOSaleMainEngine.getBeansFromSql(condition, null).length > 0;
	}

	@Override
	public boolean hasEitInSale(String orderId) throws Exception {

		String condition = "SELECT * FROM SALE_WEAPON_T WHERE id IN "
				+ "(SELECT weapon_id FROM SALE_DETAIL_T WHERE sale_id IN "
				+ "(SELECT id FROM hbsale.sale_main_t WHERE order_id = '"
				+ orderId
				+ "' and (SALE_FLAG = '12' OR (present_busi2_amount IS NOT NULL AND present_busi2_amount <> 0))))";
		return BOSaleMainEngine.getBeansFromSql(condition, null).length > 0;
	}

	@Override
	public String checksalemaintype(String orderId) throws Exception {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		Boolean havertPerson=false;
		String saleMainType="";
		String sql ="select distinct(SALE_MAIN_TYPE) from HBSALE.SALE_MAIN_T where ORDER_ID=" +orderId;
		try{
		conn = ConnectUtil.getConnection();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		if(rs.next()){
			if(rs.getString("SALE_MAIN_TYPE").equals("rtPerson")){
				havertPerson=true;
			}
		}
		if(havertPerson){
			saleMainType="rtPerson";
		}else{
			saleMainType="rtGroup";
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return saleMainType;
	
	}
}
