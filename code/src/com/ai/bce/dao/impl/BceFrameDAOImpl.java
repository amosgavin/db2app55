package com.ai.bce.dao.impl;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.complex.datasource.FlatDataSourceUtil;
import com.ai.bce.bo.BceAttrEngine;
import com.ai.bce.bo.BceAttrFieldMapEngine;
import com.ai.bce.bo.BceBatInputFieldFormatEngine;
import com.ai.bce.bo.BceBatInputFormatEngine;
import com.ai.bce.bo.BceExtTableConfigEngine;
import com.ai.bce.bo.BceFormGroupEngine;
import com.ai.bce.bo.BceFrameAreaFormEngine;
import com.ai.bce.bo.BceFrameAreaPagetabEngine;
import com.ai.bce.bo.BceFrameEngine;
import com.ai.bce.bo.BceFrameJavaRulesetRelBean;
import com.ai.bce.bo.BceFrameJavaRulesetRelEngine;
import com.ai.bce.bo.BceFramePageRoleEngine;
import com.ai.bce.bo.BceFrameSpecialPageEngine;
import com.ai.bce.bo.BceFrameTabitemEngine;
import com.ai.bce.bo.BceModuleEngine;
import com.ai.bce.bo.BcePageEngine;
import com.ai.bce.bo.BcePageFrameEngine;
import com.ai.bce.bo.BceQrAttrEngine;
import com.ai.bce.bo.BceQrTemplateEngine;
import com.ai.bce.bo.BceRowsetEngine;
import com.ai.bce.bo.BceRuleEngine;
import com.ai.bce.bo.BceSimpleFuncEngine;
import com.ai.bce.bo.BceSimpleFuncFieldMappingEngine;
import com.ai.bce.bo.BceWarnEngine;
import com.ai.bce.bo.BceWarnRelateEngine;
import com.ai.bce.bo.BceWorkflowEngine;
import com.ai.bce.bo.QBceBusinessAttrEngine;
import com.ai.bce.bo.QBceBusinessButtonEngine;
import com.ai.bce.bo.QBceRowsetBean;
import com.ai.bce.bo.QBceRulesetRuleEngine;
import com.ai.bce.bo.QPageFramePageEngine;
import com.ai.bce.dao.interfaces.IBceFrameDAO;
import com.ai.bce.ivalues.IBceAttrFieldMapValue;
import com.ai.bce.ivalues.IBceAttrValue;
import com.ai.bce.ivalues.IBceBatInputFieldFormatValue;
import com.ai.bce.ivalues.IBceBatInputFormatValue;
import com.ai.bce.ivalues.IBceExtTableConfigValue;
import com.ai.bce.ivalues.IBceFormGroupValue;
import com.ai.bce.ivalues.IBceFrameAreaFormValue;
import com.ai.bce.ivalues.IBceFrameAreaPagetabValue;
import com.ai.bce.ivalues.IBceFrameAttrValue;
import com.ai.bce.ivalues.IBceFrameJavaRulesetRelValue;
import com.ai.bce.ivalues.IBceFramePageRoleValue;
import com.ai.bce.ivalues.IBceFrameSpecialPageValue;
import com.ai.bce.ivalues.IBceFrameTabitemValue;
import com.ai.bce.ivalues.IBceFrameValue;
import com.ai.bce.ivalues.IBceModuleValue;
import com.ai.bce.ivalues.IBcePageFrameValue;
import com.ai.bce.ivalues.IBcePageRowsetRelValue;
import com.ai.bce.ivalues.IBcePageValue;
import com.ai.bce.ivalues.IBceQrAttrValue;
import com.ai.bce.ivalues.IBceQrTemplateValue;
import com.ai.bce.ivalues.IBceRowsetValue;
import com.ai.bce.ivalues.IBceRuleValue;
import com.ai.bce.ivalues.IBceSimpleFuncFieldMappingValue;
import com.ai.bce.ivalues.IBceSimpleFuncValue;
import com.ai.bce.ivalues.IBceWarnRelateValue;
import com.ai.bce.ivalues.IBceWarnValue;
import com.ai.bce.ivalues.IBceWorkflowValue;
import com.ai.bce.ivalues.IQBceBusinessAttrValue;
import com.ai.bce.ivalues.IQBceBusinessButtonValue;
import com.ai.bce.ivalues.IQBceRulesetRuleValue;
import com.ai.bce.ivalues.IQPageFramePageValue;
import com.ai.bce.util.BceException;
import com.ai.bce.util.BceSVUtil;
import com.ai.bce.util.BceUtil;
import com.ai.bce.valuebean.BceTabBean;

