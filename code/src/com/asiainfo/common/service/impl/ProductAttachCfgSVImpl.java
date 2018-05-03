package com.asiainfo.common.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.common.dao.interfaces.IProductAttachCfgDAO;
import com.asiainfo.common.ivalues.IBOProductAttachCfgValue;
import com.asiainfo.common.service.interfaces.IProductAttachCfgSV;

public class ProductAttachCfgSVImpl implements IProductAttachCfgSV {

	@Override
	public IBOProductAttachCfgValue getProductAttachCfgById(String id)
			throws Exception, RuntimeException {

		return ((IProductAttachCfgDAO) ServiceFactory
				.getService(IProductAttachCfgDAO.class))
				.getProductAttachCfgById(id);
	}

	@Override
	public int saveProductAttachCfg(String principle, String orgId,
			String relaOrderId, String relaOrderType, String flag)
			throws Exception, RuntimeException {

		return ((IProductAttachCfgDAO) ServiceFactory
				.getService(IProductAttachCfgDAO.class)).saveProductAttachCfg(
				principle, orgId, relaOrderId, relaOrderType, flag);
	}

}
