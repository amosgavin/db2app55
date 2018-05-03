package com.asiainfo.sale.activity.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.activity.dao.interfaces.ISaleResourceDAO;
import com.asiainfo.sale.activity.dao.interfaces.IUsedQueryDAO;
import com.asiainfo.sale.activity.ivalues.IBOUsedQueryValue;
import com.asiainfo.sale.activity.service.interfaces.IUsedQuerySV;

public class UsedQuerySVImpl implements IUsedQuerySV{

	@Override
	public int queryUsedCount(String cityCode, String resourcetype,
			String createorg, String datetime) throws Exception {
		return 0;
	}

	@Override
	public IBOUsedQueryValue[] queryUsedValue(String cityCode,
			String resourcetype, String createorg, String datetime, int startNum, int endNum) throws Exception {
		return ((IUsedQueryDAO) ServiceFactory.getService(IUsedQueryDAO.class))
		.queryUsedValue(cityCode,resourcetype,createorg,datetime,startNum,endNum);
	}

}
