package com.ai.bce.configtool.service.impl;

import com.ai.bce.configtool.service.interfaces.IConfWorkflowSV;
import com.ai.bce.ivalues.IBceWorkflowValue;
import com.ai.bce.bo.BceWorkflowEngine;

public class ConfWorkflowSVImpl implements IConfWorkflowSV {

	public IBceWorkflowValue[] getBceWorkflowValues(String cond,
			int startrowindex, int endrowindex) throws Exception {
		return BceWorkflowEngine.getBeans(null, cond, null, startrowindex, endrowindex, false);
	}

	public int getBceWorkflowValuesCount(String cond) throws Exception {
		return BceWorkflowEngine.getBeansCount(cond, null);
	}

	public IBceWorkflowValue getBceWorkflowValue(String workflowId)
			throws Exception {
		return BceWorkflowEngine.getBean(Long.parseLong(workflowId));
	}

}
