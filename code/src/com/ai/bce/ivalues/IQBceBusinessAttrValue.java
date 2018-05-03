package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IQBceBusinessAttrValue extends DataStructInterface{

  public final static  String S_IsVisible = "IS_VISIBLE";
  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_RuleId = "RULE_ID";
  public final static  String S_AttrName = "ATTR_NAME";
  public final static  String S_EditType = "EDIT_TYPE";
  public final static  String S_IsLog = "IS_LOG";
  public final static  String S_MaxLength = "MAX_LENGTH";
  public final static  String S_FieldWidth = "FIELD_WIDTH";
  public final static  String S_IsNullable = "IS_NULLABLE";
  public final static  String S_SeqNo = "SEQ_NO";
  public final static  String S_IsEditable = "IS_EDITABLE";
  public final static  String S_FieldType = "FIELD_TYPE";
  public final static  String S_I18nRes = "I18N_RES";
  public final static  String S_IsMultivalueable = "IS_MULTIVALUEABLE";
  public final static  String S_AttrId = "ATTR_ID";
  public final static  String S_IsValidate = "IS_VALIDATE";
  public final static  String S_GroupId = "GROUP_ID";
  public final static  String S_FormId = "FORM_ID";
  public final static  String S_ValueClass = "VALUE_CLASS";
  public final static  String S_ResSrc = "RES_SRC";
  public final static  String S_EffType = "EFF_TYPE";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_Ext1 = "EXT_1";
  public final static  String S_BceFrameId = "BCE_FRAME_ID";
  public final static  String S_MutiFlag = "MUTI_FLAG";
  public final static  String S_ColSpan = "COL_SPAN";
  public final static  String S_AttrCode = "ATTR_CODE";
  public final static  String S_Ext3 = "EXT_3";
  public final static  String S_Ext2 = "EXT_2";
  public final static  String S_DefaultValue = "DEFAULT_VALUE";
  public final static  String S_FieldHeight = "FIELD_HEIGHT";
  public final static  String S_ResParam = "RES_PARAM";


public long getIsVisible();

public long getModuleId();

public long getState();

public String getRuleId();

public String getAttrName();

public long getEditType();

public long getIsLog();

public long getMaxLength();

public String getFieldWidth();

public long getIsNullable();

public long getSeqNo();

public long getIsEditable();

public String getFieldType();

public String getI18nRes();

public long getIsMultivalueable();

public long getAttrId();

public long getIsValidate();

public long getGroupId();

public String getFormId();

public String getValueClass();

public String getResSrc();

public long getEffType();

public String getRegionId();

public String getExt1();

public long getBceFrameId();

public long getMutiFlag();

public long getColSpan();

public String getAttrCode();

public long getExt3();

public String getExt2();

public String getDefaultValue();

public String getFieldHeight();

public String getResParam();


public  void setIsVisible(long value);

public  void setModuleId(long value);

public  void setState(long value);

public  void setRuleId(String value);

public  void setAttrName(String value);

public  void setEditType(long value);

public  void setIsLog(long value);

public  void setMaxLength(long value);

public  void setFieldWidth(String value);

public  void setIsNullable(long value);

public  void setSeqNo(long value);

public  void setIsEditable(long value);

public  void setFieldType(String value);

public  void setI18nRes(String value);

public  void setIsMultivalueable(long value);

public  void setAttrId(long value);

public  void setIsValidate(long value);

public  void setGroupId(long value);

public  void setFormId(String value);

public  void setValueClass(String value);

public  void setResSrc(String value);

public  void setEffType(long value);

public  void setRegionId(String value);

public  void setExt1(String value);

public  void setBceFrameId(long value);

public  void setMutiFlag(long value);

public  void setColSpan(long value);

public  void setAttrCode(String value);

public  void setExt3(long value);

public  void setExt2(String value);

public  void setDefaultValue(String value);

public  void setFieldHeight(String value);

public  void setResParam(String value);
}
