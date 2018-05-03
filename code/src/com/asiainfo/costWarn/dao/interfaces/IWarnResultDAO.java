package com.asiainfo.costWarn.dao.interfaces;

import com.asiainfo.costWarn.ivalues.IBOWarnResultValue;

public interface IWarnResultDAO {

	public int count(String resource_type,String up_down,String city_code) throws Exception;

	public IBOWarnResultValue[] select(String resource_type,String up_down,String city_code, int startNum, int endNum) throws Exception;

	public void insert(IBOWarnResultValue vls) throws Exception;

}
