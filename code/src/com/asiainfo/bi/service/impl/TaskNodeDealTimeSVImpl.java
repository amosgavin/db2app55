package com.asiainfo.bi.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.bi.dao.interfaces.ITaskNodeDealTimeDAO;
import com.asiainfo.bi.ivalues.IBOTaskNodeDTValue;
import com.asiainfo.bi.service.interfaces.ITaskNodeDealTimeSV;

public class TaskNodeDealTimeSVImpl implements ITaskNodeDealTimeSV {

	@Override
	public IBOTaskNodeDTValue[] query(String itemId, String itemType,
			String taskReceiverOpid, String taskReceiver, String node,
			String finishDateFrom, String finishDateTo, String dayLe,
			String dayGe, String isDelay, int startNum, int endNum)
			throws Exception {

		return ((ITaskNodeDealTimeDAO) ServiceFactory
				.getService(ITaskNodeDealTimeDAO.class)).query(itemId,
				itemType, taskReceiverOpid, taskReceiver, node, finishDateFrom,
				finishDateTo, dayLe, dayGe, isDelay, startNum, endNum);
	}

	@Override
	public int queryCn(String itemId, String itemType, String taskReceiverOpid,
			String taskReceiver, String node, String finishDateFrom,
			String finishDateTo, String dayLe, String dayGe, String isDelay)
			throws Exception {

		return ((ITaskNodeDealTimeDAO) ServiceFactory
				.getService(ITaskNodeDealTimeDAO.class)).queryCn(itemId,
				itemType, taskReceiverOpid, taskReceiver, node, finishDateFrom,
				finishDateTo, dayLe, dayGe, isDelay);
	}

}
