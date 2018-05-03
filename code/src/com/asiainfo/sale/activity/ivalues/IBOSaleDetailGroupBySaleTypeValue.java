package com.asiainfo.sale.activity.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOSaleDetailGroupBySaleTypeValue extends DataStructInterface{

  public final static  String S_SaleId = "SALE_ID";
  public final static  String S_Scount = "SCOUNT";
  public final static  String S_SaleFlag = "SALE_FLAG";


public long getSaleId();

public long getScount();

public String getSaleFlag();


public  void setSaleId(long value);

public  void setScount(long value);

public  void setSaleFlag(String value);
}
