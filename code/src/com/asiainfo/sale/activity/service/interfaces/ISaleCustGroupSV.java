package com.asiainfo.sale.activity.service.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOSaleCustGroupValue;

public interface ISaleCustGroupSV {

	public IBOSaleCustGroupValue[] getCustGroup(String cityId,
			String custGroupName, String createDateF, String createDateE,
			int startNum, int endNum) throws Exception;
	
	public int getCustGroupCn(String cityId, String custGroupName,
			String createDateF, String createDateE) throws Exception;
}
