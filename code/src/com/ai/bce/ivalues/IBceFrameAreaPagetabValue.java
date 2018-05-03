package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceFrameAreaPagetabValue extends DataStructInterface{

  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_Getparameter = "GETPARAMETER";
  public final static  String S_State = "STATE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_Height = "HEIGHT";
  public final static  String S_AreaId = "AREA_ID";
  public final static  String S_TabType = "TAB_TYPE";
  public final static  String S_TabId = "TAB_ID";
  public final static  String S_Width = "WIDTH";
  public final static  String S_BceFrameId = "BCE_FRAME_ID";
  public final static  String S_Beforesettab = "BEFORESETTAB";
  public final static  String S_Aftersettab = "AFTERSETTAB";
  public final static  String S_Vmfile = "VMFILE";


public long getModuleId();

public String getGetparameter();

public int getState();

public String getRemarks();

public String getHeight();

public String getAreaId();

public String getTabType();

public long getTabId();

public String getWidth();

public long getBceFrameId();

public String getBeforesettab();

public String getAftersettab();

public String getVmfile();


public  void setModuleId(long value);

public  void setGetparameter(String value);

public  void setState(int value);

public  void setRemarks(String value);

public  void setHeight(String value);

public  void setAreaId(String value);

public  void setTabType(String value);

public  void setTabId(long value);

public  void setWidth(String value);

public  void setBceFrameId(long value);

public  void setBeforesettab(String value);

public  void setAftersettab(String value);

public  void setVmfile(String value);
}
