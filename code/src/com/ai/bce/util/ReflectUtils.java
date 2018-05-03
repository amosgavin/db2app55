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
 * 问题:JDK5中不能传递二个可变参数,如:methodInvoke()方法 Copyright (c) 2010 Asiainfo-Linkage
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
	 * 通过构造函数实例化对象
	 * 
	 * @param className
	 *            类的全路径名称
	 * @param parameterTypes
	 *            参数类型
	 * @param initargs
	 *            参数值
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
				// 通过服务参数去获取
				object = getSVService(className);
			}
			if (clazz != null) {
				object = constructorNewInstance(clazz, parameterTypes, initargs);
			}
			if(object == null ){ExceptionUtil.throwBusinessException("创建实例数据失败，实例为空：ClassName:"+className);};
			return object;
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error("实例化服务出错,服务名：" + className, ex);
			}
			throw new RuntimeException(ex);
		}
	}

	/**
	 * 通过构造函数实例化对象
	 * 
	 * @param className
	 *            类的全路径名称
	 * @param parameterTypes
	 *            参数类型
	 * @param initargs
	 *            参数值
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
					log.debug("[BCE_DEBUG]当前需要中为配置为使用 Class 模式,ClassName Is ["
							+ clazz.getName() + "]");
				}
				Constructor constructor = (Constructor) clazz
						.getDeclaredConstructor(parameterTypes); // 暴力反射
				constructor.setAccessible(true);
				object = constructor.newInstance(initargs);
			}
			return object;
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error("实例化服务出错,服务名：" + clazz.getName(), ex);
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
				log.info("[BCE_INFO]当前线程中获取为Is Cross Service,ServiceName Is ["
						+ clazz.getName() + "]");
			}
			object = ServiceFactory.getCrossCenterService(clazz);
		} else {
			if (log.isDebugEnabled()) {
				log
						.debug("[BCE_DEBUG]当前线程中为配置为Is Not Cross Service,ServiceName Is ["
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
				log.info("[BCE_INFO]当前线程中获取为Is Cross Service,ServiceName Is ["
						+ className + "]");
			}
			object = ServiceFactory.getCrossCenterService(className);
		} else {
			if (log.isDebugEnabled()) {
				log
						.debug("[BCE_DEBUG]当前线程中为配置为Is Not Cross Service,ServiceName Is ["
								+ className + "]");
			}
			object = ServiceFactory.getService(className);
		}
		return object;
	}

	/**
	 * 
	 * 获取Class
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
	 * 反射生成Class
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
	 * 暴力反射获取字段值
	 * 
	 * @param fieldName
	 *            属性名
	 * @param obj
	 *            实例对象
	 * @return 属性值
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
	 * 暴力反射获取字段值
	 * 
	 * @param propertyName
	 *            属性名
	 * @param object
	 *            实例对象
	 * @return 字段值
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
	 * 通过BeanUtils工具包获取反射获取字段值,注意此值是以字符串形式存在的,它支持属性连缀操作:如,.对象.属性
	 * 
	 * @param propertyName
	 *            属性名
	 * @param object
	 *            实例对象
	 * @return 字段值
	 */
	public static Object getBeanInfoProperty(String propertyName, Object object) {
		try {
			return BeanUtils.getProperty(object, propertyName);
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error("获取反射获取字段值出错错误：", ex);
			}
			throw new RuntimeException(ex);
		}
	}

	/**
	 * 通过BeanUtils工具包获取反射获取字段值,注意此值是以字符串形式存在的
	 * 
	 * @param object
	 *            实例对象
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            字段值
	 * @return
	 */
	public static void setBeanInfoProperty(Object object, String propertyName,
			String value) {
		try {
			BeanUtils.setProperty(object, propertyName, value);
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error("设置字段值出错:", ex);
			}
			throw new RuntimeException(ex);
		}
	}

	/**
	 * 通过BeanUtils工具包获取反射获取字段值,注意此值是以对象属性的实际类型
	 * 
	 * @param propertyName
	 *            属性名
	 * @param object
	 *            实例对象
	 * @return 字段值
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
	 * 通过BeanUtils工具包获取反射获取字段值,注意此值是以对象属性的实际类型,这是PropertyUtils与BeanUtils的根本区别
	 * 
	 * @param object
	 *            实例对象
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            字段值
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
	 * 设置字段值
	 * 
	 * @param obj
	 *            实例对象
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            新的字段值
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
	 * 设置字段值
	 * 
	 * @param propertyName
	 *            字段名
	 * @param obj
	 *            实例对象
	 * @param value
	 *            新的字段值
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
	 * 设置字段值
	 * 
	 * @param className
	 *            类的全路径名称
	 * @param methodName
	 *            调用方法名
	 * @param parameterTypes
	 *            参数类型
	 * @param values
	 *            参数值
	 * @param object
	 *            实例对象
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
				log.error("当前出错的Class 为："+className+",Method:"+methodName);
				log.error("参数类型名称为："+StringUtils.join(parameterTypes==null?new String[]{}:parameterTypes,","));
				log.error("参数值为："+StringUtils.join(values==null?new String[]{}:values,","));
				log.error("反射方法出错.Class:"+className+",MethodName:"+methodName,ex);
			}
			throw ex;
		}
	}

	/**
	 * 
	 * 此方法为格式化时间专用
	 * 
	 * SimpleDateFormat函数语法：
	 * 
	 * G 年代标志符 y 年 M 月 d 日 h 时 在上午或下午 (1~12) H 时 在一天中 (0~23) m 分 s 秒 S 毫秒 E 星期 D
	 * 一年中的第几天 F 一月中第几个星期几 w 一年中第几个星期 W 一月中第几个星期 a 上午 / 下午 标记符 k 时 在一天中 (1~24) K
	 * 时 在上午或下午 (0~11) z 时区
	 * 
	 * @Title:
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param
	 * @param date
	 *            时间
	 * @param format
	 *            格式化格式
	 * @return String 类型字符串
	 * @throws
	 */
	public static String getFormatDate(Date date, String format) {
		SimpleDateFormat myFmt = new SimpleDateFormat(format);
		return myFmt.format(date);
	}

	/**
	 * 计算表达式结果，表达式格式为常规的算术表达式，可包括常量，变量，函数，变量名是Map容器中的属性名，还可以嵌套的属性名，如：A/A.B/A[i]/
	 * A[i].B
	 * 
	 * @param expr
	 *            表达式
	 * @param map
	 *            存储各种变量的容器
	 * @return Object 表达式执行结果
	 * @throws Exception
	 */
	public static Object evaluateExpr(String expr, Map map) throws Exception {
		Object result = null;
		// 构建MapContext对象
		MapContext context = new MapContext();
		Iterator iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			context.set(entry.getKey().toString(), entry.getValue());
		}
		// 获取Expression对象
		Expression expression = (Expression) exprMap.get(expr);
		if (expression == null) {
			expression = engine.createExpression(expr);
			exprMap.put(expr, expression);
		}
		// 计算表达式的值
		result = expression.evaluate(context);
		return result;
	}

	public static void main(String[] args) throws ClassNotFoundException {
		forName("com");
	}
}
