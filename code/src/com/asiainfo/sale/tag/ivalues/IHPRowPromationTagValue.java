package com.asiainfo.sale.tag.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IHPRowPromationTagValue extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_ModifyTime = "MODIFY_TIME";
  public final static  String S_Pid = "PID";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_Remark = "REMARK";
  public final static  String S_TagCode = "TAG_CODE";
  public final static  String S_Cycle = "CYCLE";
  public final static  String S_AccountType = "ACCOUNT_TYPE";
  public final static  String S_TagType = "TAG_TYPE";
  public final static  String S_Atid = "ATID";
  public final static  String S_Id = "ID";
  public final static  String S_StockCharge = "STOCK_CHARGE";
  public final static  String S_Remark1 = "REMARK1";
  public final static  String S_Remark2 = "REMARK2";
  public final static  String S_Name = "NAME";
  public final static  String S_Remark3 = "REMARK3";
  public final static  String S_Area = "AREA";
  public final static  String S_IsSp = "IS_SP";
  public final static  String S_ShowFlag = "SHOW_FLAG";
  public final static  String S_SaleId = "SALE_ID";
  public final static  String S_Fill = "FILL";
  public final static  String S_Charge = "CHARGE";
  public final static  String S_StockNumber = "STOCK_NUMBER";
  public final static  String S_StockFlag = "STOCK_FLAG";
  public final static  String S_Sumcharge = "SUMCHARGE";


public String getState();

public Timestamp getModifyTime();

public long getPid();

public Timestamp getCreateTime();

public String getRemark();

public String getTagCode();

public long getCycle();

public String getAccountType();

public String getTagType();

public long getAtid();

public long getId();

public long getStockCharge();

public long getRemark1();

public String getRemark2();

public String getName();

public String getRemark3();

public String getArea();

public String getIsSp();

public String getShowFlag();

public long getSaleId();

public String getFill();

public long getCharge();

public String getStockNumber();

public String getStockFlag();

public long getSumcharge();


public  void setState(String value);

public  void setModifyTime(Timestamp value);

public  void setPid(long value);

public  void setCreateTime(Timestamp value);

public  void setRemark(String value);

public  void setTagCode(String value);

public  void setCycle(long value);

public  void setAccountType(String value);

public  void setTagType(String value);

public  void setAtid(long value);

public  void setId(long value);

public  void setStockCharge(long value);

public  void setRemark1(long value);

public  void setRemark2(String value);

public  void setName(String value);

public  void setRemark3(String value);

public  void setArea(String value);

public  void setIsSp(String value);

public  void setShowFlag(String value);

public  void setSaleId(long value);

public  void setFill(String value);

public  void setCharge(long value);

public  void setStockNumber(String value);

public  void setStockFlag(String value);

public  void setSumcharge(long value);
}
