package com.asiainfo.sale.activity.dao.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOSaleCustGroupValue;

public interface ISaleCustGroupDAO {

	public IBOSaleCustGroupValue[] getCustGroup(String cityId,
			String custGroupName, String createDateF, String createDateE,
			int startNum, int endNum) throws Exception;

	public int getCustGroupCn(String cityId, String custGroupName,
			String createDateF, String createDateE) throws Exception;

	public void addCGroupSchedule(String orderId) throws Exception;
}
