package com.asiainfo.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOProductAttachCfgValue extends DataStructInterface{

  public final static  String S_RelaOrderId = "RELA_ORDER_ID";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_RelaOrderType = "RELA_ORDER_TYPE";
  public final static  String S_Id = "ID";
  public final static  String S_Principle = "PRINCIPLE";
  public final static  String S_Flag = "FLAG";
  public final static  String S_OrgId = "ORG_ID";


public String getRelaOrderId();

public Timestamp getCreateTime();

public String getRelaOrderType();

public int getId();

public String getPrinciple();

public String getFlag();

public String getOrgId();


public  void setRelaOrderId(String value);

public  void setCreateTime(Timestamp value);

public  void setRelaOrderType(String value);

public  void setId(int value);

public  void setPrinciple(String value);

public  void setFlag(String value);

public  void setOrgId(String value);
}
