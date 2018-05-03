package com.asiainfo.sale.activity.service.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOUsedQueryValue;

public interface IUsedQuerySV {

	
	public IBOUsedQueryValue[] queryUsedValue(String cityCode, String resourcetype, 
			String createorg, String datetime, int startNum, int endNum)
			throws Exception;
	
	public int queryUsedCount(String cityCode, String resourcetype, String createorg, String datetime) throws Exception;
}
