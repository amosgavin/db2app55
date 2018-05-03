package com.asiainfo.sale.access.dao.impl;

import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.asiainfo.costWarn.job.ConnectUtil;

import com.asiainfo.sale.access.bo.BOBusiChangeDetailEngine;
import com.asiainfo.sale.access.bo.BOBusiChangeEngine;
import com.asiainfo.sale.access.dao.interfaces.IBusiChangeDAO;
import com.asiainfo.sale.access.ivalues.IBOBusiChangeValue;

public class BusiChangeDAOImpl implements IBusiChangeDAO {

	@Override
	public IBOBusiChangeValue getBusiChargeById(String busiId) throws Exception {

		return BOBusiChangeEngine.getBean(Integer.parseInt(busiId));
	}

	@Override
	public IBOBusiChangeValue[] queryBusiChangeValue(String busiId,
			String applyName, String principle, String cityId, String state,
			String beginTime, String endTime, int startNum, int endNum)
			throws Exception {

		Map<String, String> paras = new HashMap<String, String>();
		if (busiId != null && !busiId.equals("")) {
			paras.put("like", IBOBusiChangeValue.S_BusiId + ";"
					+ StringUtils.trimToEmpty(busiId));
		}
		if (applyName != null && !applyName.equals("")) {
			paras.put("like", IBOBusiChangeValue.S_ApplyName
					+ ";"
					+ StringUtils.trimToEmpty(URLDecoder.decode(applyName,
							"utf-8")));
		}
		if (state != null && !state.equals("") && !state.equals("0")) {
			paras.put(IBOBusiChangeValue.S_State, StringUtils
					.trimToEmpty(state));
		}
		if (cityId != null && !cityId.equals("") && !cityId.equals("0")) {
			paras.put("substr(ORG,1,2)", StringUtils.trimToEmpty(cityId));
		}
		paras.put(IBOBusiChangeValue.S_Principle, StringUtils
				.trimToEmpty(principle));
		paras.put("between", StringUtils.trimToEmpty(beginTime) + ";prop_time;"
				+ StringUtils.trimToEmpty(endTime));
		return BOBusiChangeEngine.getBeans(null, getCondition(paras)
				+ " order by prop_time desc", null, startNum, endNum, false);
	}

	@Override
	public int queryBusiChangeCount(String busiId, String applyName,
			String principle, String cityId, String state, String beginTime,
			String endTime) throws Exception {

		Map<String, String> paras = new HashMap<String, String>();
		if (busiId != null && !busiId.equals("")) {
			paras.put("like", IBOBusiChangeValue.S_BusiId + ";"
					+ StringUtils.trimToEmpty(busiId));
		}
		if (applyName != null && !applyName.equals("")) {
			paras.put("like", IBOBusiChangeValue.S_ApplyName
					+ ";"
					+ StringUtils.trimToEmpty(URLDecoder.decode(applyName,
							"utf-8")));
		}
		if (state != null && !state.equals("") && !state.equals("0")) {
			paras.put(IBOBusiChangeValue.S_State, StringUtils
					.trimToEmpty(state));
		}
		if (cityId != null && !cityId.equals("") && !cityId.equals("0")) {
			paras.put("substr(ORG,1,2)", StringUtils.trimToEmpty(cityId));
		}
		paras.put(IBOBusiChangeValue.S_Principle, StringUtils
				.trimToEmpty(principle));
		paras.put("between", StringUtils.trimToEmpty(beginTime) + ";prop_time;"
				+ StringUtils.trimToEmpty(endTime));
		return BOBusiChangeEngine.getBeansCount(getCondition(paras), null);
	}

	@Override
	public int saveBusiChange(IBOBusiChangeValue busiChangeValue)
			throws Exception {

		int busiId = busiChangeValue.getBusiId();
		if (busiChangeValue != null) {
			if (busiChangeValue.isNew()) {
				busiId = BOBusiChangeEngine.getNewId().intValue();
				busiChangeValue.setBusiId(busiId);
				busiChangeValue.setState("1");
				busiChangeValue.setStsToNew();
			}
			BOBusiChangeEngine.save(busiChangeValue);
		}
		return busiId;
	}

	String getCondition(Map<String, String> paras) {

		String condition = " 1=1 and is_delete is null";
		if (paras != null) {

			for (Entry<String, String> para : paras.entrySet()) {
				if (para.getKey().trim().equals("like")) {
					condition += " and " + para.getValue().split(";")[0].trim()
							+ " like '%" + para.getValue().split(";")[1].trim()
							+ "%'";
				} else if (para.getKey().trim().equals("between")) {
					String[] cond = para.getValue().split(";");
					if (cond.length >= 2 && !cond[0].trim().equals("")) {
						condition += " and " + cond[1] + " >= '" + cond[0]
								+ "'";
					}
					if (cond.length >= 3 && !cond[2].trim().equals("")) {
						condition += " and " + cond[1] + " <= '" + cond[2]
								+ "'";
					}
				} else if (!para.getKey().trim().equals("")
						&& !para.getValue().trim().equals("")) {
					if (para.getKey().trim().equals("substr(ORG,1,2)")
							&& para.getValue().trim().equals("18")) {
						condition += " and substr(ORG,1,2) in (18,27,28)";
					} else {
						condition += " and " + para.getKey().trim() + " = "
								+ para.getValue().trim();
					}
				}
			}
		}
		return condition;
	}

	@Override
	public void saveBusiChangeBatch(IBOBusiChangeValue[] busiChangeValues)
			throws Exception {

		if (busiChangeValues != null && busiChangeValues.length > 0) {
			for (int i = 0; i < busiChangeValues.length; ++i) {
				if (busiChangeValues[i].isNew()) {
					busiChangeValues[i].setBusiId(BOBusiChangeEngine.getNewId()
							.intValue());
					busiChangeValues[i].setStsToNew();
				}
			}
			BOBusiChangeEngine.save(busiChangeValues);
		}
	}

	@Override
	public void changeStateTo(String busiId, String state) throws Exception {

		IBOBusiChangeValue busiChangeValue = BOBusiChangeEngine.getBean(Integer
				.parseInt(busiId));
		if (busiChangeValue != null) {

			busiChangeValue.setState(state);
			BOBusiChangeEngine.save(busiChangeValue);
		}
	}

	@Override
	public boolean isHasTicketChange(String busiId) throws Exception {
		String condition = " BUSI_ID= " + busiId + " and HAS_TICKET = 'true'";
		return BOBusiChangeDetailEngine.getBeansCount(condition, null) > 0;
	}

	@Override
	public String checkdq_kf(String busiId) throws Exception {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		Boolean havedq=false;
		String DQKF="";
		String sql ="select distinct(dq_kf) from HBSALE.BUSI_CHANGE_DETAIL_T where busi_id=" +busiId;
		try{
		conn = ConnectUtil.getConnection();
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		while(rs.next()){
			if(rs.getString("DQ_KF").equals("dq")){
				havedq=true;
			}
		}
		if(havedq){
			DQKF="dq";
		}else{
			DQKF="kf";
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
		return DQKF;
	}
}
