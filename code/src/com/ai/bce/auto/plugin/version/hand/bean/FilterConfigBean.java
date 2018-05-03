package com.ai.bce.auto.plugin.version.hand.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * ������Ϣ
 * <p>
 * Copyright (c) 2010 Asiainfo-Linkage
 * </p>
 * 
 * @ClassName: FilterConfigBean.java
 * @Description: ����Ĺ�������
 * 
 * @version: v1.0.0
 * @author: Qinjin Peng
 * @date: Feb 21, 2011 10:09:39 AM
 */
public class FilterConfigBean implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(��һ�仰�������������ʾʲô)
	 */
	private static final long serialVersionUID = -4031913834318173368L;

	private String formateDateType;
	private Map filterClassMapping = new HashMap();

	public String getFormateDateType() {
		return formateDateType;
	}

	public void setFormateDateType(String formateDateType) {
		this.formateDateType = formateDateType;
	}

	public Map getFilterClassMapping() {
		return filterClassMapping;
	}

	public void setFilterClassMapping(Map filterClassMapping) {
		this.filterClassMapping = filterClassMapping;
	};
}
