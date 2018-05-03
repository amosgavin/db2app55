package com.asiainfo.sale.common.dao.interfaces;

import com.asiainfo.sale.common.ivalues.IBOAnnounceInfoValue;

public interface IAnnounceInfoDAO {

	public String saveAnnounceInfo(IBOAnnounceInfoValue announceInfoValue)throws Exception;

	public IBOAnnounceInfoValue[] getAnnounceInfos(String title,String apply_time,String create_time,String flag)throws Exception;
	
	public IBOAnnounceInfoValue getAnnounceInfoById(String id)throws Exception;

	public void applyAnnounceInfo(String id)throws Exception;

	public void cancleAnnounceInfo(String id)throws Exception;
	
	public String getCurrentAnnounceInfo()throws Exception;
}
