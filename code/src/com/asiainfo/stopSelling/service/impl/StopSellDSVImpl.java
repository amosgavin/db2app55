package com.asiainfo.stopSelling.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.stopSelling.dao.interfaces.IStopSellDDAO;
import com.asiainfo.stopSelling.ivalues.IBOStopSellDValue;
import com.asiainfo.stopSelling.service.interfaces.IStopSellDSV;

public class StopSellDSVImpl implements IStopSellDSV {

	@Override
	public void save(IBOStopSellDValue[] stopSellCharged) throws Exception {

		((IStopSellDDAO) ServiceFactory.getService(IStopSellDDAO.class))
				.save(stopSellCharged);
	}

	@Override
	public IBOStopSellDValue[] getStopSellDByMainId(String mainId,
			int startNum, int endNum) throws Exception {

		return ((IStopSellDDAO) ServiceFactory.getService(IStopSellDDAO.class))
				.getStopSellDByMainId(mainId, startNum, endNum);
	}

	@Override
	public int getStopSellDCountByMainId(String mainId) throws Exception {

		return ((IStopSellDDAO) ServiceFactory.getService(IStopSellDDAO.class))
				.getStopSellDCountByMainId(mainId);
	}

	@Override
	public IBOStopSellDValue getStopSellDById(String did) throws Exception {

		return ((IStopSellDDAO) ServiceFactory.getService(IStopSellDDAO.class))
				.getStopSellDById(did);
	}

}
