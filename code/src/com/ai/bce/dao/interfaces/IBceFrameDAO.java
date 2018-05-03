package com.ai.bce.dao.interfaces;

import java.util.Map;

import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ObjectType;
import com.ai.bce.ivalues.IBceAttrFieldMapValue;
import com.ai.bce.ivalues.IBceAttrValue;
import com.ai.bce.ivalues.IBceBatInputFieldFormatValue;
import com.ai.bce.ivalues.IBceBatInputFormatValue;
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

public interface IBceFrameDAO {

	public IBcePageValue getBcePage(long pageId) throws Exception;

	public IBceRuleValue getBceRule(long ruleId) throws Exception;

	/**
	 * 根据受理框架编号、页面编号,获取受理框架页面包含的角色配置
	 * 
	 * @param pBeFrameId
	 * @param pPageId
	 * @return
	 * @throws Exception
	 */
	public IBceFramePageRoleValue[] getBceFramePageRoles(long pBeFrameId,
			long pPageId) throws Exception;

	/**
	 * 根据受理框架编号获取受理框架包含的所有的角色
	 * 
	 * @param pBeFrameId
	 * @param pPageId
	 * @return
	 * @throws Exception
	 */
	public IBceFramePageRoleValue[] getBceFramePageRolesByBceFrameId(
			long BeFrameId) throws Exception;

	/**
	 * 根据条件查询受理框架
	 */
	public IBceFrameValue getBceFrameValue(long businessId, Map paramMap)
			throws Exception;
	/**
	 * 根据条件查询受理框架
	 */
	public IBceFrameValue[] getBceFrameValue(String businessId)
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
	public IBcePageFrameValue getBcePageFrameValue(long pPageFrameId)
			throws Exception;

	/**
	 * 根据受理框架编号、页面框架编号查询页面框架包含的页面
	 * 
	 * @param pBeFrameId
	 * @param pPageFrameId
	 * @return
	 * @throws Exception
	 */
	public IQPageFramePageValue[] getPageFramePages(long pBeFrameId,
			long pPageFrameId) throws Exception;

	/**
	 * 根据页面编号获取页面关联的数据集
	 * 
	 * @param pPageId
	 * @return
	 * @throws Exception
	 */
	public IBceRowsetValue[] getPageRowsets(long pPageId) throws Exception;

	/**
	 * 查询该受理框架注册的该类规则集
	 */
	public IBceFrameJavaRulesetRelValue[] getRegistedRuleSet(long aBeFrameId,
			long ruleType, Map paramMap) throws Exception;

	public IBceSimpleFuncValue[] qrySFunc(String cond, Map param)
			throws Exception;

	public IBceSimpleFuncFieldMappingValue[] qrySFuncFieldMapping(String cond,
			Map param) throws Exception;

	public DataContainerInterface[] getDatasByBO(String datasourceName,
			String cond, Map param, ObjectType ot) throws Exception;

	//通用数据保存方法
	public void saveDatas(DataContainerInterface[] dcs, String datasourceName)throws Exception;
	
	//bce配置工具通用数据保存方法
	public void saveDatasForConf(DataContainerInterface[] dcs, String datasourceName)throws Exception;

	public IQBceBusinessAttrValue[] getQBceBusinessAttrs(String cond, Map param)
			throws Exception;

	public IBceFrameAreaFormValue[] getBceFrameAreas(String cond, Map param)
			throws Exception;

	public IQBceBusinessButtonValue[] getQBceBusinessButton(String cond,
			Map param) throws Exception;

	public IBceFormGroupValue[] getBceFormGroup(String cond, Map param)
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

	public IQBceBusinessAttrValue[] getBceAttrValues(long attrId, long frameId)
			throws Exception;

	public IBceAttrValue getQBceBusinessAttr(long attrId) throws Exception;
	
	public BceTabBean getQBusiTabArea(long bceFrameId, String formId)throws Exception ;

	

	/**
	 * @throws Exception  
	* @Title: getTemplateValueByframeId 
	* @Description: TODO  
	* @param @param printTemplateId
	* @param @return    
	* @return IBceQrTemplateValue     
	* @throws 
	*/
	public IBceQrTemplateValue getTemplateValueByframeId(long printTemplateId) throws Exception;

	/**
	 * @throws Exception  
	* @Title: getQrTempAttrs 
	* @Description: TODO  
	* @param @param key
	* @param @param templateId
	* @param @param b
	* @param @return    
	* @return IBceQrAttrValue[]     
	* @throws 
	*/
	public IBceQrAttrValue[] getQrTempAttrs(long  attrId,String key, long templateId,
			boolean b) throws Exception;

	/**
	 * @param warnType 
	 * @throws Exception  
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
			String changeName, String changeValue, int warnType) throws Exception;
	
	
	/**
	 * 根据受理框架编号、页面编号查询页面框架指定的弹出的页面
	 * 
	 * @param pBceFrameId
	 * @param pPageFrameId
	 * @return
	 * @throws Exception
	 */
	public IQPageFramePageValue getPageFramePagesTop(long pBceFrameId,
			long pPageId) throws Exception; 
}
