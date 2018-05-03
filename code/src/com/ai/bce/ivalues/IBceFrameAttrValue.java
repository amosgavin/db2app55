package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceFrameAttrValue extends DataStructInterface{

  public final static  String S_IsVisible = "IS_VISIBLE";
  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_AttrName = "ATTR_NAME";
  public final static  String S_EditType = "EDIT_TYPE";
  public final static  String S_IsLog = "IS_LOG";
  public final static  String S_MaxLength = "MAX_LENGTH";
  public final static  String S_FieldWidth = "FIELD_WIDTH";
  public final static  String S_IsNullable = "IS_NULLABLE";
  public final static  String S_SeqNo = "SEQ_NO";
  public final static  String S_IsEditable = "IS_EDITABLE";
  public final static  String S_I18nRes = "I18N_RES";
  public final static  String S_IsMultivalueable = "IS_MULTIVALUEABLE";
  public final static  String S_AttrId = "ATTR_ID";
  public final static  String S_IsValidate = "IS_VALIDATE";
  public final static  String S_GroupId = "GROUP_ID";
  public final static  String S_FormId = "FORM_ID";
  public final static  String S_ValueClass = "VALUE_CLASS";
  public final static  String S_ResSrc = "RES_SRC";
  public final static  String S_EffType = "EFF_TYPE";
  public final static  String S_Ext1 = "EXT_1";
  public final static  String S_BceFrameId = "BCE_FRAME_ID";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_ColSpan = "COL_SPAN";
  public final static  String S_MutiFlag = "MUTI_FLAG";
  public final static  String S_Ext3 = "EXT_3";
  public final static  String S_Ext2 = "EXT_2";
  public final static  String S_DefaultValue = "DEFAULT_VALUE";
  public final static  String S_FieldHeight = "FIELD_HEIGHT";
  public final static  String S_ResParam = "RES_PARAM";


public int getIsVisible();

public long getModuleId();

public int getState();

public String getAttrName();

public int getEditType();

public int getIsLog();

public int getMaxLength();

public String getFieldWidth();

public int getIsNullable();

public int getSeqNo();

public int getIsEditable();

public String getI18nRes();

public int getIsMultivalueable();

public long getAttrId();

public int getIsValidate();

public long getGroupId();

public String getFormId();

public String getValueClass();

public String getResSrc();

public int getEffType();

public String getExt1();

public long getBceFrameId();

public String getRegionId();

public int getColSpan();

public int getMutiFlag();

public long getExt3();

public String getExt2();

public String getDefaultValue();

public String getFieldHeight();

public String getResParam();


public  void setIsVisible(int value);

public  void setModuleId(long value);

public  void setState(int value);

public  void setAttrName(String value);

public  void setEditType(int value);

public  void setIsLog(int value);

public  void setMaxLength(int value);

public  void setFieldWidth(String value);

public  void setIsNullable(int value);

public  void setSeqNo(int value);

public  void setIsEditable(int value);

public  void setI18nRes(String value);

public  void setIsMultivalueable(int value);

public  void setAttrId(long value);

public  void setIsValidate(int value);

public  void setGroupId(long value);

public  void setFormId(String value);

public  void setValueClass(String value);

public  void setResSrc(String value);

public  void setEffType(int value);

public  void setExt1(String value);

public  void setBceFrameId(long value);

public  void setRegionId(String value);

public  void setColSpan(int value);

public  void setMutiFlag(int value);

public  void setExt3(long value);

public  void setExt2(String value);

public  void setDefaultValue(String value);

public  void setFieldHeight(String value);

public  void setResParam(String value);
}
