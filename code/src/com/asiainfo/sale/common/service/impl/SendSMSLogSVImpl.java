package com.asiainfo.sale.common.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.common.dao.interfaces.ISendSMSLogDAO;
import com.asiainfo.sale.common.service.interfaces.ISendSMSLogSV;

public class SendSMSLogSVImpl implements ISendSMSLogSV {

	@Override
	public void savaSendSMSLog(String taskId, int sender, int receiver,
			String conment) throws Exception {

		((ISendSMSLogDAO) ServiceFactory.getService(ISendSMSLogDAO.class))
				.savaSendSMSLog(taskId, sender, receiver, conment);
	}
}