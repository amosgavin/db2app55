package com.ai.bce.configtool.service.interfaces;

import com.ai.bce.ivalues.IBceRulesetRuleValue;

/**
 * 规则集的规则服务接口
 * 
 * @author linzhaoming
 *
 */
public interface IConfRulesetRuleSV {
	
	/**
	 * 根据条件获取规则集的规则
	 * @param cond
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IBceRulesetRuleValue[] getBceRulesetRuleValues(String cond,int startIndex,int endIndex)throws Exception;
	
	/**
	 * 根据条件获取规则集的规则(分页)
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public int getBceRulesetRuleValuesCount(String cond) throws Exception ;
}
