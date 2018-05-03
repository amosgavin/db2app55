package com.asiainfo.sale.activity.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.activity.dao.interfaces.ISaleCostEffectiveDAO;
import com.asiainfo.sale.activity.ivalues.IBOSaleCostEffectiveValue;
import com.asiainfo.sale.activity.service.interfaces.ISaleCostEffectiveSV;

public class SaleCostEffectiveSVImpl implements ISaleCostEffectiveSV{

	@Override
	public int querySaleCostEffectiveCount(String cityCode, String activityType, String datetime) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IBOSaleCostEffectiveValue[] querySaleCostEffectiveValue(
			String cityCode, String activityType, String datetime,int startNum, int endNum)
			throws Exception {
		return ((ISaleCostEffectiveDAO) ServiceFactory.getService(ISaleCostEffectiveDAO.class))
		.querySaleCostEffectiveValue(cityCode,activityType,datetime,startNum,endNum);
	}

}
