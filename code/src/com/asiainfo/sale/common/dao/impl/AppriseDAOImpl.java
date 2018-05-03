package com.asiainfo.sale.common.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.comframe.vm.workflow.dao.interfaces.IVmWorkflowDAO;
import com.ai.comframe.vm.workflow.ivalues.IBOHVmWFValue;
import com.ai.comframe.vm.workflow.ivalues.IBOVmWFValue;
import com.asiainfo.sale.common.bo.BOAppriseMarkEngine;
import com.asiainfo.sale.common.bo.BOAppriseMemberBean;
import com.asiainfo.sale.common.bo.BOAppriseMemberEngine;
import com.asiainfo.sale.common.bo.BOAppriseOrgBean;
import com.asiainfo.sale.common.bo.BOAppriseOrgEngine;
import com.asiainfo.sale.common.bo.BOAppriseTaskEngine;
import com.asiainfo.sale.common.dao.interfaces.IAppriseDAO;
import com.asiainfo.sale.common.ivalues.IBOAppriseMarkValue;
import com.asiainfo.sale.common.ivalues.IBOAppriseMemberValue;
import com.asiainfo.sale.common.ivalues.IBOAppriseOrgValue;
import com.asiainfo.sale.common.ivalues.IBOAppriseTaskValue;
import com.asiainfo.task.dao.interfaces.IProxyPriveDAO;

public class AppriseDAOImpl implements IAppriseDAO {

	public void modifyAppriseOrg(String orgStr, String workflowId)
			throws Exception {

		IBOAppriseOrgValue appriseOrg = getAppriseOrg(workflowId);
		if (appriseOrg != null) {
			appriseOrg.setOrgStr(orgStr);
			BOAppriseOrgEngine.save(appriseOrg);
		}
	}

	public void saveAppriseOrg(String orgStr, String workflowId)
			throws Exception {

		if (orgStr != null && orgStr.length() > 0) {

			IBOAppriseOrgValue appriseOrg = getAppriseOrg(workflowId);

			if (appriseOrg != null) {
				appriseOrg.setOrgStr(orgStr);
				BOAppriseOrgEngine.save(appriseOrg);
			} else {
				appriseOrg = new BOAppriseOrgBean();
				appriseOrg.setId(BOAppriseOrgEngine.getNewId().intValue());
				appriseOrg.setOrgStr(orgStr);
				appriseOrg.setWorkflowId(workflowId);
				appriseOrg.setStsToNew();
				BOAppriseOrgEngine.save(appriseOrg);
			}
		} else {

			IBOAppriseOrgValue appriseOrg = getAppriseOrg(workflowId);

			if (appriseOrg != null) {
				appriseOrg.setOrgStr("");
				BOAppriseOrgEngine.save(appriseOrg);
			}
		}
	}

	public IBOAppriseOrgValue getAppriseOrg(String workflowId) throws Exception {

		String condition = " " + IBOAppriseOrgValue.S_WorkflowId + "=" + "\'"
				+ workflowId + "\'";
		IBOAppriseOrgValue[] appriseOrg = BOAppriseOrgEngine.getBeans(
				condition, null);
		if (appriseOrg != null && appriseOrg.length > 0) {
			return appriseOrg[0];
		}
		return null;
	}

	public void savaApprisePrime(int operatorId, String workflowId,
			String content, String senderInfo) throws Exception {

		IBOAppriseMemberValue appriseSender = getAppriseMember(operatorId,
				workflowId);
		if (appriseSender == null) {

			appriseSender = new BOAppriseMemberBean();
			appriseSender.setId(BOAppriseMemberEngine.getNewId().intValue());
			appriseSender.setWorkflowId(workflowId);
			appriseSender.setOperatorId(operatorId);
			appriseSender.setContent(content);
			appriseSender.setSenderInfo(senderInfo);
			appriseSender.setLastOperatorId(0);
			appriseSender.setSendTime(new Timestamp((new Date()).getTime()));
			appriseSender.setStsToNew();

		} else {

			appriseSender.setSenderInfo(senderInfo);
			appriseSender.setContent(content);
			appriseSender.setSendTime(new Timestamp((new Date()).getTime()));

		}
		BOAppriseMemberEngine.save(appriseSender);
	}

