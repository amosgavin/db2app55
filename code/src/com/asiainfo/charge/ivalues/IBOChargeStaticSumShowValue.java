package com.asiainfo.charge.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOChargeStaticSumShowValue extends DataStructInterface{

  public final static  String S_BeforeChange = "BEFORE_CHANGE";
  public final static  String S_SwitchUser = "SWITCH_USER";
  public final static  String S_AfterChange = "AFTER_CHANGE";
  public final static  String S_Item = "ITEM";
  public final static  String S_SumChange = "SUM_CHANGE";
  public final static  String S_Fluctuate = "FLUCTUATE";
  public final static  String S_UserChange = "USER_CHANGE";


public long getBeforeChange();

public long getSwitchUser();

public long getAfterChange();

public String getItem();

public long getSumChange();

public long getFluctuate();

public long getUserChange();


public  void setBeforeChange(long value);

public  void setSwitchUser(long value);

public  void setAfterChange(long value);

public  void setItem(String value);

public  void setSumChange(long value);

public  void setFluctuate(long value);

public  void setUserChange(long value);
}
