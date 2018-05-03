package com.asiainfo.httpserver.pojo;

public class SaleLev {

	/**
	 * levName:’档次名’, levType:’档次类型’, levCode:’档次编码’, levDes:’档次描述’,
	 * weaponDes:’关联武器’
	 */
	private String levName;
	private String levType;
	private String levCode;
	private String levDes;
	private String weaponDes;

	public String getLevName() {
		return levName;
	}

	public void setLevName(String levName) {
		this.levName = levName;
	}

	public String getLevType() {
		return levType;
	}

	public void setLevType(String levType) {
		this.levType = levType;
	}

	public String getLevCode() {
		return levCode;
	}

	public void setLevCode(String levCode) {
		this.levCode = levCode;
	}

	public String getLevDes() {
		return levDes;
	}

	public void setLevDes(String levDes) {
		this.levDes = levDes;
	}

	public String getWeaponDes() {
		return weaponDes;
	}

	public void setWeaponDes(String weaponDes) {
		this.weaponDes = weaponDes;
	}
}
