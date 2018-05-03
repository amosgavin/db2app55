package com.asiainfo.sale.prestore.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.prestore.ivalues.*;

public class BOSaleBatchPrestoreHisBean extends DataContainer implements DataContainerInterface,IBOSaleBatchPrestoreHisValue{

  private static String  m_boName = "com.asiainfo.sale.prestore.bo.BOSaleBatchPrestoreHis";



  public final static  String S_UserNumber = "USER_NUMBER";
  public final static  String S_ProvideEndDate = "PROVIDE_END_DATE";
  public final static  String S_Ext3 = "EXT3";
  public final static  String S_PromoteDepart = "PROMOTE_DEPART";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_SmsSendType = "SMS_SEND_TYPE";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_ModifyTime = "MODIFY_TIME";
  public final static  String S_Ext5 = "EXT5";
  public final static  String S_FundReason = "FUND_REASON";
  public final static  String S_ApplyAmount = "APPLY_AMOUNT";
  public final static  String S_BusiType = "BUSI_TYPE";
  public final static  String S_IsSubmit = "IS_SUBMIT";
  public final static  String S_FundRange = "FUND_RANGE";
  public final static  String S_OperatorId = "OPERATOR_ID";
  public final static  String S_DoneTime = "DONE_TIME";
  public final static  String S_Ext4 = "EXT4";
  public final static  String S_BusinessReview = "BUSINESS_REVIEW";
  public final static  String S_SendRange = "SEND_RANGE";
  public final static  String S_SmsContent = "SMS_CONTENT";
  public final static  String S_AreaCode = "AREA_CODE";
  public final static  String S_OperType = "OPER_TYPE";
  public final static  String S_BossDoneCode = "BOSS_DONE_CODE";
  public final static  String S_ApplyName = "APPLY_NAME";
  public final static  String S_FileName = "FILE_NAME";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_ProvideBeginDate = "PROVIDE_BEGIN_DATE";
  public final static  String S_PromoteManager = "PROMOTE_MANAGER";
  public final static  String S_Principal = "PRINCIPAL";
  public final static  String S_Id = "ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOSaleBatchPrestoreHisBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initUserNumber(String value){
     this.initProperty(S_UserNumber,value);
  }
  public  void setUserNumber(String value){
     this.set(S_UserNumber,value);
  }
  public  void setUserNumberNull(){
     this.set(S_UserNumber,null);
  }

  public String getUserNumber(){
       return DataType.getAsString(this.get(S_UserNumber));
  
  }
  public String getUserNumberInitialValue(){
        return DataType.getAsString(this.getOldObj(S_UserNumber));
      }

  public void initProvideEndDate(Timestamp value){
     this.initProperty(S_ProvideEndDate,value);
  }
  public  void setProvideEndDate(Timestamp value){
     this.set(S_ProvideEndDate,value);
  }
  public  void setProvideEndDateNull(){
     this.set(S_ProvideEndDate,null);
  }

  public Timestamp getProvideEndDate(){
        return DataType.getAsDateTime(this.get(S_ProvideEndDate));
  
  }
  public Timestamp getProvideEndDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ProvideEndDate));
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

  public void initSmsSendType(String value){
     this.initProperty(S_SmsSendType,value);
  }
  public  void setSmsSendType(String value){
     this.set(S_SmsSendType,value);
  }
  public  void setSmsSendTypeNull(){
     this.set(S_SmsSendType,null);
  }

  public String getSmsSendType(){
       return DataType.getAsString(this.get(S_SmsSendType));
  
  }
  public String getSmsSendTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SmsSendType));
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

  public void initFundReason(String value){
     this.initProperty(S_FundReason,value);
  }
  public  void setFundReason(String value){
     this.set(S_FundReason,value);
  }
  public  void setFundReasonNull(){
     this.set(S_FundReason,null);
  }

  public String getFundReason(){
       return DataType.getAsString(this.get(S_FundReason));
  
  }
  public String getFundReasonInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FundReason));
      }

  public void initApplyAmount(double value){
     this.initProperty(S_ApplyAmount,new Double(value));
  }
  public  void setApplyAmount(double value){
     this.set(S_ApplyAmount,new Double(value));
  }
  public  void setApplyAmountNull(){
     this.set(S_ApplyAmount,null);
  }

  public double getApplyAmount(){
        return DataType.getAsDouble(this.get(S_ApplyAmount));
  
  }
  public double getApplyAmountInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_ApplyAmount));
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

  public void initIsSubmit(String value){
     this.initProperty(S_IsSubmit,value);
  }
  public  void setIsSubmit(String value){
     this.set(S_IsSubmit,value);
  }
  public  void setIsSubmitNull(){
     this.set(S_IsSubmit,null);
  }

  public String getIsSubmit(){
       return DataType.getAsString(this.get(S_IsSubmit));
  
  }
  public String getIsSubmitInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsSubmit));
      }

  public void initFundRange(String value){
     this.initProperty(S_FundRange,value);
  }
  public  void setFundRange(String value){
     this.set(S_FundRange,value);
  }
  public  void setFundRangeNull(){
     this.set(S_FundRange,null);
  }

  public String getFundRange(){
       return DataType.getAsString(this.get(S_FundRange));
  
  }
  public String getFundRangeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FundRange));
      }

  public void initOperatorId(String value){
     this.initProperty(S_OperatorId,value);
  }
  public  void setOperatorId(String value){
     this.set(S_OperatorId,value);
  }
  public  void setOperatorIdNull(){
     this.set(S_OperatorId,null);
  }

  public String getOperatorId(){
       return DataType.getAsString(this.get(S_OperatorId));
  
  }
  public String getOperatorIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OperatorId));
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

  public void initBusinessReview(String value){
     this.initProperty(S_BusinessReview,value);
  }
  public  void setBusinessReview(String value){
     this.set(S_BusinessReview,value);
  }
  public  void setBusinessReviewNull(){
     this.set(S_BusinessReview,null);
  }

  public String getBusinessReview(){
       return DataType.getAsString(this.get(S_BusinessReview));
  
  }
  public String getBusinessReviewInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BusinessReview));
      }

  public void initSendRange(String value){
     this.initProperty(S_SendRange,value);
  }
  public  void setSendRange(String value){
     this.set(S_SendRange,value);
  }
  public  void setSendRangeNull(){
     this.set(S_SendRange,null);
  }

  public String getSendRange(){
       return DataType.getAsString(this.get(S_SendRange));
  
  }
  public String getSendRangeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SendRange));
      }

  public void initSmsContent(String value){
     this.initProperty(S_SmsContent,value);
  }
  public  void setSmsContent(String value){
     this.set(S_SmsContent,value);
  }
  public  void setSmsContentNull(){
     this.set(S_SmsContent,null);
  }

  public String getSmsContent(){
       return DataType.getAsString(this.get(S_SmsContent));
  
  }
  public String getSmsContentInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SmsContent));
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

  public void initBossDoneCode(String value){
     this.initProperty(S_BossDoneCode,value);
  }
  public  void setBossDoneCode(String value){
     this.set(S_BossDoneCode,value);
  }
  public  void setBossDoneCodeNull(){
     this.set(S_BossDoneCode,null);
  }

  public String getBossDoneCode(){
       return DataType.getAsString(this.get(S_BossDoneCode));
  
  }
  public String getBossDoneCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BossDoneCode));
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

  public void initFileName(String value){
     this.initProperty(S_FileName,value);
  }
  public  void setFileName(String value){
     this.set(S_FileName,value);
  }
  public  void setFileNameNull(){
     this.set(S_FileName,null);
  }

  public String getFileName(){
       return DataType.getAsString(this.get(S_FileName));
  
  }
  public String getFileNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FileName));
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

  public void initProvideBeginDate(Timestamp value){
     this.initProperty(S_ProvideBeginDate,value);
  }
  public  void setProvideBeginDate(Timestamp value){
     this.set(S_ProvideBeginDate,value);
  }
  public  void setProvideBeginDateNull(){
     this.set(S_ProvideBeginDate,null);
  }

  public Timestamp getProvideBeginDate(){
        return DataType.getAsDateTime(this.get(S_ProvideBeginDate));
  
  }
  public Timestamp getProvideBeginDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ProvideBeginDate));
      }

  public void initPromoteManager(String value){
     this.initProperty(S_PromoteManager,value);
  }
  public  void setPromoteManager(String value){
     this.set(S_PromoteManager,value);
  }
  public  void setPromoteManagerNull(){
     this.set(S_PromoteManager,null);
  }

  public String getPromoteManager(){
       return DataType.getAsString(this.get(S_PromoteManager));
  
  }
  public String getPromoteManagerInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PromoteManager));
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


 
 }

