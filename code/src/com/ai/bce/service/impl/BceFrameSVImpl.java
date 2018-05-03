package com.ai.bce.service.impl;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.AIThreadLocal;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.bce.auto.plugin.qr.PrintUtil;
import com.ai.bce.bo.QBceBusinessAttrBean;
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
import com.ai.bce.service.interfaces.IBceDealService;
import com.ai.bce.service.interfaces.IBceFrameSV;
import com.ai.bce.util.BceCommonStore;
import com.ai.bce.util.BceException;
import com.ai.bce.util.BceDefaultFactory;
import com.ai.bce.util.BceSVUtil;
import com.ai.bce.util.BceServiceFactory;
import com.ai.bce.util.LocaleResourceFactory;
import com.ai.bce.valuebean.BceDealReturnDataBean;
import com.ai.bce.valuebean.BceTabBean;
import com.asiainfo.crm.common.ivalues.IBOBsParaDetailValue;

public class BceFrameSVImpl implements IBceFrameSV {
	public static transient final Log log = LogFactory
			.getLog(BceFrameSVImpl.class);

	public IBcePageValue getBcePage(long pageId) throws Exception {
		return BceServiceFactory.getBceFrameDAO().getBcePage(pageId);
	}

	public IBceRuleValue getBceRule(long ruleId) throws Exception {
		return BceServiceFactory.getBceFrameDAO().getBceRule(ruleId);
	}

	/**
	 * 根据受理框架编号、页面编号,获取受理框架页面包含的角色配置
	 * 
	 * @param pBceFrameId
	 * @param pageFramePageId
	 * @return
	 * @throws Exception
	 */
	public IBceFramePageRoleValue[] getBceFramePageRoles(long beFrameId,
			long pageFramePageId) throws Exception {
		return BceServiceFactory.getBceFrameDAO().getBceFramePageRoles(
				beFrameId, pageFramePageId);
	}

	/**
	 * 根据受理框架编号获取受理框架包含的所有的角色
	 * 
	 * @param pBceFrameId
	 * @param pPageId
	 * @return
	 * @throws Exception
	 */
	public IBceFramePageRoleValue[] getBceFramePageRolesByBceFrameId(
			long beFrameId) throws Exception {

		return BceServiceFactory.getBceFrameDAO()
				.getBceFramePageRolesByBceFrameId(beFrameId);
	}

	/**
	 * 根据操作id查询受理框架信息
	 */
	public IBceFrameValue getBceFrameValue(long pBusiOperId, Map paramMap)
			throws Exception {
		return BceServiceFactory.getBceFrameDAO().getBceFrameValue(pBusiOperId,
				paramMap);
	}

	/**
	 * 根据受理框架编号获取受理框架数据
	 * 
	 * @param pPageFrameId
	 * @return
	 * @throws Exception
	 */
	public IBceFrameValue getBceFrameValue(long pFrameId) throws Exception {
		return BceServiceFactory.getBceFrameDAO().getBceFrameValue(pFrameId);
	}

	/**
	 * 根据规则集编号查询该规则集包含的所有规则
	 * 
	 * @param pPageRulesetId
	 * @return
	 * @throws Exception
	 */
	public IQBceRulesetRuleValue[] getRulesByRulesetId(long pPageRulesetId)
			throws Exception {
		return BceServiceFactory.getBceFrameDAO().getRulesByRulesetId(
				pPageRulesetId);
	}

	/**
	 * 根据页面框架编号获取页面框架数据
	 * 
	 * @param pPageFrameId
	 * @return
	 * @throws Exception
	 */
	public IBcePageFrameValue getBePageFrameValue(long pPageFrameId)
			throws Exception {
		return BceServiceFactory.getBceFrameDAO().getBcePageFrameValue(
				pPageFrameId);
	}

	/**
	 * 根据受理框架编号、页面框架编号查询页面框架包含的页面
	 * 
	 * @param pBceFrameId
	 * @param pPageFrameId
	 * @return
	 * @throws Exception
	 */
	public IQPageFramePageValue[] getPageFramePages(long pBceFrameId,
			long pPageFrameId) throws Exception {
		return BceServiceFactory.getBceFrameDAO().getPageFramePages(
				pBceFrameId, pPageFrameId);
	}

	/**
	 * 根据页面编号获取页面关联的数据集
	 * 
	 * @param pPageFramePageId
	 * @return
	 * @throws Exception
	 */
	public IBceRowsetValue[] getPageRowsets(long pPageFramePageId)
			throws Exception {
		return BceServiceFactory.getBceFrameDAO().getPageRowsets(
				pPageFramePageId);
	}

