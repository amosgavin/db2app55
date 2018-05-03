package com.asiainfo.common.service.interfaces;

import com.asiainfo.common.ivalues.IBOAuditInfoShowValue;

public interface IAuditInfoShowSV {

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

	public String getCurTaskTagByOrderId(String orderId) throws Exception,
			RuntimeException;
}
