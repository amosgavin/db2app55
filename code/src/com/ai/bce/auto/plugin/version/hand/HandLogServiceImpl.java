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
 * ����汾��־����ʵ����
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
	 * �鿴�Ƿ���Ϊ�޸ķ�����
	 * <p>
	 * boolean isModified();
	 * 
	 * </p>
	 */
	public static final String ISMODIFIED = "isModified";
	/**
	 * ��Ӧ���������ֶ�ֵ������
	 * <p>
	 * String[] getPropertyNames();
	 * </p>
	 */
	public static final String GET_PROPERTY_NAMES = "getPropertyNames";
	/**
	 * �������鷽����
	 * <p>
	 * String[] getKeyPropertyNames();
	 * </p>
	 */
	public static final String GET_KEY_PROPERTY_NAMES = "getKeyPropertyNames";
	/**
	 * ��ȡ��ֵ�Ķ�Ӧ����
	 * <p>
	 * Object get(String propertyName);
	 * </p>
	 */
	public static final String GET = "get";
	/**
	 * ��ȡ��ֵ��Ӧ��������
	 * <p>
	 * Object getOldObj(String propertyName);
	 * </p>
	 */
	public static final String GET_OLD_OBJ = "getOldObj";
	/**
	 * ��ȡ�����ķ�����
	 * <p>
	 * String getTableName();
	 * </p>
	 */
	public static final String GET_TABLE_NAME = "fetchTableName";
	/**
	 * ��ǰ�û���Ϣ�����õ�����汾�Ŷ�Ӧ�ֶ�
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
			throw new RuntimeException(LocaleResourceFactory.getResource("BES0000816") + " " + e.getMessage()); //�����ļ�����
		}
	}

	/**
	 * �����׼����
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
			// �������󹤵����
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
			// ��Բ������������ò�������ʵ��
			if (params[j] == null || j >= args.length)
				continue;
			// ��ȡ����
			Object arg = args[j];
			if (arg.getClass().isArray()) {
				String[] argParams = new String[Array.getLength(arg)];
				Object[] objcects = new Object[Array.getLength(arg)];
				for (int i = 0; i < argParams.length; i++) {
					objcects[i] = Array.get(arg, i);
					argParams[i] = String.valueOf(i);
				}
				// ������鴦��
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
			// ���ñ������
			handBean.setOperType(ismodufied ? 3 : isNew ? 1 : 2);
			// �����ֶ���
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
			// �������ֵΪ�գ��������ֵ�;�ֵ����Ϊ��
			if ("".equals(typeName))
				continue;
			coBeans.add(coBean);
		}
	}

	/**
	 * ��⵱ǰ�����Ƿ���Ҫ��¼��־
	 * 
	 * @param className
	 *            ����
	 * @param methodName
	 *            ������
	 * @return boolean true ��Ҫ��false ����Ҫ
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
