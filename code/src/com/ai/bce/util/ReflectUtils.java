package com.ai.bce.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
import com.ai.common.util.ExceptionUtil;

/**
 * ����:JDK5�в��ܴ��ݶ����ɱ����,��:methodInvoke()���� Copyright (c) 2010 Asiainfo-Linkage
 * 
 * @ClassName: ReflectUtils.java
 * @version: v1.0.0
 * @author: Qinjin Peng
 * @date: Oct 24, 2010 7:25:21 PM
 */
public class ReflectUtils {
	public static transient Log log = LogFactory.getLog(ReflectUtils.class);
	static final Map classmap = new HashMap();
	public static final String FORMATE_YEAR_MONTH = "yyyyMM";
	public static final String FORMATE_YYYYMMDDHHMMSS = "yyyyMMddhhmmssSSS";
	private static Map exprMap = new HashMap();
	private static JexlEngine engine = new JexlEngine();
	public static String BCE_IS_CROSS_SERVICE = "BCE_IS_CROSS_SERVICE";
	public static String BCE_CROSS_SERVICE_Y = "Y";

	/**
	 * ͨ�����캯��ʵ��������
	 * 
	 * @param className
	 *            ���ȫ·������
	 * @param parameterTypes
	 *            ��������
	 * @param initargs
	 *            ����ֵ
	 * @return
	 */

