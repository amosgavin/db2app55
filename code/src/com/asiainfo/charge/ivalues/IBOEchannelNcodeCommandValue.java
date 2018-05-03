package com.asiainfo.charge.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOEchannelNcodeCommandValue extends DataStructInterface{

  public final static  String S_ProdPackage = "PROD_PACKAGE";
  public final static  String S_OpenCommand = "OPEN_COMMAND";
  public final static  String S_BaseProduct = "BASE_PRODUCT";
  public final static  String S_PriTariff = "PRI_TARIFF";
  public final static  String S_ProdPackage2 = "PROD_PACKAGE2";
  public final static  String S_CancelCommand = "CANCEL_COMMAND";
  public final static  String S_InfoType = "INFO_TYPE";
  public final static  String S_Name = "NAME";
  public final static  String S_Ncode = "NCODE";
  public final static  String S_BusiRule = "BUSI_RULE";
  public final static  String S_GProduct = "G_PRODUCT";
  public final static  String S_AddAttr = "ADD_ATTR";
  public final static  String S_Id = "ID";
  public final static  String S_RelId = "REL_ID";


public String getProdPackage();

public String getOpenCommand();

public String getBaseProduct();

public String getPriTariff();

public String getProdPackage2();

public String getCancelCommand();

public String getInfoType();

public String getName();

public String getNcode();

public String getBusiRule();

public String getGProduct();

public String getAddAttr();

public long getId();

public long getRelId();


public  void setProdPackage(String value);

public  void setOpenCommand(String value);

public  void setBaseProduct(String value);

public  void setPriTariff(String value);

public  void setProdPackage2(String value);

public  void setCancelCommand(String value);

public  void setInfoType(String value);

public  void setName(String value);

public  void setNcode(String value);

public  void setBusiRule(String value);

public  void setGProduct(String value);

public  void setAddAttr(String value);

public  void setId(long value);

public  void setRelId(long value);
}
