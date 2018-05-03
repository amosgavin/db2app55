package com.asiainfo.costWarn.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOConfigureValue extends DataStructInterface{

  public final static  String S_Telphone = "TELPHONE";
  public final static  String S_Bumen = "BUMEN";
  public final static  String S_Staffid = "STAFFID";
  public final static  String S_Staffname = "STAFFNAME";
  public final static  String S_City = "CITY";


public String getTelphone();

public String getBumen();

public String getStaffid();

public String getStaffname();

public String getCity();


public  void setTelphone(String value);

public  void setBumen(String value);

public  void setStaffid(String value);

public  void setStaffname(String value);

public  void setCity(String value);
}
