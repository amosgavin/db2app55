package com.asiainfo.sale.activity.dao.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOChannelInfoValue;

public interface ISaleChannelInfoDAO {

	public void save(IBOChannelInfoValue[] values) throws Exception;

	public IBOChannelInfoValue[] getChannelInfoByRelaId(String relaId,
			String relaType, int startNum, int endNum) throws Exception;

	public int getCnChannelListByRelaId(String relaId, String relaType)
			throws Exception;
	
	public void cloneChannelInfoByRelaId(String relaType, String oldId,
			String newId) throws Exception;
}
