package com.ai.bce.util.bean;

import java.io.Serializable;
/**
 * 
 * 
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: AI(NanJing)</p>
 * @author Qinjin Peng
 * @version 2.0
 */
public class BceConfigItemBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String itemKind ;
	private String itemKey;
	private String itemValue;
	
	
	/**
	 * ¹¹Ôìº¯Êý
	 */
	public BceConfigItemBean() {
		super();
	}
	
	/**
	 * 
	 * @param itemKind
	 * @param itemKey
	 * @param itemValue
	 */
	public BceConfigItemBean(String itemKind, String itemKey, String itemValue) {
		super();
		this.itemKind = itemKind;
		this.itemKey = itemKey;
		this.itemValue = itemValue;
	}
	/**
	 * @return the itemKind
	 */
	public String getItemKind() {
		return itemKind;
	}
	/**
	 * @param itemKind the itemKind to set
	 */
	public void setItemKind(String itemKind) {
		this.itemKind = itemKind;
	}
	/**
	 * @return the itemKey
	 */
	public String getItemKey() {
		return itemKey;
	}
	/**
	 * @param itemKey the itemKey to set
	 */
	public void setItemKey(String itemKey) {
		this.itemKey = itemKey;
	}
	/**
	 * @return the itemValue
	 */
	public String getItemValue() {
		return itemValue;
	}
	/**
	 * @param itemValue the itemValue to set
	 */
	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}
	
	
	
}
