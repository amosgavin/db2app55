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
	 * 根据受理框架编号、页面编号,获取受理框架页面包含的角色配置
	 * 
	 * @param pBceFrameId
	 * @param pPageId
	 * @return
	 * @throws Exception
	 */
	public IBceFramePageRoleValue[] getBceFramePageRoles(long pBceFrameId,
			long pPageId) throws Exception;

	/**
	 * 根据受理框架编号获取受理框架包含的所有的角色
	 * 
	 * @param pBceFrameId
	 * @param pPageId
	 * @return
	 * @throws Exception
	 */
	public IBceFramePageRoleValue[] getBceFramePageRolesByBceFrameId(
			long BceFrameId) throws Exception;

	/**
	 * 根据条件查询受理框架
	 */
	public IBceFrameValue getBceFrameValue(long businessId, Map paramMap)
			throws Exception;
	
	/**
	 * 根据条件查询受理框架
	 */
	public IBceFrameValue[] getBceFrameValueByBusinessId(String businessId)
			throws Exception;

	/**
	 * 根据受理框架编号获取受理框架数据
	 * 
	 * @param pPageFrameId
	 * @return
	 * @throws Exception
	 */
	public IBceFrameValue getBceFrameValue(long pFrameId) throws Exception;

	/**
	 * 根据规则集编号查询该规则集包含的所有规则
	 * 
	 * @param pPageRulesetId
	 * @return
	 * @throws Exception
	 */
	public IQBceRulesetRuleValue[] getRulesByRulesetId(long pPageRulesetId)
			throws Exception;

	/**
	 * 根据页面框架编号获取页面框架数据
	 * 
	 * @param pPageFrameId
	 * @return
	 * @throws Exception
	 */
	public IBcePageFrameValue getBePageFrameValue(long pPageFrameId)
			throws Exception;

	/**
	 * 根据受理框架编号、页面框架编号查询页面框架包含的页面
	 * 
	 * @param pBceFrameId
	 * @param pPageFrameId
	 * @return
	 * @throws Exception
	 */
	public IQPageFramePageValue[] getPageFramePages(long pBceFrameId,
			long pPageFrameId) throws Exception;

	/**
	 * 根据页面编号获取页面关联的数据集
	 * 
	 * @param pPageFramePageId
	 * @return
	 * @throws Exception
	 */
	public IBceRowsetValue[] getPageRowsets(long pPageFramePageId)
			throws Exception;

	/**
	 * 查询该受理框架注册的该类规则集
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
	 * 提供给Cm的查询信息
	 * 
	 * @Title:
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param businessId
	 *            操作ID
	 * @param paramMap
	 *            参数
	 * @param formId
	 *            formId(不传，写""或null)
	 * @throws Exception
	 *             ,RemoteException 设定文件
	 * @return IQBceBusinessAttrValue的数组
	 * @throws
	 */
	public IQBceBusinessAttrValue[] getQBceBusinessAttrsByBusinessId(
			long businessId, Map paramMap, String formId) throws Exception,
			RemoteException;

	public IQBceBusinessAttrValue getQBceBusinessAttr(long attrId,
			long bceframeId) throws Exception;

	/**
	 * 获取属性表中数据
	 * 
	 * @Title:
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param
	 * @param attrId
	 * @param
	 * @return
	 * @param
	 * @throws Exception
	 *             设定文件
	 * @return 返回类型
	 * @throws
	 */
	public IQBceBusinessAttrValue getQBceBusinessAttr(long attrId)
			throws Exception;

	public BceTabBean getQBusiTabArea(long bceFrameId, String formId)
			throws Exception;
	/**
	 * 通过BceFrameId 获取打印模板
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
	 * 根据相关信息获取提醒信息
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
	 * 根据BusinessId 获取ObjectType
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
	 * 根据受理框架编号、页面编号查询页面框架指定的弹出的页面
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
	 * 通过模板ID 获取打印模板信息
	 * @param templateId
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public IBceQrTemplateValue getTemplateValueByTmmplateId(long templateId) throws Exception,RemoteException;
}
