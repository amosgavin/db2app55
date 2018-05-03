package com.asiainfo.sale.activity.dao.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOResourceChangeValue;

public interface IResourceChangeDAO {

	IBOResourceChangeValue getResourceChange(String resourceId) throws Exception;

	int saveResourceChange(IBOResourceChangeValue resourceChangeValue) throws Exception;

	int queryResourceChangeCount(String resourceId, String applyName,
			String principle, String cityId, String state, String beginTime,
			String endTime) throws Exception;

	IBOResourceChangeValue[] queryResourceChangeValue(String resourceId,
			String applyName, String principle, String cityId, String state,
			String beginTime, String endTime, int startNum, int endNum) throws Exception;
	
	// ÐÞ¸Ä¹¤µ¥×´Ì¬
	public void changeStateTo(String resourceId, String state) throws Exception;

}
