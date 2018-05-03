package com.ai.bce.configtool.service.impl;

import java.rmi.RemoteException;

import com.ai.bce.bo.QPageFramePageBean;
import com.ai.bce.configtool.dao.interfaces.IConfPFramePageDAO;
import com.ai.bce.configtool.service.interfaces.IConfPFramePageSV;
import com.ai.bce.ivalues.IQPageFramePageValue;
import com.ai.bce.util.BServiceFactory;

/**
 * @author szw
 *Ò³Ãæ¿ò¼Ü¹ØÏµ
 */
public class ConfPFramePageSVImpl implements IConfPFramePageSV {

	public IQPageFramePageValue getBcePageFramePageValueByPFramePageId(
			String pFramePageId) throws Exception {
		if(null != pFramePageId&&!"".equals(pFramePageId)){
			long pageFramePageId = Long.parseLong(pFramePageId);
			IConfPFramePageDAO bcePFramePageDao = getBcePFramePageDAO();
		    return bcePFramePageDao.getPFramePageByPFramePageId(pageFramePageId);
		}
		return new QPageFramePageBean();
	}
	
	public int getBcePageFramePageValuesCount(String cond) throws RemoteException,Exception{
		return getBcePFramePageDAO().getBcePageFramePageValuesCount(cond);
	}
	
	public IQPageFramePageValue[] getBcePageFramePageValues(String cond,int startIndex,int endIndex)throws RemoteException,Exception{
		return getBcePFramePageDAO().getBcePageFramePageValues(cond, startIndex, endIndex);
	}

	public IQPageFramePageValue[] getPageFramePageByBcePageFrameId(String bcePageFrameId) throws RemoteException,Exception {
		if(null!=bcePageFrameId&&!"".equals(bcePageFrameId)){
		 long pageFrameId = Long.parseLong(bcePageFrameId);  
		 IConfPFramePageDAO bcePFramePageDao = getBcePFramePageDAO();
		 return bcePFramePageDao.getPageFramePageByBcePageFrameId(pageFrameId);
	   }
		return new IQPageFramePageValue[0];
	}

	public IConfPFramePageDAO getBcePFramePageDAO() throws Exception{
		return (IConfPFramePageDAO) BServiceFactory.getService(IConfPFramePageDAO.class);
	}
}
