package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceFrameAreaFormValue extends DataStructInterface{

  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_IsInitial = "IS_INITIAL";
  public final static  String S_State = "STATE";
  public final static  String S_Cols = "COLS";
  public final static  String S_BceFrameId = "BCE_FRAME_ID";
  public final static  String S_OnDbclick = "ON_DBCLICK";
  public final static  String S_Validation = "VALIDATION";
  public final static  String S_MultSelect = "MULT_SELECT";
  public final static  String S_TemplateId = "TEMPLATE_ID";
  public final static  String S_FormId = "FORM_ID";
  public final static  String S_QueryMethod = "QUERY_METHOD";
  public final static  String S_ParameterName = "PARAMETER_NAME";
  public final static  String S_RowHeight = "ROW_HEIGHT";
  public final static  String S_IsEditable = "IS_EDITABLE";
  public final static  String S_ServiceName = "SERVICE_NAME";
  public final static  String S_OnValuechange = "ON_VALUECHANGE";
  public final static  String S_ConditionName = "CONDITION_NAME";
  public final static  String S_FootDisplay = "FOOT_DISPLAY";
  public final static  String S_FormType = "FORM_TYPE";
  public final static  String S_DataModel = "DATA_MODEL";
  public final static  String S_NeedRefresh = "NEED_REFRESH";
  public final static  String S_Height = "HEIGHT";
  public final static  String S_Operator = "OPERATOR";
  public final static  String S_OnRowchange = "ON_ROWCHANGE";
  public final static  String S_CountMethod = "COUNT_METHOD";
  public final static  String S_Mo = "MO";
  public final static  String S_PageSize = "PAGE_SIZE";
  public final static  String S_Width = "WIDTH";

  public  Long  getModuleIdAsLong();

public long getModuleId();


  public  Integer  getIsInitialAsInteger();

public int getIsInitial();


  public  Integer  getStateAsInteger();

public int getState();


  public  Integer  getColsAsInteger();

public int getCols();


  public  Long  getBceFrameIdAsLong();

public long getBceFrameId();



public String getOnDbclick();



public String getValidation();


  public  Integer  getMultSelectAsInteger();

public int getMultSelect();



public String getTemplateId();



public String getFormId();



public String getQueryMethod();



public String getParameterName();



public String getRowHeight();


  public  Integer  getIsEditableAsInteger();

public int getIsEditable();



public String getServiceName();



public String getOnValuechange();



public String getConditionName();


  public  Integer  getFootDisplayAsInteger();

public int getFootDisplay();


  public  Integer  getFormTypeAsInteger();

public int getFormType();



public String getDataModel();


  public  Integer  getNeedRefreshAsInteger();

public int getNeedRefresh();



public String getHeight();



public String getOperator();



public String getOnRowchange();



public String getCountMethod();



public String getMo();


  public  Integer  getPageSizeAsInteger();

public int getPageSize();



public String getWidth();




  public  void setModuleId(Long value);

public  void setModuleId(long value);



  public  void setIsInitial(Integer value);

public  void setIsInitial(int value);



  public  void setState(Integer value);

public  void setState(int value);



  public  void setCols(Integer value);

public  void setCols(int value);



  public  void setBceFrameId(Long value);

public  void setBceFrameId(long value);




public  void setOnDbclick(String value);




public  void setValidation(String value);



  public  void setMultSelect(Integer value);

public  void setMultSelect(int value);




public  void setTemplateId(String value);




public  void setFormId(String value);




public  void setQueryMethod(String value);




public  void setParameterName(String value);




public  void setRowHeight(String value);



  public  void setIsEditable(Integer value);

public  void setIsEditable(int value);




public  void setServiceName(String value);




public  void setOnValuechange(String value);




public  void setConditionName(String value);



  public  void setFootDisplay(Integer value);

public  void setFootDisplay(int value);



  public  void setFormType(Integer value);

public  void setFormType(int value);




public  void setDataModel(String value);



  public  void setNeedRefresh(Integer value);

public  void setNeedRefresh(int value);




public  void setHeight(String value);




public  void setOperator(String value);




public  void setOnRowchange(String value);




public  void setCountMethod(String value);




public  void setMo(String value);



  public  void setPageSize(Integer value);

public  void setPageSize(int value);




public  void setWidth(String value);


}
