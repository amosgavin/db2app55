package com.ai.bce.service.interfaces;

import java.rmi.RemoteException;
import java.util.Map;

import com.ai.bce.ivalues.IBceAttrFieldMapValue;
import com.ai.bce.ivalues.IBceAttrValue;
import com.ai.bce.ivalues.IBceBatInputFieldFormatValue;
import com.ai.bce.ivalues.IBceBatInputFormatValue;
import com.ai.bce.ivalues.IBceData;
import com.ai.bce.ivalues.IBceDealReturnData;
import com.ai.bce.ivalues.IBceExtTableConfigValue;
import com.ai.bce.ivalues.IBceFormGroupValue;
import com.ai.bce.ivalues.IBceFrameAreaFormValue;
import com.ai.bce.ivalues.IBceFrameJavaRulesetRelValue;
import com.ai.bce.ivalues.IBceFramePageRoleValue;
import com.ai.bce.ivalues.IBceFrameValue;
import com.ai.bce.ivalues.IBceModuleValue;
import com.ai.bce.ivalues.IBcePageFrameValue;
import com.ai.bce.ivalues.IBcePageValue;
import com.ai.bce.ivalues.IBceQrAttrValue;
import com.ai.bce.ivalues.IBceQrTemplateValue;
import com.ai.bce.ivalues.IBceRowsetValue;
import com.ai.bce.ivalues.IBceRuleValue;
import com.ai.bce.ivalues.IBceSimpleFuncFieldMappingValue;
import com.ai.bce.ivalues.IBceSimpleFuncValue;
import com.ai.bce.ivalues.IBceWarnValue;
import com.ai.bce.ivalues.IBceWorkflowValue;
import com.ai.bce.ivalues.IQBceBusinessAttrValue;
import com.ai.bce.ivalues.IQBceBusinessButtonValue;
import com.ai.bce.ivalues.IQBceRulesetRuleValue;
import com.ai.bce.ivalues.IQPageFramePageValue;
import com.ai.bce.valuebean.BceTabBean;

public interface IBceFrameSV {

	public IBcePageValue getBcePage(long pageId) throws Exception;

	public IBceRuleValue getBceRule(long ruleId) throws Exception;

	/**
	 * ���������ܱ�š�ҳ����,��ȡ������ҳ������Ľ�ɫ����
	 * 
	 * @param pBceFrameId
	 * @param pPageId
	 * @return
	 * @throws Exception
	 */
	public IBceFramePageRoleValue[] getBceFramePageRoles(long pBceFrameId,
			long pPageId) throws Exception;

	/**
	 * ���������ܱ�Ż�ȡ�����ܰ��������еĽ�ɫ
	 * 
	 * @param pBceFrameId
	 * @param pPageId
	 * @return
	 * @throws Exception
	 */
	public IBceFramePageRoleValue[] getBceFramePageRolesByBceFrameId(
			long BceFrameId) throws Exception;

	/**
	 * ����������ѯ������
	 */
	public IBceFrameValue getBceFrameValue(long businessId, Map paramMap)
			throws Exception;
	
	/**
	 * ����������ѯ������
	 */
	public IBceFrameValue[] getBceFrameValueByBusinessId(String businessId)
			throws Exception;

	/**
	 * ���������ܱ�Ż�ȡ����������
	 * 
	 * @param pPageFrameId
	 * @return
	 * @throws Exception
	 */
	public IBceFrameValue getBceFrameValue(long pFrameId) throws Exception;

	/**
	 * ���ݹ��򼯱�Ų�ѯ�ù��򼯰��������й���
	 * 
	 * @param pPageRulesetId
	 * @return
	 * @throws Exception
	 */
	public IQBceRulesetRuleValue[] getRulesByRulesetId(long pPageRulesetId)
			throws Exception;

	/**
	 * ����ҳ���ܱ�Ż�ȡҳ��������
	 * 
	 * @param pPageFrameId
	 * @return
	 * @throws Exception
	 */
	public IBcePageFrameValue getBePageFrameValue(long pPageFrameId)
			throws Exception;

	/**
	 * ���������ܱ�š�ҳ���ܱ�Ų�ѯҳ���ܰ�����ҳ��
	 * 
	 * @param pBceFrameId
	 * @param pPageFrameId
	 * @return
	 * @throws Exception
	 */
	public IQPageFramePageValue[] getPageFramePages(long pBceFrameId,
			long pPageFrameId) throws Exception;

	/**
	 * ����ҳ���Ż�ȡҳ����������ݼ�
	 * 
	 * @param pPageFramePageId
	 * @return
	 * @throws Exception
	 */
	public IBceRowsetValue[] getPageRowsets(long pPageFramePageId)
			throws Exception;

	/**
	 * ��ѯ��������ע��ĸ������
	 */
	public IBceFrameJavaRulesetRelValue[] getRegistedRuleSet(long aBceFrameId,
			long ruleType, Map paramMap) throws Exception;

	public IBceSimpleFuncValue[] getSFunc(long beFrameId) throws Exception;

	public IBceSimpleFuncFieldMappingValue[] getSFuncFieldMapping(long funcId)
			throws Exception;

