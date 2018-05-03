package com.asiainfo.sale.common.dao.interfaces;

public interface ISendSMSLogDAO {

	public void savaSendSMSLog(String taskId, int sender, int receiver,
			String conment) throws Exception;
}
