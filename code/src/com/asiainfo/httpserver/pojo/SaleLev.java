package com.asiainfo.httpserver.pojo;

public class SaleLev {

	/**
	 * levName:����������, levType:���������͡�, levCode:�����α��롯, levDes:������������,
	 * weaponDes:������������
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