	public void saveAppriseMember(String appriseEmp, String assistEmp,
			String workflowId, int lastOperatorId, String content,
			String senderInfo) throws Exception {

		savaApprisePrime(lastOperatorId, workflowId, content, senderInfo);

		// 知会类型
		if (appriseEmp != null && !appriseEmp.equals("")) {
			appriseEmp = appriseEmp.replace(";", ",");
			int[] operatorIds = string2Ints(appriseEmp);

			if (operatorIds == null || operatorIds.length == 0) {
				return;
			}
			int length = operatorIds.length;
			IBOAppriseMemberValue[] appriseMembers = new IBOAppriseMemberValue[length];

			for (int i = 0; i < length; ++i) {

				IBOAppriseMemberValue appriseSender = getAppriseMember(
						operatorIds[i], workflowId);

				// System.out.println(appriseSender.getLastOperatorId());
				if (appriseSender == null
						|| appriseSender.getLastOperatorId() == 0) {

					IBOAppriseMemberValue tmp = new BOAppriseMemberBean();
					tmp.setId(BOAppriseMemberEngine.getNewId().intValue());
					tmp.setOperatorId(operatorIds[i]);
					tmp.setWorkflowId(workflowId);
					tmp.setLastOperatorId(lastOperatorId);
					tmp.setAppriseFlag("0");
					tmp.setIsReaded("0");
					tmp.setStsToNew();
					appriseMembers[i] = tmp;
				} else {
					appriseMembers[i] = appriseSender;
				}
			}
			BOAppriseMemberEngine.save(appriseMembers);
		}
		// 协办类型
		if (assistEmp != null && !assistEmp.equals("")) {

			assistEmp = assistEmp.replace(";", ",");
			int[] operatorIds = string2Ints(assistEmp);

			if (operatorIds == null || operatorIds.length == 0) {
				return;
			}
			int length = operatorIds.length;
			IBOAppriseMemberValue[] appriseMembers = new IBOAppriseMemberValue[length];

			for (int i = 0; i < length; ++i) {

				IBOAppriseMemberValue appriseSender = getAppriseMember(
						operatorIds[i], workflowId);

				if (appriseSender == null
						|| appriseSender.getLastOperatorId() == 0) {

					IBOAppriseMemberValue tmp = new BOAppriseMemberBean();
					tmp.setId(BOAppriseMemberEngine.getNewId().intValue());
					tmp.setOperatorId(operatorIds[i]);
					tmp.setWorkflowId(workflowId);
					tmp.setLastOperatorId(lastOperatorId);
					tmp.setAppriseFlag("1");
					tmp.setIsReaded("2");
					tmp.setStsToNew();
					appriseMembers[i] = tmp;
				} else {
					appriseMembers[i] = appriseSender;
				}
			}
			BOAppriseMemberEngine.save(appriseMembers);

		}
	}

	public IBOAppriseMemberValue getAppriseMember(int operatorId,
			String workflowId) throws Exception {

		String condition = " " + IBOAppriseMemberValue.S_OperatorId + " = "
				+ operatorId + " and " + IBOAppriseMemberValue.S_WorkflowId
				+ " = " + "\'" + workflowId + "\'";
		IBOAppriseMemberValue[] appriseMember = BOAppriseMemberEngine.getBeans(
				condition, null);
		if (appriseMember == null || appriseMember.length < 1) {
			return null;
		}
		return appriseMember[0];
	}

	private int[] string2Ints(String str) {

		String[] strList = (str.trim()).split(",");

		if (strList != null && strList.length != 0) {
			int[] intList = new int[strList.length];
			for (int i = 0; i < strList.length; ++i) {
				intList[i] = Integer.parseInt(strList[i]);
			}
			return intList;

		} else {

			return null;
		}
	}

	public IBOAppriseMemberValue getAppriseSender(String operatorId,
			String workflowId) throws Exception {

		List<String> opeList = ((IProxyPriveDAO) ServiceFactory
				.getService(IProxyPriveDAO.class)).getAuthorStaff(operatorId);

		String opeStr = operatorId;

		if (null != opeList && 0 != opeList.size()) {
			for (String s : opeList) {
				opeStr += "," + s;
			}
		}

		String condition = " " + IBOAppriseMemberValue.S_OperatorId + " in ("
				+ opeStr + ") and " + IBOAppriseMemberValue.S_WorkflowId
				+ " = " + "\'" + workflowId + "\'";
		IBOAppriseMemberValue[] recepter = BOAppriseMemberEngine.getBeans(
				condition, null);

		if (recepter != null && recepter.length > 0) {

			String lastOperatorStr = "";
			for (IBOAppriseMemberValue tmp : recepter) {
				lastOperatorStr += "," + tmp.getLastOperatorId();
			}
			lastOperatorStr = lastOperatorStr.substring(1, lastOperatorStr
					.length());
			condition = " " + IBOAppriseMemberValue.S_OperatorId + " in ("
					+ lastOperatorStr + ") and "
					+ IBOAppriseMemberValue.S_WorkflowId + " = " + "\'"
					+ workflowId + "\'";
			// System.out.println(condition);
			IBOAppriseMemberValue[] sender = BOAppriseMemberEngine.getBeans(
					condition, null);
			if (sender != null && sender.length > 0) {
				return sender[0];
			}
		}
		return null;
	}

