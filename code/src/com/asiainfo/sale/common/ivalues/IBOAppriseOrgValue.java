package com.asiainfo.sale.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IBOAppriseOrgValue extends DataStructInterface{

  public final static  String S_Id = "ID";
  public final static  String S_OrgStr = "ORG_STR";
  public final static  String S_WorkflowId = "WORKFLOW_ID";


public int getId();

public String getOrgStr();

public String getWorkflowId();


public  void setId(int value);

public  void setOrgStr(String value);

public  void setWorkflowId(String value);
}
