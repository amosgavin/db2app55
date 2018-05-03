package com.ai.bce.configtool.service.interfaces;

import java.rmi.RemoteException;

import com.ai.bce.bo.BceFrameJavaRulesetRelBean;

/**
 * Java规则相关处理逻辑服务接口
 * @author linzhaoming
 *
 */
public interface IConfJavaRuleSV {
	
	/**
	 * 通过条件获取受理框架关联的java规则集
	 * @param rulesetId
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public BceFrameJavaRulesetRelBean[] getJavaRulesetByCond(
			String cond,int startIndex,int endIndex) throws RemoteException, Exception;
	
	/**
	 * 通过条件获取受理框架关联的java规则集(分页数量)
	 * @param cond
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public int getJavaRulesetByCondCount(String cond) throws RemoteException, Exception;
}
