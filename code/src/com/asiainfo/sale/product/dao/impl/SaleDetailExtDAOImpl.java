package com.asiainfo.sale.product.dao.impl;

import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.ai.appframe2.common.ServiceManager;
import com.asiainfo.common.dao.impl.CommonProductExtDAOImpl;
import com.asiainfo.sale.product.bo.BOSaleDetailExtBean;
import com.asiainfo.sale.product.bo.BOSaleDetailExtEngine;
import com.asiainfo.sale.product.bo.BOSaleDetailExtQEngine;
import com.asiainfo.sale.product.dao.interfaces.ISaleDetailExtDAO;
import com.asiainfo.sale.product.ivalues.IBOSaleDetailExtQValue;
import com.asiainfo.sale.product.ivalues.IBOSaleDetailExtValue;

public class SaleDetailExtDAOImpl extends CommonProductExtDAOImpl implements
		ISaleDetailExtDAO {

	@Override
	public IBOSaleDetailExtQValue[] qrySaleDetailExt(String mainId,String detail_id,
			String saleFlag, String active_name, String market,
			String start_date, String end_date, String status,String condStr, int startIndex,
			int endIndex) throws Exception {
		Object[] objArray = getSaleDetailSqlStr(mainId, detail_id,saleFlag, active_name,
				market, start_date, end_date,status ,condStr);
		String sqls = null;
		Map params = null;
		if (objArray != null) {
			for (int i = 0; i < objArray.length; i++) {
				if (i == 0) {
					sqls = (String) objArray[i];
				} else if (i == 1) {
					params = (Map) objArray[i];
				} else {
					break;
				}
			}

		}
		return BOSaleDetailExtQEngine.getBeans(null, sqls, params, startIndex,
				endIndex, false);
	}

	@Override
	public int qrySaleDetailExtCount(String mainId, String detail_id,String saleFlag,
			String active_name, String market, String start_date,
			String end_date, String status,String condStr) throws Exception {

		Object[] objArray = getSaleDetailSqlStr(mainId,detail_id, saleFlag, active_name,
				market, start_date, end_date,status, condStr);
		String sqls = null;
		Map params = null;
		if (objArray != null) {
			for (int i = 0; i < objArray.length; i++) {
				if (i == 0) {
					sqls = (String) objArray[i];
				} else if (i == 1) {
					params = (Map) objArray[i];
				} else {
					break;
				}
			}

		}
		return BOSaleDetailExtQEngine.getBeansCount(sqls, params);
	}

	/**
	 * 拼接查询条件
	 * 
	 * @param mainId
	 * @param saleFlag
	 * @param active_name
	 * @param market
	 * @param start_date
	 * @param end_date
	 * @param status
	 * @param condStr
	 * @return
	 * @throws Exception
	 */
	public Object[] getSaleDetailSqlStr(String mainId, String detail_id,String saleFlag,
			String active_name, String market, String start_date,
			String end_date,String status,String condStr) throws Exception {
		Map paramMap = new HashMap();

		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("1=1");

		if (!StringUtils.isBlank(mainId)) {
			sqlStr.append(" and ").append(IBOSaleDetailExtQValue.S_SaleId)
					.append("=:mainId");
			paramMap.put("mainId", mainId);
		}
		if(StringUtils.isNotBlank(detail_id)){
			
			sqlStr.append(" and ").append(IBOSaleDetailExtQValue.S_FDetailId).append("=:detail_id");
			paramMap.put("detail_id",detail_id);
		}
		if (!StringUtils.isBlank(saleFlag)) {
			sqlStr.append(" and ").append(IBOSaleDetailExtQValue.S_SaleFlag)
					.append("=:saleFlag");
			paramMap.put("saleFlag", saleFlag);
		}

		if (!StringUtils.isBlank(active_name)) {
			active_name = URLDecoder.decode(active_name, "utf-8");
			sqlStr.append(" and ").append(
					IBOSaleDetailExtQValue.S_SaleActiveName).append(
					" like '%" + active_name + "%'");
		}

		if (!StringUtils.isBlank(market)) {
			sqlStr.append(" and ").append(IBOSaleDetailExtQValue.S_Market)
					.append("=:market");
			paramMap.put("market", market);
		}
		if (!StringUtils.isBlank(start_date)) {
			// start_date = URLDecoder.decode(start_date, "utf-8");
			sqlStr.append(" and ").append(IBOSaleDetailExtQValue.S_CreateTime)
					.append(" >=:start_date ");
			paramMap.put("start_date", start_date);
		}
		if (!StringUtils.isBlank(end_date)) {
			// end_date = URLDecoder.decode(end_date, "utf-8");
			sqlStr.append(" and ").append(IBOSaleDetailExtQValue.S_CreateTime)
					.append(" <=:end_date");
			paramMap.put("end_date", end_date);

		}
		if(StringUtils.isNotBlank(status)){
			sqlStr.append(" and ").append(IBOSaleDetailExtQValue.S_Status).append("=:status");
			paramMap.put("status", status);
		}
		else {
			sqlStr.append(" and (status is null or status='1')");
		}
		if (!StringUtils.isBlank(condStr)) {
			sqlStr.append(" and ").append(condStr);
		}
		

		Object[] objs = new Object[2];
		objs[0] = sqlStr.toString();
		objs[1] = paramMap;
		return objs;

	}

	@Override
	public void saveInitialValues(String extType, String staffId)
			throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		StringBuffer executeSql = new StringBuffer();
		executeSql
				.append("insert into hbsale.SALE_DETAIL_EXT(E_ID,create_date,status,STAFF_ID,F_DETAIL_ID ,BOSS_ID) select nextval for hbsale.sale_detail_ext_seq,current date," +
						"'1','"+staffId+"',ID,"
						+ "LEVEL_CODE  from "
						+ " hbsale.sale_detail_t a left outer join hbsale.sale_detail_ext b on a.id = b.f_detail_id "
						+" where b.f_detail_id is null");
		try {
			System.out.println(executeSql.toString());
			conn = ServiceManager.getSession().getConnection();
			ps = conn.prepareStatement(executeSql.toString());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}

		}

	}

	@Override
	public IBOSaleDetailExtValue getDataValue(String e_id) throws Exception {
		
		return BOSaleDetailExtEngine.getBean(Long.parseLong(e_id));
	}

	@Override
	public void saveSaleDetailExtValue(IBOSaleDetailExtValue[] saleDetailExtBeans)
			throws Exception {
		if(null!=saleDetailExtBeans && saleDetailExtBeans.length > 0){
			BOSaleDetailExtEngine.save(saleDetailExtBeans);
		}
	}

	@Override
	public long getNewId() throws Exception {
		return BOSaleDetailExtEngine.getNewId().longValue();
	}

	@Override
	public IBOSaleDetailExtValue[] getSaleDetailExt(String detail_id, String status) throws Exception {
		StringBuffer sql = new StringBuffer();
		Map map = new HashMap();
		if(StringUtils.isNotBlank(detail_id)){
			if(StringUtils.isNotBlank(sql.toString())){
				sql.append(" and ");
			}
			sql.append(IBOSaleDetailExtValue.S_FDetailId).append("=:detail_id");
			map.put("detail_id", detail_id);
		}
		if(StringUtils.isNotBlank(status)){
			if(StringUtils.isNotBlank(sql.toString())){
				sql.append(" and ");
			}
			sql.append(IBOSaleDetailExtValue.S_Status).append("=:status");
			map.put("status", status);
		}
		else {
			if(!StringUtils.isNotBlank(sql.toString())){
				return null;
			}else {
				sql.append(" and (status is null or status = '1' )");
			}
		}
		
		return BOSaleDetailExtEngine.getBeans(sql.toString(),map);
	}
	
	
	
	
	
	

}