public class BceFrameDAOImpl implements IBceFrameDAO {
	public static transient Log log = LogFactory.getLog(BceFrameDAOImpl.class);

	public IBcePageValue getBcePage(long pageId) throws Exception {
		return BcePageEngine.getBean(pageId);
	}

	public IBceRuleValue getBceRule(long ruleId) throws Exception {
		return BceRuleEngine.getBean(ruleId);
	}

	/**
	 * 根据受理框架编号、页面编号,获取受理框架页面包含的角色配置
	 * 
	 * @param pBceFrameId
	 * @param pPageId
	 * @return
	 * @throws Exception
	 */
	public IBceFramePageRoleValue[] getBceFramePageRoles(long pBceFrameId,
			long pPageFramePageId) throws Exception {
		String sql = IBceFramePageRoleValue.S_BceFrameId + " = :pBceFrameId ";
		sql += " and " + IBceFramePageRoleValue.S_PageFramePageId
				+ " = :pPageFramePageId ";
		sql += " and " + IBceFramePageRoleValue.S_State + " = 1 ";
		sql += " order by " + IBceFramePageRoleValue.S_SeqNo + " ";
		HashMap parameter = new HashMap();
		parameter.put("pBceFrameId", new Long(pBceFrameId));
		parameter.put("pPageFramePageId", new Long(pPageFramePageId));
		IBceFramePageRoleValue[] beans = BceFramePageRoleEngine.getBeans(sql,
				parameter);
		return beans;
	}

	/**
	 * 根据受理框架编号获取受理框架包含的所有的角色
	 * 
	 * @param pBceFrameId
	 * @param pPageId
	 * @return
	 * @throws Exception
	 * @add by Yuye
	 */
	public IBceFramePageRoleValue[] getBceFramePageRolesByBceFrameId(
			long BceFrameId) throws Exception {
		String sql = IBceFramePageRoleValue.S_BceFrameId
				+ " = :pBceFrameId and " + IBceFramePageRoleValue.S_State
				+ " = 1 order by " + IBceFramePageRoleValue.S_SeqNo;
		HashMap parameter = new HashMap();
		parameter.put("pBceFrameId", new Long(BceFrameId));
		IBceFramePageRoleValue[] beans = BceFramePageRoleEngine.getBeans(sql,
				parameter);
		return beans;
	}

	/**
	 * 根据条件查询受理框架
	 */
	public IBceFrameValue getBceFrameValue(long businessId, Map paramMap)
			throws Exception {
		String cond = IBceFrameValue.S_BusinessId + " = :businessId and "
				+ IBceFrameValue.S_State + " = 1 ";
		HashMap parameter = new HashMap();
		parameter.put("businessId", new Long(businessId));
		IBceFrameValue[] values = BceFrameEngine.getBeans(cond, parameter);
		if (values == null || values.length == 0)
			return null;
		if (paramMap == null || paramMap.size() == 0) {
			for (int i = 0; i < values.length; i++) {
				IBceFrameValue iBceFrameValue = values[i];
				if (StringUtils.isBlank(iBceFrameValue.getParamData()))
					return iBceFrameValue;
			}
			return null;
		}
		int hitSize = 0;
		IBceFrameValue bceFrameValue = null;
		for (int i = 0; i < values.length; i++) {
			String paramData = values[i].getParamData();
			HashMap dataMap = BceUtil.generationMap(paramData);
			int kl = 0;
			for (Iterator iterator = dataMap.entrySet().iterator(); iterator
					.hasNext();) {
				Entry entry = (Entry) iterator.next();
				if (paramMap.containsKey(entry.getKey())
						&& StringUtils.equals(String.valueOf(entry.getValue()),
								String.valueOf(paramMap.get(entry.getKey())))) {
					kl++;
				}
			}
			if (kl == dataMap.size() && kl <= paramMap.size()) {
				if (kl > hitSize || (dataMap.size() == 0 && hitSize == 0)) {

					bceFrameValue = values[i];
					hitSize = kl;
				}
			}
			if (kl == dataMap.size() && kl == paramMap.size())
				return values[i];
		}

		return bceFrameValue;
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
		String condition = IQBceRulesetRuleValue.S_RulesetId
				+ " = :pPageRulesetId and " + IQBceRulesetRuleValue.S_State
				+ " = 1 order by " + IQBceRulesetRuleValue.S_SeqNo;
		HashMap parameter = new HashMap();
		parameter.put("pPageRulesetId", new Long(pPageRulesetId));
		return QBceRulesetRuleEngine.getBeans(condition, parameter);
	}

