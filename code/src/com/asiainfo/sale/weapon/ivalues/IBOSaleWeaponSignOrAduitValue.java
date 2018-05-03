package com.asiainfo.sale.weapon.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOSaleWeaponSignOrAduitValue extends DataStructInterface{

  public final static  String S_Tlabel = "TLABEL";
  public final static  String S_WeaponName = "WEAPON_NAME";
  public final static  String S_StationId = "STATION_ID";
  public final static  String S_NetAge = "NET_AGE";
  public final static  String S_TaskId = "TASK_ID";
  public final static  String S_Mid = "MID";
  public final static  String S_TaskType = "TASK_TYPE";
  public final static  String S_Wlabel = "WLABEL";
  public final static  String S_Id = "ID";
  public final static  String S_SaleFlag = "SALE_FLAG";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_MarketType = "MARKET_TYPE";
  public final static  String S_TaskTag = "TASK_TAG";
  public final static  String S_TaskStaffId = "TASK_STAFF_ID";


public String getTlabel();

public String getWeaponName();

public String getStationId();

public String getNetAge();

public String getTaskId();

public String getMid();

public String getTaskType();

public String getWlabel();

public String getId();

public String getSaleFlag();

public Timestamp getCreateDate();

public String getMarketType();

public String getTaskTag();

public String getTaskStaffId();


public  void setTlabel(String value);

public  void setWeaponName(String value);

public  void setStationId(String value);

public  void setNetAge(String value);

public  void setTaskId(String value);

public  void setMid(String value);

public  void setTaskType(String value);

public  void setWlabel(String value);

public  void setId(String value);

public  void setSaleFlag(String value);

public  void setCreateDate(Timestamp value);

public  void setMarketType(String value);

public  void setTaskTag(String value);

public  void setTaskStaffId(String value);
}
