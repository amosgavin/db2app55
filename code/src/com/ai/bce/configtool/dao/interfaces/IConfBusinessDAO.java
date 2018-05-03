package com.ai.bce.configtool.dao.interfaces;

import com.ai.bce.bo.BceOperatorBean;

public interface IConfBusinessDAO {
	public BceOperatorBean[] getOperatorBeans(String cond, int startIndex,
			int endIndex) throws Exception;
	public int getOperatorBeansCount(String cond) throws Exception;
	
}