	/**
	 * 根据页面框架编号获取页面框架数据
	 * 
	 * @param pPageFrameId
	 * @return
	 * @throws Exception
	 */
	public IBcePageFrameValue getBcePageFrameValue(long pPageFrameId)
			throws Exception {
		IBcePageFrameValue retValue = null;
		retValue = BcePageFrameEngine.getBean(pPageFrameId);
		if (retValue != null && !retValue.isNew()) {
			return retValue;
		} else {
			return null;
		}
	}

	/**
	 * 根据受理框架编号获取受理框架数据
	 * 
	 * @param pPageFrameId
	 * @return
	 * @throws Exception
	 */
	public IBceFrameValue getBceFrameValue(long pFrameId) throws Exception {
		IBceFrameValue retValue = null;
		retValue = BceFrameEngine.getBean(pFrameId);
		if (retValue != null && !retValue.isNew()) {
			return retValue;
		} else {
			return null;
		}
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
		// 首先查询受理框架的特殊页面。
		String condition = IBceFrameSpecialPageValue.S_BceFrameId
				+ " = :pBceFrameId and " + IBceFrameSpecialPageValue.S_State
				+ " =1 ";
		HashMap parameter = new HashMap();
		parameter.put("pBceFrameId", new Long(pBceFrameId));
		IBceFrameSpecialPageValue[] BceFrameSpecPages = BceFrameSpecialPageEngine
				.getBeans(condition, parameter);
		HashMap pageMap = new HashMap();
		if (BceFrameSpecPages != null && BceFrameSpecPages.length > 0) {
			for (int i = 0; i < BceFrameSpecPages.length; i++) {
				pageMap.put(
						new Long(BceFrameSpecPages[i].getPageFramePageId()),
						BceFrameSpecPages[i]);
			}
		}
		// 查询受理框架的页面，如果页面信息在受理框架的特殊页面已存在，则以特殊页面的配置信息覆盖之。
		condition = IQPageFramePageValue.S_PageFrameId
				+ " = :pPageFrameId and " + IQPageFramePageValue.S_State
				+ " =1 and " + IQPageFramePageValue.S_PageLoadType
				+ " in (1,2) order by " + IQPageFramePageValue.S_SeqNo;
		parameter = new HashMap();
		parameter.put("pPageFrameId", new Long(pPageFrameId));
		IQPageFramePageValue[] pageFamePages = QPageFramePageEngine.getBeans(
				condition, parameter);
		if (pageFamePages != null && pageFamePages.length > 0) {
			for (int i = 0; i < pageFamePages.length; i++) {
				long pageFramePageId = pageFamePages[i].getPageFramePageId();
				IBceFrameSpecialPageValue specPage = (IBceFrameSpecialPageValue) pageMap
						.get(new Long(pageFramePageId));
				if (specPage != null) {
					if (StringUtils.isNotBlank(specPage.getPageParam())) {
						String tmp = pageFamePages[i].getPageUrl();
						if (tmp.indexOf("?") > 0) {
							tmp += "&" + specPage.getPageParam();
						} else {
							tmp += "?" + specPage.getPageParam();
						}
						pageFamePages[i].setPageUrl(tmp);
					}
					if (specPage.getIsDataMust() != -1)
						pageFamePages[i]
								.setIsDataMust(specPage.getIsDataMust());
					if (specPage.getIsGetPageData() != -1)
						pageFamePages[i].setIsGetPageData(specPage
								.getIsGetPageData());
					if (specPage.getPageRulesetId() != -1)
						pageFamePages[i].setPageRulesetId(specPage
								.getPageRulesetId());
					if (StringUtils.isNotBlank(specPage.getPageTitle()))
						pageFamePages[i].setPageTitle(specPage.getPageTitle());
				}
			}
		}
		return pageFamePages;
	}

	/**
	 * 根据页面编号获取页面关联的数据集
	 * 
	 * @param pPageId
	 * @return
	 * @throws Exception
	 */
	public IBceRowsetValue[] getPageRowsets(long pPageFramePageId)
			throws Exception {
		String sql = QBceRowsetBean.getObjectTypeStatic().getMapingEnty();
		sql += " and " + IBcePageRowsetRelValue.S_PageFramePageId
				+ " = :pPageFramePageId ";
		HashMap parameter = new HashMap();
		parameter.put("pPageFramePageId", new Long(pPageFramePageId));
		return BceRowsetEngine.getBeansFromSql(sql, parameter);
	}