	/**
	 * 查询该受理框架注册的该类规则集
	 * 
	 * @param aBceFrameId
	 * @param aBusinessId
	 * @param aOfferId
	 * @param aRoleId
	 * @param regionId
	 * @param aChannelId
	 * @param ruleType
	 * @return
	 * @throws Exception
	 */
	public IBceFrameJavaRulesetRelValue[] getRegistedRuleSet(long aBceFrameId,
			long ruleType, Map paramMap) throws Exception {
		return BceServiceFactory.getBceFrameDAO().getRegistedRuleSet(
				aBceFrameId, ruleType, paramMap);
	}

	/**
	 * 查询be_simple_func
	 */
	public IBceSimpleFuncValue[] getSFunc(long bceFrameId) throws Exception {
		String cond = IBceSimpleFuncValue.S_BceFrameId
				+ " = :bceFrameId and state = 1 ";
		Map param = new HashMap();
		param.put("bceFrameId", new Long(bceFrameId));
		return BceServiceFactory.getBceFrameDAO().qrySFunc(cond, param);
	}

	public IBceSimpleFuncFieldMappingValue[] getSFuncFieldMapping(long funcId)
			throws Exception {
		String cond = IBceSimpleFuncFieldMappingValue.S_FuncId
				+ " = :funcId and state = 1 ";
		Map param = new HashMap();
		param.put("funcId", new Long(funcId));
		return BceServiceFactory.getBceFrameDAO().qrySFuncFieldMapping(cond,
				param);
	}

	public IBceDealReturnData dealService(long beFrameId, IBceData bceData,
			boolean is_CONFIRM, long orderId) throws Exception {
		return BceDefaultFactory._getInstance().dealService(beFrameId, bceData,
				is_CONFIRM, orderId);
	}

	/**
	 * 
	 */
	public IQBceBusinessAttrValue[] getQBceBusinessAttrs(long bceFrameId,
			String formId) throws Exception {
		String cond = IQBceBusinessAttrValue.S_BceFrameId + " = :bceFrameId   ";
		Map param = new HashMap();
		param.put("bceFrameId", new Long(bceFrameId));
		// 彭秦进变更（2010.12.30针对不知道formId）
		if (StringUtils.isNotBlank(formId)) {
			cond += "and " + IQBceBusinessAttrValue.S_FormId + " = :formId ";
			param.put("formId", formId);
		}
		cond += "and (" + IQBceBusinessAttrValue.S_RegionId + " is null or "
				+ IQBceBusinessAttrValue.S_RegionId + "="
				+ BceSVUtil.getStaticRegionId() + ") ";
		cond += " and " + IQBceBusinessAttrValue.S_State + " = 1 order by "
				+ IQBceBusinessAttrValue.S_SeqNo;
		return BceServiceFactory.getBceFrameDAO().getQBceBusinessAttrs(cond,
				param);
	}

	public IBceFrameAreaFormValue[] getBceFrameAreas(long bceFrameId,
			String formId) throws Exception {
		String cond = IBceFrameAreaFormValue.S_BceFrameId
				+ " = :bceFrameId and " + IBceFrameAreaFormValue.S_FormId
				+ " = :formId and " + IBceFrameAreaFormValue.S_State + " = 1 ";
		Map param = new HashMap();
		param.put("bceFrameId", new Long(bceFrameId));
		param.put("formId", formId);
		return BceServiceFactory.getBceFrameDAO().getBceFrameAreas(cond, param);
	}

	public IQBceBusinessButtonValue[] getQBceBusinessButton(long bceFrameId,
			String areaId) throws Exception {
		String cond = IQBceBusinessButtonValue.S_BceFrameId
				+ " = :bceFrameId and " + IQBceBusinessButtonValue.S_AreaId
				+ " = :areaId ORDER BY  " + IQBceBusinessButtonValue.S_SeqNo;
		Map param = new HashMap();
		param.put("bceFrameId", new Long(bceFrameId));
		param.put("areaId", areaId);
		return BceServiceFactory.getBceFrameDAO().getQBceBusinessButton(cond,
				param);
	}

	public IBceFormGroupValue[] getBceFormGroup(long bceFrameId, String formId)
			throws Exception {
		String cond = IBceFormGroupValue.S_BceFrameId + " = :bceFrameId and "
				+ IBceFormGroupValue.S_FormId + " = :formId and "
				+ IBceFormGroupValue.S_State + " = 1 order by "
				+ IBceFormGroupValue.S_SeqNo;
		Map param = new HashMap();
		param.put("bceFrameId", new Long(bceFrameId));
		param.put("formId", formId);
		return BceServiceFactory.getBceFrameDAO().getBceFormGroup(cond, param);
	}

