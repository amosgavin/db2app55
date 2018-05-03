package com.asiainfo.sale.activity.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.activity.ivalues.*;

public class BOSaleDetailShowBean extends DataContainer implements DataContainerInterface,IBOSaleDetailShowValue{

  private static String  m_boName = "com.asiainfo.sale.activity.bo.BOSaleDetailShow";



  public final static  String S_SaletypeDesOthersale = "SALETYPE_DES_OTHERSALE";
  public final static  String S_Staffid = "STAFFID";
  public final static  String S_BrandDesc = "BRAND_DESC";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_PresentBusi5Amount = "PRESENT_BUSI5_AMOUNT";
  public final static  String S_PreDiscount = "PRE_DISCOUNT";
  public final static  String S_MobileCost = "MOBILE_COST";
  public final static  String S_SaleActiveCode = "SALE_ACTIVE_CODE";
  public final static  String S_SaleFlagName = "SALE_FLAG_NAME";
  public final static  String S_OpenMonth = "OPEN_MONTH";
  public final static  String S_SaleBackground = "SALE_BACKGROUND";
  public final static  String S_PreAddPerson = "PRE_ADD_PERSON";
  public final static  String S_BackProportion = "BACK_PROPORTION";
  public final static  String S_ChannelPayPolicy = "CHANNEL_PAY_POLICY";
  public final static  String S_MarketType = "MARKET_TYPE";
  public final static  String S_ReferencePrice = "REFERENCE_PRICE";
  public final static  String S_BusiType = "BUSI_TYPE";
  public final static  String S_SaleId = "SALE_ID";
  public final static  String S_NetAge = "NET_AGE";
  public final static  String S_MarketNameW = "MARKET_NAME_W";
  public final static  String S_HomeScore = "HOME_SCORE";
  public final static  String S_ElecgoodsCost = "ELECGOODS_COST";
  public final static  String S_PresentReachAmount = "PRESENT_REACH_AMOUNT";
  public final static  String S_ElecpayCost = "ELECPAY_COST";
  public final static  String S_SaleScope = "SALE_SCOPE";
  public final static  String S_PresentBusi4Amount = "PRESENT_BUSI4_AMOUNT";
  public final static  String S_PrePerson = "PRE_PERSON";
  public final static  String S_ZfqType = "ZFQ_TYPE";
  public final static  String S_PreBaseFee = "PRE_BASE_FEE";
  public final static  String S_Remark4 = "REMARK_4";
  public final static  String S_Remark3 = "REMARK_3";
  public final static  String S_SzxScore = "SZX_SCORE";
  public final static  String S_EstimateAdFee = "ESTIMATE_AD_FEE";
  public final static  String S_Remark5 = "REMARK_5";
  public final static  String S_WeaponName = "WEAPON_NAME";
  public final static  String S_MarketName = "MARKET_NAME";
  public final static  String S_Remark2 = "REMARK_2";
  public final static  String S_Remark1 = "REMARK_1";
  public final static  String S_AgreementValue = "AGREEMENT_VALUE";
  public final static  String S_BasePrice = "BASE_PRICE";
  public final static  String S_Market = "MARKET";
  public final static  String S_ActiveSaleSite = "ACTIVE_SALE_SITE";
  public final static  String S_SaleContent = "SALE_CONTENT";
  public final static  String S_PresentBusi2Amount = "PRESENT_BUSI2_AMOUNT";
  public final static  String S_DataBusiType = "DATA_BUSI_TYPE";
  public final static  String S_GoodAdoptDirectory = "GOOD_ADOPT_DIRECTORY";
  public final static  String S_IsactiveSale = "ISACTIVE_SALE";
  public final static  String S_GoodsCost = "GOODS_COST";
  public final static  String S_PresentBusiMonth = "PRESENT_BUSI_MONTH";
  public final static  String S_SaleFlagNameW = "SALE_FLAG_NAME_W";
  public final static  String S_ChannelPay = "CHANNEL_PAY";
  public final static  String S_PresentValuePermon = "PRESENT_VALUE_PERMON";
  public final static  String S_PrestroreReachAccount = "PRESTRORE_REACH_ACCOUNT";
  public final static  String S_TermCostFee = "TERM_COST_FEE";
  public final static  String S_PublicityWord = "PUBLICITY_WORD";
  public final static  String S_SaleActiveName = "SALE_ACTIVE_NAME";
  public final static  String S_BackMonth = "BACK_MONTH";
  public final static  String S_DataFee = "DATA_FEE";
  public final static  String S_PresentBusiAmount = "PRESENT_BUSI_AMOUNT";
  public final static  String S_TermGuideFee = "TERM_GUIDE_FEE";
  public final static  String S_FeeDiscount = "FEE_DISCOUNT";
  public final static  String S_EstimateOtherFee = "ESTIMATE_OTHER_FEE";
  public final static  String S_ValuePermonth = "VALUE_PERMONTH";
  public final static  String S_ConfigTime = "CONFIG_TIME";
  public final static  String S_PreIncome = "PRE_INCOME";
  public final static  String S_FeeAccountProperty = "FEE_ACCOUNT_PROPERTY";
  public final static  String S_MaxnetAge = "MAXNET_AGE";
  public final static  String S_Id = "ID";
  public final static  String S_BusinessDiscount = "BUSINESS_DISCOUNT";
  public final static  String S_OtherBusiTarget = "OTHER_BUSI_TARGET";
  public final static  String S_MobilepayCost = "MOBILEPAY_COST";
  public final static  String S_GlobalScore = "GLOBAL_SCORE";
  public final static  String S_BaseMonth = "BASE_MONTH";
  public final static  String S_CostTotal = "COST_TOTAL";
  public final static  String S_ExcludeDemand = "EXCLUDE_DEMAND";
  public final static  String S_SuggestDate = "SUGGEST_DATE";
  public final static  String S_MinnetAge = "MINNET_AGE";
  public final static  String S_ZfqTypeName = "ZFQ_TYPE_NAME";
  public final static  String S_SaleTarget = "SALE_TARGET";
  public final static  String S_LLimit = "L_LIMIT";
  public final static  String S_TermType = "TERM_TYPE";
  public final static  String S_State = "STATE";
  public final static  String S_ModifyTime = "MODIFY_TIME";
  public final static  String S_TermRealFee = "TERM_REAL_FEE";
  public final static  String S_LevelDesc = "LEVEL_DESC";
  public final static  String S_Mid = "MID";
  public final static  String S_SaletypeOthersale = "SALETYPE_OTHERSALE";
  public final static  String S_OtherUserinfo = "OTHER_USERINFO";
  public final static  String S_PrestoreFee = "PRESTORE_FEE";
  public final static  String S_BLimit = "B_LIMIT";
  public final static  String S_BeginTime = "BEGIN_TIME";
  public final static  String S_OpenChannel = "OPEN_CHANNEL";
  public final static  String S_WeaponId = "WEAPON_ID";
  public final static  String S_MaxPerson = "MAX_PERSON";
  public final static  String S_TargetListCode = "TARGET_LIST_CODE";
  public final static  String S_LevelCode = "LEVEL_CODE";
  public final static  String S_SaleFlag = "SALE_FLAG";
  public final static  String S_PreStoreToPresent = "PRE_STORE_TO_PRESENT";
  public final static  String S_PresentBusi3Amount = "PRESENT_BUSI3_AMOUNT";
  public final static  String S_DynamicScore = "DYNAMIC_SCORE";
  public final static  String S_EndTime = "END_TIME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOSaleDetailShowBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initSaletypeDesOthersale(String value){
     this.initProperty(S_SaletypeDesOthersale,value);
  }
  public  void setSaletypeDesOthersale(String value){
     this.set(S_SaletypeDesOthersale,value);
  }
  public  void setSaletypeDesOthersaleNull(){
     this.set(S_SaletypeDesOthersale,null);
  }

  public String getSaletypeDesOthersale(){
       return DataType.getAsString(this.get(S_SaletypeDesOthersale));
  
  }
  public String getSaletypeDesOthersaleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaletypeDesOthersale));
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

  public void initBrandDesc(String value){
     this.initProperty(S_BrandDesc,value);
  }
  public  void setBrandDesc(String value){
     this.set(S_BrandDesc,value);
  }
  public  void setBrandDescNull(){
     this.set(S_BrandDesc,null);
  }

  public String getBrandDesc(){
       return DataType.getAsString(this.get(S_BrandDesc));
  
  }
  public String getBrandDescInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BrandDesc));
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

  public void initPreDiscount(long value){
     this.initProperty(S_PreDiscount,new Long(value));
  }
  public  void setPreDiscount(long value){
     this.set(S_PreDiscount,new Long(value));
  }
  public  void setPreDiscountNull(){
     this.set(S_PreDiscount,null);
  }

  public long getPreDiscount(){
        return DataType.getAsLong(this.get(S_PreDiscount));
  
  }
  public long getPreDiscountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PreDiscount));
      }

  public void initMobileCost(long value){
     this.initProperty(S_MobileCost,new Long(value));
  }
  public  void setMobileCost(long value){
     this.set(S_MobileCost,new Long(value));
  }
  public  void setMobileCostNull(){
     this.set(S_MobileCost,null);
  }

  public long getMobileCost(){
        return DataType.getAsLong(this.get(S_MobileCost));
  
  }
  public long getMobileCostInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_MobileCost));
      }

  public void initSaleActiveCode(String value){
     this.initProperty(S_SaleActiveCode,value);
  }
  public  void setSaleActiveCode(String value){
     this.set(S_SaleActiveCode,value);
  }
  public  void setSaleActiveCodeNull(){
     this.set(S_SaleActiveCode,null);
  }

  public String getSaleActiveCode(){
       return DataType.getAsString(this.get(S_SaleActiveCode));
  
  }
  public String getSaleActiveCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleActiveCode));
      }

  public void initSaleFlagName(String value){
     this.initProperty(S_SaleFlagName,value);
  }
  public  void setSaleFlagName(String value){
     this.set(S_SaleFlagName,value);
  }
  public  void setSaleFlagNameNull(){
     this.set(S_SaleFlagName,null);
  }

  public String getSaleFlagName(){
       return DataType.getAsString(this.get(S_SaleFlagName));
  
  }
  public String getSaleFlagNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleFlagName));
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

  public void initSaleBackground(String value){
     this.initProperty(S_SaleBackground,value);
  }
  public  void setSaleBackground(String value){
     this.set(S_SaleBackground,value);
  }
  public  void setSaleBackgroundNull(){
     this.set(S_SaleBackground,null);
  }

  public String getSaleBackground(){
       return DataType.getAsString(this.get(S_SaleBackground));
  
  }
  public String getSaleBackgroundInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleBackground));
      }

  public void initPreAddPerson(long value){
     this.initProperty(S_PreAddPerson,new Long(value));
  }
  public  void setPreAddPerson(long value){
     this.set(S_PreAddPerson,new Long(value));
  }
  public  void setPreAddPersonNull(){
     this.set(S_PreAddPerson,null);
  }

  public long getPreAddPerson(){
        return DataType.getAsLong(this.get(S_PreAddPerson));
  
  }
  public long getPreAddPersonInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PreAddPerson));
      }

  public void initBackProportion(long value){
     this.initProperty(S_BackProportion,new Long(value));
  }
  public  void setBackProportion(long value){
     this.set(S_BackProportion,new Long(value));
  }
  public  void setBackProportionNull(){
     this.set(S_BackProportion,null);
  }

  public long getBackProportion(){
        return DataType.getAsLong(this.get(S_BackProportion));
  
  }
  public long getBackProportionInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BackProportion));
      }

  public void initChannelPayPolicy(String value){
     this.initProperty(S_ChannelPayPolicy,value);
  }
  public  void setChannelPayPolicy(String value){
     this.set(S_ChannelPayPolicy,value);
  }
  public  void setChannelPayPolicyNull(){
     this.set(S_ChannelPayPolicy,null);
  }

  public String getChannelPayPolicy(){
       return DataType.getAsString(this.get(S_ChannelPayPolicy));
  
  }
  public String getChannelPayPolicyInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ChannelPayPolicy));
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

  public void initSaleId(String value){
     this.initProperty(S_SaleId,value);
  }
  public  void setSaleId(String value){
     this.set(S_SaleId,value);
  }
  public  void setSaleIdNull(){
     this.set(S_SaleId,null);
  }

  public String getSaleId(){
       return DataType.getAsString(this.get(S_SaleId));
  
  }
  public String getSaleIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleId));
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

  public void initMarketNameW(String value){
     this.initProperty(S_MarketNameW,value);
  }
  public  void setMarketNameW(String value){
     this.set(S_MarketNameW,value);
  }
  public  void setMarketNameWNull(){
     this.set(S_MarketNameW,null);
  }

  public String getMarketNameW(){
       return DataType.getAsString(this.get(S_MarketNameW));
  
  }
  public String getMarketNameWInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MarketNameW));
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

  public void initElecgoodsCost(long value){
     this.initProperty(S_ElecgoodsCost,new Long(value));
  }
  public  void setElecgoodsCost(long value){
     this.set(S_ElecgoodsCost,new Long(value));
  }
  public  void setElecgoodsCostNull(){
     this.set(S_ElecgoodsCost,null);
  }

  public long getElecgoodsCost(){
        return DataType.getAsLong(this.get(S_ElecgoodsCost));
  
  }
  public long getElecgoodsCostInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ElecgoodsCost));
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

  public void initElecpayCost(long value){
     this.initProperty(S_ElecpayCost,new Long(value));
  }
  public  void setElecpayCost(long value){
     this.set(S_ElecpayCost,new Long(value));
  }
  public  void setElecpayCostNull(){
     this.set(S_ElecpayCost,null);
  }

  public long getElecpayCost(){
        return DataType.getAsLong(this.get(S_ElecpayCost));
  
  }
  public long getElecpayCostInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ElecpayCost));
      }

  public void initSaleScope(String value){
     this.initProperty(S_SaleScope,value);
  }
  public  void setSaleScope(String value){
     this.set(S_SaleScope,value);
  }
  public  void setSaleScopeNull(){
     this.set(S_SaleScope,null);
  }

  public String getSaleScope(){
       return DataType.getAsString(this.get(S_SaleScope));
  
  }
  public String getSaleScopeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleScope));
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

  public void initPrePerson(long value){
     this.initProperty(S_PrePerson,new Long(value));
  }
  public  void setPrePerson(long value){
     this.set(S_PrePerson,new Long(value));
  }
  public  void setPrePersonNull(){
     this.set(S_PrePerson,null);
  }

  public long getPrePerson(){
        return DataType.getAsLong(this.get(S_PrePerson));
  
  }
  public long getPrePersonInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PrePerson));
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

  public void initPreBaseFee(long value){
     this.initProperty(S_PreBaseFee,new Long(value));
  }
  public  void setPreBaseFee(long value){
     this.set(S_PreBaseFee,new Long(value));
  }
  public  void setPreBaseFeeNull(){
     this.set(S_PreBaseFee,null);
  }

  public long getPreBaseFee(){
        return DataType.getAsLong(this.get(S_PreBaseFee));
  
  }
  public long getPreBaseFeeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PreBaseFee));
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

  public void initEstimateAdFee(long value){
     this.initProperty(S_EstimateAdFee,new Long(value));
  }
  public  void setEstimateAdFee(long value){
     this.set(S_EstimateAdFee,new Long(value));
  }
  public  void setEstimateAdFeeNull(){
     this.set(S_EstimateAdFee,null);
  }

  public long getEstimateAdFee(){
        return DataType.getAsLong(this.get(S_EstimateAdFee));
  
  }
  public long getEstimateAdFeeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_EstimateAdFee));
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

  public void initMarket(String value){
     this.initProperty(S_Market,value);
  }
  public  void setMarket(String value){
     this.set(S_Market,value);
  }
  public  void setMarketNull(){
     this.set(S_Market,null);
  }

  public String getMarket(){
       return DataType.getAsString(this.get(S_Market));
  
  }
  public String getMarketInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Market));
      }

  public void initActiveSaleSite(String value){
     this.initProperty(S_ActiveSaleSite,value);
  }
  public  void setActiveSaleSite(String value){
     this.set(S_ActiveSaleSite,value);
  }
  public  void setActiveSaleSiteNull(){
     this.set(S_ActiveSaleSite,null);
  }

  public String getActiveSaleSite(){
       return DataType.getAsString(this.get(S_ActiveSaleSite));
  
  }
  public String getActiveSaleSiteInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ActiveSaleSite));
      }

  public void initSaleContent(String value){
     this.initProperty(S_SaleContent,value);
  }
  public  void setSaleContent(String value){
     this.set(S_SaleContent,value);
  }
  public  void setSaleContentNull(){
     this.set(S_SaleContent,null);
  }

  public String getSaleContent(){
       return DataType.getAsString(this.get(S_SaleContent));
  
  }
  public String getSaleContentInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleContent));
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

  public void initIsactiveSale(String value){
     this.initProperty(S_IsactiveSale,value);
  }
  public  void setIsactiveSale(String value){
     this.set(S_IsactiveSale,value);
  }
  public  void setIsactiveSaleNull(){
     this.set(S_IsactiveSale,null);
  }

  public String getIsactiveSale(){
       return DataType.getAsString(this.get(S_IsactiveSale));
  
  }
  public String getIsactiveSaleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsactiveSale));
      }

  public void initGoodsCost(long value){
     this.initProperty(S_GoodsCost,new Long(value));
  }
  public  void setGoodsCost(long value){
     this.set(S_GoodsCost,new Long(value));
  }
  public  void setGoodsCostNull(){
     this.set(S_GoodsCost,null);
  }

  public long getGoodsCost(){
        return DataType.getAsLong(this.get(S_GoodsCost));
  
  }
  public long getGoodsCostInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_GoodsCost));
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

  public void initSaleFlagNameW(String value){
     this.initProperty(S_SaleFlagNameW,value);
  }
  public  void setSaleFlagNameW(String value){
     this.set(S_SaleFlagNameW,value);
  }
  public  void setSaleFlagNameWNull(){
     this.set(S_SaleFlagNameW,null);
  }

  public String getSaleFlagNameW(){
       return DataType.getAsString(this.get(S_SaleFlagNameW));
  
  }
  public String getSaleFlagNameWInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleFlagNameW));
      }

  public void initChannelPay(long value){
     this.initProperty(S_ChannelPay,new Long(value));
  }
  public  void setChannelPay(long value){
     this.set(S_ChannelPay,new Long(value));
  }
  public  void setChannelPayNull(){
     this.set(S_ChannelPay,null);
  }

  public long getChannelPay(){
        return DataType.getAsLong(this.get(S_ChannelPay));
  
  }
  public long getChannelPayInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ChannelPay));
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

  public void initPublicityWord(String value){
     this.initProperty(S_PublicityWord,value);
  }
  public  void setPublicityWord(String value){
     this.set(S_PublicityWord,value);
  }
  public  void setPublicityWordNull(){
     this.set(S_PublicityWord,null);
  }

  public String getPublicityWord(){
       return DataType.getAsString(this.get(S_PublicityWord));
  
  }
  public String getPublicityWordInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PublicityWord));
      }

  public void initSaleActiveName(String value){
     this.initProperty(S_SaleActiveName,value);
  }
  public  void setSaleActiveName(String value){
     this.set(S_SaleActiveName,value);
  }
  public  void setSaleActiveNameNull(){
     this.set(S_SaleActiveName,null);
  }

  public String getSaleActiveName(){
       return DataType.getAsString(this.get(S_SaleActiveName));
  
  }
  public String getSaleActiveNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleActiveName));
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

  public void initFeeDiscount(long value){
     this.initProperty(S_FeeDiscount,new Long(value));
  }
  public  void setFeeDiscount(long value){
     this.set(S_FeeDiscount,new Long(value));
  }
  public  void setFeeDiscountNull(){
     this.set(S_FeeDiscount,null);
  }

  public long getFeeDiscount(){
        return DataType.getAsLong(this.get(S_FeeDiscount));
  
  }
  public long getFeeDiscountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_FeeDiscount));
      }

  public void initEstimateOtherFee(long value){
     this.initProperty(S_EstimateOtherFee,new Long(value));
  }
  public  void setEstimateOtherFee(long value){
     this.set(S_EstimateOtherFee,new Long(value));
  }
  public  void setEstimateOtherFeeNull(){
     this.set(S_EstimateOtherFee,null);
  }

  public long getEstimateOtherFee(){
        return DataType.getAsLong(this.get(S_EstimateOtherFee));
  
  }
  public long getEstimateOtherFeeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_EstimateOtherFee));
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

  public void initPreIncome(long value){
     this.initProperty(S_PreIncome,new Long(value));
  }
  public  void setPreIncome(long value){
     this.set(S_PreIncome,new Long(value));
  }
  public  void setPreIncomeNull(){
     this.set(S_PreIncome,null);
  }

  public long getPreIncome(){
        return DataType.getAsLong(this.get(S_PreIncome));
  
  }
  public long getPreIncomeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PreIncome));
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

  public void initBusinessDiscount(long value){
     this.initProperty(S_BusinessDiscount,new Long(value));
  }
  public  void setBusinessDiscount(long value){
     this.set(S_BusinessDiscount,new Long(value));
  }
  public  void setBusinessDiscountNull(){
     this.set(S_BusinessDiscount,null);
  }

  public long getBusinessDiscount(){
        return DataType.getAsLong(this.get(S_BusinessDiscount));
  
  }
  public long getBusinessDiscountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BusinessDiscount));
      }

  public void initOtherBusiTarget(String value){
     this.initProperty(S_OtherBusiTarget,value);
  }
  public  void setOtherBusiTarget(String value){
     this.set(S_OtherBusiTarget,value);
  }
  public  void setOtherBusiTargetNull(){
     this.set(S_OtherBusiTarget,null);
  }

  public String getOtherBusiTarget(){
       return DataType.getAsString(this.get(S_OtherBusiTarget));
  
  }
  public String getOtherBusiTargetInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OtherBusiTarget));
      }

  public void initMobilepayCost(long value){
     this.initProperty(S_MobilepayCost,new Long(value));
  }
  public  void setMobilepayCost(long value){
     this.set(S_MobilepayCost,new Long(value));
  }
  public  void setMobilepayCostNull(){
     this.set(S_MobilepayCost,null);
  }

  public long getMobilepayCost(){
        return DataType.getAsLong(this.get(S_MobilepayCost));
  
  }
  public long getMobilepayCostInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_MobilepayCost));
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

  public void initCostTotal(long value){
     this.initProperty(S_CostTotal,new Long(value));
  }
  public  void setCostTotal(long value){
     this.set(S_CostTotal,new Long(value));
  }
  public  void setCostTotalNull(){
     this.set(S_CostTotal,null);
  }

  public long getCostTotal(){
        return DataType.getAsLong(this.get(S_CostTotal));
  
  }
  public long getCostTotalInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_CostTotal));
      }

  public void initExcludeDemand(String value){
     this.initProperty(S_ExcludeDemand,value);
  }
  public  void setExcludeDemand(String value){
     this.set(S_ExcludeDemand,value);
  }
  public  void setExcludeDemandNull(){
     this.set(S_ExcludeDemand,null);
  }

  public String getExcludeDemand(){
       return DataType.getAsString(this.get(S_ExcludeDemand));
  
  }
  public String getExcludeDemandInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExcludeDemand));
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

  public void initZfqTypeName(String value){
     this.initProperty(S_ZfqTypeName,value);
  }
  public  void setZfqTypeName(String value){
     this.set(S_ZfqTypeName,value);
  }
  public  void setZfqTypeNameNull(){
     this.set(S_ZfqTypeName,null);
  }

  public String getZfqTypeName(){
       return DataType.getAsString(this.get(S_ZfqTypeName));
  
  }
  public String getZfqTypeNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ZfqTypeName));
      }

  public void initSaleTarget(String value){
     this.initProperty(S_SaleTarget,value);
  }
  public  void setSaleTarget(String value){
     this.set(S_SaleTarget,value);
  }
  public  void setSaleTargetNull(){
     this.set(S_SaleTarget,null);
  }

  public String getSaleTarget(){
       return DataType.getAsString(this.get(S_SaleTarget));
  
  }
  public String getSaleTargetInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleTarget));
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

  public void initLevelDesc(String value){
     this.initProperty(S_LevelDesc,value);
  }
  public  void setLevelDesc(String value){
     this.set(S_LevelDesc,value);
  }
  public  void setLevelDescNull(){
     this.set(S_LevelDesc,null);
  }

  public String getLevelDesc(){
       return DataType.getAsString(this.get(S_LevelDesc));
  
  }
  public String getLevelDescInitialValue(){
        return DataType.getAsString(this.getOldObj(S_LevelDesc));
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

  public void initSaletypeOthersale(String value){
     this.initProperty(S_SaletypeOthersale,value);
  }
  public  void setSaletypeOthersale(String value){
     this.set(S_SaletypeOthersale,value);
  }
  public  void setSaletypeOthersaleNull(){
     this.set(S_SaletypeOthersale,null);
  }

  public String getSaletypeOthersale(){
       return DataType.getAsString(this.get(S_SaletypeOthersale));
  
  }
  public String getSaletypeOthersaleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaletypeOthersale));
      }

  public void initOtherUserinfo(String value){
     this.initProperty(S_OtherUserinfo,value);
  }
  public  void setOtherUserinfo(String value){
     this.set(S_OtherUserinfo,value);
  }
  public  void setOtherUserinfoNull(){
     this.set(S_OtherUserinfo,null);
  }

  public String getOtherUserinfo(){
       return DataType.getAsString(this.get(S_OtherUserinfo));
  
  }
  public String getOtherUserinfoInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OtherUserinfo));
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

  public void initBeginTime(Timestamp value){
     this.initProperty(S_BeginTime,value);
  }
  public  void setBeginTime(Timestamp value){
     this.set(S_BeginTime,value);
  }
  public  void setBeginTimeNull(){
     this.set(S_BeginTime,null);
  }

  public Timestamp getBeginTime(){
        return DataType.getAsDateTime(this.get(S_BeginTime));
  
  }
  public Timestamp getBeginTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_BeginTime));
      }

  public void initOpenChannel(String value){
     this.initProperty(S_OpenChannel,value);
  }
  public  void setOpenChannel(String value){
     this.set(S_OpenChannel,value);
  }
  public  void setOpenChannelNull(){
     this.set(S_OpenChannel,null);
  }

  public String getOpenChannel(){
       return DataType.getAsString(this.get(S_OpenChannel));
  
  }
  public String getOpenChannelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OpenChannel));
      }

  public void initWeaponId(String value){
     this.initProperty(S_WeaponId,value);
  }
  public  void setWeaponId(String value){
     this.set(S_WeaponId,value);
  }
  public  void setWeaponIdNull(){
     this.set(S_WeaponId,null);
  }

  public String getWeaponId(){
       return DataType.getAsString(this.get(S_WeaponId));
  
  }
  public String getWeaponIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WeaponId));
      }

  public void initMaxPerson(long value){
     this.initProperty(S_MaxPerson,new Long(value));
  }
  public  void setMaxPerson(long value){
     this.set(S_MaxPerson,new Long(value));
  }
  public  void setMaxPersonNull(){
     this.set(S_MaxPerson,null);
  }

  public long getMaxPerson(){
        return DataType.getAsLong(this.get(S_MaxPerson));
  
  }
  public long getMaxPersonInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_MaxPerson));
      }

  public void initTargetListCode(String value){
     this.initProperty(S_TargetListCode,value);
  }
  public  void setTargetListCode(String value){
     this.set(S_TargetListCode,value);
  }
  public  void setTargetListCodeNull(){
     this.set(S_TargetListCode,null);
  }

  public String getTargetListCode(){
       return DataType.getAsString(this.get(S_TargetListCode));
  
  }
  public String getTargetListCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TargetListCode));
      }

  public void initLevelCode(String value){
     this.initProperty(S_LevelCode,value);
  }
  public  void setLevelCode(String value){
     this.set(S_LevelCode,value);
  }
  public  void setLevelCodeNull(){
     this.set(S_LevelCode,null);
  }

  public String getLevelCode(){
       return DataType.getAsString(this.get(S_LevelCode));
  
  }
  public String getLevelCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_LevelCode));
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

  public void initPreStoreToPresent(long value){
     this.initProperty(S_PreStoreToPresent,new Long(value));
  }
  public  void setPreStoreToPresent(long value){
     this.set(S_PreStoreToPresent,new Long(value));
  }
  public  void setPreStoreToPresentNull(){
     this.set(S_PreStoreToPresent,null);
  }

  public long getPreStoreToPresent(){
        return DataType.getAsLong(this.get(S_PreStoreToPresent));
  
  }
  public long getPreStoreToPresentInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PreStoreToPresent));
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

  public void initEndTime(Timestamp value){
     this.initProperty(S_EndTime,value);
  }
  public  void setEndTime(Timestamp value){
     this.set(S_EndTime,value);
  }
  public  void setEndTimeNull(){
     this.set(S_EndTime,null);
  }

  public Timestamp getEndTime(){
        return DataType.getAsDateTime(this.get(S_EndTime));
  
  }
  public Timestamp getEndTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_EndTime));
      }


 
 }

