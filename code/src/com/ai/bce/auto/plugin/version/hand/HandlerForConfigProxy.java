package com.ai.bce.auto.plugin.version.hand;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.rmi.RemoteException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.bce.util.BceProxy;
import com.ai.bce.util.LocaleResourceFactory;
import com.ai.bce.util.define.BceUseProxyInterface;

/**
 * 
 * 代理服务类
 * <p>
 * Copyright (c) 2010
 * </p>
 * 
 * @ClassName: HandlerForConfig.java
 * @version: v1.0.0
 * @author: Qinjin Peng
 * @date: Dec 16, 2010 2:00:21 PM
 */
public class HandlerForConfigProxy implements BceUseProxyInterface {
	private static transient final Log log = LogFactory
			.getLog(HandlerForConfigProxy.class);
	private String idClassName;
	private boolean isUse = true;
	private	HandLogServiceImpl hService = new HandLogServiceImpl();
	public String getIdClassName() {
		return idClassName;
	}


	/**
	 * 
	* @Title: useAfter 
	* @Description: TODO  
	* @param @param object
	* @param @param proxy
	* @param @param method
	* @param @param args
	* @param @throws Exception    
	* @return void     
	* @throws
	 */
	public void useAfter(Object object,Object proxy, Method method, Object[] args,String idClassName) throws Exception {
		// TODO Auto-generated method stub
		if (isUse)
			// 记录日志
			hService.doLogService(object, args, method, idClassName);
	}

	/**
	 * 
	* @Title: useBefore 
	* @Description: TODO  
	* @param @param object
	* @param @param proxy
	* @param @param method
	* @param @param args    
	* @return void     
	* @throws
	 */
	public void useBefore(Object object,Object proxy, Method method, Object[] args,String idClassName) {
		// TODO Auto-generated method stub
		isUse = hService.isUseService(idClassName, method.getName());
		if (!isUse && log.isDebugEnabled()) {
			//当前业务不需要日志变更.
			log.debug(LocaleResourceFactory.getResource("BES0000837"));
		}
	}
}
