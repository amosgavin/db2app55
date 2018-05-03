package com.ai.bce.plugin.grid.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceTagPGridValue extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_IsInitial = "IS_INITIAL";
  public final static  String S_Editable = "EDITABLE";
  public final static  String S_FootDisplay = "FOOT_DISPLAY";
  public final static  String S_MultSelect = "MULT_SELECT";
  public final static  String S_ObjectId = "OBJECT_ID";
  public final static  String S_SetName = "SET_NAME";
  public final static  String S_QueryMethod = "QUERY_METHOD";
  public final static  String S_DataModel = "DATA_MODEL";
  public final static  String S_GridId = "GRID_ID";
  public final static  String S_RowHeight = "ROW_HEIGHT";
  public final static  String S_NeedRefresh = "NEED_REFRESH";
  public final static  String S_Height = "HEIGHT";
  public final static  String S_Operator = "OPERATOR";
  public final static  String S_ServiceName = "SERVICE_NAME";
  public final static  String S_CountMethod = "COUNT_METHOD";
  public final static  String S_PageSize = "PAGE_SIZE";
  public final static  String S_Mo = "MO";
  public final static  String S_Width = "WIDTH";
  public final static  String S_ConditionName = "CONDITION_NAME";


public int getState();

public int getIsInitial();

public int getEditable();

public int getFootDisplay();

public int getMultSelect();

public long getObjectId();

public String getSetName();

public String getQueryMethod();

public String getDataModel();

public String getGridId();

public String getRowHeight();

public int getNeedRefresh();

public String getHeight();

public String getOperator();

public String getServiceName();

public String getCountMethod();

public int getPageSize();

public String getMo();

public String getWidth();

public String getConditionName();


public  void setState(int value);

public  void setIsInitial(int value);

public  void setEditable(int value);

public  void setFootDisplay(int value);

public  void setMultSelect(int value);

public  void setObjectId(long value);

public  void setSetName(String value);

public  void setQueryMethod(String value);

public  void setDataModel(String value);

public  void setGridId(String value);

public  void setRowHeight(String value);

public  void setNeedRefresh(int value);

public  void setHeight(String value);

public  void setOperator(String value);

public  void setServiceName(String value);

public  void setCountMethod(String value);

public  void setPageSize(int value);

public  void setMo(String value);

public  void setWidth(String value);

public  void setConditionName(String value);
}
