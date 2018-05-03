package com.ai.bce.auto.plugin.cache.bean;

import java.io.Serializable;
import java.util.Map;

/**
 * BceCache ����
 * <p>
 * Copyright (c) 2010 Asiainfo-Linkage
 * </p>
 * 
 * @ClassName: CacheBean.java
 * @Description: ����Ĺ�������
 * 
 * @version: v1.0.0
 * @author: Qinjin Peng
 * @date: Feb 12, 2011 10:35:50 AM
 */
public class CacheBean implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(��һ�仰�������������ʾʲô)
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ��ǰCache������
	 */
	private String type;
	private String code ;
	/**
	 * ��ΪSTATIC���͵�ʱ����Ϊkey_value��ֵ�����ʹ�ʩ����ʱ����Cacheʱ�������ȴӴ˴���
	 */
	private Map staticCache;

	/**
	 * ����ΪMETHOD��ʱ��ʹ��
	 */
	private CacheKeyBean cacheKey;
	/**
	 * ����ΪMETHOD��ʱ��ʹ��
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
