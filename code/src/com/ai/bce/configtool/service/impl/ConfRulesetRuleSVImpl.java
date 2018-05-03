package com.ai.bce.configtool.service.impl;

import com.ai.bce.bo.BceRulesetRuleEngine;
import com.ai.bce.configtool.service.interfaces.IConfRulesetRuleSV;
import com.ai.bce.ivalues.IBceRulesetRuleValue;

/**
 * ���򼯵Ĺ������ʵ��
 * @author linzhaoming
 *
 */
public class ConfRulesetRuleSVImpl implements IConfRulesetRuleSV{
	
	public IBceRulesetRuleValue[] getBceRulesetRuleValues(String cond,int startIndex,int endIndex)throws Exception{
		return BceRulesetRuleEngine.getBeans(null, cond, null, startIndex, endIndex, false);
	}
	
	public int getBceRulesetRuleValuesCount(String cond) throws Exception {
		return BceRulesetRuleEngine.getBeansCount(cond, null);
	}
}
