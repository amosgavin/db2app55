package com.asiainfo.sale.activity.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOUsedQueryValue extends DataStructInterface{

  public final static  String S_ActionOutYearPer = "ACTION_OUT_YEAR_PER";
  public final static  String S_CityCode = "CITY_CODE";
  public final static  String S_TerminalCostYearPer = "TERMINAL_COST_YEAR_PER";
  public final static  String S_CxpCostYear = "CXP_COST_YEAR";
  public final static  String S_CxpCostYearPer = "CXP_COST_YEAR_PER";
  public final static  String S_JfDzqCostYearPer = "JF_DZQ_COST_YEAR_PER";
  public final static  String S_Createorg = "CREATEORG";
  public final static  String S_TerminalCostYear = "TERMINAL_COST_YEAR";
  public final static  String S_ActionOutYear = "ACTION_OUT_YEAR";
  public final static  String S_FjfDzqCostYear = "FJF_DZQ_COST_YEAR";
  public final static  String S_FjfDzqCostYearPer = "FJF_DZQ_COST_YEAR_PER";
  public final static  String S_PrivsetidName = "PRIVSETID_NAME";
  public final static  String S_JfDzqCostYear = "JF_DZQ_COST_YEAR";
  public final static  String S_UserNum = "USER_NUM";


public long getActionOutYearPer();

public String getCityCode();

public long getTerminalCostYearPer();

public long getCxpCostYear();

public long getCxpCostYearPer();

public long getJfDzqCostYearPer();

public String getCreateorg();

public long getTerminalCostYear();

public long getActionOutYear();

public long getFjfDzqCostYear();

public long getFjfDzqCostYearPer();

public String getPrivsetidName();

public long getJfDzqCostYear();

public long getUserNum();


public  void setActionOutYearPer(long value);

public  void setCityCode(String value);

public  void setTerminalCostYearPer(long value);

public  void setCxpCostYear(long value);

public  void setCxpCostYearPer(long value);

public  void setJfDzqCostYearPer(long value);

public  void setCreateorg(String value);

public  void setTerminalCostYear(long value);

public  void setActionOutYear(long value);

public  void setFjfDzqCostYear(long value);

public  void setFjfDzqCostYearPer(long value);

public  void setPrivsetidName(String value);

public  void setJfDzqCostYear(long value);

public  void setUserNum(long value);
}
