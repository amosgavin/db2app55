package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceRulesetRuleValue extends DataStructInterface{

  public final static  String S_EventName = "EVENT_NAME";
  public final static  String S_ParamValueList = "PARAM_VALUE_LIST";
  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_RuleId = "RULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_RuleTriggerType = "RULE_TRIGGER_TYPE";
  public final static  String S_ObjName = "OBJ_NAME";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_ChildObjName = "CHILD_OBJ_NAME";
  public final static  String S_RelateId = "RELATE_ID";
  public final static  String S_VerifyType = "VERIFY_TYPE";
  public final static  String S_SeqNo = "SEQ_NO";
  public final static  String S_EventObjType = "EVENT_OBJ_TYPE";
  public final static  String S_RulesetId = "RULESET_ID";


public String getEventName();

public String getParamValueList();

public long getModuleId();

public long getRuleId();

public long getState();

public long getRuleTriggerType();

public String getObjName();

public String getRemarks();

public String getChildObjName();

public long getRelateId();

public long getVerifyType();

public long getSeqNo();

public long getEventObjType();

public long getRulesetId();


public  void setEventName(String value);

public  void setParamValueList(String value);

public  void setModuleId(long value);

public  void setRuleId(long value);

public  void setState(long value);

public  void setRuleTriggerType(long value);

public  void setObjName(String value);

public  void setRemarks(String value);

public  void setChildObjName(String value);

public  void setRelateId(long value);

public  void setVerifyType(long value);

public  void setSeqNo(long value);

public  void setEventObjType(long value);

public  void setRulesetId(long value);
}
