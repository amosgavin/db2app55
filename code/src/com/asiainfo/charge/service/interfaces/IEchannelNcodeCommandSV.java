package com.asiainfo.charge.service.interfaces;

import com.asiainfo.charge.ivalues.IBOEchannelNcodeCommandValue;



public interface IEchannelNcodeCommandSV {

	public void save(IBOEchannelNcodeCommandValue[] values) throws Exception;

	public IBOEchannelNcodeCommandValue[] getEchannelNcodeCommandByRelaId(String relaId,String InfoType,
			int startNum, int endNum) throws Exception;

	public int getCnEchannelNcodeCommandListByRelaId(String relaId,String infoType)
			throws Exception;
}
