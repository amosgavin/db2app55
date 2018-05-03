package com.asiainfo.common.dao.impl;

import com.asiainfo.common.bo.BOProductAttachCfgBean;
import com.asiainfo.common.bo.BOProductAttachCfgEngine;
import com.asiainfo.common.dao.interfaces.IProductAttachCfgDAO;
import com.asiainfo.common.ivalues.IBOProductAttachCfgValue;

public class ProductAttachCfgDAOImpl implements IProductAttachCfgDAO {

	@Override
	public IBOProductAttachCfgValue getProductAttachCfgById(String id)
			throws Exception, RuntimeException {

		return BOProductAttachCfgEngine.getBean(Integer.parseInt(id));
	}

	@Override
	public int saveProductAttachCfg(String principle, String orgId,
			String relaOrderId, String relaOrderType, String flag)
			throws Exception, RuntimeException {

		if (getProductAttachCfgCn(relaOrderId, relaOrderType, flag) > 0) {
			return -1;
		}
		BOProductAttachCfgBean bean = new BOProductAttachCfgBean();
		int newId = BOProductAttachCfgEngine.getNewId().intValue();
		bean.setId(newId);
		bean.setPrinciple(principle);
		bean.setOrgId(orgId);
		bean.setRelaOrderId(relaOrderId);
		bean.setRelaOrderType(relaOrderType);
		bean.setFlag(flag);
		BOProductAttachCfgEngine.save(bean);
		return newId;
	}

	private int getProductAttachCfgCn(String relaOrderId, String relaOrderType,
			String flag) throws Exception {
		String cd = " rela_order_id='" + relaOrderId
				+ "' and rela_order_type = '" + relaOrderType + "' and flag='"
				+ flag + "' ";
		return BOProductAttachCfgEngine.getBeansCount(cd, null);
	}
}
