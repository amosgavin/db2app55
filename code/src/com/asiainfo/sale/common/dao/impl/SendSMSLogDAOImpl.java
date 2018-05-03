package com.asiainfo.sale.common.dao.impl;

import java.sql.Timestamp;
import java.util.Date;

import com.asiainfo.sale.common.bo.BOSendSMSLogBean;
import com.asiainfo.sale.common.bo.BOSendSMSLogEngine;
import com.asiainfo.sale.common.dao.interfaces.ISendSMSLogDAO;

public class SendSMSLogDAOImpl implements ISendSMSLogDAO {

	@Override
	public void savaSendSMSLog(String taskId, int sender, int receiver,
			String conment) throws Exception {

		BOSendSMSLogBean log = new BOSendSMSLogBean();

		log.setId(BOSendSMSLogEngine.getNewId().intValue());
		log.setTaskId(taskId);
		log.setSender(sender);
		log.setReceiver(receiver);
		log.setContent(conment);
		log.setSendTime(new Timestamp((new Date()).getTime()));
		log.setStsToNew();

		BOSendSMSLogEngine.save(log);
	}

}
