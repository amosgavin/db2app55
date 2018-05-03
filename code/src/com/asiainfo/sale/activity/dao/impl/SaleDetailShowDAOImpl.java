package com.asiainfo.sale.activity.dao.impl;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import com.asiainfo.sale.activity.bo.BOSaleDetailShowEngine;
import com.asiainfo.sale.activity.dao.interfaces.ISaleDetailShowDAO;
import com.asiainfo.sale.activity.ivalues.IBOSaleDetailShowValue;

public class SaleDetailShowDAOImpl implements ISaleDetailShowDAO {

	@Override
	public IBOSaleDetailShowValue[] getSaleDetailShowValues(String id)
			throws Exception {
		String condition = " " + IBOSaleDetailShowValue.S_SaleId + " = :id";
		Map parameter = new HashedMap();
		parameter.put("id", id);
		return BOSaleDetailShowEngine.getBeans(condition, parameter);
	}
	
}
