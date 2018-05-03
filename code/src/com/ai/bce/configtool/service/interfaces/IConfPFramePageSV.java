package com.ai.bce.configtool.service.interfaces;

import java.rmi.RemoteException;

import com.ai.appframe2.common.AIException;
import com.ai.bce.ivalues.IQPageFramePageValue;

public interface IConfPFramePageSV {
	public IQPageFramePageValue getBcePageFramePageValueByPFramePageId(String pFramePageId) throws RemoteException, AIException, Exception;
	
	public int getBcePageFramePageValuesCount(String cond) throws Exception;
	
	public IQPageFramePageValue[] getBcePageFramePageValues(String cond,int startIndex,int endIndex)throws Exception;

	public IQPageFramePageValue[] getPageFramePageByBcePageFrameId(String bcePageFrameId) throws RemoteException, Exception;

}
