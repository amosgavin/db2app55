package com.asiainfo.sale.activity.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.activity.dao.interfaces.IChannelRuleDAO;
import com.asiainfo.sale.activity.ivalues.IBOChannelRuleValue;
import com.asiainfo.sale.activity.service.interfaces.IChannelRuleSV;

public class ChannelRuleSVImpl implements IChannelRuleSV {

	@Override
	public IBOChannelRuleValue[] getRuleBySaleDetailId(String saleDetailId,
			String channelRulesIds) throws Exception {

		return ((IChannelRuleDAO) ServiceFactory
				.getService(IChannelRuleDAO.class)).getRuleBySaleDetailId(
				saleDetailId, channelRulesIds);
	}

	@Override
	public int getRuleCountBySaleDetailId(String saleDetailId,
			String channelRulesIds) throws Exception {

		return ((IChannelRuleDAO) ServiceFactory
				.getService(IChannelRuleDAO.class)).getRuleCountBySaleDetailId(
				saleDetailId, channelRulesIds);
	}

	@Override
	public void saveChannelRules(IBOChannelRuleValue[] rules) throws Exception {

		((IChannelRuleDAO) ServiceFactory.getService(IChannelRuleDAO.class))
				.saveChannelRules(rules);
	}

	@Override
	public IBOChannelRuleValue getRuleByRuleId(String ruleId) throws Exception {

		return ((IChannelRuleDAO) ServiceFactory
				.getService(IChannelRuleDAO.class)).getRuleByRuleId(ruleId);
	}

	@Override
	public String saveChannelRule(IBOChannelRuleValue rule) throws Exception {

		return ((IChannelRuleDAO) ServiceFactory
				.getService(IChannelRuleDAO.class)).saveChannelRule(rule);
	}

	@Override
	public void bindChannelRule2SaleDetailId(String saleDetailId,
			String channelRulesIds) throws Exception {

		((IChannelRuleDAO) ServiceFactory.getService(IChannelRuleDAO.class))
				.bindChannelRule2SaleDetailId(saleDetailId, channelRulesIds);
	}

	@Override
	public IBOChannelRuleValue[] getRuleByChargeDetailId(String chargeDetailId,
			String channelRulesIds) throws Exception {

		return ((IChannelRuleDAO) ServiceFactory
				.getService(IChannelRuleDAO.class)).getRuleByChargeDetailId(
				chargeDetailId, channelRulesIds);
	}

	@Override
	public int getRuleCountByChargeDetailId(String chargeDetailId,
			String channelRulesIds) throws Exception {

		return ((IChannelRuleDAO) ServiceFactory
				.getService(IChannelRuleDAO.class))
				.getRuleCountByChargeDetailId(chargeDetailId, channelRulesIds);
	}

}
