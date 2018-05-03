package com.asiainfo.costWarn.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOActualUsedSourceValue extends DataStructInterface{

  public final static  String S_JtZdUserCnt = "JT_ZD_USER_CNT";
  public final static  String S_Zdbt = "ZDBT";
  public final static  String S_CityId = "CITY_ID";
  public final static  String S_PreEndpoint = "PRE_ENDPOINT";
  public final static  String S_CityName = "CITY_NAME";
  public final static  String S_UsedSalebase = "USED_SALEBASE";
  public final static  String S_PreFee = "PRE_FEE";
  public final static  String S_UsedEndpoint = "USED_ENDPOINT";
  public final static  String S_UsedFee = "USED_FEE";
  public final static  String S_ProgressEndpoint = "PROGRESS_ENDPOINT";
  public final static  String S_ProgressFee = "PROGRESS_FEE";


public long getJtZdUserCnt();

public double getZdbt();

public String getCityId();

public String getPreEndpoint();

public String getCityName();

public String getUsedSalebase();

public String getPreFee();

public String getUsedEndpoint();

public String getUsedFee();

public String getProgressEndpoint();

public String getProgressFee();


public  void setJtZdUserCnt(long value);

public  void setZdbt(double value);

public  void setCityId(String value);

public  void setPreEndpoint(String value);

public  void setCityName(String value);

public  void setUsedSalebase(String value);

public  void setPreFee(String value);

public  void setUsedEndpoint(String value);

public  void setUsedFee(String value);

public  void setProgressEndpoint(String value);

public  void setProgressFee(String value);
}
