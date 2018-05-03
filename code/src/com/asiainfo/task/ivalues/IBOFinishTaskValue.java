package com.asiainfo.task.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOFinishTaskValue extends DataStructInterface{

  public final static  String S_ApplyName = "APPLY_NAME";
  public final static  String S_WorkflowObjectId = "WORKFLOW_OBJECT_ID";
  public final static  String S_OrgName = "ORG_NAME";
  public final static  String S_CreateStaffId = "CREATE_STAFF_ID";
  public final static  String S_Label = "LABEL";
  public final static  String S_TemplateTag = "TEMPLATE_TAG";
  public final static  String S_WorkflowObjectType = "WORKFLOW_OBJECT_TYPE";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_ObjectTypeName = "OBJECT_TYPE_NAME";
  public final static  String S_StaffName = "STAFF_NAME";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_WorkflowId = "WORKFLOW_ID";
  public final static  String S_Department = "DEPARTMENT";


public String getApplyName();

public String getWorkflowObjectId();

public String getOrgName();

public String getCreateStaffId();

public String getLabel();

public String getTemplateTag();

public String getWorkflowObjectType();

public String getRegionId();

public String getObjectTypeName();

public String getStaffName();

public Timestamp getCreateDate();

public String getWorkflowId();

public String getDepartment();


public  void setApplyName(String value);

public  void setWorkflowObjectId(String value);

public  void setOrgName(String value);

public  void setCreateStaffId(String value);

public  void setLabel(String value);

public  void setTemplateTag(String value);

public  void setWorkflowObjectType(String value);

public  void setRegionId(String value);

public  void setObjectTypeName(String value);

public  void setStaffName(String value);

public  void setCreateDate(Timestamp value);

public  void setWorkflowId(String value);

public  void setDepartment(String value);
}
