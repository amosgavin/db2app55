package com.ai.bce.valuebean;

import java.sql.Timestamp;
import java.util.Map;

import com.ai.bce.ivalues.IBceDealReturnData;
import com.ai.omframe.util.LocaleResourceFactory;

public class BceDealReturnDataBean implements IBceDealReturnData{

	private String[][] customProperty;
	private String isSuccess;
  private String errorMsg;
  private String successMsg;
  private String workflowCode;
  private String workflowObjectTypeId;
  private String workflowObjectId;
  private Map workflowParamMap;
  private Timestamp workflowStartTime;
  private String workflowNotes;
  private Map proessRetrunMap;
  
  private String errorKey ;
  private Object[] errorParams;
  public String[][] getCustomProperty() {
		return customProperty;
	}

	public void setCustomProperty(String[][] customProperty) {
		this.customProperty = customProperty;
	}

	public String getWorkflowNotes() {
		return workflowNotes;
	}

	public void setWorkflowNotes(String workflowNotes) {
		this.workflowNotes = workflowNotes;
	}

	public String getIsSuccess() {
      return isSuccess;
  }

  public void setIsSuccess(String newIsSuccess) {
      isSuccess = newIsSuccess;
  }

  public String getErrorMsg() {
      return errorMsg;
  }

  public void setErrorMsg(String newErrorMsg) {
      errorMsg = newErrorMsg;
  }

  public String getSuccessMsg() {
      return successMsg;
  }

  public void setSuccessMsg(String successMsg) {
      this.successMsg = successMsg;
  }

	public String getWorkflowCode() {
		return workflowCode;
	}

	public void setWorkflowCode(String workflowCode) {
		this.workflowCode = workflowCode;
	}

	public String getWorkflowObjectId() {
		return workflowObjectId;
	}

	public void setWorkflowObjectId(String workflowObjectId) {
		this.workflowObjectId = workflowObjectId;
	}

	public String getWorkflowObjectTypeId() {
		return workflowObjectTypeId;
	}

	public void setWorkflowObjectTypeId(String workflowObjectTypeId) {
		this.workflowObjectTypeId = workflowObjectTypeId;
	}

	public Map getWorkflowParamMap() {
		return workflowParamMap;
	}

	public void setWorkflowParamMap(Map workflowParamMap) {
		this.workflowParamMap = workflowParamMap;
	}

	public Timestamp getWorkflowStartTime() {
		return workflowStartTime;
	}

	public void setWorkflowStartTime(Timestamp workflowStartTime) {
		this.workflowStartTime = workflowStartTime;
	}

	public Map getProcessReturnMap() {
		// TODO Auto-generated method stub
		return this.proessRetrunMap;
	}

	public void setProcessReturnMap(Map map) {
		// TODO Auto-generated method stub
		this.proessRetrunMap = map;
	}

	
	public void setErrorMsgByKey(String key, Object[] params) {
		// TODO Auto-generated method stub
		this.errorKey  = key;
		this.errorParams = params;
		this.errorMsg = LocaleResourceFactory.getResource(key,params);
	}



	

	
	public Object[] getErrorMsgParams() {
		// TODO Auto-generated method stub
		return this.errorParams;
	}

	public void setErrorMsgKey(String key) {
		// TODO Auto-generated method stub
		this.errorKey  = key;
		this.errorMsg = LocaleResourceFactory.getResource(key);
	}

	
	public String getErrorMsgKey() {
		// TODO Auto-generated method stub
		return this.errorKey;
	}

	
	public void setErrorMsgByKey(String key) {
		// TODO Auto-generated method stub
		this.errorKey  = key;
		this.errorMsg = LocaleResourceFactory.getResource(key);
		
	}

	
}
