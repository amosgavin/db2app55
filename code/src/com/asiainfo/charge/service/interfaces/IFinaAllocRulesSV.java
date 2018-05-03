package com.asiainfo.charge.service.interfaces;

import com.asiainfo.charge.ivalues.IBOFinaAllocRulesValue;

public interface IFinaAllocRulesSV {

	/**
	 * ��������̯������Ϣ
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
	 * ����chargeId��ѯ�����̯������Ϣ
	 * 
	 * @param chargeId
	 * @return
	 * @throws Exception
	 */
	public IBOFinaAllocRulesValue[] queryFinaAllocRules(String chargeId)
			throws Exception;

}
