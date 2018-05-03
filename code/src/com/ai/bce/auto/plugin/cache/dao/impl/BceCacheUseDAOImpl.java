package com.ai.bce.auto.plugin.cache.dao.impl;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.complex.datasource.CheckResultSet;
import com.ai.bce.auto.plugin.cache.bean.CacheKeyBean;
import com.ai.bce.auto.plugin.cache.bean.CacheValueBean;
import com.ai.bce.auto.plugin.cache.dao.interfaces.IBceCacheUseDAO;
import com.ai.bce.util.ReflectUtils;

public class BceCacheUseDAOImpl implements IBceCacheUseDAO {
	public static transient final Log log = LogFactory
			.getLog(BceCacheUseDAOImpl.class);

	public Map getObject(Map cache, CacheKeyBean cacheKeyBean,
			CacheValueBean enginName) throws Exception {
		// TODO Auto-generated method stub
		String sql = enginName.getWhereSql();
		if (!enginName.isUseSql()){
			useBean(cache, cacheKeyBean, enginName, sql);
		}
		else{
			useSql(cache, cacheKeyBean, enginName, sql);
		}
		return cache;
	}

	private void useSql(Map cache, CacheKeyBean cacheKeyBean,
			CacheValueBean enginName, String sql) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = ServiceManager.getSession().getConnection();
		ResultSet resultSet = null;
		PreparedStatement ptmt = null;
		
		try {
			ptmt = conn.prepareStatement(sql);
			
			//不做SQL条数限制检查
			CheckResultSet.ignoreCheckByConneciton(conn);
			
			ptmt.setFetchSize(1000);
			
			resultSet = ptmt.executeQuery();
			long size = 0;
			while (resultSet.next()) {
				DataContainer object = (DataContainer) ReflectUtils
						.constructorNewInstance(enginName.getEnginName(),
								new Class[] {}, new Object[] {});
				String[] properties = object.getPropertyNames();
				for (int i = 0; i < properties.length; i++) {
					String name = properties[i];
					Object value = resultSet.getObject(name);
					object.set(name, value);
				}
				
				Object key = ReflectUtils.methodInvoke(
						enginName.getEnginName(), cacheKeyBean.getValue(),
						null, null, object);
				
				//将Key转换成字符串
				key = String.valueOf(key);
				
				List objcets = (List) cache.get(key);
				if (objcets == null)
					objcets = new LinkedList();
				objcets.add(object);
				cache.put(key, objcets);
				
				size++;
			}
			if (log.isDebugEnabled()) {
				log.debug("BCE_CACHE:SQL Cache Size: " + size + " ("
						+ enginName.getEnginName() + ") ");
			}
		} finally {
			if (resultSet != null)
				resultSet.close();
			if (ptmt != null)
				ptmt.close();
			if (conn != null)
				conn.close();
		}
	}

	private void useBean(Map cache, CacheKeyBean cacheKeyBean,
			CacheValueBean enginName, String sql) throws Exception {
		if (StringUtils.isBlank(sql))
			sql = "";
		Map map = new HashMap();
		Object object = ReflectUtils.methodInvoke(enginName.getEnginName(),
				"getBeans", new Class[] { String.class, Map.class },
				new Object[] { sql, map }, null);
		if (object.getClass().isArray()) {
			int length = Array.getLength(object);
			if (log.isDebugEnabled()) {
				log.debug("BCE_CACHE: Engine (" + enginName.getEnginName()
						+ ") Cache Size: " + length);
			}
			
			for (int i = 0; i < length; i++) {
				Object obj = Array.get(object, i);
				Object key = ReflectUtils.methodInvoke(
						obj.getClass().getName(), cacheKeyBean.getValue(),
						null, null, obj);
				key = String.valueOf(key);
				List objcets = (List) cache.get(key);
				if (objcets == null)
					objcets = new LinkedList();
				objcets.add(obj);
				cache.put(key, objcets);
			}
			
		}
	}

}
