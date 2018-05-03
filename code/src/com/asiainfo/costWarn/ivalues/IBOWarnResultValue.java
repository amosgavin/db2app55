package com.asiainfo.costWarn.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOWarnResultValue extends DataStructInterface{

  public final static  String S_Remark1 = "REMARK1";
  public final static  String S_CityCode = "CITY_CODE";
  public final static  String S_Remark2 = "REMARK2";
  public final static  String S_Remark3 = "REMARK3";
  public final static  String S_TerminalCost = "TERMINAL_COST";
  public final static  String S_Remark4 = "REMARK4";
  public final static  String S_SaleActiveName = "SALE_ACTIVE_NAME";
  public final static  String S_InsertTime = "INSERT_TIME";
  public final static  String S_PerPromoteScore = "PER_PROMOTE_SCORE";
  public final static  String S_SaleActiveCode = "SALE_ACTIVE_CODE";
  public final static  String S_IsDelete = "IS_DELETE";
  public final static  String S_PerActionOut = "PER_ACTION_OUT";
  public final static  String S_PerTerminalCost = "PER_TERMINAL_COST";
  public final static  String S_SaleMainName = "SALE_MAIN_NAME";
  public final static  String S_SalePoint = "SALE_POINT";
  public final static  String S_SaleMainCode = "SALE_MAIN_CODE";
  public final static  String S_ActionOut = "ACTION_OUT";
  public final static  String S_PromoteScore = "PROMOTE_SCORE";
  public final static  String S_PerSalePoint = "PER_SALE_POINT";


public String getRemark1();

public String getCityCode();

public String getRemark2();

public String getRemark3();

public double getTerminalCost();

public String getRemark4();

public String getSaleActiveName();

public Timestamp getInsertTime();

public double getPerPromoteScore();

public String getSaleActiveCode();

public String getIsDelete();

public double getPerActionOut();

public double getPerTerminalCost();

public String getSaleMainName();

public double getSalePoint();

public String getSaleMainCode();

public double getActionOut();

public double getPromoteScore();

public double getPerSalePoint();


public  void setRemark1(String value);

public  void setCityCode(String value);

public  void setRemark2(String value);

public  void setRemark3(String value);

public  void setTerminalCost(double value);

public  void setRemark4(String value);

public  void setSaleActiveName(String value);

public  void setInsertTime(Timestamp value);

public  void setPerPromoteScore(double value);

public  void setSaleActiveCode(String value);

public  void setIsDelete(String value);

public  void setPerActionOut(double value);

public  void setPerTerminalCost(double value);

public  void setSaleMainName(String value);

public  void setSalePoint(double value);

public  void setSaleMainCode(String value);

public  void setActionOut(double value);

public  void setPromoteScore(double value);

public  void setPerSalePoint(double value);
}
