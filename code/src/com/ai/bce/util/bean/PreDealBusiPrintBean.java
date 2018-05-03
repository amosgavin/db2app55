package com.ai.bce.util.bean;

import java.io.Serializable;

import javax.servlet.http.HttpUtils;

public class PreDealBusiPrintBean implements Serializable {
	private String billId;
	private String buinessId;
	private Object busiObject;
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public String getBuinessId() {
		return buinessId;
	}
	public void setBuinessId(String buinessId) {
		this.buinessId = buinessId;
	}
	public Object getBusiObject() {
		return busiObject;
	}
	public void setBusiObject(Object busiObject) {
		this.busiObject = busiObject;
	}
}
