package com.ai.bce.configtool.dao.impl;

import com.ai.bce.bo.BceExtTableConfigEngine;
import com.ai.bce.configtool.dao.interfaces.IConfExtTableDAO;
import com.ai.bce.ivalues.IBceExtTableConfigValue;

public class ConfExtTableDAOImpl implements IConfExtTableDAO {

	public IBceExtTableConfigValue getExtTable(String configId)
			throws NumberFormatException, Exception {
		return BceExtTableConfigEngine.getBean(Long.parseLong(configId));
	}

	public IBceExtTableConfigValue[] getExtTables(String cond, int startIndex,
			int endIndex) throws Exception {
		return BceExtTableConfigEngine.getBeans(null,cond,null,startIndex,endIndex,false);
	}

	public int getExtTablesCount(String cond) throws Exception {
		return BceExtTableConfigEngine.getBeansCount(cond, null);
	}

}