	/**
	 * 查询该受理框架注册的该类规则集
	 */
	public IBceFrameJavaRulesetRelValue[] getRegistedRuleSet(long aBceFrameId,
			long ruleType, Map paramMap) throws Exception {
		String cond = IBceFrameJavaRulesetRelValue.S_BceFrameId
				+ " = :aBceFrameId and "
				+ IBceFrameJavaRulesetRelValue.S_RulesetType
				+ " = :ruleType and " + IBceFrameJavaRulesetRelValue.S_State
				+ " = 1 ";
		HashMap param = new HashMap();
		param.put("aBceFrameId", new Long(aBceFrameId));
		param.put("ruleType", new Long(ruleType));
		IBceFrameJavaRulesetRelValue[] values = BceFrameJavaRulesetRelEngine
				.getBeans(cond, param);
		if (values == null || values.length == 0)
			return new IBceFrameJavaRulesetRelValue[0];
		if (paramMap == null || paramMap.size() == 0) {
			return values;
		}
		// values[i].getParamData()基本上都没有配，根据这一特点做特殊处理以提高效率
		boolean isParamDataAllBlank = true;
		for (int i = 0; i < values.length; i++) {
			if (StringUtils.isNotBlank(values[i].getParamData())) {
				isParamDataAllBlank = false;
				break;
			}
		}
		if (isParamDataAllBlank == true) {
			return values;
		}

		// 根据values[i].getParamData() 分组
		Map map = new HashMap();
		String blankParam = "null";
		for (int i = 0; i < values.length; i++) {
			String paramData = values[i].getParamData();
			if (StringUtils.isBlank(paramData)) {
				paramData = blankParam;
			}
			List list = (List) map.get(paramData);
			if (list == null) {
				list = new ArrayList();
				map.put(paramData, list);
			}
			list.add(values[i]);
		}

		// 根据参数列表匹配
		int index = -1;
		int maxMatch = 0;
		int maxNotMatch = 0;
		Set keySet = map.keySet();
		String[] keys = (String[]) keySet.toArray(new String[0]);
		for (int i = 0; i < keys.length; i++) {
			String paramData = keys[i];
			if (StringUtils.isBlank(paramData) || paramData.equals(blankParam)) {
				if (index == -1)
					index = i;
				continue;
			}
			int match = 0;
			int notMatch = 0;
			String[] params = StringUtils.split(paramData, "&");

			for (int j = 0; j < params.length; j++) {
				String[] tmp = StringUtils.split(params[j], "=");
				if (tmp.length != 2) {
					throw new BceException("BES0000413",
							"key1=value1&key2=value2");
				}

				if (paramMap.containsKey(tmp[0])) {
					if (paramMap.get(tmp[0]).toString().equals(tmp[1])) {
						match++;
					} else {
						// 不一致说明不匹配
						match = 0;
						break;
					}
				} else {
					notMatch++;
				}
			}
			if (match > maxMatch) {
				maxMatch = match;
				maxNotMatch = notMatch;
				index = i;
			} else if (match == maxMatch && notMatch < maxNotMatch) {
				maxMatch = match;
				maxNotMatch = notMatch;
				index = i;
			}
		}
		if (index == -1) {
			return new IBceFrameJavaRulesetRelValue[0];
		}
		List returnList = (List) map.get(keys[index]);
		return (IBceFrameJavaRulesetRelValue[]) returnList
				.toArray(new BceFrameJavaRulesetRelBean[0]);
	}

	public IBceSimpleFuncValue[] qrySFunc(String cond, Map param)
			throws Exception {
		return BceSimpleFuncEngine.getBeans(cond, param);
	}

	public IBceSimpleFuncFieldMappingValue[] qrySFuncFieldMapping(String cond,
			Map param) throws Exception {
		return BceSimpleFuncFieldMappingEngine.getBeans(cond, param);
	}

