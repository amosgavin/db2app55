package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceAttrValue extends DataStructInterface{

  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_RuleId = "RULE_ID";
  public final static  String S_AttrName = "ATTR_NAME";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_ObjName = "OBJ_NAME";
  public final static  String S_ValueClass = "VALUE_CLASS";
  public final static  String S_EditType = "EDIT_TYPE";
  public final static  String S_MaxLength = "MAX_LENGTH";
  public final static  String S_ResSrc = "RES_SRC";
  public final static  String S_EffType = "EFF_TYPE";
  public final static  String S_FieldWidth = "FIELD_WIDTH";
  public final static  String S_IsNullable = "IS_NULLABLE";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_MutiFlag = "MUTI_FLAG";
  public final static  String S_ColSpan = "COL_SPAN";
  public final static  String S_FieldType = "FIELD_TYPE";
  public final static  String S_I18nRes = "I18N_RES";
  public final static  String S_AttrCode = "ATTR_CODE";
  public final static  String S_IsMultivalueable = "IS_MULTIVALUEABLE";
  public final static  String S_DefaultValue = "DEFAULT_VALUE";
  public final static  String S_FieldHeight = "FIELD_HEIGHT";
  public final static  String S_AttrId = "ATTR_ID";
  public final static  String S_ResParam = "RES_PARAM";


public long getModuleId();

public int getState();

public String getRuleId();

public String getAttrName();

public String getRemarks();

public String getObjName();

public String getValueClass();

public int getEditType();

public int getMaxLength();

public String getResSrc();

public int getEffType();

public String getFieldWidth();

public int getIsNullable();

public String getRegionId();

public int getMutiFlag();

public int getColSpan();

public String getFieldType();

public String getI18nRes();

public String getAttrCode();

public int getIsMultivalueable();

public String getDefaultValue();

public String getFieldHeight();

public long getAttrId();

public String getResParam();


public  void setModuleId(long value);

public  void setState(int value);

public  void setRuleId(String value);

public  void setAttrName(String value);

public  void setRemarks(String value);

public  void setObjName(String value);

public  void setValueClass(String value);

public  void setEditType(int value);

public  void setMaxLength(int value);

public  void setResSrc(String value);

public  void setEffType(int value);

public  void setFieldWidth(String value);

public  void setIsNullable(int value);

public  void setRegionId(String value);

public  void setMutiFlag(int value);

public  void setColSpan(int value);

public  void setFieldType(String value);

public  void setI18nRes(String value);

public  void setAttrCode(String value);

public  void setIsMultivalueable(int value);

public  void setDefaultValue(String value);

public  void setFieldHeight(String value);

public  void setAttrId(long value);

public  void setResParam(String value);
}
