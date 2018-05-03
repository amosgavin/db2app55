package com.ai.bce.configtool.dao.impl;

import com.ai.bce.bo.BceOperatorBean;
import com.ai.bce.bo.BceOperatorEngine;
import com.ai.bce.configtool.dao.interfaces.IConfBusinessDAO;

public class ConfBusinessDAOImpl implements IConfBusinessDAO {

	public BceOperatorBean[] getOperatorBeans(String cond, int startIndex,
			int endIndex) throws Exception {
		return BceOperatorEngine.getBeans(null, cond, null, startIndex, endIndex, false);
	}

	public int getOperatorBeansCount(String cond) throws Exception {
		return BceOperatorEngine.getBeansCount(cond, null);
	}

}
