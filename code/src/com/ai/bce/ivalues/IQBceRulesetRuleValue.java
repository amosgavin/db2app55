package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IQBceRulesetRuleValue extends DataStructInterface{

  public final static  String S_EventName = "EVENT_NAME";
  public final static  String S_ParamValueList = "PARAM_VALUE_LIST";
  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_RuleId = "RULE_ID";
  public final static  String S_RuleType = "RULE_TYPE";
  public final static  String S_ParamList = "PARAM_LIST";
  public final static  String S_RuleTriggerType = "RULE_TRIGGER_TYPE";
  public final static  String S_RuleKind = "RULE_KIND";
  public final static  String S_ObjName = "OBJ_NAME";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_ChildObjName = "CHILD_OBJ_NAME";
  public final static  String S_RelateId = "RELATE_ID";
  public final static  String S_VerifyType = "VERIFY_TYPE";
  public final static  String S_SeqNo = "SEQ_NO";
  public final static  String S_FileName = "FILE_NAME";
  public final static  String S_RuleName = "RULE_NAME";
  public final static  String S_ResType = "RES_TYPE";
  public final static  String S_FuncName = "FUNC_NAME";
  public final static  String S_EventObjType = "EVENT_OBJ_TYPE";
  public final static  String S_RulesetId = "RULESET_ID";


public String getEventName();

public String getParamValueList();

public long getModuleId();

public long getState();

public long getRuleId();

public long getRuleType();

public String getParamList();

public long getRuleTriggerType();

public long getRuleKind();

public String getObjName();

public String getRemarks();

public String getChildObjName();

public long getRelateId();

public long getVerifyType();

public long getSeqNo();

public String getFileName();

public String getRuleName();

public String getResType();

public String getFuncName();

public long getEventObjType();

public long getRulesetId();


public  void setEventName(String value);

public  void setParamValueList(String value);

public  void setModuleId(long value);

public  void setState(long value);

public  void setRuleId(long value);

public  void setRuleType(long value);

public  void setParamList(String value);

public  void setRuleTriggerType(long value);

public  void setRuleKind(long value);

public  void setObjName(String value);

public  void setRemarks(String value);

public  void setChildObjName(String value);

public  void setRelateId(long value);

public  void setVerifyType(long value);

public  void setSeqNo(long value);

public  void setFileName(String value);

public  void setRuleName(String value);

public  void setResType(String value);

public  void setFuncName(String value);

public  void setEventObjType(long value);

public  void setRulesetId(long value);
}
