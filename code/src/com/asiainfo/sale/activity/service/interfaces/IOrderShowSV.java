package com.asiainfo.sale.activity.service.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOOrderShowValue;

public interface IOrderShowSV {

	public IBOOrderShowValue[] getSaleInfoByOrderId(String orderId)
			throws Exception;
}
