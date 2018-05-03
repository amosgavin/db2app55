package com.asiainfo.charge.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOBillingCheckValue extends DataStructInterface{

  public final static  String S_BillingContent = "BILLING_CONTENT";
  public final static  String S_BillingSellingpoint = "BILLING_SELLINGPOINT";
  public final static  String S_Slogan = "SLOGAN";
  public final static  String S_SchemeName = "SCHEME_NAME";
  public final static  String S_Id = "ID";
  public final static  String S_ChargeId = "CHARGE_ID";
  public final static  String S_TargetMarket = "TARGET_MARKET";
  public final static  String S_CheckItem = "CHECK_ITEM";
  public final static  String S_Brand = "BRAND";


public String getBillingContent();

public String getBillingSellingpoint();

public String getSlogan();

public String getSchemeName();

public String getId();

public String getChargeId();

public String getTargetMarket();

public String getCheckItem();

public String getBrand();


public  void setBillingContent(String value);

public  void setBillingSellingpoint(String value);

public  void setSlogan(String value);

public  void setSchemeName(String value);

public  void setId(String value);

public  void setChargeId(String value);

public  void setTargetMarket(String value);

public  void setCheckItem(String value);

public  void setBrand(String value);
}
