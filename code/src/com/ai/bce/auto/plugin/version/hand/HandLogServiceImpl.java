package com.ai.bce.auto.plugin.version.hand;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataType;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.bce.auto.plugin.version.hand.bean.ColumnBean;
import com.ai.bce.auto.plugin.version.hand.bean.FilterConfigBean;
import com.ai.bce.auto.plugin.version.hand.bean.HandAttrBean;
import com.ai.bce.auto.plugin.version.hand.bean.HanldBean;
import com.ai.bce.auto.plugin.version.hand.service.interfaces.IHandLogServiceSV;
import com.ai.bce.util.BceConfigServer;
import com.ai.bce.util.LocaleResourceFactory;
import com.ai.bce.util.ReflectUtils;

/**
 * 处理版本日志服务实现类
 * <p>
 * Copyright (c) 2010
 * </p>
 * 
 * @ClassName: HandLogService.java
 * @version: v1.0.0
 * @author: Qinjin Peng
 * @date: Dec 16, 2010 2:41:21 PM
 */
public class HandLogServiceImpl {

	public static final transient Log log = LogFactory
			.getLog(HandLogServiceImpl.class);
	/**
	 * 查看是否是为修改方法名
	 * <p>
	 * boolean isModified();
	 * 
	 * </p>
	 */
	public static final String ISMODIFIED = "isModified";
	/**
	 * 对应表格的所有字段值方法名
	 * <p>
	 * String[] getPropertyNames();
	 * </p>
	 */
	public static final String GET_PROPERTY_NAMES = "getPropertyNames";
	/**
	 * 主键数组方法名
	 * <p>
	 * String[] getKeyPropertyNames();
	 * </p>
	 */
	public static final String GET_KEY_PROPERTY_NAMES = "getKeyPropertyNames";
	/**
	 * 获取新值的对应方法
	 * <p>
	 * Object get(String propertyName);
	 * </p>
	 */
	public static final String GET = "get";
	/**
	 * 获取旧值对应方法名：
	 * <p>
	 * Object getOldObj(String propertyName);
	 * </p>
	 */
	public static final String GET_OLD_OBJ = "getOldObj";
	/**
	 * 获取表名的方法名
	 * <p>
	 * String getTableName();
	 * </p>
	 */
	public static final String GET_TABLE_NAME = "fetchTableName";
	/**
	 * 当前用户信息中设置的需求版本号对应字段
	 */
	public static final String VERSION_ORD_SN = "BCE_VERSION_ORD_SN";

	public static final String ISNEW = "isNew";
	public static Map versionMethodMap = new HashMap();
	private boolean isUse = true;
	static {
		try {
			versionMethodMap = (Map) BceConfigServer
					.getRegisterConfig("HAND_FILTER");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(LocaleResourceFactory.getResource("BES0000816") + " " + e.getMessage()); //解析文件出错
		}
	}

	/**
	 * 处理标准服务
	 * 
	 * @param object
	 * @param args
	 * @param method
	 * @version: v1.0.0
	 * @param idClassName
	 * @throws Exception
	 * @throws RemoteException
	 * 
	 */
	public void doLogService(Object object, Object[] args, Method method,
			String idClassName) throws RemoteException, Exception {
		// TODO Auto-generated method stub
		// IsUseService(className, methodName);
		Map methodMap = (Map) versionMethodMap.get(idClassName);
		HanldBean hanldBean = (HanldBean) methodMap.get(method.getName());
		if (hanldBean.getParams() == null) {
			log.error(LocaleResourceFactory.getResource("BES0000794",
					new Object[] { method.getName() }));
			return;
		}
		IHandLogServiceSV handLogService = (IHandLogServiceSV) ServiceFactory
				.getService(IHandLogServiceSV.class);
		HandAttrBean handBean = new HandAttrBean();
		if (ServiceManager.getUser() != null
				&& ServiceManager.getUser().get(VERSION_ORD_SN) != null) {
			String ordSn = String.valueOf(ServiceManager.getUser().get(
					VERSION_ORD_SN));
			// 设置需求工单编号
			handBean.setOrdSn(ordSn);
			handBean.setOpId(ServiceManager.getUser().getID());
		} else {
			handBean.setOrdSn("0000000");
		}
		handBean.setServiceId(idClassName);
		handBean.setMethodName(method.getName());
		handBean.setOpId(handLogService.logServiceOrd(handBean).getOpId());
		String[] params = hanldBean.getParams();
		saveBean(args, hanldBean, handLogService, handBean, params);
	}

