package com.asiainfo.sale.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOWorkflowInfoValue extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_WorkflowObjectId = "WORKFLOW_OBJECT_ID";
  public final static  String S_CreateStaffId = "CREATE_STAFF_ID";
  public final static  String S_EngineWorkflowId = "ENGINE_WORKFLOW_ID";
  public final static  String S_StateDate = "STATE_DATE";
  public final static  String S_WarningTimes = "WARNING_TIMES";
  public final static  String S_TaskId = "TASK_ID";
  public final static  String S_FinishDate = "FINISH_DATE";
  public final static  String S_Vars = "VARS";
  public final static  String S_QueueId = "QUEUE_ID";
  public final static  String S_EngineType = "ENGINE_TYPE";
  public final static  String S_TemplateVersionId = "TEMPLATE_VERSION_ID";
  public final static  String S_WorkflowKind = "WORKFLOW_KIND";
  public final static  String S_WorkflowId = "WORKFLOW_ID";
  public final static  String S_Duration = "DURATION";
  public final static  String S_WarningDate = "WARNING_DATE";
  public final static  String S_ParentTaskId = "PARENT_TASK_ID";
  public final static  String S_UserTaskCount = "USER_TASK_COUNT";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Label = "LABEL";
  public final static  String S_CurrentTaskId = "CURRENT_TASK_ID";
  public final static  String S_TemplateTag = "TEMPLATE_TAG";
  public final static  String S_WorkflowObjectType = "WORKFLOW_OBJECT_TYPE";
  public final static  String S_ErrorMessage = "ERROR_MESSAGE";
  public final static  String S_SuspendState = "SUSPEND_STATE";
  public final static  String S_WorkflowType = "WORKFLOW_TYPE";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_StartDate = "START_DATE";
  public final static  String S_OpStaffId = "OP_STAFF_ID";
  public final static  String S_ErrorCount = "ERROR_COUNT";
  public final static  String S_CreateDate = "CREATE_DATE";


public long getState();

public String getWorkflowObjectId();

public String getCreateStaffId();

public String getEngineWorkflowId();

public Timestamp getStateDate();

public long getWarningTimes();

public String getTaskId();

public Timestamp getFinishDate();

public String getVars();

public String getQueueId();

public String getEngineType();

public long getTemplateVersionId();

public long getWorkflowKind();

public String getWorkflowId();

public long getDuration();

public Timestamp getWarningDate();

public String getParentTaskId();

public long getUserTaskCount();

public String getDescription();

public String getLabel();

public String getCurrentTaskId();

public String getTemplateTag();

public String getWorkflowObjectType();

public String getErrorMessage();

public long getSuspendState();

public String getWorkflowType();

public String getRegionId();

public Timestamp getStartDate();

public String getOpStaffId();

public long getErrorCount();

public Timestamp getCreateDate();


public  void setState(long value);

public  void setWorkflowObjectId(String value);

public  void setCreateStaffId(String value);

public  void setEngineWorkflowId(String value);

public  void setStateDate(Timestamp value);

public  void setWarningTimes(long value);

public  void setTaskId(String value);

public  void setFinishDate(Timestamp value);

public  void setVars(String value);

public  void setQueueId(String value);

public  void setEngineType(String value);

public  void setTemplateVersionId(long value);

public  void setWorkflowKind(long value);

public  void setWorkflowId(String value);

public  void setDuration(long value);

public  void setWarningDate(Timestamp value);

public  void setParentTaskId(String value);

public  void setUserTaskCount(long value);

public  void setDescription(String value);

public  void setLabel(String value);

public  void setCurrentTaskId(String value);

public  void setTemplateTag(String value);

public  void setWorkflowObjectType(String value);

public  void setErrorMessage(String value);

public  void setSuspendState(long value);

public  void setWorkflowType(String value);

public  void setRegionId(String value);

public  void setStartDate(Timestamp value);

public  void setOpStaffId(String value);

public  void setErrorCount(long value);

public  void setCreateDate(Timestamp value);
}
