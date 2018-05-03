package com.asiainfo.sale.activity.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.activity.ivalues.*;

public class BOSaleDetailBean extends DataContainer implements DataContainerInterface,IBOSaleDetailValue{

  private static String  m_boName = "com.asiainfo.sale.activity.bo.BOSaleDetail";



  public final static  String S_SaletypeDesOthersale = "SALETYPE_DES_OTHERSALE";
  public final static  String S_HandleEmployeeId = "HANDLE_EMPLOYEE_ID";
  public final static  String S_PreIncome = "PRE_INCOME";
  public final static  String S_TerminalCost = "TERMINAL_COST";
  public final static  String S_BrandDesc = "BRAND_DESC";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_PreDiscount = "PRE_DISCOUNT";
  public final static  String S_SaleActiveCode = "SALE_ACTIVE_CODE";
  public final static  String S_MobileCost = "MOBILE_COST";
  public final static  String S_SaleBackground = "SALE_BACKGROUND";
  public final static  String S_PreAddPerson = "PRE_ADD_PERSON";
  public final static  String S_BackProportion = "BACK_PROPORTION";
  public final static  String S_SalePoint = "SALE_POINT";
  public final static  String S_Reserve1 = "RESERVE1";
  public final static  String S_Id = "ID";
  public final static  String S_Reserve3 = "RESERVE3";
  public final static  String S_BusinessDiscount = "BUSINESS_DISCOUNT";
  public final static  String S_OtherBusiTarget = "OTHER_BUSI_TARGET";
  public final static  String S_Reserve2 = "RESERVE2";
  public final static  String S_ChannelPayPolicy = "CHANNEL_PAY_POLICY";
  public final static  String S_PromoteScore = "PROMOTE_SCORE";
  public final static  String S_CostTotal = "COST_TOTAL";
  public final static  String S_MobilepayCost = "MOBILEPAY_COST";
  public final static  String S_CustGroupName = "CUST_GROUP_NAME";
  public final static  String S_IsContractReason = "IS_CONTRACT_REASON";
  public final static  String S_ExcludeDemand = "EXCLUDE_DEMAND";
  public final static  String S_SaleId = "SALE_ID";
  public final static  String S_CustGroupTab = "CUST_GROUP_TAB";
  public final static  String S_ElecgoodsCost = "ELECGOODS_COST";
  public final static  String S_HandleWebsiteId = "HANDLE_WEBSITE_ID";
  public final static  String S_SaleTarget = "SALE_TARGET";
  public final static  String S_ElecpayCost = "ELECPAY_COST";
  public final static  String S_SaleScope = "SALE_SCOPE";
  public final static  String S_PrePerson = "PRE_PERSON";
  public final static  String S_PreBaseFee = "PRE_BASE_FEE";
  public final static  String S_Ext5 = "EXT5";
  public final static  String S_Ext6 = "EXT6";
  public final static  String S_Ext7 = "EXT7";
  public final static  String S_Ext8 = "EXT8";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_Ext3 = "EXT3";
  public final static  String S_Ext4 = "EXT4";
  public final static  String S_EstimateAdFee = "ESTIMATE_AD_FEE";
  public final static  String S_ModifyTime = "MODIFY_TIME";
  public final static  String S_PreIncome2 = "PRE_INCOME2";
  public final static  String S_CgroupBeginTime = "CGROUP_BEGIN_TIME";
  public final static  String S_LevelDesc = "LEVEL_DESC";
  public final static  String S_SaleContent = "SALE_CONTENT";
  public final static  String S_ActiveSaleSite = "ACTIVE_SALE_SITE";
  public final static  String S_Market = "MARKET";
  public final static  String S_SaletypeOthersale = "SALETYPE_OTHERSALE";
  public final static  String S_OtherUserinfo = "OTHER_USERINFO";
  public final static  String S_BeginTime = "BEGIN_TIME";
  public final static  String S_IsactiveSale = "ISACTIVE_SALE";
  public final static  String S_OpenChannel = "OPEN_CHANNEL";
  public final static  String S_WeaponId = "WEAPON_ID";
  public final static  String S_GoodsCost = "GOODS_COST";
  public final static  String S_ActionOut = "ACTION_OUT";
  public final static  String S_ChannelPay = "CHANNEL_PAY";
  public final static  String S_CgroupRegion = "CGROUP_REGION";
  public final static  String S_PublicityWord = "PUBLICITY_WORD";
  public final static  String S_SaleActiveName = "SALE_ACTIVE_NAME";
  public final static  String S_IsContract = "IS_CONTRACT";
  public final static  String S_MaxPerson = "MAX_PERSON";
  public final static  String S_CgroupEndTime = "CGROUP_END_TIME";
  public final static  String S_TargetListCode = "TARGET_LIST_CODE";
  public final static  String S_ManageCondition = "MANAGE_CONDITION";
  public final static  String S_LevelCode = "LEVEL_CODE";
  public final static  String S_SaleFlag = "SALE_FLAG";
  public final static  String S_PreStoreToPresent = "PRE_STORE_TO_PRESENT";
  public final static  String S_CustGroupId = "CUST_GROUP_ID";
  public final static  String S_EndTime = "END_TIME";
  public final static  String S_FeeDiscount = "FEE_DISCOUNT";
  public final static  String S_IsSendSms = "IS_SEND_SMS";
  public final static  String S_EstimateOtherFee = "ESTIMATE_OTHER_FEE";
  public final static  String S_HomeType = "HOME_TYPE";
  public final static  String S_IsLimitCombo = "IS_LIMIT_COMBO";
  public final static  String S_LimitAmount = "LIMIT_AMOUNT";
  public final static  String S_LimType = "LIM_TYPE";
  
  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOSaleDetailBean() throws AIException{
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

  public void initHandleEmployeeId(String value){
     this.initProperty(S_HandleEmployeeId,value);
  }
  public  void setHandleEmployeeId(String value){
     this.set(S_HandleEmployeeId,value);
  }
  public  void setHandleEmployeeIdNull(){
     this.set(S_HandleEmployeeId,null);
  }

  public String getHandleEmployeeId(){
       return DataType.getAsString(this.get(S_HandleEmployeeId));
  
  }
  public String getHandleEmployeeIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_HandleEmployeeId));
      }

  public void initPreIncome(double value){
     this.initProperty(S_PreIncome,new Double(value));
  }
  public  void setPreIncome(double value){
     this.set(S_PreIncome,new Double(value));
  }
  public  void setPreIncomeNull(){
     this.set(S_PreIncome,null);
  }

  public double getPreIncome(){
        return DataType.getAsDouble(this.get(S_PreIncome));
  
  }
  public double getPreIncomeInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PreIncome));
      }

  public void initTerminalCost(double value){
     this.initProperty(S_TerminalCost,new Double(value));
  }
  public  void setTerminalCost(double value){
     this.set(S_TerminalCost,new Double(value));
  }
  public  void setTerminalCostNull(){
     this.set(S_TerminalCost,null);
  }

  public double getTerminalCost(){
        return DataType.getAsDouble(this.get(S_TerminalCost));
  
  }
  public double getTerminalCostInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_TerminalCost));
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

  public void initPreDiscount(double value){
     this.initProperty(S_PreDiscount,new Double(value));
  }
  public  void setPreDiscount(double value){
     this.set(S_PreDiscount,new Double(value));
  }
  public  void setPreDiscountNull(){
     this.set(S_PreDiscount,null);
  }

  public double getPreDiscount(){
        return DataType.getAsDouble(this.get(S_PreDiscount));
  
  }
  public double getPreDiscountInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PreDiscount));
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

  public void initMobileCost(double value){
     this.initProperty(S_MobileCost,new Double(value));
  }
  public  void setMobileCost(double value){
     this.set(S_MobileCost,new Double(value));
  }
  public  void setMobileCostNull(){
     this.set(S_MobileCost,null);
  }

  public double getMobileCost(){
        return DataType.getAsDouble(this.get(S_MobileCost));
  
  }
  public double getMobileCostInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_MobileCost));
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

  public void initPreAddPerson(int value){
     this.initProperty(S_PreAddPerson,new Integer(value));
  }
  public  void setPreAddPerson(int value){
     this.set(S_PreAddPerson,new Integer(value));
  }
  public  void setPreAddPersonNull(){
     this.set(S_PreAddPerson,null);
  }

  public int getPreAddPerson(){
        return DataType.getAsInt(this.get(S_PreAddPerson));
  
  }
  public int getPreAddPersonInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_PreAddPerson));
      }

  public void initBackProportion(double value){
     this.initProperty(S_BackProportion,new Double(value));
  }
  public  void setBackProportion(double value){
     this.set(S_BackProportion,new Double(value));
  }
  public  void setBackProportionNull(){
     this.set(S_BackProportion,null);
  }

  public double getBackProportion(){
        return DataType.getAsDouble(this.get(S_BackProportion));
  
  }
  public double getBackProportionInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_BackProportion));
      }

  public void initSalePoint(double value){
     this.initProperty(S_SalePoint,new Double(value));
  }
  public  void setSalePoint(double value){
     this.set(S_SalePoint,new Double(value));
  }
  public  void setSalePointNull(){
     this.set(S_SalePoint,null);
  }

  public double getSalePoint(){
        return DataType.getAsDouble(this.get(S_SalePoint));
  
  }
  public double getSalePointInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_SalePoint));
      }

  public void initReserve1(double value){
     this.initProperty(S_Reserve1,new Double(value));
  }
  public  void setReserve1(double value){
     this.set(S_Reserve1,new Double(value));
  }
  public  void setReserve1Null(){
     this.set(S_Reserve1,null);
  }

  public double getReserve1(){
        return DataType.getAsDouble(this.get(S_Reserve1));
  
  }
  public double getReserve1InitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_Reserve1));
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

  public void initReserve3(String value){
     this.initProperty(S_Reserve3,value);
  }
  public  void setReserve3(String value){
     this.set(S_Reserve3,value);
  }
  public  void setReserve3Null(){
     this.set(S_Reserve3,null);
  }

  public String getReserve3(){
       return DataType.getAsString(this.get(S_Reserve3));
  
  }
  public String getReserve3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Reserve3));
      }

  public void initBusinessDiscount(double value){
     this.initProperty(S_BusinessDiscount,new Double(value));
  }
  public  void setBusinessDiscount(double value){
     this.set(S_BusinessDiscount,new Double(value));
  }
  public  void setBusinessDiscountNull(){
     this.set(S_BusinessDiscount,null);
  }

  public double getBusinessDiscount(){
        return DataType.getAsDouble(this.get(S_BusinessDiscount));
  
  }
  public double getBusinessDiscountInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_BusinessDiscount));
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

  public void initReserve2(double value){
     this.initProperty(S_Reserve2,new Double(value));
  }
  public  void setReserve2(double value){
     this.set(S_Reserve2,new Double(value));
  }
  public  void setReserve2Null(){
     this.set(S_Reserve2,null);
  }

  public double getReserve2(){
        return DataType.getAsDouble(this.get(S_Reserve2));
  
  }
  public double getReserve2InitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_Reserve2));
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

  public void initPromoteScore(String value){
     this.initProperty(S_PromoteScore,value);
  }
  public  void setPromoteScore(String value){
     this.set(S_PromoteScore,value);
  }
  public  void setPromoteScoreNull(){
     this.set(S_PromoteScore,null);
  }

  public String getPromoteScore(){
       return DataType.getAsString(this.get(S_PromoteScore));
  
  }
  public String getPromoteScoreInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PromoteScore));
      }

  public void initCostTotal(double value){
     this.initProperty(S_CostTotal,new Double(value));
  }
  public  void setCostTotal(double value){
     this.set(S_CostTotal,new Double(value));
  }
  public  void setCostTotalNull(){
     this.set(S_CostTotal,null);
  }

  public double getCostTotal(){
        return DataType.getAsDouble(this.get(S_CostTotal));
  
  }
  public double getCostTotalInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_CostTotal));
      }

  public void initMobilepayCost(double value){
     this.initProperty(S_MobilepayCost,new Double(value));
  }
  public  void setMobilepayCost(double value){
     this.set(S_MobilepayCost,new Double(value));
  }
  public  void setMobilepayCostNull(){
     this.set(S_MobilepayCost,null);
  }

  public double getMobilepayCost(){
        return DataType.getAsDouble(this.get(S_MobilepayCost));
  
  }
  public double getMobilepayCostInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_MobilepayCost));
      }

  public void initCustGroupName(String value){
     this.initProperty(S_CustGroupName,value);
  }
  public  void setCustGroupName(String value){
     this.set(S_CustGroupName,value);
  }
  public  void setCustGroupNameNull(){
     this.set(S_CustGroupName,null);
  }

  public String getCustGroupName(){
       return DataType.getAsString(this.get(S_CustGroupName));
  
  }
  public String getCustGroupNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CustGroupName));
      }

  public void initIsContractReason(String value){
     this.initProperty(S_IsContractReason,value);
  }
  public  void setIsContractReason(String value){
     this.set(S_IsContractReason,value);
  }
  public  void setIsContractReasonNull(){
     this.set(S_IsContractReason,null);
  }

  public String getIsContractReason(){
       return DataType.getAsString(this.get(S_IsContractReason));
  
  }
  public String getIsContractReasonInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsContractReason));
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

  public void initCustGroupTab(String value){
     this.initProperty(S_CustGroupTab,value);
  }
  public  void setCustGroupTab(String value){
     this.set(S_CustGroupTab,value);
  }
  public  void setCustGroupTabNull(){
     this.set(S_CustGroupTab,null);
  }

  public String getCustGroupTab(){
       return DataType.getAsString(this.get(S_CustGroupTab));
  
  }
  public String getCustGroupTabInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CustGroupTab));
      }

  public void initElecgoodsCost(double value){
     this.initProperty(S_ElecgoodsCost,new Double(value));
  }
  public  void setElecgoodsCost(double value){
     this.set(S_ElecgoodsCost,new Double(value));
  }
  public  void setElecgoodsCostNull(){
     this.set(S_ElecgoodsCost,null);
  }

  public double getElecgoodsCost(){
        return DataType.getAsDouble(this.get(S_ElecgoodsCost));
  
  }
  public double getElecgoodsCostInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_ElecgoodsCost));
      }

  public void initHandleWebsiteId(String value){
     this.initProperty(S_HandleWebsiteId,value);
  }
  public  void setHandleWebsiteId(String value){
     this.set(S_HandleWebsiteId,value);
  }
  public  void setHandleWebsiteIdNull(){
     this.set(S_HandleWebsiteId,null);
  }

  public String getHandleWebsiteId(){
       return DataType.getAsString(this.get(S_HandleWebsiteId));
  
  }
  public String getHandleWebsiteIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_HandleWebsiteId));
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

  public void initElecpayCost(double value){
     this.initProperty(S_ElecpayCost,new Double(value));
  }
  public  void setElecpayCost(double value){
     this.set(S_ElecpayCost,new Double(value));
  }
  public  void setElecpayCostNull(){
     this.set(S_ElecpayCost,null);
  }

  public double getElecpayCost(){
        return DataType.getAsDouble(this.get(S_ElecpayCost));
  
  }
  public double getElecpayCostInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_ElecpayCost));
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

  public void initPrePerson(int value){
     this.initProperty(S_PrePerson,new Integer(value));
  }
  public  void setPrePerson(int value){
     this.set(S_PrePerson,new Integer(value));
  }
  public  void setPrePersonNull(){
     this.set(S_PrePerson,null);
  }

  public int getPrePerson(){
        return DataType.getAsInt(this.get(S_PrePerson));
  
  }
  public int getPrePersonInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_PrePerson));
      }

  public void initPreBaseFee(double value){
     this.initProperty(S_PreBaseFee,new Double(value));
  }
  public  void setPreBaseFee(double value){
     this.set(S_PreBaseFee,new Double(value));
  }
  public  void setPreBaseFeeNull(){
     this.set(S_PreBaseFee,null);
  }

  public double getPreBaseFee(){
        return DataType.getAsDouble(this.get(S_PreBaseFee));
  
  }
  public double getPreBaseFeeInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PreBaseFee));
      }

  public void initExt5(String value){
     this.initProperty(S_Ext5,value);
  }
  public  void setExt5(String value){
     this.set(S_Ext5,value);
  }
  public  void setExt5Null(){
     this.set(S_Ext5,null);
  }

  public String getExt5(){
       return DataType.getAsString(this.get(S_Ext5));
  
  }
  public String getExt5InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext5));
      }

  public void initExt6(int value){
     this.initProperty(S_Ext6,new Integer(value));
  }
  public  void setExt6(int value){
     this.set(S_Ext6,new Integer(value));
  }
  public  void setExt6Null(){
     this.set(S_Ext6,null);
  }

  public int getExt6(){
        return DataType.getAsInt(this.get(S_Ext6));
  
  }
  public int getExt6InitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Ext6));
      }

  public void initExt7(int value){
     this.initProperty(S_Ext7,new Integer(value));
  }
  public  void setExt7(int value){
     this.set(S_Ext7,new Integer(value));
  }
  public  void setExt7Null(){
     this.set(S_Ext7,null);
  }

  public int getExt7(){
        return DataType.getAsInt(this.get(S_Ext7));
  
  }
  public int getExt7InitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Ext7));
      }

  public void initExt8(double value){
     this.initProperty(S_Ext8,new Double(value));
  }
  public  void setExt8(double value){
     this.set(S_Ext8,new Double(value));
  }
  public  void setExt8Null(){
     this.set(S_Ext8,null);
  }

  public double getExt8(){
        return DataType.getAsDouble(this.get(S_Ext8));
  
  }
  public double getExt8InitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_Ext8));
      }

  public void initExt1(String value){
     this.initProperty(S_Ext1,value);
  }
  public  void setExt1(String value){
     this.set(S_Ext1,value);
  }
  public  void setExt1Null(){
     this.set(S_Ext1,null);
  }

  public String getExt1(){
       return DataType.getAsString(this.get(S_Ext1));
  
  }
  public String getExt1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext1));
      }

  public void initExt2(String value){
     this.initProperty(S_Ext2,value);
  }
  public  void setExt2(String value){
     this.set(S_Ext2,value);
  }
  public  void setExt2Null(){
     this.set(S_Ext2,null);
  }

  public String getExt2(){
       return DataType.getAsString(this.get(S_Ext2));
  
  }
  public String getExt2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext2));
      }

  public void initExt3(String value){
     this.initProperty(S_Ext3,value);
  }
  public  void setExt3(String value){
     this.set(S_Ext3,value);
  }
  public  void setExt3Null(){
     this.set(S_Ext3,null);
  }

  public String getExt3(){
       return DataType.getAsString(this.get(S_Ext3));
  
  }
  public String getExt3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext3));
      }

  public void initExt4(String value){
     this.initProperty(S_Ext4,value);
  }
  public  void setExt4(String value){
     this.set(S_Ext4,value);
  }
  public  void setExt4Null(){
     this.set(S_Ext4,null);
  }

  public String getExt4(){
       return DataType.getAsString(this.get(S_Ext4));
  
  }
  public String getExt4InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext4));
      }

  public void initEstimateAdFee(double value){
     this.initProperty(S_EstimateAdFee,new Double(value));
  }
  public  void setEstimateAdFee(double value){
     this.set(S_EstimateAdFee,new Double(value));
  }
  public  void setEstimateAdFeeNull(){
     this.set(S_EstimateAdFee,null);
  }

  public double getEstimateAdFee(){
        return DataType.getAsDouble(this.get(S_EstimateAdFee));
  
  }
  public double getEstimateAdFeeInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_EstimateAdFee));
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

  public void initPreIncome2(double value){
     this.initProperty(S_PreIncome2,new Double(value));
  }
  public  void setPreIncome2(double value){
     this.set(S_PreIncome2,new Double(value));
  }
  public  void setPreIncome2Null(){
     this.set(S_PreIncome2,null);
  }

  public double getPreIncome2(){
        return DataType.getAsDouble(this.get(S_PreIncome2));
  
  }
  public double getPreIncome2InitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PreIncome2));
      }

  public void initCgroupBeginTime(Timestamp value){
     this.initProperty(S_CgroupBeginTime,value);
  }
  public  void setCgroupBeginTime(Timestamp value){
     this.set(S_CgroupBeginTime,value);
  }
  public  void setCgroupBeginTimeNull(){
     this.set(S_CgroupBeginTime,null);
  }

  public Timestamp getCgroupBeginTime(){
        return DataType.getAsDateTime(this.get(S_CgroupBeginTime));
  
  }
  public Timestamp getCgroupBeginTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CgroupBeginTime));
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

  public void initGoodsCost(double value){
     this.initProperty(S_GoodsCost,new Double(value));
  }
  public  void setGoodsCost(double value){
     this.set(S_GoodsCost,new Double(value));
  }
  public  void setGoodsCostNull(){
     this.set(S_GoodsCost,null);
  }

  public double getGoodsCost(){
        return DataType.getAsDouble(this.get(S_GoodsCost));
  
  }
  public double getGoodsCostInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_GoodsCost));
      }

  public void initActionOut(double value){
     this.initProperty(S_ActionOut,new Double(value));
  }
  public  void setActionOut(double value){
     this.set(S_ActionOut,new Double(value));
  }
  public  void setActionOutNull(){
     this.set(S_ActionOut,null);
  }

  public double getActionOut(){
        return DataType.getAsDouble(this.get(S_ActionOut));
  
  }
  public double getActionOutInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_ActionOut));
      }

  public void initChannelPay(double value){
     this.initProperty(S_ChannelPay,new Double(value));
  }
  public  void setChannelPay(double value){
     this.set(S_ChannelPay,new Double(value));
  }
  public  void setChannelPayNull(){
     this.set(S_ChannelPay,null);
  }

  public double getChannelPay(){
        return DataType.getAsDouble(this.get(S_ChannelPay));
  
  }
  public double getChannelPayInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_ChannelPay));
      }

  public void initCgroupRegion(String value){
     this.initProperty(S_CgroupRegion,value);
  }
  public  void setCgroupRegion(String value){
     this.set(S_CgroupRegion,value);
  }
  public  void setCgroupRegionNull(){
     this.set(S_CgroupRegion,null);
  }

  public String getCgroupRegion(){
       return DataType.getAsString(this.get(S_CgroupRegion));
  
  }
  public String getCgroupRegionInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CgroupRegion));
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

  public void initIsContract(String value){
     this.initProperty(S_IsContract,value);
  }
  public  void setIsContract(String value){
     this.set(S_IsContract,value);
  }
  public  void setIsContractNull(){
     this.set(S_IsContract,null);
  }

  public String getIsContract(){
       return DataType.getAsString(this.get(S_IsContract));
  
  }
  public String getIsContractInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsContract));
      }

  public void initMaxPerson(int value){
     this.initProperty(S_MaxPerson,new Integer(value));
  }
  public  void setMaxPerson(int value){
     this.set(S_MaxPerson,new Integer(value));
  }
  public  void setMaxPersonNull(){
     this.set(S_MaxPerson,null);
  }

  public int getMaxPerson(){
        return DataType.getAsInt(this.get(S_MaxPerson));
  
  }
  public int getMaxPersonInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_MaxPerson));
      }

  public void initCgroupEndTime(Timestamp value){
     this.initProperty(S_CgroupEndTime,value);
  }
  public  void setCgroupEndTime(Timestamp value){
     this.set(S_CgroupEndTime,value);
  }
  public  void setCgroupEndTimeNull(){
     this.set(S_CgroupEndTime,null);
  }

  public Timestamp getCgroupEndTime(){
        return DataType.getAsDateTime(this.get(S_CgroupEndTime));
  
  }
  public Timestamp getCgroupEndTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CgroupEndTime));
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

  public void initManageCondition(String value){
     this.initProperty(S_ManageCondition,value);
  }
  public  void setManageCondition(String value){
     this.set(S_ManageCondition,value);
  }
  public  void setManageConditionNull(){
     this.set(S_ManageCondition,null);
  }

  public String getManageCondition(){
       return DataType.getAsString(this.get(S_ManageCondition));
  
  }
  public String getManageConditionInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ManageCondition));
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

  public void initPreStoreToPresent(double value){
     this.initProperty(S_PreStoreToPresent,new Double(value));
  }
  public  void setPreStoreToPresent(double value){
     this.set(S_PreStoreToPresent,new Double(value));
  }
  public  void setPreStoreToPresentNull(){
     this.set(S_PreStoreToPresent,null);
  }

  public double getPreStoreToPresent(){
        return DataType.getAsDouble(this.get(S_PreStoreToPresent));
  
  }
  public double getPreStoreToPresentInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PreStoreToPresent));
      }

  public void initCustGroupId(String value){
     this.initProperty(S_CustGroupId,value);
  }
  public  void setCustGroupId(String value){
     this.set(S_CustGroupId,value);
  }
  public  void setCustGroupIdNull(){
     this.set(S_CustGroupId,null);
  }

  public String getCustGroupId(){
       return DataType.getAsString(this.get(S_CustGroupId));
  
  }
  public String getCustGroupIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CustGroupId));
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

  public void initFeeDiscount(double value){
     this.initProperty(S_FeeDiscount,new Double(value));
  }
  public  void setFeeDiscount(double value){
     this.set(S_FeeDiscount,new Double(value));
  }
  public  void setFeeDiscountNull(){
     this.set(S_FeeDiscount,null);
  }

  public double getFeeDiscount(){
        return DataType.getAsDouble(this.get(S_FeeDiscount));
  
  }
  public double getFeeDiscountInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_FeeDiscount));
      }

  public void initIsSendSms(String value){
     this.initProperty(S_IsSendSms,value);
  }
  public  void setIsSendSms(String value){
     this.set(S_IsSendSms,value);
  }
  public  void setIsSendSmsNull(){
     this.set(S_IsSendSms,null);
  }

  public String getIsSendSms(){
       return DataType.getAsString(this.get(S_IsSendSms));
  
  }
  public String getIsSendSmsInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsSendSms));
      }

  public void initEstimateOtherFee(double value){
     this.initProperty(S_EstimateOtherFee,new Double(value));
  }
  public  void setEstimateOtherFee(double value){
     this.set(S_EstimateOtherFee,new Double(value));
  }
  public  void setEstimateOtherFeeNull(){
     this.set(S_EstimateOtherFee,null);
  }

  public double getEstimateOtherFee(){
        return DataType.getAsDouble(this.get(S_EstimateOtherFee));
  
  }
  public double getEstimateOtherFeeInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_EstimateOtherFee));
      }

  public void initHomeType(String value){
	     this.initProperty(S_HomeType,value);
	  }
	  public  void setHomeType(String value){
	     this.set(S_HomeType,value);
	  }
	  public  void setHomeTypeNull(){
	     this.set(S_HomeType,null);
	  }

	  public String getHomeType(){
	       return DataType.getAsString(this.get(S_HomeType));
	  
	  }
	  public String getHomeTypeInitialValue(){
	        return DataType.getAsString(this.getOldObj(S_HomeType));
	      }
	  //is_limit_combo
	  public void initIsLimitCombo(String value){
		     this.initProperty(S_IsLimitCombo,value);
	  }
	  public  void setIsLimitCombo(String value){
		     this.set(S_IsLimitCombo,value);
		}
	 public  void setIsLimitComboNull(){
		     this.set(S_IsLimitCombo,null);
		}

	public String getIsLimitCombo(){
		 return DataType.getAsString(this.get(S_IsLimitCombo));
		  
	}
	public String getIsLimitComboInitialValue(){
		 return DataType.getAsString(this.getOldObj(S_IsLimitCombo));
	}
	  
	//limit_amount
	 public void initLimitAmount(double value){
	     this.initProperty(S_LimitAmount,value);
	  }
	  public  void setLimitAmount(double value){
	     this.set(S_LimitAmount,value);
	  }
	  public  void setLimitAmountNull(){
	     this.set(S_LimitAmount,null);
	  }

	  public double getLimitAmount(){
	       return DataType.getAsDouble(this.get(S_LimitAmount));
	  
	  }
	  public double getLimitAmountInitialValue(){
	        return DataType.getAsDouble(this.getOldObj(S_LimitAmount));
	  }
	  
	  //lim_type,S_LimType
	  
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
 }

