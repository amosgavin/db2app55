package com.asiainfo.httpserver.pojo;

import java.util.ArrayList;

public class BusiChangeInfo {

	/*
	 * proposer:�������ˡ�, orgName:�������˲��š�, orderName:����������, description:��������,
	 * items:������嵥��
	 */
	private String proposer;
	private String orgName;
	private String orderName;
	private String description;
	private ArrayList<BusiChangeLev> items;

	public String getProposer() {
		return proposer;
	}

	public void setProposer(String proposer) {
		this.proposer = proposer;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<BusiChangeLev> getItems() {
		return items;
	}

	public void setItems(ArrayList<BusiChangeLev> items) {
		this.items = items;
	}
}
