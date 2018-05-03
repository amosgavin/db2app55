package com.asiainfo.sale.activity.service.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOChannelRuleValue;

public interface IChannelRuleSV {

	/**
	 * �����Ʒ������������
	 * 
	 * @param rule
	 * @return
	 * @throws Exception
	 */
	public String saveChannelRule(IBOChannelRuleValue rule) throws Exception;

	/**
	 * �������Ʒ������������
	 * 
	 * @param rules
	 * @throws Exception
	 */
	public void saveChannelRules(IBOChannelRuleValue[] rules) throws Exception;

	/**
	 * ����Ӫ��������id��ѯ��Ʒ������������
	 * 
	 * @param saleDetailId
	 * @return
	 * @throws Exception
	 */
	public IBOChannelRuleValue[] getRuleBySaleDetailId(String saleDetailId,
			String channelRulesIds) throws Exception;

	public int getRuleCountBySaleDetailId(String saleDetailId,
			String channelRulesIds) throws Exception;

	/**
	 * �����ʷѵ���id��ѯ��Ʒ������������
	 * 
	 * @param saleDetailId
	 * @param channelRulesIds
	 * @return
	 * @throws Exception
	 */
	public IBOChannelRuleValue[] getRuleByChargeDetailId(String chargeDetailId,
			String channelRulesIds) throws Exception;

	public int getRuleCountByChargeDetailId(String chargeDetailId,
			String channelRulesIds) throws Exception;

	/**
	 * ����ruleId��ѯ��������
	 * 
	 * @param ruleId
	 * @return
	 * @throws Exception
	 */
	public IBOChannelRuleValue getRuleByRuleId(String ruleId) throws Exception;

	/**
	 * ������������Ӫ��������
	 * 
	 * @param saleDetailId
	 * @param channelRulesIds
	 * @throws Exception
	 */
	public void bindChannelRule2SaleDetailId(String saleDetailId,
			String channelRulesIds) throws Exception;
}
