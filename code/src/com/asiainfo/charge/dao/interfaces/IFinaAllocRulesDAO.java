package com.asiainfo.charge.dao.interfaces;

import com.asiainfo.charge.ivalues.IBOFinaAllocRulesValue;

public interface IFinaAllocRulesDAO {

	/**
	 * ��������̯������Ϣ
	 * 
	 * @param finaAllocRulesValue
	 * @return
	 * @throws Exception
	 */
	public String saveFinaAllocRulesInfo(
			IBOFinaAllocRulesValue finaAllocRulesValue) throws Exception;

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
