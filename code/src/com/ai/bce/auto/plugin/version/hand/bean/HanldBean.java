package com.ai.bce.auto.plugin.version.hand.bean;

import java.io.Serializable;

/**
 * 
 * 
 * HanderBean
 * <p>
 * Copyright (c) 2010
 * </p>
 * 
 * @ClassName: HandLogService.java
 * @version: v1.0.0
 * @author: Qinjin Peng
 * @date: Dec 16, 2010 3:06:28 PM
 */
public class HanldBean implements Serializable{
	/**
	 * 方法名
	 */
	private String methodName;
	/**
	 * 参数
	 */
	private String[] params;

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String[] getParams() {
		return params;
	}

	public void setParams(String[] params) {
		this.params = params;
	}

}
