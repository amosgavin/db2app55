package com.asiainfo.costWarn.dao.impl;

import com.asiainfo.costWarn.bo.BOCostWarnReceiverEngine;
import com.asiainfo.costWarn.dao.interfaces.ICostWarnReceiverDAO;
import com.asiainfo.costWarn.ivalues.IBOCostWarnReceiverValue;

public class CostWarnReceiverDAOImpl implements ICostWarnReceiverDAO {

	@Override
	public void deleteCostWarnReceiverValues(
			IBOCostWarnReceiverValue[] costWarnReceiverValues) throws Exception {

		if (costWarnReceiverValues != null) {

			for (int i = 0; i < costWarnReceiverValues.length; ++i) {
				costWarnReceiverValues[i].delete();
			}
			BOCostWarnReceiverEngine.save(costWarnReceiverValues);
		}
	}

	@Override
	public void saveCostWarnReceiverValues(
			IBOCostWarnReceiverValue[] costWarnReceiverValues) throws Exception {

		if (costWarnReceiverValues != null && costWarnReceiverValues.length > 0) {
			for (int i = 0; i < costWarnReceiverValues.length; ++i) {
				if (costWarnReceiverValues[i].isNew()) {
					costWarnReceiverValues[i]
							.setPersonId(BOCostWarnReceiverEngine.getNewId()
									.intValue());
					costWarnReceiverValues[i].setStsToNew();
				}
			}
			BOCostWarnReceiverEngine.save(costWarnReceiverValues);
		}
	}

	@Override
	public IBOCostWarnReceiverValue[] getCostWarnReceiverValues(
			String personId, String cityId, String target, String levelId,
			String grade, String billId, int startNum, int endNum)
			throws Exception {

		return BOCostWarnReceiverEngine.getBeans(null, getCondition(personId,
				cityId, target, levelId, grade, billId), null, startNum,
				endNum, false);
	}

	@Override
	public int getCountCostWarnReceiverValues(String personId, String cityId,
			String target, String levelId, String grade, String billId)
			throws Exception {

		return BOCostWarnReceiverEngine.getBeansCount(getCondition(personId,
				cityId, target, levelId, grade, billId), null);
	}

	private String getCondition(String personId, String cityId, String target,
			String levelId, String grade, String billId) {

		String condition = " 1=1 ";
		if (personId != null && !personId.equals("")) {
			condition += " and " + IBOCostWarnReceiverValue.S_PersonId + " = "
					+ personId;
		}
		if (cityId != null && !cityId.equals("")) {
			condition += " and " + IBOCostWarnReceiverValue.S_CityId + " = "
					+ cityId;
		}
		if (target != null && !target.equals("") && target.equals("L1")) {
			condition += " and " + IBOCostWarnReceiverValue.S_Target
					+ " like '" + target.substring(0, 1) + "%'";
		}
		if (levelId != null && !levelId.equals("")) {
			condition += " and " + IBOCostWarnReceiverValue.S_LevelId + " = "
					+ levelId;
		}
		if (grade != null && !grade.equals("")) {
			condition += " and " + IBOCostWarnReceiverValue.S_Grade + " = "
					+ grade;
		}
		if (billId != null && !billId.equals("")) {
			condition += " and " + IBOCostWarnReceiverValue.S_BillId + " = "
					+ billId;
		}
		return condition;
	}
}
