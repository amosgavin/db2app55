package com.asiainfo.charge.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOChargeConcessInfoValue extends DataStructInterface{

  public final static  String S_ConcessType = "CONCESS_TYPE";
  public final static  String S_BusiType = "BUSI_TYPE";
  public final static  String S_Remark = "REMARK";
  public final static  String S_Concessid = "CONCESSID";
  public final static  String S_ChargeType = "CHARGE_TYPE";
  public final static  String S_Mid = "MID";
  public final static  String S_DisRate = "DIS_RATE";
  public final static  String S_Fee = "FEE";


public String getConcessType();

public String getBusiType();

public String getRemark();

public int getConcessid();

public String getChargeType();

public int getMid();

public int getDisRate();

public int getFee();


public  void setConcessType(String value);

public  void setBusiType(String value);

public  void setRemark(String value);

public  void setConcessid(int value);

public  void setChargeType(String value);

public  void setMid(int value);

public  void setDisRate(int value);

public  void setFee(int value);
}
