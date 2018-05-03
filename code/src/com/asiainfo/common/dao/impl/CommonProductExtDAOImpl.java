package com.asiainfo.common.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.asiainfo.charge.bo.BOProductExtDescEngine;
import com.asiainfo.charge.ivalues.IBOProductExtDescValue;
import com.asiainfo.common.dao.interfaces.ICommonProductExtDAO;

public class CommonProductExtDAOImpl implements ICommonProductExtDAO {

	@Override
	public IBOProductExtDescValue getExtCodeValue(String extType)
			throws Exception {
		StringBuffer sqlStr = new StringBuffer();
		if(StringUtils.isBlank(extType)){
			return null;
		}
		sqlStr
				.append("select *  from hbsale.product_ext_desc where ext_code like 'EXT%' and state = '0' and ext_type='"
						+ extType + "'order by ext_code asc");
		IBOProductExtDescValue[] values = BOProductExtDescEngine
				.getBeansFromSql(sqlStr.toString(), null);
		if (values.length > 0) {
			return values[0];
		} else {
			return null;
		}
	}


	@Override
	public int getTypeNum(String extType) throws Exception {
		
		StringBuffer sqlStr = new StringBuffer();
		if(StringUtils.isNotBlank(extType)){
			sqlStr.append(IBOProductExtDescValue.S_IsCanModify).append("='1'");
			sqlStr.append(" and ").append(IBOProductExtDescValue.S_ExtType).append("='"+extType+"'");
		}
		
		return BOProductExtDescEngine.getBeansCount(sqlStr.toString(), null);
		
		
	}

	@Override
	public void saveAttr(IBOProductExtDescValue[] values) throws Exception {
		BOProductExtDescEngine.save(values);

	}

	@Override
	public IBOProductExtDescValue[] getAttr(String codeStr, String extType,
			String staffId) throws Exception {
		StringBuffer cond = new StringBuffer();

		if (null != codeStr && !"".equals(codeStr)) {
			if (cond.toString().length() > 0) {
				cond.append(" and ");
			}
			cond.append(IBOProductExtDescValue.S_ExtCode).append("  in (")
					.append(codeStr).append(")");

		}
		if (null != extType && !"".equals(extType)) {
			if (cond.toString().length() > 0) {
				cond.append(" and ");
			}
			cond.append(IBOProductExtDescValue.S_ExtType).append(
					"='" + extType + "'");

		}

		if (null != staffId && !"".equals(staffId)) {
			if (cond.toString().length() > 0) {
				cond.append(" and ");
			}
			cond.append(IBOProductExtDescValue.S_StaffId).append(
					"='" + staffId + "'");

		}
		if ("".equals(cond.toString())) {
			return null;
		}
		IBOProductExtDescValue[] values = BOProductExtDescEngine.getBeans(cond
				.toString(), null);
		return values;
	}


	@Override
	public int getMaxExt(String extType) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		Map map = new HashMap();
		if(StringUtils.isNotBlank(extType)){
			sql.append(IBOProductExtDescValue.S_ExtType).append("=:extType");
			map.put("extType", extType);
		}
		else {
			return 0;
		}
		sql.append(" and ").append(IBOProductExtDescValue.S_ExtCode).append(" like '%EXT%'")
		.append(" and (is_can_modify is null or is_can_modify <>'1')");
		return BOProductExtDescEngine.getBeansCount(sql.toString(), map);
	
	}


	@Override
	public IBOProductExtDescValue[] getColsName(String extName, String type,
			String state, String is_can_modify, int startIndex, int endIndex)
			throws Exception {
		String sqlStr = getColsSql(extName, type, state, is_can_modify);
		sqlStr += " order by create_date asc,ext_type asc,is_can_modify asc ";
		return BOProductExtDescEngine.getBeans(null, sqlStr, null, startIndex,
				endIndex, false);
	}
	
	public String getColsSql(String extName, String type, String state,
			String is_can_modify) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("1=1");
		if (null != state && !state.equals("")) {
			sql.append(" and ").append(IBOProductExtDescValue.S_State).append(
					"='" + state + "'");
		}
		if (null != is_can_modify && !("").equals(is_can_modify)) {
			sql.append(" and ").append(IBOProductExtDescValue.S_IsCanModify).append("=")
					.append("'" + is_can_modify + "'");
		}

		if (null != type && !"".equals(type)) {
			sql.append(" and (").append(IBOProductExtDescValue.S_ExtType)
					.append("='" + type).append("'");
			sql.append(" or ").append(IBOProductExtDescValue.S_ExtType).append(
					"='0')"); // 全部类型
		}
		if (null != extName && !"".equals(extName)) {
			sql.append(" and ").append(IBOProductExtDescValue.S_ExtName)
					.append(" like '%" + extName + "%' ");
		}

		return sql.toString();
	}


	@Override
	public int getColsNameCount(String extName, String type, String state,
			String is_can_modify) throws Exception {
		String sqlStr = getColsSql(extName, type, state, is_can_modify);
		System.out.println(sqlStr);
		return BOProductExtDescEngine.getBeansCount(sqlStr, null);
	}
	
	

}
