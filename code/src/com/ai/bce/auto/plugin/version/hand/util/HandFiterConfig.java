package com.ai.bce.auto.plugin.version.hand.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.Element;

import com.ai.appframe2.util.XmlUtil;
import com.ai.bce.auto.plugin.version.hand.bean.FilterConfigBean;
import com.ai.bce.auto.plugin.version.hand.bean.HanldBean;
import com.ai.bce.util.BceException;
import com.ai.bce.util.define.AbstraParse;

public class HandFiterConfig extends AbstraParse {

	public Map versionMethodMap = new HashMap();

	public Object parseXml(String fileName) throws Exception {
		Element element = XmlUtil.parseXml(fileName);
		// ��ȡDAO����
		Iterator elIterator = element.elementIterator();
		while (elIterator.hasNext()) {
			Element daoElement = (Element) elIterator.next();
			if ("filter-config".equalsIgnoreCase(daoElement.getName())) {
				FilterConfigBean filterConfigBean = new FilterConfigBean();
				String formate = daoElement.element("formate-date")
						.attributeValue("value");
				filterConfigBean.setFormateDateType(formate);
				Element element_map = daoElement
						.element("filter-class-mapping");
				List maps = element_map.elements("class-mapping");
				Map hap = new HashMap();
				for (Iterator iterator = maps.iterator(); iterator.hasNext();) {
					Element class_map = (Element) iterator.next();
					String key = class_map.attributeValue("key");
					String value = class_map.attributeValue("value");
					hap.put(key, value);
				}
				filterConfigBean.setFilterClassMapping(hap);
				versionMethodMap.put("ID_KEY_Q_FILTER_LOG", filterConfigBean);
			}
			if ("dao".equalsIgnoreCase(daoElement.getName())) {
				Attribute id_attr = daoElement.attribute("id");
				if (id_attr == null)
			/*		throw new Exception("DAOʵ����û������ID����,DAOʵ��Ϊ:"
							+ daoElement.getName());*/
					throw new BceException("BES0000817",daoElement.getName());
				String daoId = id_attr.getValue();
				Map methodMap = new HashMap();
				Iterator eltIterator = daoElement.elementIterator();
				while (eltIterator.hasNext()) {
					Element methodEl = (Element) eltIterator.next();
					HanldBean hanldBean = getHanldBean(daoId, methodEl);
					methodMap.put(hanldBean.getMethodName(), hanldBean);
				}
				versionMethodMap.put(daoId, methodMap);
			}
			if ("include".equalsIgnoreCase(daoElement.getName())) {
				Attribute file_attr = daoElement.attribute("file");
				String file = file_attr.getValue();
				parseXml(file);
			}

		}

		return versionMethodMap;
	}

	private static HanldBean getHanldBean(String daoId, Element methodEl)
			throws Exception {
		Attribute name_attr = methodEl.attribute("name");
		if (name_attr == null)
//			throw new Exception("��ǰMethod ��û��������Ӧ�ķ�������DAO_ID Ϊ:" + daoId);
			throw new BceException("BES0000818",daoId);
		HanldBean hanldBean = new HanldBean();
		String methodName = name_attr.getValue();
		hanldBean.setMethodName(methodName);
		Iterator paramIterator = methodEl.elementIterator();
		String[] paramS = new String[1];
		while (paramIterator.hasNext()) {
			Element paramIter = (Element) paramIterator.next();
			Attribute param_attr = paramIter.attribute("sort");
			if (param_attr == null)
//				throw new Exception("�������Ϊ��.������������ز���.");
				throw new BceException("BES0000819");
			String paramSort = param_attr.getValue();
			int sort;
			if (StringUtils.isNumeric(paramSort)) {
				sort = Integer.valueOf(paramSort).intValue();
				if (sort >= paramS.length) {
					String[] paramStemp = paramS;
					paramS = new String[sort + 1];
					for (int i = 0; i < paramStemp.length; i++)
						paramS[i] = paramStemp[i];
					paramS[sort] = paramSort;
				} else {
					paramS[sort] = paramSort;
				}
			}
		}
		hanldBean.setParams(paramS);
		return hanldBean;
	}
}
