package com.asiainfo.sale.activity.dao.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOOrderShowValue;

public interface IOrderShowDAO {

	public IBOOrderShowValue[] getSaleInfoByOrderId(String orderId)
			throws Exception;
}
