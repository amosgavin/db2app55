package com.ai.bce.ivalues;

import java.io.Serializable;

public interface IBceRuleData extends Serializable {

	String getRuleId();

	String getRuleMsg();

	int getRuleResult();

	void setRuleId(String ruleId);

	void setRuleMsg(String ruleMsg);

	void setRuleResult(int i);
}
