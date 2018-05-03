package com.ai.bce.configtool.service.impl;

import java.rmi.RemoteException;

import com.ai.bce.configtool.dao.interfaces.IConfAttrFieldMapDAO;
import com.ai.bce.configtool.service.interfaces.IConfAttrFieldMapSV;
import com.ai.bce.ivalues.IBceAttrFieldMapValue;
import com.ai.bce.util.BServiceFactory;

public class ConfAttrFieldMapSVImpl implements IConfAttrFieldMapSV {

	public IBceAttrFieldMapValue[] getAttrFieldMapValues(String cond,
			int startIndex, int endIndex) throws RemoteException,Exception {
		return getDao().getAttrFieldMapValues(cond, startIndex, endIndex);
	}

	public int getAttrFieldMapValuesCount(String cond) throws RemoteException,Exception {
		return getDao().getAttrFieldMapValuesCount(cond);
	}

	public IBceAttrFieldMapValue getAttrFieldMapValue(String configId) throws RemoteException,Exception {
		return getDao().getAttrFieldMapValue(configId);
	}
	public IConfAttrFieldMapDAO getDao() throws Exception{
		return (IConfAttrFieldMapDAO) BServiceFactory.getService(IConfAttrFieldMapDAO.class);
	}
}
