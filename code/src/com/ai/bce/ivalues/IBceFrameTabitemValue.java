package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceFrameTabitemValue extends DataStructInterface{

  public final static  String S_Isdeletable = "ISDELETABLE";
  public final static  String S_Isinitial = "ISINITIAL";
  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_Onclose = "ONCLOSE";
  public final static  String S_Mo = "MO";
  public final static  String S_Operator = "OPERATOR";
  public final static  String S_Src = "SRC";
  public final static  String S_TabId = "TAB_ID";
  public final static  String S_Width = "WIDTH";
  public final static  String S_I18nres = "I18NRES";
  public final static  String S_SrcParams = "SRC_PARAMS";
  public final static  String S_Title = "TITLE";
  public final static  String S_TabItemId = "TAB_ITEM_ID";


public String getIsdeletable();

public int getIsinitial();

public long getModuleId();

public int getState();

public String getRemarks();

public String getOnclose();

public String getMo();

public String getOperator();

public String getSrc();

public long getTabId();

public String getWidth();

public String getI18nres();

public String getSrcParams();

public String getTitle();

public long getTabItemId();


public  void setIsdeletable(String value);

public  void setIsinitial(int value);

public  void setModuleId(long value);

public  void setState(int value);

public  void setRemarks(String value);

public  void setOnclose(String value);

public  void setMo(String value);

public  void setOperator(String value);

public  void setSrc(String value);

public  void setTabId(long value);

public  void setWidth(String value);

public  void setI18nres(String value);

public  void setSrcParams(String value);

public  void setTitle(String value);

public  void setTabItemId(long value);
}
