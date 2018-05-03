package com.asiainfo.bi.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOTaskDurationValue extends DataStructInterface{

  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_AvgTime1 = "AVG_TIME1";
  public final static  String S_AvgTime5 = "AVG_TIME5";
  public final static  String S_AvgTime4 = "AVG_TIME4";
  public final static  String S_AvgTime3 = "AVG_TIME3";
  public final static  String S_AvgTime2 = "AVG_TIME2";


public String getRegionId();

public double getAvgTime1();

public double getAvgTime5();

public double getAvgTime4();

public double getAvgTime3();

public double getAvgTime2();


public  void setRegionId(String value);

public  void setAvgTime1(double value);

public  void setAvgTime5(double value);

public  void setAvgTime4(double value);

public  void setAvgTime3(double value);

public  void setAvgTime2(double value);
}
