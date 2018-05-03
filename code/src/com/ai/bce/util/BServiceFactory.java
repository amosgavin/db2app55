package com.ai.bce.util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.bce.util.bean.PluginBean;

/**
 * 
 * 服务类生成工具(针对DAO层的)
 * <p>
 * 此功能只试用于DAO层（为保存日志变量使用）
 * </p>
 * <p>
 * Copyright (c) 2010
 * </p>
 * 
 * @ClassName: HandLogServiceFactory.java
 * @version: v1.0.0
 * @author: Qinjin Peng
 * @date: Dec 16, 2010 5:37:29 PM
 */
public class BServiceFactory {
	public static transient final Log log = LogFactory
			.getLog(BServiceFactory.class);

	/**
	 * 获取对象
	 * 
	 * @param className
	 * @return
	 * @version: v1.0.0
	 * @throws Exception
	 * 
	 */
	public static Object getService(String className) throws Exception {
		boolean isUseLocal = false;
		Map map = (Map) BceConfigServer
				.getRegisterConfig(BceConfigServer.KEY_ROOT);
		List plugins = (List) map.get("plugin");
		for (Iterator iterator = plugins.iterator(); iterator.hasNext();) {
			PluginBean pluginBean = (PluginBean) iterator.next();
			if (!pluginBean.isUse())
				continue;
			if (pluginBean.isUseServiceMap()) {
				String valueClass = (String) pluginBean.getServiceMap().get(
						className);
				if (StringUtils.isNotBlank(valueClass)) {
					className = valueClass;
					// 只有缓存的情况下，才会使用Local 否则不允许使用Local
					if (pluginBean.isUseLocal()) {
						isUseLocal = true;
					}
				}
			}
		}
		Object object = null;
		if (isUseLocal) {
			object = ServiceFactory.getSeviceOfLocal(className);
		} else {
			Object obj = BceCommonStore
					.getSomeThingFromThread(BceCommonStore.CROSS_SERVICE);
			if (obj != null && (((Boolean) obj).booleanValue())) {
				object = ServiceFactory.getCrossCenterService(className);
			} else {
				object = ServiceFactory.getService(className);
			}
			BceCommonStore.putSomeThingToThread(BceCommonStore.CROSS_SERVICE,
					null);
		}

		List lclazz = new LinkedList();
		for (Iterator iterator = plugins.iterator(); iterator.hasNext();) {
			PluginBean pluginBean = (PluginBean) iterator.next();
			if (!pluginBean.isUse())
				continue;
			if (pluginBean.isProxy()) {
				lclazz.add(pluginBean.getProxyClass());
			}
		}
		if (lclazz.size() < 1)
			return object;
		BceProxy hand = new BceProxy((Class[]) lclazz.toArray(new Class[0]));
		return hand.bindRelation(object);
	}

	/**
	 * 获取对象
	 * 
	 * @param clazz
	 * @return
	 * @version: v1.0.0
	 * @throws Exception
	 * 
	 */
	public static Object getService(Class clazz) throws Exception {
		boolean isUseLocal = false;
		Map map = (Map) BceConfigServer
				.getRegisterConfig(BceConfigServer.KEY_ROOT);
		List plugins = (List) map.get("plugin");
		for (Iterator iterator = plugins.iterator(); iterator.hasNext();) {
			PluginBean pluginBean = (PluginBean) iterator.next();
			if (!pluginBean.isUse())
				continue;
			if (pluginBean.isUseServiceMap()) {
				String valueClass = (String) pluginBean.getServiceMap().get(
						clazz.getName());
				if (StringUtils.isNotBlank(valueClass)) {
					clazz = ReflectUtils.forName(valueClass);
					// 只有缓存的情况下，才会使用Local 否则不允许使用Local
					if (pluginBean.isUseLocal()) {
						isUseLocal = true;
					}
				}
			}
		}

		Object object = null;
		if (isUseLocal) {
			if (log.isDebugEnabled()) {
				log.debug(LocaleResourceFactory.getResource("BES0000846",
						new String[] { clazz.getClass().getName() }));
			}
			object = ServiceFactory.getSeviceOfLocal(clazz);
		} else {
			if (log.isDebugEnabled()) {
				log.debug(LocaleResourceFactory.getResource("BES0000847",
						new String[] { clazz.getClass().getName() }));
			}
			object = ReflectUtils.constructorNewInstance(clazz.getName(),
					new Class[] {}, new Object[] {});
		}

		List lclazz = new LinkedList();
		for (Iterator iterator = plugins.iterator(); iterator.hasNext();) {
			PluginBean pluginBean = (PluginBean) iterator.next();
			if (!pluginBean.isUse())
				continue;
			if (pluginBean.isProxy()) {
				lclazz.add(pluginBean.getProxyClass());
			}
		}

		BceProxy hand = new BceProxy((Class[]) lclazz.toArray(new Class[0]));
		return hand.bindRelation(object);
	}
}
