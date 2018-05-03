package com.asiainfo.costWarn.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.costWarn.dao.interfaces.ICostWarnDAO;
import com.asiainfo.costWarn.ivalues.IBOCostWarnValue;
import com.asiainfo.costWarn.service.interfaces.ICostWarnSV;

public class CostWarnSVImpl implements ICostWarnSV {

	@Override
	public void deleteCostWarnValues(IBOCostWarnValue[] costWarnValues)
			throws Exception {

		((ICostWarnDAO) ServiceFactory.getService(ICostWarnDAO.class))
				.deleteCostWarnValues(costWarnValues);
	}

	@Override
	public IBOCostWarnValue[] getCostWarnValues(String cfId, String cityId,
			String target, String levelId, String grade, int startNum,
			int endNum) throws Exception {

		return ((ICostWarnDAO) ServiceFactory.getService(ICostWarnDAO.class))
				.getCostWarnValues(cfId, cityId, target, levelId, grade,
						startNum, endNum);
	}

	@Override
	public int getCountCostWarnValues(String cfId, String cityId,
			String target, String levelId, String grade) throws Exception {

		return ((ICostWarnDAO) ServiceFactory.getService(ICostWarnDAO.class))
				.getCountCostWarnValues(cfId, cityId, target, levelId, grade);
	}

	@Override
	public String saveCostWarnValues(IBOCostWarnValue[] costWarnValues)
			throws Exception {

		return ((ICostWarnDAO) ServiceFactory.getService(ICostWarnDAO.class))
				.saveCostWarnValues(costWarnValues);
	}

	@Override
	public IBOCostWarnValue getCostWarnValue(String cfId, String cityId,
			String target, String levelId, String grade) throws Exception {

		return getCostWarnValues(cfId, cityId, target, levelId, grade, 0, 1)[0];
	}

}
