package com.asiainfo.sale.activity.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.activity.dao.interfaces.IOrderShowDAO;
import com.asiainfo.sale.activity.ivalues.IBOOrderShowValue;
import com.asiainfo.sale.activity.service.interfaces.IOrderShowSV;

public class OrderShowSVImpl implements IOrderShowSV {

	@Override
	public IBOOrderShowValue[] getSaleInfoByOrderId(String orderId)
			throws Exception {

		return ((IOrderShowDAO) ServiceFactory.getService(IOrderShowDAO.class))
				.getSaleInfoByOrderId(orderId);
	}

}
