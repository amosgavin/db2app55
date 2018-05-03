package com.asiainfo.task.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOCurCountTaskValue extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_TaskTemplateId = "TASK_TEMPLATE_ID";
  public final static  String S_Tlabel = "TLABEL";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_StationId = "STATION_ID";
  public final static  String S_ErrorMessage = "ERROR_MESSAGE";
  public final static  String S_TaskId = "TASK_ID";
  public final static  String S_FinishDate = "FINISH_DATE";
  public final static  String S_TaskDate = "TASK_DATE";
  public final static  String S_TaskType = "TASK_TYPE";
  public final static  String S_WorkflowId = "WORKFLOW_ID";
  public final static  String S_FinishStaffId = "FINISH_STAFF_ID";
  public final static  String S_TaskTag = "TASK_TAG";
  public final static  String S_TaskStaffId = "TASK_STAFF_ID";


public long getState();

public long getTaskTemplateId();

public String getTlabel();

public String getDescription();

public String getStationId();

public String getErrorMessage();

public String getTaskId();

public Timestamp getFinishDate();

public Timestamp getTaskDate();

public String getTaskType();

public String getWorkflowId();

public String getFinishStaffId();

public String getTaskTag();

public String getTaskStaffId();


public  void setState(long value);

public  void setTaskTemplateId(long value);

public  void setTlabel(String value);

public  void setDescription(String value);

public  void setStationId(String value);

public  void setErrorMessage(String value);

public  void setTaskId(String value);

public  void setFinishDate(Timestamp value);

public  void setTaskDate(Timestamp value);

public  void setTaskType(String value);

public  void setWorkflowId(String value);

public  void setFinishStaffId(String value);

public  void setTaskTag(String value);

public  void setTaskStaffId(String value);
}