	public DataContainerInterface[] getDatasByBO(String datasourceName,
			String cond, Map param, ObjectType ot) throws Exception {
		Connection conn = ServiceManager.getSession().getConnection(
				datasourceName);
		try {
			return ServiceManager.getDataStore().retrieve(conn, null, ot, null,
					cond, param, -1, -1, false, false, null);
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	// bce配置工具通用数据保存方法
	public void saveDatasForConf(DataContainerInterface[] dcs,
			String datasourceName) throws Exception {
		// 因为appframe不支持DataContainerInterface[] 为不同的bo，所以此处进行分组
		Map map = new HashMap();
		for (int i = 0; i < dcs.length; i++) {
			ObjectType ot = dcs[i].getObjectType();
			List list = (List) map.get(ot);
			if (list == null) {
				list = new ArrayList();
				map.put(ot, list);
			}
			list.add(dcs[i]);
		}
		Set keys = map.keySet();
		for (Iterator it = keys.iterator(); it.hasNext();) {
			List list = (List) map.get(it.next());
			this.saveDatas((DataContainerInterface[]) list
					.toArray(new DataContainerInterface[0]), datasourceName);
		}
	}

	// 通用数据保存方法
	public void saveDatas(DataContainerInterface[] dcs, String datasourceName)
			throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("Begin to save datas...");
		}
		Connection conn = null;
		String oldDataSource = null;
		if (StringUtils.isNotBlank(datasourceName)) {
			oldDataSource = FlatDataSourceUtil
					.suspendCurrentDataSource(datasourceName);

			if (log.isDebugEnabled()) {
				log.debug("Original DataSource: " + oldDataSource
						+ ". Current DataSource: " + datasourceName);
			}
		} else {
			if (log.isDebugEnabled()) {
				log.debug("Use default DataSource");
			}
		}
		conn = ServiceManager.getSession().getConnection();
		try {
			/*
			 * if (dcs.length > 0) { ObjectType tmpType =
			 * dcs[0].getObjectType(); String[] names =
			 * tmpType.getPropertyNames(); List needTransferColName = new
			 * ArrayList(); List needTransferJavaClass = new ArrayList();
			 * 
			 * for (int i = 0; i < names.length; i++) { String colJavaType =
			 * tmpType.getProperty(names[i]) .getJavaDataType(); Class tmpClass
			 * = BceUtil.getNumberClass(colJavaType); if (tmpClass != null) {
			 * needTransferJavaClass.add(tmpClass);
			 * needTransferColName.add(names[i]); } } for (int i = 0; i <
			 * dcs.length; i++) { for (int j = 0; j <
			 * needTransferColName.size(); j++) { String name = (String)
			 * needTransferColName.get(j); Class tmpClass = (Class)
			 * needTransferJavaClass.get(j); if (dcs[i].getOldObj(name) != null)
			 * { //
			 * dcs[i].initProperty(name,BceUtil.transfer((Number)dcs[i].getOldObj
			 * (name), // tmpClass)); dcs[i].initProperty(name,
			 * DataType.transfer(dcs[i] .getOldObj(name), tmpClass)); } if
			 * (dcs[i].get(name) != null) { //
			 * dcs[i].set(name,BceUtil.transfer((Number)dcs[i].get(name), //
			 * tmpClass)); dcs[i].set(name, DataType.transfer( dcs[i].get(name),
			 * tmpClass)); } } } }
			 */
			ServiceManager.getDataStore().saveBatch(conn, dcs);
			if (log.isDebugEnabled()) {
				log.debug("Finished save datas. Total: " + dcs.length);
			}
		} finally {
			if (conn != null)
				conn.close();
			if (StringUtils.isNotBlank(datasourceName)) {
				FlatDataSourceUtil.resumeCurrentDataSource(oldDataSource);
				if (log.isDebugEnabled()) {
					log.debug("Resume DataSource to " + oldDataSource);
				}
			}
		}
	}

	public IQBceBusinessAttrValue[] getQBceBusinessAttrs(String cond, Map param)
			throws Exception {
		return QBceBusinessAttrEngine.getBeans(cond, param);
	}

	public IBceFrameAreaFormValue[] getBceFrameAreas(String cond, Map param)
			throws Exception {
		return BceFrameAreaFormEngine.getBeans(cond, param);
	}

	public IQBceBusinessButtonValue[] getQBceBusinessButton(String cond,
			Map param) throws Exception {
		return QBceBusinessButtonEngine.getBeans(cond, param);
	}

	public IBceFormGroupValue[] getBceFormGroup(String cond, Map param)
			throws Exception {
		return BceFormGroupEngine.getBeans(cond, param);
	}

	public IBceModuleValue[] getBceModule() throws Exception {
		return BceModuleEngine.getBeans(IBceModuleValue.S_State
				+ " = 1 order by " + IBceModuleValue.S_ModuleId, null);
	}

	public IBceWorkflowValue[] getBceWorkflow(long busiOperId, long prodSpecId,
			long offerId) throws Exception, RemoteException {
		StringBuffer buf = new StringBuffer();
		Map param = new HashMap();
		buf.append(IBceWorkflowValue.S_BusinessId)
				.append(" = :busiOperId and ")
				.append(IBceWorkflowValue.S_State).append(" = 1 ");
		param.put("busiOperId", new Long(busiOperId));
		if (offerId < 0)
			offerId = -1;
		buf.append(" and ( ").append(IBceWorkflowValue.S_OfferId).append(
				" = :offerId  or ").append(
				IBceWorkflowValue.S_OfferId + "='-1')");
		param.put("offerId", new Long(offerId));

		if (prodSpecId < 0)
			prodSpecId = -1;
		buf.append(" and (").append(IBceWorkflowValue.S_ProdSpecId).append(
				" = :prodSpecId or " + IBceWorkflowValue.S_ProdSpecId
						+ "='-1' ) order by seq_No ");
		param.put("prodSpecId", new Long(prodSpecId));

		return BceWorkflowEngine.getBeans(buf.toString(), param);
	}

