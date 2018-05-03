package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IQBOBceRuleRulesetValue extends DataStructInterface{

  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_RulesetId = "RULESET_ID";
  public final static  String S_Remarks = "REMARKS";

  public  Long  getModuleIdAsLong();

public long getModuleId();


  public  Long  getStateAsLong();

public long getState();


  public  Long  getRulesetIdAsLong();

public long getRulesetId();



public String getRemarks();




  public  void setModuleId(Long value);

public  void setModuleId(long value);



  public  void setState(Long value);

public  void setState(long value);



  public  void setRulesetId(Long value);

public  void setRulesetId(long value);




public  void setRemarks(String value);


}
