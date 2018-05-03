package com.ai.bce.configtool.service.interfaces;

import com.ai.bce.ivalues.IBceRulesetValue;

/**
 * ���򼯷���ӿ�
 * @author linzhaoming
 *
 */
public interface IConfRulesetSV {

	/**
	 * ��ҳ��ȡ�������
	 * @param cond
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IBceRulesetValue[] getBceRulesetValues(String cond,int startIndex,int endIndex)throws Exception;
	
	/**
	 * ��ҳ��ȡ�������
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public int getBceRulesetValuesCount(String cond) throws Exception;
}
