package com.asiainfo.sale.activity.dao.impl;

import java.math.BigDecimal;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.asiainfo.costWarn.job.ConnectUtil;
import com.asiainfo.sale.access.bo.BOBusiChangeEngine;
import com.asiainfo.sale.access.ivalues.IBOBusiChangeValue;
import com.asiainfo.sale.activity.bo.BOResourceChangeEngine;
import com.asiainfo.sale.activity.dao.interfaces.IResourceChangeDAO;
import com.asiainfo.sale.activity.ivalues.IBOResourceChangeValue;

public class ResourceChangeDAOImpl implements IResourceChangeDAO{

	@Override
	public IBOResourceChangeValue getResourceChange(String resourceId)
			throws Exception {
		return BOResourceChangeEngine.getBean(Integer.parseInt(resourceId));
	}

	@Override
	public int saveResourceChange(IBOResourceChangeValue resourceChangeValue)
			throws Exception {
		int resourceId =resourceChangeValue.getResourceId();
		if(resourceChangeValue!=null){
			if(resourceChangeValue.isNew()){
				resourceId=BOResourceChangeEngine.getNewId().intValue();
				resourceChangeValue.setResourceId(resourceId);
				resourceChangeValue.setState("1");
				resourceChangeValue.setStsToNew();
			}
			BOResourceChangeEngine.save(resourceChangeValue);
		}
		return resourceId;
	}

	@Override
	public int queryResourceChangeCount(String resourceId, String applyName,
			String principle, String cityId, String state, String beginTime,
			String endTime) throws Exception {
		Map<String, String> paras = new HashMap<String, String>();
		if (resourceId != null && !resourceId.equals("")) {
			paras.put("like", IBOResourceChangeValue.S_ResourceId + ";"
					+ StringUtils.trimToEmpty(resourceId));
		}
		if (applyName != null && !applyName.equals("")) {
			paras.put("like", IBOResourceChangeValue.S_ApplyName
					+ ";"
					+ StringUtils.trimToEmpty(URLDecoder.decode(applyName,
							"utf-8")));
		}
		if (state != null && !state.equals("") && !state.equals("0")) {
			paras.put(IBOResourceChangeValue.S_State, StringUtils
					.trimToEmpty(state));
		}
		if (cityId != null && !cityId.equals("") && !cityId.equals("0")) {
			paras.put("substr(ORG,1,2)", StringUtils.trimToEmpty(cityId));
		}
		paras.put(IBOResourceChangeValue.S_Principle, StringUtils
				.trimToEmpty(principle));
		paras.put("between", StringUtils.trimToEmpty(beginTime) + ";prop_time;"
				+ StringUtils.trimToEmpty(endTime));
		return BOResourceChangeEngine.getBeansCount(getCondition(paras), null);
	}

	@Override
	public IBOResourceChangeValue[] queryResourceChangeValue(String resourceId,
			String applyName, String principle, String cityId, String state,
			String beginTime, String endTime, int startNum, int endNum)
			throws Exception {
		Map<String, String> paras = new HashMap<String, String>();
		if (resourceId != null && !resourceId.equals("")) {
			paras.put(IBOResourceChangeValue.S_ResourceId,StringUtils
					.trimToEmpty(resourceId));
		}
		if (applyName != null && !applyName.equals("")) {
			paras.put("like", IBOResourceChangeValue.S_ApplyName
					+ ";"
					+ StringUtils.trimToEmpty(URLDecoder.decode(applyName,
							"utf-8")));
		}
		if (state != null && !state.equals("") && !state.equals("0")) {
			paras.put(IBOResourceChangeValue.S_State, StringUtils
					.trimToEmpty(state));
		}
		if (cityId != null && !cityId.equals("") && !cityId.equals("0")) {
			paras.put("substr(ORG,1,2)", StringUtils.trimToEmpty(cityId));
		}
		paras.put(IBOResourceChangeValue.S_Principle, StringUtils
				.trimToEmpty(principle));
		paras.put("between", StringUtils.trimToEmpty(beginTime) + ";prop_time;"
				+ StringUtils.trimToEmpty(endTime));
		return BOResourceChangeEngine.getBeans(null, getCondition(paras)
				+ " order by prop_time desc", null, startNum, endNum, false);
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
	public void changeStateTo(String resourceId, String state) throws Exception {
		if(state=="3"){
		java.math.BigDecimal C_TERM=null;
		java.math.BigDecimal C_DISC=null;
		java.math.BigDecimal C_POINTS=null;
		java.math.BigDecimal C_PROMT=null;
		String ORG=null;
		try {
			Connection conn=ConnectUtil.getConnection();
			Statement stm=conn.createStatement();
			String sql1="SELECT C_TERM,C_DISC,C_POINTS,C_PROMT,SUBSTR(ORG, 1, 2) ORG FROM" +
					" RESOURCE_CHANGE_DETAIL_T A LEFT JOIN"+
			        " RESOURCE_CHANGE_T B ON A.RESOURCE_ID = B.RESOURCE_ID WHERE B.RESOURCE_ID="+resourceId;
			ResultSet rs=stm.executeQuery(sql1);
			while(rs.next()){
				C_TERM=rs.getBigDecimal(1);
			    C_DISC=rs.getBigDecimal(2);
				C_POINTS=rs.getBigDecimal(3);
				C_PROMT=rs.getBigDecimal(4);
				ORG=rs.getString(5);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(C_TERM+"---"+C_DISC+"---"+C_POINTS+"---"+C_PROMT);
		
		try {
			Connection conn=ConnectUtil.getConnection();
			String sql2="UPDATE HBSALE.RESOURCE_ALLOT SET " +
			"P_TERM=P_TERM+?,P_DISC=P_DISC+?,P_POINTS=P_POINTS+?,P_PROMT=P_PROMT+?," +
			"L_TERM=L_TERM-?,L_DISC=L_DISC-?,L_POINTS=L_POINTS-?,L_PROMT=L_PROMT-? " +
			"WHERE CITY_ID=?";
			PreparedStatement ps=conn.prepareStatement(sql2);
			ps.setBigDecimal(1, getPresultValue(C_TERM));
			ps.setBigDecimal(2, getPresultValue(C_DISC));
			ps.setBigDecimal(3, getPresultValue(C_POINTS));
			ps.setBigDecimal(4, getPresultValue(C_PROMT));
			ps.setBigDecimal(5, getPresultValue(C_TERM));
			ps.setBigDecimal(6, getPresultValue(C_DISC));
			ps.setBigDecimal(7, getPresultValue(C_POINTS));
			ps.setBigDecimal(8, getPresultValue(C_PROMT));
			ps.setString(9, ORG);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		IBOResourceChangeValue resourceChangeValue = BOResourceChangeEngine.getBean(Integer
				.parseInt(resourceId));
		if (resourceChangeValue != null) {
			resourceChangeValue.setState(state);
			BOResourceChangeEngine.save(resourceChangeValue);
		}		
	}
	
	   public static java.math.BigDecimal getPresultValue(java.math.BigDecimal C_value){
		   if(C_value!=null){
			   return C_value;
		   }else{
			   return new BigDecimal(0);
		   }
	   }
	
	
	
}
