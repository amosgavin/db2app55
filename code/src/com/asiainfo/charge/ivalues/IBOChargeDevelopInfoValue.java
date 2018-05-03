package com.asiainfo.charge.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOChargeDevelopInfoValue extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_PlanDate = "PLAN_DATE";
  public final static  String S_Id = "ID";
  public final static  String S_ChargeId = "CHARGE_ID";
  public final static  String S_FinishDate = "FINISH_DATE";
  public final static  String S_Principal = "PRINCIPAL";
  public final static  String S_Code = "CODE";


public String getState();

public Timestamp getPlanDate();

public int getId();

public int getChargeId();

public Timestamp getFinishDate();

public String getPrincipal();

public String getCode();


public  void setState(String value);

public  void setPlanDate(Timestamp value);

public  void setId(int value);

public  void setChargeId(int value);

public  void setFinishDate(Timestamp value);

public  void setPrincipal(String value);

public  void setCode(String value);
}
