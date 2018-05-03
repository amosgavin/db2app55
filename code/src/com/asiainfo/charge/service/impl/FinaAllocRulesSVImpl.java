package com.asiainfo.charge.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.charge.dao.interfaces.IFinaAllocRulesDAO;
import com.asiainfo.charge.ivalues.IBOFinaAllocRulesValue;
import com.asiainfo.charge.service.interfaces.IFinaAllocRulesSV;

public class FinaAllocRulesSVImpl implements IFinaAllocRulesSV {

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
			RuntimeException {
		IFinaAllocRulesDAO finaAllocRulesDAO = (IFinaAllocRulesDAO) ServiceFactory
				.getService(IFinaAllocRulesDAO.class);
		return finaAllocRulesDAO.saveFinaAllocRulesInfo(finaAllocRulesValue);
	}

	/**
	 * ����chargeId��ѯ�����̯������Ϣ
	 * 
	 * @param chargeId
	 * @return
	 * @throws Exception
	 */
	public IBOFinaAllocRulesValue[] queryFinaAllocRules(String chargeId)
			throws Exception {
		IFinaAllocRulesDAO finaAllocRulesDAO = (IFinaAllocRulesDAO) ServiceFactory
				.getService(IFinaAllocRulesDAO.class);
		return finaAllocRulesDAO.queryFinaAllocRules(chargeId);
	}

}
