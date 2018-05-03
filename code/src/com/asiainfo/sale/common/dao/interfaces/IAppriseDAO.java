package com.asiainfo.sale.common.dao.interfaces;

import com.asiainfo.sale.common.ivalues.IBOAppriseMarkValue;
import com.asiainfo.sale.common.ivalues.IBOAppriseMemberValue;
import com.asiainfo.sale.common.ivalues.IBOAppriseOrgValue;
import com.asiainfo.sale.common.ivalues.IBOAppriseTaskValue;

public interface IAppriseDAO {

	public void saveAppriseOrg(String orgList, String workflowId)
			throws Exception;

	public IBOAppriseOrgValue getAppriseOrg(String workflowId) throws Exception;

	public IBOAppriseMemberValue getAppriseMember(int operatorId,
			String workflowId) throws Exception;

	public IBOAppriseMemberValue getAppriseSender(String operatorId,
			String workflowId) throws Exception;

	public IBOAppriseTaskValue[] getAppriseTask(String operatorId)
			throws Exception;

	public int getAppriseTaskCount(String operatorId) throws Exception;

	public void modifyAppriseOrg(String orgList, String workflowId)
			throws Exception;

	public void savaApprisePrime(int operatorId, String workflowId,
			String content, String senderInfo) throws Exception;

	public void saveAppriseMember(String appriseEmp, String assistEmp,
			String workflowId, int lastOperatorId, String content,
			String senderInfo) throws Exception;

	public void savePuplishMember(String publishEmp, String workflowId,
			int lastOperatorId, String content, String senderInfo)
			throws Exception;

	public void changeAppriseSta(String operatorId, String markedRecord)
			throws Exception;

	public IBOAppriseTaskValue[] getAppriseTask(String operatorId,
			String taskId, String applyName, String applyPerson,
			String organizeName, String fromTime, String toTime,
			String readSts, String appriseSts, int startIndex, int endIndex)
			throws Exception;

	public int getAppriseTaskCount(String operatorId, String taskId,
			String applyName, String applyPerson, String organizeName,
			String fromTime, String toTime, String readSts, String appriseSts)
			throws Exception;

	public IBOAppriseMarkValue[] getAppriseMark(String workflowId,
			int startIndex, int endIndex) throws Exception;

	public int getAppriseMarkCount(String workflowId) throws Exception;

	public String[] getObjectTypeAndId(String workflowId) throws Exception;

	public String autoSendApprise(String workflowId, int lastOperatorId,
			String content, String senderInfo) throws Exception;
}
