package com.asiainfo.sale.activity.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.activity.dao.interfaces.ISaleEitAppriseDAO;
import com.asiainfo.sale.activity.ivalues.IBoSaleEitAppriseValue;
import com.asiainfo.sale.activity.service.interfaces.ISaleEitAppriseSV;

public class SaleEitAppriseSVImpl implements ISaleEitAppriseSV {

	@Override
	public IBoSaleEitAppriseValue getSaleEitAppriseByMainId(String mainId,
			String appriseType) throws Exception {

		return ((ISaleEitAppriseDAO) ServiceFactory
				.getService(ISaleEitAppriseDAO.class))
				.getSaleEitAppriseByMainId(mainId, appriseType);
	}

	@Override
	public String saveSaleEitApprise(IBoSaleEitAppriseValue SaleEitAppriseValue)
			throws Exception {

		return ((ISaleEitAppriseDAO) ServiceFactory
				.getService(ISaleEitAppriseDAO.class))
				.saveSaleEitApprise(SaleEitAppriseValue);
	}

}