	/**
	 * 根据产品规格编号和角色编号查询该角色成员导入的文件格式配置信息
	 * 
	 * @param aProductSpecId
	 * @param aProductRoleId
	 * @param aBusinessId
	 * @return
	 * @throws Exception
	 */
	public IBceBatInputFormatValue getImportFileConfig(long aProductSpecId,
			long aProductRoleId, long aBusinessId) throws Exception {
		IBceBatInputFormatValue ret = null;
		String condition = "(" + IBceBatInputFormatValue.S_ProdSpecId
				+ " = :aProductSpecId or "
				+ IBceBatInputFormatValue.S_ProdSpecId + " = -10000 )";
		condition += " and (" + IBceBatInputFormatValue.S_RoleId
				+ " = :aProductRoleId  or " + IBceBatInputFormatValue.S_RoleId
				+ " = -10000)";
		condition += " and (" + IBceBatInputFormatValue.S_BusinessId
				+ " = :aBusinessId or " + IBceBatInputFormatValue.S_BusinessId
				+ " = -1 )";
		HashMap parameter = new HashMap();
		parameter.put("aProductSpecId", String.valueOf(aProductSpecId));
		parameter.put("aProductRoleId", String.valueOf(aProductRoleId));
		parameter.put("aBusinessId", String.valueOf(aBusinessId));
		IBceBatInputFormatValue[] values = BceBatInputFormatEngine.getBeans(
				condition, parameter);
		if (values != null && values.length > 0) {
			// 判断具体传入的参数，如果有具体参数的，则返回符合具体参数最多的那条数据。
			int maxFitNo = -1;
			int maxFitRowNo = 0;
			for (int i = 0; i < values.length; i++) {
				int tmpFitNo = 0;
				if (values[i].getBusinessId() == aBusinessId) {
					tmpFitNo++;
				}
				if (values[i].getRoleId() == aProductRoleId) {
					tmpFitNo++;
				}

				if (tmpFitNo > maxFitNo) {
					maxFitNo = tmpFitNo;
					maxFitRowNo = i;
				}
			}
			ret = values[maxFitRowNo];
		} else {
			// "未找到产品规格["+aProductSpecId+"]、角色["+aProductRoleId+"]、业务操作为["+aBusinessId+"]的成员导入的配置数据。"
			Object[] pParams = new String[] { Long.toString(aProductSpecId),
					Long.toString(aProductRoleId), Long.toString(aBusinessId) };
			throw new BceException("BES0000008", pParams);
		}
		return ret;
	}

	/**
	 * 根据配置编号获取配置的字段的详细信息
	 * 
	 * @param aConfigId
	 * @return
	 * @throws Exception
	 */
	public IBceBatInputFieldFormatValue[] getImportFieldValues(long aConfigId)
			throws Exception {
		String condition = IBceBatInputFieldFormatValue.S_ConfigId
				+ " = :aConfigId order by "
				+ IBceBatInputFieldFormatValue.S_SeqNo;
		HashMap parameter = new HashMap();
		parameter.put("aConfigId", new Long(aConfigId));
		return BceBatInputFieldFormatEngine.getBeans(condition, parameter);
	}

	/**
	 * 根据业务操作编号查询该业务操作配置的属性与订单列的映射关系
	 * 
	 * @param aBusinessId
	 * @return
	 * @throws Exception
	 */
	public IBceAttrFieldMapValue[] getBceAttrFieldMaps(long aBusinessId)
			throws Exception {
		String condition = IBceAttrFieldMapValue.S_BusinessId
				+ " = :aBusinessId ";
		HashMap parameter = new HashMap();
		parameter.put("aBusinessId", new Long(aBusinessId));
		return BceAttrFieldMapEngine.getBeans(condition, parameter);
	}

	/**
	 * 根据关联字段类型查询订单扩展表配置
	 * 
	 * @param relType
	 * @return
	 * @throws Exception
	 */
	public IBceExtTableConfigValue[] getBceExtTableConfigs(String relType)
			throws Exception {
		String condition = IBceExtTableConfigValue.S_State + " = 1 ";
		HashMap parameter = new HashMap();
		condition += " and " + IBceExtTableConfigValue.S_RelType
				+ " = :relType";
		parameter.put("relType", relType);
		return BceExtTableConfigEngine.getBeans(condition, parameter);
	}

