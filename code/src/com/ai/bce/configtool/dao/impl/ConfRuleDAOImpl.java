package com.ai.bce.configtool.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.ai.appframe2.util.criteria.Criteria;
import com.ai.bce.bo.QBceRulesetRuleEngine;
import com.ai.bce.configtool.dao.interfaces.IConfRuleDAO;
import com.ai.bce.ivalues.IQBceRulesetRuleValue;

/**
 * 
 * @author linzhaoming
 *
 */
public class ConfRuleDAOImpl implements IConfRuleDAO{
	
	public IQBceRulesetRuleValue[] getRulesetRulesByRulesetId(String rulesetId, int startNum, int endNum) throws Exception{
		try {
			Criteria criteria = new Criteria();
			criteria.addEqual(IQBceRulesetRuleValue.S_RulesetId, rulesetId);
			criteria.addAscendingOrderByColumn(IQBceRulesetRuleValue.S_SeqNo);
			return QBceRulesetRuleEngine.getBeans(criteria, startNum, endNum, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getRulesetRulesByRulesetIdCount(String rulesetId) throws Exception{
		StringBuffer condition = new StringBuffer();
		condition.append(IQBceRulesetRuleValue.S_RulesetId + " = :rulesetId");
		condition.append(" order by " + IQBceRulesetRuleValue.S_SeqNo);
		Map parameter = new HashMap();
		parameter.put("rulesetId", rulesetId);
		return QBceRulesetRuleEngine.getBeansCount(condition.toString(), parameter);//(condition.toString(), parameter);
	}
}
