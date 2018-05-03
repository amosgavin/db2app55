package com.asiainfo.sale.weapon.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.weapon.ivalues.*;

public class BOSaleWeaponDeBean extends DataContainer implements DataContainerInterface,IBOSaleWeaponDeValue{

  private static String  m_boName = "com.asiainfo.sale.weapon.bo.BOSaleWeaponDe";



  public final static  String S_ValuePermonth = "VALUE_PERMONTH";
  public final static  String S_Staffid = "STAFFID";
  public final static  String S_ConfigTime = "CONFIG_TIME";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_PresentBusi5Amount = "PRESENT_BUSI5_AMOUNT";
  public final static  String S_FeeAccountProperty = "FEE_ACCOUNT_PROPERTY";
  public final static  String S_MaxnetAge = "MAXNET_AGE";
  public final static  String S_OpenMonth = "OPEN_MONTH";
  public final static  String S_AddMonthcharge = "ADD_MONTHCHARGE";
  public final static  String S_SflagName = "SFLAG_NAME";
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
  public final static  String S_MarketName = "MARKET_NAME";
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
  public final static  String S_ZfqName = "ZFQ_NAME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOSaleWeaponDeBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initValuePermonth(long value){
     this.initProperty(S_ValuePermonth,new Long(value));
  }
  public  void setValuePermonth(long value){
     this.set(S_ValuePermonth,new Long(value));
  }
  public  void setValuePermonthNull(){
     this.set(S_ValuePermonth,null);
  }

  public long getValuePermonth(){
        return DataType.getAsLong(this.get(S_ValuePermonth));
  
  }
  public long getValuePermonthInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ValuePermonth));
      }

  public void initStaffid(String value){
     this.initProperty(S_Staffid,value);
  }
  public  void setStaffid(String value){
     this.set(S_Staffid,value);
  }
  public  void setStaffidNull(){
     this.set(S_Staffid,null);
  }

  public String getStaffid(){
       return DataType.getAsString(this.get(S_Staffid));
  
  }
  public String getStaffidInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Staffid));
      }

  public void initConfigTime(Timestamp value){
     this.initProperty(S_ConfigTime,value);
  }
  public  void setConfigTime(Timestamp value){
     this.set(S_ConfigTime,value);
  }
  public  void setConfigTimeNull(){
     this.set(S_ConfigTime,null);
  }

  public Timestamp getConfigTime(){
        return DataType.getAsDateTime(this.get(S_ConfigTime));
  
  }
  public Timestamp getConfigTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ConfigTime));
      }

  public void initCreateTime(Timestamp value){
     this.initProperty(S_CreateTime,value);
  }
  public  void setCreateTime(Timestamp value){
     this.set(S_CreateTime,value);
  }
  public  void setCreateTimeNull(){
     this.set(S_CreateTime,null);
  }

  public Timestamp getCreateTime(){
        return DataType.getAsDateTime(this.get(S_CreateTime));
  
  }
  public Timestamp getCreateTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CreateTime));
      }

  public void initPresentBusi5Amount(long value){
     this.initProperty(S_PresentBusi5Amount,new Long(value));
  }
  public  void setPresentBusi5Amount(long value){
     this.set(S_PresentBusi5Amount,new Long(value));
  }
  public  void setPresentBusi5AmountNull(){
     this.set(S_PresentBusi5Amount,null);
  }

  public long getPresentBusi5Amount(){
        return DataType.getAsLong(this.get(S_PresentBusi5Amount));
  
  }
  public long getPresentBusi5AmountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PresentBusi5Amount));
      }

  public void initFeeAccountProperty(String value){
     this.initProperty(S_FeeAccountProperty,value);
  }
  public  void setFeeAccountProperty(String value){
     this.set(S_FeeAccountProperty,value);
  }
  public  void setFeeAccountPropertyNull(){
     this.set(S_FeeAccountProperty,null);
  }

  public String getFeeAccountProperty(){
       return DataType.getAsString(this.get(S_FeeAccountProperty));
  
  }
  public String getFeeAccountPropertyInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FeeAccountProperty));
      }

  public void initMaxnetAge(long value){
     this.initProperty(S_MaxnetAge,new Long(value));
  }
  public  void setMaxnetAge(long value){
     this.set(S_MaxnetAge,new Long(value));
  }
  public  void setMaxnetAgeNull(){
     this.set(S_MaxnetAge,null);
  }

  public long getMaxnetAge(){
        return DataType.getAsLong(this.get(S_MaxnetAge));
  
  }
  public long getMaxnetAgeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_MaxnetAge));
      }

  public void initOpenMonth(int value){
     this.initProperty(S_OpenMonth,new Integer(value));
  }
  public  void setOpenMonth(int value){
     this.set(S_OpenMonth,new Integer(value));
  }
  public  void setOpenMonthNull(){
     this.set(S_OpenMonth,null);
  }

  public int getOpenMonth(){
        return DataType.getAsInt(this.get(S_OpenMonth));
  
  }
  public int getOpenMonthInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_OpenMonth));
      }

  public void initAddMonthcharge(String value){
     this.initProperty(S_AddMonthcharge,value);
  }
  public  void setAddMonthcharge(String value){
     this.set(S_AddMonthcharge,value);
  }
  public  void setAddMonthchargeNull(){
     this.set(S_AddMonthcharge,null);
  }

  public String getAddMonthcharge(){
       return DataType.getAsString(this.get(S_AddMonthcharge));
  
  }
  public String getAddMonthchargeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AddMonthcharge));
      }

  public void initSflagName(String value){
     this.initProperty(S_SflagName,value);
  }
  public  void setSflagName(String value){
     this.set(S_SflagName,value);
  }
  public  void setSflagNameNull(){
     this.set(S_SflagName,null);
  }

  public String getSflagName(){
       return DataType.getAsString(this.get(S_SflagName));
  
  }
  public String getSflagNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SflagName));
      }

  public void initId(String value){
     this.initProperty(S_Id,value);
  }
  public  void setId(String value){
     this.set(S_Id,value);
  }
  public  void setIdNull(){
     this.set(S_Id,null);
  }

  public String getId(){
       return DataType.getAsString(this.get(S_Id));
  
  }
  public String getIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Id));
      }

  public void initMarketType(String value){
     this.initProperty(S_MarketType,value);
  }
  public  void setMarketType(String value){
     this.set(S_MarketType,value);
  }
  public  void setMarketTypeNull(){
     this.set(S_MarketType,null);
  }

  public String getMarketType(){
       return DataType.getAsString(this.get(S_MarketType));
  
  }
  public String getMarketTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MarketType));
      }

  public void initReferencePrice(long value){
     this.initProperty(S_ReferencePrice,new Long(value));
  }
  public  void setReferencePrice(long value){
     this.set(S_ReferencePrice,new Long(value));
  }
  public  void setReferencePriceNull(){
     this.set(S_ReferencePrice,null);
  }

  public long getReferencePrice(){
        return DataType.getAsLong(this.get(S_ReferencePrice));
  
  }
  public long getReferencePriceInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ReferencePrice));
      }

  public void initSubjectName(String value){
     this.initProperty(S_SubjectName,value);
  }
  public  void setSubjectName(String value){
     this.set(S_SubjectName,value);
  }
  public  void setSubjectNameNull(){
     this.set(S_SubjectName,null);
  }

  public String getSubjectName(){
       return DataType.getAsString(this.get(S_SubjectName));
  
  }
  public String getSubjectNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SubjectName));
      }

  public void initGlobalScore(long value){
     this.initProperty(S_GlobalScore,new Long(value));
  }
  public  void setGlobalScore(long value){
     this.set(S_GlobalScore,new Long(value));
  }
  public  void setGlobalScoreNull(){
     this.set(S_GlobalScore,null);
  }

  public long getGlobalScore(){
        return DataType.getAsLong(this.get(S_GlobalScore));
  
  }
  public long getGlobalScoreInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_GlobalScore));
      }

  public void initBaseMonth(int value){
     this.initProperty(S_BaseMonth,new Integer(value));
  }
  public  void setBaseMonth(int value){
     this.set(S_BaseMonth,new Integer(value));
  }
  public  void setBaseMonthNull(){
     this.set(S_BaseMonth,null);
  }

  public int getBaseMonth(){
        return DataType.getAsInt(this.get(S_BaseMonth));
  
  }
  public int getBaseMonthInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_BaseMonth));
      }

  public void initFirstcharge(String value){
     this.initProperty(S_Firstcharge,value);
  }
  public  void setFirstcharge(String value){
     this.set(S_Firstcharge,value);
  }
  public  void setFirstchargeNull(){
     this.set(S_Firstcharge,null);
  }

  public String getFirstcharge(){
       return DataType.getAsString(this.get(S_Firstcharge));
  
  }
  public String getFirstchargeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Firstcharge));
      }

  public void initBusiType(String value){
     this.initProperty(S_BusiType,value);
  }
  public  void setBusiType(String value){
     this.set(S_BusiType,value);
  }
  public  void setBusiTypeNull(){
     this.set(S_BusiType,null);
  }

  public String getBusiType(){
       return DataType.getAsString(this.get(S_BusiType));
  
  }
  public String getBusiTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BusiType));
      }

  public void initSuggestDate(Timestamp value){
     this.initProperty(S_SuggestDate,value);
  }
  public  void setSuggestDate(Timestamp value){
     this.set(S_SuggestDate,value);
  }
  public  void setSuggestDateNull(){
     this.set(S_SuggestDate,null);
  }

  public Timestamp getSuggestDate(){
        return DataType.getAsDateTime(this.get(S_SuggestDate));
  
  }
  public Timestamp getSuggestDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_SuggestDate));
      }

  public void initMinnetAge(long value){
     this.initProperty(S_MinnetAge,new Long(value));
  }
  public  void setMinnetAge(long value){
     this.set(S_MinnetAge,new Long(value));
  }
  public  void setMinnetAgeNull(){
     this.set(S_MinnetAge,null);
  }

  public long getMinnetAge(){
        return DataType.getAsLong(this.get(S_MinnetAge));
  
  }
  public long getMinnetAgeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_MinnetAge));
      }

  public void initNetAge(String value){
     this.initProperty(S_NetAge,value);
  }
  public  void setNetAge(String value){
     this.set(S_NetAge,value);
  }
  public  void setNetAgeNull(){
     this.set(S_NetAge,null);
  }

  public String getNetAge(){
       return DataType.getAsString(this.get(S_NetAge));
  
  }
  public String getNetAgeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_NetAge));
      }

  public void initHomeScore(long value){
     this.initProperty(S_HomeScore,new Long(value));
  }
  public  void setHomeScore(long value){
     this.set(S_HomeScore,new Long(value));
  }
  public  void setHomeScoreNull(){
     this.set(S_HomeScore,null);
  }

  public long getHomeScore(){
        return DataType.getAsLong(this.get(S_HomeScore));
  
  }
  public long getHomeScoreInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_HomeScore));
      }

  public void initPresentReachAmount(long value){
     this.initProperty(S_PresentReachAmount,new Long(value));
  }
  public  void setPresentReachAmount(long value){
     this.set(S_PresentReachAmount,new Long(value));
  }
  public  void setPresentReachAmountNull(){
     this.set(S_PresentReachAmount,null);
  }

  public long getPresentReachAmount(){
        return DataType.getAsLong(this.get(S_PresentReachAmount));
  
  }
  public long getPresentReachAmountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PresentReachAmount));
      }

  public void initPresentBusi4Amount(long value){
     this.initProperty(S_PresentBusi4Amount,new Long(value));
  }
  public  void setPresentBusi4Amount(long value){
     this.set(S_PresentBusi4Amount,new Long(value));
  }
  public  void setPresentBusi4AmountNull(){
     this.set(S_PresentBusi4Amount,null);
  }

  public long getPresentBusi4Amount(){
        return DataType.getAsLong(this.get(S_PresentBusi4Amount));
  
  }
  public long getPresentBusi4AmountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PresentBusi4Amount));
      }

  public void initZfqType(String value){
     this.initProperty(S_ZfqType,value);
  }
  public  void setZfqType(String value){
     this.set(S_ZfqType,value);
  }
  public  void setZfqTypeNull(){
     this.set(S_ZfqType,null);
  }

  public String getZfqType(){
       return DataType.getAsString(this.get(S_ZfqType));
  
  }
  public String getZfqTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ZfqType));
      }

  public void initLLimit(long value){
     this.initProperty(S_LLimit,new Long(value));
  }
  public  void setLLimit(long value){
     this.set(S_LLimit,new Long(value));
  }
  public  void setLLimitNull(){
     this.set(S_LLimit,null);
  }

  public long getLLimit(){
        return DataType.getAsLong(this.get(S_LLimit));
  
  }
  public long getLLimitInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_LLimit));
      }

  public void initReturnType(String value){
     this.initProperty(S_ReturnType,value);
  }
  public  void setReturnType(String value){
     this.set(S_ReturnType,value);
  }
  public  void setReturnTypeNull(){
     this.set(S_ReturnType,null);
  }

  public String getReturnType(){
       return DataType.getAsString(this.get(S_ReturnType));
  
  }
  public String getReturnTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ReturnType));
      }

  public void initTermType(String value){
     this.initProperty(S_TermType,value);
  }
  public  void setTermType(String value){
     this.set(S_TermType,value);
  }
  public  void setTermTypeNull(){
     this.set(S_TermType,null);
  }

  public String getTermType(){
       return DataType.getAsString(this.get(S_TermType));
  
  }
  public String getTermTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TermType));
      }

  public void initRemark4(String value){
     this.initProperty(S_Remark4,value);
  }
  public  void setRemark4(String value){
     this.set(S_Remark4,value);
  }
  public  void setRemark4Null(){
     this.set(S_Remark4,null);
  }

  public String getRemark4(){
       return DataType.getAsString(this.get(S_Remark4));
  
  }
  public String getRemark4InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark4));
      }

  public void initSzxScore(long value){
     this.initProperty(S_SzxScore,new Long(value));
  }
  public  void setSzxScore(long value){
     this.set(S_SzxScore,new Long(value));
  }
  public  void setSzxScoreNull(){
     this.set(S_SzxScore,null);
  }

  public long getSzxScore(){
        return DataType.getAsLong(this.get(S_SzxScore));
  
  }
  public long getSzxScoreInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SzxScore));
      }

  public void initRemark3(String value){
     this.initProperty(S_Remark3,value);
  }
  public  void setRemark3(String value){
     this.set(S_Remark3,value);
  }
  public  void setRemark3Null(){
     this.set(S_Remark3,null);
  }

  public String getRemark3(){
       return DataType.getAsString(this.get(S_Remark3));
  
  }
  public String getRemark3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark3));
      }

  public void initState(String value){
     this.initProperty(S_State,value);
  }
  public  void setState(String value){
     this.set(S_State,value);
  }
  public  void setStateNull(){
     this.set(S_State,null);
  }

  public String getState(){
       return DataType.getAsString(this.get(S_State));
  
  }
  public String getStateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_State));
      }

  public void initRemark5(String value){
     this.initProperty(S_Remark5,value);
  }
  public  void setRemark5(String value){
     this.set(S_Remark5,value);
  }
  public  void setRemark5Null(){
     this.set(S_Remark5,null);
  }

  public String getRemark5(){
       return DataType.getAsString(this.get(S_Remark5));
  
  }
  public String getRemark5InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark5));
      }

  public void initModifyTime(Timestamp value){
     this.initProperty(S_ModifyTime,value);
  }
  public  void setModifyTime(Timestamp value){
     this.set(S_ModifyTime,value);
  }
  public  void setModifyTimeNull(){
     this.set(S_ModifyTime,null);
  }

  public Timestamp getModifyTime(){
        return DataType.getAsDateTime(this.get(S_ModifyTime));
  
  }
  public Timestamp getModifyTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ModifyTime));
      }

  public void initWeaponName(String value){
     this.initProperty(S_WeaponName,value);
  }
  public  void setWeaponName(String value){
     this.set(S_WeaponName,value);
  }
  public  void setWeaponNameNull(){
     this.set(S_WeaponName,null);
  }

  public String getWeaponName(){
       return DataType.getAsString(this.get(S_WeaponName));
  
  }
  public String getWeaponNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WeaponName));
      }

  public void initMarketName(String value){
     this.initProperty(S_MarketName,value);
  }
  public  void setMarketName(String value){
     this.set(S_MarketName,value);
  }
  public  void setMarketNameNull(){
     this.set(S_MarketName,null);
  }

  public String getMarketName(){
       return DataType.getAsString(this.get(S_MarketName));
  
  }
  public String getMarketNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MarketName));
      }

  public void initRemark2(String value){
     this.initProperty(S_Remark2,value);
  }
  public  void setRemark2(String value){
     this.set(S_Remark2,value);
  }
  public  void setRemark2Null(){
     this.set(S_Remark2,null);
  }

  public String getRemark2(){
       return DataType.getAsString(this.get(S_Remark2));
  
  }
  public String getRemark2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark2));
      }

  public void initTermRealFee(String value){
     this.initProperty(S_TermRealFee,value);
  }
  public  void setTermRealFee(String value){
     this.set(S_TermRealFee,value);
  }
  public  void setTermRealFeeNull(){
     this.set(S_TermRealFee,null);
  }

  public String getTermRealFee(){
       return DataType.getAsString(this.get(S_TermRealFee));
  
  }
  public String getTermRealFeeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TermRealFee));
      }

  public void initRemark1(String value){
     this.initProperty(S_Remark1,value);
  }
  public  void setRemark1(String value){
     this.set(S_Remark1,value);
  }
  public  void setRemark1Null(){
     this.set(S_Remark1,null);
  }

  public String getRemark1(){
       return DataType.getAsString(this.get(S_Remark1));
  
  }
  public String getRemark1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark1));
      }

  public void initAgreementValue(long value){
     this.initProperty(S_AgreementValue,new Long(value));
  }
  public  void setAgreementValue(long value){
     this.set(S_AgreementValue,new Long(value));
  }
  public  void setAgreementValueNull(){
     this.set(S_AgreementValue,null);
  }

  public long getAgreementValue(){
        return DataType.getAsLong(this.get(S_AgreementValue));
  
  }
  public long getAgreementValueInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AgreementValue));
      }

  public void initBasePrice(long value){
     this.initProperty(S_BasePrice,new Long(value));
  }
  public  void setBasePrice(long value){
     this.set(S_BasePrice,new Long(value));
  }
  public  void setBasePriceNull(){
     this.set(S_BasePrice,null);
  }

  public long getBasePrice(){
        return DataType.getAsLong(this.get(S_BasePrice));
  
  }
  public long getBasePriceInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BasePrice));
      }

  public void initMid(String value){
     this.initProperty(S_Mid,value);
  }
  public  void setMid(String value){
     this.set(S_Mid,value);
  }
  public  void setMidNull(){
     this.set(S_Mid,null);
  }

  public String getMid(){
       return DataType.getAsString(this.get(S_Mid));
  
  }
  public String getMidInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Mid));
      }

  public void initStandbyNum1(String value){
     this.initProperty(S_StandbyNum1,value);
  }
  public  void setStandbyNum1(String value){
     this.set(S_StandbyNum1,value);
  }
  public  void setStandbyNum1Null(){
     this.set(S_StandbyNum1,null);
  }

  public String getStandbyNum1(){
       return DataType.getAsString(this.get(S_StandbyNum1));
  
  }
  public String getStandbyNum1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_StandbyNum1));
      }

  public void initStandbyNum2(String value){
     this.initProperty(S_StandbyNum2,value);
  }
  public  void setStandbyNum2(String value){
     this.set(S_StandbyNum2,value);
  }
  public  void setStandbyNum2Null(){
     this.set(S_StandbyNum2,null);
  }

  public String getStandbyNum2(){
       return DataType.getAsString(this.get(S_StandbyNum2));
  
  }
  public String getStandbyNum2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_StandbyNum2));
      }

  public void initStandbyNum3(String value){
     this.initProperty(S_StandbyNum3,value);
  }
  public  void setStandbyNum3(String value){
     this.set(S_StandbyNum3,value);
  }
  public  void setStandbyNum3Null(){
     this.set(S_StandbyNum3,null);
  }

  public String getStandbyNum3(){
       return DataType.getAsString(this.get(S_StandbyNum3));
  
  }
  public String getStandbyNum3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_StandbyNum3));
      }

  public void initPresentBusi2Amount(long value){
     this.initProperty(S_PresentBusi2Amount,new Long(value));
  }
  public  void setPresentBusi2Amount(long value){
     this.set(S_PresentBusi2Amount,new Long(value));
  }
  public  void setPresentBusi2AmountNull(){
     this.set(S_PresentBusi2Amount,null);
  }

  public long getPresentBusi2Amount(){
        return DataType.getAsLong(this.get(S_PresentBusi2Amount));
  
  }
  public long getPresentBusi2AmountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PresentBusi2Amount));
      }

  public void initDataBusiType(String value){
     this.initProperty(S_DataBusiType,value);
  }
  public  void setDataBusiType(String value){
     this.set(S_DataBusiType,value);
  }
  public  void setDataBusiTypeNull(){
     this.set(S_DataBusiType,null);
  }

  public String getDataBusiType(){
       return DataType.getAsString(this.get(S_DataBusiType));
  
  }
  public String getDataBusiTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DataBusiType));
      }

  public void initPrestoreFee(long value){
     this.initProperty(S_PrestoreFee,new Long(value));
  }
  public  void setPrestoreFee(long value){
     this.set(S_PrestoreFee,new Long(value));
  }
  public  void setPrestoreFeeNull(){
     this.set(S_PrestoreFee,null);
  }

  public long getPrestoreFee(){
        return DataType.getAsLong(this.get(S_PrestoreFee));
  
  }
  public long getPrestoreFeeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PrestoreFee));
      }

  public void initBLimit(long value){
     this.initProperty(S_BLimit,new Long(value));
  }
  public  void setBLimit(long value){
     this.set(S_BLimit,new Long(value));
  }
  public  void setBLimitNull(){
     this.set(S_BLimit,null);
  }

  public long getBLimit(){
        return DataType.getAsLong(this.get(S_BLimit));
  
  }
  public long getBLimitInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BLimit));
      }

  public void initGoodAdoptDirectory(String value){
     this.initProperty(S_GoodAdoptDirectory,value);
  }
  public  void setGoodAdoptDirectory(String value){
     this.set(S_GoodAdoptDirectory,value);
  }
  public  void setGoodAdoptDirectoryNull(){
     this.set(S_GoodAdoptDirectory,null);
  }

  public String getGoodAdoptDirectory(){
       return DataType.getAsString(this.get(S_GoodAdoptDirectory));
  
  }
  public String getGoodAdoptDirectoryInitialValue(){
        return DataType.getAsString(this.getOldObj(S_GoodAdoptDirectory));
      }

  public void initPresentBusiMonth(int value){
     this.initProperty(S_PresentBusiMonth,new Integer(value));
  }
  public  void setPresentBusiMonth(int value){
     this.set(S_PresentBusiMonth,new Integer(value));
  }
  public  void setPresentBusiMonthNull(){
     this.set(S_PresentBusiMonth,null);
  }

  public int getPresentBusiMonth(){
        return DataType.getAsInt(this.get(S_PresentBusiMonth));
  
  }
  public int getPresentBusiMonthInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_PresentBusiMonth));
      }

  public void initPresentValuePermon(long value){
     this.initProperty(S_PresentValuePermon,new Long(value));
  }
  public  void setPresentValuePermon(long value){
     this.set(S_PresentValuePermon,new Long(value));
  }
  public  void setPresentValuePermonNull(){
     this.set(S_PresentValuePermon,null);
  }

  public long getPresentValuePermon(){
        return DataType.getAsLong(this.get(S_PresentValuePermon));
  
  }
  public long getPresentValuePermonInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PresentValuePermon));
      }

  public void initPrestroreReachAccount(long value){
     this.initProperty(S_PrestroreReachAccount,new Long(value));
  }
  public  void setPrestroreReachAccount(long value){
     this.set(S_PrestroreReachAccount,new Long(value));
  }
  public  void setPrestroreReachAccountNull(){
     this.set(S_PrestroreReachAccount,null);
  }

  public long getPrestroreReachAccount(){
        return DataType.getAsLong(this.get(S_PrestroreReachAccount));
  
  }
  public long getPrestroreReachAccountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PrestroreReachAccount));
      }

  public void initTermCostFee(long value){
     this.initProperty(S_TermCostFee,new Long(value));
  }
  public  void setTermCostFee(long value){
     this.set(S_TermCostFee,new Long(value));
  }
  public  void setTermCostFeeNull(){
     this.set(S_TermCostFee,null);
  }

  public long getTermCostFee(){
        return DataType.getAsLong(this.get(S_TermCostFee));
  
  }
  public long getTermCostFeeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TermCostFee));
      }

  public void initBackMonth(int value){
     this.initProperty(S_BackMonth,new Integer(value));
  }
  public  void setBackMonth(int value){
     this.set(S_BackMonth,new Integer(value));
  }
  public  void setBackMonthNull(){
     this.set(S_BackMonth,null);
  }

  public int getBackMonth(){
        return DataType.getAsInt(this.get(S_BackMonth));
  
  }
  public int getBackMonthInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_BackMonth));
      }

  public void initDataFee(long value){
     this.initProperty(S_DataFee,new Long(value));
  }
  public  void setDataFee(long value){
     this.set(S_DataFee,new Long(value));
  }
  public  void setDataFeeNull(){
     this.set(S_DataFee,null);
  }

  public long getDataFee(){
        return DataType.getAsLong(this.get(S_DataFee));
  
  }
  public long getDataFeeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_DataFee));
      }

  public void initPresentBusiAmount(long value){
     this.initProperty(S_PresentBusiAmount,new Long(value));
  }
  public  void setPresentBusiAmount(long value){
     this.set(S_PresentBusiAmount,new Long(value));
  }
  public  void setPresentBusiAmountNull(){
     this.set(S_PresentBusiAmount,null);
  }

  public long getPresentBusiAmount(){
        return DataType.getAsLong(this.get(S_PresentBusiAmount));
  
  }
  public long getPresentBusiAmountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PresentBusiAmount));
      }

  public void initTermGuideFee(long value){
     this.initProperty(S_TermGuideFee,new Long(value));
  }
  public  void setTermGuideFee(long value){
     this.set(S_TermGuideFee,new Long(value));
  }
  public  void setTermGuideFeeNull(){
     this.set(S_TermGuideFee,null);
  }

  public long getTermGuideFee(){
        return DataType.getAsLong(this.get(S_TermGuideFee));
  
  }
  public long getTermGuideFeeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TermGuideFee));
      }

  public void initLastcharge(String value){
     this.initProperty(S_Lastcharge,value);
  }
  public  void setLastcharge(String value){
     this.set(S_Lastcharge,value);
  }
  public  void setLastchargeNull(){
     this.set(S_Lastcharge,null);
  }

  public String getLastcharge(){
       return DataType.getAsString(this.get(S_Lastcharge));
  
  }
  public String getLastchargeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Lastcharge));
      }

  public void initSaleFlag(String value){
     this.initProperty(S_SaleFlag,value);
  }
  public  void setSaleFlag(String value){
     this.set(S_SaleFlag,value);
  }
  public  void setSaleFlagNull(){
     this.set(S_SaleFlag,null);
  }

  public String getSaleFlag(){
       return DataType.getAsString(this.get(S_SaleFlag));
  
  }
  public String getSaleFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleFlag));
      }

  public void initPresentBusi3Amount(long value){
     this.initProperty(S_PresentBusi3Amount,new Long(value));
  }
  public  void setPresentBusi3Amount(long value){
     this.set(S_PresentBusi3Amount,new Long(value));
  }
  public  void setPresentBusi3AmountNull(){
     this.set(S_PresentBusi3Amount,null);
  }

  public long getPresentBusi3Amount(){
        return DataType.getAsLong(this.get(S_PresentBusi3Amount));
  
  }
  public long getPresentBusi3AmountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PresentBusi3Amount));
      }

  public void initDynamicScore(long value){
     this.initProperty(S_DynamicScore,new Long(value));
  }
  public  void setDynamicScore(long value){
     this.set(S_DynamicScore,new Long(value));
  }
  public  void setDynamicScoreNull(){
     this.set(S_DynamicScore,null);
  }

  public long getDynamicScore(){
        return DataType.getAsLong(this.get(S_DynamicScore));
  
  }
  public long getDynamicScoreInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_DynamicScore));
      }

  public void initZfqName(String value){
     this.initProperty(S_ZfqName,value);
  }
  public  void setZfqName(String value){
     this.set(S_ZfqName,value);
  }
  public  void setZfqNameNull(){
     this.set(S_ZfqName,null);
  }

  public String getZfqName(){
       return DataType.getAsString(this.get(S_ZfqName));
  
  }
  public String getZfqNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ZfqName));
      }


 
 }

