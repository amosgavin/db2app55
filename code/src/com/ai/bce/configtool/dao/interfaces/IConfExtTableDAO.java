package com.ai.bce.configtool.dao.interfaces;

import com.ai.bce.ivalues.IBceExtTableConfigValue;

public interface IConfExtTableDAO {
	public IBceExtTableConfigValue getExtTable(String configId) throws NumberFormatException, Exception;
	public IBceExtTableConfigValue[] getExtTables(String cond, int startIndex,
			int endIndex) throws Exception ;
	public int getExtTablesCount(String cond) throws Exception ;
}
