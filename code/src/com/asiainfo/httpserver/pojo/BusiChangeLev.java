package com.asiainfo.httpserver.pojo;

public class BusiChangeLev {

	/*
	 * changeObj:������� batchName������������ƣ� batchCode��������α��룬 levName������������ƣ�
	 * levCode��������α��룬 changeContent���������
	 */
	private String changeObj;
	private String batchName;
	private String batchCode;
	private String levName;
	private String levCode;
	private String changeContent;

	public String getChangeObj() {
		return changeObj;
	}

	public void setChangeObj(String changeObj) {
		this.changeObj = changeObj;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getBatchCode() {
		return batchCode;
	}

	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}

	public String getLevName() {
		return levName;
	}

	public void setLevName(String levName) {
		this.levName = levName;
	}

	public String getLevCode() {
		return levCode;
	}

	public void setLevCode(String levCode) {
		this.levCode = levCode;
	}

	public String getChangeContent() {
		return changeContent;
	}

	public void setChangeContent(String changeContent) {
		this.changeContent = changeContent;
	}
}