	public static Object constructorNewInstance(String className,
			Class[] parameterTypes, Object[] initargs) {
		try {
			Object object = null;
			Class clazz = null;
			try {
				clazz = forName(className);
			} catch (ClassNotFoundException e) {
				// ͨ���������ȥ��ȡ
				object = getSVService(className);
			}
			if (clazz != null) {
				object = constructorNewInstance(clazz, parameterTypes, initargs);
			}
			if(object == null ){ExceptionUtil.throwBusinessException("����ʵ������ʧ�ܣ�ʵ��Ϊ�գ�ClassName:"+className);};
			return object;
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error("ʵ�����������,��������" + className, ex);
			}
			throw new RuntimeException(ex);
		}
	}

	/**
	 * ͨ�����캯��ʵ��������
	 * 
	 * @param className
	 *            ���ȫ·������
	 * @param parameterTypes
	 *            ��������
	 * @param initargs
	 *            ����ֵ
	 * @return
	 */

	public static Object constructorNewInstance(Class clazz,
			Class[] parameterTypes, Object[] initargs) {
		try {
			Object object = null;
			if (clazz != null && clazz.isInterface()
					&& (parameterTypes == null || parameterTypes.length < 1)
					&& (initargs == null || parameterTypes.length < 1)) {
				object = getSVService(clazz);
			} else if (clazz != null) {
				if (log.isDebugEnabled()) {
					log.debug("[BCE_DEBUG]��ǰ��Ҫ��Ϊ����Ϊʹ�� Class ģʽ,ClassName Is ["
							+ clazz.getName() + "]");
				}
				Constructor constructor = (Constructor) clazz
						.getDeclaredConstructor(parameterTypes); // ��������
				constructor.setAccessible(true);
				object = constructor.newInstance(initargs);
			}
			return object;
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error("ʵ�����������,��������" + clazz.getName(), ex);
			}
			throw new RuntimeException(ex);
		}
	}

	private static Object getSVService(Class clazz) {
		Object object;
		String Y_BCE_IS_CROSS_SERVICE = String.valueOf(BceCommonStore
				.getSomeThingFromThread(ReflectUtils.BCE_IS_CROSS_SERVICE));
		if (StringUtils.equals(ReflectUtils.BCE_CROSS_SERVICE_Y,
				Y_BCE_IS_CROSS_SERVICE)) {
			if (log.isInfoEnabled()) {
				log.info("[BCE_INFO]��ǰ�߳��л�ȡΪIs Cross Service,ServiceName Is ["
						+ clazz.getName() + "]");
			}
			object = ServiceFactory.getCrossCenterService(clazz);
		} else {
			if (log.isDebugEnabled()) {
				log
						.debug("[BCE_DEBUG]��ǰ�߳���Ϊ����ΪIs Not Cross Service,ServiceName Is ["
								+ clazz.getName() + "]");
			}
			object = ServiceFactory.getService(clazz);
		}
		return object;
	}

	private static Object getSVService(String className) {
		Object object;
		String Y_BCE_IS_CROSS_SERVICE = String.valueOf(BceCommonStore
				.getSomeThingFromThread(ReflectUtils.BCE_IS_CROSS_SERVICE));
		if (StringUtils.equals(ReflectUtils.BCE_CROSS_SERVICE_Y,
				Y_BCE_IS_CROSS_SERVICE)) {
			if (log.isInfoEnabled()) {
				log.info("[BCE_INFO]��ǰ�߳��л�ȡΪIs Cross Service,ServiceName Is ["
						+ className + "]");
			}
			object = ServiceFactory.getCrossCenterService(className);
		} else {
			if (log.isDebugEnabled()) {
				log
						.debug("[BCE_DEBUG]��ǰ�߳���Ϊ����ΪIs Not Cross Service,ServiceName Is ["
								+ className + "]");
			}
			object = ServiceFactory.getService(className);
		}
		return object;
	}

	/**
	 * 
	 * ��ȡClass
	 * 
	 * @param className
	 * @return
	 * @throws ClassNotFoundException
	 * @version: v1.0.0
	 * @author: Qinjin Peng
	 * @date: Nov 3, 2010 4:32:39 PM
	 */
	public static Class forName(String className) throws ClassNotFoundException {
		return (Class) (!classmap.containsKey(className) ? setClassmap(className)
				: classmap.get(className));
	}

	/**
	 * ��������Class
	 * 
	 * @param className
	 * @return
	 * @throws ClassNotFoundException
	 * @version: v1.0.0
	 * @author: Qinjin Peng
	 * @date: Nov 3, 2010 4:32:12 PM
	 */
	private static Class setClassmap(String className)
			throws ClassNotFoundException {
		Class cl = Class.forName(className);
		classmap.put(className, cl);
		return cl;
	}

	/**
	 * ���������ȡ�ֶ�ֵ
	 * 
	 * @param fieldName
	 *            ������
	 * @param obj
	 *            ʵ������
	 * @return ����ֵ
	 */
	public static Object getFieldValue(String propertyName, Object obj) {
		try {
			Field field = obj.getClass().getDeclaredField(propertyName);
			field.setAccessible(true);
			return field.get(obj);
		} catch (Exception ex) {

			throw new RuntimeException(ex);
		}
	}

	/**
	 * ���������ȡ�ֶ�ֵ
	 * 
	 * @param propertyName
	 *            ������
	 * @param object
	 *            ʵ������
	 * @return �ֶ�ֵ
	 */
	public static Object getProperty(String propertyName, Object object) {
		try {

			PropertyDescriptor pd = new PropertyDescriptor(propertyName, object
					.getClass());
			Method method = pd.getReadMethod();
			return method.invoke(object, new Object[] {});
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * ͨ��BeanUtils���߰���ȡ�����ȡ�ֶ�ֵ,ע���ֵ�����ַ�����ʽ���ڵ�,��֧��������׺����:��,.����.����
	 * 
	 * @param propertyName
	 *            ������
	 * @param object
	 *            ʵ������
	 * @return �ֶ�ֵ
	 */
	public static Object getBeanInfoProperty(String propertyName, Object object) {
		try {
			return BeanUtils.getProperty(object, propertyName);
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error("��ȡ�����ȡ�ֶ�ֵ�������", ex);
			}
			throw new RuntimeException(ex);
		}
	}

	/**
	 * ͨ��BeanUtils���߰���ȡ�����ȡ�ֶ�ֵ,ע���ֵ�����ַ�����ʽ���ڵ�
	 * 
	 * @param object
	 *            ʵ������
	 * @param propertyName
	 *            ������
	 * @param value
	 *            �ֶ�ֵ
	 * @return
	 */
	public static void setBeanInfoProperty(Object object, String propertyName,
			String value) {
		try {
			BeanUtils.setProperty(object, propertyName, value);
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error("�����ֶ�ֵ����:", ex);
			}
			throw new RuntimeException(ex);
		}
	}

	/**
	 * ͨ��BeanUtils���߰���ȡ�����ȡ�ֶ�ֵ,ע���ֵ���Զ������Ե�ʵ������
	 * 
	 * @param propertyName
	 *            ������
	 * @param object
	 *            ʵ������
	 * @return �ֶ�ֵ
	 */
	public static Object getPropertyUtilByName(String propertyName,
			Object object) {
		try {
			return PropertyUtils.getProperty(object, propertyName);
		} catch (Exception ex) {
			throw new RuntimeException();
		}
	}

	/**
	 * ͨ��BeanUtils���߰���ȡ�����ȡ�ֶ�ֵ,ע���ֵ���Զ������Ե�ʵ������,����PropertyUtils��BeanUtils�ĸ�������
	 * 
	 * @param object
	 *            ʵ������
	 * @param propertyName
	 *            ������
	 * @param value
	 *            �ֶ�ֵ
	 * @return
	 */
	public static void setPropertyUtilByName(Object object,
			String propertyName, Object value) {
		try {
			PropertyUtils.setProperty(object, propertyName, value);
		} catch (Exception ex) {
			throw new RuntimeException();
		}
	}

	/**
	 * �����ֶ�ֵ
	 * 
	 * @param obj
	 *            ʵ������
	 * @param propertyName
	 *            ������
	 * @param value
	 *            �µ��ֶ�ֵ
	 * @return
	 */
	public static void setProperties(Object object, String propertyName,
			Object value) throws IntrospectionException,
			IllegalAccessException, InvocationTargetException {
		PropertyDescriptor pd = new PropertyDescriptor(propertyName, object
				.getClass());
		Method methodSet = pd.getWriteMethod();
		methodSet.invoke(object, new Object[] { value });
	}

	/**
	 * �����ֶ�ֵ
	 * 
	 * @param propertyName
	 *            �ֶ���
	 * @param obj
	 *            ʵ������
	 * @param value
	 *            �µ��ֶ�ֵ
	 * @return
	 */
	public static void setFieldValue(Object obj, String propertyName,
			Object value) {
		try {
			Field field = obj.getClass().getDeclaredField(propertyName);
			field.setAccessible(true);
			field.set(obj, value);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * �����ֶ�ֵ
	 * 
	 * @param className
	 *            ���ȫ·������
	 * @param methodName
	 *            ���÷�����
	 * @param parameterTypes
	 *            ��������
	 * @param values
	 *            ����ֵ
	 * @param object
	 *            ʵ������
	 * @return
	 * @throws Exception 
	 */

	public static Object methodInvoke(String className, String methodName,
			Class[] parameterTypes, Object[] values, Object object) throws Exception {
		try {
			if (object == null) {
				object = constructorNewInstance(className, new Class[] {},
						new Object[] {});
			}
			
			Method method = (object == null ? forName(className) : object
					.getClass()).getMethod(methodName, parameterTypes);
			method.setAccessible(true);
			return method.invoke(object, values);
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error("��ǰ�����Class Ϊ��"+className+",Method:"+methodName);
				log.error("������������Ϊ��"+StringUtils.join(parameterTypes==null?new String[]{}:parameterTypes,","));
				log.error("����ֵΪ��"+StringUtils.join(values==null?new String[]{}:values,","));
				log.error("���䷽������.Class:"+className+",MethodName:"+methodName,ex);
			}
			throw ex;
		}
	}

	/**
	 * 
	 * �˷���Ϊ��ʽ��ʱ��ר��
	 * 
	 * SimpleDateFormat�����﷨��
	 * 
	 * G �����־�� y �� M �� d �� h ʱ ����������� (1~12) H ʱ ��һ���� (0~23) m �� s �� S ���� E ���� D
	 * һ���еĵڼ��� F һ���еڼ������ڼ� w һ���еڼ������� W һ���еڼ������� a ���� / ���� ��Ƿ� k ʱ ��һ���� (1~24) K
	 * ʱ ����������� (0~11) z ʱ��
	 * 
	 * @Title:
	 * @Description: TODO(������һ�仰�����������������)
	 * @param
	 * @param date
	 *            ʱ��
	 * @param format
	 *            ��ʽ����ʽ
	 * @return String �����ַ���
	 * @throws
	 */
	public static String getFormatDate(Date date, String format) {
		SimpleDateFormat myFmt = new SimpleDateFormat(format);
		return myFmt.format(date);
	}

	/**
	 * ������ʽ��������ʽ��ʽΪ������������ʽ���ɰ�����������������������������Map�����е���������������Ƕ�׵����������磺A/A.B/A[i]/
	 * A[i].B
	 * 
	 * @param expr
	 *            ���ʽ
	 * @param map
	 *            �洢���ֱ���������
	 * @return Object ���ʽִ�н��
	 * @throws Exception
	 */
	public static Object evaluateExpr(String expr, Map map) throws Exception {
		Object result = null;
		// ����MapContext����
		MapContext context = new MapContext();
		Iterator iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			context.set(entry.getKey().toString(), entry.getValue());
		}
		// ��ȡExpression����
		Expression expression = (Expression) exprMap.get(expr);
		if (expression == null) {
			expression = engine.createExpression(expr);
			exprMap.put(expr, expression);
		}
		// ������ʽ��ֵ
		result = expression.evaluate(context);
		return result;
	}

	public static void main(String[] args) throws ClassNotFoundException {
		forName("com");
	}
}
