package com.asiainfo.httpserver.pojo;

import java.util.ArrayList;

public class SaleInfo {

	/**
	 * proposer:�������ˡ�, orgName:�������˲��š�, orderName:����������, saleBatch:'�����'
	 */

	private String proposer;
	private String orgName;
	private String orderName;
	private ArrayList<SaleBatch> saleBatch;

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

	public ArrayList<SaleBatch> getSaleBatch() {
		return saleBatch;
	}

	public void setSaleBatch(ArrayList<SaleBatch> saleBatch) {
		this.saleBatch = saleBatch;
	}

}
