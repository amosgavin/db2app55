package com.ai.bce.auto.plugin.cache.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.complex.cache.CacheFactory;
import com.ai.bce.auto.plugin.cache.BceServiceCache;
import com.ai.bce.auto.plugin.cache.service.interfaces.IBceFrameCacheSV;
import com.ai.bce.bo.BceBatInputFieldFormatBean;
import com.ai.bce.bo.BceExtTableConfigBean;
import com.ai.bce.bo.BceFormGroupBean;
import com.ai.bce.bo.BceFrameAreaFormBean;
import com.ai.bce.bo.BceFrameJavaRulesetRelBean;
import com.ai.bce.bo.BceFramePageRoleBean;
import com.ai.bce.bo.BceFrameTabitemBean;
import com.ai.bce.bo.BceModuleBean;
import com.ai.bce.bo.BceRowsetBean;
import com.ai.bce.bo.BceSimpleFuncBean;
import com.ai.bce.bo.BceWorkflowBean;
import com.ai.bce.bo.QBceBusinessAttrBean;
import com.ai.bce.bo.QBceBusinessButtonBean;
import com.ai.bce.bo.QBceRulesetRuleBean;
import com.ai.bce.bo.QPageFramePageBean;
import com.ai.bce.ivalues.IBceAttrFieldMapValue;
import com.ai.bce.ivalues.IBceAttrValue;
import com.ai.bce.ivalues.IBceBatInputFieldFormatValue;
import com.ai.bce.ivalues.IBceBatInputFormatValue;
import com.ai.bce.ivalues.IBceData;
import com.ai.bce.ivalues.IBceDealReturnData;
import com.ai.bce.ivalues.IBceExtTableConfigValue;
import com.ai.bce.ivalues.IBceFormGroupValue;
import com.ai.bce.ivalues.IBceFrameAreaFormValue;
import com.ai.bce.ivalues.IBceFrameAreaPagetabValue;
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
import com.ai.bce.service.interfaces.IBceFrameSV;
import com.ai.bce.util.BceException;
import com.ai.bce.util.BceSVUtil;
import com.ai.bce.util.BceUtil;
import com.ai.bce.util.LocaleResourceFactory;
import com.ai.bce.util.ReflectUtils;
import com.ai.bce.valuebean.BceTabBean;
import com.asiainfo.crm.common.ivalues.IBOBsParaDetailValue;

public class BceFrameCacheSVImpl implements IBceFrameCacheSV {
	public static transient final Log log = LogFactory
			.getLog(BceFrameCacheSVImpl.class);

	public Object getCache(String key) throws Exception {
		Map cmmaps = (Map) CacheFactory.get(BceServiceCache.class,
				"BCE_SERVICE_CACHE");
		Map cmcmp = (Map) cmmaps.get(key);
		return cmcmp.get(key);
	}

	public IBceDealReturnData dealService(long beFrameId, IBceData bceData,
			boolean is_CONFIRM, long orderId) throws Exception {
		IBceFrameSV object = (IBceFrameSV) ReflectUtils.constructorNewInstance(
				IBceFrameSV.class.getName(), new Class[] {}, new Object[] {});
		return object.dealService(beFrameId, bceData, is_CONFIRM, orderId);
	}

	public IBceFormGroupValue[] getBceFormGroup(long bceFrameId, String formId)
			throws Exception {
		Map key = (Map) getCache("getBceFormGroup");
		List groups = (List) key.get(String.valueOf(bceFrameId));
		if (groups == null)
			return new IBceFormGroupValue[0];
		List bceList = new LinkedList();
		for (Iterator iterator = groups.iterator(); iterator.hasNext();) {
			IBceFormGroupValue bceFormGroupValue = (IBceFormGroupValue) iterator
					.next();
			if (formId.equals(bceFormGroupValue.getFormId())) {
				bceList.add(bceFormGroupValue);
			}
		}
		return (IBceFormGroupValue[]) bceList.toArray(new BceFormGroupBean[0]);
	}

	public IBceFrameAreaFormValue[] getBceFrameAreas(long bceFrameId,
			String formId) throws Exception {
		Map key = (Map) getCache("getBceFrameAreas");
		List groups = (List) key.get(String.valueOf(bceFrameId));
		if (groups == null)
			return new IBceFrameAreaFormValue[0];
		List bceList = new LinkedList();
		for (Iterator iterator = groups.iterator(); iterator.hasNext();) {
			IBceFrameAreaFormValue bceFormGroupValue = (IBceFrameAreaFormValue) iterator
					.next();
			if (formId.equals(bceFormGroupValue.getFormId())) {
				bceList.add(bceFormGroupValue);
			}
		}
		return (IBceFrameAreaFormValue[]) bceList
				.toArray(new BceFrameAreaFormBean[0]);
	}

