package com.asiainfo.stopSelling.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.stopSelling.dao.interfaces.IStopSellMDAO;
import com.asiainfo.stopSelling.ivalues.IBOStopSellMValue;
import com.asiainfo.stopSelling.service.interfaces.IStopSellMSV;

public class StopSellMSVImpl implements IStopSellMSV {

	@Override
	public int save(IBOStopSellMValue[] stopSellCharge) throws Exception {

		return ((IStopSellMDAO) ServiceFactory.getService(IStopSellMDAO.class))
				.save(stopSellCharge);
	}

	@Override
	public IBOStopSellMValue getStopSellMInfoById(String mainId)
			throws Exception {

		return ((IStopSellMDAO) ServiceFactory.getService(IStopSellMDAO.class))
				.getStopSellMInfoById(mainId);
	}

	@Override
	public IBOStopSellMValue[] query(String mainId, String applyName,
			String itemType, String principal, String cityId, String state,
			String beginTime, String endTime, int startNum, int endNum)
			throws Exception {

		return ((IStopSellMDAO) ServiceFactory.getService(IStopSellMDAO.class))
				.query(mainId, applyName, itemType, principal, cityId, state,
						beginTime, endTime, startNum, endNum);
	}

	@Override
	public int queryCn(String mainId, String applyName, String itemType,
			String principal, String cityId, String state, String beginTime,
			String endTime) throws Exception {

		return ((IStopSellMDAO) ServiceFactory.getService(IStopSellMDAO.class))
				.queryCn(mainId, applyName, itemType, principal, cityId, state,
						beginTime, endTime);
	}

	@Override
	public void changeStsTo(String mainId, String state) throws Exception,
			RuntimeException {

		((IStopSellMDAO) ServiceFactory.getService(IStopSellMDAO.class))
				.changeStsTo(mainId, state);
	}

	@Override
	public void changeStsToAgreen(String mainId) throws Exception,
			RuntimeException {

		((IStopSellMDAO) ServiceFactory.getService(IStopSellMDAO.class))
				.changeStsToAgreen(mainId);
	}

	@Override
	public void changeStsToNo(String mainId, String choice) throws Exception,
			RuntimeException {

		((IStopSellMDAO) ServiceFactory.getService(IStopSellMDAO.class))
				.changeStsToNo(mainId, choice);
	}

	@Override
	public void changeStsTo2(String mainId) throws Exception, RuntimeException {

		((IStopSellMDAO) ServiceFactory.getService(IStopSellMDAO.class))
				.changeStsTo2(mainId);
	}

}
