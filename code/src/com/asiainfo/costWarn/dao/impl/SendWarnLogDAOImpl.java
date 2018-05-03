package com.asiainfo.costWarn.dao.impl;

import com.asiainfo.costWarn.bo.BOSendWarnLogEngine;
import com.asiainfo.costWarn.dao.interfaces.ISendWarnLogDAO;
import com.asiainfo.costWarn.ivalues.IBOSendWarnLogValue;

public class SendWarnLogDAOImpl implements ISendWarnLogDAO {

	@Override
	public IBOSendWarnLogValue[] getSendedWarnLog(String cityId, String target,
			String levelId, String grade) throws Exception {

		return BOSendWarnLogEngine.getBeans(getCondition(cityId, target,
				levelId, grade), null);
	}

	@Override
	public void saveSendWarnLog(IBOSendWarnLogValue warnLog) throws Exception {

		if (warnLog != null) {
			warnLog.setLogId(BOSendWarnLogEngine.getNewId().intValue());
			warnLog.setStsToNew();
			BOSendWarnLogEngine.save(warnLog);
		}
	}

	private String getCondition(String cityId, String target, String levelId,
			String grade) {

		String condition = " 1=1 ";
		if (cityId != null && !cityId.equals("")) {
			condition += " and " + IBOSendWarnLogValue.S_CityId + " = "
					+ cityId;
		}
		if (target != null && !target.equals("")) {
			condition += " and " + IBOSendWarnLogValue.S_Target + " = '"
					+ target + "'";
		}
		if (levelId != null && !levelId.equals("")) {
			condition += " and " + IBOSendWarnLogValue.S_LevelId + " = '"
					+ levelId + "'";
		}
		if (grade != null && !grade.equals("")) {
			condition += " and " + IBOSendWarnLogValue.S_Grade + " = '" + grade
					+ "'";
		}
		condition += " order by insert_time desc FETCH FIRST  1 ROWS only";
		return condition;
	}
}
