package com.ai.bce.auto.plugin.version.hand.bean;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/**
 * ����PCEBean *
 * <p>
 * Copyright (c) 2010
 * </p>
 * 
 * @ClassName: HandToPCEBean.java
 * @version: v1.0.0
 * @author: Qinjin Peng
 * @date: Dec 16, 2010 5:21:32 PM
 */
public class HandAttrBean implements Serializable{
	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;
	/**
	 * �����������
	 */
	private String serviceId;
	private long opId;
	
	/**
	 * ��������
	 */
	private String methodName;

	/**
	 * ��������
	 */
	private String objectClass;
	/**
	 * ����
	 */
	private String tableName;
	/**
	 * ����ID
	 */
	private String ordSn;
	/**
	 * 1 ����,3 ���
	 */
	private int operType;
	/**
	 * �ֶ�����
	 */
	private List clomnes;

	/**
	 * 
	 * ��������
	 * 
	 * @return
	 * @version: v1.0.0
	 * 
	 */
	public String getObjectClass() {
		return objectClass;
	}

	public void setObjectClass(String objectClass) {
		this.objectClass = objectClass;
	}

	/**
	 * ����
	 * 
	 * @param objectClass
	 * @version: v1.0.0
	 * 
	 */
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * ����ID
	 * 
	 * @return
	 * @version: v1.0.0
	 * 
	 */
	public String getOrdSn() {
		return ordSn;
	}

	public void setOrdSn(String ordSn) {
		this.ordSn = ordSn;
	}

	/**
	 * 1 ����,3 ���
	 * 
	 * @param objectClass
	 * @version: v1.0.0
	 * 
	 */
	public int getOperType() {
		return operType;
	}

	public void setOperType(int operType) {
		this.operType = operType;
	}

	public List getClomnes() {
		return clomnes;
	}

	public void setClomnes(List clomnes) {
		this.clomnes = clomnes;
	}

	
	public String toString() {
		// TODO Auto-generated method stub
		String toString = "[HandToPCEBean]{objectClass:" + objectClass
				+ "} {tableName:" + tableName + "} {ordSn:" + ordSn
				+ "} {operType:" + operType + "}";
		toString += "{ ";
		for (Iterator iterator = clomnes.iterator(); iterator.hasNext();) {
			ColumnBean clomnBean = (ColumnBean) iterator.next();
			toString = toString+ "{";
			toString = toString + clomnBean.toString() ;
			toString = toString + "}";
		}
		toString += " }";
		return toString;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public long getOpId() {
		return opId;
	}

	public void setOpId(long opId) {
		this.opId = opId;
	}
}
