package com.asiainfo.charge.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.charge.dao.interfaces.IOptionalPackageDAO;
import com.asiainfo.charge.ivalues.IBOOptionalPackaegValue;
import com.asiainfo.charge.service.interfaces.IOptionalPackageSV;

public class OptionalPackageSVImpl implements IOptionalPackageSV {

	@Override
	public int getCountOptionalPackaegValues(String id, String name)
			throws Exception, RuntimeException {
		IOptionalPackageDAO iOptionalPackageDAO = (IOptionalPackageDAO) ServiceFactory
		.getService(IOptionalPackageDAO.class);
		return iOptionalPackageDAO.getCountOptionalPackaegValues(id, name);
	}

	@Override
	public IBOOptionalPackaegValue[] getOptionalPackaegValues(String id,
			String name, int startNum, int endNum) throws Exception,
			RuntimeException {
		IOptionalPackageDAO iOptionalPackageDAO = (IOptionalPackageDAO) ServiceFactory
		.getService(IOptionalPackageDAO.class);
		return iOptionalPackageDAO.getOptionalPackaegValues(id, name, startNum, endNum);
	}

}
