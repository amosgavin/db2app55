package com.ai.bce.configtool.service.impl;

import java.rmi.RemoteException;

import com.ai.bce.configtool.dao.interfaces.IConfBatInputFieldFormatDAO;
import com.ai.bce.configtool.service.interfaces.IConfBatInputFieldFormatSV;
import com.ai.bce.ivalues.IBceBatInputFieldFormatValue;
import com.ai.bce.util.BServiceFactory;

public class ConfBatInputFieldFormatSVImpl implements
		IConfBatInputFieldFormatSV {

	public IBceBatInputFieldFormatValue[] getBatInputFieldFormatValues(String cond,
			int startIndex, int endIndex) throws RemoteException,Exception {
		return getDao().getBatInputFieldFormatValues(cond, startIndex, endIndex);
	}

	public int getBatInputFieldFormatValuesCount(String cond) throws RemoteException,Exception {
		return getDao().getBatInputFieldFormatValuesCount(cond);
	}

	public IBceBatInputFieldFormatValue getBatInputFieldFormatValue(
			String configId, String listType, String seqNo) throws RemoteException,Exception {
		return getDao().getBatInputFieldFormatValue(configId, listType, seqNo);
	}	

	public IConfBatInputFieldFormatDAO getDao() throws Exception{
		return (IConfBatInputFieldFormatDAO) BServiceFactory.getService(IConfBatInputFieldFormatDAO.class);
	}
}
