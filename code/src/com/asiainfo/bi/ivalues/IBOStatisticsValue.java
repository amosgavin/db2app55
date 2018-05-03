package com.asiainfo.bi.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOStatisticsValue extends DataStructInterface{

  public final static  String S_A2 = "A2";
  public final static  String S_A1 = "A1";
  public final static  String S_A3 = "A3";
  public final static  String S_A = "A";
  public final static  String S_OrgId = "ORG_ID";


public long getA2();

public long getA1();

public long getA3();

public long getA();

public long getOrgId();


public  void setA2(long value);

public  void setA1(long value);

public  void setA3(long value);

public  void setA(long value);

public  void setOrgId(long value);
}
