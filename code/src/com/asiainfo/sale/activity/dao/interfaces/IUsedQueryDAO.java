package com.asiainfo.sale.activity.dao.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOUsedQueryValue;

public interface IUsedQueryDAO {

	public IBOUsedQueryValue[] queryUsedValue(String cityCode, String resourcetype, 
			String createorg,  String datetime, int startNum, int endNum)
			throws Exception;
	
	public int queryUsedCount(String cityCode, String resourcetype, String createorg, String datetime) throws Exception;
}
