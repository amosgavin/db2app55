package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceFrameJavaRulesetRelValue extends DataStructInterface{

  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_RelateId = "RELATE_ID";
  public final static  String S_BceFrameId = "BCE_FRAME_ID";
  public final static  String S_RulesetId = "RULESET_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_ParamData = "PARAM_DATA";
  public final static  String S_RulesetType = "RULESET_TYPE";
  public final static  String S_CheckType = "CHECK_TYPE";

  public  Long  getModuleIdAsLong();

public long getModuleId();


  public  Integer  getStateAsInteger();

public int getState();


  public  Long  getRelateIdAsLong();

public long getRelateId();


  public  Long  getBceFrameIdAsLong();

public long getBceFrameId();


  public  Long  getRulesetIdAsLong();

public long getRulesetId();



public String getRemarks();



public String getParamData();


  public  Integer  getRulesetTypeAsInteger();

public int getRulesetType();


  public  Integer  getCheckTypeAsInteger();

public int getCheckType();




  public  void setModuleId(Long value);

public  void setModuleId(long value);



  public  void setState(Integer value);

public  void setState(int value);



  public  void setRelateId(Long value);

public  void setRelateId(long value);



  public  void setBceFrameId(Long value);

public  void setBceFrameId(long value);



  public  void setRulesetId(Long value);

public  void setRulesetId(long value);




public  void setRemarks(String value);




public  void setParamData(String value);



  public  void setRulesetType(Integer value);

public  void setRulesetType(int value);



  public  void setCheckType(Integer value);

public  void setCheckType(int value);


}
