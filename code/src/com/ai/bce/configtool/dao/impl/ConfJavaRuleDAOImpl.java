package com.ai.bce.configtool.dao.impl;

import com.ai.bce.bo.BceFrameJavaRulesetRelBean;
import com.ai.bce.bo.BceFrameJavaRulesetRelEngine;
import com.ai.bce.configtool.dao.interfaces.IConfJavaRuleDAO;

/**
 * Java规则相关处理逻辑DAO实现
 * 
 * @author linzhaoming
 *
 */
public class ConfJavaRuleDAOImpl implements IConfJavaRuleDAO {

	public BceFrameJavaRulesetRelBean[] getJavaRulesetByCond(String cond,int startIndex,int endIndex) throws Exception {
		
		BceFrameJavaRulesetRelBean[] beans = BceFrameJavaRulesetRelEngine.getBeans(
					null,cond, null, startIndex, endIndex, false);
		return beans;
	}
	
	public int getJavaRulesetByCondCount(String cond) throws Exception{
		return BceFrameJavaRulesetRelEngine.getBeansCount(cond, null);
	}
}