	public IBOAppriseTaskValue[] getAppriseTask(String operatorId)
			throws Exception {

		List<String> opeList = ((IProxyPriveDAO) ServiceFactory
				.getService(IProxyPriveDAO.class)).getAuthorStaff(operatorId);
		String opeStr = operatorId;

		if (null != opeList && 0 != opeList.size()) {
			for (String s : opeList) {
				opeStr += "," + s;
			}
		}
		String condition = " SELECT DISTINCT WORKFLOW_ID,SEND_TIME,WORKFLOW_OBJECT_TYPE,TASK_LABEL,TASK_ID, WF_LABEL,CREATE_DATE,ORGANIZE_NAME,STAFF_NAME,DEPART,APPLY_NAME,IS_READED,APPRISE_FLAG,READ_TIME,DEAL_TIME FROM ( "
				+ " SELECT T1.WORKFLOW_ID, T1.SEND_TIME, T1.WORKFLOW_OBJECT_TYPE,T1.TASK_LABEL,T1.TASK_ID,T1.WF_LABEL,T1.CREATE_DATE,T1.REGION_ID,T1.IS_READED,T1.APPRISE_FLAG,T1.READ_TIME,T1.DEAL_TIME,S1.ORGANIZE_NAME ,S2.STAFF_NAME,S2.ORGANIZE_NAME DEPART,S3.APPLY_NAME FROM ( "
				+ " SELECT D.WORKFLOW_ID WORKFLOW_ID, "
				+ " WORKFLOW_OBJECT_TYPE, "
				+ " TASK_LABEL, "
				+ " TASK_ID, "
				+ " WF_LABEL, "
				+ " T_CREATE_DATE, "
				+ " CREATE_DATE, "
				+ " SEND_TIME, "
				+ " CREATE_STAFF_ID, "
				+ " IS_READED, "
				+ " REGION_ID, "
				+ " APPRISE_FLAG "
				+ " FROM ( "
				+ " (SELECT DISTINCT S.SEND_TIME SEND_TIME,T.IS_READED,T.APPRISE_FLAG,T.WORKFLOW_ID WORKFLOW_ID "
				+ " FROM (SELECT DISTINCT * "
				+ " FROM HBSALE.SALE_APPRISE_MEMBER_T "
				+ " WHERE OPERATOR_ID IN ("
				+ opeStr
				+ " ) AND LAST_OPERATOR_ID <> 0) T, "
				+ " HBSALE.SALE_APPRISE_MEMBER_T S "
				+ " WHERE T.LAST_OPERATOR_ID = S.OPERATOR_ID AND T.WORKFLOW_ID=S.WORKFLOW_ID) SS "
				+ " LEFT JOIN "
				+ " (SELECT "
				+ " TASK.WORKFLOW_ID WORKFLOW_ID, "
				+ " TASK.LABEL TASK_LABEL, "
				+ " TASK.CREATE_DATE T_CREATE_DATE, "
				+ " WF.WORKFLOW_OBJECT_TYPE WORKFLOW_OBJECT_TYPE, "
				+ " WF.WORKFLOW_OBJECT_ID TASK_ID, "
				+ " WF.LABEL WF_LABEL, "
				+ " WF.CREATE_DATE CREATE_DATE, "
				+ " WF.CREATE_STAFF_ID CREATE_STAFF_ID, "
				+ " WF.REGION_ID REGION_ID "
				+ " FROM HBSALE.VM_TASK TASK,HBSALE.VM_WF WF WHERE TASK.WORKFLOW_ID=WF.WORKFLOW_ID AND task.TASK_TAG <>'autodecision'"
				+ " UNION ALL "
				+ " SELECT "
				+ " TASK.WORKFLOW_ID WORKFLOW_ID, "
				+ " TASK.LABEL TASK_LABEL, "
				+ " TASK.CREATE_DATE T_CREATE_DATE, "
				+ " WF.WORKFLOW_OBJECT_TYPE WORKFLOW_OBJECT_TYPE, "
				+ " WF.WORKFLOW_OBJECT_ID TASK_ID, "
				+ " WF.LABEL WF_LABEL, "
				+ " WF.CREATE_DATE CREATE_DATE, "
				+ " WF.CREATE_STAFF_ID CREATE_STAFF_ID, "
				+ " WF.REGION_ID REGION_ID "
				+ " FROM HBSALE.H_VM_TASK TASK,HBSALE.H_VM_WF WF WHERE TASK.WORKFLOW_ID=WF.WORKFLOW_ID AND task.TASK_TAG <>'autodecision') D "
				+ " ON D.WORKFLOW_ID=SS.WORKFLOW_ID ) "
				+ " WHERE T_CREATE_DATE IN (SELECT MAX (T_CREATE_DATE) "
				+ " FROM (SELECT SS.WORKFLOW_ID WORKFLOW_ID,T_CREATE_DATE "
				+ " FROM (SELECT DISTINCT "
				+ " T.WORKFLOW_ID WORKFLOW_ID "
				+ " FROM (SELECT DISTINCT * "
				+ " FROM HBSALE.SALE_APPRISE_MEMBER_T "
				+ " WHERE OPERATOR_ID IN ("
				+ opeStr
				+ " )AND LAST_OPERATOR_ID <> 0) T, "
				+ " HBSALE.SALE_APPRISE_MEMBER_T S "
				+ " WHERE T.LAST_OPERATOR_ID = S.OPERATOR_ID "
				+ " AND T.WORKFLOW_ID = S.WORKFLOW_ID) SS "
				+ " LEFT JOIN (SELECT TASK.WORKFLOW_ID WORKFLOW_ID, "
				+ " TASK.CREATE_DATE T_CREATE_DATE "
				+ " FROM HBSALE.VM_TASK TASK, HBSALE.VM_WF WF "
				+ " WHERE TASK.WORKFLOW_ID = WF.WORKFLOW_ID AND TASK.TASK_TAG <> 'autodecision'"
				+ " UNION ALL "
				+ " SELECT TASK.WORKFLOW_ID WORKFLOW_ID, "
				+ " TASK.CREATE_DATE T_CREATE_DATE "
				+ " FROM HBSALE.H_VM_TASK TASK, HBSALE.H_VM_WF WF "
				+ " WHERE TASK.WORKFLOW_ID = WF.WORKFLOW_ID AND TASK.TASK_TAG <> 'autodecision') D "
				+ " ON D.WORKFLOW_ID = SS.WORKFLOW_ID) E "
				+ " GROUP BY E.WORKFLOW_ID) ) T1 LEFT JOIN SECHB.SEC_ORGANIZE S1 ON TO_CHAR(T1.REGION_ID)=S1.ORGANIZE_ID "
				+ " LEFT JOIN (SELECT STA1.STAFF_ID,STA1.STAFF_NAME,ORG1.ORGANIZE_NAME FROM SECHB.SEC_STAFF STA1,SECHB.SEC_ORGANIZE ORG1 WHERE STA1.ORGANIZE_ID=TO_CHAR(ORG1.ORGANIZE_ID)) S2 "
				+ " ON T1.CREATE_STAFF_ID=S2.STAFF_ID "
				+ " LEFT JOIN (SELECT ID RECORDID, "
				+ " APPLY_NAME "
				+ " FROM SALE_WEAPON_MAIN_T SW "
				+ " UNION ALL "
				+ " SELECT ORDER_ID RECORDID, "
				+ " ORDER_NAME APPLY_NAME "
				+ " FROM SALE_ORDER_T SM "
				+ " UNION ALL "
				+ " SELECT MAIN_ID RECORDID, "
				+ " REAMRK_1 APPLY_NAME "
				+ " FROM CHARGE_MAIN_T SM"
				+ " UNION ALL "
				+ " SELECT ACCESS_ID RECORDID,APPLY_NAME APPLY_NAME FROM ACCESS_CHANGE_T "
				+ " UNION ALL "
				+ " SELECT BUSI_ID RECORDID,APPLY_NAME APPLY_NAME FROM BUSI_CHANGE_T"
				+ " UNION ALL "
				+ " SELECT ID RECORDID, "
				+ " APPLY_NAME "
				+ " FROM SALE_BATCH_PRESTORE_T SM "
				+ " UNION ALL "
				+ " SELECT MAINID RECORDID, "
				+ " APPLY_NAME "
				+ " FROM stop_selling_main_t SM "
				+ " UNION ALL "
				+ " SELECT COMPLAINS_ID RECORDID, "
				+ " APPLY_NAME "
				+ " FROM ORDER_COMPLAINS_T SM "
				+ " ) S3 ON T1.TASK_ID=S3.RECORDID) "
				+ " ORDER BY SEND_TIME DESC";
		/*
		 * for (int i = 0; i < appriseMember.length; ++i) {
		 * 
		 * String workflowId = appriseMember[i].getWorkflowId(); String
		 * condition = " 1=1 and workflow_id='" + workflowId +
		 * "' order by create_date desc fetch first 1 rows only";
		 * 
		 * IBOAppriseTaskValue[] tmp = BOAppriseTaskEngine.getBeans( condition,
		 * null);
		 * 
		 * if (tmp != null && tmp.length > 0) { curTask.add(tmp[0]); } }
		 */

		// int length = curTask.size();
		return (BOAppriseTaskEngine.getBeansFromSql(condition, null));
	}

