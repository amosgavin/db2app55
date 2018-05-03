package com.ai.bce.configtool.dao.interfaces;

import com.ai.bce.ivalues.IQBceRulesetRuleValue;

/**
 * 
 * @author linzhaoming
 *
 */
public interface IConfRuleDAO {
	public IQBceRulesetRuleValue[] getRulesetRulesByRulesetId(String rulesetId, int startNum, int endNum) throws Exception;
	
	public int getRulesetRulesByRulesetIdCount(String rulesetId) throws Exception;
}
