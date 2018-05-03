package com.ai.bce.configtool.service.impl;

import java.rmi.RemoteException;

import com.ai.bce.configtool.dao.interfaces.IConfSpecialPageDAO;
import com.ai.bce.configtool.service.interfaces.IConfSpecialPageSV;
import com.ai.bce.ivalues.IBceFrameSpecialPageValue;
import com.ai.bce.util.BServiceFactory;

public class ConfSpecialPageSVImpl implements IConfSpecialPageSV {

	public IBceFrameSpecialPageValue[] getSpecialPageValues(String cond,
			int startIndex, int endIndex) throws RemoteException,Exception {
		return getDao().getSpecialPageValues(cond, startIndex, endIndex);
	}

	public int getSpecialPageValuesCount(String cond) throws RemoteException,Exception {
			return getDao().getSpecialPageValuesCount(cond);
		}

	public IBceFrameSpecialPageValue getSpecialPageById(String bceFrameId,
			String pageFramePageId) throws RemoteException,Exception {
		long frameId=-1,pFramePageId=-1;
		if(null != bceFrameId&& !"".equals(bceFrameId)){
			frameId = Long.parseLong(bceFrameId);
		}
		if(null != pageFramePageId&& !"".equals(pageFramePageId)){
			pFramePageId = Long.parseLong(pageFramePageId);
		}
		return getDao().getSpecialPageById(frameId, pFramePageId);
	}
	
	public IConfSpecialPageDAO getDao() throws Exception{
		return (IConfSpecialPageDAO) BServiceFactory.getService(IConfSpecialPageDAO.class);
	}
}
