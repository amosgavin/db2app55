package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceQrAttrValue extends DataStructInterface{

  public final static  String S_ParamRe = "PARAM_RE";
  public final static  String S_State = "STATE";
  public final static  String S_AliasName = "ALIAS_NAME";
  public final static  String S_AttrName = "ATTR_NAME";
  public final static  String S_IsList = "IS_LIST";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_BceGetRule = "BCE_GET_RULE";
  public final static  String S_TemplateId = "TEMPLATE_ID";
  public final static  String S_PreAttrId = "PRE_ATTR_ID";
  public final static  String S_TempString = "TEMP_STRING";
  public final static  String S_DefaultValue = "DEFAULT_VALUE";
  public final static  String S_AttrId = "ATTR_ID";
  public final static  String S_IsPre = "IS_PRE";


public String getParamRe();

public int getState();

public String getAliasName();

public String getAttrName();

public int getIsList();

public String getRemarks();

public String getBceGetRule();

public long getTemplateId();

public long getPreAttrId();

public String getTempString();

public String getDefaultValue();

public long getAttrId();

public int getIsPre();


public  void setParamRe(String value);

public  void setState(int value);

public  void setAliasName(String value);

public  void setAttrName(String value);

public  void setIsList(int value);

public  void setRemarks(String value);

public  void setBceGetRule(String value);

public  void setTemplateId(long value);

public  void setPreAttrId(long value);

public  void setTempString(String value);

public  void setDefaultValue(String value);

public  void setAttrId(long value);

public  void setIsPre(int value);
}
