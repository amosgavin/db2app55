package com.ai.bce.auto.plugin.version.hand.bean;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/**
 * 送至PCEBean *
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
	 * 保存服务名称
	 */
	private String serviceId;
	private long opId;
	
	/**
	 * 方法名称
	 */
	private String methodName;

	/**
	 * 对象类型
	 */
	private String objectClass;
	/**
	 * 表名
	 */
	private String tableName;
	/**
	 * 需求单ID
	 */
	private String ordSn;
	/**
	 * 1 增加,3 变更
	 */
	private int operType;
	/**
	 * 字段数组
	 */
	private List clomnes;

	/**
	 * 
	 * 对象类型
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
	 * 表名
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
	 * 需求单ID
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
	 * 1 增加,3 变更
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
