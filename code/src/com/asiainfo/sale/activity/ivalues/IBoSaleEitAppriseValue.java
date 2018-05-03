package com.asiainfo.sale.activity.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBoSaleEitAppriseValue extends DataStructInterface{

  public final static  String S_AomSmsContent = "AOM_SMS_CONTENT";
  public final static  String S_TriggerCondition = "TRIGGER_CONDITION";
  public final static  String S_ProvideArea = "PROVIDE_AREA";
  public final static  String S_SampleDealInterval = "SAMPLE_DEAL_INTERVAL";
  public final static  String S_MaxProvidenumOneday = "MAX_PROVIDENUM_ONEDAY";
  public final static  String S_SaleName = "SALE_NAME";
  public final static  String S_Mid = "MID";
  public final static  String S_MaxReceivenumIncycle = "MAX_RECEIVENUM_INCYCLE";
  public final static  String S_OfdSmsContent = "OFD_SMS_CONTENT";
  public final static  String S_UseBusiProp = "USE_BUSI_PROP";
  public final static  String S_ProvideBeginDate = "PROVIDE_BEGIN_DATE";
  public final static  String S_Id = "ID";
  public final static  String S_MaxReceivenumInliquid = "MAX_RECEIVENUM_INLIQUID";
  public final static  String S_OutOfDateSms = "OUT_OF_DATE_SMS";
  public final static  String S_ParticipateCycle = "PARTICIPATE_CYCLE";
  public final static  String S_EitName = "EIT_NAME";
  public final static  String S_ReceiveBusiPerson = "RECEIVE_BUSI_PERSON";
  public final static  String S_Remark1 = "REMARK1";
  public final static  String S_Remark2 = "REMARK2";
  public final static  String S_Remark3 = "REMARK3";
  public final static  String S_Remark4 = "REMARK4";
  public final static  String S_Remark5 = "REMARK5";
  public final static  String S_ProvideCall = "PROVIDE_CALL";
  public final static  String S_ProvideEndDate = "PROVIDE_END_DATE";
  public final static  String S_LevcodeRelaLevid = "LEVCODE_RELA_LEVID";
  public final static  String S_ArriveOfMoneySms = "ARRIVE_OF_MONEY_SMS";
  public final static  String S_ActiveType = "ACTIVE_TYPE";
  public final static  String S_ChannelChargeProp = "CHANNEL_CHARGE_PROP";
  public final static  String S_SampleEitValid = "SAMPLE_EIT_VALID";
  public final static  String S_UseBusiPerson = "USE_BUSI_PERSON";
  public final static  String S_AfterBuyeitValid = "AFTER_BUYEIT_VALID";
  public final static  String S_ProvideWholesaleNum = "PROVIDE_WHOLESALE_NUM";
  public final static  String S_AlluseValidDate = "ALLUSE_VALID_DATE";
  public final static  String S_ReceiveBusiProp = "RECEIVE_BUSI_PROP";


public String getAomSmsContent();

public String getTriggerCondition();

public String getProvideArea();

public String getSampleDealInterval();

public String getMaxProvidenumOneday();

public String getSaleName();

public String getMid();

public String getMaxReceivenumIncycle();

public String getOfdSmsContent();

public String getUseBusiProp();

public Timestamp getProvideBeginDate();

public int getId();

public String getMaxReceivenumInliquid();

public String getOutOfDateSms();

public String getParticipateCycle();

public String getEitName();

public String getReceiveBusiPerson();

public String getRemark1();

public String getRemark2();

public String getRemark3();

public String getRemark4();

public String getRemark5();

public String getProvideCall();

public Timestamp getProvideEndDate();

public String getLevcodeRelaLevid();

public String getArriveOfMoneySms();

public String getActiveType();

public String getChannelChargeProp();

public String getSampleEitValid();

public String getUseBusiPerson();

public String getAfterBuyeitValid();

public double getProvideWholesaleNum();

public Timestamp getAlluseValidDate();

public String getReceiveBusiProp();


public  void setAomSmsContent(String value);

public  void setTriggerCondition(String value);

public  void setProvideArea(String value);

public  void setSampleDealInterval(String value);

public  void setMaxProvidenumOneday(String value);

public  void setSaleName(String value);

public  void setMid(String value);

public  void setMaxReceivenumIncycle(String value);

public  void setOfdSmsContent(String value);

public  void setUseBusiProp(String value);

public  void setProvideBeginDate(Timestamp value);

public  void setId(int value);

public  void setMaxReceivenumInliquid(String value);

public  void setOutOfDateSms(String value);

public  void setParticipateCycle(String value);

public  void setEitName(String value);

public  void setReceiveBusiPerson(String value);

public  void setRemark1(String value);

public  void setRemark2(String value);

public  void setRemark3(String value);

public  void setRemark4(String value);

public  void setRemark5(String value);

public  void setProvideCall(String value);

public  void setProvideEndDate(Timestamp value);

public  void setLevcodeRelaLevid(String value);

public  void setArriveOfMoneySms(String value);

public  void setActiveType(String value);

public  void setChannelChargeProp(String value);

public  void setSampleEitValid(String value);

public  void setUseBusiPerson(String value);

public  void setAfterBuyeitValid(String value);

public  void setProvideWholesaleNum(double value);

public  void setAlluseValidDate(Timestamp value);

public  void setReceiveBusiProp(String value);
}
