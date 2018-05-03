package com.ai.bce.configtool.service.impl;

import java.rmi.RemoteException;

import com.ai.bce.bo.BceModuleBean;
import com.ai.bce.configtool.dao.interfaces.IConfModuleDAO;
import com.ai.bce.configtool.service.interfaces.IConfModuleSV;
import com.ai.bce.ivalues.IQModuleMenuRelateValue;
import com.ai.bce.util.BServiceFactory;

public class ConfModuleSVImpl implements IConfModuleSV {

	/**
	 * 根据模块ID获取所有菜单
	 * 
	 * @param moduleId
	 * @return
	 * @throws Exception
	 */
	public IQModuleMenuRelateValue[] getMenusByModuleId(String moduleId)
			throws RemoteException,Exception {
		IConfModuleDAO dao = (IConfModuleDAO) BServiceFactory
				.getService(IConfModuleDAO.class);
		return dao.getMenusByModuleId(moduleId);
	}

	public BceModuleBean[] getDataSource() throws RemoteException,Exception {
		IConfModuleDAO dao = (IConfModuleDAO) BServiceFactory
		.getService(IConfModuleDAO.class);
		return dao.getDataSource();
	}
}