	public int getAppriseTaskCount(String operatorId) throws Exception {

		List<String> opeList = ((IProxyPriveDAO) ServiceFactory
				.getService(IProxyPriveDAO.class)).getAuthorStaff(operatorId);

		String opeStr = operatorId;

		if (null != opeList && 0 != opeList.size()) {
			for (String s : opeList) {
				opeStr += "," + s;
			}
		}

		String condition = " " + IBOAppriseMemberValue.S_OperatorId + " in ("
				+ opeStr + ") and " + IBOAppriseMemberValue.S_LastOperatorId
				+ " <> 0 ";

		return BOAppriseMemberEngine.getBeansCount(condition, null);
	}

	private IBOAppriseMemberValue[] getAppriseMemberByOpeId(String operatorId)
			throws Exception {

		List<String> opeList = ((IProxyPriveDAO) ServiceFactory
				.getService(IProxyPriveDAO.class)).getAuthorStaff(operatorId);

		String opeStr = operatorId;

		if (null != opeList && 0 != opeList.size()) {
			for (String s : opeList) {
				opeStr += "," + s;
			}
		}

		String condition = "SELECT DISTINCT * " + "FROM (SELECT DISTINCT * "
				+ "FROM HBSALE.SALE_APPRISE_MEMBER_T "
				+ "WHERE OPERATOR_ID IN (" + opeStr
				+ ") AND LAST_OPERATOR_ID <> 0) T ";
		/*
		 * String condition = " " + IBOAppriseMemberValue.S_OperatorId + " in ("
		 * + opeStr + ") and " + IBOAppriseMemberValue.S_LastOperatorId +
		 * " <> 0 ";
		 */

		return BOAppriseMemberEngine.getBeansFromSql(condition, null);
	}

	@Override
	// 状态从协办改为已办或未阅改为已阅
	public void changeAppriseSta(String operatorId, String markedRecord)
			throws Exception {
		String condition = " " + IBOAppriseMemberValue.S_Id + " in ("
				+ markedRecord + ")";
		IBOAppriseMemberValue[] changeStsRecord = BOAppriseMemberEngine
				.getBeans(condition, null);
		if (changeStsRecord != null && changeStsRecord.length > 0) {
			for (IBOAppriseMemberValue tmp : changeStsRecord) {
				// 未阅改为已阅
				if (tmp.getAppriseFlag().equals("0")
						|| tmp.getAppriseFlag().equals("2")) {
					tmp.setIsReaded("1");
				}
				// 状态从协办改为已办
				else if (tmp.getAppriseFlag().equals("1")) {
					tmp.setIsReaded("3");
				} else {
					return;
				}
				tmp.setDealTime(new Timestamp((new Date()).getTime()));
			}
		}
		BOAppriseMemberEngine.save(changeStsRecord);
	}

