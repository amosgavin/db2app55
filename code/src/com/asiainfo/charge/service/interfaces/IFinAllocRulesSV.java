package com.asiainfo.charge.service.interfaces;

import com.asiainfo.charge.ivalues.IBOFinAllocRulesValue;

public interface IFinAllocRulesSV {

	/**
	 * 根据资费ID查询财务分摊规则信息
	 * 
	 * @param chargeId
	 *            资费ID
	 * @param startNum
	 *            分页记录开始索引
	 * @param endNum
	 *            分页记录结束索引
	 * @return
	 * @throws Exception
	 */
	public IBOFinAllocRulesValue[] queryFinAllocRulesInfo(String chargeId,
			int startNum, int endNum) throws Exception;

	/**
	 * 根据chargeId获取财务分摊规则总记录数
	 * 
	 * @param chargeId
	 *            资费ID
	 * @return
	 * @throws Exception
	 */
	public int countFinAllocRulesInfo(String chargeId) throws Exception;

	/**
	 * 保存财务分摊规则信息（单个finAllocRulesValue对象）
	 * 
	 * @param finAllocRulesValue
	 * @return
	 * @throws Exception
	 */
	public String saveFinAllocRulesInfo(IBOFinAllocRulesValue finAllocRulesValue)
			throws Exception;

	/**
	 * 保存财务分摊规则信息（多个finAllocRulesValue对象）
	 * 
	 * @param finAllocRulesValues
	 * @throws Exception
	 */
	public void saveFinAllocRulesInfo(
			IBOFinAllocRulesValue[] finAllocRulesValues) throws Exception;
}
