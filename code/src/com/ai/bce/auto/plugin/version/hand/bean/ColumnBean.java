package com.ai.bce.auto.plugin.version.hand.bean;

import java.io.Serializable;

public class ColumnBean implements Serializable{
	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;
	/**
	 * 表字段名称
	 */
	private String clomnName;
	/**
	 * 约定类型
	 */
	private String valueType;
	/**
	 * 旧值
	 */
	private String oldValue;
	/**
	 * 新值 （注意时间日期格式）
	 */
	private String newValue;
	/**
	 * 是否是PK
	 */
	private boolean isPk;

	public String toString() {
		// TODO Auto-generated method stub
		return "{clomnName " + clomnName + " } {valueType " + valueType
				+ "} {oldValue " + oldValue + "}{newValue " + newValue
				+ "} {isPk " + isPk + "}";
	}

	public boolean isPk() {
		return isPk;
	}

	public void setPk(boolean isPk) {
		this.isPk = isPk;
	}

	public String getClomnName() {
		return clomnName;
	}

	public void setClomnName(String clomnName) {
		this.clomnName = clomnName;
	}

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

}
