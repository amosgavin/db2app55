package com.ai.bce.auto.plugin.cache.bean;

import java.io.Serializable;

/**
 * 
 * Cache键模块
 * <p>
 * Copyright (c) 2010 Asiainfo-Linkage
 * </p>
 * 
 * @ClassName: CacheKeyBean.java
 * @Description: 该类的功能描述
 * 
 * @version: v1.0.0
 * @author: Qinjin Peng
 * @date: Feb 12, 2011 3:58:12 PM
 */
public class CacheKeyBean implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 4141834477933800786L;

	private String name;
	private String methodName;
	private String value;

	/**
	 * 返回名称
	 * 
	 * @Title:
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param
	 * @return 设定文件
	 * @return 返回类型
	 * @throws
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取方法名：只有Cache基于Method
	 * 
	 * @Title:
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param
	 * @return 设定文件
	 * @return 返回类型
	 * @throws
	 */
	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	/**
	 * 返回一个值
	 * 
	 * @Title:
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param
	 * @return 设定文件
	 * @return 返回类型
	 * @throws
	 */
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
