package com.asiainfo.task.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOVmTaskTsValue extends DataStructInterface{

  public final static  String S_LockStaffId = "LOCK_STAFF_ID";
  public final static  String S_DecisionResult = "DECISION_RESULT";
  public final static  String S_State = "STATE";
  public final static  String S_TaskBaseType = "TASK_BASE_TYPE";
  public final static  String S_StateDate = "STATE_DATE";
  public final static  String S_WarningTimes = "WARNING_TIMES";
  public final static  String S_TaskId = "TASK_ID";
  public final static  String S_FinishDate = "FINISH_DATE";
  public final static  String S_QueueId = "QUEUE_ID";
  public final static  String S_TaskType = "TASK_TYPE";
  public final static  String S_DestTaskTemplateId = "DEST_TASK_TEMPLATE_ID";
  public final static  String S_WorkflowId = "WORKFLOW_ID";
  public final static  String S_Duration = "DURATION";
  public final static  String S_TaskStaffId = "TASK_STAFF_ID";
  public final static  String S_WarningDate = "WARNING_DATE";
  public final static  String S_ParentTaskId = "PARENT_TASK_ID";
  public final static  String S_TaskTemplateId = "TASK_TEMPLATE_ID";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_StationId = "STATION_ID";
  public final static  String S_DestType = "DEST_TYPE";
  public final static  String S_Label = "LABEL";
  public final static  String S_IsCurrentTask = "IS_CURRENT_TASK";
  public final static  String S_ErrorMessage = "ERROR_MESSAGE";
  public final static  String S_LockDate = "LOCK_DATE";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_FinishStaffId = "FINISH_STAFF_ID";
  public final static  String S_TaskTag = "TASK_TAG";


public String getLockStaffId();

public String getDecisionResult();

public int getState();

public String getTaskBaseType();

public Timestamp getStateDate();

public int getWarningTimes();

public String getTaskId();

public Timestamp getFinishDate();

public String getQueueId();

public String getTaskType();

public long getDestTaskTemplateId();

public String getWorkflowId();

public long getDuration();

public String getTaskStaffId();

public Timestamp getWarningDate();

public String getParentTaskId();

public long getTaskTemplateId();

public String getDescription();

public String getStationId();

public String getDestType();

public String getLabel();

public String getIsCurrentTask();

public String getErrorMessage();

public Timestamp getLockDate();

public String getRegionId();

public Timestamp getCreateDate();

public String getFinishStaffId();

public String getTaskTag();


public  void setLockStaffId(String value);

public  void setDecisionResult(String value);

public  void setState(int value);

public  void setTaskBaseType(String value);

public  void setStateDate(Timestamp value);

public  void setWarningTimes(int value);

public  void setTaskId(String value);

public  void setFinishDate(Timestamp value);

public  void setQueueId(String value);

public  void setTaskType(String value);

public  void setDestTaskTemplateId(long value);

public  void setWorkflowId(String value);

public  void setDuration(long value);

public  void setTaskStaffId(String value);

public  void setWarningDate(Timestamp value);

public  void setParentTaskId(String value);

public  void setTaskTemplateId(long value);

public  void setDescription(String value);

public  void setStationId(String value);

public  void setDestType(String value);

public  void setLabel(String value);

public  void setIsCurrentTask(String value);

public  void setErrorMessage(String value);

public  void setLockDate(Timestamp value);

public  void setRegionId(String value);

public  void setCreateDate(Timestamp value);

public  void setFinishStaffId(String value);

public  void setTaskTag(String value);
}