	public IBceModuleValue[] getBceModule() throws Exception {
		return BceServiceFactory.getBceFrameDAO().getBceModule();
	}

	public IBceWorkflowValue[] getBceWorkflow(long busiOperId, long prodSpecId,
			long offerId) throws Exception {
		return BceServiceFactory.getBceFrameDAO().getBceWorkflow(busiOperId,
				prodSpecId, offerId);
	}

	public IBceBatInputFormatValue getImportFileConfig(long aProductSpecId,
			long aProductRoleId, long aBusinessId) throws Exception {
		return BceServiceFactory.getBceFrameDAO().getImportFileConfig(
				aProductSpecId, aProductRoleId, aBusinessId);
	}

	public IBceBatInputFieldFormatValue[] getImportFieldValues(long aConfigId)
			throws Exception {
		return BceServiceFactory.getBceFrameDAO().getImportFieldValues(
				aConfigId);
	}

	public IBceAttrFieldMapValue[] getBceAttrFieldMaps(long aBusinessId)
			throws Exception {
		return BceServiceFactory.getBceFrameDAO().getBceAttrFieldMaps(
				aBusinessId);
	}

	public IBceExtTableConfigValue[] getBceExtTableConfigs(String relType)
			throws Exception {
		return BceServiceFactory.getBceFrameDAO()
				.getBceExtTableConfigs(relType);
	}

	public IQBceBusinessAttrValue[] getQBceBusinessAttrsByBusinessId(
			long businessId, Map paramMap, String formId) throws Exception,
			RemoteException {
		// TODO Auto-generated method stub
		IBceFrameValue bceFrameValue = this.getBceFrameValue(businessId,
				paramMap);
		if (bceFrameValue == null)
			return null;
		return this.getQBceBusinessAttrs(bceFrameValue.getBceFrameId(), formId);
	}

	public IQBceBusinessAttrValue getQBceBusinessAttr(long attrId,
			long bceframeId) throws Exception {
		// TODO Auto-generated method stub
		String cond = IQBceBusinessAttrValue.S_AttrId + "=:AttrId and "
				+ IQBceBusinessAttrValue.S_BceFrameId + "=:bceframeId and "
				+ IBceFormGroupValue.S_State + " = 1";
		cond += "and (" + IQBceBusinessAttrValue.S_RegionId + " is null or "
				+ IQBceBusinessAttrValue.S_RegionId + "="
				+ BceSVUtil.getStaticRegionId() + ") ";
		Map param = new HashMap();
		param.put("AttrId", new Long(attrId));
		param.put("bceframeId", new Long(bceframeId));
		IQBceBusinessAttrValue[] qAttrValues = BceServiceFactory
				.getBceFrameDAO().getQBceBusinessAttrs(cond, param);
		if (qAttrValues == null || qAttrValues.length == 0) {
			return null;
		}
		return qAttrValues[0];
	}

	/**
	 * 
	 */
	public IQBceBusinessAttrValue getQBceBusinessAttr(long attrId)
			throws Exception {
		// TODO Auto-generated method stub
		IBceAttrValue bceAttrValue = BceServiceFactory.getBceFrameDAO()
				.getQBceBusinessAttr(attrId);
		IQBceBusinessAttrValue qAttrValue = null;
		if (bceAttrValue == null)
			return null;
		String[] attrNames = bceAttrValue.getPropertyNames();
		qAttrValue = new QBceBusinessAttrBean();
		String[] name = qAttrValue.getPropertyNames();
		for (int i = 0; i < name.length; i++) {
			String proe = name[i];
			for (int j = 0; j < attrNames.length; j++) {
				if (proe.equals(attrNames[j])) {
					qAttrValue.set(proe, bceAttrValue.get(proe));
					break;
				}
			}
		}
		return qAttrValue;
	}

	public BceTabBean getQBusiTabArea(long bceFrameId, String formId)
			throws Exception {

		return BceServiceFactory.getBceFrameDAO().getQBusiTabArea(bceFrameId,
				formId);
	}

	/*
	 * (非 Javadoc) <p>Title: getTemplateValueByframeId</p> <p>Description: </p>
	 * 
	 * @param bceframeId
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @throws RemoteException
	 * 
	 * @see
	 * com.ai.bce.service.interfaces.IBceFrameSV#getTemplateValueByframeId(long)
	 */
	public IBceQrTemplateValue getTemplateValueByframeId(long bceframeId)
			throws Exception, RemoteException {
		// TODO Auto-generated method stub
		IBceFrameValue bceFrameValue = getBceFrameValue(bceframeId);

		return BceServiceFactory.getBceFrameDAO().getTemplateValueByframeId(
				bceFrameValue.getPrintTemplateId());
	}

