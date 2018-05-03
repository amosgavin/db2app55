package com.asiainfo.sale.activity.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.StringUtils;
import com.asiainfo.sale.activity.bo.BOSaleDetailBean;
import com.asiainfo.sale.activity.bo.BOSaleDetailEngine;
import com.asiainfo.sale.activity.bo.BOSaleInfoBean;
import com.asiainfo.sale.activity.bo.BOSaleMainBean;
import com.asiainfo.sale.activity.bo.BOSaleMainEngine;
import com.asiainfo.sale.activity.bo.BOSaleMainShowEngine;
import com.asiainfo.sale.activity.dao.interfaces.ISaleDetailDAO;
import com.asiainfo.sale.activity.dao.interfaces.ISaleDetailShowDAO;
import com.asiainfo.sale.activity.dao.interfaces.ISaleMainDAO;
import com.asiainfo.sale.activity.dao.interfaces.ISaleMainShowDAO;
import com.asiainfo.sale.activity.ivalues.IBOSaleDetailShowValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleDetailValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleInfoValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleMainShowValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleMainValue;

public class SaleMainShowDAOImpl implements ISaleMainShowDAO {
	
	
	public int getCount(String name, String applicant, String org)
			throws Exception {
		Object[] objects = getCondition(name, applicant, org);
		return BOSaleMainShowEngine.getBeansCount((String) objects[0],
				(Map) objects[1]);
	}

	
	public IBOSaleMainShowValue[] getSaleMainShow(String name, String applicant,
			String org, int startNum, int endNum) throws Exception {
		Object[] objects = getCondition(name, applicant, org);
		return BOSaleMainShowEngine.getBeans((String) objects[0], (Map) objects[1]);
	}

	
	public IBOSaleMainShowValue getSaleMainShowById(String id) throws Exception {
		return BOSaleMainShowEngine.getBean(id);
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
		if (StringUtils.isNotBlank(name)) {
			condition.append(" AND " + IBOSaleMainShowValue.S_SaleMainName
					+ " like :name");
			parameter.put("name", "%" + name + "%");
		}
		if (StringUtils.isNotBlank(applicant)) {
			condition.append(" AND " + IBOSaleMainShowValue.S_Principal
					+ " = :applicant");
			parameter.put("applicant", applicant);
		}
		if (StringUtils.isNotBlank(org)) {
			condition.append(" AND " + IBOSaleMainShowValue.S_PromoteDepart
					+ " = :org");
			parameter.put("org", org);
		}
		return new Object[] { condition.toString(), parameter };
	}