	@Override
	// 查询所有知会过来的工单，包含代理人的
	public IBOAppriseTaskValue[] getAppriseTask(String operatorId,
			String taskId, String applyName, String applyPerson,
			String organizeName, String fromTime, String toTime,
			String readSts, String appriseSts, int startIndex, int endIndex)
			throws Exception {

		// 获取所有的代理人的操作员id
		List<String> opeList = ((IProxyPriveDAO) ServiceFactory
				.getService(IProxyPriveDAO.class)).getAuthorStaff(operatorId);
		String opeStr = operatorId;

		if (null != opeList && 0 != opeList.size()) {
			for (String s : opeList) {
				opeStr += "," + s;
			}
		}
		String appendCondition = " WHERE 1=1 ";
		if (null != organizeName && !organizeName.equals("")) {
			appendCondition += " AND ORGANIZE_NAME like " + "'%" + organizeName
					+ "%'";
		}
		if (null != taskId && !taskId.equals("")) {
			appendCondition += " AND TASK_ID = " + "'" + taskId + "'";
		}
		if (null != applyName && !applyName.equals("")) {
			appendCondition += " AND APPLY_NAME like " + "'%" + applyName
					+ "%'";
		}
		if (null != applyPerson && !applyPerson.equals("")) {
			appendCondition += " AND STAFF_NAME like " + "'%" + applyPerson
					+ "%'";
		}
		if (null != fromTime && !fromTime.equals("")) {
			appendCondition += " AND SEND_TIME > " + "'" + fromTime + "'";
		}
		if (null != toTime && !toTime.equals("")) {
			appendCondition += " AND SEND_TIME < " + "'" + toTime + "'";
		}
		if (null != readSts && !readSts.equals("")) {
			appendCondition += " AND IS_READED= " + readSts;
		}
		if (null != appriseSts && !appriseSts.equals("")) {
			appendCondition += " AND APPRISE_FLAG= " + appriseSts;
		}
		String condition = "SELECT DISTINCT ID AID,WORKFLOW_ID,SEND_TIME,WORKFLOW_OBJECT_TYPE,TASK_LABEL,TASK_ID, WF_LABEL,CREATE_DATE,ORGANIZE_NAME,STAFF_NAME,DEPART,APPLY_NAME,IS_READED,APPRISE_FLAG,READ_TIME,DEAL_TIME FROM ("
				+ " SELECT ROWNUMBER () OVER (ORDER BY SEND_TIME DESC) AS ROW_INDEX,ID,WORKFLOW_ID,SEND_TIME,WORKFLOW_OBJECT_TYPE,TASK_LABEL,TASK_ID, WF_LABEL,CREATE_DATE,ORGANIZE_NAME,STAFF_NAME,DEPART,APPLY_NAME,IS_READED,APPRISE_FLAG,READ_TIME,DEAL_TIME FROM ( "
				+ " SELECT T1.WORKFLOW_ID, T1.SEND_TIME, T1.ID, T1.WORKFLOW_OBJECT_TYPE,T1.TASK_LABEL,T1.TASK_ID,T1.WF_LABEL,T1.CREATE_DATE,T1.REGION_ID,T1.IS_READED,T1.APPRISE_FLAG,T1.READ_TIME,T1.DEAL_TIME,S1.ORGANIZE_NAME,S2.STAFF_NAME,S2.ORGANIZE_NAME DEPART,S3.APPLY_NAME FROM ( "
				+ " SELECT D.WORKFLOW_ID WORKFLOW_ID, "
				+ " WORKFLOW_OBJECT_TYPE, "
				+ " TASK_LABEL, "
				+ " TASK_ID, "
				+ " WF_LABEL, "
				+ " T_CREATE_DATE, "
				+ " CREATE_DATE, "
				+ " SEND_TIME, "
				+ " CREATE_STAFF_ID, "
				+ " ID, "
				+ " IS_READED, "
				+ " REGION_ID, "
				+ " APPRISE_FLAG, "
				+ " READ_TIME, "
				+ " DEAL_TIME "
				+ " FROM ( "
				+ " (SELECT DISTINCT S.SEND_TIME SEND_TIME,T.ID, T.IS_READED,T.APPRISE_FLAG,T.READ_TIME,T.DEAL_TIME,T.WORKFLOW_ID WORKFLOW_ID "
				+ " FROM (SELECT DISTINCT * "
				+ " FROM HBSALE.SALE_APPRISE_MEMBER_T "
				+ " WHERE OPERATOR_ID IN ("
				+ opeStr
				+ " ) AND LAST_OPERATOR_ID <> 0) T, "
				+ " HBSALE.SALE_APPRISE_MEMBER_T S "
				+ " WHERE T.LAST_OPERATOR_ID = S.OPERATOR_ID AND T.WORKFLOW_ID=S.WORKFLOW_ID AND S.SEND_TIME IS NOT NULL) SS "
				+ " LEFT JOIN "
				+ " (SELECT "
				+ " TASK.WORKFLOW_ID WORKFLOW_ID, "
				+ " TASK.LABEL TASK_LABEL, "
				+ " TASK.CREATE_DATE T_CREATE_DATE, "
				+ " WF.WORKFLOW_OBJECT_TYPE WORKFLOW_OBJECT_TYPE, "
				+ " WF.WORKFLOW_OBJECT_ID TASK_ID, "
				+ " WF.LABEL WF_LABEL, "
				+ " WF.CREATE_DATE CREATE_DATE, "
				+ " WF.CREATE_STAFF_ID CREATE_STAFF_ID, "
				+ " WF.REGION_ID REGION_ID "
				+ " FROM HBSALE.VM_TASK TASK,HBSALE.VM_WF WF WHERE TASK.WORKFLOW_ID=WF.WORKFLOW_ID AND task.TASK_TAG <>'autodecision' "
				+ " UNION ALL "
				+ " SELECT "
				+ " TASK.WORKFLOW_ID WORKFLOW_ID, "
				+ " TASK.LABEL TASK_LABEL, "
				+ " TASK.CREATE_DATE T_CREATE_DATE, "
				+ " WF.WORKFLOW_OBJECT_TYPE WORKFLOW_OBJECT_TYPE, "
				+ " WF.WORKFLOW_OBJECT_ID TASK_ID, "
				+ " WF.LABEL WF_LABEL, "
				+ " WF.CREATE_DATE CREATE_DATE, "
				+ " WF.CREATE_STAFF_ID CREATE_STAFF_ID, "
				+ " WF.REGION_ID REGION_ID "
				+ " FROM HBSALE.H_VM_TASK TASK,HBSALE.H_VM_WF WF WHERE TASK.WORKFLOW_ID=WF.WORKFLOW_ID AND task.TASK_TAG <>'autodecision') D "
				+ " ON D.WORKFLOW_ID=SS.WORKFLOW_ID ) "
				+ " WHERE T_CREATE_DATE IN (SELECT MAX (T_CREATE_DATE) "
				+ " FROM (SELECT SS.WORKFLOW_ID WORKFLOW_ID,T_CREATE_DATE "
				+ " FROM (SELECT DISTINCT "
				+ " T.WORKFLOW_ID WORKFLOW_ID "
				+ " FROM (SELECT DISTINCT * "
				+ " FROM HBSALE.SALE_APPRISE_MEMBER_T "
				+ " WHERE OPERATOR_ID IN ("
				+ opeStr
				+ " )AND LAST_OPERATOR_ID <> 0) T, "
				+ " HBSALE.SALE_APPRISE_MEMBER_T S "
				+ " WHERE T.LAST_OPERATOR_ID = S.OPERATOR_ID "
				+ " AND T.WORKFLOW_ID = S.WORKFLOW_ID) SS "
				+ " LEFT JOIN (SELECT TASK.WORKFLOW_ID WORKFLOW_ID, "
				+ " TASK.CREATE_DATE T_CREATE_DATE "
				+ " FROM HBSALE.VM_TASK TASK, HBSALE.VM_WF WF "
				+ " WHERE TASK.WORKFLOW_ID = WF.WORKFLOW_ID AND task.TASK_TAG <>'autodecision' "
				+ " UNION ALL "
				+ " SELECT TASK.WORKFLOW_ID WORKFLOW_ID, "
				+ " TASK.CREATE_DATE T_CREATE_DATE "
				+ " FROM HBSALE.H_VM_TASK TASK, HBSALE.H_VM_WF WF "
				+ " WHERE TASK.WORKFLOW_ID = WF.WORKFLOW_ID AND task.TASK_TAG <>'autodecision') D "
				+ " ON D.WORKFLOW_ID = SS.WORKFLOW_ID) E "
				+ " GROUP BY E.WORKFLOW_ID) ) T1 LEFT JOIN SECHB.SEC_ORGANIZE S1 ON TO_CHAR(T1.REGION_ID)=S1.ORGANIZE_ID "
				+ " LEFT JOIN (SELECT STA1.STAFF_ID,OPE1.OPERATOR_ID,STA1.STAFF_NAME,ORG1.ORGANIZE_NAME FROM SECHB.SEC_STAFF STA1,SECHB.SEC_ORGANIZE ORG1,SECHB.SEC_OPERATOR OPE1 WHERE STA1.ORGANIZE_ID=TO_CHAR(ORG1.ORGANIZE_ID) AND OPE1.STAFF_ID=STA1.STAFF_ID) S2 "
				+ " ON T1.CREATE_STAFF_ID=S2.OPERATOR_ID "
				+ " LEFT JOIN (SELECT ID RECORDID, "
				+ " APPLY_NAME "
				+ " FROM SALE_WEAPON_MAIN_T SW "
				+ " UNION ALL "
				+ " SELECT ORDER_ID RECORDID, "
				+ " ORDER_NAME APPLY_NAME "
				+ " FROM SALE_ORDER_T SM "
				+ " UNION ALL "
				+ " SELECT MAIN_ID RECORDID, "
				+ " REAMRK_1 APPLY_NAME "
				+ " FROM CHARGE_MAIN_T SM"
				+ " UNION ALL "
				+ " SELECT ACCESS_ID RECORDID,APPLY_NAME APPLY_NAME FROM ACCESS_CHANGE_T "
				+ " UNION ALL "
				+ " SELECT BUSI_ID RECORDID,APPLY_NAME APPLY_NAME FROM BUSI_CHANGE_T"
				+ " UNION ALL "
				+ " SELECT ID RECORDID, "
				+ " APPLY_NAME "
				+ " FROM SALE_BATCH_PRESTORE_T SM "
				+ " UNION ALL "
				+ " SELECT MAINID RECORDID, "
				+ " APPLY_NAME "
				+ " FROM stop_selling_main_t SM "
				+ " UNION ALL "
				+ " SELECT COMPLAINS_ID RECORDID, "
				+ " APPLY_NAME "
				+ " FROM ORDER_COMPLAINS_T SM "
				+ " ) S3 ON T1.TASK_ID=S3.RECORDID) ";
		condition += appendCondition + " ) ";
		if (startIndex < endIndex) {
			condition += " where ROW_INDEX>=" + startIndex + " and ROW_INDEX<="
					+ endIndex;
		}
		condition += " ORDER BY SEND_TIME DESC";
		return (BOAppriseTaskEngine.getBeansFromSql(condition, null));
	}

