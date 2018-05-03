package com.asiainfo.sale.activity.dao.impl;

import java.net.URLDecoder;

import com.asiainfo.sale.activity.bo.BOMainDetailContractEngine;
import com.asiainfo.sale.activity.bo.BOSaleMainEngine;
import com.asiainfo.sale.activity.dao.interfaces.IMainDetailContractDAO;
import com.asiainfo.sale.activity.ivalues.IBOMainDetailContractValue;

public class MainDetailContractDAOImpl implements IMainDetailContractDAO{

	@Override
	public int getContractCountBySql(String saleMainCode, String saleMainName,
			String saleActiveCode, String saleActiveName, String isContract)
			throws Exception {
		String condition=getCondition(saleMainCode,
				saleMainName,saleActiveCode,saleActiveName,isContract);
		return BOMainDetailContractEngine.getBeansCount(condition, null);
	}

	@Override
	public IBOMainDetailContractValue[] getContractInfoBySql(
			String saleMainCode, String saleMainName, String saleActiveCode,
			String saleActiveName, String isContract, int startNum, int endNum)
			throws Exception {
		String condition=getCondition(saleMainCode,
				saleMainName,saleActiveCode,saleActiveName,isContract);
		return BOMainDetailContractEngine.getBeans(null, condition, null, startNum, endNum, false);
	}
	
	private String getCondition(String saleMainCode, String saleMainName,
			String saleActiveCode, String saleActiveName, String isContract) throws Exception {

		String condition = " 1=1 ";
		if (saleMainCode != null && !saleMainCode.equals("")) {
			condition += " and sale_main_code = '"
					+ saleMainCode+"'";
		}
		if (saleMainName != null && !saleMainName.equals("")) {
			condition += " and sale_main_name like '%"
					+ URLDecoder.decode(saleMainName, "utf-8") + "%'";
		}
		if (saleActiveCode != null && !saleActiveCode.equals("")) {
			condition += " and sale_active_code = '"
					+ saleActiveCode +"'";
		}
		if (saleActiveName != null && !saleActiveName.equals("")) {
			condition += " and sale_active_name like '%"
					+ URLDecoder.decode(saleActiveName, "utf-8") + "%'";
		}
		if (isContract != null && !isContract.equals("")) {
			if(isContract.equals("null")){
				condition += " and is_contract is null ";
			}else{
			condition += " and is_contract = '"
					+ isContract +"'";
			}
		}
		return condition;
	}

	@Override
	public String saveContract(IBOMainDetailContractValue[] ContractValues)
			throws Exception, RuntimeException {
		// TODO Auto-generated method stub
		BOMainDetailContractEngine.save(ContractValues);
		return null;
	}

}
