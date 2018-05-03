package com.ai.bce.configtool.service.impl;

import java.rmi.RemoteException;

import com.ai.bce.configtool.dao.interfaces.IConfFramePageRoleDAO;
import com.ai.bce.configtool.service.interfaces.IConfFramePageRoleSV;
import com.ai.bce.ivalues.IBceFramePageRoleValue;
import com.ai.bce.util.BServiceFactory;


public class ConfFramePageRoleSVImpl implements IConfFramePageRoleSV {
	
	public IBceFramePageRoleValue[] getPageRoleValues(String cond,int startIndex,int endIndex)throws RemoteException,Exception{
		return getDao().getPageRoleValues(cond, startIndex, endIndex);
	}
	
	public int getPageRoleValuesCount(String cond) throws RemoteException,Exception{
		return getDao().getPageRoleValuesCount(cond);
	}

	public IBceFramePageRoleValue getPageRoleById(String pFramePageId,
			String roleId, String frameId) throws RemoteException{
		long _pFramePageId=-1,_roleId =-1,_frameId=-1;
		if(null != pFramePageId && !"".equals(pFramePageId)){
			_pFramePageId = Long.parseLong(pFramePageId);
		}
		if(null != roleId && !"".equals(roleId)){
			 _roleId = Long.parseLong(roleId);
		}
		if(null != frameId && !"".equals(frameId)){
			_frameId = Long.parseLong(frameId);
		}
		try {
			return getDao().getPageRoleById(_pFramePageId, _roleId, _frameId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public IConfFramePageRoleDAO getDao() throws Exception{
		return (IConfFramePageRoleDAO) BServiceFactory.getService(IConfFramePageRoleDAO.class);
	}
}
