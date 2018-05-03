package com.asiainfo.sale.activity.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.activity.dao.interfaces.IContractDAO;
import com.asiainfo.sale.activity.dao.interfaces.IMainDetailContractDAO;
import com.asiainfo.sale.activity.ivalues.IBOMainDetailContractValue;
import com.asiainfo.sale.activity.service.interfaces.IMainDetailContractSV;

public class MainDetailContractSVImpl implements IMainDetailContractSV{

	@Override
	public int getContractCountBySql(String saleMainCode, String saleMainName,
			String saleActiveCode, String saleActiveName, String isContract)
			throws Exception {
		return ((IMainDetailContractDAO) ServiceFactory.getService(IMainDetailContractDAO.class))
		.getContractCountBySql(saleMainCode,saleMainName,saleActiveCode,saleActiveName,isContract);
	}

	@Override
	public IBOMainDetailContractValue[] getContractInfoBySql(
			String saleMainCode, String saleMainName, String saleActiveCode,
			String saleActiveName, String isContract, int startNum, int endNum)
			throws Exception {
		return ((IMainDetailContractDAO) ServiceFactory.getService(IMainDetailContractDAO.class))
		.getContractInfoBySql(saleMainCode,saleMainName,saleActiveCode,saleActiveName,isContract,startNum,endNum);
	}

	@Override
	public String saveContract(IBOMainDetailContractValue[] ContractValues)
			throws Exception, RuntimeException {
		// TODO Auto-generated method stub
		return ((IMainDetailContractDAO) ServiceFactory.getService(IMainDetailContractDAO.class))
		.saveContract(ContractValues);
	}

}
