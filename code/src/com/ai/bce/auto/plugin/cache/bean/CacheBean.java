package com.ai.bce.auto.plugin.cache.bean;

import java.io.Serializable;
import java.util.Map;

/**
 * BceCache 对象
 * <p>
 * Copyright (c) 2010 Asiainfo-Linkage
 * </p>
 * 
 * @ClassName: CacheBean.java
 * @Description: 该类的功能描述
 * 
 * @version: v1.0.0
 * @author: Qinjin Peng
 * @date: Feb 12, 2011 10:35:50 AM
 */
public class CacheBean implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 当前Cache的类型
	 */
	private String type;
	private String code ;
	/**
	 * 若为STATIC类型的时候则为key_value键值对类型措施，此时解析Cache时候则优先从此处理
	 */
	private Map staticCache;

	/**
	 * 类型为METHOD的时候使用
	 */
	private CacheKeyBean cacheKey;
	/**
	 * 类型为METHOD的时候使用
	 */
	private CacheValueBean cacheValue;

	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Map getStaticCache() {
		return staticCache;
	}

	public void setStaticCache(Map staticCache) {
		this.staticCache = staticCache;
	}

	public CacheKeyBean getCacheKey() {
		return cacheKey;
	}

	public void setCacheKey(CacheKeyBean cacheKey) {
		this.cacheKey = cacheKey;
	}

	public CacheValueBean getCacheValue() {
		return cacheValue;
	}

	public void setCacheValue(CacheValueBean cacheValue) {
		this.cacheValue = cacheValue;
	}



}
