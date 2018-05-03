package com.asiainfo.sale.activity.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.activity.dao.interfaces.ISaleResourceDAO;
import com.asiainfo.sale.activity.ivalues.IBOSaleResourceAllotValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleResourceUsedValue;
import com.asiainfo.sale.activity.service.interfaces.ISaleResourceSV;

public class SaleResourceSVImpl implements ISaleResourceSV {

	@Override
	public IBOSaleResourceAllotValue[] getResourceAllot(String cityId)
			throws Exception {
		return ((ISaleResourceDAO) ServiceFactory
				.getService(ISaleResourceDAO.class)).getResourceAllot(cityId);
	}

	@Override
	public void save(IBOSaleResourceAllotValue vl) throws Exception {
		((ISaleResourceDAO) ServiceFactory.getService(ISaleResourceDAO.class))
				.save(vl);
	}

	@Override
	public IBOSaleResourceUsedValue[] selectResourceUsed(String cityId) throws Exception {
		return ((ISaleResourceDAO) ServiceFactory
				.getService(ISaleResourceDAO.class)).selectResourceUsed(cityId);
	}
	
	public IBOSaleResourceUsedValue[] selectResourceUsed() throws Exception {
		return ((ISaleResourceDAO) ServiceFactory
				.getService(ISaleResourceDAO.class)).selectResourceUsed();
	}
	
	public IBOSaleResourceUsedValue[] selectResourceUsed2(String cityId) throws Exception {
		return ((ISaleResourceDAO) ServiceFactory
				.getService(ISaleResourceDAO.class)).selectResourceUsed2(cityId);
	}

}
