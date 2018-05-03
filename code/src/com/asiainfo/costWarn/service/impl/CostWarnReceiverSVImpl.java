package com.asiainfo.costWarn.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.costWarn.dao.interfaces.ICostWarnReceiverDAO;
import com.asiainfo.costWarn.ivalues.IBOCostWarnReceiverValue;
import com.asiainfo.costWarn.service.interfaces.ICostWarnReceiverSV;

public class CostWarnReceiverSVImpl implements ICostWarnReceiverSV {

	@Override
	public void deleteCostWarnReceiverValues(
			IBOCostWarnReceiverValue[] costWarnReceiverValues) throws Exception {

		((ICostWarnReceiverDAO) ServiceFactory
				.getService(ICostWarnReceiverDAO.class))
				.deleteCostWarnReceiverValues(costWarnReceiverValues);
	}

	@Override
	public IBOCostWarnReceiverValue[] getCostWarnReceiverValues(
			String personId, String cityId, String target, String levelId,
			String grade, String billId, int startNum, int endNum)
			throws Exception {
		return ((ICostWarnReceiverDAO) ServiceFactory
				.getService(ICostWarnReceiverDAO.class))
				.getCostWarnReceiverValues(personId, cityId, target, levelId,
						grade, billId, startNum, endNum);
	}

	@Override
	public int getCountCostWarnReceiverValues(String personId, String cityId,
			String target, String levelId, String grade, String billId)
			throws Exception {

		return ((ICostWarnReceiverDAO) ServiceFactory
				.getService(ICostWarnReceiverDAO.class))
				.getCountCostWarnReceiverValues(personId, cityId, target,
						levelId, grade, billId);
	}

	@Override
	public void saveCostWarnReceiverValues(
			IBOCostWarnReceiverValue[] costWarnReceiverValues) throws Exception {

		((ICostWarnReceiverDAO) ServiceFactory
				.getService(ICostWarnReceiverDAO.class))
				.saveCostWarnReceiverValues(costWarnReceiverValues);
	}

	@Override
	public IBOCostWarnReceiverValue getCostWarnReceiverValue(String personId,
			String cityId, String target, String levelId, String grade,
			String billId) throws Exception {

		return getCostWarnReceiverValues(personId, cityId, target, levelId,
				grade, billId, 0, 1)[0];
	}

}
