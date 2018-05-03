package com.asiainfo.charge.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOChargeConcessDetailInfoValue extends DataStructInterface{

  public final static  String S_DetailType = "DETAIL_TYPE";
  public final static  String S_Price = "PRICE";
  public final static  String S_Unit = "UNIT";
  public final static  String S_ChargeOut = "CHARGE_OUT";
  public final static  String S_Cnt = "CNT";
  public final static  String S_Id = "ID";
  public final static  String S_Remark = "REMARK";
  public final static  String S_Conssid = "CONSSID";
  public final static  String S_ChargeIn = "CHARGE_IN";


public String getDetailType();

public int getPrice();

public String getUnit();

public int getChargeOut();

public int getCnt();

public int getId();

public String getRemark();

public int getConssid();

public int getChargeIn();


public  void setDetailType(String value);

public  void setPrice(int value);

public  void setUnit(String value);

public  void setChargeOut(int value);

public  void setCnt(int value);

public  void setId(int value);

public  void setRemark(String value);

public  void setConssid(int value);

public  void setChargeIn(int value);
}
