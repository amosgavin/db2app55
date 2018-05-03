package com.asiainfo.charge.dao.interfaces;

import com.asiainfo.charge.ivalues.IBODynamicSumValue;


public interface IDynamicSumDAO {
	public String saveDynamicSum(IBODynamicSumValue dynamicSumValue)
	throws Exception, RuntimeException;
	
	public IBODynamicSumValue  getDynamicSumById(String id)
	throws Exception, RuntimeException;
}
