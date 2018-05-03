package com.ai.bce.auto.plugin.cache.dao.interfaces;

import java.sql.SQLException;
import java.util.Map;

import com.ai.bce.auto.plugin.cache.bean.CacheKeyBean;
import com.ai.bce.auto.plugin.cache.bean.CacheValueBean;

public interface IBceCacheUseDAO {
	public Map getObject( Map cache,CacheKeyBean cacheKeyBean, CacheValueBean enginName) throws SQLException, Exception;
}
