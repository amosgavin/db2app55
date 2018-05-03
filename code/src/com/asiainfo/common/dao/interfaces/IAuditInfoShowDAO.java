package com.asiainfo.common.dao.interfaces;

import com.asiainfo.common.ivalues.IBOAuditInfoShowValue;
import com.asiainfo.task.bo.BOVmTaskBean;

public interface IAuditInfoShowDAO {

	public IBOAuditInfoShowValue[] getApproveInfoByWFId(String orderId,
			String workflowId) throws Exception, RuntimeException;

	public IBOAuditInfoShowValue[] getSignInfoByWFId(String orderId,
			String workflowId) throws Exception, RuntimeException;

	public IBOAuditInfoShowValue getEstInfoByWFId(String orderId,
			String workflowId) throws Exception, RuntimeException;

	public IBOAuditInfoShowValue[] getconfInfoByWFId(String orderId,
			String workflowId) throws Exception, RuntimeException;

	public IBOAuditInfoShowValue[] getTestInfoByWFId(String orderId,
			String workflowId) throws Exception, RuntimeException;

	public BOVmTaskBean getCurVMTaskByOrderId(String orderId) throws Exception,
			RuntimeException;
}
