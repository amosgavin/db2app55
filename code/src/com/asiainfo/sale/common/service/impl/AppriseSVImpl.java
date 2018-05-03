package com.asiainfo.sale.common.service.impl;

import java.net.URLDecoder;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.comframe.vm.workflow.dao.interfaces.IVmWorkflowDAO;
import com.ai.comframe.vm.workflow.ivalues.IBOHVmWFValue;
import com.ai.comframe.vm.workflow.ivalues.IBOVmWFValue;
import com.asiainfo.sale.common.dao.interfaces.IAppriseDAO;
import com.asiainfo.sale.common.ivalues.IBOAppriseMarkValue;
import com.asiainfo.sale.common.ivalues.IBOAppriseMemberValue;
import com.asiainfo.sale.common.ivalues.IBOAppriseOrgValue;
import com.asiainfo.sale.common.ivalues.IBOAppriseTaskValue;
import com.asiainfo.sale.common.service.interfaces.IAppriseSV;

public class AppriseSVImpl implements IAppriseSV {

	public IBOAppriseOrgValue getAppriseOrg(String workflowId) throws Exception {

		return ((IAppriseDAO) ServiceFactory.getService(IAppriseDAO.class))
				.getAppriseOrg(workflowId);
	}

	public void modifyAppriseOrg(String orgList, String workflowId)
			throws Exception {

		((IAppriseDAO) ServiceFactory.getService(IAppriseDAO.class))
				.modifyAppriseOrg(orgList, workflowId);
	}

	public void saveAppriseOrg(String orgList, String workflowId)
			throws Exception {

		((IAppriseDAO) ServiceFactory.getService(IAppriseDAO.class))
				.saveAppriseOrg(orgList, workflowId);
	}

	public IBOAppriseMemberValue getAppriseMember(int operatorId,
			String workflowId) throws Exception {

		return ((IAppriseDAO) ServiceFactory.getService(IAppriseDAO.class))
				.getAppriseMember(operatorId, workflowId);
	}

	public void savaApprisePrime(int operatorId, String workflowId,
			String content, String senderInfo) throws Exception {

		((IAppriseDAO) ServiceFactory.getService(IAppriseDAO.class))
				.savaApprisePrime(operatorId, workflowId, content, senderInfo);
	}

	public void saveAppriseMember(String appriseEmp, String assistEmp,
			String workflowId, int lastOperatorId, String content,
			String senderInfo) throws Exception {

		((IAppriseDAO) ServiceFactory.getService(IAppriseDAO.class))
				.saveAppriseMember(appriseEmp, assistEmp, workflowId,
						lastOperatorId, content, senderInfo);

	}

	public IBOAppriseMemberValue getAppriseSender(String operatorId,
			String workflowId) throws Exception {

		return ((IAppriseDAO) ServiceFactory.getService(IAppriseDAO.class))
				.getAppriseSender(operatorId, workflowId);
	}

	public int getAppriseTaskCount(String operatorId) throws Exception {

		return ((IAppriseDAO) ServiceFactory.getService(IAppriseDAO.class))
				.getAppriseTaskCount(operatorId);
	}

	@Override
	public void changeAppriseSta(String operatorId, String markedRecord)
			throws Exception {

		((IAppriseDAO) ServiceFactory.getService(IAppriseDAO.class))
				.changeAppriseSta(operatorId, markedRecord);
	}

	@Override
	public IBOAppriseTaskValue[] getAppriseTask(String operatorId,
			String taskId, String applyName, String applyPerson,
			String organizeName, String fromTime, String toTime,
			String readSts, String appriseSts, int startIndex, int endIndex)
			throws Exception {

		if (null != applyPerson) {
			applyPerson = URLDecoder.decode(applyPerson, "utf-8");
		}
		if (null != applyName) {
			applyName = URLDecoder.decode(applyName, "utf-8");
		}
		if (null != organizeName) {
			organizeName = URLDecoder.decode(organizeName, "utf-8");
		}
		return ((IAppriseDAO) ServiceFactory.getService(IAppriseDAO.class))
				.getAppriseTask(operatorId, taskId, applyName, applyPerson,
						organizeName, fromTime, toTime, readSts, appriseSts,
						startIndex, endIndex);
	}

	@Override
	public int getAppriseTaskCount(String operatorId, String taskId,
			String applyName, String applyPerson, String organizeName,
			String fromTime, String toTime, String readSts, String appriseSts)
			throws Exception {

		return ((IAppriseDAO) ServiceFactory.getService(IAppriseDAO.class))
				.getAppriseTaskCount(operatorId, taskId, applyName,
						applyPerson, organizeName, fromTime, toTime, readSts,
						appriseSts);
	}

	@Override
	public IBOAppriseMarkValue[] getAppriseMark(String workflowId,
			int startIndex, int endIndex) throws Exception {
		return ((IAppriseDAO) ServiceFactory.getService(IAppriseDAO.class))
				.getAppriseMark(workflowId, startIndex, endIndex);
	}

	@Override
	public int getAppriseMarkCount(String workflowId) throws Exception {

		return ((IAppriseDAO) ServiceFactory.getService(IAppriseDAO.class))
				.getAppriseMarkCount(workflowId);
	}

	public String[] getObjectTypeAndId(String workflowId) throws Exception {

		return ((IAppriseDAO) ServiceFactory.getService(IAppriseDAO.class))
				.getObjectTypeAndId(workflowId);
	}

	@Override
	public void savePuplishMember(String publishEmp, String workflowId,
			int lastOperatorId, String content, String senderInfo)
			throws Exception {

		((IAppriseDAO) ServiceFactory.getService(IAppriseDAO.class))
				.savePuplishMember(publishEmp, workflowId, lastOperatorId,
						content, senderInfo);
	}

	@Override
	public String autoSendApprise(String workflowId, int lastOperatorId,
			String content, String senderInfo) throws Exception {

		return ((IAppriseDAO) ServiceFactory.getService(IAppriseDAO.class))
				.autoSendApprise(workflowId, lastOperatorId, content,
						senderInfo);
	}
}
