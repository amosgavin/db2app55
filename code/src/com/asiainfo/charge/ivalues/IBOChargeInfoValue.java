package com.asiainfo.charge.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOChargeInfoValue extends DataStructInterface{

  public final static  String S_FlowCharge = "FLOW_CHARGE";
  public final static  String S_EarningTotal = "EARNING_TOTAL";
  public final static  String S_ChargeType = "CHARGE_TYPE";
  public final static  String S_Mid = "MID";
  public final static  String S_DoorDamnify = "DOOR_DAMNIFY";
  public final static  String S_Case = "CASE";
  public final static  String S_ChargeCategory = "CHARGE_CATEGORY";
  public final static  String S_InaddUserCount = "INADD_USER_COUNT";
  public final static  String S_ApplyId = "APPLY_ID";
  public final static  String S_FeeMark = "FEE_MARK";
  public final static  String S_DoorEarning = "DOOR_EARNING";
  public final static  String S_NinnerTochargeCount = "NINNER_TOCHARGE_COUNT";
  public final static  String S_IsDelete = "IS_DELETE";
  public final static  String S_PreferentialId2 = "PREFERENTIAL_ID2";
  public final static  String S_PreferentialId1 = "PREFERENTIAL_ID1";
  public final static  String S_PreferentialId4 = "PREFERENTIAL_ID4";
  public final static  String S_FeeName = "FEE_NAME";
  public final static  String S_PreferentialId3 = "PREFERENTIAL_ID3";
  public final static  String S_AddUserMarket = "ADD_USER_MARKET";
  public final static  String S_PreferentialId5 = "PREFERENTIAL_ID5";
  public final static  String S_EarningDamnify = "EARNING_DAMNIFY";
  public final static  String S_IsDivide = "IS_DIVIDE";
  public final static  String S_Ext5 = "EXT5";
  public final static  String S_Ext6 = "EXT6";
  public final static  String S_Ext7 = "EXT7";
  public final static  String S_Ext8 = "EXT8";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_IntendingAcount = "INTENDING_ACOUNT";
  public final static  String S_IsSendSms = "IS_SEND_SMS";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_IsGroup = "IS_GROUP";
  public final static  String S_Ext3 = "EXT3";
  public final static  String S_SpliceMutexRule = "SPLICE_MUTEX_RULE";
  public final static  String S_Ext4 = "EXT4";

  public void unDelete();
public String getFlowCharge();

public String getEarningTotal();

public String getChargeType();

public String getMid();

public double getDoorDamnify();

public String getCase();

public String getChargeCategory();

public String getInaddUserCount();

public String getApplyId();

public String getFeeMark();

public double getDoorEarning();

public int getNinnerTochargeCount();

public String getIsDelete();

public String getPreferentialId2();

public String getPreferentialId1();

public String getPreferentialId4();

public String getFeeName();

public String getPreferentialId3();

public String getAddUserMarket();

public String getPreferentialId5();

public double getEarningDamnify();

public String getIsDivide();

public String getExt5();

public int getExt6();

public int getExt7();

public double getExt8();

public String getExt1();

public int getIntendingAcount();

public String getIsSendSms();

public String getExt2();

public String getIsGroup();

public String getExt3();

public String getSpliceMutexRule();

public String getExt4();


public  void setFlowCharge(String value);

public  void setEarningTotal(String value);

public  void setChargeType(String value);

public  void setMid(String value);

public  void setDoorDamnify(double value);

public  void setCase(String value);

public  void setChargeCategory(String value);

public  void setInaddUserCount(String value);

public  void setApplyId(String value);

public  void setFeeMark(String value);

public  void setDoorEarning(double value);

public  void setNinnerTochargeCount(int value);

public  void setIsDelete(String value);

public  void setPreferentialId2(String value);

public  void setPreferentialId1(String value);

public  void setPreferentialId4(String value);

public  void setFeeName(String value);

public  void setPreferentialId3(String value);

public  void setAddUserMarket(String value);

public  void setPreferentialId5(String value);

public  void setEarningDamnify(double value);

public  void setIsDivide(String value);

public  void setExt5(String value);

public  void setExt6(int value);

public  void setExt7(int value);

public  void setExt8(double value);

public  void setExt1(String value);

public  void setIntendingAcount(int value);

public  void setIsSendSms(String value);

public  void setExt2(String value);

public  void setIsGroup(String value);

public  void setExt3(String value);

public  void setSpliceMutexRule(String value);

public  void setExt4(String value);
}
