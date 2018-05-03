package com.ai.bce.configtool.dao.interfaces;

import com.ai.bce.bo.BceFrameJavaRulesetRelBean;

/**
 * Java规则相关处理逻辑DAO接口
 * @author linzhaoming
 *
 */
public interface IConfJavaRuleDAO {
	
	/**
	 * 通过条件获取受理框架关联的java规则集
	 * @param rulesetId
	 * @return
	 * @throws Exception
	 */
	public BceFrameJavaRulesetRelBean[] getJavaRulesetByCond(
			String cond,int startIndex,int endIndex) throws Exception;
	
	/**
	 * 通过条件获取受理框架关联的java规则集(分页数量)
	 * @param cond
	 * @return
	 * @throws Exception
	 */
	public int getJavaRulesetByCondCount(String cond) throws Exception;
}
