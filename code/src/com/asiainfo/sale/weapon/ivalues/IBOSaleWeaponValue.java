package com.asiainfo.sale.weapon.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOSaleWeaponValue extends DataStructInterface{

  public final static  String S_ValuePermonth = "VALUE_PERMONTH";
  public final static  String S_Staffid = "STAFFID";
  public final static  String S_ConfigTime = "CONFIG_TIME";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_PresentBusi5Amount = "PRESENT_BUSI5_AMOUNT";
  public final static  String S_FeeAccountProperty = "FEE_ACCOUNT_PROPERTY";
  public final static  String S_MaxnetAge = "MAXNET_AGE";
  public final static  String S_OpenMonth = "OPEN_MONTH";
  public final static  String S_AddMonthcharge = "ADD_MONTHCHARGE";
  public final static  String S_Id = "ID";
  public final static  String S_MarketType = "MARKET_TYPE";
  public final static  String S_ReferencePrice = "REFERENCE_PRICE";
  public final static  String S_SubjectName = "SUBJECT_NAME";
  public final static  String S_GlobalScore = "GLOBAL_SCORE";
  public final static  String S_BaseMonth = "BASE_MONTH";
  public final static  String S_Firstcharge = "FIRSTCHARGE";
  public final static  String S_BusiType = "BUSI_TYPE";
  public final static  String S_SuggestDate = "SUGGEST_DATE";
  public final static  String S_MinnetAge = "MINNET_AGE";
  public final static  String S_NetAge = "NET_AGE";
  public final static  String S_IsDelete = "IS_DELETE";
  public final static  String S_HomeScore = "HOME_SCORE";
  public final static  String S_PresentReachAmount = "PRESENT_REACH_AMOUNT";
  public final static  String S_PresentBusi4Amount = "PRESENT_BUSI4_AMOUNT";
  public final static  String S_ZfqType = "ZFQ_TYPE";
  public final static  String S_LLimit = "L_LIMIT";
  public final static  String S_ReturnType = "RETURN_TYPE";
  public final static  String S_TermType = "TERM_TYPE";
  public final static  String S_Remark4 = "REMARK_4";
  public final static  String S_SzxScore = "SZX_SCORE";
  public final static  String S_Remark3 = "REMARK_3";
  public final static  String S_State = "STATE";
  public final static  String S_Remark5 = "REMARK_5";
  public final static  String S_ModifyTime = "MODIFY_TIME";
  public final static  String S_WeaponName = "WEAPON_NAME";
  public final static  String S_Remark2 = "REMARK_2";
  public final static  String S_TermRealFee = "TERM_REAL_FEE";
  public final static  String S_Remark1 = "REMARK_1";
  public final static  String S_AgreementValue = "AGREEMENT_VALUE";
  public final static  String S_BasePrice = "BASE_PRICE";
  public final static  String S_Mid = "MID";
  public final static  String S_StandbyNum1 = "STANDBY_NUM1";
  public final static  String S_StandbyNum2 = "STANDBY_NUM2";
  public final static  String S_StandbyNum3 = "STANDBY_NUM3";
  public final static  String S_PresentBusi2Amount = "PRESENT_BUSI2_AMOUNT";
  public final static  String S_DataBusiType = "DATA_BUSI_TYPE";
  public final static  String S_PrestoreFee = "PRESTORE_FEE";
  public final static  String S_BLimit = "B_LIMIT";
  public final static  String S_GoodAdoptDirectory = "GOOD_ADOPT_DIRECTORY";
  public final static  String S_PresentBusiMonth = "PRESENT_BUSI_MONTH";
  public final static  String S_PresentValuePermon = "PRESENT_VALUE_PERMON";
  public final static  String S_PrestroreReachAccount = "PRESTRORE_REACH_ACCOUNT";
  public final static  String S_TermCostFee = "TERM_COST_FEE";
  public final static  String S_BackMonth = "BACK_MONTH";
  public final static  String S_DataFee = "DATA_FEE";
  public final static  String S_PresentBusiAmount = "PRESENT_BUSI_AMOUNT";
  public final static  String S_TermGuideFee = "TERM_GUIDE_FEE";
  public final static  String S_Lastcharge = "LASTCHARGE";
  public final static  String S_SaleFlag = "SALE_FLAG";
  public final static  String S_PresentBusi3Amount = "PRESENT_BUSI3_AMOUNT";
  public final static  String S_DynamicScore = "DYNAMIC_SCORE";
  public final static  String S_LimType = "LIM_TYPE";
  public final static  String S_AddMonthchargeHb = "ADD_MONTHCHARGE_HB";
  public final static  String S_ReturnTypeHb = "RETURN_TYPE_HB";
  public final static  String S_FirstchargeHb = "FIRSTCHARGE_HB";
  public final static  String S_LastchargeHb = "LASTCHARGE_HB";
  public final static  String S_PresentBusi2AmountHb = "PRESENT_BUSI2_AMOUNT_HB";
  public final static  String S_StandbyNum1Hb = "STANDBY_NUM1_HB";

public void undelete();
  
public double getValuePermonth();

public String getStaffid();

public Timestamp getConfigTime();

public Timestamp getCreateTime();

public double getPresentBusi5Amount();

public String getFeeAccountProperty();

public int getMaxnetAge();

public int getOpenMonth();

public String getAddMonthcharge();

public String getId();

public String getMarketType();

public double getReferencePrice();

public String getSubjectName();

public int getGlobalScore();

public int getBaseMonth();

public String getFirstcharge();

public String getBusiType();

public Timestamp getSuggestDate();

public int getMinnetAge();

public String getNetAge();

public String getIsDelete();

public int getHomeScore();

public double getPresentReachAmount();

public double getPresentBusi4Amount();

public String getZfqType();

public int getLLimit();

public String getReturnType();

public String getTermType();

public String getRemark4();

public int getSzxScore();

public String getRemark3();

public String getState();

public String getRemark5();

public Timestamp getModifyTime();

public String getWeaponName();

public String getRemark2();

public String getTermRealFee();

public String getRemark1();

public double getAgreementValue();

public double getBasePrice();

public String getMid();

public String getStandbyNum1();

public String getStandbyNum2();

public String getStandbyNum3();

public double getPresentBusi2Amount();

public String getDataBusiType();

public double getPrestoreFee();

public int getBLimit();

public String getGoodAdoptDirectory();

public int getPresentBusiMonth();

public double getPresentValuePermon();

public double getPrestroreReachAccount();

public double getTermCostFee();

public int getBackMonth();

public double getDataFee();

public double getPresentBusiAmount();

public double getTermGuideFee();

public String getLastcharge();

public String getSaleFlag();

public double getPresentBusi3Amount();

public int getDynamicScore();

public String getLimType();

public String getAddMonthchargeHb();

public String getReturnTypeHb();

public String getFirstchargeHb();

public String getLastchargeHb();

public double getPresentBusi2AmountHb();

public String getStandbyNum1Hb();

public  void setValuePermonth(double value);

public  void setStaffid(String value);

public  void setConfigTime(Timestamp value);

public  void setCreateTime(Timestamp value);

public  void setPresentBusi5Amount(double value);

public  void setFeeAccountProperty(String value);

public  void setMaxnetAge(int value);

public  void setOpenMonth(int value);

public  void setAddMonthcharge(String value);

public  void setId(String value);

public  void setMarketType(String value);

public  void setReferencePrice(double value);

public  void setSubjectName(String value);

public  void setGlobalScore(int value);

public  void setBaseMonth(int value);

public  void setFirstcharge(String value);

public  void setBusiType(String value);

public  void setSuggestDate(Timestamp value);

public  void setMinnetAge(int value);

public  void setNetAge(String value);

public  void setIsDelete(String value);

public  void setHomeScore(int value);

public  void setPresentReachAmount(double value);

public  void setPresentBusi4Amount(double value);

public  void setZfqType(String value);

public  void setLLimit(int value);

public  void setReturnType(String value);

public  void setTermType(String value);

public  void setRemark4(String value);

public  void setSzxScore(int value);

public  void setRemark3(String value);

public  void setState(String value);

public  void setRemark5(String value);

public  void setModifyTime(Timestamp value);

public  void setWeaponName(String value);

public  void setRemark2(String value);

public  void setTermRealFee(String value);

public  void setRemark1(String value);

public  void setAgreementValue(double value);

public  void setBasePrice(double value);

public  void setMid(String value);

public  void setStandbyNum1(String value);

public  void setStandbyNum2(String value);

public  void setStandbyNum3(String value);

public  void setPresentBusi2Amount(double value);

public  void setDataBusiType(String value);

public  void setPrestoreFee(double value);

public  void setBLimit(int value);

public  void setGoodAdoptDirectory(String value);

public  void setPresentBusiMonth(int value);

public  void setPresentValuePermon(double value);

public  void setPrestroreReachAccount(double value);

public  void setTermCostFee(double value);

public  void setBackMonth(int value);

public  void setDataFee(double value);

public  void setPresentBusiAmount(double value);

public  void setTermGuideFee(double value);

public  void setLastcharge(String value);

public  void setSaleFlag(String value);

public  void setPresentBusi3Amount(double value);

public  void setDynamicScore(int value);

public void setLimType(String value);

public  void setAddMonthchargeHb(String value);

public  void setReturnTypeHb(String value);

public  void setFirstchargeHb(String value);

public  void setLastchargeHb(String value);

public  void setPresentBusi2AmountHb(double value);

public  void setStandbyNum1Hb(String value);

}
