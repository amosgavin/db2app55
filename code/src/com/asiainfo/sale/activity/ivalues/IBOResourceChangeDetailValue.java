package com.asiainfo.sale.activity.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOResourceChangeDetailValue extends DataStructInterface{

  public final static  String S_LTerm = "L_TERM";
  public final static  String S_CTerm = "C_TERM";
  public final static  String S_PDisc = "P_DISC";
  public final static  String S_CPoints = "C_POINTS";
  public final static  String S_ResourceId = "RESOURCE_ID";
  public final static  String S_ResourcedId = "RESOURCED_ID";
  public final static  String S_LPoints = "L_POINTS";
  public final static  String S_PPoints = "P_POINTS";
  public final static  String S_LDisc = "L_DISC";
  public final static  String S_PPromt = "P_PROMT";
  public final static  String S_PTerm = "P_TERM";
  public final static  String S_LPromt = "L_PROMT";
  public final static  String S_CDisc = "C_DISC";
  public final static  String S_CPromt = "C_PROMT";


public double getLTerm();

public double getCTerm();

public double getPDisc();

public double getCPoints();

public int getResourceId();

public int getResourcedId();

public double getLPoints();

public double getPPoints();

public double getLDisc();

public double getPPromt();

public double getPTerm();

public double getLPromt();

public double getCDisc();

public double getCPromt();


public  void setLTerm(double value);

public  void setCTerm(double value);

public  void setPDisc(double value);

public  void setCPoints(double value);

public  void setResourceId(int value);

public  void setResourcedId(int value);

public  void setLPoints(double value);

public  void setPPoints(double value);

public  void setLDisc(double value);

public  void setPPromt(double value);

public  void setPTerm(double value);

public  void setLPromt(double value);

public  void setCDisc(double value);

public  void setCPromt(double value);
}
