package com.asiainfo.charge.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.charge.dao.interfaces.IDynamicSumDAO;
import com.asiainfo.charge.ivalues.IBODynamicSumValue;
import com.asiainfo.charge.service.interfaces.IDynamicSumSV;

public class DynamicSumSVImpl implements IDynamicSumSV {

	@Override
	public IBODynamicSumValue getDynamicSumById(String id) throws Exception,
			RuntimeException {
		IDynamicSumDAO dynamicSumDAO=(IDynamicSumDAO) ServiceFactory
		.getService(IDynamicSumDAO.class);
		return dynamicSumDAO.getDynamicSumById(id);
	}

	@Override
	public String saveDynamicSum(IBODynamicSumValue dynamicSumValue)
			throws Exception, RuntimeException {
		IDynamicSumDAO dynamicSumDAO=(IDynamicSumDAO) ServiceFactory
		.getService(IDynamicSumDAO.class);
		return dynamicSumDAO.saveDynamicSum(dynamicSumValue);
	}

}
