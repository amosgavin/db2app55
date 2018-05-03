package com.asiainfo.sale.complain.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOOrderComplainsDetailValue extends DataStructInterface{

  public final static  String S_ComplainsType = "COMPLAINS_TYPE";
  public final static  String S_ComplainsReason = "COMPLAINS_REASON";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_OrderStaff = "ORDER_STAFF";
  public final static  String S_BossId = "BOSS_ID";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_OrderTime = "ORDER_TIME";
  public final static  String S_Id = "ID";
  public final static  String S_IsDelete = "IS_DELETE";
  public final static  String S_Principle = "PRINCIPLE";
  public final static  String S_OrderName = "ORDER_NAME";
  public final static  String S_ComplainsId = "COMPLAINS_ID";


public String getComplainsType();

public String getComplainsReason();

public int getOrderId();

public String getOrderStaff();

public String getBossId();

public Timestamp getCreateTime();

public Timestamp getOrderTime();

public int getId();

public String getIsDelete();

public String getPrinciple();

public String getOrderName();

public int getComplainsId();


public  void setComplainsType(String value);

public  void setComplainsReason(String value);

public  void setOrderId(int value);

public  void setOrderStaff(String value);

public  void setBossId(String value);

public  void setCreateTime(Timestamp value);

public  void setOrderTime(Timestamp value);

public  void setId(int value);

public  void setIsDelete(String value);

public  void setPrinciple(String value);

public  void setOrderName(String value);

public  void setComplainsId(int value);

public void undelete();
}
