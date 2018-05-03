package com.ai.bce.auto.plugin.cache.service.impl;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.bce.auto.plugin.cache.bean.CacheKeyBean;
import com.ai.bce.auto.plugin.cache.bean.CacheValueBean;
import com.ai.bce.auto.plugin.cache.dao.interfaces.IBceCacheUseDAO;
import com.ai.bce.auto.plugin.cache.service.interfaces.IBceCacheUseSV;

public class BceCacheUseSVImpl implements IBceCacheUseSV {

	public Map getObject( CacheKeyBean cacheKeyBean,
			CacheValueBean enginName) throws Exception ,RemoteException{
		// TODO Auto-generated method stub
		Map map = new HashMap() ;
		return ((IBceCacheUseDAO) ServiceFactory.getService(IBceCacheUseDAO.class))
		.getObject(map, cacheKeyBean, enginName);
	}

}
