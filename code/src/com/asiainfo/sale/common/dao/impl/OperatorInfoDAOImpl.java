package com.asiainfo.sale.common.dao.impl;

import java.net.URLDecoder;
import java.util.HashMap;

import com.asiainfo.sale.common.bo.BOOperatorInfoBean;
import com.asiainfo.sale.common.bo.BOOperatorInfoEngine;
import com.asiainfo.sale.common.bo.BOWFOperatorBean;
import com.asiainfo.sale.common.bo.BOWFOperatorEngine;
import com.asiainfo.sale.common.dao.interfaces.IOperatorInfoDAO;
import com.asiainfo.sale.common.ivalues.IBOOperatorInfoValue;
import com.asiainfo.sale.common.ivalues.IBOWFOperatorValue;

public class OperatorInfoDAOImpl implements IOperatorInfoDAO {

	public BOOperatorInfoBean[] getOperatorInfo(String staffName, String orgId,
			int startNum, int endNum) throws Exception {
		String[] cols = null;
		boolean isShowFK = false;
		HashMap parameter = new HashMap();

		String condition = " 1=1 ";
		if (null != staffName && !"".equals(staffName)
				&& !"null".equals(staffName)) {
			staffName = URLDecoder.decode(staffName, "utf-8");
			condition = condition + " AND " + IBOOperatorInfoValue.S_StaffName
					+ " LIKE :staffName ";
			parameter.put("staffName", "%" + staffName + "%");
		}
		if (null != orgId && !"".equals(orgId) && !"null".equals(orgId)) {
			condition = condition
					+ " AND LOCATE ( (SELECT CODE FROM SECHB.SEC_ORGANIZE WHERE ORGANIZE_ID = :orgId ), ORG_CODE) > 0";
			parameter.put("orgId", orgId);
		}
		return BOOperatorInfoEngine.getBeans(cols, condition
				+ " ORDER BY NOTES, CODE", parameter, startNum, endNum,
				isShowFK);
	}

	public int getCountByOrgId(String staffName, String orgId) throws Exception {
		HashMap parameter = new HashMap();
		String condition = " 1=1 ";
		if (null != staffName && !"".equals(staffName)
				&& !"null".equals(staffName)) {
			staffName = URLDecoder.decode(staffName, "utf-8");
			condition = condition + " AND " + IBOOperatorInfoValue.S_StaffName
					+ " LIKE :staffName ";
			parameter.put("staffName", "%" + staffName + "%");
		}
		if (null != orgId && !"".equals(orgId) && !"null".equals(orgId)) {
			condition = condition
					+ " AND LOCATE ( (SELECT CODE FROM SECHB.SEC_ORGANIZE WHERE ORGANIZE_ID = :orgId ) , ORG_CODE) > 0";
			parameter.put("orgId", orgId);
		}
		return BOOperatorInfoEngine.getBeansCount(condition, parameter);
	}

	public int getWFOperatorCountByOrgId(String staffName, String roleId,
			String orgId) throws Exception {
		HashMap parameter = new HashMap();
		String condition = " 1=1 ";
		if (null != staffName && !"".equals(staffName)
				&& !"null".equals(staffName)) {
			staffName = URLDecoder.decode(staffName, "utf-8");
			condition = condition + " AND " + IBOOperatorInfoValue.S_StaffName
					+ " LIKE :staffName";
			parameter.put("staffName", "%" + staffName + "%");
		}
		if (null != roleId && !"".equals(roleId) && !"null".equals(roleId)) {
			condition = condition + " AND " + IBOWFOperatorValue.S_RoleId
					+ " = :roleId ";
			parameter.put("roleId", roleId);
		}
		if (null != orgId && !"".equals(orgId) && !"null".equals(orgId)) {
			if (roleId.equals("101405")) {
				condition = condition + " and ORGANIZE_ID = :orgId ";
			} else if (roleId.equals("101408") || roleId.equals("101410")) {
				condition = condition
						+ " AND (subStr (ORGANIZE_ID,1,2) = subStr( :orgId , 1 , 2 )) ";
			} else {
				condition = condition
						+ " AND (subStr (ORGANIZE_ID,1,2) = '10' or subStr (ORGANIZE_ID,1,2) = subStr( :orgId , 1 , 2 )) ";
			}
			parameter.put("orgId", orgId);
		}
		return BOWFOperatorEngine.getBeansCount(condition, parameter);
	}

	public BOWFOperatorBean[] getWFOperatorInfo(String staffName,
			String roleId, String orgId, int startNum, int endNum)
			throws Exception {
		String[] cols = null;
		boolean isShowFK = false;
		HashMap parameter = new HashMap();

		String condition = " 1=1 ";
		if (null != staffName && !"".equals(staffName)
				&& !"null".equals(staffName)) {
			staffName = URLDecoder.decode(staffName, "utf-8");
			condition = condition + " AND " + IBOOperatorInfoValue.S_StaffName
					+ " LIKE :staffName";
			parameter.put("staffName", "%" + staffName + "%");
		}
		if (null != roleId && !"".equals(roleId) && !"null".equals(roleId)) {
			condition = condition + " AND " + IBOWFOperatorValue.S_RoleId
					+ " = :roleId ";
			parameter.put("roleId", roleId);
		}
		if (null != orgId && !"".equals(orgId) && !"null".equals(orgId)) {
			if (roleId.equals("101405")) {
				condition = condition + " and ORGANIZE_ID = :orgId ";
			} else if (roleId.equals("101408") || roleId.equals("101410")) {
				condition = condition
						+ " AND (subStr (ORGANIZE_ID,1,2) = subStr( :orgId , 1 , 2 )) ";
			} else {
				condition = condition
						+ " AND (subStr (ORGANIZE_ID,1,2) = '10' or subStr (ORGANIZE_ID,1,2) = subStr( :orgId , 1 , 2 )) ";
			}
			parameter.put("orgId", orgId);
		}
		return BOWFOperatorEngine.getBeans(cols, condition
				+ " ORDER BY NOTES, CODE", parameter, startNum, endNum,
				isShowFK);
	}

	public IBOWFOperatorValue getNameById(String id) throws Exception {
		HashMap parameter = new HashMap();

		String condition = " " + IBOWFOperatorValue.S_OperatorId + "= :id ";
		parameter.put("id", id);
		return BOWFOperatorEngine.getBeans(condition, parameter)[0];
	}
}
