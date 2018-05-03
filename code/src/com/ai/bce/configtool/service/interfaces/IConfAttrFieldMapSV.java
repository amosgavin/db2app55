package com.ai.bce.configtool.service.interfaces;

import com.ai.bce.ivalues.IBceAttrFieldMapValue;

public interface IConfAttrFieldMapSV {
public IBceAttrFieldMapValue[] getAttrFieldMapValues(String cond,int startIndex,int endIndex) throws Exception;
public int getAttrFieldMapValuesCount(String cond) throws Exception;
public IBceAttrFieldMapValue getAttrFieldMapValue(String configId) throws Exception;
}
