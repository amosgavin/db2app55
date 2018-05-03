package com.asiainfo.sale.activity.dao.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOMainDetailContractValue;

public interface IMainDetailContractDAO {
	public IBOMainDetailContractValue[] getContractInfoBySql(String sale_main_code,
			String sale_main_name, String sale_active_code,
			String sale_active_name, String is_contract, int startNum,
			int endNum) throws Exception;
	
	public int getContractCountBySql(String sale_main_code,
			String sale_main_name, String sale_active_code,
			String sale_active_name, String is_contract) throws Exception;
	
	public String saveContract(IBOMainDetailContractValue[] ContractValues)
	throws Exception, RuntimeException;
}
