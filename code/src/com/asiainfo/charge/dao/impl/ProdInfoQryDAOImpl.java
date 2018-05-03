package com.asiainfo.charge.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.ServiceManager;
import com.asiainfo.charge.bo.BOGprsFluxParamEngine;
import com.asiainfo.charge.bo.BOGprsProductInfoEngine;
import com.asiainfo.charge.bo.BOProductExtDescEngine;
import com.asiainfo.charge.bo.BOProductExtEngine;
import com.asiainfo.charge.bo.BOProductInfoEngine;
import com.asiainfo.charge.dao.interfaces.IProdInfoQryDAO;
import com.asiainfo.charge.ivalues.IBOGprsFluxParamValue;
import com.asiainfo.charge.ivalues.IBOGprsProductInfoValue;
import com.asiainfo.charge.ivalues.IBOPrivAttrUsedParamValue;
import com.asiainfo.charge.ivalues.IBOProductExtDescValue;
import com.asiainfo.charge.ivalues.IBOProductExtValue;
import com.asiainfo.charge.ivalues.IBOProductInfoValue;
import com.asiainfo.common.dao.impl.CommonProductExtDAOImpl;

/**
 * 资费套餐管理 数据访问实现类
 * @author jiangxl
 * 
 */
public class ProdInfoQryDAOImpl  extends CommonProductExtDAOImpl implements IProdInfoQryDAO {

	/**
	 * 查询资费信息
	 */
	public DataContainer[] getBasicProdInfo(String cols, String prodName,
			String type, String attrId, String privId,String condStr,int startIndex,
			int endIndex) throws Exception {
		
		
		String sqlStr = getSqlForBasic(cols, prodName, type, attrId, privId,condStr);
		String limitSql = "";
		DataContainer[] values; 
		if (startIndex == -1 && endIndex == -1) {
			limitSql = sqlStr;
		} else {
			limitSql = getLimitSQL(sqlStr, startIndex, endIndex);
		}
		if(!"GPRS".equals(type)){
			 values = BOProductInfoEngine.getBeansFromSql(
					limitSql, null);
		}
		else{
			 values = BOGprsProductInfoEngine.getBeansFromSql(limitSql, null);
		}
		

		return values;
	}

	protected String getLimitSQL(String sql, int start, int end) {
		if (start == 0) {
			start = 1;
		}
		StringBuffer limitSQL = new StringBuffer(
				"select * from (select t.*,rownumber() over(order by 1) as row_num from (");
		limitSQL.append(sql.trim());
		if (limitSQL.indexOf(" with ur") > 0) {
			limitSQL.delete(limitSQL.indexOf("with ur"), limitSQL.length());
		}
		limitSQL.append(") t) t2 where row_num between ").append(start).append(
				" and ").append(end).append(" with ur");
		// LOG.debug("limitSQL:" + limitSQL);
		return limitSQL.toString();
	}

	public int getCountFromSql(String sql, Map parameter) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		int count = 0;

		try {
			conn = ServiceManager.getSession().getConnection();
			if (null != sql && !"".equals(sql)) {
				sql = "select count(1) as cnt from (" + sql + ") a ";
			} else {
				return count;
			}
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("cnt");
			}

