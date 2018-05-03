package com.ai.bce.configtool.service.impl;

import com.ai.bce.bo.BceRulesetEngine;
import com.ai.bce.configtool.service.interfaces.IConfRulesetSV;
import com.ai.bce.ivalues.IBceRulesetValue;

/**
 * 规则集服务实现
 * @author linzhaoming
 *
 */
public class ConfRulesetSVImpl implements IConfRulesetSV {
	public IBceRulesetValue[] getBceRulesetValues(String cond,int startIndex,int endIndex)throws Exception{
		return BceRulesetEngine.getBeans(null, cond, null, startIndex, endIndex, false);
	}
	
	public int getBceRulesetValuesCount(String cond) throws Exception {
		return BceRulesetEngine.getBeansCount(cond, null);
	}
}