	@Override
	// 查询所有知会过来的工单条数，包含代理认的
	public int getAppriseTaskCount(String operatorId, String taskId,
			String applyName, String applyPerson, String organizeName,
			String fromTime, String toTime, String readSts, String appriseSts)
			throws Exception {
		/*
		 * List<String> opeList = ((IProxyPriveDAO) ServiceFactory
		 * .getService(IProxyPriveDAO.class)).getAuthorStaff(operatorId); String
		 * opeStr = operatorId;
		 * 
		 * if (null != opeList && 0 != opeList.size()) { for (String s :
		 * opeList) { opeStr += "," + s; } } String appendCondition =
		 * " WHERE 1=1 "; if (null != fromTime && !fromTime.equals("")) {
		 * appendCondition += " AND SEND_TIME > " + "'" + fromTime + "'"; } if
		 * (null != toTime && !toTime.equals("")) { appendCondition +=
		 * " AND SEND_TIME < " + "'" + toTime + "'"; } if (null != readSts &&
		 * !readSts.equals("")) { appendCondition += " AND IS_READED= " +
		 * readSts; } if (null != appriseSts && !appriseSts.equals("")) {
		 * appendCondition += " AND APPRISE_FLAG= " + appriseSts; } String
		 * condition = " SELECT DISTINCT * FROM ( " +
		 * " SELECT DISTINCT S.ID,S.OPERATOR_ID,S.LAST_OPERATOR_ID,S.SENDER_INFO,S.CONTENT,S.REMARK1,S.REMARK2,S.REMARK3,S.REMARK4,S.SEND_TIME SEND_TIME,T.IS_READED IS_READED,T.APPRISE_FLAG APPRISE_FLAG,T.WORKFLOW_ID WORKFLOW_ID "
		 * + " FROM (SELECT DISTINCT * " + " FROM HBSALE.SALE_APPRISE_MEMBER_T "
		 * + " WHERE OPERATOR_ID IN (" + opeStr +
		 * ") AND LAST_OPERATOR_ID <> 0) T, " +
		 * " HBSALE.SALE_APPRISE_MEMBER_T S " +
		 * " WHERE T.LAST_OPERATOR_ID = S.OPERATOR_ID AND T.WORKFLOW_ID=S.WORKFLOW_ID) "
		 * ; condition += appendCondition; return
		 * BOAppriseMemberEngine.getBeansFromSql(condition, null).length;
		 */
		return getAppriseTask(operatorId, taskId, applyName, applyPerson,
				organizeName, fromTime, toTime, readSts, appriseSts, 1, 1000).length;
	}

