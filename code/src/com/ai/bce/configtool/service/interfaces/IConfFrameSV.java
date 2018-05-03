package com.ai.bce.configtool.service.interfaces;

import java.rmi.RemoteException;

import com.ai.bce.ivalues.IBceFrameConfigTemplateValue;
import com.ai.bce.ivalues.IBceFrameJavaRulesetRelValue;
import com.ai.bce.ivalues.IBceFrameValue;
import com.ai.bce.ivalues.IBcePageRowsetRelValue;
import com.ai.bce.ivalues.IBceRowsetValue;
import com.ai.bce.ivalues.IBceRuleValue;
import com.ai.bce.ivalues.IBceRulesetRuleValue;
import com.ai.bce.ivalues.IBceRulesetValue;
import com.ai.bce.ivalues.IBceSimpleFuncFieldMappingValue;
import com.ai.bce.ivalues.IBceSimpleFuncValue;

public interface IConfFrameSV {
	
	public IBceFrameValue getBceFrameValueByBceFrameId(String bceFrameId) throws RemoteException, Exception;
	
	public IBceFrameValue[] getBceFrameValues(String cond,int startIndex,int endIndex)throws Exception;
	
	public int getBceFrameValuesCount(String cond) throws Exception;
	
	public IBceFrameConfigTemplateValue[] getBceFrameConfigTemplateValues(String cond,int startIndex,int endIndex)throws Exception;
	
	public int getBceFrameConfigTemplateValuesCount(String cond) throws Exception;
	
	public IBcePageRowsetRelValue[] getPageRowsetRelValues(String cond)throws Exception;
	
	public IBceRowsetValue[] getRowsetValues(String cond)throws Exception;
	
	public IBceRuleValue[] getBceRuleValues(String cond)throws Exception;
	
	public IBceRulesetValue[] getBceRulesetValues(String cond)throws Exception;
	
	public IBceRulesetRuleValue[] getBceRulesetRuleValues(String cond)throws Exception;
	
	public IBceFrameJavaRulesetRelValue[] getFrameJavaRulesetRelValues(String cond)throws Exception;
	
	public IBceSimpleFuncValue[] getSFuncValues(String cond)throws Exception;
	
	public IBceSimpleFuncFieldMappingValue[] getSFuncFMappingValues(String cond)throws Exception;
	
	/**
	 * 
	 * @Function: IConfFrameSV::bceFrameConfigTemplate
	 * @Description: 该函数的功能描述
	 * @param bceFrameId
	 * @param templateId
	 * @return
	 * @version: v1.1.0
	 * @author: Administrator
	 * @date: 2011-5-14 下午03:01:11 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *-------------------------------------------------------------
	 * 2011-5-14     Administrator          v1.1.0               修改原因
	 */
	public boolean bceFrameConfigTemplate(long bceFrameId,long templateId)throws Exception;
}
