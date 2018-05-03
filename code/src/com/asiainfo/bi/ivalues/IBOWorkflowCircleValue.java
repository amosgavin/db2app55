package com.asiainfo.bi.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOWorkflowCircleValue extends DataStructInterface{

  public final static  String S_Pass = "PASS";
  public final static  String S_Scb = "SCB";
  public final static  String S_False = "FALSE";
  public final static  String S_Total = "TOTAL";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_Hdpz = "HDPZ";
  public final static  String S_Qrsz = "QRSZ";
  public final static  String S_Nbsh = "NBSH";
  public final static  String S_Yzpz = "YZPZ";


public long getPass();

public long getScb();

public long getFalse();

public long getTotal();

public String getRegionId();

public long getHdpz();

public long getQrsz();

public long getNbsh();

public long getYzpz();


public  void setPass(long value);

public  void setScb(long value);

public  void setFalse(long value);

public  void setTotal(long value);

public  void setRegionId(String value);

public  void setHdpz(long value);

public  void setQrsz(long value);

public  void setNbsh(long value);

public  void setYzpz(long value);
}