	@Override
	public IBOAppriseMarkValue[] getAppriseMark(String workflowId,
			int startIndex, int endIndex) throws Exception {

		String condition = " SELECT T3.STAFF_NAME,T3.DEPART,T3.ORGANIZE_ID,T3.SEND_TIME,T3.IS_READED,T3.APPRISE_FLAG,T3.READ_TIME,T3.DEAL_TIME,ORG2.ORGANIZE_NAME FROM (	 "
				+ " SELECT ROWNUMBER () OVER () AS ROW_INDEX,T2.STAFF_NAME,T2.ORGANIZE_NAME DEPART,T2.ORGANIZE_ID,T1.SEND_TIME,T1.IS_READED,T1.APPRISE_FLAG,T1.READ_TIME,T1.DEAL_TIME FROM "
				+ " (SELECT DISTINCT S.SEND_TIME SEND_TIME,A.WORKFLOW_ID WORKFLOW_ID,A.OPERATOR_ID,A.IS_READED,A.APPRISE_FLAG,A.READ_TIME,A.DEAL_TIME "
				+ " FROM (SELECT DISTINCT * "
				+ " FROM HBSALE.SALE_APPRISE_MEMBER_T "
				+ " WHERE WORKFLOW_ID= '"
				+ workflowId
				+ "' AND LAST_OPERATOR_ID <> 0) A, "
				+ " HBSALE.SALE_APPRISE_MEMBER_T S "
				+ " WHERE A.LAST_OPERATOR_ID = S.OPERATOR_ID AND A.WORKFLOW_ID=S.WORKFLOW_ID AND S.SEND_TIME IS NOT NULL) T1 "
				+ " LEFT JOIN ( SELECT STA1.ORGANIZE_ID, "
				+ " STA1.STAFF_NAME, "
				+ " OPE1.OPERATOR_ID, "
				+ " ORG1.ORGANIZE_NAME "
				+ " FROM SECHB.SEC_STAFF STA1, "
				+ " SECHB.SEC_ORGANIZE ORG1, "
				+ " SECHB.SEC_OPERATOR OPE1 "
				+ " WHERE STA1.ORGANIZE_ID = TO_CHAR (ORG1.ORGANIZE_ID) "
				+ " AND OPE1.STAFF_ID = STA1.STAFF_ID ) T2 ON T1.OPERATOR_ID=T2.OPERATOR_ID) T3,SECHB.SEC_ORGANIZE ORG2 WHERE SUBSTR (T3.ORGANIZE_ID, 1, 2)=TO_CHAR(ORG2.ORGANIZE_ID) ";

		if (startIndex < endIndex) {
			condition += " AND ROW_INDEX>=" + startIndex + " and ROW_INDEX<="
					+ endIndex;
		}
		condition += " GROUP BY T3.APPRISE_FLAG,T3.STAFF_NAME,T3.DEPART,T3.ORGANIZE_ID,T3.SEND_TIME,T3.IS_READED,T3.READ_TIME,T3.DEAL_TIME,ORG2.ORGANIZE_NAME "
				+ "ORDER BY T3.APPRISE_FLAG,T3.SEND_TIME";
		return BOAppriseMarkEngine.getBeansFromSql(condition, null);
	}

