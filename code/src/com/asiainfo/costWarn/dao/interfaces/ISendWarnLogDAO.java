package com.asiainfo.costWarn.dao.interfaces;

import com.asiainfo.costWarn.ivalues.IBOSendWarnLogValue;

public interface ISendWarnLogDAO {

	public void saveSendWarnLog(IBOSendWarnLogValue log) throws Exception;

	public IBOSendWarnLogValue[] getSendedWarnLog(String city_id,
			String target, String levelId, String grade) throws Exception;
}
