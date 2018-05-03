package com.asiainfo.charge.service.interfaces;

import com.asiainfo.charge.ivalues.IBODynamicSumValue;

public interface IDynamicSumSV {
	public String saveDynamicSum(IBODynamicSumValue dynamicSumValue)
	throws Exception, RuntimeException;
	
	public IBODynamicSumValue  getDynamicSumById(String id)
	throws Exception, RuntimeException;
}
