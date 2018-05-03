package com.asiainfo.costWarn.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOPreUsedSourceValue extends DataStructInterface{

  public final static  String S_PrePrefee = "PRE_PREFEE";
  public final static  String S_CityId = "CITY_ID";
  public final static  String S_ProgressPrefee = "PROGRESS_PREFEE";
  public final static  String S_CityName = "CITY_NAME";
  public final static  String S_UsedPrefee = "USED_PREFEE";


public long getPrePrefee();

public String getCityId();

public long getProgressPrefee();

public String getCityName();

public long getUsedPrefee();


public  void setPrePrefee(long value);

public  void setCityId(String value);

public  void setProgressPrefee(long value);

public  void setCityName(String value);

public  void setUsedPrefee(long value);
}
