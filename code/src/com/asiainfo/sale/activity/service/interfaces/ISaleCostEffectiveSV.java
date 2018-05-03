package com.asiainfo.sale.activity.service.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOSaleCostEffectiveValue;

public interface ISaleCostEffectiveSV {
	
	public IBOSaleCostEffectiveValue[] querySaleCostEffectiveValue(String cityCode, String activityType, String datetime, int startNum, int endNum) throws Exception;
	
	public int querySaleCostEffectiveCount(String cityCode, String activityType, String datetime) throws Exception;

}
