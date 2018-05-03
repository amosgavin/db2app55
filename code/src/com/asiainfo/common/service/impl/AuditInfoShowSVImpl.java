package com.asiainfo.common.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.common.dao.interfaces.IAuditInfoShowDAO;
import com.asiainfo.common.ivalues.IBOAuditInfoShowValue;
import com.asiainfo.common.service.interfaces.IAuditInfoShowSV;
import com.asiainfo.task.bo.BOVmTaskBean;

public class AuditInfoShowSVImpl implements IAuditInfoShowSV {

	@Override
	public IBOAuditInfoShowValue[] getApproveInfoByWFId(String orderId,
			String workflowId) throws Exception, RuntimeException {

		return ((IAuditInfoShowDAO) ServiceFactory
				.getService(IAuditInfoShowDAO.class)).getApproveInfoByWFId(
				orderId, workflowId);
	}

	@Override
	public IBOAuditInfoShowValue[] getSignInfoByWFId(String orderId,
			String workflowId) throws Exception, RuntimeException {

		return ((IAuditInfoShowDAO) ServiceFactory
				.getService(IAuditInfoShowDAO.class)).getSignInfoByWFId(
				orderId, workflowId);
	}

	@Override
	public IBOAuditInfoShowValue getEstInfoByWFId(String orderId,
			String workflowId) throws Exception, RuntimeException {

		return ((IAuditInfoShowDAO) ServiceFactory
				.getService(IAuditInfoShowDAO.class)).getEstInfoByWFId(orderId,
				workflowId);
	}

	@Override
	public IBOAuditInfoShowValue[] getTestInfoByWFId(String orderId,
			String workflowId) throws Exception, RuntimeException {

		return ((IAuditInfoShowDAO) ServiceFactory
				.getService(IAuditInfoShowDAO.class)).getTestInfoByWFId(
				orderId, workflowId);
	}

	@Override
	public IBOAuditInfoShowValue[] getconfInfoByWFId(String orderId,
			String workflowId) throws Exception, RuntimeException {

		return ((IAuditInfoShowDAO) ServiceFactory
				.getService(IAuditInfoShowDAO.class)).getconfInfoByWFId(
				orderId, workflowId);
	}

	@Override
	public String getCurTaskTagByOrderId(String orderId) throws Exception,
			RuntimeException {

		BOVmTaskBean task = ((IAuditInfoShowDAO) ServiceFactory
				.getService(IAuditInfoShowDAO.class))
				.getCurVMTaskByOrderId(orderId);
		return task == null ? "" : task.getTaskTag();
	}

}