	public IBceDealReturnData dealService(long beFrameId, IBceData bceData,
			boolean is_CONFIRM, long orderId) throws Exception;

	public IBceDealReturnData dealService(long beFrameId, IBceData bceData,
			boolean is_CONFIRM, String orderCode) throws Exception,
			RemoteException;

	public IQBceBusinessAttrValue[] getQBceBusinessAttrs(long bceFrameId,
			String formId) throws Exception;

	public IBceFrameAreaFormValue[] getBceFrameAreas(long bceFrameId,
			String formId) throws Exception;

	public IQBceBusinessButtonValue[] getQBceBusinessButton(long bceFrameId,
			String areaId) throws Exception;

	public IBceFormGroupValue[] getBceFormGroup(long bceFrameId, String formId)
			throws Exception;

	public IBceModuleValue[] getBceModule() throws Exception;

	public IBceWorkflowValue[] getBceWorkflow(long busiOperId, long prodSpecId,
			long offerId) throws Exception;

	public IBceBatInputFormatValue getImportFileConfig(long aProductSpecId,
			long aProductRoleId, long aBusinessId) throws Exception;

	public IBceBatInputFieldFormatValue[] getImportFieldValues(long aConfigId)
			throws Exception;

	public IBceAttrFieldMapValue[] getBceAttrFieldMaps(long aBusinessId)
			throws Exception;

	public IBceExtTableConfigValue[] getBceExtTableConfigs(String relType)
			throws Exception;

	/**
	 * �ṩ��Cm�Ĳ�ѯ��Ϣ
	 * 
	 * @Title:
	 * @Description: TODO(������һ�仰�����������������)
	 * @param businessId
	 *            ����ID
	 * @param paramMap
	 *            ����
	 * @param formId
	 *            formId(������д""��null)
	 * @throws Exception
	 *             ,RemoteException �趨�ļ�
	 * @return IQBceBusinessAttrValue������
	 * @throws
	 */
	public IQBceBusinessAttrValue[] getQBceBusinessAttrsByBusinessId(
			long businessId, Map paramMap, String formId) throws Exception,
			RemoteException;

	public IQBceBusinessAttrValue getQBceBusinessAttr(long attrId,
			long bceframeId) throws Exception;

	/**
	 * ��ȡ���Ա�������
	 * 
	 * @Title:
	 * @Description: TODO(������һ�仰�����������������)
	 * @param
	 * @param attrId
	 * @param
	 * @return
	 * @param
	 * @throws Exception
	 *             �趨�ļ�
	 * @return ��������
	 * @throws
	 */
	public IQBceBusinessAttrValue getQBceBusinessAttr(long attrId)
			throws Exception;

	public BceTabBean getQBusiTabArea(long bceFrameId, String formId)
			throws Exception;
	/**
	 * ͨ��BceFrameId ��ȡ��ӡģ��
	 * @param bceframeId
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public IBceQrTemplateValue getTemplateValueByframeId(long bceframeId)
			throws Exception, RemoteException;

	/**
	 * @throws RemoteException
	 * @throws Exception
	 * @Title: getQrTempAttrs
	 * @Description: TODO
	 * @param @param key
	 * @param @param templateId
	 * @param @param b
	 * @param @return
	 * @return Map
	 * @throws
	 */
	public IBceQrAttrValue[] getQrTempAttrs(long attrId, String key,
			long templateId, boolean b) throws Exception, RemoteException;

	/**
	 * ���������Ϣ��ȡ������Ϣ
	 * 
	 * @Title: getWarnContent
	 * @Description: TODO
	 * @param @param bceFrameId
	 * @param @param businessId
	 * @param @param changeName
	 * @param @param changeValue
	 * @param @return
	 * @return IBceWarnValue
	 * @throws
	 */
	public IBceWarnValue getWarnContent(long bceFrameId, String businessId,
			String changeName, String changeValue,int warnType) throws Exception,
			RemoteException;

	/**
	 * ����BusinessId ��ȡObjectType
	 * 
	 * @Title: getOrderObjectType
	 * @Description: TODO
	 * @param @param businessId
	 * @param @param bceFrameId
	 * @param @return
	 * @param @throws Exception
	 * @param @throws RemoteException
	 * @return String
	 * @throws
	 */
	public String getOrderObjectType(long businessId, long bceFrameId)
			throws Exception, RemoteException;

	/**
	 * ���������ܱ�š�ҳ���Ų�ѯҳ����ָ���ĵ�����ҳ��
	 * 
	 * @param pBceFrameId
	 * @param pPageFrameId
	 * @return
	 * @throws Exception
	 */
	public IQPageFramePageValue getPageFramePagesTop(long pBceFrameId,
			long pPageId) throws Exception, RemoteException;

	public long getCoustomOrderId(String dealService) throws Exception,
			RemoteException;
	public String getCoustomOrderCode(String dealService) throws Exception,
	RemoteException ;
	/**
	 * ͨ��ģ��ID ��ȡ��ӡģ����Ϣ
	 * @param templateId
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public IBceQrTemplateValue getTemplateValueByTmmplateId(long templateId) throws Exception,RemoteException;
}
