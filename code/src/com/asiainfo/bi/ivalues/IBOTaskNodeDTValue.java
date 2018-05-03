package com.asiainfo.bi.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOTaskNodeDTValue extends DataStructInterface{

  public final static  String S_DiffDay = "DIFF_DAY";
  public final static  String S_WorkflowObjectId = "WORKFLOW_OBJECT_ID";
  public final static  String S_Tlabel = "TLABEL";
  public final static  String S_WfName = "WF_NAME";
  public final static  String S_DelayReason = "DELAY_REASON";
  public final static  String S_WorkflowObjectType = "WORKFLOW_OBJECT_TYPE";
  public final static  String S_IsDelay = "IS_DELAY";
  public final static  String S_ApproveFlag = "APPROVE_FLAG";
  public final static  String S_AdviseDealTime = "ADVISE_DEAL_TIME";
  public final static  String S_StaffName = "STAFF_NAME";
  public final static  String S_TaskEndTime = "TASK_END_TIME";
  public final static  String S_TaskRecTime = "TASK_REC_TIME";
  public final static  String S_TaskTag = "TASK_TAG";
  public final static  String S_TaskStaffId = "TASK_STAFF_ID";


public long getDiffDay();

public String getWorkflowObjectId();

public String getTlabel();

public String getWfName();

public String getDelayReason();

public String getWorkflowObjectType();

public long getIsDelay();

public String getApproveFlag();

public Timestamp getAdviseDealTime();

public String getStaffName();

public Timestamp getTaskEndTime();

public Timestamp getTaskRecTime();

public String getTaskTag();

public String getTaskStaffId();


public  void setDiffDay(long value);

public  void setWorkflowObjectId(String value);

public  void setTlabel(String value);

public  void setWfName(String value);

public  void setDelayReason(String value);

public  void setWorkflowObjectType(String value);

public  void setIsDelay(long value);

public  void setApproveFlag(String value);

public  void setAdviseDealTime(Timestamp value);

public  void setStaffName(String value);

public  void setTaskEndTime(Timestamp value);

public  void setTaskRecTime(Timestamp value);

public  void setTaskTag(String value);

public  void setTaskStaffId(String value);
}
