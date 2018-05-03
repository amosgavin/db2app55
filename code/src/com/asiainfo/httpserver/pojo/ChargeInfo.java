package com.asiainfo.httpserver.pojo;

import java.util.ArrayList;

public class ChargeInfo {

	/**
	 * 
	 chargeType:'�ʷ�����', market:'ϸ���г�', brand:'Ʒ��', beginTime:'��ʼʱ��',
	 * endTime:'����ʱ��', chargeName:'�ʷѹ�������', extendChennel:'�ƹ�����', flack:'�����ں�',
	 * backGroup:'����', target:'Ŀ��', chargeLev:'�����'
	 */

	private String chargeType;
	private String market;
	private String brand;
	private String beginTime;
	private String endTime;
	private String chargeName;
	private String extendChennel;
	private String flack;
	private String backGroup;
	private String target;
	private ArrayList<ChargeLev> chargeLev;

	public String getChargeType() {
		return chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getChargeName() {
		return chargeName;
	}

	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
	}

	public String getExtendChennel() {
		return extendChennel;
	}

	public void setExtendChennel(String extendChennel) {
		this.extendChennel = extendChennel;
	}

	public String getFlack() {
		return flack;
	}

	public void setFlack(String flack) {
		this.flack = flack;
	}

	public String getBackGroup() {
		return backGroup;
	}

	public void setBackGroup(String backGroup) {
		this.backGroup = backGroup;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public ArrayList<ChargeLev> getChargeLev() {
		return chargeLev;
	}

	public void setChargeLev(ArrayList<ChargeLev> chargeLev) {
		this.chargeLev = chargeLev;
	}
}
