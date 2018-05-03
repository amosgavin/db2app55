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
 * @Description: �������ӿ�
 *
 * @version: v1.0.0
 * @author: ZhangWenqi
 * @date: Dec 10, 2010 2:57:46 PM 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * Dec 10, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
 */
public interface IConfRuleSV {

	/**
	 * 
	 * @Function: getRuleValues
	 * @Description: ����������ȡ������Ϣ
	 *
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 10, 2010 3:04:22 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 10, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
	 */
	public IBceRuleValue[] getBceRuleValues(String cond, int startNum, int endNum) throws Exception, RemoteException;
	public IBceRuleValue[] getBceRuleValues(String cond) throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getBceRuleCount
	 * @Description: ����������ȡ������Ϣ����
	 *
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 16, 2010 2:46:36 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 16, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
	 */
	public int getBceRuleCount(String cond) throws Exception, RemoteException;
	
	/**
	 * 
	 * @Function: getRulesetRulesRulesetId
	 * @Description: �ú����Ĺ�������
	 *
	 * @param:	���ݹ��򼯱�ŷ��ض�Ӧ�Ĺ��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 *
	 * @version: v1.0.0
	 * @author: Linzhaoming
	 * @date: Dec 14, 2010 2:30:33 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 14, 2010  Linzhaoming    v1.0.0               �޸�ԭ��
	 */
	public IQBceRulesetRuleValue[] getRulesetRulesByRulesetId(String rulesetId, int startNum, int endNum) throws Exception, RemoteException;
	public int getRulesetRulesByRulesetIdCount(String rulesetId) throws Exception, RemoteException;
	
	/**
	 * 
	 * @Function: getRelateRulesetsByRuleId
	 * @Description: ���ݹ����Ż�ȡ�����Ĺ���
	 *
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 14, 2010 7:43:00 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 14, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
	 */
	public IQBOBceRuleRulesetValue[] getRelateRulesetsByRuleId(long ruleId, int startNum, int endNum) throws Exception, RemoteException;
	public IQBOBceRuleRulesetValue[] getRelateRulesetsByRuleId(long ruleId ) throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getRelateRulesetCount
	 * @Description: ���ݹ����Ż�ȡ�����Ĺ�������
	 *
	 * @param:��������
	 * @return�����ؽ������
	 * @throws���쳣����
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 16, 2010 2:58:03 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 16, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
	 */
	public int getRelateRulesetCount(long ruleId) throws Exception, RemoteException;
	
public IQBceRulesetRuleValue[] getRulesetRules(String cond, int startNum, int endNum) throws Exception, RemoteException;
	
	public int getRulesetRulesCount(String cond) throws Exception, RemoteException;
}
