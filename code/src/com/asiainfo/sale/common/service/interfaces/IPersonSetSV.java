package com.asiainfo.sale.common.service.interfaces;

public interface IPersonSetSV {

	public void savePersonInfo(int operatorId, String isReceiveSMS,
			String isReceiveSysInfo) throws Exception;

	public boolean isReceiveSMS(int operatorId) throws Exception;
}
