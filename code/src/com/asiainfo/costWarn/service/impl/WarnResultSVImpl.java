package com.asiainfo.costWarn.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.costWarn.dao.interfaces.IWarnResultDAO;
import com.asiainfo.costWarn.ivalues.IBOWarnResultValue;
import com.asiainfo.costWarn.service.interfaces.IWarnResultSV;

public class WarnResultSVImpl implements IWarnResultSV {

	@Override
	public int count(String resource_type,String up_down,String city_code) throws Exception {
		return ((IWarnResultDAO)ServiceFactory.getService(IWarnResultDAO.class)).count(resource_type,up_down,city_code);
	}

	@Override
	public IBOWarnResultValue[] select(String resource_type,String up_down,String city_code, int startNum, int endNum)
			throws Exception {
		return ((IWarnResultDAO)ServiceFactory.getService(IWarnResultDAO.class)).select(resource_type,up_down,city_code, startNum, endNum);
		
	}

	@Override
	public void insert(IBOWarnResultValue vls) throws Exception {
	((IWarnResultDAO)ServiceFactory.getService(IWarnResultDAO.class)).insert(vls);		
	}

}
