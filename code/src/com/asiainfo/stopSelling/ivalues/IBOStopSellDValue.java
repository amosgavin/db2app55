package com.asiainfo.stopSelling.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOStopSellDValue extends DataStructInterface{

  public final static  String S_Remark1 = "REMARK1";
  public final static  String S_Remark2 = "REMARK2";
  public final static  String S_Remark3 = "REMARK3";
  public final static  String S_ExeArea = "EXE_AREA";
  public final static  String S_Remark4 = "REMARK4";
  public final static  String S_BusiType = "BUSI_TYPE";
  public final static  String S_BatchCode = "BATCH_CODE";
  public final static  String S_BatchName = "BATCH_NAME";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_EndDate = "END_DATE";
  public final static  String S_PreOffdate = "PRE_OFFDATE";
  public final static  String S_IsDelete = "IS_DELETE";
  public final static  String S_ChargeType = "CHARGE_TYPE";
  public final static  String S_Mainid = "MAINID";
  public final static  String S_Market = "MARKET";
  public final static  String S_LevelCode = "LEVEL_CODE";
  public final static  String S_Id = "ID";
  public final static  String S_WorkDate = "WORK_DATE";
  public final static  String S_LevelName = "LEVEL_NAME";

public void undelete();

public String getRemark1();

public String getRemark2();

public String getRemark3();

public String getExeArea();

public String getRemark4();

public String getBusiType();

public String getBatchCode();

public String getBatchName();

public String getDescription();

public Timestamp getEndDate();

public Timestamp getPreOffdate();

public String getIsDelete();

public String getChargeType();

public int getMainid();

public String getMarket();

public String getLevelCode();

public int getId();

public Timestamp getWorkDate();

public String getLevelName();


public  void setRemark1(String value);

public  void setRemark2(String value);

public  void setRemark3(String value);

public  void setExeArea(String value);

public  void setRemark4(String value);

public  void setBusiType(String value);

public  void setBatchCode(String value);

public  void setBatchName(String value);

public  void setDescription(String value);

public  void setEndDate(Timestamp value);

public  void setPreOffdate(Timestamp value);

public  void setIsDelete(String value);

public  void setChargeType(String value);

public  void setMainid(int value);

public  void setMarket(String value);

public  void setLevelCode(String value);

public  void setId(int value);

public  void setWorkDate(Timestamp value);

public  void setLevelName(String value);
}
