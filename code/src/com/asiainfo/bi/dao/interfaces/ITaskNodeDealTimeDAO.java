package com.asiainfo.bi.dao.interfaces;

import java.sql.Timestamp;

import com.asiainfo.bi.ivalues.IBOTaskNodeDTValue;

public interface ITaskNodeDealTimeDAO {

	public IBOTaskNodeDTValue[] query(String itemId, String itemType,
			String taskReceiverOpid, String taskReceiver, String node,
			String finishDateFrom, String finishDateTo, String dayLe,
			String dayGe, String isDelay, int startNum, int endNum)
			throws Exception;

	public int queryCn(String itemId, String itemType, String taskReceiverOpid,
			String taskReceiver, String node, String finishDateFrom,
			String finishDateTo, String dayLe, String dayGe, String isDelay)
			throws Exception;

	public int getCurrentTaskNum(String taskReceiverOpid, String itemType)
			throws Exception;

	public Timestamp getLastTaskEndTime(String taskReceiverOpid)
			throws Exception;
}
