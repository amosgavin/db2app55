package com.asiainfo.sale.activity.service.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOChannelRuleValue;

public interface IChannelRuleSV {

	/**
	 * 保存产品发布渠道规则
	 * 
	 * @param rule
	 * @return
	 * @throws Exception
	 */
	public String saveChannelRule(IBOChannelRuleValue rule) throws Exception;

	/**
	 * 批处理产品发布渠道规则
	 * 
	 * @param rules
	 * @throws Exception
	 */
	public void saveChannelRules(IBOChannelRuleValue[] rules) throws Exception;

	/**
	 * 根据营销案档次id查询产品发布渠道规则
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
	 * 根据资费档次id查询产品发布渠道规则
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
	 * 根据ruleId查询渠道规则
	 * 
	 * @param ruleId
	 * @return
	 * @throws Exception
	 */
	public IBOChannelRuleValue getRuleByRuleId(String ruleId) throws Exception;

	/**
	 * 关联渠道规则到营销案档次
	 * 
	 * @param saleDetailId
	 * @param channelRulesIds
	 * @throws Exception
	 */
	public void bindChannelRule2SaleDetailId(String saleDetailId,
			String channelRulesIds) throws Exception;
}
