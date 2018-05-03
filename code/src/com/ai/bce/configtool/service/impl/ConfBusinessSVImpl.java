package com.ai.bce.configtool.service.impl;

import com.ai.bce.bo.BceOperatorBean;
import com.ai.bce.configtool.dao.interfaces.IConfBusinessDAO;
import com.ai.bce.configtool.service.interfaces.IConfBusinessSV;
import com.ai.bce.util.BServiceFactory;

public class ConfBusinessSVImpl implements IConfBusinessSV {

	public BceOperatorBean[] getOperatorBeans(String cond, int startIndex,
			int endIndex) throws Exception {
		return getDao().getOperatorBeans(cond, startIndex, endIndex);
	}

	public int getOperatorBeansCount(String cond) throws Exception {
		return getDao().getOperatorBeansCount(cond);
	}
	
	public IConfBusinessDAO getDao() throws Exception{
		return (IConfBusinessDAO) BServiceFactory.getService(IConfBusinessDAO.class);
	}
}
