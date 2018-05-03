package com.asiainfo.costWarn.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOSaleLevelSourceValue extends DataStructInterface{

  public final static  String S_ProSource = "PRO_SOURCE";
  public final static  String S_CityId = "CITY_ID";
  public final static  String S_PrePerson = "PRE_PERSON";
  public final static  String S_Person = "PERSON";
  public final static  String S_LevelCode = "LEVEL_CODE";
  public final static  String S_CityName = "CITY_NAME";
  public final static  String S_SaleName = "SALE_NAME";
  public final static  String S_LevelName = "LEVEL_NAME";


public long getProSource();

public String getCityId();

public long getPrePerson();

public long getPerson();

public String getLevelCode();

public String getCityName();

public String getSaleName();

public String getLevelName();


public  void setProSource(long value);

public  void setCityId(String value);

public  void setPrePerson(long value);

public  void setPerson(long value);

public  void setLevelCode(String value);

public  void setCityName(String value);

public  void setSaleName(String value);

public  void setLevelName(String value);
}
