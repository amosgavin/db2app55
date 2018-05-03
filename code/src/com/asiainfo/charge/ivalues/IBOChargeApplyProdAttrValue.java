package com.asiainfo.charge.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOChargeApplyProdAttrValue extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_ChargeId = "CHARGE_ID";
  public final static  String S_ProdName = "PROD_NAME";
  public final static  String S_ApplyId = "APPLY_ID";
  public final static  String S_UnitPrice = "UNIT_PRICE";
  public final static  String S_ApplyMainId = "APPLY_MAIN_ID";
  public final static  String S_AreaType = "AREA_TYPE";
  public final static  String S_Principal = "PRINCIPAL";
  public final static  String S_TestItemA = "TEST_ITEM_A";
  public final static  String S_TestItemB = "TEST_ITEM_B";
  public final static  String S_GivesAmount = "GIVES_AMOUNT";
  public final static  String S_ProdType = "PROD_TYPE";
  public final static  String S_TestItemC = "TEST_ITEM_C";
  public final static  String S_AreaName = "AREA_NAME";
  public final static  String S_TestPrincipal = "TEST_PRINCIPAL";
  public final static  String S_Ext5 = "EXT5";
  public final static  String S_Ext6 = "EXT6";
  public final static  String S_GivesAmountType = "GIVES_AMOUNT_TYPE";
  public final static  String S_Ext7 = "EXT7";
  public final static  String S_Ext8 = "EXT8";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_Ext3 = "EXT3";
  public final static  String S_Ext4 = "EXT4";


public String getState();

public String getRemarks();

public String getChargeId();

public String getProdName();

public String getApplyId();

public double getUnitPrice();

public String getApplyMainId();

public String getAreaType();

public String getPrincipal();

public String getTestItemA();

public String getTestItemB();

public String getGivesAmount();

public String getProdType();

public String getTestItemC();

public String getAreaName();

public String getTestPrincipal();

public int getExt5();

public int getExt6();

public String getGivesAmountType();

public double getExt7();

public double getExt8();

public String getExt1();

public String getExt2();

public String getExt3();

public String getExt4();


public  void setState(String value);

public  void setRemarks(String value);

public  void setChargeId(String value);

public  void setProdName(String value);

public  void setApplyId(String value);

public  void setUnitPrice(double value);

public  void setApplyMainId(String value);

public  void setAreaType(String value);

public  void setPrincipal(String value);

public  void setTestItemA(String value);

public  void setTestItemB(String value);

public  void setGivesAmount(String value);

public  void setProdType(String value);

public  void setTestItemC(String value);

public  void setAreaName(String value);

public  void setTestPrincipal(String value);

public  void setExt5(int value);

public  void setExt6(int value);

public  void setGivesAmountType(String value);

public  void setExt7(double value);

public  void setExt8(double value);

public  void setExt1(String value);

public  void setExt2(String value);

public  void setExt3(String value);

public  void setExt4(String value);
}
