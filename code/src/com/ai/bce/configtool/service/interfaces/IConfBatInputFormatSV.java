package com.ai.bce.configtool.service.interfaces;

import com.ai.bce.ivalues.IBceBatInputFormatValue;

public interface IConfBatInputFormatSV {
public IBceBatInputFormatValue[] getBatInputFormatValues(String cond,int startIndex,int endIndex) throws Exception;
public IBceBatInputFormatValue getBatInputFormatValue(String configId) throws Exception;
public int getBatInputFormatValuesCount(String cond) throws Exception;
}
