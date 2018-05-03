package com.ai.bce.plugin.form.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceTagPFormValue extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_IsInitial = "IS_INITIAL";
  public final static  String S_Cols = "COLS";
  public final static  String S_Editable = "EDITABLE";
  public final static  String S_FieldStyle = "FIELD_STYLE";
  public final static  String S_ObjectId = "OBJECT_ID";
  public final static  String S_TableStyle = "TABLE_STYLE";
  public final static  String S_FormId = "FORM_ID";
  public final static  String S_SetName = "SET_NAME";
  public final static  String S_QueryMethod = "QUERY_METHOD";
  public final static  String S_DataModel = "DATA_MODEL";
  public final static  String S_TitleStyle = "TITLE_STYLE";
  public final static  String S_Operator = "OPERATOR";
  public final static  String S_ServiceName = "SERVICE_NAME";
  public final static  String S_Mo = "MO";
  public final static  String S_ConditionName = "CONDITION_NAME";


public int getState();

public int getIsInitial();

public int getCols();

public int getEditable();

public String getFieldStyle();

public long getObjectId();

public String getTableStyle();

public String getFormId();

public String getSetName();

public String getQueryMethod();

public String getDataModel();

public String getTitleStyle();

public String getOperator();

public String getServiceName();

public String getMo();

public String getConditionName();


public  void setState(int value);

public  void setIsInitial(int value);

public  void setCols(int value);

public  void setEditable(int value);

public  void setFieldStyle(String value);

public  void setObjectId(long value);

public  void setTableStyle(String value);

public  void setFormId(String value);

public  void setSetName(String value);

public  void setQueryMethod(String value);

public  void setDataModel(String value);

public  void setTitleStyle(String value);

public  void setOperator(String value);

public  void setServiceName(String value);

public  void setMo(String value);

public  void setConditionName(String value);
}
