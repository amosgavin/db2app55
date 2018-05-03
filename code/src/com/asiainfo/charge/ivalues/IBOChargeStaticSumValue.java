package com.asiainfo.charge.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOChargeStaticSumValue extends DataStructInterface{

  public final static  String S_BeforeChange = "BEFORE_CHANGE";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_SwitchUser = "SWITCH_USER";
  public final static  String S_AfterChange = "AFTER_CHANGE";
  public final static  String S_Item = "ITEM";
  public final static  String S_GrandId = "GRAND_ID";


public double getBeforeChange();

public int getOrderId();

public int getSwitchUser();

public double getAfterChange();

public String getItem();

public String getGrandId();


public  void setBeforeChange(double value);

public  void setOrderId(int value);

public  void setSwitchUser(int value);

public  void setAfterChange(double value);

public  void setItem(String value);

public  void setGrandId(String value);
}
