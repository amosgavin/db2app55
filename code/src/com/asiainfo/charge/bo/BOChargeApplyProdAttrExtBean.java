package com.asiainfo.charge.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.charge.ivalues.*;

public class BOChargeApplyProdAttrExtBean extends DataContainer implements DataContainerInterface,IBOChargeApplyProdAttrExtValue{

  private static String  m_boName = "com.asiainfo.charge.bo.BOChargeApplyProdAttrExt";



  public final static  String S_IncomeShare = "INCOME_SHARE";
  public final static  String S_PreferentialConditions = "PREFERENTIAL_CONDITIONS";
  public final static  String S_State = "STATE";
  public final static  String S_ModifyTime = "MODIFY_TIME";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_IsMinimumCharge = "IS_MINIMUM_CHARGE";
  public final static  String S_MonthlyFee = "MONTHLY_FEE";
  public final static  String S_SettlementInstructions = "SETTLEMENT_INSTRUCTIONS";
  public final static  String S_ChargeProcess = "CHARGE_PROCESS";
  public final static  String S_ChargeId = "CHARGE_ID";
  public final static  String S_AreaCode = "AREA_CODE";
  public final static  String S_PreferentialRange = "PREFERENTIAL_RANGE";
  public final static  String S_ChargeRepulsion = "CHARGE_REPULSION";
  public final static  String S_OtherPreferential = "OTHER_PREFERENTIAL";
  public final static  String S_IsMonthlyRent = "IS_MONTHLY_RENT";
  public final static  String S_MinimumChargeRange = "MINIMUM_CHARGE_RANGE";
  public final static  String S_OperType = "OPER_TYPE";
  public final static  String S_TestDepart = "TEST_DEPART";
  public final static  String S_DisposableIncome = "DISPOSABLE_INCOME";
  public final static  String S_PromoteDepart = "PROMOTE_DEPART";
  public final static  String S_ApplyId = "APPLY_ID";
  public final static  String S_TestTime = "TEST_TIME";
  public final static  String S_Rounding = "ROUNDING";
  public final static  String S_ApplyName = "APPLY_NAME";
  public final static  String S_NonDisposableIncome = "NON_DISPOSABLE_INCOME";
  public final static  String S_TestResult = "TEST_RESULT";
  public final static  String S_ProductDescription = "PRODUCT_DESCRIPTION";
  public final static  String S_Principal = "PRINCIPAL";
  public final static  String S_OtherChargeRequirement = "OTHER_CHARGE_REQUIREMENT";
  public final static  String S_IsUserProcess = "IS_USER_PROCESS";
  public final static  String S_TestPrincipal = "TEST_PRINCIPAL";
  public final static  String S_Ext5 = "EXT5";
  public final static  String S_Ext6 = "EXT6";
  public final static  String S_Ext7 = "EXT7";
  public final static  String S_ReportDetails = "REPORT_DETAILS";
  public final static  String S_DoneTime = "DONE_TIME";
  public final static  String S_Ext8 = "EXT8";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_ChannelDescription = "CHANNEL_DESCRIPTION";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_Ext3 = "EXT3";
  public final static  String S_Ext4 = "EXT4";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOChargeApplyProdAttrExtBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initIncomeShare(String value){
     this.initProperty(S_IncomeShare,value);
  }
  public  void setIncomeShare(String value){
     this.set(S_IncomeShare,value);
  }
  public  void setIncomeShareNull(){
     this.set(S_IncomeShare,null);
  }

