package com.ai.bce.configtool.service.interfaces;

import com.ai.bce.bo.BceOperatorBean;

public interface IConfBusinessSV {
public BceOperatorBean[] getOperatorBeans(String cond,int startIndex,int endIndex) throws Exception;
public int getOperatorBeansCount(String cond) throws Exception;
}