	@Override
	public IBOSaleMainShowValue[] getSaleMainAndFWInfo(String selectType,
			String mainCode, String name, String applicant, String org,
			String submitTimeBegin, String submitTimeEnd, String isFinish,
			int startNum, int endNum) throws Exception {
		String VM_WF = "VM_WF";
		String VM_TASK = "VM_TASK";
		if ("true".equals(isFinish))
		{
			VM_WF = "H_VM_WF";
			VM_TASK = "H_VM_TASK";
		}
		if ("3".equals(selectType)||"4".equals(selectType))
		{
			VM_WF = "H_VM_WF";
			VM_TASK = "H_VM_TASK";
		}
		
		StringBuffer queryStr = new StringBuffer();
		queryStr.append("SELECT DISTINCT M.BEGIN_TIME,");
		queryStr.append("       M.CREATE_TIME,");
		queryStr.append("       M.DETAIL_INFO,");
		queryStr.append("       M.END_TIME,");
		queryStr.append("       M.ID,");
		queryStr.append("       M.IS_SUBMIT,");
		queryStr.append("       M.MODIFY_TIME,");
		queryStr.append("       M.IS_SUBMIT,");
		queryStr.append("       M.BACK_GROUND,");
		queryStr.append("       M.AIM,");
		queryStr.append("       M.CONTENT,");
		queryStr.append("       M.EXEAREA,");
		queryStr.append("       M.ISACTIVE_SALE,");
		queryStr.append("       M.ACTIVE_SALE_SITE,");
		queryStr.append("       M.MARKTYPE,");
		queryStr.append("       ORG.ORGANIZE_NAME,");
		queryStr.append("       M.PRINCIPAL,");
		queryStr.append("       M.PROMOTE_DEPART,");
		queryStr.append("       M.SALE_MAIN_CODE,");
		queryStr.append("       M.SALE_MAIN_NAME,");
		queryStr.append("       S.STAFF_NAME,");
		queryStr.append("       WF.WORKFLOW_ID,");
		//queryStr.append("       T.LABEL,");
		//queryStr.append("       T.TASK_TAG,");
		//queryStr.append("       T.STATE,");
		//queryStr.append("       T.STATE_DATE,");
		//queryStr.append("       T.FINISH_DATE,");
		queryStr.append("       WF.WORKFLOW_OBJECT_TYPE,");
		queryStr.append("       WF.CREATE_DATE");
		queryStr.append("  FROM SALE_MAIN_T M");
		queryStr.append("       LEFT JOIN SECHB.SEC_OPERATOR OP");
		queryStr.append("          ON M.PRINCIPAL = char(OP.OPERATOR_ID)");
		queryStr.append("       LEFT JOIN SECHB.SEC_STAFF S");
		queryStr.append("          ON OP.STAFF_ID = S.STAFF_ID");
		queryStr.append("       LEFT JOIN (select o1.ORGANIZE_ID, o2.organize_name||o1.organize_name organize_name from SECHB.SEC_ORGANIZE o1 left join SECHB.SEC_ORGANIZE o2 on substr(o1.organize_id,1,2) = o2.organize_id) ORG");
		queryStr.append("          ON M.PROMOTE_DEPART = ORG.ORGANIZE_ID");
		queryStr.append("       LEFT JOIN HBSALE." + VM_WF + " WF");
		queryStr.append("          ON M.ID = WF.WORKFLOW_OBJECT_ID");
		//queryStr.append("       LEFT JOIN (SELECT X.WORKFLOW_ID,");
		//queryStr.append("                         X.LABEL,");
		//queryStr.append("                         X.TASK_TAG,");
		//queryStr.append("                         X.STATE,");
		//queryStr.append("                         X.STATE_DATE,");
		//queryStr.append("                         X.FINISH_DATE,");
		//queryStr.append("                         X.STATION_ID,");
		//queryStr.append("                         X.TASK_STAFF_ID");
		//queryStr.append("                    FROM HBSALE." + VM_TASK + " X");
		//queryStr.append("                   WHERE X.STATE = 5) T");
		//queryStr.append("                    ) T");
		//queryStr.append("          ON WF.WORKFLOW_ID = T.WORKFLOW_ID");
		queryStr.append("   WHERE 1 =1 ");

		Map parameter = new HashMap();
		if (StringUtils.isNotBlank(mainCode)) {
			queryStr.append(" AND M.ID = :mainCode");
			parameter.put("mainCode", mainCode);
		} else {

			if (StringUtils.isNotBlank(selectType) && !selectType.equals("0")) 
			{
				queryStr.append(" AND M.IS_SUBMIT = :selectType ");
				parameter.put("selectType", selectType);
			}
			//System.out.println(name);
			if (StringUtils.isNotBlank(name)) 
			{
				queryStr.append(" AND M.SALE_MAIN_NAME like :name");
				parameter.put("name", "%" + name + "%");
			}
			if (StringUtils.isNotBlank(org) && !org.equals("0")) {
				if (org.equals("18")) {
					queryStr.append(" AND substr(M.PROMOTE_DEPART,1,2) in ('18','27','28')");
				} else {
					queryStr.append(" AND substr(M.PROMOTE_DEPART,1,2) = '" + org + "'");
					parameter.put("org", org);
				}
			}
			if (StringUtils.isNotBlank(applicant)) {
				/*if (StringUtils.isNotBlank(org)) {
					queryStr.append(" OR");
				} else {
					queryStr.append(" AND (");
				}*/
				queryStr.append(" and OP.OPERATOR_ID = " + applicant);
				//取消代理功能
				//queryStr.append(" OR OP.OPERATOR_ID IN ");
				//queryStr.append("	(SELECT AUTHOR_STAFF_ID FROM HBSALE.PROXY_PRIVE_T ");
				//queryStr.append("  		WHERE PROXY_STAFF_ID = '" + applicant + "' AND STATE = '1') ");
				//取消流程相关人员查询
				//queryStr.append(" OR (T.STATION_ID IN (SELECT ROLE_ID");
				//queryStr.append(" FROM SECHB.SEC_AUTHOR AU");
				//queryStr.append(" LEFT JOIN");
				//queryStr.append(" SECHB.SEC_OP_STATION ST");
				//queryStr.append(" ON AU.OP_STATION_ID = ST.OP_STATION_ID");
				//queryStr.append(" WHERE ST.OPERATOR_ID = '" + applicant+"')");
				//queryStr.append(" OR T.TASK_STAFF_ID = '" + applicant+"')");

				parameter.put("applicant", applicant);
			} else {
				queryStr.append(" and OP.OPERATOR_ID <> 0 ");
			}
			/*if (StringUtils.isNotBlank(org) || StringUtils.isNotBlank(applicant)) {
				queryStr.append(" ) ");
			}*/
			if (StringUtils.isNotBlank(submitTimeBegin)) {
				if ("1".equals(selectType)) {
					queryStr.append(" AND M.CREATE_TIME >= to_date(:submitTimeBegin ,'yyyymmdd hh24:mi:ss')");
				} else if ("0".equals(selectType) || !StringUtils.isNotBlank(selectType)) {
					queryStr.append(" AND (WF.CREATE_DATE >= to_date(:submitTimeBegin ,'yyyymmdd hh24:mi:ss') OR M.CREATE_TIME >= to_date(:submitTimeBegin ,'yyyymmdd hh24:mi:ss'))");
				} else {
					queryStr.append(" AND WF.CREATE_DATE >= to_date(:submitTimeBegin ,'yyyymmdd hh24:mi:ss')");
				}
				parameter.put("submitTimeBegin", submitTimeBegin);
			}
			if (StringUtils.isNotBlank(submitTimeEnd)) {
				if ("1".equals(selectType)) {
					queryStr.append(" AND M.CREATE_TIME <= to_date(:submitTimeEnd ,'yyyymmdd hh24:mi:ss')");
				} else if ("0".equals(selectType) || !StringUtils.isNotBlank(selectType)) {
					queryStr.append(" AND (M.CREATE_TIME <= to_date(:submitTimeEnd ,'yyyymmdd hh24:mi:ss') OR M.CREATE_TIME <= to_date(:submitTimeEnd ,'yyyymmdd hh24:mi:ss'))");
				} else {
					queryStr.append(" AND WF.CREATE_DATE <= to_date(:submitTimeEnd ,'yyyymmdd hh24:mi:ss')");
				}
				parameter.put("submitTimeEnd", submitTimeEnd);
			}
		}

		queryStr.append(" ORDER BY CREATE_TIME DESC");
		
		String sql = queryStr.toString();
		if (0 < startNum && startNum < endNum) {
			sql = "SELECT * FROM (SELECT DATA1.*,ROWNUMBER() OVER() AS ROW_INDEX FROM ( "
					+ sql
					+ ") AS DATA1 ) AS DATA2 WHERE  ROW_INDEX >=:startNum AND ROW_INDEX <= :endNum ";
			parameter.put("startNum", startNum);
			parameter.put("endNum", endNum);
		}
		
		return BOSaleMainShowEngine.getBeansFromSql(sql, parameter);
	}


