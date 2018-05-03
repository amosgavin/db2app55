package com.asiainfo.sale.activity.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.activity.dao.interfaces.ISaleChannelInfoDAO;
import com.asiainfo.sale.activity.ivalues.IBOChannelInfoValue;
import com.asiainfo.sale.activity.service.interfaces.ISaleChannelInfoSV;

public class SaleChannelInfoSVImpl implements ISaleChannelInfoSV {

	@Override
	public IBOChannelInfoValue[] getChannelInfoByRelaId(String relaId,
			String relaType, int startNum, int endNum) throws Exception {
		return ((ISaleChannelInfoDAO) ServiceFactory
				.getService(ISaleChannelInfoDAO.class)).getChannelInfoByRelaId(
				relaId, relaType, startNum, endNum);
	}

	@Override
	public void save(IBOChannelInfoValue[] values) throws Exception {

		((ISaleChannelInfoDAO) ServiceFactory
				.getService(ISaleChannelInfoDAO.class)).save(values);
	}

	@Override
	public int getCnChannelListByRelaId(String relaId, String relaType)
			throws Exception {

		return ((ISaleChannelInfoDAO) ServiceFactory
				.getService(ISaleChannelInfoDAO.class))
				.getCnChannelListByRelaId(relaId, relaType);
	}

}
