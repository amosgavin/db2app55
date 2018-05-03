package com.asiainfo.sale.activity.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.activity.dao.interfaces.IContractDAO;
import com.asiainfo.sale.activity.ivalues.IBOContractValue;
import com.asiainfo.sale.activity.service.interfaces.IContractSV;

public class ContractSVImpl implements IContractSV{

	@Override
	public int getContractCountBySql(String saleMainCode, String saleMainName,
			String saleActiveCode, String saleActiveName, String isContract)
			throws Exception {
		// TODO Auto-generated method stub
		return ((IContractDAO) ServiceFactory.getService(IContractDAO.class))
		.getContractCountBySql(saleMainCode,saleMainName,saleActiveCode,saleActiveName,isContract);
	}

	@Override
	public IBOContractValue[] getContractInfoBySql(String saleMainCode,
			String saleMainName, String saleActiveCode, String saleActiveName,
			String isContract, int startNum, int endNum) throws Exception {
		// TODO Auto-generated method stub
		return ((IContractDAO) ServiceFactory.getService(IContractDAO.class))
		.getContractInfoBySql(saleMainCode,saleMainName,saleActiveCode,saleActiveName,isContract,startNum,endNum);
	}

	@Override
	public String saveContract(IBOContractValue[] ContractValues)
			throws Exception, RuntimeException {
		// TODO Auto-generated method stub
		return ((IContractDAO) ServiceFactory.getService(IContractDAO.class))
		.saveContract(ContractValues);
	}

}
