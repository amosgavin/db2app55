package com.asiainfo.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOAuditInfoShowValue extends DataStructInterface{

  public final static  String S_DecisionResult = "DECISION_RESULT";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Label = "LABEL";
  public final static  String S_StaffName = "STAFF_NAME";
  public final static  String S_Depart = "DEPART";
  public final static  String S_Org = "ORG";


public String getDecisionResult();

public String getDescription();

public String getLabel();

public String getStaffName();

public String getDepart();

public String getOrg();


public  void setDecisionResult(String value);

public  void setDescription(String value);

public  void setLabel(String value);

public  void setStaffName(String value);

public  void setDepart(String value);

public  void setOrg(String value);
}
