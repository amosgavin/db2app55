package com.ai.bce.configtool.dao.impl;

import com.ai.bce.bo.BceBatInputFormatEngine;
import com.ai.bce.configtool.dao.interfaces.IConfBatInputFormatDAO;
import com.ai.bce.ivalues.IBceBatInputFormatValue;

public class ConfBatInputFormatDAOImpl implements IConfBatInputFormatDAO {

	public IBceBatInputFormatValue getBatInputFormatValue(String configId)
			throws Exception {
		return BceBatInputFormatEngine.getBean(Long.parseLong(configId));
	}

	public IBceBatInputFormatValue[] getBatInputFormatValues(String cond,
			int startIndex, int endIndex) throws Exception {
		return BceBatInputFormatEngine.getBeans(null, cond, null, startIndex, endIndex, false);
	}

	public int getBatInputFormatValuesCount(String cond) throws Exception {
		return BceBatInputFormatEngine.getBeansCount(cond, null);
	}

}
