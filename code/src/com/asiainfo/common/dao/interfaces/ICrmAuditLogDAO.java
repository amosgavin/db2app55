package com.asiainfo.common.dao.interfaces;

import com.asiainfo.common.ivalues.IBOCrmAuditLogValue;

public interface ICrmAuditLogDAO {

	public void saveAuditLog(IBOCrmAuditLogValue boValue) throws Exception;

}
