package com.asiainfo.task.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOHistoryTaskValue extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_WorkflowObjectId = "WORKFLOW_OBJECT_ID";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_OrgName = "ORG_NAME";
  public final static  String S_CreateStaffId = "CREATE_STAFF_ID";
  public final static  String S_TaskId = "TASK_ID";
  public final static  String S_FinishDate = "FINISH_DATE";
  public final static  String S_CreateCorporation = "CREATE_CORPORATION";
  public final static  String S_StateName = "STATE_NAME";
  public final static  String S_ObjectTypeName = "OBJECT_TYPE_NAME";
  public final static  String S_StaffName = "STAFF_NAME";
  public final static  String S_WorkflowId = "WORKFLOW_ID";
  public final static  String S_Corporation = "CORPORATION";
  public final static  String S_TaskStaffId = "TASK_STAFF_ID";
  public final static  String S_ApplyName = "APPLY_NAME";
  public final static  String S_Tlabel = "TLABEL";
  public final static  String S_TaskTemplateId = "TASK_TEMPLATE_ID";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_StationId = "STATION_ID";
  public final static  String S_TemplateTag = "TEMPLATE_TAG";
  public final static  String S_Label = "LABEL";
  public final static  String S_WorkflowObjectType = "WORKFLOW_OBJECT_TYPE";
  public final static  String S_ErrorMessage = "ERROR_MESSAGE";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_TaskStaffName = "TASK_STAFF_NAME";
  public final static  String S_TaskDate = "TASK_DATE";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_FinishStaffId = "FINISH_STAFF_ID";
  public final static  String S_CreateStaffName = "CREATE_STAFF_NAME";
  public final static  String S_TaskTag = "TASK_TAG";


public long getState();

public String getWorkflowObjectId();

public Timestamp getCreateTime();

public String getOrgName();

public String getCreateStaffId();

public String getTaskId();

public Timestamp getFinishDate();

public String getCreateCorporation();

public String getStateName();

public String getObjectTypeName();

public String getStaffName();

public String getWorkflowId();

public String getCorporation();

public String getTaskStaffId();

public String getApplyName();

public String getTlabel();

public long getTaskTemplateId();

public String getDescription();

public String getStationId();

public String getTemplateTag();

public String getLabel();

public String getWorkflowObjectType();

public String getErrorMessage();

public String getRegionId();

public String getTaskStaffName();

public Timestamp getTaskDate();

public Timestamp getCreateDate();

public String getFinishStaffId();

public String getCreateStaffName();

public String getTaskTag();


public  void setState(long value);

public  void setWorkflowObjectId(String value);

public  void setCreateTime(Timestamp value);

public  void setOrgName(String value);

public  void setCreateStaffId(String value);

public  void setTaskId(String value);

public  void setFinishDate(Timestamp value);

public  void setCreateCorporation(String value);

public  void setStateName(String value);

public  void setObjectTypeName(String value);

public  void setStaffName(String value);

public  void setWorkflowId(String value);

public  void setCorporation(String value);

public  void setTaskStaffId(String value);

public  void setApplyName(String value);

public  void setTlabel(String value);

public  void setTaskTemplateId(long value);

public  void setDescription(String value);

public  void setStationId(String value);

public  void setTemplateTag(String value);

public  void setLabel(String value);

public  void setWorkflowObjectType(String value);

public  void setErrorMessage(String value);

public  void setRegionId(String value);

public  void setTaskStaffName(String value);

public  void setTaskDate(Timestamp value);

public  void setCreateDate(Timestamp value);

public  void setFinishStaffId(String value);

public  void setCreateStaffName(String value);

public  void setTaskTag(String value);
}
