package com.ai.bce.configtool.dao.interfaces;

import com.ai.bce.bo.BceFrameJavaRulesetRelBean;

/**
 * Java������ش����߼�DAO�ӿ�
 * @author linzhaoming
 *
 */
public interface IConfJavaRuleDAO {
	
	/**
	 * ͨ��������ȡ�����ܹ�����java����
	 * @param rulesetId
	 * @return
	 * @throws Exception
	 */
	public BceFrameJavaRulesetRelBean[] getJavaRulesetByCond(
			String cond,int startIndex,int endIndex) throws Exception;
	
	/**
	 * ͨ��������ȡ�����ܹ�����java����(��ҳ����)
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public int getJavaRulesetByCondCount(String cond) throws Exception;
}
