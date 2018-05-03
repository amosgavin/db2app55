package com.ai.bce.auto.plugin.cache.service.interfaces;

import java.rmi.RemoteException;
import java.util.Map;

import com.ai.bce.auto.plugin.cache.bean.CacheKeyBean;
import com.ai.bce.auto.plugin.cache.bean.CacheValueBean;

public interface IBceCacheUseSV {
	public Map getObject( CacheKeyBean cacheKeyBean,
			CacheValueBean enginName) throws Exception, RemoteException;
}
