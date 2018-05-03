package com.asiainfo.charge.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOGprsFluxParamValue extends DataStructInterface{

  public final static  String S_Statusdate = "STATUSDATE";
  public final static  String S_Groupid = "GROUPID";
  public final static  String S_Status = "STATUS";
  public final static  String S_Rateplanid = "RATEPLANID";
  public final static  String S_StdFree4 = "STD_FREE4";
  public final static  String S_Gettype = "GETTYPE";
  public final static  String S_Iscalbyday = "ISCALBYDAY";
  public final static  String S_Pkgcode = "PKGCODE";
  public final static  String S_StdFree1 = "STD_FREE1";
  public final static  String S_Halfflag = "HALFFLAG";
  public final static  String S_StdFree3 = "STD_FREE3";
  public final static  String S_StdFree2 = "STD_FREE2";
  public final static  String S_Exesql = "EXESQL";
  public final static  String S_Privname = "PRIVNAME";
  public final static  String S_Privid = "PRIVID";
  public final static  String S_AccExesql = "ACC_EXESQL";


public Timestamp getStatusdate();

public String getGroupid();

public int getStatus();

public String getRateplanid();

public int getStdFree4();

public int getGettype();

public int getIscalbyday();

public String getPkgcode();

public int getStdFree1();

public int getHalfflag();

public int getStdFree3();

public int getStdFree2();

public String getExesql();

public String getPrivname();

public String getPrivid();

public String getAccExesql();


public  void setStatusdate(Timestamp value);

public  void setGroupid(String value);

public  void setStatus(int value);

public  void setRateplanid(String value);

public  void setStdFree4(int value);

public  void setGettype(int value);

public  void setIscalbyday(int value);

public  void setPkgcode(String value);

public  void setStdFree1(int value);

public  void setHalfflag(int value);

public  void setStdFree3(int value);

public  void setStdFree2(int value);

public  void setExesql(String value);

public  void setPrivname(String value);

public  void setPrivid(String value);

public  void setAccExesql(String value);
}
