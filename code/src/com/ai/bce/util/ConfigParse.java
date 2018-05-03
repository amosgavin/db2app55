package com.ai.bce.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

import com.ai.bce.util.bean.BceConfigItemBean;
import com.ai.bce.util.bean.PluginBean;
import com.ai.bce.util.define.AbstraParse;

public class ConfigParse extends AbstraParse {

	public Object parseXml(String fileName) throws Exception {
		Map canMap = new HashMap();
		Element rootElement = getRootElement(fileName);
		List plugins = loadPlugin(rootElement);
		Map configItems  = loadItem(rootElement);
		canMap.put("plugin", plugins);
		canMap.put("BCE_CONF_ITEM", configItems);
		return canMap;
	}

	private Map loadItem(Element rootElement) {
		Element items = rootElement.element("items");
		Map cmap = new HashMap();
		if(items== null)return cmap;
		List  itemList  = items.elements("bceItem");
		for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
			Element element= (Element) iterator.next();
			String type  = element.attributeValue("type");
			String key  = element.attributeValue("key");
			String value = element.getText();
			BceConfigItemBean item = new BceConfigItemBean();
			item.setItemKey(key);
			item.setItemKind(type);
			item.setItemValue(value);
			cmap.put(type+key, item);
		}
		return cmap;
	}

	private List loadPlugin(Element rootElement) {
		List pluginList = rootElement.elements("plugin");
		List plugins = new LinkedList();
		for (Iterator iterator = pluginList.iterator(); iterator.hasNext();) {
			PluginBean pluginBean = new PluginBean();
			Element pluginElement = (Element) iterator.next();
			String name = pluginElement.attributeValue("name");
			pluginBean.setName(name);
			String type = pluginElement.attributeValue("type");
			pluginBean.setType(type);
			String isLoadFile_S = pluginElement.attributeValue("isLoadFile");
			String isUse_S = pluginElement.attributeValue("isUse");
			Boolean isLoadFile = Boolean.valueOf(isLoadFile_S);
			String isLocal_s = pluginElement.attributeValue("isUseLocal");
			Boolean isLocal = Boolean.valueOf(isLocal_s);
			pluginBean.setLoadFile(isLoadFile.booleanValue());
			Boolean isUse = Boolean.valueOf(isUse_S);
			pluginBean.setUse(isUse.booleanValue());
			pluginBean.setUseLocal(isLocal.booleanValue());
			if (isLoadFile.booleanValue()) {
				Element filElement = pluginElement.element("file");
				String filename = filElement.attributeValue("name");
				pluginBean.setFileName(filename);
				String staticName = filElement.attributeValue("staticName");
				pluginBean.setStaticName(staticName);
				Element classElement = pluginElement.element("clazz");
				String className = classElement.attributeValue("name");
				pluginBean.setClassName(className);
			}

			String isUseMap_s = pluginElement.attributeValue("isUseMap");
			Boolean isUseMap = Boolean.valueOf(isUseMap_s);
			// 是否使用对象替换
			if (isUseMap.booleanValue()) {
				// 加载"KEY"
				Element useServiceMap = pluginElement.element("useServiceMap");
				List eleList = useServiceMap.elements("service");
				Map serviceMap = new HashMap();
				for (Iterator iterator2 = eleList.iterator(); iterator2
						.hasNext();) {
					Element service = (Element) iterator2.next();
					String value = service.attributeValue("value");
					String mapValue = service.attributeValue("mapValue");
					serviceMap.put(value, mapValue);
				}
				pluginBean.setServiceMap(serviceMap);
			}
			pluginBean.setUseServiceMap(isUseMap.booleanValue());
			String isProxy_s = pluginElement.attributeValue("isUseProxy");
			Boolean isProxy = Boolean.valueOf(isProxy_s);
			// 代理
			if (isProxy.booleanValue()) {
				// 加载"KEY"
				Element proxy = pluginElement.element("proxy");
				String proxyClass = proxy.attributeValue("class");
				pluginBean.setProxyClass(proxyClass);
			}
			pluginBean.setProxy(isProxy.booleanValue());
			plugins.add(pluginBean);
		}
		return plugins;
	}

}
