package com.asiainfo.charge.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.charge.dao.interfaces.IFinAllocRulesDAO;
import com.asiainfo.charge.ivalues.IBOFinAllocRulesValue;
import com.asiainfo.charge.service.interfaces.IFinAllocRulesSV;

public class FinAllocRulesSVImpl implements IFinAllocRulesSV {

	/**
	 * �����ʷ�ID��ѯ�����̯������Ϣ
	 * 
	 * @param chargeId
	 *            �ʷ�ID
	 * @param startNum
	 *            ��ҳ��¼��ʼ����
	 * @param endNum
	 *            ��ҳ��¼��������
	 * @return
	 * @throws Exception
	 */
	public IBOFinAllocRulesValue[] queryFinAllocRulesInfo(String chargeId,
			int startNum, int endNum) throws Exception {
		IBOFinAllocRulesValue[] finAllocRules = null;

		finAllocRules = ((IFinAllocRulesDAO) ServiceFactory
				.getService(IFinAllocRulesDAO.class)).queryFinAllocRulesInfo(
				chargeId, startNum, endNum);

		return finAllocRules;
	}

	/**
	 * ����chargeId��ȡ�����̯�����ܼ�¼��
	 * 
	 * @param chargeId
	 *            �ʷ�ID
	 * @return
	 * @throws Exception
	 */
	public int countFinAllocRulesInfo(String chargeId) throws Exception {
		int cnt = ((IFinAllocRulesDAO) ServiceFactory
				.getService(IFinAllocRulesDAO.class))
				.countFinAllocRulesInfo(chargeId);

		return cnt;
	}

	/**
	 * ��������̯������Ϣ������finAllocRulesValue����
	 * 
	 * @param finAllocRulesValue
	 * @return
	 * @throws Exception
	 */
	public String saveFinAllocRulesInfo(IBOFinAllocRulesValue finAllocRulesValue)
			throws Exception {
		IFinAllocRulesDAO finAllocRulesDAO = (IFinAllocRulesDAO) ServiceFactory
				.getService(IFinAllocRulesDAO.class);
		return finAllocRulesDAO.saveFinAllocRulesInfo(finAllocRulesValue);
	}

	/**
	 * ��������̯������Ϣ�����finAllocRulesValue����
	 * 
	 * @param finAllocRulesValues
	 * @throws Exception
	 */
	public void saveFinAllocRulesInfo(
			IBOFinAllocRulesValue[] finAllocRulesValues) throws Exception {
		IFinAllocRulesDAO finAllocRulesDAO = (IFinAllocRulesDAO) ServiceFactory
				.getService(IFinAllocRulesDAO.class);
		finAllocRulesDAO.saveFinAllocRulesInfo(finAllocRulesValues);
	}

}