	public IBceFrameValue getBceFrameValue(long frameId) throws Exception {
		Map cmmap = (Map) getCache("getBceFrameValue");
		List value = ((List) cmmap.get(String.valueOf(frameId)));
		if (value == null)
			return null;
		if (value.size() == 1) {
			return (IBceFrameValue) value.get(0);
		}
		return null;
	}

	public IBceModuleValue[] getBceModule() throws Exception {
		// TODO 没有用到，暂时不说

		Map cmmap = (Map) getCache("getBceModule");
		List modules = new LinkedList();
		for (Iterator iterator = cmmap.entrySet().iterator(); iterator
				.hasNext();) {
			Entry name = (Entry) iterator.next();
			List lis = (List) name.getValue();
			modules.addAll(lis);
		}
		return (IBceModuleValue[]) modules.toArray(new BceModuleBean[0]);
	}

	public IBcePageValue getBcePage(long pageId) throws Exception {
		// TODO Auto-generated method stub
		if (log.isDebugEnabled()) {
			log.debug(LocaleResourceFactory.getResource(""));
		}
		Map cmmap = (Map) getCache("getBcePage");
		List value = ((List) cmmap.get(String.valueOf(pageId)));
		if (value == null)
			return null;
		if (value.size() == 1) {
			return (IBcePageValue) value.get(0);
		}
		return null;
	}

	public IBceRuleValue getBceRule(long ruleId) throws Exception {
		// TODO Auto-generated method stub
		Map cmmap = (Map) getCache("getBceRule");
		List value = ((List) cmmap.get(String.valueOf(ruleId)));

		if (value != null && value.size() == 1) {
			return (IBceRuleValue) value.get(0);
		}
		return null;
	}

	public IBceAttrFieldMapValue[] getBceAttrFieldMaps(long businessId)
			throws Exception {
		// TODO Auto-generated method stub
		Map cmmap = (Map) getCache("getBceAttrFieldMaps");
		List value = ((List) cmmap.get(String.valueOf(businessId)));
		return value == null ? new IBceAttrFieldMapValue[0]
				: (IBceAttrFieldMapValue[]) value
						.toArray(new IBceAttrFieldMapValue[0]);
	}

	public IBceExtTableConfigValue[] getBceExtTableConfigs(String relType)
			throws Exception {
		// TODO Auto-generated method stub
		Map cmmap = (Map) getCache("getBceExtTableConfigs");
		List value = ((List) cmmap.get(relType));
		return value == null ? new IBceExtTableConfigValue[0]
				: (IBceExtTableConfigValue[]) value
						.toArray(new BceExtTableConfigBean[0]);
	}

	public IBceFramePageRoleValue[] getBceFramePageRoles(long bceFrameId,
			long pageId) throws Exception {

		Map cmmap = (Map) getCache("getBceFramePageRoles");
		List value = ((List) cmmap.get(String.valueOf(bceFrameId)));
		if (value == null)
			return new BceFramePageRoleBean[0];
		List values = new LinkedList();
		for (Iterator iterator = value.iterator(); iterator.hasNext();) {
			IBceFramePageRoleValue name = (IBceFramePageRoleValue) iterator
					.next();
			if (name.getPageFramePageId() == pageId)
				values.add(name);
		}
		// TODO Auto-generated method stub
		return (IBceFramePageRoleValue[]) values
				.toArray(new BceFramePageRoleBean[0]);
	}

	public IBceFramePageRoleValue[] getBceFramePageRolesByBceFrameId(
			long BceFrameId) throws Exception {
		Map cmmap = (Map) getCache("getBceFramePageRoles");
		List value = ((List) cmmap.get(String.valueOf(BceFrameId)));

		return value == null ? new BceFramePageRoleBean[0]
				: (IBceFramePageRoleValue[]) value
						.toArray(new BceFramePageRoleBean[0]);
	}

