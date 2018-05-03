package com.ai.bce.auto.plugin.cache.bean;

import java.io.Serializable;
import java.util.List;

public class CacheValueBean implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	private String type;

	private String enginName;

	private List caches;
	private String whereSql;
	private boolean isUseSql;
	

	public boolean isUseSql() {
		return isUseSql;
	}

	public void setUseSql(boolean isUseSql) {
		this.isUseSql = isUseSql;
	}

	public String getWhereSql() {
		return whereSql;
	}

	public void setWhereSql(String whereSql) {
		this.whereSql = whereSql;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEnginName() {
		return enginName;
	}

	public void setEnginName(String enginName) {
		this.enginName = enginName;
	}

	public List getCaches() {
		return caches;
	}

	public void setCaches(List caches) {
		this.caches = caches;
	}

}
