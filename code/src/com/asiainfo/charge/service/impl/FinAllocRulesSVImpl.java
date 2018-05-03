package com.asiainfo.charge.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.charge.dao.interfaces.IFinAllocRulesDAO;
import com.asiainfo.charge.ivalues.IBOFinAllocRulesValue;
import com.asiainfo.charge.service.interfaces.IFinAllocRulesSV;

public class FinAllocRulesSVImpl implements IFinAllocRulesSV {

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
			int startNum, int endNum) throws Exception {
		IBOFinAllocRulesValue[] finAllocRules = null;

		finAllocRules = ((IFinAllocRulesDAO) ServiceFactory
				.getService(IFinAllocRulesDAO.class)).queryFinAllocRulesInfo(
				chargeId, startNum, endNum);

		return finAllocRules;
	}

	/**
	 * 根据chargeId获取财务分摊规则总记录数
	 * 
	 * @param chargeId
	 *            资费ID
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
	 * 保存财务分摊规则信息（单个finAllocRulesValue对象）
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
	 * 保存财务分摊规则信息（多个finAllocRulesValue对象）
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
