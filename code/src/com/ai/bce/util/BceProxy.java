package com.ai.bce.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.bce.auto.plugin.version.hand.HandlerForConfigProxy;
import com.ai.bce.util.define.BceUseProxyInterface;

public class BceProxy implements InvocationHandler {
	public static transient final Log log = LogFactory
			.getLog(HandlerForConfigProxy.class);
	
	private Object object;
	private String idClassName;
	protected Class[] clazzes;
	private Class[] filterClass;

	public BceProxy(Class[] clazzes) {
		this.clazzes = clazzes;
	}

	/**
	 * 绑定变量
	 * 
	 * @Title: bindRelation
	 * @Description: TODO
	 * @param @param object
	 * @param @return
	 * @return Object
	 * @throws
	 */
	public Object bindRelation(Object object) {
		this.object = object;
		this.idClassName = object.getClass().getName();
		return Proxy.newProxyInstance(object.getClass().getClassLoader(),
				object.getClass().getInterfaces(), this);
	}

	/**
	 * 绑定变量
	 * 
	 * @Title: bindRelation
	 * @Description: TODO
	 * @param @param object
	 * @param @return
	 * @return Object
	 * @throws
	 */
	public Object bindRelation(Object object, Class[] filterClasses) {
		this.object = object;
		this.idClassName = object.getClass().getName();
		this.filterClass = filterClasses;
		return Proxy.newProxyInstance(object.getClass().getClassLoader(),
				object.getClass().getInterfaces(), this);
	}

	/**
	 * 执行反射体函数
	 */
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;
		BceUseProxyInterface[] kzz = new BceUseProxyInterface[clazzes != null ? clazzes.length
				: 0];
		if (log.isDebugEnabled()) {
			log.debug(LocaleResourceFactory.getResource(
					"BES0000845",
					new Object[] {
							String.valueOf(kzz.length),
							Thread.currentThread().getStackTrace()[2]
									.getMethodName(),
							Thread.currentThread().getStackTrace()[2]
									.getClassName() }));
		}

		// 根据递归进来的类名创建实例
		if (log.isDebugEnabled()) {
			log.debug("[BCE]创建拦截实例数据开始");
		}
		for (int i = 0; i < clazzes.length; i++) {
			Class clazz = clazzes[i];
			if (log.isDebugEnabled()) {
				log.debug("[BCE]创建拦截实例数据,类名为：" + clazz.getName());
			}
			kzz[i] = (BceUseProxyInterface) ReflectUtils
					.constructorNewInstance(clazz.getName(), new Class[] {},
							new Object[] {});
		}
		// 根据递归进来的类名创建实例
		if (log.isDebugEnabled()) {
			log.debug("[BCE]创建拦截实例数据结束");
		}
		// 执行参数前方法
		for (int i = 0; i < kzz.length; i++) {
			kzz[i].useBefore(object, proxy, method, args, idClassName);
		}
		if (log.isDebugEnabled()) {
			log.debug("[BCE]开始执行代理方法........");
		}
		result = method.invoke(object, args);
		if (log.isDebugEnabled()) {
			log.debug("[BCE]执行代理方法结束........");
		}
		if (log.isDebugEnabled()) {
			log.debug("[BCE]执行代理执行后方法");
		}
		// 执行参数后方法
		for (int i = 0; i < kzz.length; i++) {
			BceUseProxyInterface bceUseProxyInterface = kzz[i];
			bceUseProxyInterface.useAfter(object, proxy, method, args,
					idClassName);
		}
		if (log.isDebugEnabled()) {
			log.debug("[BCE]执行代理执行后方法结束");
		}
		return result;
	}

}
