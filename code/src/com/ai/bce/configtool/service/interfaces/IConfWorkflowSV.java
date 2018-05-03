package com.ai.bce.configtool.service.interfaces;

import com.ai.bce.ivalues.IBceWorkflowValue;

public interface IConfWorkflowSV {
public IBceWorkflowValue[] getBceWorkflowValues(String cond,int $STARTROWINDEX,int $ENDROWINDEX) throws Exception;
public int getBceWorkflowValuesCount(String cond) throws Exception;
public IBceWorkflowValue getBceWorkflowValue(String workflowId) throws Exception;
}
