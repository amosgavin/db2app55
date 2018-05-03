package com.ai.bce.auto.plugin.cache.bean;

import java.io.Serializable;

/**
 * 
 * Cache��ģ��
 * <p>
 * Copyright (c) 2010 Asiainfo-Linkage
 * </p>
 * 
 * @ClassName: CacheKeyBean.java
 * @Description: ����Ĺ�������
 * 
 * @version: v1.0.0
 * @author: Qinjin Peng
 * @date: Feb 12, 2011 3:58:12 PM
 */
public class CacheKeyBean implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(��һ�仰�������������ʾʲô)
	 */
	private static final long serialVersionUID = 4141834477933800786L;

	private String name;
	private String methodName;
	private String value;

	/**
	 * ��������
	 * 
	 * @Title:
	 * @Description: TODO(������һ�仰�����������������)
	 * @param
	 * @return �趨�ļ�
	 * @return ��������
	 * @throws
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ȡ��������ֻ��Cache����Method
	 * 
	 * @Title:
	 * @Description: TODO(������һ�仰�����������������)
	 * @param
	 * @return �趨�ļ�
	 * @return ��������
	 * @throws
	 */
	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	/**
	 * ����һ��ֵ
	 * 
	 * @Title:
	 * @Description: TODO(������һ�仰�����������������)
	 * @param
	 * @return �趨�ļ�
	 * @return ��������
	 * @throws
	 */
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
