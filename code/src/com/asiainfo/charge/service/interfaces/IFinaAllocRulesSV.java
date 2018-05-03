package com.asiainfo.charge.service.interfaces;

import com.asiainfo.charge.ivalues.IBOFinaAllocRulesValue;

public interface IFinaAllocRulesSV {

	/**
	 * 保存财务分摊规则信息
	 * 
	 * @param finaAllocRulesValue
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public String saveFinaAllocRulesInfo(
			IBOFinaAllocRulesValue finaAllocRulesValue) throws Exception,
			RuntimeException;

	/**
	 * 根据chargeId查询财务分摊规则信息
	 * 
	 * @param chargeId
	 * @return
	 * @throws Exception
	 */
	public IBOFinaAllocRulesValue[] queryFinaAllocRules(String chargeId)
			throws Exception;

}
