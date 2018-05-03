package com.asiainfo.charge.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBODynamicSumValue extends DataStructInterface{

  public final static  String S_Barpu = "BARPU";
  public final static  String S_AccountCourse = "ACCOUNT_COURSE";
  public final static  String S_Carpu = "CARPU";
  public final static  String S_AddUserCount = "ADD_USER_COUNT";
  public final static  String S_Id = "ID";
  public final static  String S_EarningInfo = "EARNING_INFO";
  public final static  String S_AddUserArpu = "ADD_USER_ARPU";
  public final static  String S_Mid = "MID";
  public final static  String S_InfoTotal = "INFO_TOTAL";
  public final static  String S_Cearning = "CEARNING";
  public final static  String S_Aarpu = "AARPU";


public double getBarpu();

public String getAccountCourse();

public double getCarpu();

public long getAddUserCount();

public String getId();

public double getEarningInfo();

public double getAddUserArpu();

public String getMid();

public double getInfoTotal();

public double getCearning();

public double getAarpu();


public  void setBarpu(double value);

public  void setAccountCourse(String value);

public  void setCarpu(double value);

public  void setAddUserCount(long value);

public  void setId(String value);

public  void setEarningInfo(double value);

public  void setAddUserArpu(double value);

public  void setMid(String value);

public  void setInfoTotal(double value);

public  void setCearning(double value);

public  void setAarpu(double value);
}