	@Override
	public int getCount(String selectType, String mainCode, String name,
			String applicant, String org, String submitTimeBegin,
			String submitTimeEnd, String isFinish) throws Exception {
		IBOSaleMainShowValue[] values = this.getSaleMainAndFWInfo(selectType,
				mainCode, name, applicant, org, submitTimeBegin, submitTimeEnd,
				isFinish, -1, -1);
		if (values != null && values.length > 0) {
			return values.length;
		}
		return 0;
	}


	@Override
	public int getCount(List<String> wfList, String mainCode, String name,
			String applicant, String org, String submitTimeBegin,
			String submitTimeEnd) throws Exception {
		IBOSaleMainShowValue[] values = this.getSaleMainAndFWInfo(wfList,
				mainCode, name, applicant, org, submitTimeBegin, submitTimeEnd,
				-1, -1);
		if (values != null && values.length > 0) {
			return values.length;
		}
		return 0;
	}

	@Override
	public IBOSaleMainShowValue[] getSaleMainAndFWInfo(List<String> wfList,
			String mainCode, String name, String applicant, String org,
			String submitTimeBegin, String submitTimeEnd, int startNum,
			int endNum) throws Exception {
		String mainIdList = "";
		if (null == wfList || wfList.size() < 1) {
			return null;
		}
		for (String mainId : wfList) {
			if ("".equals(mainIdList)) {
				mainIdList = "'" + mainId + "'";
			} else {
				mainIdList = mainIdList + ",'" + mainId + "'";
			}
		}

		StringBuffer queryStr = new StringBuffer();
		queryStr.append("SELECT M.BEGIN_TIME,");
		queryStr.append("       M.CREATE_TIME,");
		queryStr.append("       M.DETAIL_INFO,");
		queryStr.append("       M.END_TIME,");
		queryStr.append("       M.ID,");
		queryStr.append("       M.MODIFY_TIME,");
		queryStr.append("       M.IS_SUBMIT,");
		queryStr.append("       ORG.ORGANIZE_NAME,");
		queryStr.append("       M.PRINCIPAL,");
		queryStr.append("       M.PROMOTE_DEPART,");
		queryStr.append("       M.SALE_MAIN_CODE,");
		queryStr.append("       M.SALE_MAIN_NAME,");
		queryStr.append("       S.STAFF_NAME");
		queryStr.append("  FROM SALE_MAIN_T M");
		queryStr.append("       LEFT JOIN SECHB.SEC_OPERATOR OP");
		queryStr.append("          ON M.PRINCIPAL = OP.OPERATOR_ID");
		queryStr.append("       LEFT JOIN SECHB.SEC_STAFF S");
		queryStr.append("          ON OP.STAFF_ID = S.STAFF_ID");
		queryStr.append("       LEFT JOIN SECHB.SEC_ORGANIZE ORG");
		queryStr.append("          ON M.PROMOTE_DEPART = ORG.ORGANIZE_ID");
		queryStr.append("   WHERE 1 =1");

		Map parameter = new HashMap();
		if (StringUtils.isNotBlank(mainIdList)) {
			queryStr.append(" AND M.SALE_MAIN_CODE in ( :mainIdList )");
			parameter.put("mainIdList", mainIdList);
		}
		if (StringUtils.isNotBlank(mainCode)) {
			queryStr.append(" AND M.SALE_MAIN_CODE = :mainCode");
			parameter.put("mainId", mainCode);
		}
		if (StringUtils.isNotBlank(name)) {
			queryStr.append(" AND M.SALE_MAIN_NAME like :name");
			parameter.put("name", "%" + name + "%");
		}
		if (StringUtils.isNotBlank(applicant)) {
			queryStr.append(" AND OP.STAFF_ID in ( :applicant )");
			parameter.put("applicant", applicant);
		}
		if (StringUtils.isNotBlank(org)) {
			queryStr.append(" AND M.PROMOTE_DEPART = :org");
			parameter.put("org", org);
		}
		if (StringUtils.isNotBlank(submitTimeBegin)) {
			queryStr
					.append(" AND WF.CREATE_DATE >= to_date(:submitTimeBegin ,'yyyymmdd hh24:mi:ss'");
			parameter.put("submitTimeBegin", submitTimeBegin);
		}
		if (StringUtils.isNotBlank(submitTimeEnd)) {
			queryStr
					.append(" AND WF.CREATE_DATE <= to_date(:submitTimeEnd ,'yyyymmdd hh24:mi:ss'");
			parameter.put("submitTimeEnd", submitTimeEnd);
		}

		String sql = queryStr.toString();
		if (0 < startNum && startNum < endNum) {
			sql = "SELECT * FROM (SELECT DATA1.*,ROWNUMBER() OVER() AS ROW_INDEX FROM ( "
					+ sql
					+ ") AS DATA1 ) AS DATA2 WHERE  ROW_INDEX >=:startNum AND ROW_INDEX <= :endNum ";
			parameter.put("startNum", startNum);
			parameter.put("endNum", endNum);
		}

		return BOSaleMainShowEngine.getBeansFromSql(sql, parameter);
	}