	@Override
	public int getAppriseMarkCount(String workflowId) throws Exception {

		String condition = " " + IBOAppriseMemberValue.S_WorkflowId + " = '"
				+ workflowId + "' and "
				+ IBOAppriseMemberValue.S_LastOperatorId + " <> 0 ";
		return BOAppriseMemberEngine.getBeansCount(condition, null);
	}

	public String[] getObjectTypeAndId(String workflowId) throws Exception {

		String[] idAndType = new String[2];
		IBOVmWFValue vmValue = ((IVmWorkflowDAO) ServiceFactory
				.getService(IVmWorkflowDAO.class))
				.getVmWorkflowBeanbyId(workflowId);
		if (null != vmValue) {
			idAndType[0] = vmValue.getWorkflowObjectId();
			idAndType[1] = vmValue.getWorkflowObjectType();

		} else {
			IBOHVmWFValue hvmValue = ((IVmWorkflowDAO) ServiceFactory
					.getService(IVmWorkflowDAO.class))
					.getHisVmWorkflowBeanbyId(workflowId);
			idAndType[0] = hvmValue.getWorkflowObjectId();
			idAndType[1] = hvmValue.getWorkflowObjectType();
		}
		return idAndType;
	}

	@Override
	public void savePuplishMember(String publishEmp, String workflowId,
			int lastOperatorId, String content, String senderInfo)
			throws Exception {

		savaApprisePrime(lastOperatorId, workflowId, content, senderInfo);

		if (publishEmp != null && !publishEmp.equals("")) {
			publishEmp = publishEmp.replace(";", ",");
			int[] operatorIds = string2Ints(publishEmp);

			if (operatorIds == null || operatorIds.length == 0) {
				return;
			}
			int length = operatorIds.length;
			IBOAppriseMemberValue[] appriseMembers = new IBOAppriseMemberValue[length];

			for (int i = 0; i < length; ++i) {

				IBOAppriseMemberValue appriseSender = getAppriseMember(
						operatorIds[i], workflowId);

				// System.out.println(appriseSender.getLastOperatorId());
				if (appriseSender == null
						|| appriseSender.getLastOperatorId() == 0) {

					IBOAppriseMemberValue tmp = new BOAppriseMemberBean();
					tmp.setId(BOAppriseMemberEngine.getNewId().intValue());
					tmp.setOperatorId(operatorIds[i]);
					tmp.setWorkflowId(workflowId);
					tmp.setLastOperatorId(lastOperatorId);
					tmp.setAppriseFlag("2");
					tmp.setIsReaded("0");
					tmp.setStsToNew();
					appriseMembers[i] = tmp;
				} else {
					appriseMembers[i] = appriseSender;
				}
			}
			BOAppriseMemberEngine.save(appriseMembers);
		}
	}

	@Override
	public String autoSendApprise(String workflowId, int lastOperatorId,
			String content, String senderInfo) throws Exception {

		String publishEmp = "";
		IBOAppriseOrgValue appriseVal = getAppriseOrg(workflowId);
		if(appriseVal == null) {
			return "";
		}
		String[] orgIds = appriseVal.getOrgStr().split(",");
		if (orgIds == null || orgIds.length < 1)
			return "";
		String orgStr = "00";
		for (int i = 0; i < orgIds.length; ++i) {
			if (orgIds[i].substring(0, 2).equals("10")) {
				orgStr += "," + orgIds[i].substring(0, 4);
			} else {
				orgStr += "," + orgIds[i].substring(0, 2);
			}
		}
		try {
			Connection conn = ServiceManager.getSession().getConnection();
			String sql = "SELECT operator_id operatorId FROM (SELECT s1.operator_id, CASE WHEN substr (s2.ORGANIZE_ID, 1, 2) = 10 THEN substr (s2.ORGANIZE_ID, 1, 4) ELSE substr (s2.ORGANIZE_ID, 1, 2) END org_id FROM sechb.sec_operator s1, sechb.sec_staff s2 WHERE s1.operator_id IN (SELECT operator_id FROM sechb.sec_op_station WHERE op_station_id IN (SELECT op_station_id FROM sechb.sec_author WHERE role_id IN (103419, 102210, 101425) AND STATE = 1)) AND s1.STAFF_ID = s2.staff_id AND s1.STATE = 1 AND s2.STATE = 1) where org_id IN ("
					+ orgStr + ")";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String operatorId = rs.getString("operatorId");
				if (null != operatorId && !"".equals(operatorId)) {
					if (publishEmp.equals("")) {
						publishEmp = operatorId;
					} else {
						publishEmp += "," + operatorId;
					}
				}
			}
			System.out.println(sql + ":" + publishEmp);
			savePuplishMember(publishEmp, workflowId, lastOperatorId, content,
					senderInfo);
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return publishEmp.replace(",", ";");
	}
}
