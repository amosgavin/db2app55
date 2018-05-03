package com.asiainfo.sale.activity.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOOrderShowValue extends DataStructInterface{

  public final static  String S_Marktype = "MARKTYPE";
  public final static  String S_PrestroreReachAccount = "PRESTRORE_REACH_ACCOUNT";
  public final static  String S_BatchName = "BATCH_NAME";
  public final static  String S_PresentTick = "PRESENT_TICK";
  public final static  String S_Exearea = "EXEAREA";
  public final static  String S_SaleActiveCode = "SALE_ACTIVE_CODE";
  public final static  String S_DigType = "DIG_TYPE";
  public final static  String S_LevelDesc = "LEVEL_DESC";
  public final static  String S_PresentReachAmount = "PRESENT_REACH_AMOUNT";
  public final static  String S_PrestoreFee = "PRESTORE_FEE";
  public final static  String S_Base = "BASE";
  public final static  String S_BeginTime = "BEGIN_TIME";
  public final static  String S_LevelCode = "LEVEL_CODE";
  public final static  String S_BatchId = "BATCH_ID";
  public final static  String S_SaleFlag = "SALE_FLAG";
  public final static  String S_SaleMainCode = "SALE_MAIN_CODE";
  public final static  String S_LevelId = "LEVEL_ID";
  public final static  String S_EndTime = "END_TIME";
  public final static  String S_GoodsNames = "GOODS_NAMES";
  public final static  String S_ReferencePrice = "REFERENCE_PRICE";
  public final static  String S_PresentFee = "PRESENT_FEE";
  public final static  String S_GlobalScore = "GLOBAL_SCORE";
  public final static  String S_LevelName = "LEVEL_NAME";


public String getMarktype();

public long getPrestroreReachAccount();

public String getBatchName();

public String getPresentTick();

public String getExearea();

public String getSaleActiveCode();

public String getDigType();

public String getLevelDesc();

public long getPresentReachAmount();

public String getPrestoreFee();

public String getBase();

public Timestamp getBeginTime();

public String getLevelCode();

public String getBatchId();

public String getSaleFlag();

public String getSaleMainCode();

public String getLevelId();

public Timestamp getEndTime();

public String getGoodsNames();

public long getReferencePrice();

public String getPresentFee();

public long getGlobalScore();

public String getLevelName();


public  void setMarktype(String value);

public  void setPrestroreReachAccount(long value);

public  void setBatchName(String value);

public  void setPresentTick(String value);

public  void setExearea(String value);

public  void setSaleActiveCode(String value);

public  void setDigType(String value);

public  void setLevelDesc(String value);

public  void setPresentReachAmount(long value);

public  void setPrestoreFee(String value);

public  void setBase(String value);

public  void setBeginTime(Timestamp value);

public  void setLevelCode(String value);

public  void setBatchId(String value);

public  void setSaleFlag(String value);

public  void setSaleMainCode(String value);

public  void setLevelId(String value);

public  void setEndTime(Timestamp value);

public  void setGoodsNames(String value);

public  void setReferencePrice(long value);

public  void setPresentFee(String value);

public  void setGlobalScore(long value);

public  void setLevelName(String value);
}
