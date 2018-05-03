package com.asiainfo.bi.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOTaskDurationCountValue extends DataStructInterface{

  public final static  String S_Scb = "SCB";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_Nbsh = "NBSH";
  public final static  String S_Qrsx = "QRSX";
  public final static  String S_Hdpz = "HDPZ";
  public final static  String S_Yzpz = "YZPZ";
  public final static  String S_False = "FALSE";
  public final static  String S_WorkflowObjectType = "WORKFLOW_OBJECT_TYPE";
  public final static  String S_Total = "TOTAL";
  public final static  String S_Pass = "PASS";


public int getScb();

public String getRegionId();

public int getNbsh();

public int getQrsx();

public int getHdpz();

public int getYzpz();

public int getFalse();

public String getWorkflowObjectType();

public int getTotal();

public int getPass();


public  void setScb(int value);

public  void setRegionId(String value);

public  void setNbsh(int value);

public  void setQrsx(int value);

public  void setHdpz(int value);

public  void setYzpz(int value);

public  void setFalse(int value);

public  void setWorkflowObjectType(String value);

public  void setTotal(int value);

public  void setPass(int value);
}
