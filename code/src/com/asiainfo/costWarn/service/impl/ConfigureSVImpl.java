package com.asiainfo.costWarn.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.costWarn.dao.interfaces.IConfigureDAO;
import com.asiainfo.costWarn.ivalues.IBOConfigureValue;
import com.asiainfo.costWarn.service.interfaces.IConfigureSV;


public class ConfigureSVImpl implements IConfigureSV{

	@Override
	public int count(String city, String staffid,
			String staffname, String bumen, String telphone) throws Exception {
		// TODO Auto-generated method stub
		return ((IConfigureDAO) ServiceFactory.getService(IConfigureDAO.class))
		.count(city, staffid, staffname, bumen, telphone);
	}

	@Override
	public IBOConfigureValue[] select(String city, String staffid,
			String staffname, String bumen, String telphone, int startNum,
			int endNum) throws Exception {
		// TODO Auto-generated method stub
		return ((IConfigureDAO) ServiceFactory.getService(IConfigureDAO.class))
		.select(city, staffid, staffname, bumen, telphone,startNum,endNum);
	}

	@Override
	public void save(IBOConfigureValue vl) throws Exception {
		// TODO Auto-generated method stub
		((IConfigureDAO) ServiceFactory.getService(IConfigureDAO.class))
		.save(vl);
		
	}

	@Override
	public void deleteconfigure(IBOConfigureValue[] values) throws Exception {
		// TODO Auto-generated method stub
		((IConfigureDAO) ServiceFactory.getService(IConfigureDAO.class)).deleteconfigure(values);
	}

	@Override
	public IBOConfigureValue[] getStaffid(String staffid) throws Exception {
		// TODO Auto-generated method stub
		return ((IConfigureDAO) ServiceFactory.getService(IConfigureDAO.class))
		.getStaffid(staffid);
	}

}
