package com.ai.bce.configtool.service.interfaces;

import java.rmi.RemoteException;

import com.ai.bce.ivalues.IBceFramePageRoleValue;

public interface IConfFramePageRoleSV {
	
	public IBceFramePageRoleValue[] getPageRoleValues(String cond,int startIndex,int endIndex)throws RemoteException,Exception;
	
	public int getPageRoleValuesCount(String cond) throws RemoteException,Exception;
	
	public IBceFramePageRoleValue getPageRoleById(String pFramePageId,
			String roleId, String frameId) throws RemoteException;

}