	public IBceFrameValue getBceFrameValue(long businessId, Map paramMap)
			throws Exception {
		Map cmmap = (Map) getCache("getBceFrameValueByBusiness");
		List li = (List) cmmap.get(String.valueOf(businessId));
		if (li == null)
			return null;
		IBceFrameValue[] values = new IBceFrameValue[li.size()];
		for (int i = 0; i < li.size(); i++) {
			Object objce = li.get(i);
			values[i] = (IBceFrameValue) objce;
		}
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
		// 根据参数列表匹配
		// 根据参数列表匹配
		int hitSize = 0;
		IBceFrameValue bceFrameValue = null;
		for (int i = 0; i < values.length; i++) {
			String paramData = values[i].getParamData();
			HashMap dataMap = BceUtil.generationMap(paramData);
			// 匹配数量
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
				// 匹配数量大于上次匹配数量
				if (kl > hitSize || (dataMap.size() == 0 && hitSize == 0)) {
					bceFrameValue = values[i];
					hitSize = kl;
				}
			}
			// **完全匹配数据
			if (kl == dataMap.size() && kl == paramMap.size())
				return values[i];
		}

		return bceFrameValue;
	}

	public IBceWorkflowValue[] getBceWorkflow(long busiOperId, long prodSpecId,
			long offerId) throws Exception {
		// TODO Auto-generated method stub
		Map BePageFrameMap = (Map) getCache("getBceWorkflow");
		List value = ((List) BePageFrameMap.get(String.valueOf(busiOperId)));
		if (value == null)
			return new IBceWorkflowValue[0];
		if (prodSpecId <= 0 && offerId <= 0) {
			return (IBceWorkflowValue[]) value.toArray(new BceWorkflowBean[0]);
		}
		List values = new LinkedList();
		for (Iterator iterator = value.iterator(); iterator.hasNext();) {
			IBceWorkflowValue bceWorkflowValue = (IBceWorkflowValue) iterator
					.next();
			if ((bceWorkflowValue.getProdSpecId() == -1 || bceWorkflowValue
					.getProdSpecId() == prodSpecId)
					&& (bceWorkflowValue.getOfferId() == -1 || bceWorkflowValue
							.getOfferId() == offerId)) {
				values.add(bceWorkflowValue);
			}
		}
		return (IBceWorkflowValue[]) values.toArray(new BceWorkflowBean[0]);
	}

	public IBcePageFrameValue getBePageFrameValue(long pageFrameId)
			throws Exception {
		// TODO Auto-generated method stub
		Map BePageFrameMap = (Map) getCache("getBePageFrameValue");
		List value = ((List) BePageFrameMap.get(String.valueOf(pageFrameId)));
		if (value != null && value.size() == 1) {
			return (IBcePageFrameValue) value.get(0);
		}
		return null;
	}

	public IBceBatInputFieldFormatValue[] getImportFieldValues(long configId)
			throws Exception {
		// TODO Auto-generated method stub
		Map cache = (Map) getCache("getImportFieldValues");
		List value = (List) cache.get(String.valueOf(configId));
		return value == null ? new BceBatInputFieldFormatBean[0]
				: (IBceBatInputFieldFormatValue[]) value
						.toArray(new BceBatInputFieldFormatBean[0]);
	}

	public IBceBatInputFormatValue getImportFileConfig(long productSpecId,
			long productRoleId, long businessId) throws Exception {
		// TODO Auto-generated method stub
		IBceBatInputFormatValue ret = null;
		Map BePageFrameMap = (Map) getCache("getImportFileConfig");
		List value = ((List) BePageFrameMap.get(String.valueOf(businessId)));
		List value1 = ((List) BePageFrameMap.get(String.valueOf(-1)));
		if (value != null)
			value.addAll(value1);
		else
			value = value1;
		if (value == null)
			return null;
		List values = new LinkedList();
		for (Iterator iterator = value.iterator(); iterator.hasNext();) {
			IBceBatInputFormatValue bceWorkflowValue = (IBceBatInputFormatValue) iterator
					.next();
			if ((bceWorkflowValue.getProdSpecId() == productSpecId || bceWorkflowValue
					.getProdSpecId() == -10000)
					&& (bceWorkflowValue.getRoleId() == productRoleId || bceWorkflowValue
							.getRoleId() == -10000))
				values.add(bceWorkflowValue);
		}
		if (values != null && values.size() > 0) {
			// 判断具体传入的参数，如果有具体参数的，则返回符合具体参数最多的那条数据。
			int maxFitNo = -1;
			int maxFitRowNo = 0;
			for (int i = 0; i < values.size(); i++) {
				int tmpFitNo = 0;
				IBceBatInputFormatValue object = (IBceBatInputFormatValue) values
						.get(i);
				if (object.getBusinessId() == businessId) {
					tmpFitNo++;
				}
				if (object.getRoleId() == productRoleId) {
					tmpFitNo++;
				}

				if (tmpFitNo > maxFitNo) {
					maxFitNo = tmpFitNo;
					maxFitRowNo = i;
				}
			}
			ret = (IBceBatInputFormatValue) values.get(maxFitRowNo);
		} else {
			// "未找到产品规格["+aProductSpecId+"]、角色["+aProductRoleId+"]、业务操作为["+aBusinessId+"]的成员导入的配置数据。"
			Object[] pParams = new String[] { Long.toString(productSpecId),
					Long.toString(productRoleId), Long.toString(businessId) };
			throw new BceException("BES0000008", pParams);
		}
		return ret;
	}

	public IQPageFramePageValue[] getPageFramePages(long bceFrameId,
			long pageFrameId) throws Exception {

		// 首先查询受理框架的特殊页面。
		Map cmmap = (Map) getCache("BceFrameSpecialPage");
		List list_s = (List) cmmap.get(String.valueOf(bceFrameId));
		HashMap pageMap = new HashMap();
		if (list_s != null && list_s.size() > 0) {
			IBceFrameSpecialPageValue[] BceFrameSpecPages = (IBceFrameSpecialPageValue[]) (list_s)
					.toArray(new IBceFrameSpecialPageValue[0]);
			for (int i = 0; i < BceFrameSpecPages.length; i++) {
				pageMap.put(
						new Long(BceFrameSpecPages[i].getPageFramePageId()),
						BceFrameSpecPages[i]);
			}
		}
		// 查询受理框架的页面，如果页面信息在受理框架的特殊页面已存在，则以特殊页面的配置信息覆盖之。
		Map cmma1p = (Map) getCache("QPageFramePage");
		List keyList = (List) cmma1p.get(String.valueOf(pageFrameId));
		List key2List = new LinkedList();
		for (int i = 0; i < keyList.size(); i++) {
			IQPageFramePageValue iqPageFramePageValue = (IQPageFramePageValue) keyList
					.get(i);
			if (iqPageFramePageValue.getPageLoadType() != 1
					&& iqPageFramePageValue.getPageLoadType() != 2)
				continue;
			key2List.add(iqPageFramePageValue);
		}
		IQPageFramePageValue[] pageFamePages = (IQPageFramePageValue[]) key2List
				.toArray(new QPageFramePageBean[0]);
		if (pageFamePages != null && pageFamePages.length > 0) {
			IQPageFramePageValue[] returnValues = new IQPageFramePageValue[pageFamePages.length];
			for (int i = 0; i < pageFamePages.length; i++) {
				returnValues[i] = new QPageFramePageBean();
				returnValues[i].copy(pageFamePages[i]);
				long pageFramePageId = returnValues[i].getPageFramePageId();
				IBceFrameSpecialPageValue specPage = (IBceFrameSpecialPageValue) pageMap
						.get(new Long(pageFramePageId));
				if (specPage != null) {
					if (StringUtils.isNotBlank(specPage.getPageParam())) {
						String tmp = returnValues[i].getPageUrl();
						if (tmp.indexOf("?") > 0) {
							tmp += "&" + specPage.getPageParam();
						} else {
							tmp += "?" + specPage.getPageParam();
						}
						returnValues[i].setPageUrl(tmp);
					}
					if (specPage.getIsDataMust() != -1)
						returnValues[i].setIsDataMust(specPage.getIsDataMust());
					if (specPage.getIsGetPageData() != -1)
						returnValues[i].setIsGetPageData(specPage
								.getIsGetPageData());
					if (specPage.getPageRulesetId() != -1)
						returnValues[i].setPageRulesetId(specPage
								.getPageRulesetId());
					if (StringUtils.isNotBlank(specPage.getPageTitle()))
						returnValues[i].setPageTitle(specPage.getPageTitle());
				}
			}
			return returnValues;
		}
		return pageFamePages;
	}

	public IBceRowsetValue[] getPageRowsets(long pageFramePageId)
			throws Exception {
		// TODO 稍等处理
		Map cmmapRel = (Map) getCache("BcePageRowsetRel");
		List relList = (List) cmmapRel.get(String.valueOf(pageFramePageId));
		if (relList == null)
			return new IBceRowsetValue[0];
		List RowsetList = new LinkedList();
		Map bceRowsets = (Map) getCache("getBceRowseT");
		for (Iterator iterator = relList.iterator(); iterator.hasNext();) {
			IBcePageRowsetRelValue name = (IBcePageRowsetRelValue) iterator
					.next();
			List ls = (List) bceRowsets.get(String.valueOf(name.getRowsetId()));
			if (ls != null && ls.size() > 0) {
				RowsetList.add(ls.get(0));
			}

		}
		return (IBceRowsetValue[]) RowsetList.toArray(new BceRowsetBean[0]);
	}

	/*
	 * public IQBceBusinessAttrValue getQBceBusinessAttr(long attrId) throws
	 * Exception { // TODO Auto-generated method stub // 此方法废弃 Map cmmap = (Map)
	 * getCache("getQBceBusinessAttr1"); List value = ((List) cmmap.get(new
	 * Long(attrId))); if (value != null && value.size() >= 1) { return
	 * (IQBceBusinessAttrValue) value.get(0); } return null; }
	 */

	public IQBceBusinessAttrValue[] getQBceBusinessAttrs(long bceFrameId,
			String formId) throws Exception {
		// TODO Auto-generated method stub
		Map cmmap = (Map) getCache("getQBceBusinessAttr");
		List cmList = (List) cmmap.get(String.valueOf(bceFrameId));
		if (cmList == null)
			return new IQBceBusinessAttrValue[0];
		List formAttr = new LinkedList();
		for (Iterator iterator = cmList.iterator(); iterator.hasNext();) {
			IQBceBusinessAttrValue attrValue = (IQBceBusinessAttrValue) iterator
					.next();
			if (formId.equals(attrValue.getFormId())
					&& (StringUtils.isBlank(attrValue.getRegionId()) || (StringUtils
							.equals(attrValue.getRegionId(),
									BceSVUtil.getStaticRegionId()))))
				formAttr.add(attrValue);
		}
		return (IQBceBusinessAttrValue[]) formAttr
				.toArray(new QBceBusinessAttrBean[0]);
		// return
		// ((IBceFrameSV)ServiceFactory.getService(IBceFrameSV.class)).getQBceBusinessAttrs(bceFrameId,
		// formId);
	}

	public IQBceBusinessAttrValue[] getQBceBusinessAttrsByBusinessId(
			long businessId, Map paramMap, String formId) throws Exception,
			RemoteException {
		IBceFrameValue bceFrameValue = this.getBceFrameValue(businessId,
				paramMap);
		return this.getQBceBusinessAttrs(bceFrameValue.getBceFrameId(), formId);
	}

	public IQBceBusinessButtonValue[] getQBceBusinessButton(long bceFrameId,
			String areaId) throws Exception {
		// TODO Auto-generated method stub
		Map cmmap = (Map) getCache("getQBceBusinessButton");
		List list = (List) cmmap.get(String.valueOf(bceFrameId));
		if (list == null)
			return new IQBceBusinessButtonValue[0];
		List AreaAttr = new LinkedList();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			IQBceBusinessButtonValue buttonValue = (IQBceBusinessButtonValue) iterator
					.next();
			if (areaId.equals(buttonValue.getAreaId()))
				AreaAttr.add(buttonValue);
		}
		return (IQBceBusinessButtonValue[]) AreaAttr
				.toArray(new QBceBusinessButtonBean[0]);
	}

	public IBceFrameJavaRulesetRelValue[] getRegistedRuleSet(long bceFrameId,
			long ruleType, Map paramMap) throws Exception {
		// TODO Auto-generated method stub
		Map cmmap = (Map) getCache("getRegistedRuleSet");
		List ruleList = (List) cmmap.get(String.valueOf(bceFrameId));
		if (ruleList == null)
			return new IBceFrameJavaRulesetRelValue[0];
		List _ruleList = new LinkedList();
		for (Iterator iterator = ruleList.iterator(); iterator.hasNext();) {
			IBceFrameJavaRulesetRelValue relValue = (IBceFrameJavaRulesetRelValue) iterator
					.next();
			if (relValue.getRulesetType() == ruleType)
				_ruleList.add(relValue);
		}
		IBceFrameJavaRulesetRelValue[] values = (IBceFrameJavaRulesetRelValue[]) _ruleList
				.toArray(new IBceFrameJavaRulesetRelValue[0]);
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

	public IQBceRulesetRuleValue[] getRulesByRulesetId(long pageRulesetId)
			throws Exception {
		// TODO Auto-generated method stub
		Map BePageFrameMap = (Map) getCache("getRulesByRulesetId");
		List value = ((List) BePageFrameMap.get(String.valueOf(pageRulesetId)));

		return value == null ? new QBceRulesetRuleBean[0]
				: (IQBceRulesetRuleValue[]) value
						.toArray(new QBceRulesetRuleBean[0]);
	}

	public IBceSimpleFuncValue[] getSFunc(long beFrameId) throws Exception {
		// TODO Auto-generated method stub
		Map BePageFrameMap = (Map) getCache("getSFunc");
		List value = ((List) BePageFrameMap.get(String.valueOf(beFrameId)));
		IBceSimpleFuncValue[] values = (BceSimpleFuncBean[]) (value != null ? (BceSimpleFuncBean[]) value
				.toArray(new BceSimpleFuncBean[0]) : new BceSimpleFuncBean[0]);
		return values;
	}

	public IBceSimpleFuncFieldMappingValue[] getSFuncFieldMapping(long funcId)
			throws Exception {
		// TODO Auto-generated method stub
		Map BePageFrameMap = (Map) getCache("getSFuncFieldMapping");
		List value = ((List) BePageFrameMap.get(String.valueOf(funcId)));
		return value == null ? new IBceSimpleFuncFieldMappingValue[0]
				: (IBceSimpleFuncFieldMappingValue[]) value
						.toArray(new IBceSimpleFuncFieldMappingValue[0]);
	}

	public IQBceBusinessAttrValue getQBceBusinessAttr(long attrId,
			long bceframeId) throws Exception {
		// TODO Auto-generated method stub
		Map cmmap = (Map) getCache("getQBceBusinessAttr");
		List cmList = (List) cmmap.get(String.valueOf(bceframeId));
		if (cmList == null)
			return null;
		for (Iterator iterator = cmList.iterator(); iterator.hasNext();) {
			IQBceBusinessAttrValue bcAttrValue = (IQBceBusinessAttrValue) iterator
					.next();
			if (bcAttrValue.getAttrId() == attrId
					&& (StringUtils.isBlank(bcAttrValue.getRegionId()) || (StringUtils
							.equals(bcAttrValue.getRegionId(),
									BceSVUtil.getStaticRegionId()))))
				return bcAttrValue;
		}
		return null;
	}

	public IQBceBusinessAttrValue getQBceBusinessAttr(long attrId)
			throws Exception {
		// TODO Auto-generated method stub
		Map getBceAttr = (Map) getCache("getBceAttr");
		List list = (List) getBceAttr.get(String.valueOf(attrId));
		IQBceBusinessAttrValue qAttrValue = new QBceBusinessAttrBean();
		if (list != null && list.size() > 0) {
			IBceAttrValue bceAttrValue = (IBceAttrValue) list.get(0);
			qAttrValue.copy(bceAttrValue);
		}
		return qAttrValue;
	}

	public BceTabBean getQBusiTabArea(long bceFrameId, String formId)
			throws Exception {
		// TODO Auto-generated method stub
		Map cmMap = (Map) getCache("IBceFrameAreaPagetabValue");
		List ails = (List) cmMap.get(String.valueOf(bceFrameId));
		IBceFrameAreaPagetabValue areaPagetabValue = null;
		if (ails == null || ails.size() < 1)
			throw new BceException("BES0000788");
		for (Iterator iterator = ails.iterator(); iterator.hasNext();) {
			IBceFrameAreaPagetabValue tabValue = (IBceFrameAreaPagetabValue) iterator
					.next();
			if (formId.equals(tabValue.getAreaId())) {
				areaPagetabValue = tabValue;
			}
		}
		BceTabBean tabBean = new BceTabBean();
		tabBean.setAreaPagetabValue(areaPagetabValue);
		Map cmsMap = (Map) getCache("IBceFrameTabitemValue");
		List items = (List) cmsMap.get(String.valueOf(areaPagetabValue
				.getTabId()));
		if (items == null || items.size() < 1)
			throw new BceException("BES0000789");
		tabBean.setTabitemValues((IBceFrameTabitemValue[]) items
				.toArray(new BceFrameTabitemBean[0]));
		return tabBean;
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
		Map comMap = (Map) getCache("getTemplateValueByframeId");
		List li = (List) comMap.get(String.valueOf(bceFrameValue
				.getPrintTemplateId()));
		return (IBceQrTemplateValue) (li == null ? null : li.get(0));
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
	 * com.ai.bce.service.interfaces.IBceFrameSV#getQrTempAttrs(java.lang.String
	 * , long, boolean)
	 */
	public IBceQrAttrValue[] getQrTempAttrs(long attrId, String key,
			long templateId, boolean b) throws Exception, RemoteException {
		// TODO Auto-generated method stub
		Map comMap = (Map) getCache("getQrTempAttrs");
		List li = (List) comMap.get(String.valueOf(templateId));
		if (key == null && b) {
			return (IBceQrAttrValue[]) (li != null ? li
					.toArray(new IBceQrAttrValue[0]) : new IBceQrAttrValue[0]);
		}
		List getList = new LinkedList();
		for (Iterator iterator = li.iterator(); iterator.hasNext();) {
			IBceQrAttrValue object = (IBceQrAttrValue) iterator.next();

			if (key != null && b) {
				if (key.equals(object.getAttrName())) {
					getList.add(object);
					break;
				}
			} else {
				if (attrId == object.getPreAttrId())
					getList.add(object);
			}
		}
		return (IBceQrAttrValue[]) (getList != null ? getList
				.toArray(new IBceQrAttrValue[0]) : new IBceQrAttrValue[0]);
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
	 * @see com.ai.bce.service.interfaces.IBceFrameSV#getWarnContent(long,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	public IBceWarnValue getWarnContent(long bceFrameId, String businessId,
			String changeName, String changeValue, int warnType)
			throws Exception {
		// TODO Auto-generated method stub
		Map comMap = (Map) getCache("getWarnContent");
		List kwarnRelat = (List) comMap.get(String.valueOf(bceFrameId));
		long warnId = 0;
		if (kwarnRelat == null)
			return null;
		Map keyMap = (Map) getCache("IBceWarnValue");
		for (Iterator iterator = kwarnRelat.iterator(); iterator.hasNext();) {
			IBceWarnRelateValue relateValue = (IBceWarnRelateValue) iterator
					.next();
			if (!((StringUtils.isNotBlank(businessId) && StringUtils.equals(
					businessId, relateValue.getBusinessId())) || (StringUtils
					.isBlank(businessId) && StringUtils.equals("-1",
					relateValue.getBusinessId()))))
				continue;
			if (!((StringUtils.isNotBlank(changeName) && StringUtils.equals(
					changeName, relateValue.getChangeName())) || (StringUtils
					.isBlank(changeName) && StringUtils.equals("-1",
					relateValue.getChangeName()))))
				continue;
			if (!((StringUtils.isNotBlank(changeValue) && StringUtils.equals(
					changeValue, relateValue.getChangeNewValue())) || (StringUtils
					.isBlank(changeValue) && StringUtils.equals("-1",
					relateValue.getChangeNewValue()))))
				continue;
			if (StringUtils.isNotBlank(relateValue.getRegionId())
					&& !StringUtils.equals(relateValue.getRegionId(),
							BceSVUtil.getStaticRegionId()))
				continue;
			warnId = relateValue.getWarnId();
			List keyList = (List) keyMap.get(String.valueOf(warnId));
			if (keyList != null && keyList.size() > 0) {
				IBceWarnValue bceWarnValue = (IBceWarnValue) keyList.get(0);
				if (bceWarnValue.getWarnType() == warnType) {
					return bceWarnValue;
				}
			}
		}

		return null;
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
	 * @see com.ai.bce.service.interfaces.IBceFrameSV#getOrderObjectType(long,
	 * long)
	 */
	public String getOrderObjectType(long businessId, long bceFrameId)
			throws Exception, RemoteException {
		// TODO Auto-generated method stub
		IBceFrameValue bceFrameValue;
		if (bceFrameId <= 0)
			bceFrameValue = this.getBceFrameValue(businessId, null);
		else
			bceFrameValue = this.getBceFrameValue(bceFrameId);
		IBOBsParaDetailValue paraDetailValue = BceUtil.getParaDetailValue("X",
				"BCE_SRC_OBJECT_TYPE", String.valueOf(bceFrameValue
						.getSrcSystemType() == 0 ? 1 : bceFrameValue
						.getSrcSystemType()));
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
		// 首先查询受理框架的特殊页面。
		IBceFrameValue frameValue = this.getBceFrameValue(pBceFrameId);
		Map cmmap = (Map) getCache("BceFrameSpecialPage");
		List list_s = (List) cmmap.get(String.valueOf(pBceFrameId));

		IBceFrameSpecialPageValue[] BceFrameSpecPages = list_s == null ? new IBceFrameSpecialPageValue[0]
				: (IBceFrameSpecialPageValue[]) (list_s)
						.toArray(new IBceFrameSpecialPageValue[0]);
		HashMap pageMap = new HashMap();
		if (BceFrameSpecPages != null && BceFrameSpecPages.length > 0) {
			for (int i = 0; i < BceFrameSpecPages.length; i++) {
				pageMap.put(
						new Long(BceFrameSpecPages[i].getPageFramePageId()),
						BceFrameSpecPages[i]);
			}
		}
		// 查询受理框架的页面，如果页面信息在受理框架的特殊页面已存在，则以特殊页面的配置信息覆盖之。
		Map cmma1p = (Map) getCache("QPageFramePage");
		List keyList = (List) cmma1p.get(String.valueOf(frameValue
				.getPageFrameId()));
		IQPageFramePageValue[] pageFamePages = (IQPageFramePageValue[]) keyList
				.toArray(new IQPageFramePageValue[0]);
		IQPageFramePageValue pageValue = null;
		for (int i = 0; i < pageFamePages.length; i++) {
			IQPageFramePageValue iqPageFramePageValue = pageFamePages[i];
			if (iqPageFramePageValue.getPageId() == pPageId
					&& iqPageFramePageValue.getPageLoadType() == 3) {
				pageValue = new QPageFramePageBean();
				pageValue.copy(iqPageFramePageValue);
			}
		}
		if (pageValue != null) {
			long pageFramePageId = pageValue.getPageFramePageId();
			IBceFrameSpecialPageValue specPage = (IBceFrameSpecialPageValue) pageMap
					.get(new Long(pageFramePageId));
			if (specPage != null) {
				if (StringUtils.isNotBlank(specPage.getPageParam())) {
					String tmp = pageValue.getPageUrl();
					if (tmp.indexOf("?") > 0) {
						tmp += "&" + specPage.getPageParam();
					} else {
						tmp += "?" + specPage.getPageParam();
					}
					pageValue.setPageUrl(tmp);
				}
				if (specPage.getIsDataMust() != -1)
					pageValue.setIsDataMust(specPage.getIsDataMust());
				if (specPage.getIsGetPageData() != -1)
					pageValue.setIsGetPageData(specPage.getIsGetPageData());
				if (specPage.getPageRulesetId() != -1)
					pageValue.setPageRulesetId(specPage.getPageRulesetId());
				if (StringUtils.isNotBlank(specPage.getPageTitle()))
					pageValue.setPageTitle(specPage.getPageTitle());
			}
		}

		return pageValue;
	}

	public long getCoustomOrderId(String dealService) throws Exception,
			RemoteException {
		// TODO Auto-generated method stub
		IBceFrameSV object = (IBceFrameSV) ReflectUtils.constructorNewInstance(
				IBceFrameSV.class.getName(), new Class[] {}, new Object[] {});

		return object.getCoustomOrderId(dealService);
	}

	public IBceDealReturnData dealService(long beFrameId, IBceData bceData,
			boolean isCONFIRM, String orderCode) throws Exception,
			RemoteException {
		// TODO Auto-generated method stub
		IBceFrameSV object = (IBceFrameSV) ReflectUtils.constructorNewInstance(
				IBceFrameSV.class.getName(), new Class[] {}, new Object[] {});
		return object.dealService(beFrameId, bceData, isCONFIRM, orderCode);
	}

	public String getCoustomOrderCode(String dealService) throws Exception,
			RemoteException {
		// TODO Auto-generated method stub
		IBceFrameSV object = (IBceFrameSV) ReflectUtils.constructorNewInstance(
				IBceFrameSV.class.getName(), new Class[] {}, new Object[] {});
		return object.getCoustomOrderCode(dealService);
	}

	public IBceQrTemplateValue getTemplateValueByTmmplateId(long templateId)
			throws Exception, RemoteException {
		// TODO Auto-generated method stub
		Map comMap = (Map) getCache("getTemplateValueByframeId");
		List li = (List) comMap.get(String.valueOf(templateId));
		return (IBceQrTemplateValue) (li == null ? null : li.get(0));
	}

	
	public IBceFrameValue[] getBceFrameValueByBusinessId(String businessId)
			throws Exception {
		// TODO Auto-generated method stub
		Map cmmap = (Map) getCache("getBceFrameValueByBusiness");
		List li = (List) cmmap.get(String.valueOf(businessId));
		return (IBceFrameValue[]) li.toArray(new IBceFrameValue[0]);
	}

}
