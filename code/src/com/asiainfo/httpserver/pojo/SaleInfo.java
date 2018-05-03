package com.asiainfo.httpserver.pojo;

import java.util.ArrayList;

public class SaleInfo {

	/**
	 * proposer:’申请人’, orgName:’申请人部门’, orderName:’工单名’, saleBatch:'活动批次'
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
