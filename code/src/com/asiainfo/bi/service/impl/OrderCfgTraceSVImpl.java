package com.asiainfo.bi.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.bi.dao.interfaces.IOrderCfgTraceDAO;
import com.asiainfo.bi.ivalues.IBOOrderCfgTraceValue;
import com.asiainfo.bi.service.interfaces.IOrderCfgTraceSV;

public class OrderCfgTraceSVImpl implements IOrderCfgTraceSV {

	@Override
	public int getOrderCfgCn(String orderType, String cfgStaff,
			String startTime, String endTime) throws Exception {

		return ((IOrderCfgTraceDAO) ServiceFactory
				.getService(IOrderCfgTraceDAO.class)).getOrderCfgCn(orderType,
				cfgStaff, startTime, endTime);
	}

	@Override
	public IBOOrderCfgTraceValue[] getOrderCfgInfo(String orderType,
			String cfgStaff, String startTime, String endTime, int startNum,
			int endNum) throws Exception {

		return ((IOrderCfgTraceDAO) ServiceFactory
				.getService(IOrderCfgTraceDAO.class)).getOrderCfgInfo(
				orderType, cfgStaff, startTime, endTime, startNum, endNum);
	}

}
