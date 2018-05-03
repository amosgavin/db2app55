package com.asiainfo.common.service.interfaces;

import com.asiainfo.common.ivalues.IBOCrmAuditLogValue;

public interface ICrmAuditLogSV {

	public void saveAuditLog(IBOCrmAuditLogValue boValue) throws Exception;
}
