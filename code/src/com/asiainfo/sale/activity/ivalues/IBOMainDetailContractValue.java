package com.asiainfo.sale.activity.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOMainDetailContractValue extends DataStructInterface{

  public final static  String S_SaleMainName = "SALE_MAIN_NAME";
  public final static  String S_SaleActiveName = "SALE_ACTIVE_NAME";
  public final static  String S_IsContract = "IS_CONTRACT";
  public final static  String S_SaleMainCode = "SALE_MAIN_CODE";
  public final static  String S_SaleActiveCode = "SALE_ACTIVE_CODE";


public String getSaleMainName();

public String getSaleActiveName();

public String getIsContract();

public String getSaleMainCode();

public String getSaleActiveCode();


public  void setSaleMainName(String value);

public  void setSaleActiveName(String value);

public  void setIsContract(String value);

public  void setSaleMainCode(String value);

public  void setSaleActiveCode(String value);
}
