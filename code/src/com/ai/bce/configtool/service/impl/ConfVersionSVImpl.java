package com.ai.bce.configtool.service.impl;

import java.rmi.RemoteException;

import com.ai.bce.auto.plugin.version.hand.bo.BceVerHandBean;
import com.ai.bce.auto.plugin.version.hand.bo.BceVerOrdBean;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerHandValue;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerOrdValue;
import com.ai.bce.configtool.dao.interfaces.IConfVersionDAO;
import com.ai.bce.configtool.service.interfaces.IConfVersionSV;
import com.ai.bce.util.BServiceFactory;

public class ConfVersionSVImpl implements IConfVersionSV {

	public IBceVerHandValue getVerHands(String cond) throws RemoteException,Exception {
		return getService().getVerHands(cond);
	}

	public long saveVerHand(BceVerHandBean verHand) throws RemoteException,Exception {
		return getService().saveVerHand(verHand);
	}

	public IBceVerOrdValue[] getVerOrds(String cond,int startIndex,int endIndex) throws RemoteException,Exception {
		return getService().getVerOrds(cond, startIndex, endIndex);
	}

	public int getVerOrdsCount(String cond) throws RemoteException,Exception {
		return getService().getVerOrdsCount(cond);
	}

	public void saveVerOrd(BceVerOrdBean verOrd) throws RemoteException,Exception {
		getService().saveVerOrd(verOrd);
	}

	public IConfVersionDAO getService() throws Exception{
		return (IConfVersionDAO) BServiceFactory.getService(IConfVersionDAO.class);
	}
}