	/*
	 * (非 Javadoc) <p>Title: getQrTempAttrs</p> <p>Description: </p>
	 * 
	 * @param key
	 * 
	 * @param templateId
	 * 
	 * @param b
	 * 
	 * @return
	 * 
	 * @see
	 * com.ai.bce.service.interfaces.IBceFrameSV#getQrTempAttrs(java.lang.Object
	 * , long, boolean)
	 */
	public IBceQrAttrValue[] getQrTempAttrs(long attrId, String key,
			long templateId, boolean b) throws Exception, RemoteException {
		// TODO Auto-generated method stub
		return BceServiceFactory.getBceFrameDAO().getQrTempAttrs(attrId, key,
				templateId, b);
	}

	/*
	 * (非 Javadoc) <p>Title: getWarnContent</p> <p>Description: </p>
	 * 
	 * @param bceFrameId
	 * 
	 * @param businessId
	 * 
	 * @param changeName
	 * 
	 * @param changeValue
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @throws RemoteException
	 * 
	 * @see com.ai.bce.service.interfaces.IBceFrameSV#getWarnContent(long,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	public IBceWarnValue getWarnContent(long bceFrameId, String businessId,
			String changeName, String changeValue, int warnType)
			throws Exception, RemoteException {
		// TODO Auto-generated method stub
		return BceServiceFactory.getBceFrameDAO().getWarnContent(bceFrameId,
				businessId, changeName, changeValue, warnType);
	}

	/*
	 * (非 Javadoc) <p>Title: getOrderObjectType</p> <p>Description: </p>
	 * 
	 * @param businessId
	 * 
	 * @param bceFrameId
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @throws RemoteException
	 * 
	 * @see
	 * com.ai.bce.service.interfaces.IBceFrameSV#getOrderObjectType(java.lang
	 * .String, long)
	 */
	public String getOrderObjectType(long businessId, long bceFrameId)
			throws Exception, RemoteException {
		// TODO Auto-generated method stub
		IBceFrameValue bceFrameValue;
		if (bceFrameId <= 0)
			bceFrameValue = this.getBceFrameValue(businessId, null);
		else
			bceFrameValue = this.getBceFrameValue(bceFrameId);
		IBOBsParaDetailValue paraDetailValue = BceSVUtil
				.getSystemSrcTypeById(bceFrameValue.getSrcSystemType());
		return paraDetailValue.getPara1();
	}

	/*
	 * (非 Javadoc) <p>Title: getPageFramePagesTop</p> <p>Description: </p>
	 * 
	 * @param pBceFrameId
	 * 
	 * @param pPageId
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @throws RemoteException
	 * 
	 * @see com.ai.bce.service.interfaces.IBceFrameSV#getPageFramePagesTop(long,
	 * long)
	 */
	public IQPageFramePageValue getPageFramePagesTop(long pBceFrameId,
			long pPageId) throws Exception, RemoteException {
		// TODO Auto-generated method stub
		return BceServiceFactory.getBceFrameDAO().getPageFramePagesTop(
				pBceFrameId, pPageId);
	}

	public long getCoustomOrderId(String dealService) throws Exception,
			RemoteException {
		// TODO Auto-generated method stub
		return Long.valueOf(String.valueOf(PrintUtil.getNewId(dealService)));
	}

	public IBceDealReturnData dealService(long beFrameId, IBceData bceData,
			boolean isCONFIRM, String orderCode) throws Exception,
			RemoteException {
		try {
			PrintUtil.putCustomOrderCode(orderCode);
			return this.dealService(beFrameId, bceData, isCONFIRM, -1);
		} finally {
			BceCommonStore.clearThread();
		}
	}

	public String getCoustomOrderCode(String dealService) throws Exception,
			RemoteException {
		return String.valueOf(PrintUtil.getNewId(dealService));
	}

	public IBceQrTemplateValue getTemplateValueByTmmplateId(long templateId)
			throws Exception, RemoteException {
		return BceServiceFactory.getBceFrameDAO().getTemplateValueByframeId(
				templateId);
	}

	
	public IBceFrameValue[] getBceFrameValueByBusinessId(String businessId)
			throws Exception {
		// TODO Auto-generated method stub
		
			return BceServiceFactory.getBceFrameDAO().getBceFrameValue(
					businessId);
	}
}
