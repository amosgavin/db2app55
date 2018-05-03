package com.ai.bce.service.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.ai.appframe2.common.DataContainerInterface;
import com.ai.bce.ivalues.IBceRuleData;
import com.ai.bce.ivalues.IBceRuleReturnData;
import com.ai.bce.ivalues.IQBceRulesetRuleValue;
import com.ai.bce.service.interfaces.IBceRuleEngineForQuerySV;
import com.ai.bce.util.BceException;
import com.ai.bce.util.BceSVUtil;
import com.ai.bce.util.BceServiceFactory;
import com.ai.bce.util.BceUtil;
import com.ai.bce.util.LocaleResourceFactory;
import com.ai.bce.valuebean.BceRuleDataBean;

public class BceRuleEngineForQuerySVImpl extends BceRuleEngineSVImpl implements IBceRuleEngineForQuerySV {
	/*
	 * (non-Javadoc)
	 * @see com.ai.bce.service.impl.BceRuleEngineSVImpl#exeRuleByRuleSetId(long, java.util.Map, com.ai.appframe2.common.DataContainerInterface, com.ai.bce.ivalues.IBceRuleReturnData, int, long)
	 */
	@Override
	public void exeRuleByRuleSetId(long ruleSetId, Map paramMap, DataContainerInterface aDc, IBceRuleReturnData ruleReturnData, int resType, long ruleSetType) throws Exception, BceException {
		// 查询规则集关联的规则
		IQBceRulesetRuleValue[] rules = BceServiceFactory.getBceFrameSV().getRulesByRulesetId(ruleSetId);
		if (rules == null || rules.length == 0) {
			if (ruleReturnData.getResultCode() != BceUtil.JAVA_RULE_RETURN_CODE_WARNNING && ruleReturnData.getResultCode() != BceUtil.JAVA_RULE_RETURN_CODE_NO)
				ruleReturnData.setResultCode(BceUtil.JAVA_RULE_RETURN_CODE_YES);
		} else {
			boolean isPassRule = true;
			for (int i = 0; i < rules.length; i++) {
				if (!BceSVUtil.isUseRule(rules[i].getResType(), resType)) {
					continue;
				}
				//规则的反射调用
				String className = rules[i].getFileName();
				String methodName = rules[i].getFuncName();
				String paramList = rules[i].getParamList();
				String paramValueNameList = rules[i].getParamValueList();
				// 1-警告 2-拒绝
				long ruleVerifyType = rules[i].getVerifyType();
				// 反射调用
				IBceRuleReturnData retData = super.exeRule(className, methodName, paramList, paramValueNameList, paramMap);
				if (StringUtils.isNotBlank(retData.getMsg())) {
					if (aDc != null) {
						String dcMsg = aDc.getAsString(BceUtil.RET_DC_MSG_NAME);
						if (dcMsg == null) {
							aDc.set(BceUtil.RET_DC_MSG_NAME, retData.getMsg());
						} else {
							aDc.set(BceUtil.RET_DC_MSG_NAME, dcMsg + " " + retData.getMsg());
						}
					}
				}
				if (retData.getResultCode() == BceUtil.JAVA_RULE_RETURN_CODE_YES) {
					isPassRule = true;
				} else if (retData.getResultCode() == BceUtil.JAVA_RULE_RETURN_CODE_NO) {
					//警告
					isPassRule = false;
					if (ruleVerifyType == BceUtil.RULE_VERIFY_TYPE_WARNING) {
						String msg = "";
						ruleReturnData.setResultCode(BceUtil.JAVA_RULE_RETURN_CODE_WARNNING);
						if (StringUtils.isNotBlank(retData.getMsg())) {
							ruleReturnData.setMsg((ruleReturnData.getMsg() == null ? "" : ruleReturnData.getMsg()) + retData.getMsg() + " ");
							ruleReturnData.setKey(retData.getKey());
							msg = LocaleResourceFactory.getResource(retData.getKey(), retData.getMsgParams());
						}
						if (StringUtils.isNotBlank(retData.getCustomResultCode())) {
							ruleReturnData.setCustomResultCode((ruleReturnData.getCustomResultCode() == null ? "" : ruleReturnData.getCustomResultCode()) + retData.getCustomResultCode() + " ");
						}
						//
						IBceRuleData bceRuleData = new BceRuleDataBean(String.valueOf(rules[i].getRuleId()), BceUtil.RULE_VERIFY_TYPE_WARNING, msg);
						ruleReturnData.setBceRuleData(bceRuleData);
					} else if (ruleVerifyType == BceUtil.RULE_VERIFY_TYPE_REJECT) {
						if (ruleSetType == BceUtil.RULE_CHECK_TYPE_ALL) {
							String msg = "";
							//必须全部通过
							//TODO 这段逻辑需要改造
							ruleReturnData.setResultCode(BceUtil.JAVA_RULE_RETURN_CODE_NO);
							if (StringUtils.isNotBlank(retData.getMsg())) {
								ruleReturnData.setMsg(retData.getMsg());
								if (retData.getKey() != null) {
									ruleReturnData.setMsgByKey(retData.getKey(), retData.getMsgParams());
									msg = LocaleResourceFactory.getResource(retData.getKey(), retData.getMsgParams());
								}
								ruleReturnData.setKey(retData.getKey());
							}
							if (StringUtils.isNotBlank(retData.getCustomResultCode())) {
								ruleReturnData.setCustomResultCode(retData.getCustomResultCode());
							}
							//
							IBceRuleData bceRuleData = new BceRuleDataBean(String.valueOf(rules[i].getRuleId()), BceUtil.JAVA_RULE_RETURN_CODE_NO, msg);
							ruleReturnData.setBceRuleData(bceRuleData);
							//ruleReturnData.setErrMsgs(retData.getKey(), retData.getMsgParams());
							//ruleReturnData.setRuleCode(String.valueOf(rules[i].getRuleId()));
							//ruleReturnData.addFailDc(buildDc(retData.getKey(), retData.getMsgParams(), retData.getMsg(), className, methodName));
						}
					} else {
						isPassRule = false;
						ruleReturnData.setResultCode(BceUtil.JAVA_RULE_RETURN_CODE_NO);
						ruleReturnData.setMsg(LocaleResourceFactory.getResource("BES0000419") + retData.getMsg());
						ruleReturnData.setKey("BES0000419");
						if (StringUtils.isNotBlank(retData.getCustomResultCode())) {
							ruleReturnData.setCustomResultCode(retData.getCustomResultCode());
						}
						//
						IBceRuleData bceRuleData = new BceRuleDataBean(String.valueOf(rules[i].getRuleId()), BceUtil.JAVA_RULE_RETURN_CODE_NO, LocaleResourceFactory.getResource("BES0000419"));
						ruleReturnData.setBceRuleData(bceRuleData);
						//ruleReturnData.addFailDc(buildDc("BES0000419", null, LocaleResourceFactory.getResource("BES0000419") + retData.getMsg(), className, methodName));
						//break;
					}
				}
			}
			if (isPassRule) {
				if (ruleReturnData.getResultCode() != BceUtil.JAVA_RULE_RETURN_CODE_WARNNING && ruleReturnData.getResultCode() != BceUtil.JAVA_RULE_RETURN_CODE_NO) {
					ruleReturnData.setResultCode(BceUtil.JAVA_RULE_RETURN_CODE_YES);
				}
			}
		}
	}

}
