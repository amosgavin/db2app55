package com.asiainfo.sale.tag.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOHPPromationTagValue extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_Name = "NAME";
  public final static  String S_Area = "AREA";
  public final static  String S_ModifyTime = "MODIFY_TIME";
  public final static  String S_ShowFlag = "SHOW_FLAG";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_IsSp = "IS_SP";
  public final static  String S_Pid = "PID";
  public final static  String S_Fill = "FILL";
  public final static  String S_FirstClassify = "FIRST_CLASSIFY";
  public final static  String S_TagCode = "TAG_CODE";
  public final static  String S_Remark = "REMARK";
  public final static  String S_Charge = "CHARGE";
  public final static  String S_AccountType = "ACCOUNT_TYPE";
  public final static  String S_Cycle = "CYCLE";
  public final static  String S_TagType = "TAG_TYPE";
  public final static  String S_StockNumber = "STOCK_NUMBER";
  public final static  String S_StockFlag = "STOCK_FLAG";
  public final static  String S_ThirfClassify = "THIRF_CLASSIFY";
  public final static  String S_OverdueTime = "OVERDUE_TIME";
  public final static  String S_Sumcharge = "SUMCHARGE";
  public final static  String S_Id = "ID";
  public final static  String S_StockCharge = "STOCK_CHARGE";


public String getState();

public String getName();

public String getArea();

public Timestamp getModifyTime();

public String getShowFlag();

public Timestamp getCreateTime();

public String getIsSp();

public int getPid();

public String getFill();

public String getFirstClassify();

public String getTagCode();

public String getRemark();

public double getCharge();

public String getAccountType();

public int getCycle();

public String getTagType();

public String getStockNumber();

public String getStockFlag();

public String getThirfClassify();

public Timestamp getOverdueTime();

public double getSumcharge();

public int getId();

public double getStockCharge();


public  void setState(String value);

public  void setName(String value);

public  void setArea(String value);

public  void setModifyTime(Timestamp value);

public  void setShowFlag(String value);

public  void setCreateTime(Timestamp value);

public  void setIsSp(String value);

public  void setPid(int value);

public  void setFill(String value);

public  void setFirstClassify(String value);

public  void setTagCode(String value);

public  void setRemark(String value);

public  void setCharge(double value);

public  void setAccountType(String value);

public  void setCycle(int value);

public  void setTagType(String value);

public  void setStockNumber(String value);

public  void setStockFlag(String value);

public  void setThirfClassify(String value);

public  void setOverdueTime(Timestamp value);

public  void setSumcharge(double value);

public  void setId(int value);

public  void setStockCharge(double value);
}
