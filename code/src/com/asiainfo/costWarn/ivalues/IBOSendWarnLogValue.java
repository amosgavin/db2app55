package com.asiainfo.costWarn.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOSendWarnLogValue extends DataStructInterface{

  public final static  String S_CityId = "CITY_ID";
  public final static  String S_Grade = "GRADE";
  public final static  String S_InsertTime = "INSERT_TIME";
  public final static  String S_Line1Value = "LINE1_VALUE";
  public final static  String S_Line3Value = "LINE3_VALUE";
  public final static  String S_Line2Values = "LINE2_VALUES";
  public final static  String S_LogId = "LOG_ID";
  public final static  String S_Content = "CONTENT";
  public final static  String S_Target = "TARGET";
  public final static  String S_Seserve4 = "SESERVE4";
  public final static  String S_Reserve1 = "RESERVE1";
  public final static  String S_LevelId = "LEVEL_ID";
  public final static  String S_Reserve3 = "RESERVE3";
  public final static  String S_BillId = "BILL_ID";
  public final static  String S_Email = "EMAIL";
  public final static  String S_Reserve2 = "RESERVE2";


public String getCityId();

public String getGrade();

public Timestamp getInsertTime();

public double getLine1Value();

public double getLine3Value();

public double getLine2Values();

public int getLogId();

public String getContent();

public String getTarget();

public String getSeserve4();

public String getReserve1();

public String getLevelId();

public String getReserve3();

public String getBillId();

public String getEmail();

public String getReserve2();


public  void setCityId(String value);

public  void setGrade(String value);

public  void setInsertTime(Timestamp value);

public  void setLine1Value(double value);

public  void setLine3Value(double value);

public  void setLine2Values(double value);

public  void setLogId(int value);

public  void setContent(String value);

public  void setTarget(String value);

public  void setSeserve4(String value);

public  void setReserve1(String value);

public  void setLevelId(String value);

public  void setReserve3(String value);

public  void setBillId(String value);

public  void setEmail(String value);

public  void setReserve2(String value);
}
