package com.ai.bce.configtool.service.interfaces;

import com.ai.bce.ivalues.IBceExtTableConfigValue;

public interface IConfExtTableSV {
public IBceExtTableConfigValue[] getExtTables(String cond,int startIndex,int endIndex) throws Exception;
public int getExtTablesCount(String cond) throws Exception;
public IBceExtTableConfigValue getExtTable(String configId) throws NumberFormatException, Exception;
}
