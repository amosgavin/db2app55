package com.asiainfo.common.service.interfaces;

import com.asiainfo.common.ivalues.IBOProductAttachCfgValue;

public interface IProductAttachCfgSV {

	public IBOProductAttachCfgValue getProductAttachCfgById(String id)
			throws Exception, RuntimeException;

	public int saveProductAttachCfg(String principle, String orgId,
			String relaOrderId, String relaOrderType, String flag)
			throws Exception, RuntimeException;
}
