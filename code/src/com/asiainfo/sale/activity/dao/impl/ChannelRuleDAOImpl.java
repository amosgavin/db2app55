package com.asiainfo.sale.activity.dao.impl;

import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.StringUtils;
import com.asiainfo.sale.activity.bo.BOChannelRuleEngine;
import com.asiainfo.sale.activity.dao.interfaces.IChannelRuleDAO;
import com.asiainfo.sale.activity.ivalues.IBOChannelRuleValue;

public class ChannelRuleDAOImpl implements IChannelRuleDAO {

	@Override
	public void saveChannelRules(IBOChannelRuleValue[] rules) throws Exception {

		if (rules != null && rules.length > 0) {
			for (int i = 0; i < rules.length; ++i) {
				if (rules[i].isNew()) {
					rules[i].setRuleId(BOChannelRuleEngine.getNewId()
							.intValue());
					rules[i].setStsToNew();
				}
			}
			BOChannelRuleEngine.save(rules);
		}
	}

	@Override
	public IBOChannelRuleValue[] getRuleBySaleDetailId(String saleDetailId,
			String channelRulesIds) throws Exception {

		String condition = " " + IBOChannelRuleValue.S_Remark1 + " = 'sale'";
		if (saleDetailId != null && !saleDetailId.equals("")
				&& !saleDetailId.equals("null")) {
			condition += " and " + IBOChannelRuleValue.S_DetailId + " = "
					+ saleDetailId;
		} else {
			if (channelRulesIds.equals(""))
				channelRulesIds = null;
			condition += " and " + IBOChannelRuleValue.S_RuleId + " in ("
					+ channelRulesIds + ")";
		}
		condition += " order by create_date";
		return BOChannelRuleEngine.getBeans(condition, null);
	}

	@Override
	public int getRuleCountBySaleDetailId(String saleDetailId,
			String channelRulesIds) throws Exception {

		String condition = " " + IBOChannelRuleValue.S_Remark1 + " = 'sale'";
		if (saleDetailId != null && !saleDetailId.equals("")
				&& !saleDetailId.equals("null")) {
			condition += " and " + IBOChannelRuleValue.S_DetailId + " = "
					+ saleDetailId;
		} else {
			if (channelRulesIds.equals(""))
				return 0;
			condition += " and " + IBOChannelRuleValue.S_RuleId + " in ("
					+ channelRulesIds + ")";
		}
		return BOChannelRuleEngine.getBeansCount(condition, null);
	}

	@Override
	public IBOChannelRuleValue getRuleByRuleId(String ruleId) throws Exception {

		return BOChannelRuleEngine.getBean(Integer.parseInt(ruleId));
	}

	@Override
	public String saveChannelRule(IBOChannelRuleValue rule) throws Exception {

		String newId = "";
		if (rule != null) {
			if (rule.isNew()) {
				newId = String.valueOf(BOChannelRuleEngine.getNewId());
				rule.setRuleId(Integer.parseInt(newId));
				rule.setStsToNew();
			}
			BOChannelRuleEngine.save(rule);
		}
		return newId;
	}

	@Override
	public void bindChannelRule2SaleDetailId(String saleDetailId,
			String channelRulesIds) throws Exception {

		if (StringUtils.isNotBlank(saleDetailId)
				&& StringUtils.isNotBlank(channelRulesIds)) {
			IBOChannelRuleValue[] rules = getRuleBySaleDetailId(null,
					channelRulesIds);
			for (int i = 0; i < rules.length; ++i) {
				rules[i].setDetailId(Integer.parseInt(saleDetailId));
			}
			BOChannelRuleEngine.save(rules);
		}
	}

	@Override
	public IBOChannelRuleValue[] getRuleByChargeDetailId(String chargeDetailId,
			String channelRulesIds) throws Exception {

		String condition = " " + IBOChannelRuleValue.S_Remark1 + " = 'charge'";
		if (chargeDetailId != null && !chargeDetailId.equals("")
				&& !chargeDetailId.equals("null")) {
			condition += " and " + IBOChannelRuleValue.S_DetailId + " = "
					+ chargeDetailId;
		}
		condition += " order by create_date";
		return BOChannelRuleEngine.getBeans(condition, null);
	}

	@Override
	public int getRuleCountByChargeDetailId(String chargeDetailId,
			String channelRulesIds) throws Exception {

		String condition = " " + IBOChannelRuleValue.S_Remark1 + " = 'charge'";
		if (chargeDetailId != null && !chargeDetailId.equals("")
				&& !chargeDetailId.equals("null")) {
			condition += " and " + IBOChannelRuleValue.S_DetailId + " = "
					+ chargeDetailId;
		} 
		return BOChannelRuleEngine.getBeansCount(condition, null);
	}
}
