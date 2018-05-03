package com.ai.bce.configtool.dao.impl;

import com.ai.bce.bo.BceAttrFieldMapEngine;
import com.ai.bce.configtool.dao.interfaces.IConfAttrFieldMapDAO;
import com.ai.bce.ivalues.IBceAttrFieldMapValue;

public class ConfAttrFieldMapDAOImpl implements IConfAttrFieldMapDAO {

	public IBceAttrFieldMapValue getAttrFieldMapValue(String configId)
			throws Exception {
		return BceAttrFieldMapEngine.getBean(Long.parseLong(configId));
	}

	public IBceAttrFieldMapValue[] getAttrFieldMapValues(String cond,
			int startIndex, int endIndex) throws Exception {
		return BceAttrFieldMapEngine.getBeans(null, cond, null, startIndex, endIndex, false);
	}

	public int getAttrFieldMapValuesCount(String cond) throws Exception {
		return BceAttrFieldMapEngine.getBeansCount(cond, null);
	}

}
