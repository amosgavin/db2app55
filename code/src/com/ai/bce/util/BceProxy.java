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
	 * �󶨱���
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
	 * �󶨱���
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
	 * ִ�з����庯��
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

		// ���ݵݹ��������������ʵ��
		if (log.isDebugEnabled()) {
			log.debug("[BCE]��������ʵ�����ݿ�ʼ");
		}
		for (int i = 0; i < clazzes.length; i++) {
			Class clazz = clazzes[i];
			if (log.isDebugEnabled()) {
				log.debug("[BCE]��������ʵ������,����Ϊ��" + clazz.getName());
			}
			kzz[i] = (BceUseProxyInterface) ReflectUtils
					.constructorNewInstance(clazz.getName(), new Class[] {},
							new Object[] {});
		}
		// ���ݵݹ��������������ʵ��
		if (log.isDebugEnabled()) {
			log.debug("[BCE]��������ʵ�����ݽ���");
		}
		// ִ�в���ǰ����
		for (int i = 0; i < kzz.length; i++) {
			kzz[i].useBefore(object, proxy, method, args, idClassName);
		}
		if (log.isDebugEnabled()) {
			log.debug("[BCE]��ʼִ�д�����........");
		}
		result = method.invoke(object, args);
		if (log.isDebugEnabled()) {
			log.debug("[BCE]ִ�д���������........");
		}
		if (log.isDebugEnabled()) {
			log.debug("[BCE]ִ�д���ִ�к󷽷�");
		}
		// ִ�в����󷽷�
		for (int i = 0; i < kzz.length; i++) {
			BceUseProxyInterface bceUseProxyInterface = kzz[i];
			bceUseProxyInterface.useAfter(object, proxy, method, args,
					idClassName);
		}
		if (log.isDebugEnabled()) {
			log.debug("[BCE]ִ�д���ִ�к󷽷�����");
		}
		return result;
	}

}
