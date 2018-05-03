package com.asiainfo.sale.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOAppriseTaskValue extends DataStructInterface{

  public final static  String S_ApplyName = "APPLY_NAME";
  public final static  String S_OrganizeName = "ORGANIZE_NAME";
  public final static  String S_SendTime = "SEND_TIME";
  public final static  String S_WorkflowObjectType = "WORKFLOW_OBJECT_TYPE";
  public final static  String S_IsReaded = "IS_READED";
  public final static  String S_ReadTime = "READ_TIME";
  public final static  String S_TaskId = "TASK_ID";
  public final static  String S_Depart = "DEPART";
  public final static  String S_TaskLabel = "TASK_LABEL";
  public final static  String S_DealTime = "DEAL_TIME";
  public final static  String S_Aid = "AID";
  public final static  String S_StaffName = "STAFF_NAME";
  public final static  String S_AppriseFlag = "APPRISE_FLAG";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_WorkflowId = "WORKFLOW_ID";
  public final static  String S_WfLabel = "WF_LABEL";


public String getApplyName();

public String getOrganizeName();

public Timestamp getSendTime();

public String getWorkflowObjectType();

public String getIsReaded();

public Timestamp getReadTime();

public String getTaskId();

public String getDepart();

public String getTaskLabel();

public Timestamp getDealTime();

public long getAid();

public String getStaffName();

public String getAppriseFlag();

public Timestamp getCreateDate();

public String getWorkflowId();

public String getWfLabel();


public  void setApplyName(String value);

public  void setOrganizeName(String value);

public  void setSendTime(Timestamp value);

public  void setWorkflowObjectType(String value);

public  void setIsReaded(String value);

public  void setReadTime(Timestamp value);

public  void setTaskId(String value);

public  void setDepart(String value);

public  void setTaskLabel(String value);

public  void setDealTime(Timestamp value);

public  void setAid(long value);

public  void setStaffName(String value);

public  void setAppriseFlag(String value);

public  void setCreateDate(Timestamp value);

public  void setWorkflowId(String value);

public  void setWfLabel(String value);
}
