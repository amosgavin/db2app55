package com.asiainfo.costWarn.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOCostWarnReceiverValue extends DataStructInterface{

  public final static  String S_CityId = "CITY_ID";
  public final static  String S_Reserve5 = "RESERVE5";
  public final static  String S_Grade = "GRADE";
  public final static  String S_Reserve4 = "RESERVE4";
  public final static  String S_Target = "TARGET";
  public final static  String S_PersonId = "PERSON_ID";
  public final static  String S_Reserve1 = "RESERVE1";
  public final static  String S_LevelId = "LEVEL_ID";
  public final static  String S_Reserve3 = "RESERVE3";
  public final static  String S_Email = "EMAIL";
  public final static  String S_BillId = "BILL_ID";
  public final static  String S_Reserve2 = "RESERVE2";


public int getCityId();

public String getReserve5();

public String getGrade();

public String getReserve4();

public String getTarget();

public int getPersonId();

public String getReserve1();

public String getLevelId();

public String getReserve3();

public String getEmail();

public long getBillId();

public String getReserve2();


public  void setCityId(int value);

public  void setReserve5(String value);

public  void setGrade(String value);

public  void setReserve4(String value);

public  void setTarget(String value);

public  void setPersonId(int value);

public  void setReserve1(String value);

public  void setLevelId(String value);

public  void setReserve3(String value);

public  void setEmail(String value);

public  void setBillId(long value);

public  void setReserve2(String value);
}
