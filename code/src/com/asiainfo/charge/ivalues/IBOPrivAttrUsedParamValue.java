package com.asiainfo.charge.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOPrivAttrUsedParamValue extends DataStructInterface{

  public final static  String S_Iscrosscycle = "ISCROSSCYCLE";
  public final static  String S_AttrName = "ATTR_NAME";
  public final static  String S_SqlText = "SQL_TEXT";
  public final static  String S_PrivRate = "PRIV_RATE";
  public final static  String S_PrivUnit = "PRIV_UNIT";
  public final static  String S_Status = "STATUS";
  public final static  String S_PrivType = "PRIV_TYPE";
  public final static  String S_Rateplanid = "RATEPLANID";
  public final static  String S_AccSql = "ACC_SQL";
  public final static  String S_GetType = "GET_TYPE";
  public final static  String S_Iscalbyday = "ISCALBYDAY";
  public final static  String S_Pkgcode = "PKGCODE";
  public final static  String S_PrivCost = "PRIV_COST";
  public final static  String S_Privname = "PRIVNAME";
  public final static  String S_MinBillcycle = "MIN_BILLCYCLE";
  public final static  String S_Privid = "PRIVID";
  public final static  String S_AttrId = "ATTR_ID";


public int getIscrosscycle();

public String getAttrName();

public String getSqlText();

public int getPrivRate();

public String getPrivUnit();

public int getStatus();

public String getPrivType();

public String getRateplanid();

public String getAccSql();

public String getGetType();

public int getIscalbyday();

public String getPkgcode();

public int getPrivCost();

public String getPrivname();

public String getMinBillcycle();

public String getPrivid();

public String getAttrId();


public  void setIscrosscycle(int value);

public  void setAttrName(String value);

public  void setSqlText(String value);

public  void setPrivRate(int value);

public  void setPrivUnit(String value);

public  void setStatus(int value);

public  void setPrivType(String value);

public  void setRateplanid(String value);

public  void setAccSql(String value);

public  void setGetType(String value);

public  void setIscalbyday(int value);

public  void setPkgcode(String value);

public  void setPrivCost(int value);

public  void setPrivname(String value);

public  void setMinBillcycle(String value);

public  void setPrivid(String value);

public  void setAttrId(String value);
}
