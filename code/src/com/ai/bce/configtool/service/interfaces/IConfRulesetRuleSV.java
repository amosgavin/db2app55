package com.ai.bce.configtool.service.interfaces;

import com.ai.bce.ivalues.IBceRulesetRuleValue;

/**
 * ���򼯵Ĺ������ӿ�
 * 
 * @author linzhaoming
 *
 */
public interface IConfRulesetRuleSV {
	
	/**
	 * ����������ȡ���򼯵Ĺ���
	 * @param cond
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IBceRulesetRuleValue[] getBceRulesetRuleValues(String cond,int startIndex,int endIndex)throws Exception;
	
	/**
	 * ����������ȡ���򼯵Ĺ���(��ҳ)
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public int getBceRulesetRuleValuesCount(String cond) throws Exception ;
}
