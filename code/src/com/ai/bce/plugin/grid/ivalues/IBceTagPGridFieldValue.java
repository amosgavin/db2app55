package com.ai.bce.plugin.grid.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceTagPGridFieldValue extends DataStructInterface{

  public final static  String S_FieldName = "FIELD_NAME";
  public final static  String S_State = "STATE";
  public final static  String S_Title = "TITLE";
  public final static  String S_Visible = "VISIBLE";
  public final static  String S_Editable = "EDITABLE";
  public final static  String S_Validation = "VALIDATION";
  public final static  String S_ObjectId = "OBJECT_ID";
  public final static  String S_Width = "WIDTH";
  public final static  String S_EditType = "EDIT_TYPE";
  public final static  String S_SeqNo = "SEQ_NO";
  public final static  String S_TitleI18n = "TITLE_I18N";


public String getFieldName();

public int getState();

public String getTitle();

public int getVisible();

public int getEditable();

public String getValidation();

public long getObjectId();

public String getWidth();

public String getEditType();

public int getSeqNo();

public String getTitleI18n();


public  void setFieldName(String value);

public  void setState(int value);

public  void setTitle(String value);

public  void setVisible(int value);

public  void setEditable(int value);

public  void setValidation(String value);

public  void setObjectId(long value);

public  void setWidth(String value);

public  void setEditType(String value);

public  void setSeqNo(int value);

public  void setTitleI18n(String value);
}