	@Override
	public IBOSaleMainShowValue[] getSaleMainOverviewById(String id)
			throws Exception {
		StringBuffer queryStr = new StringBuffer();
		queryStr.append("SELECT ID,");
		queryStr.append("       SALE_MAIN_CODE,");
		queryStr.append("       SALE_MAIN_NAME,");
		queryStr.append("       PRINCIPAL,");
		queryStr.append("       PROMOTE_MANAGER,");
		queryStr.append("       PROMOTE_DEPART,");
		queryStr.append("       DETAIL_INFO,");
		queryStr.append("       BEGIN_TIME,");
		queryStr.append("       END_TIME,");
		queryStr.append("       CREATE_TIME,");
		queryStr.append("       MODIFY_TIME,");
		queryStr.append("       IS_SUBMIT,");
		queryStr.append("       PRORPLAN,");
		queryStr.append("       EXPLANATION,");
		queryStr.append("       STATREQUEST,");
		queryStr.append("       BUSINESSCHECKPLAN,");
		queryStr.append("       SPECIALNOTE,");
		queryStr.append("       SALEDEMAND,");
		queryStr.append("       BACK_GROUND,");
		queryStr.append("       MARKTYPE,");
		queryStr.append("       AIM,");
		queryStr.append("       CONTENT,");
		queryStr.append("       EXEAREA,");
		queryStr.append("       ISACTIVE_SALE,");
		queryStr.append("       ACTIVE_SALE_SITE,");
		queryStr.append("       PRE_PERSON,");
		queryStr.append("       PRE_ADD_PERSON,");
		queryStr.append("       PRE_INCOME,");
		queryStr.append("       ORG.ORGANIZE_NAME,");
		queryStr.append("       S.STAFF_NAME,");
		queryStr.append("       COST_TOTAL,");
		queryStr.append("       MOBILE_COST,");
		queryStr.append("       ELECPAY_COST,");
		queryStr.append("       MOBILEPAY_COST,");
		queryStr.append("       ELECGOODS_COST,");
		queryStr.append("       GOODS_COST,");
		queryStr.append("       FEE_DISCOUNT,");
		queryStr.append("       BUSINESS_DISCOUNT,");
		queryStr.append("       CHANNEL_PAY,");
		queryStr.append("       ESTIMATE_AD_FEE,");
		queryStr.append("       ISGROUP,");
		queryStr.append("       GROUP_PROP,");
		queryStr.append("       SALE_OBJECT,");
		queryStr.append("       ACTIVITY_TYPE,");
		queryStr.append("       ESTIMATE_OTHER_FEE");
		queryStr.append("  FROM    HBSALE.SALE_MAIN_T M");
		queryStr.append("       LEFT JOIN SECHB.SEC_OPERATOR OP");
		queryStr.append("          ON M.PRINCIPAL = OP.OPERATOR_ID");
		queryStr.append("       LEFT JOIN SECHB.SEC_STAFF S");
		queryStr.append("          ON OP.STAFF_ID = S.STAFF_ID");
		queryStr.append("       LEFT JOIN SECHB.SEC_ORGANIZE ORG");
		queryStr.append("          ON M.PROMOTE_DEPART = ORG.ORGANIZE_ID");
		queryStr.append("       LEFT JOIN");
		queryStr.append("          (SELECT d.sale_id,");
		queryStr.append("                  sum (d.PRE_PERSON) AS PRE_PERSON,");
		queryStr.append("                  sum (d.PRE_ADD_PERSON) AS PRE_ADD_PERSON,");
		queryStr.append("                  sum (d.PRE_INCOME2) AS PRE_INCOME,");
		queryStr.append("                  sum (d.COST_TOTAL) AS COST_TOTAL,");
		queryStr.append("                  sum (d.MOBILE_COST) AS MOBILE_COST,");
		queryStr.append("                  sum (d.ELECPAY_COST) AS ELECPAY_COST,");
		queryStr.append("                  sum (d.MOBILEPAY_COST) AS MOBILEPAY_COST,");
		queryStr.append("                  sum (d.ELECGOODS_COST) AS ELECGOODS_COST,");
		queryStr.append("                  sum (d.GOODS_COST) AS GOODS_COST,");
		queryStr.append("                  sum (d.FEE_DISCOUNT) AS FEE_DISCOUNT,");
		queryStr.append("                  sum (d.BUSINESS_DISCOUNT) AS BUSINESS_DISCOUNT,");
		queryStr.append("                  sum (d.CHANNEL_PAY) AS CHANNEL_PAY,");
		queryStr.append("                  sum (d.ESTIMATE_AD_FEE) AS ESTIMATE_AD_FEE,");
		queryStr.append("                  sum (d.ESTIMATE_OTHER_FEE) AS ESTIMATE_OTHER_FEE");
		queryStr.append("             FROM HBSALE.SALE_DETAIL_T D");
		queryStr.append("            WHERE SALE_ID = '" + id + "'");
		queryStr.append("           GROUP BY d.sale_id) dt");
		queryStr.append("       ON ID = dt.sale_id");
		queryStr.append(" WHERE ID = '" + id + "'");
		
		Map parameter = new HashMap();
		
		return BOSaleMainShowEngine.getBeansFromSql(queryStr.toString(), parameter);
	}


