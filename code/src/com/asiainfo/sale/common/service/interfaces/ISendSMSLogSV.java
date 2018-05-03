package com.asiainfo.sale.common.service.interfaces;

public interface ISendSMSLogSV {

	public void savaSendSMSLog(String taskId, int sender, int receiver,
			String conment) throws Exception;
}
