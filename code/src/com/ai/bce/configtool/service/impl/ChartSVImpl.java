package com.ai.bce.configtool.service.impl;

import java.rmi.RemoteException;

import com.ai.bce.configtool.dao.interfaces.IConfFrameDAO;
import com.ai.bce.configtool.dao.interfaces.IConfPageDAO;
import com.ai.bce.configtool.dao.interfaces.IConfPageFrameDAO;
import com.ai.bce.configtool.dao.interfaces.IConfRulesetDAO;
import com.ai.bce.configtool.service.interfaces.IChartSV;
import com.ai.bce.util.BServiceFactory;

public class ChartSVImpl implements IChartSV {

	public int getBceFramesCountByModuleId(long moduleId) throws RemoteException,Exception {
		IConfFrameDAO dao = (IConfFrameDAO) BServiceFactory.getService(IConfFrameDAO.class);
		return dao.getBceFramesCountByModuleId(moduleId);
	}

	public int getBcePageFrameCountByModuleId(long moduleId) throws RemoteException,Exception {
		 IConfPageFrameDAO dao = (IConfPageFrameDAO) BServiceFactory.getService(IConfPageFrameDAO.class);
		 return dao.getBcePageFrameCountByModuleId(moduleId);
	}

	public int getBcePageCountByModuleId(long moduleId) throws RemoteException,Exception {
		IConfPageDAO dao = (IConfPageDAO) BServiceFactory.getService(IConfPageDAO.class);
		return dao.getBcePageCountByModuleId(moduleId);
	}

	public int getBceRuleSetCountByModuleId(long moduleId) throws RemoteException,Exception {
		IConfRulesetDAO dao = (IConfRulesetDAO) BServiceFactory.getService(IConfRulesetDAO.class);
		return dao.getBceRuleSetCountByModuleId(moduleId);
	}
	
}