	@Override
	public IBOSaleInfoValue getSaleInfoValue(String id) throws Exception {
		IBOSaleInfoValue saleInfoValue = new BOSaleInfoBean();
		IBOSaleMainShowValue saleMainShoValue = getSaleMainShowById(id);
		IBOSaleDetailShowValue[] saleDetailShowValues = ((ISaleDetailShowDAO) ServiceFactory
				.getService(ISaleDetailShowDAO.class)).getSaleDetailShowValues(id);
		saleInfoValue.setSaleMainShowValue(saleMainShoValue);
		saleInfoValue.setSaleDetailShowValues(saleDetailShowValues);
		
		return saleInfoValue;
	}


	@Override
	public IBOSaleMainShowValue[] getSaleMainInfo(String selectType,
			String mainCode, String name, String applicant, String org,
			String submitTimeBegin, String submitTimeEnd, int startNum,
			int endNum) throws Exception {
		StringBuffer queryStr = new StringBuffer();
		Map parameter = new HashMap();
		queryStr.append("SELECT M.BEGIN_TIME,");
		queryStr.append("       M.CREATE_TIME,");
		queryStr.append("       M.DETAIL_INFO,");
		queryStr.append("       M.END_TIME,");
		queryStr.append("       M.ID,");
		queryStr.append("       M.MODIFY_TIME,");
		queryStr.append("       M.IS_SUBMIT,");
		queryStr.append("       ORG.ORGANIZE_NAME,");
		queryStr.append("       M.PRINCIPAL,");
		queryStr.append("       M.PROMOTE_DEPART,");
		queryStr.append("       M.SALE_MAIN_CODE,");
		queryStr.append("       M.SALE_MAIN_NAME,");
		queryStr.append("       S.STAFF_NAME");
		queryStr.append("  FROM SALE_MAIN_T M");
		queryStr.append("       LEFT JOIN SECHB.SEC_OPERATOR OP");
		queryStr.append("          ON M.PRINCIPAL = OP.OPERATOR_ID");
		queryStr.append("       LEFT JOIN SECHB.SEC_STAFF S");
		queryStr.append("          ON OP.STAFF_ID = S.STAFF_ID");
		queryStr.append("       LEFT JOIN SECHB.SEC_ORGANIZE ORG");
		queryStr.append("          ON M.PROMOTE_DEPART = ORG.ORGANIZE_ID");
		queryStr.append("   WHERE 1 =1");
		
		if (StringUtils.isNotBlank(mainCode)) {
			queryStr.append(" AND M.SALE_MAIN_CODE = :mainCode");
			parameter.put("mainCode", mainCode);
		} else {
			if ("0".equals(selectType))
			{
				//查询全部
			} else {
				queryStr.append(" AND M.IS_SUBMIT = :selectType");
				parameter.put("selectType", selectType);
			}
			if (StringUtils.isNotBlank(name)) 
			{
				queryStr.append(" AND M.SALE_MAIN_NAME like :name");
				parameter.put("name", "%" + name + "%");
			}
			if (StringUtils.isNotBlank(org)) {
				queryStr.append(" AND (M.PROMOTE_DEPART = " + org);
				parameter.put("org", org);
			}
			if (StringUtils.isNotBlank(applicant)) {
				if (StringUtils.isNotBlank(org)) {
					queryStr.append(" OR");
				} else {
					queryStr.append(" AND (");
				}
				queryStr.append(" OP.OPERATOR_ID = " + applicant);
				queryStr.append(" OR OP.OPERATOR_ID IN ");
				queryStr.append("	(SELECT AUTHOR_STAFF_ID FROM HBSALE.PROXY_PRIVE_T ");
				queryStr.append("  		WHERE PROXY_STAFF_ID = '" + applicant + "' AND STATE = '1') ");

				parameter.put("applicant", applicant);
			}
			if (StringUtils.isNotBlank(org) || StringUtils.isNotBlank(applicant)) {
				queryStr.append(" ) ");
			}
			if (StringUtils.isNotBlank(submitTimeBegin)) {
				queryStr.append(" AND M.CREATE_TIME >= to_date(:submitTimeBegin ,'yyyymmdd hh24:mi:ss')");
				parameter.put("submitTimeBegin", submitTimeBegin);
			}
			if (StringUtils.isNotBlank(submitTimeEnd)) {
				queryStr.append(" AND M.CREATE_TIME <= to_date(:submitTimeEnd ,'yyyymmdd hh24:mi:ss')");
				parameter.put("submitTimeEnd", submitTimeEnd);
			}
		}

		queryStr.append(" ORDER BY CREATE_TIME DESC");
		
		String sql = queryStr.toString();
		if (0 < startNum && startNum < endNum) {
			sql = "SELECT * FROM (SELECT DATA1.*,ROWNUMBER() OVER() AS ROW_INDEX FROM ( "
					+ sql
					+ ") AS DATA1 ) AS DATA2 WHERE  ROW_INDEX >=:startNum AND ROW_INDEX <= :endNum ";
			parameter.put("startNum", startNum);
			parameter.put("endNum", endNum);
		}
		
		return BOSaleMainShowEngine.getBeansFromSql(sql, parameter);
	}

	@Override
	public int getSaleMainInfoCount(String selectType,
			String mainCode, String name, String applicant, String org,
			String submitTimeBegin, String submitTimeEnd) throws Exception {
		IBOSaleMainShowValue[] values = this.getSaleMainInfo(selectType,
				mainCode, name, applicant, org, submitTimeBegin, submitTimeEnd,
				 -1, -1);
		if (values != null && values.length > 0) {
			return values.length;
		}
		return 0;
	}
}
