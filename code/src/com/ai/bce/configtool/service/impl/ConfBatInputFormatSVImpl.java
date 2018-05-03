package com.ai.bce.configtool.service.impl;

import java.rmi.RemoteException;
import com.ai.bce.util.BServiceFactory;
import com.ai.bce.configtool.dao.interfaces.IConfBatInputFormatDAO;
import com.ai.bce.configtool.service.interfaces.IConfBatInputFormatSV;
import com.ai.bce.ivalues.IBceBatInputFormatValue;

public class ConfBatInputFormatSVImpl implements IConfBatInputFormatSV {

	public IBceBatInputFormatValue[] getBatInputFormatValues(String cond,
			int startIndex, int endIndex) throws RemoteException,Exception {
		return getDao().getBatInputFormatValues(cond, startIndex, endIndex);
	}

	public int getBatInputFormatValuesCount(String cond) throws RemoteException,Exception {
		return getDao().getBatInputFormatValuesCount(cond);
	}

	public IBceBatInputFormatValue getBatInputFormatValue(String configId)
			throws RemoteException,Exception {
		return getDao().getBatInputFormatValue(configId);
	}
	public IConfBatInputFormatDAO getDao() throws Exception{
		return (IConfBatInputFormatDAO) BServiceFactory.getService(IConfBatInputFormatDAO.class);
	}
}