			System.out.println(sql);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return count;

	}

	public int getBasicProdInfoCount(String cols, String prodName, String type,
			String attrId, String privId,String condStr) throws Exception {
		String sql = getSqlForBasic(cols, prodName, type, attrId, privId,condStr);
		return this.getCountFromSql(sql, null);

	}



	public String getSqlForBasic(String cols, String prodName, String type,
			String attrId, String privId,String condStr) {

		StringBuffer sql = new StringBuffer();
		if("GPRS".equals(type)){
			sql
			.append("select ")
			.append(cols)
			.append("  from (")
			.append(
					"select PRIVID, RATEPLANID, STD_FREE1, STD_FREE2, STD_FREE3, "
							+ " HALFFLAG, GETTYPE, STATUS, STATUSDATE, STD_FREE4, "
							+ " GROUPID, PRIVNAME,PKGCODE, ISCALBYDAY"
							+ " from HBSALE.GPRS_FLUX_PARAM) a left outer join hbsale.product_ext b on a.privid = b.e_privid and b.ext_type='"
							+ type + "' and b.state='1' " 
							+ "left join (select case when DOOR_DAMNIFY >0 then '是' when DOOR_DAMNIFY =0 then  '否' else '' end as isbase," 
							+ "PREFERENTIAL_ID1,PREFERENTIAL_ID2,PREFERENTIAL_ID3,PREFERENTIAL_ID4,PREFERENTIAL_ID5 from hbsale.charge_info_t) c  "
							+ "on ((c.PREFERENTIAL_ID1 IS NOT NULL AND a.privid = c.PREFERENTIAL_ID1) " 
							+ "OR (c.PREFERENTIAL_ID2 IS NOT NULL AND a.privid = c.PREFERENTIAL_ID2) " 
							+ "OR (c.PREFERENTIAL_ID3 IS NOT NULL AND a.privid = c.PREFERENTIAL_ID3) " 
							+ "OR (c.PREFERENTIAL_ID4 IS NOT NULL AND a.privid = c.PREFERENTIAL_ID4) " 
							+ "OR (c.PREFERENTIAL_ID5 IS NOT NULL AND a.privid = c.PREFERENTIAL_ID5))");
			sql.append(" where ").append(" 1=1 ");
		}
		else{
			sql
					.append("select ")
					.append(cols)
					.append("  from (")
					.append(
							"select PRIVID, ATTR_ID, ATTR_NAME, PRIV_COST, PRIV_UNIT, PRIV_RATE"
									+ ", PRIV_TYPE, MIN_BILLCYCLE, STATUS, GET_TYPE, "
									+ " PRIVNAME, RATEPLANID, PKGCODE,  ISCALBYDAY, "
									+ " ISCROSSCYCLE"
									+ " from HBSALE.PRIV_ATTR_USED_PARAM) a left outer join hbsale.product_ext b on a.privid = b.e_privid " +
											"and a.attr_id = b.e_attr_id and b.ext_type='"
									+ type + "' and b.state = '1' "
									+ "left join (select case when DOOR_DAMNIFY >0 then '是' when DOOR_DAMNIFY =0 then  '否' else '' end as isbase," 
									+ "PREFERENTIAL_ID1,PREFERENTIAL_ID2,PREFERENTIAL_ID3,PREFERENTIAL_ID4,PREFERENTIAL_ID5 from hbsale.charge_info_t) c  "
									+ "on ((c.PREFERENTIAL_ID1 IS NOT NULL AND a.privid = c.PREFERENTIAL_ID1) " 
									+ "OR (c.PREFERENTIAL_ID2 IS NOT NULL AND a.privid = c.PREFERENTIAL_ID2) " 
									+ "OR (c.PREFERENTIAL_ID3 IS NOT NULL AND a.privid = c.PREFERENTIAL_ID3) " 
									+ "OR (c.PREFERENTIAL_ID4 IS NOT NULL AND a.privid = c.PREFERENTIAL_ID4) " 
									+ "OR (c.PREFERENTIAL_ID5 IS NOT NULL AND a.privid = c.PREFERENTIAL_ID5))");
			sql.append(" where ").append(" 1=1 ");
			if (!isBlank(type)) {
				sql.append(" and ").append(IBOPrivAttrUsedParamValue.S_PrivType)
						.append(" like '%" + type + "%'");

			}
			if (!isBlank(attrId)) {
				sql.append(" and ").append(IBOPrivAttrUsedParamValue.S_AttrId)
						.append("='" + attrId + "'");

			}
		}
		if(!isBlank(condStr)){
			sql.append(" and ").append(condStr);
		}
		
		if (!isBlank(prodName)) {
			sql.append(" and ").append(IBOPrivAttrUsedParamValue.S_Privname)
					.append(" like '%").append(prodName).append("%'");

		}
		
		if (!isBlank(privId)) {
			sql.append(" and ").append(IBOPrivAttrUsedParamValue.S_Privid)
					.append("='" + privId + "'");

		}

		return sql.toString();
	}



	public boolean isBlank(String str) {
		if (null != str && !str.equals("")) {
			return false;

		} else {
			return true;
		}

	}

	

	/**
	 * 查找属性
	 */
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

	public String getSqlForGprs(String cols, String prodName, String type,
			String privId) {
		StringBuffer sql = new StringBuffer();
		sql
				.append("select ")
				.append(cols)
				.append("  from (")
				.append(
						"select PRIVID, RATEPLANID, STD_FREE1, STD_FREE2, STD_FREE3, "
								+ " HALFFLAG, GETTYPE, STATUS, STATUSDATE, STD_FREE4, "
								+ " GROUPID, PRIVNAME,PKGCODE, ISCALBYDAY"
								+ " from HBSALE.GPRS_FLUX_PARAM) a left outer join hbsale.product_ext b on a.privid = b.e_privid and b.ext_type='"
								+ type + "' and b.state='1' "
								+ "left join (select case when DOOR_DAMNIFY >0 then '是' when DOOR_DAMNIFY =0 then  '否' else '' end as isbase," 
								+ "PREFERENTIAL_ID1,PREFERENTIAL_ID2,PREFERENTIAL_ID3,PREFERENTIAL_ID4,PREFERENTIAL_ID5 from hbsale.charge_info_t) c  "
								+ "on ((c.PREFERENTIAL_ID1 IS NOT NULL AND a.privid = c.PREFERENTIAL_ID1) " 
								+ "OR (c.PREFERENTIAL_ID2 IS NOT NULL AND a.privid = c.PREFERENTIAL_ID2) " 
								+ "OR (c.PREFERENTIAL_ID3 IS NOT NULL AND a.privid = c.PREFERENTIAL_ID3) " 
								+ "OR (c.PREFERENTIAL_ID4 IS NOT NULL AND a.privid = c.PREFERENTIAL_ID4) " 
								+ "OR (c.PREFERENTIAL_ID5 IS NOT NULL AND a.privid = c.PREFERENTIAL_ID5))");
		sql.append(" where ").append(" 1=1 ");
		if (!isBlank(prodName)) {
			sql.append(" and ").append(IBOPrivAttrUsedParamValue.S_Privname)
					.append(" like '%").append(prodName).append("%'");

		}
		if (!isBlank(privId)) {
			sql.append(" and ").append(IBOPrivAttrUsedParamValue.S_Privid)
					.append("='" + privId + "'");
		}
		return sql.toString();
	}

	@Override
	public void initialBasicValue(String extType) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		StringBuffer executeSql = new StringBuffer();
		executeSql
				.append("insert into hbsale.product_ext(pid,create_date,state,ext_type,e_privid ,e_attr_id) select nextval for hbsale.product_ext_seq,current date,'1','"
						+ extType
						+ "',privid, attr_id  from "
						+ " hbsale.priv_attr_used_param a left outer join hbsale.product_ext b on a.privid = b.e_privid and a.attr_id = b.e_attr_id "
						+ "and b.ext_type ='"
						+ extType
						+ "' where a.priv_type like '%"
						+ extType
						+ "%' and b.e_attr_id  is null and b.e_privid is null");
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
	public void initialGprsValue(String extType) throws Exception {

		Connection conn = null;
		PreparedStatement ps = null;
		StringBuffer executeSql = new StringBuffer();
		executeSql
				.append("insert into hbsale.product_ext(pid,create_date,state,ext_type,e_privid ) select nextval for hbsale.product_ext_seq,"
						+ "current date,'1','"
						+ extType
						+ "',privid  from "
						+ " hbsale.gprs_flux_param a left outer join hbsale.product_ext b on a.privid = b.e_privid  and b.ext_type ='"
						+ extType + "' where b.e_privid  is null");
		try {
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
	public IBOProductExtValue getDataValue(String privId, String attrId,
			String extType, String state) throws Exception {
		StringBuffer sql = new StringBuffer();
		Map param = new HashMap();
		sql.append("1=1");
		if (!this.isBlank(privId)) {
			sql.append(" and ").append(IBOProductExtValue.S_EPrivid).append(
					"='" + privId + "'");

		}
		if (!isBlank(attrId)) {
			sql.append(" and ").append(IBOProductExtValue.S_EAttrId).append(
					"='" + attrId + "'");

		}

		if (!this.isBlank(extType)) {
			sql.append(" and ").append(IBOProductExtValue.S_ExtType).append(
					"=:extType ");
			param.put("extType", extType);

		}
		if (!this.isBlank(state)) {
			sql.append(" and ").append(IBOProductExtValue.S_State).append(
					"=:state");
			param.put("state", state);
		}
		IBOProductExtValue[] values = BOProductExtEngine.getBeans(sql
				.toString(), param);
		if (values.length > 0) {
			return values[0];
		} else
			return null;

	}

	public void saveProductExtValue(IBOProductExtValue[] dataValues)
			throws Exception {

		for (int i = 0; i < dataValues.length; i++) {
			dataValues[i].setPid(BOProductExtEngine.getNewId().longValue());
		}
		BOProductExtEngine.save(dataValues);
	}

	/**
	 * 查询历史记录
	 */
	public DataContainer[] qryProductInfoHis(String displayCols,
			String basicCols, String tableName, String privId, String attrId,
			String state, String extType, int startIndex, int endIndex)
			throws Exception {
		String sqlStr = this.getHisSql(displayCols, basicCols, tableName,
				privId, attrId, state, extType);
		String limitSql = "";
		if (startIndex == -1 && endIndex == -1) {
			limitSql = sqlStr;
		} else {
			limitSql = this.getLimitSQL(sqlStr, startIndex, endIndex);
		}
		if ("GPRS".equals(extType)) {
			return BOGprsProductInfoEngine.getBeansFromSql(limitSql, null);
		} else
			return BOProductInfoEngine.getBeansFromSql(limitSql, null);
	}

	/**
	 * 获得查询历史记录的sql
	 * 
	 * @param displayCols
	 * @param basicCols
	 * @param tableName
	 * @param id
	 * @param state
	 * @param extType
	 * @return
	 */
	public String getHisSql(String displayCols, String basicCols,
			String tableName, String privId, String attrId, String state,
			String extType) {
		StringBuffer sql = new StringBuffer();
		sql
				.append(" select "
						+ displayCols
						+ " from (select "
						+ basicCols
						+ " from hbsale."
						+ tableName
						+ ") a inner join hbsale.product_ext b on a.privid = b.e_privid");
		if (!"GPRS".equals(extType)) {
			sql.append(" and a.attr_id = b.e_attr_id ");
		}
		sql.append(" where 1=1 ");

		if (!isBlank(state)) {
			sql.append(" and ").append(IBOProductExtValue.S_State).append(
					"='" + state + "'");
		}
		if (!isBlank(extType)) {
			sql.append(" and ").append(IBOProductExtValue.S_ExtType).append(
					"='" + extType + "'");
		}
		if (!isBlank(privId)) {
			sql.append(" and ").append(IBOProductExtValue.S_EPrivid).append(
					"='" + privId + "'");
		}
		if (!isBlank(attrId)) {
			sql.append(" and ").append(IBOProductExtValue.S_EAttrId).append(
					"='" + attrId + "'");
		}

		return sql.toString();
	}

	
	public int qryProductInfoHisCount(String displayCols, String basicCols,
			String tableName, String privId, String attrId, String state,
			String extType) throws Exception {
		String sql = this.getHisSql(displayCols, basicCols, tableName, privId,
				attrId, state, extType);
		return this.getCountFromSql(sql, null);

	}

}
