package com.asiainfo.common.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.common.dao.interfaces.IItemOtherInfoDAO;
import com.asiainfo.common.ivalues.IBOItemOtherInfoValue;
import com.asiainfo.common.service.interfaces.IItemOtherInfoSV;

public class ItemOtherInfoSVImpl implements IItemOtherInfoSV {

	@Override
	public IBOItemOtherInfoValue getItemOtherInfoByIdAndTag(String itemId,
			String taskTag) throws Exception {

		return ((IItemOtherInfoDAO) ServiceFactory
				.getService(IItemOtherInfoDAO.class))
				.getItemOtherInfoByIdAndTag(itemId, taskTag);
	}

	@Override
	public void saveAdviseFinishDate(String itemId, String taskTag,
			String adviseDate, String delayReason, String approveFlag)
			throws Exception {

		((IItemOtherInfoDAO) ServiceFactory.getService(IItemOtherInfoDAO.class))
				.saveAdviseFinishDate(itemId, taskTag, adviseDate, delayReason,
						approveFlag);
	}

	@Override
	public String getAdviseDate(String itemType, String fromTime, int diffDays)
			throws Exception {

		return ((IItemOtherInfoDAO) ServiceFactory
				.getService(IItemOtherInfoDAO.class)).getAdviseDate(itemType,
				fromTime, diffDays);
	}

	@Override
	public String getLastTaskEndTime(String taskReceiverOpid) throws Exception {

		return ((IItemOtherInfoDAO) ServiceFactory
				.getService(IItemOtherInfoDAO.class))
				.getLastTaskEndTime(taskReceiverOpid);
	}

	@Override
	public int getNeedDays(String itemId, String itemType) throws Exception {

		return ((IItemOtherInfoDAO) ServiceFactory
				.getService(IItemOtherInfoDAO.class)).getNeedDays(itemId,
				itemType);
	}

	@Override
	public boolean moreThanMaxTaskPerMan(String taskReceiverOpid,
			String itemType) throws Exception {

		return ((IItemOtherInfoDAO) ServiceFactory
				.getService(IItemOtherInfoDAO.class)).moreThanMaxTaskPerMan(
				taskReceiverOpid, itemType);
	}
}
