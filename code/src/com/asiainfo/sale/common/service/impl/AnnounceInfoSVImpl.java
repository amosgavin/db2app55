package com.asiainfo.sale.common.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.common.ivalues.IBOAnnounceInfoValue;
import com.asiainfo.sale.common.service.interfaces.IAnnounceInfoSV;
import com.asiainfo.sale.common.dao.interfaces.IAnnounceInfoDAO;

public class AnnounceInfoSVImpl implements IAnnounceInfoSV {

	public String saveAnnounceInfo(IBOAnnounceInfoValue announceInfoValue)throws Exception{
		IAnnounceInfoDAO announceInfoDAO = (IAnnounceInfoDAO) ServiceFactory.getService(IAnnounceInfoDAO.class);
		return announceInfoDAO.saveAnnounceInfo(announceInfoValue);
	}

	public IBOAnnounceInfoValue[] getAnnounceInfos(String title,String apply_time,String create_time,String flag)throws Exception{
		IAnnounceInfoDAO announceInfoDAO = (IAnnounceInfoDAO) ServiceFactory.getService(IAnnounceInfoDAO.class);
		return announceInfoDAO.getAnnounceInfos(title,apply_time,create_time,flag);
	}
	
	public IBOAnnounceInfoValue getAnnounceInfoById(String id)throws Exception{
		IAnnounceInfoDAO announceInfoDAO = (IAnnounceInfoDAO) ServiceFactory.getService(IAnnounceInfoDAO.class);
		return announceInfoDAO.getAnnounceInfoById(id);
	}
	
	public void applyAnnounceInfo(String id)throws Exception{
		IAnnounceInfoDAO announceInfoDAO = (IAnnounceInfoDAO) ServiceFactory.getService(IAnnounceInfoDAO.class);
		announceInfoDAO.applyAnnounceInfo(id);
	}
	
	public void cancleAnnounceInfo(String id)throws Exception{
		IAnnounceInfoDAO announceInfoDAO = (IAnnounceInfoDAO) ServiceFactory.getService(IAnnounceInfoDAO.class);
		announceInfoDAO.cancleAnnounceInfo(id);
	}
	
	public String getCurrentAnnounceInfo()throws Exception{
		IAnnounceInfoDAO announceInfoDAO = (IAnnounceInfoDAO) ServiceFactory.getService(IAnnounceInfoDAO.class);
		return announceInfoDAO.getCurrentAnnounceInfo();
	}
	
	
}
