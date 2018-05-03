package com.asiainfo.sale.activity.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOSaleHbHbValue extends DataStructInterface{

  public final static  String S_TakeEffectTime = "TAKE_EFFECT_TIME";
  public final static  String S_AomSmsContent = "AOM_SMS_CONTENT";
  public final static  String S_Remark1 = "REMARK1";
  public final static  String S_Mid = "MID";
  public final static  String S_ProvideArea = "PROVIDE_AREA";
  public final static  String S_Remark3 = "REMARK3";
  public final static  String S_Remark2 = "REMARK2";
  public final static  String S_ProvideWholesaleNum = "PROVIDE_WHOLESALE_NUM";
  public final static  String S_Remark4 = "REMARK4";
  public final static  String S_SaleName = "SALE_NAME";
  public final static  String S_EitName = "EIT_NAME";
  public final static  String S_LoseEffectTime = "LOSE_EFFECT_TIME";
  public final static  String S_ProvideEndDate = "PROVIDE_END_DATE";
  public final static  String S_ProvideBeginDate = "PROVIDE_BEGIN_DATE";
  public final static  String S_ArriveOfMoneySms = "ARRIVE_OF_MONEY_SMS";
  public final static  String S_Id = "ID";
  public final static  String S_ProvideCall = "PROVIDE_CALL";


public Timestamp getTakeEffectTime();

public String getAomSmsContent();

public String getRemark1();

public String getMid();

public String getProvideArea();

public long getRemark3();

public String getRemark2();

public long getProvideWholesaleNum();

public String getRemark4();

public String getSaleName();

public String getEitName();

public Timestamp getLoseEffectTime();

public Timestamp getProvideEndDate();

public Timestamp getProvideBeginDate();

public String getArriveOfMoneySms();

public long getId();

public String getProvideCall();


public  void setTakeEffectTime(Timestamp value);

public  void setAomSmsContent(String value);

public  void setRemark1(String value);

public  void setMid(String value);

public  void setProvideArea(String value);

public  void setRemark3(long value);

public  void setRemark2(String value);

public  void setProvideWholesaleNum(long value);

public  void setRemark4(String value);

public  void setSaleName(String value);

public  void setEitName(String value);

public  void setLoseEffectTime(Timestamp value);

public  void setProvideEndDate(Timestamp value);

public  void setProvideBeginDate(Timestamp value);

public  void setArriveOfMoneySms(String value);

public  void setId(long value);

public  void setProvideCall(String value);
}
