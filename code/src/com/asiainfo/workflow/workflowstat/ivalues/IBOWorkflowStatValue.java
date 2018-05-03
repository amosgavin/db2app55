package com.asiainfo.workflow.workflowstat.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOWorkflowStatValue extends DataStructInterface{

  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_WorkflowObjectId = "WORKFLOW_OBJECT_ID";
  public final static  String S_StaffId = "STAFF_ID";
  public final static  String S_Label = "LABEL";
  public final static  String S_StaffName = "STAFF_NAME";
  public final static  String S_WorkflowObjectType = "WORKFLOW_OBJECT_TYPE";
  public final static  String S_TaskId = "TASK_ID";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_WorkflowId = "WORKFLOW_ID";


public String getRegionId();

public String getWorkflowObjectId();

public String getStaffId();

public String getLabel();

public String getStaffName();

public String getWorkflowObjectType();

public String getTaskId();

public Timestamp getCreateDate();

public String getWorkflowId();


public  void setRegionId(String value);

public  void setWorkflowObjectId(String value);

public  void setStaffId(String value);

public  void setLabel(String value);

public  void setStaffName(String value);

public  void setWorkflowObjectType(String value);

public  void setTaskId(String value);

public  void setCreateDate(Timestamp value);

public  void setWorkflowId(String value);
}
