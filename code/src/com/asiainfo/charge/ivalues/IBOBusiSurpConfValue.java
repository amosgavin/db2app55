package com.asiainfo.charge.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOBusiSurpConfValue extends DataStructInterface{

  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_Reason = "REASON";
  public final static  String S_Mold = "MOLD";
  public final static  String S_Desc = "DESC";
  public final static  String S_Id = "ID";
  public final static  String S_Mode = "MODE";
  public final static  String S_Factor = "FACTOR";


public int getOrderId();

public String getReason();

public String getMold();

public String getDesc();

public int getId();

public String getMode();

public String getFactor();


public  void setOrderId(int value);

public  void setReason(String value);

public  void setMold(String value);

public  void setDesc(String value);

public  void setId(int value);

public  void setMode(String value);

public  void setFactor(String value);
}
