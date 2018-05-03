package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceWorkflowValue extends DataStructInterface{

  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_OfferId = "OFFER_ID";
  public final static  String S_BceWorkflowId = "BCE_WORKFLOW_ID";
  public final static  String S_ProdSpecId = "PROD_SPEC_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_WorkflowCode = "WORKFLOW_CODE";
  public final static  String S_BusinessId = "BUSINESS_ID";


public long getModuleId();

public int getState();

public long getOfferId();

public long getBceWorkflowId();

public long getProdSpecId();

public String getRemarks();

public String getWorkflowCode();

public long getBusinessId();


public  void setModuleId(long value);

public  void setState(int value);

public  void setOfferId(long value);

public  void setBceWorkflowId(long value);

public  void setProdSpecId(long value);

public  void setRemarks(String value);

public  void setWorkflowCode(String value);

public  void setBusinessId(long value);
}
