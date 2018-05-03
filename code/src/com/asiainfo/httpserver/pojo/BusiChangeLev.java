package com.asiainfo.httpserver.pojo;

public class BusiChangeLev {

	/*
	 * changeObj:变更对象， batchName：变更批次名称， batchCode：变更批次编码， levName：变更档次名称，
	 * levCode：变更档次编码， changeContent：变更内容
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
