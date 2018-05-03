package com.ai.bce.configtool.service.impl;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import com.ai.bce.bo.BceRuleEngine;
import com.ai.bce.bo.QBOBceRuleRulesetEngine;
import com.ai.bce.bo.QBceRulesetRuleEngine;
import com.ai.bce.configtool.dao.interfaces.IConfRuleDAO;
import com.ai.bce.configtool.service.interfaces.IConfRuleSV;
import com.ai.bce.ivalues.IBceRuleValue;
import com.ai.bce.ivalues.IQBOBceRuleRulesetValue;
import com.ai.bce.ivalues.IQBceRulesetRuleValue;
import com.ai.bce.util.BServiceFactory;
/**
 * 
 * Copyright: Copyright (c) 2010 Asiainfo-Linkage
 * 
 * @ClassName: ConfRuleSVImpl.java
 * @Description: 规则服务实现类
 *
 * @version: v1.0.0
 * @author: ZhangWenqi
 * @date: Dec 10, 2010 3:05:15 PM 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * Dec 10, 2010     ZhangWenqi           v1.0.0               修改原因
 */
public class ConfRuleSVImpl implements IConfRuleSV {

	/**
	 * 根据条件获取规则信息
	 */
	public IBceRuleValue[] getBceRuleValues(String cond, int startNum, int endNum) throws Exception,	RemoteException 
	{
		return BceRuleEngine.getBeans(null,cond, null, startNum, endNum, false);
	}
	/**
	 * 根据条件获取规则信息数量
	 */
	public int getBceRuleCount(String cond) throws Exception, RemoteException
	{
		IBceRuleValue[] values = BceRuleEngine.getBeans(cond, null);
		if(values != null && values.length > 0)
		{
			return values.length;
		}
		return 0;
	}
	
	public IQBceRulesetRuleValue[] getRulesetRulesByRulesetId(String rulesetId, int startNum, int endNum) throws Exception, RemoteException{
		IConfRuleDAO ruleDAO = (IConfRuleDAO)BServiceFactory.getService(IConfRuleDAO.class);
		return ruleDAO.getRulesetRulesByRulesetId(rulesetId, startNum, endNum);
	}
	
	public int getRulesetRulesByRulesetIdCount(String rulesetId) throws Exception, RemoteException{
		IConfRuleDAO ruleDAO = (IConfRuleDAO)BServiceFactory.getService(IConfRuleDAO.class);
		return ruleDAO.getRulesetRulesByRulesetIdCount(rulesetId);
	}
	
	public IQBceRulesetRuleValue[] getRulesetRules(String cond, int startNum, int endNum) throws Exception, RemoteException{
		
		return QBceRulesetRuleEngine.getBeans(null, cond, null, startNum, endNum, false);
	}
	
	public int getRulesetRulesCount(String cond) throws Exception, RemoteException{
		return QBceRulesetRuleEngine.getBeansCount(cond, null);
	}
	
	/**
	 * 根据规则编号获取关联的规则集
	 */
	public IQBOBceRuleRulesetValue[] getRelateRulesetsByRuleId(long ruleId, int startNum, int endNum) throws Exception, RemoteException
	{
		Map map = new HashMap();
		map.put("ruleId", new Long(ruleId));
		return QBOBceRuleRulesetEngine.getBeans(null, null, map, startNum, endNum, false);
	}
	/**
	 * 根据规则编号获取关联的规则集数量
	 */
	public int getRelateRulesetCount(long ruleId) throws Exception, RemoteException
	{
		Map map = new HashMap();
		map.put("ruleId", new Long(ruleId));
		IQBOBceRuleRulesetValue[] values = QBOBceRuleRulesetEngine.getBeans(null, map);
		if(values != null && values.length > 0)
		{
			return values.length;
		}
		return 0;
	}

	public IBceRuleValue[] getBceRuleValues(String cond) throws Exception,
			RemoteException { 
		return getBceRuleValues(cond ,-1 ,-1);
	}

	public IQBOBceRuleRulesetValue[] getRelateRulesetsByRuleId(long ruleId)
			throws Exception, RemoteException { 
		return getRelateRulesetsByRuleId(ruleId ,-1 ,-1);
	}
	
	
}
