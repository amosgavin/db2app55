package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceRulesetValue extends DataStructInterface{

  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_RulesetId = "RULESET_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_RulesetType = "RULESET_TYPE";

  public  Long  getModuleIdAsLong();

public long getModuleId();


  public  Integer  getStateAsInteger();

public int getState();


  public  Long  getRulesetIdAsLong();

public long getRulesetId();



public String getRemarks();


  public  Integer  getRulesetTypeAsInteger();

public int getRulesetType();




  public  void setModuleId(Long value);

public  void setModuleId(long value);



  public  void setState(Integer value);

public  void setState(int value);



  public  void setRulesetId(Long value);

public  void setRulesetId(long value);




public  void setRemarks(String value);



  public  void setRulesetType(Integer value);

public  void setRulesetType(int value);


}
