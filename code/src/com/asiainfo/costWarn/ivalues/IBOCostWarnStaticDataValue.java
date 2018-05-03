package com.asiainfo.costWarn.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOCostWarnStaticDataValue extends DataStructInterface{

  public final static  String S_CityCode = "CITY_CODE";
  public final static  String S_DiscountFee = "DISCOUNT_FEE";
  public final static  String S_CityId = "CITY_ID";
  public final static  String S_Reserve4 = "RESERVE4";
  public final static  String S_CityName = "CITY_NAME";
  public final static  String S_Reserve1 = "RESERVE1";
  public final static  String S_EndpointSub = "ENDPOINT_SUB";
  public final static  String S_Seserve5 = "SESERVE5";
  public final static  String S_Reserve3 = "RESERVE3";
  public final static  String S_Reserve2 = "RESERVE2";


public String getCityCode();

public double getDiscountFee();

public String getCityId();

public String getReserve4();

public String getCityName();

public double getReserve1();

public double getEndpointSub();

public String getSeserve5();

public double getReserve3();

public double getReserve2();


public  void setCityCode(String value);

public  void setDiscountFee(double value);

public  void setCityId(String value);

public  void setReserve4(String value);

public  void setCityName(String value);

public  void setReserve1(double value);

public  void setEndpointSub(double value);

public  void setSeserve5(String value);

public  void setReserve3(double value);

public  void setReserve2(double value);
}
