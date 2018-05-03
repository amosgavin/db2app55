package com.asiainfo.costWarn.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOCostWarnValue extends DataStructInterface{

  public final static  String S_CityId = "CITY_ID";
  public final static  String S_Grade = "GRADE";
  public final static  String S_WarnLine1 = "WARN_LINE1";
  public final static  String S_WarnLine2 = "WARN_LINE2";
  public final static  String S_WarnLine3 = "WARN_LINE3";
  public final static  String S_Reserve5 = "RESERVE5";
  public final static  String S_CityName = "CITY_NAME";
  public final static  String S_Reserve4 = "RESERVE4";
  public final static  String S_Target = "TARGET";
  public final static  String S_Reserve1 = "RESERVE1";
  public final static  String S_LevelId = "LEVEL_ID";
  public final static  String S_Reserve3 = "RESERVE3";
  public final static  String S_Reserve2 = "RESERVE2";
  public final static  String S_CfId = "CF_ID";


public int getCityId();

public String getGrade();

public int getWarnLine1();

public int getWarnLine2();

public int getWarnLine3();

public String getReserve5();

public String getCityName();

public String getReserve4();

public String getTarget();

public String getReserve1();

public String getLevelId();

public String getReserve3();

public String getReserve2();

public int getCfId();


public  void setCityId(int value);

public  void setGrade(String value);

public  void setWarnLine1(int value);

public  void setWarnLine2(int value);

public  void setWarnLine3(int value);

public  void setReserve5(String value);

public  void setCityName(String value);

public  void setReserve4(String value);

public  void setTarget(String value);

public  void setReserve1(String value);

public  void setLevelId(String value);

public  void setReserve3(String value);

public  void setReserve2(String value);

public  void setCfId(int value);
}
