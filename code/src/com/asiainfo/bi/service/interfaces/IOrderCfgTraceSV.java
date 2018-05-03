package com.asiainfo.bi.service.interfaces;

import com.asiainfo.bi.ivalues.IBOOrderCfgTraceValue;

public interface IOrderCfgTraceSV {

	public IBOOrderCfgTraceValue[] getOrderCfgInfo(String orderType,
			String cfgStaff, String startTime, String endTime, int startNum,
			int endNum) throws Exception;

	public int getOrderCfgCn(String orderType, String cfgStaff,
			String startTime, String endTime) throws Exception;
}
