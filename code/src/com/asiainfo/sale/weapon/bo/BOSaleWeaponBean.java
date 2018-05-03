package com.asiainfo.sale.weapon.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.weapon.ivalues.*;

public class BOSaleWeaponBean extends DataContainer implements DataContainerInterface,IBOSaleWeaponValue{

  private static String  m_boName = "com.asiainfo.sale.weapon.bo.BOSaleWeapon";



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
  
  public final static String S_CostTypeOne = "COST_TYPE_ONE";//费用一级分类
  public final static String S_CostTypeTwo = "COST_TYPE_TWO";//费用二级分类
  public final static String S_TelFeeDeduction = "TEL_FEE_DEDUCTION";//话费是否可抵扣这类费用
  public final static String S_TelFeeDeductionTime = "TEL_FEE_DEDUCTION_TIME";//话费抵扣的时间范围

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOSaleWeaponBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initValuePermonth(double value){
     this.initProperty(S_ValuePermonth,new Double(value));
  }
  public  void setValuePermonth(double value){
     this.set(S_ValuePermonth,new Double(value));
  }
  public  void setValuePermonthNull(){
     this.set(S_ValuePermonth,null);
  }

  public double getValuePermonth(){
        return DataType.getAsDouble(this.get(S_ValuePermonth));
  
  }
  public double getValuePermonthInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_ValuePermonth));
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

  public void initPresentBusi5Amount(double value){
     this.initProperty(S_PresentBusi5Amount,new Double(value));
  }
  public  void setPresentBusi5Amount(double value){
     this.set(S_PresentBusi5Amount,new Double(value));
  }
  public  void setPresentBusi5AmountNull(){
     this.set(S_PresentBusi5Amount,null);
  }

  public double getPresentBusi5Amount(){
        return DataType.getAsDouble(this.get(S_PresentBusi5Amount));
  
  }
  public double getPresentBusi5AmountInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PresentBusi5Amount));
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

  public void initMaxnetAge(int value){
     this.initProperty(S_MaxnetAge,new Integer(value));
  }
  public  void setMaxnetAge(int value){
     this.set(S_MaxnetAge,new Integer(value));
  }
  public  void setMaxnetAgeNull(){
     this.set(S_MaxnetAge,null);
  }

  public int getMaxnetAge(){
        return DataType.getAsInt(this.get(S_MaxnetAge));
  
  }
  public int getMaxnetAgeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_MaxnetAge));
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

  public void initReferencePrice(double value){
     this.initProperty(S_ReferencePrice,new Double(value));
  }
  public  void setReferencePrice(double value){
     this.set(S_ReferencePrice,new Double(value));
  }
  public  void setReferencePriceNull(){
     this.set(S_ReferencePrice,null);
  }

  public double getReferencePrice(){
        return DataType.getAsDouble(this.get(S_ReferencePrice));
  
  }
  public double getReferencePriceInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_ReferencePrice));
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

  public void initGlobalScore(int value){
     this.initProperty(S_GlobalScore,new Integer(value));
  }
  public  void setGlobalScore(int value){
     this.set(S_GlobalScore,new Integer(value));
  }
  public  void setGlobalScoreNull(){
     this.set(S_GlobalScore,null);
  }

  public int getGlobalScore(){
        return DataType.getAsInt(this.get(S_GlobalScore));
  
  }
  public int getGlobalScoreInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_GlobalScore));
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

  public void initMinnetAge(int value){
     this.initProperty(S_MinnetAge,new Integer(value));
  }
  public  void setMinnetAge(int value){
     this.set(S_MinnetAge,new Integer(value));
  }
  public  void setMinnetAgeNull(){
     this.set(S_MinnetAge,null);
  }

  public int getMinnetAge(){
        return DataType.getAsInt(this.get(S_MinnetAge));
  
  }
  public int getMinnetAgeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_MinnetAge));
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

  public void initIsDelete(String value){
     this.initProperty(S_IsDelete,value);
  }
  public  void setIsDelete(String value){
     this.set(S_IsDelete,value);
  }
  public  void setIsDeleteNull(){
     this.set(S_IsDelete,null);
  }

  public String getIsDelete(){
       return DataType.getAsString(this.get(S_IsDelete));
  
  }
  public String getIsDeleteInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsDelete));
      }

  public void initHomeScore(int value){
     this.initProperty(S_HomeScore,new Integer(value));
  }
  public  void setHomeScore(int value){
     this.set(S_HomeScore,new Integer(value));
  }
  public  void setHomeScoreNull(){
     this.set(S_HomeScore,null);
  }

  public int getHomeScore(){
        return DataType.getAsInt(this.get(S_HomeScore));
  
  }
  public int getHomeScoreInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_HomeScore));
      }

  public void initPresentReachAmount(double value){
     this.initProperty(S_PresentReachAmount,new Double(value));
  }
  public  void setPresentReachAmount(double value){
     this.set(S_PresentReachAmount,new Double(value));
  }
  public  void setPresentReachAmountNull(){
     this.set(S_PresentReachAmount,null);
  }

  public double getPresentReachAmount(){
        return DataType.getAsDouble(this.get(S_PresentReachAmount));
  
  }
  public double getPresentReachAmountInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PresentReachAmount));
      }

  public void initPresentBusi4Amount(double value){
     this.initProperty(S_PresentBusi4Amount,new Double(value));
  }
  public  void setPresentBusi4Amount(double value){
     this.set(S_PresentBusi4Amount,new Double(value));
  }
  public  void setPresentBusi4AmountNull(){
     this.set(S_PresentBusi4Amount,null);
  }

  public double getPresentBusi4Amount(){
        return DataType.getAsDouble(this.get(S_PresentBusi4Amount));
  
  }
  public double getPresentBusi4AmountInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PresentBusi4Amount));
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

  public void initLLimit(int value){
     this.initProperty(S_LLimit,new Integer(value));
  }
  public  void setLLimit(int value){
     this.set(S_LLimit,new Integer(value));
  }
  public  void setLLimitNull(){
     this.set(S_LLimit,null);
  }

  public int getLLimit(){
        return DataType.getAsInt(this.get(S_LLimit));
  
  }
  public int getLLimitInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_LLimit));
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

  public void initSzxScore(int value){
     this.initProperty(S_SzxScore,new Integer(value));
  }
  public  void setSzxScore(int value){
     this.set(S_SzxScore,new Integer(value));
  }
  public  void setSzxScoreNull(){
     this.set(S_SzxScore,null);
  }

  public int getSzxScore(){
        return DataType.getAsInt(this.get(S_SzxScore));
  
  }
  public int getSzxScoreInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_SzxScore));
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

  public void initAgreementValue(double value){
     this.initProperty(S_AgreementValue,new Double(value));
  }
  public  void setAgreementValue(double value){
     this.set(S_AgreementValue,new Double(value));
  }
  public  void setAgreementValueNull(){
     this.set(S_AgreementValue,null);
  }

  public double getAgreementValue(){
        return DataType.getAsDouble(this.get(S_AgreementValue));
  
  }
  public double getAgreementValueInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_AgreementValue));
      }

  public void initBasePrice(double value){
     this.initProperty(S_BasePrice,new Double(value));
  }
  public  void setBasePrice(double value){
     this.set(S_BasePrice,new Double(value));
  }
  public  void setBasePriceNull(){
     this.set(S_BasePrice,null);
  }

  public double getBasePrice(){
        return DataType.getAsDouble(this.get(S_BasePrice));
  
  }
  public double getBasePriceInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_BasePrice));
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

  public void initPresentBusi2Amount(double value){
     this.initProperty(S_PresentBusi2Amount,new Double(value));
  }
  public  void setPresentBusi2Amount(double value){
     this.set(S_PresentBusi2Amount,new Double(value));
  }
  public  void setPresentBusi2AmountNull(){
     this.set(S_PresentBusi2Amount,null);
  }

  public double getPresentBusi2Amount(){
        return DataType.getAsDouble(this.get(S_PresentBusi2Amount));
  
  }
  public double getPresentBusi2AmountInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PresentBusi2Amount));
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

  public void initPrestoreFee(double value){
     this.initProperty(S_PrestoreFee,new Double(value));
  }
  public  void setPrestoreFee(double value){
     this.set(S_PrestoreFee,new Double(value));
  }
  public  void setPrestoreFeeNull(){
     this.set(S_PrestoreFee,null);
  }

  public double getPrestoreFee(){
        return DataType.getAsDouble(this.get(S_PrestoreFee));
  
  }
  public double getPrestoreFeeInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PrestoreFee));
      }

  public void initBLimit(int value){
     this.initProperty(S_BLimit,new Integer(value));
  }
  public  void setBLimit(int value){
     this.set(S_BLimit,new Integer(value));
  }
  public  void setBLimitNull(){
     this.set(S_BLimit,null);
  }

  public int getBLimit(){
        return DataType.getAsInt(this.get(S_BLimit));
  
  }
  public int getBLimitInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_BLimit));
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

  public void initPresentValuePermon(double value){
     this.initProperty(S_PresentValuePermon,new Double(value));
  }
  public  void setPresentValuePermon(double value){
     this.set(S_PresentValuePermon,new Double(value));
  }
  public  void setPresentValuePermonNull(){
     this.set(S_PresentValuePermon,null);
  }

  public double getPresentValuePermon(){
        return DataType.getAsDouble(this.get(S_PresentValuePermon));
  
  }
  public double getPresentValuePermonInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PresentValuePermon));
      }

  public void initPrestroreReachAccount(double value){
     this.initProperty(S_PrestroreReachAccount,new Double(value));
  }
  public  void setPrestroreReachAccount(double value){
     this.set(S_PrestroreReachAccount,new Double(value));
  }
  public  void setPrestroreReachAccountNull(){
     this.set(S_PrestroreReachAccount,null);
  }

  public double getPrestroreReachAccount(){
        return DataType.getAsDouble(this.get(S_PrestroreReachAccount));
  
  }
  public double getPrestroreReachAccountInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PrestroreReachAccount));
      }

  public void initTermCostFee(double value){
     this.initProperty(S_TermCostFee,new Double(value));
  }
  public  void setTermCostFee(double value){
     this.set(S_TermCostFee,new Double(value));
  }
  public  void setTermCostFeeNull(){
     this.set(S_TermCostFee,null);
  }

  public double getTermCostFee(){
        return DataType.getAsDouble(this.get(S_TermCostFee));
  
  }
  public double getTermCostFeeInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_TermCostFee));
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

  public void initDataFee(double value){
     this.initProperty(S_DataFee,new Double(value));
  }
  public  void setDataFee(double value){
     this.set(S_DataFee,new Double(value));
  }
  public  void setDataFeeNull(){
     this.set(S_DataFee,null);
  }

  public double getDataFee(){
        return DataType.getAsDouble(this.get(S_DataFee));
  
  }
  public double getDataFeeInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_DataFee));
      }

  public void initPresentBusiAmount(double value){
     this.initProperty(S_PresentBusiAmount,new Double(value));
  }
  public  void setPresentBusiAmount(double value){
     this.set(S_PresentBusiAmount,new Double(value));
  }
  public  void setPresentBusiAmountNull(){
     this.set(S_PresentBusiAmount,null);
  }

  public double getPresentBusiAmount(){
        return DataType.getAsDouble(this.get(S_PresentBusiAmount));
  
  }
  public double getPresentBusiAmountInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PresentBusiAmount));
      }

  public void initTermGuideFee(double value){
     this.initProperty(S_TermGuideFee,new Double(value));
  }
  public  void setTermGuideFee(double value){
     this.set(S_TermGuideFee,new Double(value));
  }
  public  void setTermGuideFeeNull(){
     this.set(S_TermGuideFee,null);
  }

  public double getTermGuideFee(){
        return DataType.getAsDouble(this.get(S_TermGuideFee));
  
  }
  public double getTermGuideFeeInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_TermGuideFee));
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

  public void initPresentBusi3Amount(double value){
     this.initProperty(S_PresentBusi3Amount,new Double(value));
  }
  public  void setPresentBusi3Amount(double value){
     this.set(S_PresentBusi3Amount,new Double(value));
  }
  public  void setPresentBusi3AmountNull(){
     this.set(S_PresentBusi3Amount,null);
  }

  public double getPresentBusi3Amount(){
        return DataType.getAsDouble(this.get(S_PresentBusi3Amount));
  
  }
  public double getPresentBusi3AmountInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PresentBusi3Amount));
      }

  public void initDynamicScore(int value){
     this.initProperty(S_DynamicScore,new Integer(value));
  }
  public  void setDynamicScore(int value){
     this.set(S_DynamicScore,new Integer(value));
  }
  public  void setDynamicScoreNull(){
     this.set(S_DynamicScore,null);
  }

  public int getDynamicScore(){
        return DataType.getAsInt(this.get(S_DynamicScore));
  
  }
  public int getDynamicScoreInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_DynamicScore));
      }
  public void undelete(){
	  super.m_isDeleted=false;
  }
 
  public void initLimType(String value){
		 this.initProperty(S_LimType,value);
	 }
	public  void setLimType(String value){
		 this.set(S_LimType,value);
	}
	public  void setLimTypeNull(){
		 this.set(S_LimType,null);
	}

	public String getLimType(){
		 return DataType.getAsString(this.get(S_LimType));
		  
	}
	public String getLimTypeInitialValue(){
		 return DataType.getAsString(this.getOldObj(S_LimType));
	}
  
	public void initAddMonthchargeHb(String value){
	     this.initProperty(S_AddMonthchargeHb,value);
	  }
	  public  void setAddMonthchargeHb(String value){
	     this.set(S_AddMonthchargeHb,value);
	  }
	  public  void setAddMonthchargeHbNull(){
	     this.set(S_AddMonthchargeHb,null);
	  }

	  public String getAddMonthchargeHb(){
	       return DataType.getAsString(this.get(S_AddMonthchargeHb));
	  
	  }
	  public String getAddMonthchargeHbInitialValue(){
	        return DataType.getAsString(this.getOldObj(S_AddMonthchargeHb));
	      }


	public void initReturnTypeHb(String value){
	     this.initProperty(S_ReturnTypeHb,value);
	  }
	  public  void setReturnTypeHb(String value){
	     this.set(S_ReturnTypeHb,value);
	  }
	  public  void setReturnTypeHbNull(){
	     this.set(S_ReturnTypeHb,null);
	  }

	  public String getReturnTypeHb(){
	       return DataType.getAsString(this.get(S_ReturnTypeHb));
	  
	  }
	  public String getReturnTypeHbInitialValue(){
	        return DataType.getAsString(this.getOldObj(S_ReturnTypeHb));
	      }



	public void initFirstchargeHb(String value){
	     this.initProperty(S_FirstchargeHb,value);
	  }
	  public  void setFirstchargeHb(String value){
	     this.set(S_FirstchargeHb,value);
	  }
	  public  void setFirstchargeHbNull(){
	     this.set(S_FirstchargeHb,null);
	  }

	  public String getFirstchargeHb(){
	       return DataType.getAsString(this.get(S_FirstchargeHb));
	  
	  }
	  public String getFirstchargeHbInitialValue(){
	        return DataType.getAsString(this.getOldObj(S_FirstchargeHb));
	      }


	public void initLastchargeHb(String value){
	     this.initProperty(S_LastchargeHb,value);
	  }
	  public  void setLastchargeHb(String value){
	     this.set(S_LastchargeHb,value);
	  }
	  public  void setLastchargeHbNull(){
	     this.set(S_LastchargeHb,null);
	  }

	  public String getLastchargeHb(){
	       return DataType.getAsString(this.get(S_LastchargeHb));
	  
	  }
	  public String getLastchargeHbInitialValue(){
	        return DataType.getAsString(this.getOldObj(S_LastchargeHb));
	      }

	 public void initPresentBusi2AmountHb(double value){
	     this.initProperty(S_PresentBusi2AmountHb,new Double(value));
	  }
	  public  void setPresentBusi2AmountHb(double value){
	     this.set(S_PresentBusi2AmountHb,new Double(value));
	  }
	  public  void setPresentBusi2AmountHbNull(){
	     this.set(S_PresentBusi2AmountHb,null);
	  }

	  public double getPresentBusi2AmountHb(){
	        return DataType.getAsDouble(this.get(S_PresentBusi2AmountHb));
	  
	  }
	  public double getPresentBusi2AmountHbInitialValue(){
	        return DataType.getAsDouble(this.getOldObj(S_PresentBusi2AmountHb));
	      }


	public void initStandbyNum1Hb(String value){
	     this.initProperty(S_StandbyNum1Hb,value);
	  }
	  public  void setStandbyNum1Hb(String value){
	     this.set(S_StandbyNum1Hb,value);
	  }
	  public  void setStandbyNum1HbNull(){
	     this.set(S_StandbyNum1Hb,null);
	  }

	  public String getStandbyNum1Hb(){
	       return DataType.getAsString(this.get(S_StandbyNum1Hb));
	  
	  }
	  public String getStandbyNum1HbInitialValue(){
	        return DataType.getAsString(this.getOldObj(S_StandbyNum1Hb));
	      }
	  
	public void initCostTypeOne(String value){
		this.initProperty(S_CostTypeOne,value);
	}
	public  void setCostTypeOne(String value){
		this.set(S_CostTypeOne,value);
	}
	public  void setCostTypeOneNull(){
		this.set(S_CostTypeOne,null);
	}
	public String getCostTypeOne(){
		return DataType.getAsString(this.get(S_CostTypeOne));
	}
	public String getCostTypeOneInitialValue(){
		return DataType.getAsString(this.getOldObj(S_CostTypeOne));
	}
	
	public void initCostTypeTwo(String value){
		this.initProperty(S_CostTypeTwo,value);
	}
	public  void setCostTypeTwo(String value){
		this.set(S_CostTypeTwo,value);
	}
	public  void setCostTypeTwoNull(){
		this.set(S_CostTypeTwo,null);
	}
	public String getCostTypeTwo(){
		return DataType.getAsString(this.get(S_CostTypeTwo));
	}
	public String getCostTypeTwoInitialValue(){
		return DataType.getAsString(this.getOldObj(S_CostTypeTwo));
	}
	
	public void initTelFeeDeduction(String value){
		this.initProperty(S_TelFeeDeduction,value);
	}
	public  void setTelFeeDeduction(String value){
		this.set(S_TelFeeDeduction,value);
	}
	public  void setTelFeeDeductionNull(){
		this.set(S_TelFeeDeduction,null);
	}
	public String getTelFeeDeduction(){
		return DataType.getAsString(this.get(S_TelFeeDeduction));
	}
	public String getTelFeeDeductionInitialValue(){
		return DataType.getAsString(this.getOldObj(S_TelFeeDeduction));
	}
	
	public void initTelFeeDeductionTime(String value){
		this.initProperty(S_TelFeeDeductionTime,value);
	}
	public  void setTelFeeDeductionTime(String value){
		this.set(S_TelFeeDeductionTime,value);
	}
	public  void setTelFeeDeductionTimeNull(){
		this.set(S_TelFeeDeductionTime,null);
	}
	public String getTelFeeDeductionTime(){
		return DataType.getAsString(this.get(S_TelFeeDeductionTime));
	}
	public String getTelFeeDeductionTimeInitialValue(){
		return DataType.getAsString(this.getOldObj(S_TelFeeDeductionTime));
	}
 }

