package com.asiainfo.sale.common.dao.interfaces;

public interface IPersonSetDAO {

	public void savePersonInfo(int operatorId, String isReceiveSMS, String isReceiveSysInfo) throws Exception;
	
	public boolean isReceiveSMS(int operatorId) throws Exception;
}