	private void saveBean(Object[] args, HanldBean hanldBean,
			IHandLogServiceSV handLogService, HandAttrBean handBean,
			String[] params) throws Exception, RemoteException {

		for (int j = 0; j < params.length; j++) {
			// 针对参数个数和配置参数处理实现
			if (params[j] == null || j >= args.length)
				continue;
			// 获取表名
			Object arg = args[j];
			if (arg.getClass().isArray()) {
				String[] argParams = new String[Array.getLength(arg)];
				Object[] objcects = new Object[Array.getLength(arg)];
				for (int i = 0; i < argParams.length; i++) {
					objcects[i] = Array.get(arg, i);
					argParams[i] = String.valueOf(i);
				}
				// 针对数组处理
				saveBean(objcects, hanldBean, handLogService, handBean,
						argParams);
			}
			if (!(arg instanceof DataContainer))
				break;
			//
			String tableName = (String) ReflectUtils.methodInvoke(arg
					.getClass().getName(), GET_TABLE_NAME, null, null, arg);
			handBean.setTableName(tableName);
			handBean.setObjectClass(arg.getClass().getName());

			boolean ismodufied = ((Boolean) (ReflectUtils.methodInvoke(arg
					.getClass().getName(), ISMODIFIED, null, null, arg)))
					.booleanValue();
			boolean isNew = ((Boolean) (ReflectUtils.methodInvoke(arg
					.getClass().getName(), ISNEW, null, null, arg)))
					.booleanValue();
			// 设置变更类型
			handBean.setOperType(ismodufied ? 3 : isNew ? 1 : 2);
			// 设置字对象
			String[] properties = (String[]) (ReflectUtils.methodInvoke(arg
					.getClass().getName(), GET_PROPERTY_NAMES, null, null, arg));
			String[] keyProperties = (String[]) (ReflectUtils.methodInvoke(arg
					.getClass().getName(), GET_KEY_PROPERTY_NAMES, null, null,
					arg));
			List coBeans = new LinkedList();
			setCoBean(arg, properties, keyProperties, coBeans);
			handBean.setClomnes(coBeans);
			//
			if (handLogService.logService(handBean)) {
				if (log.isDebugEnabled())
					log.debug(LocaleResourceFactory.getResource("BES0000797"));
			}
		}
	}

	private void setCoBean(Object arg, String[] properties,
			String[] keyProperties, List coBeans) throws Exception {
		for (int i = 0; i < properties.length; i++) {
			String clomn = properties[i];
			ColumnBean coBean = new ColumnBean();
			for (int j = 0; j < keyProperties.length; j++) {
				String keyPro = keyProperties[j];
				if (keyPro != null && keyPro.equals(clomn)) {
					coBean.setPk(true);
					break;
				}
			}
			coBean.setClomnName(clomn);
			Object newValue = (ReflectUtils.methodInvoke(arg.getClass()
					.getName(), GET, new Class[] { String.class },
					new Object[] { clomn }, arg));

			Object oldObjValue = (ReflectUtils.methodInvoke(arg.getClass()
					.getName(), GET_OLD_OBJ, new Class[] { String.class },
					new Object[] { clomn }, arg));
			String oldvalue = "";
			String newvalue = "";
			String typeName = "";
			FilterConfigBean configBean = (FilterConfigBean) versionMethodMap
					.get("ID_KEY_Q_FILTER_LOG");
			if (oldObjValue instanceof Date || newValue instanceof Date) {
				if(oldObjValue != null  )
					oldvalue = ReflectUtils.getFormatDate((Date) oldObjValue,
						configBean.getFormateDateType());
				if(newValue != null)
					newvalue = ReflectUtils.getFormatDate((Date) newValue,
							configBean.getFormateDateType());
				Object type = configBean.getFilterClassMapping().get(
						Date.class.getName());
				typeName = (String) (type == null ? Date.class.getName() : type);
			} else {
				newvalue = newValue == null ? "" : String.valueOf(newValue);
				oldvalue = oldObjValue == null ? "" : String
						.valueOf(oldObjValue);
				Class clazz = newValue != null ? newValue.getClass()
						: (oldObjValue != null ? oldObjValue.getClass() : null);
				if (clazz != null) {
					Object type = configBean.getFilterClassMapping().get(
							DataType.getSimpleClass(clazz).getName());
					typeName = (String) (type == null ? clazz.getName() : type);
				}
			}
			coBean.setNewValue(newvalue);
			coBean.setOldValue(oldvalue);
			coBean.setValueType(typeName);
			// 检测类型值为空，则表名新值和旧值都是为空
			if ("".equals(typeName))
				continue;
			coBeans.add(coBean);
		}
	}

	/**
	 * 检测当前服务是否需要记录日志
	 * 
	 * @param className
	 *            类名
	 * @param methodName
	 *            方法名
	 * @return boolean true 需要，false 不需要
	 * @version: v1.0.0
	 * 
	 */
	public boolean isUseService(String className, String methodName) {
		if (!isUse){
			return isUse;}
		Map methodMap = (Map) versionMethodMap.get(className);
		if (methodMap == null) {
			if (log.isDebugEnabled())
				log.debug(LocaleResourceFactory.getResource("BES0000795",
						new Object[] { className }));
			isUse = false;
			return isUse;
		}
		HanldBean hanldBean = (HanldBean) methodMap.get(methodName);
		if (hanldBean == null) {
			if (log.isDebugEnabled())
				log.debug(LocaleResourceFactory.getResource("BES0000796",
						new Object[] { methodName }));
			isUse = false;
			return isUse;
		}
		return isUse;
	}

	public static void main(String[] args) {
		System.out.println(DataType.getSimpleClass(String.class).getName());
	}
}
