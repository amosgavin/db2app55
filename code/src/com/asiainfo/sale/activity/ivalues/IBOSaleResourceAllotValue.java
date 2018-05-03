package com.asiainfo.sale.activity.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOSaleResourceAllotValue extends DataStructInterface{

  public final static  String S_CityCode = "CITY_CODE";
  public final static  String S_LTerm = "L_TERM";
  public final static  String S_CityId = "CITY_ID";
  public final static  String S_PDisc = "P_DISC";
  public final static  String S_ThresholdV4 = "THRESHOLD_V4";
  public final static  String S_ThresholdV2 = "THRESHOLD_V2";
  public final static  String S_ThresholdV3 = "THRESHOLD_V3";
  public final static  String S_LPoints = "L_POINTS";
  public final static  String S_PPoints = "P_POINTS";
  public final static  String S_LDisc = "L_DISC";
  public final static  String S_ThresholdV1 = "THRESHOLD_V1";
  public final static  String S_CityName = "CITY_NAME";
  public final static  String S_PPromt = "P_PROMT";
  public final static  String S_PTerm = "P_TERM";
  public final static  String S_QuarterS = "QUARTER_S";
  public final static  String S_LPromt = "L_PROMT";
  public final static  String S_YearS = "YEAR_S";


public String getCityCode();

public double getLTerm();

public String getCityId();

public double getPDisc();

public double getThresholdV4();

public double getThresholdV2();

public double getThresholdV3();

public double getLPoints();

public double getPPoints();

public double getLDisc();

public double getThresholdV1();

public String getCityName();

public double getPPromt();

public double getPTerm();

public String getQuarterS();

public double getLPromt();

public String getYearS();


public  void setCityCode(String value);

public  void setLTerm(double value);

public  void setCityId(String value);

public  void setPDisc(double value);

public  void setThresholdV4(double value);

public  void setThresholdV2(double value);

public  void setThresholdV3(double value);

public  void setLPoints(double value);

public  void setPPoints(double value);

public  void setLDisc(double value);

public  void setThresholdV1(double value);

public  void setCityName(String value);

public  void setPPromt(double value);

public  void setPTerm(double value);

public  void setQuarterS(String value);

public  void setLPromt(double value);

public  void setYearS(String value);
}
