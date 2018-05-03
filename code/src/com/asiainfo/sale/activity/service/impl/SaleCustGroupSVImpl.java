package com.asiainfo.sale.activity.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.activity.dao.interfaces.ISaleCustGroupDAO;
import com.asiainfo.sale.activity.ivalues.IBOSaleCustGroupValue;
import com.asiainfo.sale.activity.service.interfaces.ISaleCustGroupSV;

public class SaleCustGroupSVImpl implements ISaleCustGroupSV {

	@Override
	public IBOSaleCustGroupValue[] getCustGroup(String cityId,
			String custGroupName, String createDateF, String createDateE,
			int startNum, int endNum) throws Exception {

		return ((ISaleCustGroupDAO) ServiceFactory
				.getService(ISaleCustGroupDAO.class)).getCustGroup(cityId,
				custGroupName, createDateF, createDateE, startNum, endNum);
	}

	@Override
	public int getCustGroupCn(String cityId, String custGroupName,
			String createDateF, String createDateE) throws Exception {

		return ((ISaleCustGroupDAO) ServiceFactory
				.getService(ISaleCustGroupDAO.class)).getCustGroupCn(cityId,
				custGroupName, createDateF, createDateE);
	}

}
