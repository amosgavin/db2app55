package com.asiainfo.charge.service.interfaces;

import com.asiainfo.charge.ivalues.IBOFinAllocRulesValue;

public interface IFinAllocRulesSV {

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
			int startNum, int endNum) throws Exception;

	/**
	 * ����chargeId��ȡ�����̯�����ܼ�¼��
	 * 
	 * @param chargeId
	 *            �ʷ�ID
	 * @return
	 * @throws Exception
	 */
	public int countFinAllocRulesInfo(String chargeId) throws Exception;

	/**
	 * ��������̯������Ϣ������finAllocRulesValue����
	 * 
	 * @param finAllocRulesValue
	 * @return
	 * @throws Exception
	 */
	public String saveFinAllocRulesInfo(IBOFinAllocRulesValue finAllocRulesValue)
			throws Exception;

	/**
	 * ��������̯������Ϣ�����finAllocRulesValue����
	 * 
	 * @param finAllocRulesValues
	 * @throws Exception
	 */
	public void saveFinAllocRulesInfo(
			IBOFinAllocRulesValue[] finAllocRulesValues) throws Exception;
}