	public IQBceBusinessAttrValue[] getBceAttrValues(long attrId, long frameId)
			throws Exception {
		// TODO Auto-generated method stub
		String condition = IBceFrameAttrValue.S_State + " = 1 ";
		condition += "and " + IBceFrameAttrValue.S_AttrId + " = :attrId and "
				+ IBceFrameAttrValue.S_BceFrameId + " =:frameId ";
		Map parameter = new HashMap();
		parameter.put("attrId", String.valueOf(attrId));
		parameter.put("frameId", String.valueOf(frameId));

		return this.getQBceBusinessAttrs(condition, parameter);
	}

	public IBceAttrValue getQBceBusinessAttr(long attrId) throws Exception {
		// TODO Auto-generated method stub
		return BceAttrEngine.getBean(attrId);
	}

	public BceTabBean getQBusiTabArea(long bceFrameId, String formId)
			throws Exception {
		String cond = IBceFrameAreaPagetabValue.S_BceFrameId
				+ " = :bceFrameId and " + IBceFrameAreaPagetabValue.S_AreaId
				+ " = :PagetabId and " + IBceFrameAreaPagetabValue.S_State
				+ " = 1 ";
		Map param = new HashMap();
		param.put("bceFrameId", new Long(bceFrameId));
		param.put("PagetabId", formId);
		IBceFrameAreaPagetabValue[] areaPagetabValue = BceFrameAreaPagetabEngine
				.getBeans(cond, param);
		BceTabBean tabBean = new BceTabBean();
		if (areaPagetabValue != null && areaPagetabValue.length > 0) {
			tabBean.setAreaPagetabValue(areaPagetabValue[0]);
		}
		cond = IBceFrameTabitemValue.S_TabId + " = :tabId and "
				+ IBceFrameTabitemValue.S_State + " = 1 ";
		param.clear();
		param.put("tabId", new Long(tabBean.getAreaPagetabValue().getTabId()));
		IBceFrameTabitemValue[] tabitemValues = BceFrameTabitemEngine.getBeans(
				cond, param);
		tabBean.setTabitemValues(tabitemValues);
		return tabBean;
	}

	/*
	 * (非 Javadoc) <p>Title: getTemplateValueByframeId</p> <p>Description: </p>
	 * 
	 * @param printTemplateId
	 * 
	 * @return
	 * 
	 * @see
	 * com.ai.bce.dao.interfaces.IBceFrameDAO#getTemplateValueByframeId(long)
	 */
	public IBceQrTemplateValue getTemplateValueByframeId(long printTemplateId)
			throws Exception {
		// TODO Auto-generated method stub
		return BceQrTemplateEngine.getBean(printTemplateId);
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
	 * com.ai.bce.dao.interfaces.IBceFrameDAO#getQrTempAttrs(java.lang.String,
	 * long, boolean)
	 */
	public IBceQrAttrValue[] getQrTempAttrs(long attrId, String key,
			long templateId, boolean b) throws Exception {
		// TODO Auto-generated method stub
		if (templateId < 1) {
			throw new Exception("no templateId");
		}
		String sql = "";
		Map map = new HashMap();
		if (key == null && b) {
			sql = IBceQrAttrValue.S_TemplateId + "=:templateId";
			map.put("templateId", Long.valueOf(templateId));
		} else if (key != null && b) {
			sql = IBceQrAttrValue.S_TemplateId + "=:templateId and "
					+ IBceQrAttrValue.S_AttrName + "=:AttrName";
			map.put("templateId", Long.valueOf(templateId));
			map.put("AttrName", key);
		} else {
			sql = IBceQrAttrValue.S_TemplateId + "=:templateId and "
					+ IBceQrAttrValue.S_PreAttrId + "=:AttrId";
			map.put("templateId", Long.valueOf(templateId));
			map.put("AttrId", Long.valueOf(attrId));
		}
		return BceQrAttrEngine.getBeans(sql, map);
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
	 * @see com.ai.bce.dao.interfaces.IBceFrameDAO#getWarnContent(long,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	public IBceWarnValue getWarnContent(long bceFrameId, String businessId,
			String changeName, String changeValue,int warnType) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		Map map = new HashMap();
		if (bceFrameId > 1) {
			buffer.append(IBceWarnRelateValue.S_BceFrameId + " =:bceFrameId ");
			map.put("bceFrameId", Long.valueOf(bceFrameId));
		}
		if (StringUtils.isNotBlank(businessId)) {
			buffer.append(" and " + IBceWarnRelateValue.S_BusinessId
					+ " =:BusinessId ");
			map.put("BusinessId", businessId);
		}
		if (StringUtils.isNotBlank(changeName)) {
			buffer.append(" and " + IBceWarnRelateValue.S_ChangeName
					+ " =:changeName ");
			map.put("changeName", changeName);
		}
		if (StringUtils.isNotBlank(changeValue)) {
			buffer.append(" and " + IBceWarnRelateValue.S_ChangeNewValue
					+ " =:changeValue ");
			map.put("changeValue", changeValue);
		}
		
