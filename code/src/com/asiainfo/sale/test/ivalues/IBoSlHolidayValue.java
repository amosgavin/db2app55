package com.asiainfo.sale.test.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBoSlHolidayValue extends DataStructInterface{

  public final static  String S_HolidayId = "HOLIDAY_ID";
  public final static  String S_State = "STATE";
  public final static  String S_HolidayDate = "HOLIDAY_DATE";
  public final static  String S_HolidayName = "HOLIDAY_NAME";


public int getHolidayId();

public int getState();

public Timestamp getHolidayDate();

public String getHolidayName();


public  void setHolidayId(int value);

public  void setState(int value);

public  void setHolidayDate(Timestamp value);

public  void setHolidayName(String value);
}
