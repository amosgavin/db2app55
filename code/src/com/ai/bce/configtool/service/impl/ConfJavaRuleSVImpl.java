package com.ai.bce.configtool.service.impl;

import java.rmi.RemoteException;

import com.ai.bce.bo.BceFrameJavaRulesetRelBean;
import com.ai.bce.configtool.dao.interfaces.IConfJavaRuleDAO;
import com.ai.bce.configtool.service.interfaces.IConfJavaRuleSV;
import com.ai.bce.util.BServiceFactory;

/**
 * 通过条件获取受理框架关联的java规则集
 * 
 * @author linzhaoming
 *
 */
public class ConfJavaRuleSVImpl implements IConfJavaRuleSV{
	
	public BceFrameJavaRulesetRelBean[] getJavaRulesetByCond(
			String cond,int startIndex,int endIndex) throws RemoteException, Exception {
		IConfJavaRuleDAO dao = (IConfJavaRuleDAO) BServiceFactory.getService(IConfJavaRuleDAO.class);
		return dao.getJavaRulesetByCond(cond, startIndex, endIndex);
	}
	
	public int getJavaRulesetByCondCount(String cond) throws RemoteException, Exception{
		IConfJavaRuleDAO dao = (IConfJavaRuleDAO) BServiceFactory.getService(IConfJavaRuleDAO.class);
		return dao.getJavaRulesetByCondCount(cond);
	}
}
