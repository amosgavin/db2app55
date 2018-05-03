package com.asiainfo.common.dao.impl;

import com.asiainfo.common.bo.BOCrmAuditLogEngine;
import com.asiainfo.common.dao.interfaces.ICrmAuditLogDAO;
import com.asiainfo.common.ivalues.IBOCrmAuditLogValue;

public class CrmAuditLogDAOImpl implements ICrmAuditLogDAO {

	@Override
	public void saveAuditLog(IBOCrmAuditLogValue boValue) throws Exception {

		if (boValue.isNew()) {
			boValue.setId(BOCrmAuditLogEngine.getNewId().intValue());
		}
		BOCrmAuditLogEngine.save(boValue);
	}

}
