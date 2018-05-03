package com.asiainfo.charge.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOFinalShareValue extends DataStructInterface{

  public final static  String S_Reserv2 = "RESERV2";
  public final static  String S_Reserv1 = "RESERV1";
  public final static  String S_Final = "FINAL";
  public final static  String S_Reserv3 = "RESERV3";
  public final static  String S_Id = "ID";
  public final static  String S_FinalTaxrate = "FINAL_TAXRATE";
  public final static  String S_ChargeId = "CHARGE_ID";
  public final static  String S_FinalRate = "FINAL_RATE";
  public final static  String S_AmountItem = "AMOUNT_ITEM";


public String getReserv2();

public String getReserv1();

public String getFinal();

public String getReserv3();

public long getId();

public double getFinalTaxrate();

public String getChargeId();

public double getFinalRate();

public String getAmountItem();


public  void setReserv2(String value);

public  void setReserv1(String value);

public  void setFinal(String value);

public  void setReserv3(String value);

public  void setId(long value);

public  void setFinalTaxrate(double value);

public  void setChargeId(String value);

public  void setFinalRate(double value);

public  void setAmountItem(String value);
}
