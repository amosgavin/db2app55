package com.asiainfo.costWarn.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.costWarn.dao.interfaces.IConfigureDAO;
import com.asiainfo.costWarn.dao.interfaces.ISelectStaffDAO;
import com.asiainfo.costWarn.ivalues.IBOSelectStaffValue;
import com.asiainfo.costWarn.service.interfaces.ISelectStaffSV;

public class SelectStaffSVImpl implements ISelectStaffSV{

	@Override
	public int countstaff(String staffid, String staffname, String billid)
			throws Exception {
		// TODO Auto-generated method stub
		return ((ISelectStaffDAO) ServiceFactory.getService(ISelectStaffDAO.class))
		.countstaff(staffid, staffname, billid);
	}

	@Override
	public IBOSelectStaffValue[] selectstaff(String staffid, String staffname,
			String billid, int startNum, int endNum) throws Exception {
		// TODO Auto-generated method stub
		return ((ISelectStaffDAO) ServiceFactory.getService(ISelectStaffDAO.class))
		.selectstaff(staffid, staffname, billid,startNum,endNum);
	}

}