		buffer.append( " and ("+IBceWarnRelateValue.S_RegionId +" is null or "+IBceWarnRelateValue.S_RegionId+"="+BceSVUtil.getStaticRegionId()+") ");
		
		IBceWarnRelateValue[] bceWarnValues = BceWarnRelateEngine.getBeans(
				buffer.toString(), map);
		if(bceWarnValues!=null){
			for (int i = 0; i < bceWarnValues.length; i++) {
				long warnId = bceWarnValues[0].getWarnId();
				IBceWarnValue bceWarnValue =  BceWarnEngine.getBean(warnId);
				if(bceWarnValue.getWarnType() == warnType){
					return bceWarnValue;
				}
			}
		}
		return null;
	}

	/**
	 * 根据受理框架编号、页面编号查询页面框架指定的弹出的页面
	 * 
	 * @param pBceFrameId
	 * @param pPageFrameId
	 * @return
	 * @throws Exception
	 */
	public IQPageFramePageValue getPageFramePagesTop(long pBceFrameId,
			long pPageId) throws Exception {
		// 首先查询受理框架的特殊页面。
		IBceFrameValue frameValue = this.getBceFrameValue(pBceFrameId);
		String condition = IBceFrameSpecialPageValue.S_BceFrameId
				+ " = :pBceFrameId and " + IBceFrameSpecialPageValue.S_State
				+ " =1 ";
		HashMap parameter = new HashMap();
		parameter.put("pBceFrameId", new Long(pBceFrameId));
		IBceFrameSpecialPageValue[] BceFrameSpecPages = BceFrameSpecialPageEngine
				.getBeans(condition, parameter);
		HashMap pageMap = new HashMap();
		if (BceFrameSpecPages != null && BceFrameSpecPages.length > 0) {
			for (int i = 0; i < BceFrameSpecPages.length; i++) {
				pageMap.put(
						new Long(BceFrameSpecPages[i].getPageFramePageId()),
						BceFrameSpecPages[i]);
			}
		}
		// 查询受理框架的页面，如果页面信息在受理框架的特殊页面已存在，则以特殊页面的配置信息覆盖之。
		condition = IQPageFramePageValue.S_PageId + " = :pPageFrameId and  "
				+ IQPageFramePageValue.S_State + " =1 and "
				+ IQPageFramePageValue.S_PageFrameId + "=:pageFrameId AND "
				+ IQPageFramePageValue.S_PageLoadType + " in (3) order by "
				+ IQPageFramePageValue.S_SeqNo;
		parameter = new HashMap();
		parameter.put("pPageFrameId", new Long(pPageId));
		parameter.put("pageFrameId", new Long(frameValue.getPageFrameId()));
		IQPageFramePageValue[] pageFamePages = QPageFramePageEngine.getBeans(
				condition, parameter);
		if (pageFamePages != null && pageFamePages.length > 0) {
			for (int i = 0; i < pageFamePages.length; i++) {
				long pageFramePageId = pageFamePages[i].getPageFramePageId();
				IBceFrameSpecialPageValue specPage = (IBceFrameSpecialPageValue) pageMap
						.get(new Long(pageFramePageId));
				if (specPage != null) {
					if (StringUtils.isNotBlank(specPage.getPageParam())) {
						String tmp = pageFamePages[i].getPageUrl();
						if (tmp.indexOf("?") > 0) {
							tmp += "&" + specPage.getPageParam();
						} else {
							tmp += "?" + specPage.getPageParam();
						}
						pageFamePages[i].setPageUrl(tmp);
					}
					if (specPage.getIsDataMust() != -1)
						pageFamePages[i]
								.setIsDataMust(specPage.getIsDataMust());
					if (specPage.getIsGetPageData() != -1)
						pageFamePages[i].setIsGetPageData(specPage
								.getIsGetPageData());
					if (specPage.getPageRulesetId() != -1)
						pageFamePages[i].setPageRulesetId(specPage
								.getPageRulesetId());
					if (StringUtils.isNotBlank(specPage.getPageTitle()))
						pageFamePages[i].setPageTitle(specPage.getPageTitle());
				}
			}
		}
		return pageFamePages[0];
	}

	
	public IBceFrameValue[] getBceFrameValue(String businessId)
			throws Exception {
		// 
		String cond = IBceFrameValue.S_BusinessId + " = :businessId and "
		+ IBceFrameValue.S_State + " = 1 ";
		HashMap parameter = new HashMap();
		parameter.put("businessId", new Long(businessId));
		IBceFrameValue[] values = BceFrameEngine.getBeans(cond, parameter);
		return values;
	}

}
