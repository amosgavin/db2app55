package com.asiainfo.sale.activity.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBORelateSaleWithGoodsValue extends DataStructInterface{

  public final static  String S_TagId = "TAG_ID";
  public final static  String S_Remark1 = "REMARK1";
  public final static  String S_Remark2 = "REMARK2";
  public final static  String S_Remark3 = "REMARK3";
  public final static  String S_SaleId = "SALE_ID";
  public final static  String S_Id = "ID";


public int getTagId();

public int getRemark1();

public String getRemark2();

public String getRemark3();

public int getSaleId();

public int getId();


public  void setTagId(int value);

public  void setRemark1(int value);

public  void setRemark2(String value);

public  void setRemark3(String value);

public  void setSaleId(int value);

public  void setId(int value);
}
