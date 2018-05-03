package com.ai.bce.configtool.dao.interfaces;

import java.rmi.RemoteException;

import com.ai.bce.ivalues.IBceFramePageRoleValue;

public interface IConfFramePageRoleDAO {
	public IBceFramePageRoleValue getPageRoleById(long pFramePageId,long roleId, long frameId) throws Exception;
	public IBceFramePageRoleValue[] getPageRoleValues(String cond,int startIndex,int endIndex)throws RemoteException,Exception;
	public int getPageRoleValuesCount(String cond) throws RemoteException,Exception;
	
	
}
