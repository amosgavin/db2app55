package com.asiainfo.httpserver.pojo;

public class ChargeLev {

	/**
	 * chargeLevName:'资费名称', chargeLevCode:'系统生成编码',
	 * chargeLevBossCode:'boss回填编码’, feePerMon:'月使用费', chargeLevDesc:'套餐信息'
	 */
	
	private String chargeLevName;
	private String chargeLevCode;
	private String chargeLevBossCode;
	private String feePerMon;
	private String chargeLevDesc;

	public String getChargeLevName() {
		return chargeLevName;
	}

	public void setChargeLevName(String chargeLevName) {
		this.chargeLevName = chargeLevName;
	}

	public String getChargeLevCode() {
		return chargeLevCode;
	}

	public void setChargeLevCode(String chargeLevCode) {
		this.chargeLevCode = chargeLevCode;
	}

	public String getChargeLevBossCode() {
		return chargeLevBossCode;
	}

	public void setChargeLevBossCode(String chargeLevBossCode) {
		this.chargeLevBossCode = chargeLevBossCode;
	}

	public String getFeePerMon() {
		return feePerMon;
	}

	public void setFeePerMon(String feePerMon) {
		this.feePerMon = feePerMon;
	}

	public String getChargeLevDesc() {
		return chargeLevDesc;
	}

	public void setChargeLevDesc(String chargeLevDesc) {
		this.chargeLevDesc = chargeLevDesc;
	}

}
