package com.asiainfo.costWarn.service.interfaces;

import com.asiainfo.costWarn.ivalues.IBOWarnResultValue;

public interface IWarnResultSV {

	public IBOWarnResultValue[] select(String resource_type,String up_down,String city_code,int startNum, int endNum) throws Exception;
	
	public int count(String resource_type,String up_down,String city_code) throws Exception;

	public void insert(IBOWarnResultValue vls) throws Exception;
}
