package com.asiainfo.charge.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOBusiRulesValue extends DataStructInterface{

  public final static  String S_OverlappedPackage = "OVERLAPPED_PACKAGE";
  public final static  String S_Id = "ID";
  public final static  String S_EffectiveRules = "EFFECTIVE_RULES";
  public final static  String S_BillingRules = "BILLING_RULES";


public String getOverlappedPackage();

public String getId();

public String getEffectiveRules();

public String getBillingRules();


public  void setOverlappedPackage(String value);

public  void setId(String value);

public  void setEffectiveRules(String value);

public  void setBillingRules(String value);
}
