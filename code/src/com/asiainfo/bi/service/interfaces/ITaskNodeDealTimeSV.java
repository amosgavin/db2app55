package com.asiainfo.bi.service.interfaces;

import com.asiainfo.bi.ivalues.IBOTaskNodeDTValue;

public interface ITaskNodeDealTimeSV {

	public IBOTaskNodeDTValue[] query(String itemId, String itemType,
			String taskReceiverOpid, String taskReceiver, String node,
			String finishDateFrom, String finishDateTo, String dayLe,
			String dayGe, String isDelay, int startNum, int endNum)
			throws Exception;

	public int queryCn(String itemId, String itemType, String taskReceiverOpid,
			String taskReceiver, String node, String finishDateFrom,
			String finishDateTo, String dayLe, String dayGe, String isDelay)
			throws Exception;
}
