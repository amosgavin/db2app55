package com.asiainfo.sale.activity.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOSaleResourceUsedValue extends DataStructInterface{

  public final static  String S_PFjfUsed = "P_FJF_USED";
  public final static  String S_LTermUsed = "L_TERM_USED";
  public final static  String S_LJfUsed = "L_JF_USED";
  public final static  String S_LFjfUsed = "L_FJF_USED";
  public final static  String S_PJfUsed = "P_JF_USED";
  public final static  String S_PTermUsed = "P_TERM_USED";
  public final static  String S_CityName = "CITY_NAME";
  public final static  String S_PPromtUsed = "P_PROMT_USED";
  public final static  String S_LPromtUsed = "L_PROMT_USED";
  public final static  String S_LDiscUsed = "L_DISC_USED";
  public final static  String S_PDiscUsed = "P_DISC_USED";


public long getPFjfUsed();

public long getLTermUsed();

public long getLJfUsed();

public long getLFjfUsed();

public long getPJfUsed();

public long getPTermUsed();

public String getCityName();

public long getPPromtUsed();

public long getLPromtUsed();

public long getLDiscUsed();

public long getPDiscUsed();


public  void setPFjfUsed(long value);

public  void setLTermUsed(long value);

public  void setLJfUsed(long value);

public  void setLFjfUsed(long value);

public  void setPJfUsed(long value);

public  void setPTermUsed(long value);

public  void setCityName(String value);

public  void setPPromtUsed(long value);

public  void setLPromtUsed(long value);

public  void setLDiscUsed(long value);

public  void setPDiscUsed(long value);
}
