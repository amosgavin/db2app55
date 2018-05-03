package com.asiainfo.httpserver.pojo;

public class TaskInfo {

	/**
	 * currentStage:'当前环节', corporation:'单位', orgName:'部门',
	 * receiveStaff:'任务接受人', dealStaff:'处理人', decision:'审核', nextStap:'经办选择',
	 * description:'意见', state:'状态', taskReceiveDate:'接收时间',
	 * taskFinishDate:'完成时间'
	 */
	
	private String currentStage;
	private String corporation;
	private String orgName;
	private String receiveStaff;
	private String dealStaff;
	private String decision;
	private String nextStap;
	private String description;
	private String state;
	private String taskReceiveDate;
	private String taskFinishDate;

	public String getCurrentStage() {
		return currentStage;
	}

	public void setCurrentStage(String currentStage) {
		this.currentStage = currentStage;
	}

	public String getCorporation() {
		return corporation;
	}

	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getReceiveStaff() {
		return receiveStaff;
	}

	public void setReceiveStaff(String receiveStaff) {
		this.receiveStaff = receiveStaff;
	}

	public String getDealStaff() {
		return dealStaff;
	}

	public void setDealStaff(String dealStaff) {
		this.dealStaff = dealStaff;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public String getNextStap() {
		return nextStap;
	}

	public void setNextStap(String nextStap) {
		this.nextStap = nextStap;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTaskReceiveDate() {
		return taskReceiveDate;
	}

	public void setTaskReceiveDate(String taskReceiveDate) {
		this.taskReceiveDate = taskReceiveDate;
	}

	public String getTaskFinishDate() {
		return taskFinishDate;
	}

	public void setTaskFinishDate(String taskFinishDate) {
		this.taskFinishDate = taskFinishDate;
	}
}
