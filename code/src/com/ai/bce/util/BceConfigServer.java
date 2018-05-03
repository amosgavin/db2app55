package com.ai.bce.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ai.bce.util.bean.PluginBean;
import com.ai.bce.util.define.AbstraParse;

/**
 * 
 * 配置文件服务产品server
 * 
 * <p>
 * Copyright (c) 2010 Asiainfo-Linkage
 * </p>
 * 
 * @ClassName: BceConfigServer.java
 * @Description: 该类的功能描述
 * 
 * @version: v1.0.0
 * @author: Qinjin Peng
 * @date: Feb 13, 2011 2:37:33 PM
 */
public class BceConfigServer {
	public static Map configMap = new HashMap();
	public static boolean isLoad = false;
	public static final String KEY_ROOT = "USE_ZHU";
	public static final String KEY_CACHE = "Bce_Cache";
	public static final String KEY_LOG = "Bce_Filter_Log";
	

	/**
	 * 注册配置文件
	 * 
	 * @Title:
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param
	 * @param key
	 * @param
	 * @param configValue
	 *            设定文件
	 * @return 返回类型
	 * @throws
	 */
	public static void registerConfig(String key, Object configValue) {
		configMap.put(key, configValue);
	}

	/**
	 * 获取配置文件信息
	 * 
	 * @Title:
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param
	 * @param key
	 * @param
	 * @return 设定文件
	 * @return 返回类型
	 * @throws Exception
	 * @throws
	 */
	public static Object getRegisterConfig(String key) throws Exception {
		if (configMap.isEmpty()) {
			loadAllConfig();
		}
		/**
		 * 
		 * 
		 */
		Object value = configMap.get(key);
		if (value == null) {
			return null;
		}
		return value;
	}

	/**
	 * 加载配置文件
	 * 
	 * @Title:
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param 设定文件
	 * @return 返回类型
	 * @throws Exception
	 * @throws
	 */
	public static void loadAllConfig() throws Exception {
		synchronized (configMap) {
			if (isLoad)
				return;
			ConfigParse configParse = new ConfigParse();
			Map map = (Map) configParse.parseXml("bceConfig.xml");
			List plugins = (List) map.get("plugin");
			configMap.put(KEY_ROOT, map);
			for (Iterator iterator = plugins.iterator(); iterator.hasNext();) {
				PluginBean pBean = (PluginBean) iterator.next();
				if (!pBean.isUse())
					continue;
				AbstraParse parseInterface = (AbstraParse) ReflectUtils
						.constructorNewInstance(pBean.getClassName(), null,
								null);
				if (!pBean.isLoadFile())
					continue;
				Object object = parseInterface.parseXml(pBean.getFileName());
				configMap.put(pBean.getStaticName(), object);
			}
			isLoad = true;
		}
	}
	
	public static boolean isPlugUsed(String plugName)throws Exception{
		Map map = (Map) BceConfigServer.getRegisterConfig(KEY_ROOT);
		List plugins = (List) map.get("plugin");
		for (Iterator iterator = plugins.iterator(); iterator.hasNext();) {
			PluginBean pluginBean = (PluginBean) iterator.next();
			if (plugName.equalsIgnoreCase(pluginBean.getName()) && pluginBean.isUse())
				return true;
		}
		return false;
	}
	
	 public static void main(String[] args) throws Exception {
		 System.out.println(isPlugUsed(KEY_LOG));
	}
}
