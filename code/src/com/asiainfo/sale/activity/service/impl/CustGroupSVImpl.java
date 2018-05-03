package com.asiainfo.sale.activity.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.activity.dao.interfaces.ICustGroupDAO;
import com.asiainfo.sale.activity.ivalues.IBOSaleRelatCgroupValue;
import com.asiainfo.sale.activity.service.interfaces.ICustGroupSV;

public class CustGroupSVImpl implements ICustGroupSV {

	public void save(IBOSaleRelatCgroupValue[] values) throws Exception {
		((ICustGroupDAO) ServiceFactory.getService(ICustGroupDAO.class))
				.save(values);
	}

	public IBOSaleRelatCgroupValue[] getSaleRelatCgroupByRelaId(String relaId,
			String relaType, int startNum, int endNum) throws Exception {
		return ((ICustGroupDAO) ServiceFactory.getService(ICustGroupDAO.class))
				.getSaleRelatCgroupByRelaId(relaId, relaType, startNum, endNum);
	}

	public int getCnSaleRelatCgroupByRelaId(String relaId, String relaType)
			throws Exception {
		return ((ICustGroupDAO) ServiceFactory.getService(ICustGroupDAO.class))
				.getCnSaleRelatCgroupByRelaId(relaId, relaType);
	}

	public void cloneSaleRelatCgroupByRelaId(String relaType, String oldId,
			String newId) throws Exception {
		((ICustGroupDAO) ServiceFactory.getService(ICustGroupDAO.class))
				.cloneSaleRelatCgroupByRelaId(relaType, oldId, newId);
	}
}
