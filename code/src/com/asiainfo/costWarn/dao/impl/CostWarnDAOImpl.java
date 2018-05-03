package com.asiainfo.costWarn.dao.impl;

import com.asiainfo.costWarn.bo.BOCostWarnEngine;
import com.asiainfo.costWarn.dao.interfaces.ICostWarnDAO;
import com.asiainfo.costWarn.ivalues.IBOCostWarnValue;

public class CostWarnDAOImpl implements ICostWarnDAO {

	@Override
	public void deleteCostWarnValues(IBOCostWarnValue[] costWarnValues)
			throws Exception {

		for (int i = 0; i < costWarnValues.length; ++i) {
			costWarnValues[i].delete();
		}
		BOCostWarnEngine.save(costWarnValues);
	}

	@Override
	public String saveCostWarnValues(IBOCostWarnValue[] costWarnValues)
			throws Exception {

		if (costWarnValues != null && costWarnValues.length > 0) {
			for (int i = 0; i < costWarnValues.length; ++i) {
				if (costWarnValues[i].isNew()) {
					if (existTheCostWarn(costWarnValues[i])) {
						return "exist";
					}
					costWarnValues[i].setCfId(BOCostWarnEngine.getNewId()
							.intValue());
					costWarnValues[i].setStsToNew();
				}
			}
			BOCostWarnEngine.save(costWarnValues);
		}
		return "";
	}

	@Override
	public IBOCostWarnValue[] getCostWarnValues(String cfId, String cityId,
			String target, String levelId, String grade, int startNum,
			int endNum) throws Exception {

		return BOCostWarnEngine.getBeans(null, getCondition(cfId, cityId,
				target, levelId, grade), null, startNum, endNum, false);
	}

	@Override
	public int getCountCostWarnValues(String cfId, String cityId,
			String target, String levelId, String grade) throws Exception {

		return BOCostWarnEngine.getBeansCount(getCondition(cfId, cityId,
				target, levelId, grade), null);
	}

	private String getCondition(String cfId, String cityId, String target,
			String levelId, String grade) {

		String condition = " 1=1 ";
		if (cfId != null && !cfId.equals("")) {
			condition += " and " + IBOCostWarnValue.S_CfId + " = " + cfId;
		}
		if (cityId != null && !cityId.equals("")) {
			condition += " and " + IBOCostWarnValue.S_CityId + " = " + cityId;
		}
		if (target != null && !target.equals("")) {
			condition += " and " + IBOCostWarnValue.S_Target + " = '" + target
					+ "'";
		}
		if (levelId != null && !levelId.equals("")) {
			condition += " and " + IBOCostWarnValue.S_LevelId + " = '"
					+ levelId + "'";
		}
		if (grade != null && !grade.equals("")) {
			condition += " and " + IBOCostWarnValue.S_Grade + " = '" + grade
					+ "'";
		}
		return condition;
	}

	private boolean existTheCostWarn(IBOCostWarnValue costWarnValues)
			throws Exception {

		String cityId = String.valueOf(costWarnValues.getCityId());
		String target = costWarnValues.getTarget();
		String levelId = costWarnValues.getLevelId();
		String grade = costWarnValues.getGrade();
		/*
		 * String condition = " " + IBOCostWarnValue.S_CityId + " = " + cityId +
		 * " and " + IBOCostWarnValue.S_Target + " = '" + target + "'"; if
		 * (levelId != null && !levelId.equals("")) { condition += " and " +
		 * IBOCostWarnValue.S_LevelId + " = '" + levelId + "'"; } if (grade !=
		 * null && !grade.equals("")) { condition += " and " +
		 * IBOCostWarnValue.S_Grade + " = '" + grade + "'"; }
		 */
		return (getCountCostWarnValues(null, cityId, target, levelId, grade) > 0) ? true
				: false;
	}
}
