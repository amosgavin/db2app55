package com.asiainfo.common.service.interfaces;

import com.asiainfo.common.ivalues.IBOItemOtherInfoValue;

public interface IItemOtherInfoSV {

	public IBOItemOtherInfoValue getItemOtherInfoByIdAndTag(String itemId,
			String taskTag) throws Exception;

	public void saveAdviseFinishDate(String itemId, String taskTag,
			String adviseDate, String delayReason, String approveFlag)
			throws Exception;

	public String getAdviseDate(String itemType, String fromTime, int diffDays)
			throws Exception;

	public int getNeedDays(String itemId, String itemType) throws Exception;

	public String getLastTaskEndTime(String taskReceiverOpid) throws Exception;

	public boolean moreThanMaxTaskPerMan(String taskReceiverOpid,
			String itemType) throws Exception;
}
