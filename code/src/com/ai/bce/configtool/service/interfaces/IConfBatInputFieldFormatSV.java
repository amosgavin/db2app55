package com.ai.bce.configtool.service.interfaces;

import com.ai.bce.ivalues.IBceBatInputFieldFormatValue;

public interface IConfBatInputFieldFormatSV {
	public IBceBatInputFieldFormatValue[] getBatInputFieldFormatValues(String cond,int startIndex,int endIndex) throws Exception;
	public int getBatInputFieldFormatValuesCount(String cond) throws Exception;
	public IBceBatInputFieldFormatValue getBatInputFieldFormatValue(String configId,String listType,String seqNo) throws Exception;
}
