package com.asiainfo.bi.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOBusiSupportSValue extends DataStructInterface{

  public final static  String S_Salen = "SALEN";
  public final static  String S_Totaly = "TOTALY";
  public final static  String S_Chargen = "CHARGEN";
  public final static  String S_Busin = "BUSIN";
  public final static  String S_Total = "TOTAL";
  public final static  String S_Diffgt30 = "DIFFGT30";
  public final static  String S_Saley = "SALEY";
  public final static  String S_Diffls15 = "DIFFLS15";
  public final static  String S_Weaponn = "WEAPONN";
  public final static  String S_Chargey = "CHARGEY";
  public final static  String S_StaffName = "STAFF_NAME";
  public final static  String S_Diff15to30 = "DIFF15TO30";
  public final static  String S_Totaln = "TOTALN";
  public final static  String S_Weapony = "WEAPONY";
  public final static  String S_Busiy = "BUSIY";


public long getSalen();

public long getTotaly();

public long getChargen();

public long getBusin();

public long getTotal();

public long getDiffgt30();

public long getSaley();

public long getDiffls15();

public long getWeaponn();

public long getChargey();

public String getStaffName();

public long getDiff15to30();

public long getTotaln();

public long getWeapony();

public long getBusiy();


public  void setSalen(long value);

public  void setTotaly(long value);

public  void setChargen(long value);

public  void setBusin(long value);

public  void setTotal(long value);

public  void setDiffgt30(long value);

public  void setSaley(long value);

public  void setDiffls15(long value);

public  void setWeaponn(long value);

public  void setChargey(long value);

public  void setStaffName(String value);

public  void setDiff15to30(long value);

public  void setTotaln(long value);

public  void setWeapony(long value);

public  void setBusiy(long value);
}
