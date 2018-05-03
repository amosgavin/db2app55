package com.ai.bce.configtool.service.interfaces;

import java.rmi.RemoteException;

import com.ai.bce.bo.BceFrameJavaRulesetRelBean;

/**
 * Java������ش����߼�����ӿ�
 * @author linzhaoming
 *
 */
public interface IConfJavaRuleSV {
	
	/**
	 * ͨ��������ȡ�����ܹ�����java����
	 * @param rulesetId
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public BceFrameJavaRulesetRelBean[] getJavaRulesetByCond(
			String cond,int startIndex,int endIndex) throws RemoteException, Exception;
	
	/**
	 * ͨ��������ȡ�����ܹ�����java����(��ҳ����)
	 * @param cond
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public int getJavaRulesetByCondCount(String cond) throws RemoteException, Exception;
}
