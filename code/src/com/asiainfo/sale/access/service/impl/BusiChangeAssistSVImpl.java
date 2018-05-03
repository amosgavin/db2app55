package com.asiainfo.sale.access.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.access.dao.interfaces.IBusiChangeAssistDAO;
import com.asiainfo.sale.access.service.interfaces.IBusiChangeAssistSV;

public class BusiChangeAssistSVImpl implements IBusiChangeAssistSV {

	@Override
	public String checkChannelId(String channelIdStr) throws Exception {

		return ((IBusiChangeAssistDAO) ServiceFactory
				.getService(IBusiChangeAssistDAO.class))
				.checkChannelId(channelIdStr);
	}

	@Override
	public String getSaleHandles(String feeId) throws Exception {

		return ((IBusiChangeAssistDAO) ServiceFactory
				.getService(IBusiChangeAssistDAO.class)).getSaleHandles(feeId);
	}

}
