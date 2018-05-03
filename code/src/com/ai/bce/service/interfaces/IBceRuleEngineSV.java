package com.ai.bce.service.interfaces;

import java.rmi.RemoteException;
import java.util.Map;

import com.ai.appframe2.common.DataContainerInterface;
import com.ai.bce.ivalues.IBceRuleReturnData;
import com.ai.bce.util.BceException;

public interface IBceRuleEngineSV {

	/**
	 * ҵ������Ƿ���Ա�ִ�� bceFrameId��businessId����ͬʱΪ-1�������޷���ȡ���
	 * 
	 * @param conditionMap
	 *            ���ڲ�ѯ�����ܼ������Ĺ��򼯵�����Map
	 * @param paramMap
	 *            ����ִ�й���Ĳ���Map
	 * @param resType
	 *            ��Դ���ͣ�1����̨;2��ǰ̨��3������
	 * @return
	 * @throws Exception
	 */
	public IBceRuleReturnData isBusiCanDo(long bceFrameId, long businessId,
			Map conditionMap, Map paramMap, int resType) throws Exception,
			RemoteException;

	/**
	 * �����Ƿ���Ա��ύ bceFrameId��businessId����ͬʱΪ-1�������޷���ȡ���
	 * 
	 * @param conditionMap
	 *            ���ڲ�ѯ�����ܼ������Ĺ��򼯵�����Map
	 * @param paramMap
	 *            ����ִ�й���Ĳ���Map
	 * @param resType
	 *            ��Դ���ͣ�1����̨;2��ǰ̨��3������
	 * @return
	 * @throws Exception
	 */
	public IBceRuleReturnData isCanSubmitOrder(long bceFrameId,
			long businessId, Map conditionMap, Map paramMap, int resType)
			throws Exception, RemoteException;

	/**
	 * ҵ������Ƿ����������ִ��
	 * 
	 * @param conditionMap
	 *            ���ڲ�ѯ�����ܼ������Ĺ��򼯵�����Map
	 * @param paramMap
	 *            ����ִ�й���Ĳ���Map
	 * @param resType
	 *            ��Դ���ͣ�1����̨;2��ǰ̨��3������
	 * @return
	 * @throws Exception
	 */
	// public IBceRuleReturnData isBatchBusiCanDo(long bceFrameId,
	// long businessId, Map conditionMap, Map paramMap, int resType)
	// throws Exception, RemoteException;

	/**
	 * ҵ������Ƿ���Ա�ִ�� bceFrameId��businessId����ͬʱΪ-1�������޷���ȡ���
	 * 
	 * @param conditionMap
	 *            ���ڲ�ѯ�����ܼ������Ĺ��򼯵�����Map
	 * @param paramMap
	 *            ����ִ�й���Ĳ���Map
	 * @return
	 * @throws Exception
	 */
	public IBceRuleReturnData isBusiCanDo(long bceFrameId, long businessId,
			Map conditionMap, Map paramMap) throws Exception, RemoteException;

	/**
	 * �����Ƿ���Ա��ύ bceFrameId��businessId����ͬʱΪ-1�������޷���ȡ���
	 * 
	 * @param conditionMap
	 *            ���ڲ�ѯ�����ܼ������Ĺ��򼯵�����Map
	 * @param paramMap
	 *            ����ִ�й���Ĳ���Map
	 * @return
	 * @throws Exception
	 */
	public IBceRuleReturnData isCanSubmitOrder(long bceFrameId,
			long businessId, Map conditionMap, Map paramMap) throws Exception,
			RemoteException;

	/**
	 * ҵ������Ƿ����������ִ��
	 * 
	 * @param conditionMap
	 *            ���ڲ�ѯ�����ܼ������Ĺ��򼯵�����Map
	 * @param paramMap
	 *            ����ִ�й���Ĳ���Map
	 * @return
	 * @throws Exception
	 */
	public IBceRuleReturnData isBatchBusiCanDo(long bceFrameId,
			long businessId, Map conditionMap, Map paramMap) throws Exception,
			RemoteException;

	/**
	 * ��������������ݽ���У�� bceFrameId��businessId����ͬʱΪ-1�������޷���ȡ���
	 * ��ֻ��������У�鲢����������У��Ľ�������ŵ�ʧ���б��ɹ��б������б�
	 * 
	 * @param aSoRuleReturnData
	 * @param paramMap
	 * @param ruleCheckEntryType
	 * @param members
	 * @return
	 * @throws Exception
	 */
	public IBceRuleReturnData batVerifyJavaRule(long bceFrameId,
			long businessId, Map conditionMap, Map paramMap,
			long ruleCheckEntryType, DataContainerInterface[] members,
			IBceRuleReturnData aSoRuleReturnData) throws Exception;

	/**
	 * bceFrameId��businessId����ͬʱΪ-1�������޷���ȡ���
	 * 
	 * @param bceFrameId
	 * @param businessId
	 * @param conditionMap
	 * @param paramMap
	 * @param ruleCheckEntryType
	 * @param ruleReturnData
	 * @return
	 * @throws Exception
	 */
	public IBceRuleReturnData verifyJavaRule(long bceFrameId, long businessId,
			Map conditionMap, Map paramMap, long ruleCheckEntryType,
			IBceRuleReturnData ruleReturnData, int resType) throws Exception;

	public Object exeSingleRule(String className, String methodName,
			String paramList, String paramValueNameList, Map paramValueMap)
			throws Exception;

	/**
	 * ��ǰ��ҳ���Ƿ���Ȩʹ��
	 * 
	 * @param bceFrameId
	 * @param pageFramePageId
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public IBceRuleReturnData isCanUsePage(long bceFrameId,
			long pageFramePageId, Map paramMap) throws Exception;

	/**
	 * �˷���������̨����ʹ��
	 * 
	 * @param ruleSetId
	 * @param paramMap
	 * @param aDc
	 * @param ruleReturnData
	 * @param resType
	 * @param ruleSetType
	 * @throws Exception
	 * @throws BceException
	 */
	public void exeRuleByRuleSetId(long ruleSetId, Map paramMap,
			DataContainerInterface aDc, IBceRuleReturnData ruleReturnData,
			int resType, long ruleSetType) throws Exception, BceException;

}
