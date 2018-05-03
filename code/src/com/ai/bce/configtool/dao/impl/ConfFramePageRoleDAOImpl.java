package com.ai.bce.configtool.dao.impl;

import java.rmi.RemoteException;

import com.ai.bce.bo.BceFramePageRoleEngine;
import com.ai.bce.configtool.dao.interfaces.IConfFramePageRoleDAO;
import com.ai.bce.ivalues.IBceFramePageRoleValue;
public class ConfFramePageRoleDAOImpl implements IConfFramePageRoleDAO {

	public IBceFramePageRoleValue getPageRoleById(long pFramePageId,long roleId, long frameId) throws Exception {
		return BceFramePageRoleEngine.getBean(roleId, frameId, pFramePageId);
	}

	public IBceFramePageRoleValue[] getPageRoleValues(String cond,
			int startIndex, int endIndex) throws RemoteException, Exception {
		return BceFramePageRoleEngine.getBeans(null, cond, null, startIndex, endIndex, false);
	}

	public int getPageRoleValuesCount(String cond) throws RemoteException,
			Exception {
		return BceFramePageRoleEngine.getBeansCount(cond,null);
	}

}
