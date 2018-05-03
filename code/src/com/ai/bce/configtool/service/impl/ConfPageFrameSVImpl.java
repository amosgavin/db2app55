package com.ai.bce.configtool.service.impl;

import java.rmi.RemoteException;

import com.ai.bce.configtool.dao.interfaces.IConfPageFrameDAO;
import com.ai.bce.configtool.service.interfaces.IConfPageFrameSV;
import com.ai.bce.ivalues.IBcePageFrameValue;
import com.ai.bce.ivalues.IBcePageValue;
import com.ai.bce.util.BServiceFactory;

public class ConfPageFrameSVImpl implements IConfPageFrameSV {

	 /* (non-Javadoc)
	 * @see com.ai.bce.configtool.service.interfaces.IBcePageFrameSV#getBcePageFrameValueByBcePageFrameId(String)
	 */
	public IBcePageFrameValue getBcePageFrameValueByBcePageFrameId(String bcePageFrameId) throws Exception{
	    	IConfPageFrameDAO bcePageFrameDao = (IConfPageFrameDAO) BServiceFactory.getService(IConfPageFrameDAO.class);
	    	if (null != bcePageFrameId && !"".equals(bcePageFrameId)){
				try {
					return bcePageFrameDao.getBcePageFrameValue(Long.parseLong(bcePageFrameId));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				} 
	    	}
	    		return null;
	    }
	 
	 public IBcePageFrameValue[] getPageFrameValues(String cond, int startIndex,
				int endIndex) throws Exception {
			return getDao().getPageFrameValues(cond, startIndex, endIndex);
		}
	 
	 public int getPageFrameValuesCount(String cond) throws Exception {
		 return getDao().getPageFrameValuesCount(cond);
		}
	 
	 public IBcePageValue[] getBcePageValuesByBcePageFrameId(String bcePageFrameId) throws RemoteException,Exception{
		 return getDao().getBcePageValuesByBcePageFrameId(bcePageFrameId);
	    }
	 
	 public IConfPageFrameDAO getDao() throws Exception{
		 return (IConfPageFrameDAO) BServiceFactory.getService(IConfPageFrameDAO.class);
	 }
		
}
