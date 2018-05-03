package com.asiainfo.sale.activity.service.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOResourceChangeValue;



public interface IResourceChangeSV {
	public IBOResourceChangeValue getResourceChange(String ResourceId)
			throws Exception;
	
	public int saveResourceChange(IBOResourceChangeValue resourceChangeValue) throws Exception;
	
	public IBOResourceChangeValue[] queryResourceChangeValue(String resourceId,
			String applyName, String principle, String cityId, String state,
			String beginTime, String endTime, int startNum, int endNum)
			throws Exception;

	
	public int queryResourceChangeCount(String resourceId, String applyName,
			String principle, String cityId, String state, String beginTime,
			String endTime) throws Exception;
	
	public void changeStateToPass(String resourceId) throws Exception;
	
	public void changeStateToNoPass(String resourceId) throws Exception;

}

