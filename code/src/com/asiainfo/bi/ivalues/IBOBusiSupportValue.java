package com.asiainfo.bi.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOBusiSupportValue extends DataStructInterface{

  public final static  String S_ApplyName = "APPLY_NAME";
  public final static  String S_OrganizeName = "ORGANIZE_NAME";
  public final static  String S_State = "STATE";
  public final static  String S_Wid = "WID";
  public final static  String S_FinishDate = "FINISH_DATE";
  public final static  String S_Superior = "SUPERIOR";
  public final static  String S_Lcn = "LCN";
  public final static  String S_DispatchDate = "DISPATCH_DATE";
  public final static  String S_Diffday = "DIFFDAY";
  public final static  String S_StaffName = "STAFF_NAME";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Bcn = "BCN";
  public final static  String S_Itemtype = "ITEMTYPE";


public String getApplyName();

public String getOrganizeName();

public String getState();

public String getWid();

public Timestamp getFinishDate();

public String getSuperior();

public int getLcn();

public Timestamp getDispatchDate();

public int getDiffday();

public String getStaffName();

public Timestamp getCreateDate();

public int getBcn();

public String getItemtype();


public  void setApplyName(String value);

public  void setOrganizeName(String value);

public  void setState(String value);

public  void setWid(String value);

public  void setFinishDate(Timestamp value);

public  void setSuperior(String value);

public  void setLcn(int value);

public  void setDispatchDate(Timestamp value);

public  void setDiffday(int value);

public  void setStaffName(String value);

public  void setCreateDate(Timestamp value);

public  void setBcn(int value);

public  void setItemtype(String value);
}
