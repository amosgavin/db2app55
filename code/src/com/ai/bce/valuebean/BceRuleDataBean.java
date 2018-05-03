package com.ai.bce.valuebean;

import com.ai.bce.ivalues.IBceRuleData;

/**
 * Bce 实现返回值对象描述实现
 * @author pecho
 *
 */
public class BceRuleDataBean implements IBceRuleData {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6705479716538532626L;
	private String msg;
	private String ruleId;
	private int ruleResult;

	public BceRuleDataBean() {

	}

	public BceRuleDataBean(String ruleId, int ruleResult, String msg) {
		this.ruleId = ruleId;
		this.msg = msg;
		this.ruleResult = ruleResult;
	}

	public String getRuleId() {
		return ruleId;
	}

	public String getRuleMsg() {
		return msg;
	}

	public int getRuleResult() {
		return ruleResult;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public void setRuleMsg(String ruleMsg) {
		this.msg = ruleMsg;
	}

	public void setRuleResult(int ruleResult) {
		this.ruleResult = ruleResult;
	}
}
