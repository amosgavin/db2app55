package com.asiainfo.charge.dao.impl;

import java.util.HashMap;

import com.asiainfo.charge.bo.BOFinAllocRulesEngine;
import com.asiainfo.charge.dao.interfaces.IFinAllocRulesDAO;
import com.asiainfo.charge.ivalues.IBOBillingCheckValue;
import com.asiainfo.charge.ivalues.IBOFinAllocRulesValue;

public class FinAllocRulesDAOImpl implements IFinAllocRulesDAO {

	/**
	 * ����ID��ѯ�����̯������Ϣ
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
		IBOFinAllocRulesValue[] finAllocRulesList;
		HashMap<String, String> parameter = new HashMap<String, String>();

		StringBuffer sqlCondition = new StringBuffer();
		sqlCondition.append("1=1");

		if (!chargeId.equals("")) {
			sqlCondition.append(" and " + IBOFinAllocRulesValue.S_ChargeId
					+ " = :chargeId");
			parameter.put("chargeId", chargeId);
		}

		sqlCondition.append(" order by id");

		finAllocRulesList = BOFinAllocRulesEngine.getBeans(null, sqlCondition
				.toString(), parameter, startNum, endNum, false);
		return finAllocRulesList;
	}

	/**
	 * �����ʷ�ID��ȡ�����̯�����ܼ�¼��
	 * 
	 * @param chargeId
	 *            �ʷ�ID
	 * @return
	 * @throws Exception
	 */
	public int countFinAllocRulesInfo(String chargeId) throws Exception {
		StringBuffer sqlCondition = new StringBuffer("1=1");
		HashMap<String, String> parameter = new HashMap<String, String>();

		if (!chargeId.equals("")) {
			sqlCondition.append(" and " + IBOBillingCheckValue.S_ChargeId
					+ " =:chargeId");
			parameter.put("chargeId", chargeId);
		}

		return BOFinAllocRulesEngine.getBeansCount(sqlCondition.toString(),
				parameter);
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
		if (finAllocRulesValue != null) {
			// ��������ҪȡID
			if (finAllocRulesValue.isNew()) {
				finAllocRulesValue.setId(BOFinAllocRulesEngine.getNewId()
						.toString());
				finAllocRulesValue.setStsToNew();
			}

			BOFinAllocRulesEngine.save(finAllocRulesValue);
			return finAllocRulesValue.getId();
		}
		return null;
	}

	/**
	 * ��������̯������Ϣ�����finAllocRulesValue����
	 * 
	 * @param finAllocRulesValues
	 * @throws Exception
	 */
	public void saveFinAllocRulesInfo(
			IBOFinAllocRulesValue[] finAllocRulesValues) throws Exception {
		for (int i = 0; i < finAllocRulesValues.length; i++) {
			if (finAllocRulesValues[i].isNew()) {
				finAllocRulesValues[i].setId(BOFinAllocRulesEngine.getNewId()
						.toString());
				finAllocRulesValues[i].setStsToNew();
			}

		}
		BOFinAllocRulesEngine.save(finAllocRulesValues);

	}
}
