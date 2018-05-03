package com.ai.bce.configtool.service.interfaces;

import java.rmi.RemoteException;

import com.ai.bce.ivalues.IBceFrameSpecialPageValue;

public interface IConfSpecialPageSV {
	public IBceFrameSpecialPageValue[] getSpecialPageValues(String cond,int startIndex,int endIndex)throws Exception;
	public int getSpecialPageValuesCount(String cond) throws Exception;
	public IBceFrameSpecialPageValue getSpecialPageById(String bceFrameId,String pageFramePageId) throws RemoteException, Exception;

}
