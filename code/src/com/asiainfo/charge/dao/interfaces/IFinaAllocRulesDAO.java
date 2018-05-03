package com.asiainfo.charge.dao.interfaces;

import com.asiainfo.charge.ivalues.IBOFinaAllocRulesValue;

public interface IFinaAllocRulesDAO {

	/**
	 * 保存财务分摊规则信息
	 * 
	 * @param finaAllocRulesValue
	 * @return
	 * @throws Exception
	 */
	public String saveFinaAllocRulesInfo(
			IBOFinaAllocRulesValue finaAllocRulesValue) throws Exception;

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
