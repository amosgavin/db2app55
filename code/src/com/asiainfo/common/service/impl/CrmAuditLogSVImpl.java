package com.asiainfo.common.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.common.dao.interfaces.ICrmAuditLogDAO;
import com.asiainfo.common.ivalues.IBOCrmAuditLogValue;
import com.asiainfo.common.service.interfaces.ICrmAuditLogSV;

public class CrmAuditLogSVImpl implements ICrmAuditLogSV {

	@Override
	public void saveAuditLog(IBOCrmAuditLogValue boValue) throws Exception {

		((ICrmAuditLogDAO) ServiceFactory.getService(ICrmAuditLogDAO.class))
				.saveAuditLog(boValue);
	}

}
