package com.ai.bce.configtool.service.impl;

import java.rmi.RemoteException;

import com.ai.bce.configtool.dao.interfaces.IConfExtTableDAO;
import com.ai.bce.configtool.service.interfaces.IConfExtTableSV;
import com.ai.bce.ivalues.IBceExtTableConfigValue;
import com.ai.bce.util.BServiceFactory;

public class ConfExtTableSVImpl implements IConfExtTableSV {

	public IBceExtTableConfigValue getExtTable(String configId) throws RemoteException, Exception {
		return getDao().getExtTable(configId);
	}

	public IBceExtTableConfigValue[] getExtTables(String cond, int startIndex,
			int endIndex) throws RemoteException,Exception {
		return getDao().getExtTables(cond, startIndex, endIndex);
	}

	public int getExtTablesCount(String cond) throws RemoteException,Exception {
		return getDao().getExtTablesCount(cond);
	}
	public IConfExtTableDAO getDao() throws Exception{
		return (IConfExtTableDAO) BServiceFactory.getService(IConfExtTableDAO.class);
	}
}
