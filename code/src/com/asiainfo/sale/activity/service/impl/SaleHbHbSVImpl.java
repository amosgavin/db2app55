package com.asiainfo.sale.activity.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.activity.dao.interfaces.ISaleHbHbDAO;
import com.asiainfo.sale.activity.ivalues.IBOSaleHbHbValue;
import com.asiainfo.sale.activity.service.interfaces.ISaleHbHbSV;

public class SaleHbHbSVImpl implements ISaleHbHbSV {

	@Override
	public IBOSaleHbHbValue getSaleHbHbByMainId(String mainId) throws Exception {

		return ((ISaleHbHbDAO) ServiceFactory
				.getService(ISaleHbHbDAO.class))
				.getSaleHbHbByMainId(mainId);
	}

	@Override
	public String saveSaleHbHb(IBOSaleHbHbValue SaleHbHbValue)
			throws Exception {

		return ((ISaleHbHbDAO) ServiceFactory
				.getService(ISaleHbHbDAO.class))
				.saveSaleHbHb(SaleHbHbValue);
	}

}