  public String getIncomeShare(){
       return DataType.getAsString(this.get(S_IncomeShare));
  
  }
  public String getIncomeShareInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IncomeShare));
      }

  public void initPreferentialConditions(String value){
     this.initProperty(S_PreferentialConditions,value);
  }
  public  void setPreferentialConditions(String value){
     this.set(S_PreferentialConditions,value);
  }
  public  void setPreferentialConditionsNull(){
     this.set(S_PreferentialConditions,null);
  }

  public String getPreferentialConditions(){
       return DataType.getAsString(this.get(S_PreferentialConditions));
  
  }
  public String getPreferentialConditionsInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PreferentialConditions));
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

  public void initRemarks(String value){
     this.initProperty(S_Remarks,value);
  }
  public  void setRemarks(String value){
     this.set(S_Remarks,value);
  }
  public  void setRemarksNull(){
     this.set(S_Remarks,null);
  }

  public String getRemarks(){
       return DataType.getAsString(this.get(S_Remarks));
  
  }
  public String getRemarksInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remarks));
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

  public void initIsMinimumCharge(String value){
     this.initProperty(S_IsMinimumCharge,value);
  }
  public  void setIsMinimumCharge(String value){
     this.set(S_IsMinimumCharge,value);
  }
  public  void setIsMinimumChargeNull(){
     this.set(S_IsMinimumCharge,null);
  }

  public String getIsMinimumCharge(){
       return DataType.getAsString(this.get(S_IsMinimumCharge));
  
  }
  public String getIsMinimumChargeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsMinimumCharge));
      }

  public void initMonthlyFee(double value){
     this.initProperty(S_MonthlyFee,new Double(value));
  }
  public  void setMonthlyFee(double value){
     this.set(S_MonthlyFee,new Double(value));
  }
  public  void setMonthlyFeeNull(){
     this.set(S_MonthlyFee,null);
  }

  public double getMonthlyFee(){
        return DataType.getAsDouble(this.get(S_MonthlyFee));
  
  }
  public double getMonthlyFeeInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_MonthlyFee));
      }

  public void initSettlementInstructions(String value){
     this.initProperty(S_SettlementInstructions,value);
  }
  public  void setSettlementInstructions(String value){
     this.set(S_SettlementInstructions,value);
  }
  public  void setSettlementInstructionsNull(){
     this.set(S_SettlementInstructions,null);
  }

  public String getSettlementInstructions(){
       return DataType.getAsString(this.get(S_SettlementInstructions));
  
  }
  public String getSettlementInstructionsInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SettlementInstructions));
      }

  public void initChargeProcess(String value){
     this.initProperty(S_ChargeProcess,value);
  }
  public  void setChargeProcess(String value){
     this.set(S_ChargeProcess,value);
  }
  public  void setChargeProcessNull(){
     this.set(S_ChargeProcess,null);
  }

  public String getChargeProcess(){
       return DataType.getAsString(this.get(S_ChargeProcess));
  
  }
  public String getChargeProcessInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ChargeProcess));
      }

  public void initChargeId(String value){
     this.initProperty(S_ChargeId,value);
  }
  public  void setChargeId(String value){
     this.set(S_ChargeId,value);
  }
  public  void setChargeIdNull(){
     this.set(S_ChargeId,null);
  }

  public String getChargeId(){
       return DataType.getAsString(this.get(S_ChargeId));
  
  }
  public String getChargeIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ChargeId));
      }

  public void initAreaCode(String value){
     this.initProperty(S_AreaCode,value);
  }
  public  void setAreaCode(String value){
     this.set(S_AreaCode,value);
  }
  public  void setAreaCodeNull(){
     this.set(S_AreaCode,null);
  }

  public String getAreaCode(){
       return DataType.getAsString(this.get(S_AreaCode));
  
  }
  public String getAreaCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AreaCode));
      }

  public void initPreferentialRange(String value){
     this.initProperty(S_PreferentialRange,value);
  }
  public  void setPreferentialRange(String value){
     this.set(S_PreferentialRange,value);
  }
  public  void setPreferentialRangeNull(){
     this.set(S_PreferentialRange,null);
  }

  public String getPreferentialRange(){
       return DataType.getAsString(this.get(S_PreferentialRange));
  
  }
  public String getPreferentialRangeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PreferentialRange));
      }

  public void initChargeRepulsion(String value){
     this.initProperty(S_ChargeRepulsion,value);
  }
  public  void setChargeRepulsion(String value){
     this.set(S_ChargeRepulsion,value);
  }
  public  void setChargeRepulsionNull(){
     this.set(S_ChargeRepulsion,null);
  }

  public String getChargeRepulsion(){
       return DataType.getAsString(this.get(S_ChargeRepulsion));
  
  }
  public String getChargeRepulsionInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ChargeRepulsion));
      }

  public void initOtherPreferential(String value){
     this.initProperty(S_OtherPreferential,value);
  }
  public  void setOtherPreferential(String value){
     this.set(S_OtherPreferential,value);
  }
  public  void setOtherPreferentialNull(){
     this.set(S_OtherPreferential,null);
  }

  public String getOtherPreferential(){
       return DataType.getAsString(this.get(S_OtherPreferential));
  
  }
  public String getOtherPreferentialInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OtherPreferential));
      }

  public void initIsMonthlyRent(String value){
     this.initProperty(S_IsMonthlyRent,value);
  }
  public  void setIsMonthlyRent(String value){
     this.set(S_IsMonthlyRent,value);
  }
  public  void setIsMonthlyRentNull(){
     this.set(S_IsMonthlyRent,null);
  }

  public String getIsMonthlyRent(){
       return DataType.getAsString(this.get(S_IsMonthlyRent));
  
  }
  public String getIsMonthlyRentInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsMonthlyRent));
      }

  public void initMinimumChargeRange(String value){
     this.initProperty(S_MinimumChargeRange,value);
  }
  public  void setMinimumChargeRange(String value){
     this.set(S_MinimumChargeRange,value);
  }
  public  void setMinimumChargeRangeNull(){
     this.set(S_MinimumChargeRange,null);
  }

  public String getMinimumChargeRange(){
       return DataType.getAsString(this.get(S_MinimumChargeRange));
  
  }
  public String getMinimumChargeRangeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MinimumChargeRange));
      }

  public void initOperType(String value){
     this.initProperty(S_OperType,value);
  }
  public  void setOperType(String value){
     this.set(S_OperType,value);
  }
  public  void setOperTypeNull(){
     this.set(S_OperType,null);
  }

  public String getOperType(){
       return DataType.getAsString(this.get(S_OperType));
  
  }
  public String getOperTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OperType));
      }

  public void initTestDepart(String value){
     this.initProperty(S_TestDepart,value);
  }
  public  void setTestDepart(String value){
     this.set(S_TestDepart,value);
  }
  public  void setTestDepartNull(){
     this.set(S_TestDepart,null);
  }

  public String getTestDepart(){
       return DataType.getAsString(this.get(S_TestDepart));
  
  }
  public String getTestDepartInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TestDepart));
      }

  public void initDisposableIncome(String value){
     this.initProperty(S_DisposableIncome,value);
  }
  public  void setDisposableIncome(String value){
     this.set(S_DisposableIncome,value);
  }
  public  void setDisposableIncomeNull(){
     this.set(S_DisposableIncome,null);
  }

  public String getDisposableIncome(){
       return DataType.getAsString(this.get(S_DisposableIncome));
  
  }
  public String getDisposableIncomeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DisposableIncome));
      }

  public void initPromoteDepart(String value){
     this.initProperty(S_PromoteDepart,value);
  }
  public  void setPromoteDepart(String value){
     this.set(S_PromoteDepart,value);
  }
  public  void setPromoteDepartNull(){
     this.set(S_PromoteDepart,null);
  }

  public String getPromoteDepart(){
       return DataType.getAsString(this.get(S_PromoteDepart));
  
  }
  public String getPromoteDepartInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PromoteDepart));
      }

  public void initApplyId(String value){
     this.initProperty(S_ApplyId,value);
  }
  public  void setApplyId(String value){
     this.set(S_ApplyId,value);
  }
  public  void setApplyIdNull(){
     this.set(S_ApplyId,null);
  }

  public String getApplyId(){
       return DataType.getAsString(this.get(S_ApplyId));
  
  }
  public String getApplyIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ApplyId));
      }

  public void initTestTime(Timestamp value){
     this.initProperty(S_TestTime,value);
  }
  public  void setTestTime(Timestamp value){
     this.set(S_TestTime,value);
  }
  public  void setTestTimeNull(){
     this.set(S_TestTime,null);
  }

  public Timestamp getTestTime(){
        return DataType.getAsDateTime(this.get(S_TestTime));
  
  }
  public Timestamp getTestTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_TestTime));
      }

  public void initRounding(String value){
     this.initProperty(S_Rounding,value);
  }
  public  void setRounding(String value){
     this.set(S_Rounding,value);
  }
  public  void setRoundingNull(){
     this.set(S_Rounding,null);
  }

  public String getRounding(){
       return DataType.getAsString(this.get(S_Rounding));
  
  }
  public String getRoundingInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Rounding));
      }

  public void initApplyName(String value){
     this.initProperty(S_ApplyName,value);
  }
  public  void setApplyName(String value){
     this.set(S_ApplyName,value);
  }
  public  void setApplyNameNull(){
     this.set(S_ApplyName,null);
  }

  public String getApplyName(){
       return DataType.getAsString(this.get(S_ApplyName));
  
  }
  public String getApplyNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ApplyName));
      }

  public void initNonDisposableIncome(String value){
     this.initProperty(S_NonDisposableIncome,value);
  }
  public  void setNonDisposableIncome(String value){
     this.set(S_NonDisposableIncome,value);
  }
  public  void setNonDisposableIncomeNull(){
     this.set(S_NonDisposableIncome,null);
  }

  public String getNonDisposableIncome(){
       return DataType.getAsString(this.get(S_NonDisposableIncome));
  
  }
  public String getNonDisposableIncomeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_NonDisposableIncome));
      }

  public void initTestResult(String value){
     this.initProperty(S_TestResult,value);
  }
  public  void setTestResult(String value){
     this.set(S_TestResult,value);
  }
  public  void setTestResultNull(){
     this.set(S_TestResult,null);
  }

  public String getTestResult(){
       return DataType.getAsString(this.get(S_TestResult));
  
  }
  public String getTestResultInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TestResult));
      }

  public void initProductDescription(String value){
     this.initProperty(S_ProductDescription,value);
  }
  public  void setProductDescription(String value){
     this.set(S_ProductDescription,value);
  }
  public  void setProductDescriptionNull(){
     this.set(S_ProductDescription,null);
  }

  public String getProductDescription(){
       return DataType.getAsString(this.get(S_ProductDescription));
  
  }
  public String getProductDescriptionInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ProductDescription));
      }

  public void initPrincipal(String value){
     this.initProperty(S_Principal,value);
  }
  public  void setPrincipal(String value){
     this.set(S_Principal,value);
  }
  public  void setPrincipalNull(){
     this.set(S_Principal,null);
  }

  public String getPrincipal(){
       return DataType.getAsString(this.get(S_Principal));
  
  }
  public String getPrincipalInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Principal));
      }

  public void initOtherChargeRequirement(String value){
     this.initProperty(S_OtherChargeRequirement,value);
  }
  public  void setOtherChargeRequirement(String value){
     this.set(S_OtherChargeRequirement,value);
  }
  public  void setOtherChargeRequirementNull(){
     this.set(S_OtherChargeRequirement,null);
  }

  public String getOtherChargeRequirement(){
       return DataType.getAsString(this.get(S_OtherChargeRequirement));
  
  }
  public String getOtherChargeRequirementInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OtherChargeRequirement));
      }

  public void initIsUserProcess(String value){
     this.initProperty(S_IsUserProcess,value);
  }
  public  void setIsUserProcess(String value){
     this.set(S_IsUserProcess,value);
  }
  public  void setIsUserProcessNull(){
     this.set(S_IsUserProcess,null);
  }

  public String getIsUserProcess(){
       return DataType.getAsString(this.get(S_IsUserProcess));
  
  }
  public String getIsUserProcessInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsUserProcess));
      }

  public void initTestPrincipal(String value){
     this.initProperty(S_TestPrincipal,value);
  }
  public  void setTestPrincipal(String value){
     this.set(S_TestPrincipal,value);
  }
  public  void setTestPrincipalNull(){
     this.set(S_TestPrincipal,null);
  }

  public String getTestPrincipal(){
       return DataType.getAsString(this.get(S_TestPrincipal));
  
  }
  public String getTestPrincipalInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TestPrincipal));
      }

  public void initExt5(int value){
     this.initProperty(S_Ext5,new Integer(value));
  }
  public  void setExt5(int value){
     this.set(S_Ext5,new Integer(value));
  }
  public  void setExt5Null(){
     this.set(S_Ext5,null);
  }

  public int getExt5(){
        return DataType.getAsInt(this.get(S_Ext5));
  
  }
  public int getExt5InitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Ext5));
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

  public void initExt7(double value){
     this.initProperty(S_Ext7,new Double(value));
  }
  public  void setExt7(double value){
     this.set(S_Ext7,new Double(value));
  }
  public  void setExt7Null(){
     this.set(S_Ext7,null);
  }

  public double getExt7(){
        return DataType.getAsDouble(this.get(S_Ext7));
  
  }
  public double getExt7InitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_Ext7));
      }

  public void initReportDetails(String value){
     this.initProperty(S_ReportDetails,value);
  }
  public  void setReportDetails(String value){
     this.set(S_ReportDetails,value);
  }
  public  void setReportDetailsNull(){
     this.set(S_ReportDetails,null);
  }

  public String getReportDetails(){
       return DataType.getAsString(this.get(S_ReportDetails));
  
  }
  public String getReportDetailsInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ReportDetails));
      }

  public void initDoneTime(Timestamp value){
     this.initProperty(S_DoneTime,value);
  }
  public  void setDoneTime(Timestamp value){
     this.set(S_DoneTime,value);
  }
  public  void setDoneTimeNull(){
     this.set(S_DoneTime,null);
  }

  public Timestamp getDoneTime(){
        return DataType.getAsDateTime(this.get(S_DoneTime));
  
  }
  public Timestamp getDoneTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_DoneTime));
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

  public void initChannelDescription(String value){
     this.initProperty(S_ChannelDescription,value);
  }
  public  void setChannelDescription(String value){
     this.set(S_ChannelDescription,value);
  }
  public  void setChannelDescriptionNull(){
     this.set(S_ChannelDescription,null);
  }

  public String getChannelDescription(){
       return DataType.getAsString(this.get(S_ChannelDescription));
  
  }
  public String getChannelDescriptionInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ChannelDescription));
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


 
 }

