package com.asiainfo.charge.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.charge.dao.interfaces.IEchannelNcodeCommandDAO;
import com.asiainfo.charge.ivalues.IBOEchannelNcodeCommandValue;
import com.asiainfo.charge.service.interfaces.IEchannelNcodeCommandSV;


public class EchannelNcodeCommandSVImpl implements IEchannelNcodeCommandSV {

	@Override
	public IBOEchannelNcodeCommandValue[] getEchannelNcodeCommandByRelaId(String relaId,String infoType,
			 int startNum, int endNum) throws Exception {
		return ((IEchannelNcodeCommandDAO) ServiceFactory
				.getService(IEchannelNcodeCommandDAO.class)).getEchannelNcodeCommandByRelaId(
				relaId,infoType, startNum, endNum);
	}

	@Override
	public void save(IBOEchannelNcodeCommandValue[] values) throws Exception {

		((IEchannelNcodeCommandDAO) ServiceFactory
				.getService(IEchannelNcodeCommandDAO.class)).save(values);
	}

	@Override
	public int getCnEchannelNcodeCommandListByRelaId(String relaId,String infoType)
			throws Exception {

		return ((IEchannelNcodeCommandDAO) ServiceFactory
				.getService(IEchannelNcodeCommandDAO.class))
				.getCnEchannelNcodeCommandListByRelaId(relaId,infoType);
	}

}
