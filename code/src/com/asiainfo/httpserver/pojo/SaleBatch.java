package com.asiainfo.httpserver.pojo;

import java.util.ArrayList;

public class SaleBatch {

	/**
	 * batchName:���������ơ�, batchCode:�����α��롯, beginTime:����ʼʱ�䡯, endTime:������ʱ�䡯,
	 * execArea:��ִ�з�Χ��, backGroup:��������, target:��Ŀ�ꡯ, description:��������,
	 * saleLevs:'�����'
	 */
	private String batchName;
	private String batchCode;
	private String beginTime;
	private String endTime;
	private String execArea;
	private String backGroup;
	private String target;
	private String description;
	private ArrayList<SaleLev> saleLevs;

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

	public String getExecArea() {
		return execArea;
	}

	public void setExecArea(String execArea) {
		this.execArea = execArea;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<SaleLev> getSaleLevs() {
		return saleLevs;
	}

	public void setSaleLevs(ArrayList<SaleLev> saleLevs) {
		this.saleLevs = saleLevs;
	}
}
