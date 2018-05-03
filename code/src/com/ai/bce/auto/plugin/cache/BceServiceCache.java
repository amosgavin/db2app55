package com.ai.bce.auto.plugin.cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.complex.cache.impl.AbstractCache;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.bce.auto.plugin.cache.bean.CacheBean;
import com.ai.bce.auto.plugin.cache.bean.CacheKeyBean;
import com.ai.bce.auto.plugin.cache.bean.CacheValueBean;
import com.ai.bce.auto.plugin.cache.service.interfaces.IBceCacheUseSV;
import com.ai.bce.auto.plugin.cache.util.StaticData;
import com.ai.bce.util.BceConfigServer;
import com.ai.bce.util.LocaleResourceFactory;

/**
 * 
 * BceRule规则Cache
 * <p>
 * Copyright (c) 2010 Asiainfo-Linkage
 * </p>
 * 
 * @ClassName: BceRuleCache.java
 * @Description: 该类的功能描述
 * 
 * @version: v1.0.0
 * @author: Qinjin Peng
 * @date: Feb 11, 2011 2:59:31 PM
 */
public class BceServiceCache extends AbstractCache {
	
	public static transient final Log log = LogFactory
			.getLog(BceServiceCache.class);


	public HashMap getData() throws Exception {
		// TODO Auto-generated method stub
		HashMap serviceMap = new HashMap();
		loadCache(serviceMap);
		return serviceMap;
	}

	private void loadCache(HashMap serviceMap) throws Exception {
		// TODO Auto-generated method stub
		
		List _allCache = (List) BceConfigServer
				.getRegisterConfig("STATIC_CACHE");
		if (_allCache == null) {
			log.error(LocaleResourceFactory.getResource("BES0000791"));
			return;
		}
		log.info(LocaleResourceFactory.getResource("BES0000792"));
		/**
		 * 详细Load
		 */
		for (Iterator iterator = _allCache.iterator(); iterator.hasNext();) {
			CacheBean cacheBean = (CacheBean) iterator.next();
			Map cache = getCache(cacheBean);
			serviceMap.put(cacheBean.getCode(), cache);
		}
		log.info(LocaleResourceFactory.getResource("BES0000793"));
	}

	private Map getCache(CacheBean cacheBean) throws Exception {

		Map cache = new HashMap();
		if (StaticData.TYPE_METHOD.equals(cacheBean.getType())) {
			CacheValueBean cacheValueBean = cacheBean.getCacheValue();
			CacheKeyBean cacheKeyBean = cacheBean.getCacheKey();
			if ("MAP".equals(cacheValueBean.getType())) {
				for (Iterator iterator = cacheValueBean.getCaches().iterator(); iterator
						.hasNext();) {
					CacheBean caBean = (CacheBean) iterator.next();
					cache.put(caBean.getCode(), getCache(caBean));
				}
			} else {
				cache = loadNomalCache(cache, cacheValueBean, cacheKeyBean);
			}
		} else if (StaticData.TYPE_STATIC.equals(cacheBean.getType())) {
			Set set = cacheBean.getStaticCache().entrySet();
			Iterator ieI = set.iterator();
			while (ieI.hasNext()) {
				Entry type = (Entry) ieI.next();
				cache.put(type.getKey(), getCache((CacheBean) type.getValue()));
			}
		} else {
			cache = loadNomalCache(cache, cacheBean.getCacheValue(), cacheBean
					.getCacheKey());
		}
		return cache;
	}

	private Map loadNomalCache(Map cache, CacheValueBean cacheValueBean,
			CacheKeyBean cacheKeyBean) throws Exception {
		if ("MAP".equals(cacheValueBean.getType())) {
			List cas = cacheValueBean.getCaches();
			for (Iterator iterator = cas.iterator(); iterator.hasNext();) {
				CacheBean caBean = (CacheBean) iterator.next();
				cache.put(cacheKeyBean.getValue(), getCache(caBean));
			}
			return  cache;
		}
		cache  = ((IBceCacheUseSV) ServiceFactory.getService(IBceCacheUseSV.class))
				.getObject( cacheKeyBean, cacheValueBean);
		return cache ;
	}

}
