package com.asiainfo.charge.dao.interfaces;

import com.asiainfo.charge.ivalues.IBOEchannelNcodeCommandValue;

public interface IEchannelNcodeCommandDAO {

	public void save(IBOEchannelNcodeCommandValue[] values) throws Exception;

	public IBOEchannelNcodeCommandValue[] getEchannelNcodeCommandByRelaId(String relaId,String infoType,
			 int startNum, int endNum) throws Exception;

	public int getCnEchannelNcodeCommandListByRelaId(String relaId,String infoType)
			throws Exception;
	
	public void cloneEchannelNcodeCommandByRelaId( String oldId,String infoType,
			String newId) throws Exception;


}
