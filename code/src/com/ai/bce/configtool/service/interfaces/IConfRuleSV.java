package com.ai.bce.configtool.service.interfaces;

import java.rmi.RemoteException;

import com.ai.bce.ivalues.IBceRuleValue;
import com.ai.bce.ivalues.IQBOBceRuleRulesetValue;
import com.ai.bce.ivalues.IQBceRulesetRuleValue;

/**
 * 
 * Copyright: Copyright (c) 2010 Asiainfo-Linkage
 * 
 * @ClassName: IConfRuleSV.java
 * @Description: 规则服务接口
 *
 * @version: v1.0.0
 * @author: ZhangWenqi
 * @date: Dec 10, 2010 2:57:46 PM 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * Dec 10, 2010     ZhangWenqi           v1.0.0               修改原因
 */
public interface IConfRuleSV {

	/**
	 * 
	 * @Function: getRuleValues
	 * @Description: 根据条件获取规则信息
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 10, 2010 3:04:22 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 10, 2010     ZhangWenqi           v1.0.0               修改原因
	 */
	public IBceRuleValue[] getBceRuleValues(String cond, int startNum, int endNum) throws Exception, RemoteException;
	public IBceRuleValue[] getBceRuleValues(String cond) throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getBceRuleCount
	 * @Description: 根据条件获取规则信息数量
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 16, 2010 2:46:36 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 16, 2010     ZhangWenqi           v1.0.0               修改原因
	 */
	public int getBceRuleCount(String cond) throws Exception, RemoteException;
	
	/**
	 * 
	 * @Function: getRulesetRulesRulesetId
	 * @Description: 该函数的功能描述
	 *
	 * @param:	根据规则集编号返回对应的规则集与规则
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: Linzhaoming
	 * @date: Dec 14, 2010 2:30:33 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 14, 2010  Linzhaoming    v1.0.0               修改原因
	 */
	public IQBceRulesetRuleValue[] getRulesetRulesByRulesetId(String rulesetId, int startNum, int endNum) throws Exception, RemoteException;
	public int getRulesetRulesByRulesetIdCount(String rulesetId) throws Exception, RemoteException;
	
	/**
	 * 
	 * @Function: getRelateRulesetsByRuleId
	 * @Description: 根据规则编号获取关联的规则集
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 14, 2010 7:43:00 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 14, 2010     ZhangWenqi           v1.0.0               修改原因
	 */
	public IQBOBceRuleRulesetValue[] getRelateRulesetsByRuleId(long ruleId, int startNum, int endNum) throws Exception, RemoteException;
	public IQBOBceRuleRulesetValue[] getRelateRulesetsByRuleId(long ruleId ) throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getRelateRulesetCount
	 * @Description: 根据规则编号获取关联的规则集数量
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 16, 2010 2:58:03 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 16, 2010     ZhangWenqi           v1.0.0               修改原因
	 */
	public int getRelateRulesetCount(long ruleId) throws Exception, RemoteException;
	
public IQBceRulesetRuleValue[] getRulesetRules(String cond, int startNum, int endNum) throws Exception, RemoteException;
	
	public int getRulesetRulesCount(String cond) throws Exception, RemoteException;
}
