package com.ai.bce.configtool.dao.impl;

import com.ai.bce.bo.BceBatInputFieldFormatEngine;
import com.ai.bce.configtool.dao.interfaces.IConfBatInputFieldFormatDAO;
import com.ai.bce.ivalues.IBceBatInputFieldFormatValue;

public class ConfBatInputFieldFormatDAOImpl implements
		IConfBatInputFieldFormatDAO {

	public IBceBatInputFieldFormatValue getBatInputFieldFormatValue(
			String configId, String listType, String seqNo) throws Exception {
		return BceBatInputFieldFormatEngine.getBean(Integer.parseInt(listType),Long.parseLong(configId), Integer.parseInt(seqNo));
	}

	public IBceBatInputFieldFormatValue[] getBatInputFieldFormatValues(
			String cond, int startIndex, int endIndex) throws Exception {
		return BceBatInputFieldFormatEngine.getBeans(null, cond, null, startIndex, endIndex, false);
	}

	public int getBatInputFieldFormatValuesCount(String cond) throws Exception {
		return BceBatInputFieldFormatEngine.getBeansCount(cond, null);
	}

}
