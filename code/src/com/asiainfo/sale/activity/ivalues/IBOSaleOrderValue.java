package com.asiainfo.sale.activity.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOSaleOrderValue extends DataStructInterface{

  public final static  String S_Remark1 = "REMARK1";
  public final static  String S_State = "STATE";
  public final static  String S_Remark2 = "REMARK2";
  public final static  String S_Remark3 = "REMARK3";
  public final static  String S_Remark4 = "REMARK4";
  public final static  String S_Remark5 = "REMARK5";
  public final static  String S_OrgName = "ORG_NAME";
  public final static  String S_IsDelete = "IS_DELETE";
  public final static  String S_Principle = "PRINCIPLE";
  public final static  String S_OrderName = "ORDER_NAME";
  public final static  String S_BatchCnt = "BATCH_CNT";
  public final static  String S_OrgId = "ORG_ID";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_PropName = "PROP_NAME";
  public final static  String S_CreateDate = "CREATE_DATE";


public String getRemark1();

public String getState();

public String getRemark2();

public String getRemark3();

public String getRemark4();

public String getRemark5();

public String getOrgName();

public String getIsDelete();

public String getPrinciple();

public String getOrderName();

public int getBatchCnt();

public String getOrgId();

public int getOrderId();

public String getPropName();

public Timestamp getCreateDate();

public void undelete();

public  void setRemark1(String value);

public  void setState(String value);

public  void setRemark2(String value);

public  void setRemark3(String value);

public  void setRemark4(String value);

public  void setRemark5(String value);

public  void setOrgName(String value);

public  void setIsDelete(String value);

public  void setPrinciple(String value);

public  void setOrderName(String value);

public  void setBatchCnt(int value);

public  void setOrgId(String value);

public  void setOrderId(int value);

public  void setPropName(String value);

public  void setCreateDate(Timestamp value);
}
