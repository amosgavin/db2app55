package com.asiainfo.httpserver.pojo;

public class WfInfo {

	/**
	 * orgName:'������λ', proposer:'������', orderId:'�������', orderType:'��������',
	 * templateCode:����ģ����롯, orderName:'��������', currentStage:'��ǰ����',
	 * taskId:������id�� cfStaff:'������Ա', testStaff:'������Ա', createTime:'������������',
	 * receiveTime:'����ʱ��'
	 **/

	private String orgName;
	private String proposer;
	private String orderId;
	private String orderType;
	private String templateCode;
	private String taskTemplateId;
	private String orderName;
	private String currentStage;
	private String workflowId;
	private String taskId;
	private String cfStaff;
	private String testStaff;
	private String createTime;
	private String receiveTime;

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getProposer() {
		return proposer;
	}

	public void setProposer(String proposer) {
		this.proposer = proposer;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getCurrentStage() {
		return currentStage;
	}

	public void setCurrentStage(String currentStage) {
		this.currentStage = currentStage;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getCfStaff() {
		return cfStaff;
	}

	public void setCfStaff(String cfStaff) {
		this.cfStaff = cfStaff;
	}

	public String getTestStaff() {
		return testStaff;
	}

	public void setTestStaff(String testStaff) {
		this.testStaff = testStaff;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}

	public void setTaskTemplateId(String taskTemplateId) {
		this.taskTemplateId = taskTemplateId;
	}

	public String getTaskTemplateId() {
		return taskTemplateId;
	}

	public String getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}
}
