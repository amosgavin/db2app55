package com.ai.bce.configtool.dao.interfaces;

import com.ai.bce.ivalues.IBceBatInputFormatValue;

public interface IConfBatInputFormatDAO {
	public IBceBatInputFormatValue[] getBatInputFormatValues(String cond,
			int startIndex, int endIndex) throws Exception;
	public int getBatInputFormatValuesCount(String cond) throws Exception ;
	public IBceBatInputFormatValue getBatInputFormatValue(String configId)
	throws Exception ;
}
