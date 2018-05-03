package com.ai.bce.auto.plugin.cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

import com.ai.bce.auto.plugin.cache.bean.CacheBean;
import com.ai.bce.auto.plugin.cache.bean.CacheKeyBean;
import com.ai.bce.auto.plugin.cache.bean.CacheValueBean;
import com.ai.bce.auto.plugin.cache.util.StaticData;
import com.ai.bce.util.define.AbstraParse;

/**
 * 
 * 解析Cache相关代码
 * <p>
 * Copyright (c) 2010 Asiainfo-Linkage
 * </p>
 * 
 * @ClassName: BceAutoCacheConfig.java
 * @Description: 该类的功能描述
 * 
 * @version: v1.0.0
 * @author: Qinjin Peng
 * @date: Feb 12, 2011 10:27:01 AM
 */

public class BceCacheConfigParse extends AbstraParse {

	public Object parseXml(String fileName) throws Exception {
		List _allCache = new LinkedList();
		Element element = getRootElement(fileName);
		List allCache = element.elements();
		for (Iterator iterator = allCache.iterator(); iterator.hasNext();) {
			Element cache = (Element) iterator.next();
			CacheBean cacheBean = loadCacheConfig(cache);
			_allCache.add(cacheBean);
		}
		return _allCache;
	}

	private CacheBean loadCacheConfig(Element cache) {
		CacheBean cacheBean = new CacheBean();
		// 根据方法设置的Cache
		String type = cache.attributeValue("type");
		String code = cache.attributeValue("code");
		cacheBean.setType(type);
		cacheBean.setCode(code);
		if (StaticData.TYPE_METHOD.equals(type)) {
			cacheBean = loadCache(cacheBean, cache);
		}
		if (StaticData.TYPE_STATIC.equals(type)) {
			cacheBean = loadCacheByStatic(cacheBean, cache);
		}
		return cacheBean;
	}

	private CacheBean loadCacheByStatic(CacheBean cacheBean, Element cache) {
		// TODO Auto-generated method stub
		Map staticCache = new HashMap();
		List propertyList = cache.elements("property");
		for (Iterator iterator = propertyList.iterator(); iterator.hasNext();) {
			Element propertyElement = (Element) iterator.next();
			CacheBean caBean = new CacheBean();
			caBean = loadCache(caBean, propertyElement);
			staticCache.put(caBean.getCacheKey().getValue(), caBean);
		}
		cacheBean.setStaticCache(staticCache);
		return cacheBean;
	}

	private CacheBean loadCache(CacheBean cacheBean, Element cache) {
		// TODO Auto-generated method stub
		CacheKeyBean keyBean = loadKey(cache);
		cacheBean.setCacheKey(keyBean);
		CacheValueBean cacheValue = loadValue(cache);
		cacheBean.setCacheValue(cacheValue);
		return cacheBean;
	}

	private CacheKeyBean loadKey(Element cache) {
		CacheKeyBean keyBean = new CacheKeyBean();
		Element keyElement = cache.element("key");
		String name = keyElement.attributeValue("name");
		keyBean.setName(name);
		String value = keyElement.attributeValue("value");
		keyBean.setValue(value);
		return keyBean;
	}

	private CacheValueBean loadValue(Element cache) {
		Element valueElement = cache.element("value");
		CacheValueBean cacheValue = new CacheValueBean();
		String type = valueElement.attributeValue("type");
		cacheValue.setType(type);
		if ("MAP".equals(type)) {
			List cacheE = valueElement.elements("cache");
			List cacheBeanes = new LinkedList();
			for (Iterator iterator = cacheE.iterator(); iterator.hasNext();) {
				Element object = (Element) iterator.next();
				CacheBean cacheBean2 = loadCacheConfig(object);
				cacheBeanes.add(cacheBean2);
			}
			cacheValue.setCaches(cacheBeanes);
		} else {
			String isUseSql = valueElement.attributeValue("isUseSql");
			String enginName = valueElement.attributeValue("enginName");
			String sqlWhere = valueElement.attributeValue("whereSql");
			cacheValue.setUseSql(Boolean.valueOf(isUseSql).booleanValue());
			cacheValue.setEnginName(enginName);
			cacheValue.setWhereSql(sqlWhere);
		}
		return cacheValue;
	}
	public static void main(String[] args) {
	}
}
