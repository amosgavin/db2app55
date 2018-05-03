package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceRuleValue extends DataStructInterface{

  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_RuleId = "RULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_ParamList = "PARAM_LIST";
  public final static  String S_RuleType = "RULE_TYPE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_RuleKind = "RULE_KIND";
  public final static  String S_CenterType = "CENTER_TYPE";
  public final static  String S_CenterValueIndex = "CENTER_VALUE_INDEX";
  public final static  String S_AlertMessage = "ALERT_MESSAGE";
  public final static  String S_FileName = "FILE_NAME";
  public final static  String S_RuleName = "RULE_NAME";
  public final static  String S_FuncName = "FUNC_NAME";


public long getModuleId();

public long getRuleId();

public long getState();

public String getParamList();

public long getRuleType();

public String getRemarks();

public long getRuleKind();

public String getCenterType();

public String getCenterValueIndex();

public String getAlertMessage();

public String getFileName();

public String getRuleName();

public String getFuncName();


public  void setModuleId(long value);

public  void setRuleId(long value);

public  void setState(long value);

public  void setParamList(String value);

public  void setRuleType(long value);

public  void setRemarks(String value);

public  void setRuleKind(long value);

public  void setCenterType(String value);

public  void setCenterValueIndex(String value);

public  void setAlertMessage(String value);

public  void setFileName(String value);

public  void setRuleName(String value);

public  void setFuncName(String value);
}
