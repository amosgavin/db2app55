package com.asiainfo.sale.activity.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.activity.ivalues.*;

public class BOOrderShowBean extends DataContainer implements DataContainerInterface,IBOOrderShowValue{

  private static String  m_boName = "com.asiainfo.sale.activity.bo.BOOrderShow";



  public final static  String S_Marktype = "MARKTYPE";
  public final static  String S_PrestroreReachAccount = "PRESTRORE_REACH_ACCOUNT";
  public final static  String S_BatchName = "BATCH_NAME";
  public final static  String S_PresentTick = "PRESENT_TICK";
  public final static  String S_Exearea = "EXEAREA";
  public final static  String S_SaleActiveCode = "SALE_ACTIVE_CODE";
  public final static  String S_DigType = "DIG_TYPE";
  public final static  String S_LevelDesc = "LEVEL_DESC";
  public final static  String S_PresentReachAmount = "PRESENT_REACH_AMOUNT";
  public final static  String S_PrestoreFee = "PRESTORE_FEE";
  public final static  String S_Base = "BASE";
  public final static  String S_BeginTime = "BEGIN_TIME";
  public final static  String S_LevelCode = "LEVEL_CODE";
  public final static  String S_BatchId = "BATCH_ID";
  public final static  String S_SaleFlag = "SALE_FLAG";
  public final static  String S_SaleMainCode = "SALE_MAIN_CODE";
  public final static  String S_LevelId = "LEVEL_ID";
  public final static  String S_EndTime = "END_TIME";
  public final static  String S_GoodsNames = "GOODS_NAMES";
  public final static  String S_ReferencePrice = "REFERENCE_PRICE";
  public final static  String S_PresentFee = "PRESENT_FEE";
  public final static  String S_GlobalScore = "GLOBAL_SCORE";
  public final static  String S_LevelName = "LEVEL_NAME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOOrderShowBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initMarktype(String value){
     this.initProperty(S_Marktype,value);
  }
  public  void setMarktype(String value){
     this.set(S_Marktype,value);
  }
  public  void setMarktypeNull(){
     this.set(S_Marktype,null);
  }

  public String getMarktype(){
       return DataType.getAsString(this.get(S_Marktype));
  
  }
  public String getMarktypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Marktype));
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

  public void initBatchName(String value){
     this.initProperty(S_BatchName,value);
  }
  public  void setBatchName(String value){
     this.set(S_BatchName,value);
  }
  public  void setBatchNameNull(){
     this.set(S_BatchName,null);
  }

  public String getBatchName(){
       return DataType.getAsString(this.get(S_BatchName));
  
  }
  public String getBatchNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BatchName));
      }

  public void initPresentTick(String value){
     this.initProperty(S_PresentTick,value);
  }
  public  void setPresentTick(String value){
     this.set(S_PresentTick,value);
  }
  public  void setPresentTickNull(){
     this.set(S_PresentTick,null);
  }

  public String getPresentTick(){
       return DataType.getAsString(this.get(S_PresentTick));
  
  }
  public String getPresentTickInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PresentTick));
      }

  public void initExearea(String value){
     this.initProperty(S_Exearea,value);
  }
  public  void setExearea(String value){
     this.set(S_Exearea,value);
  }
  public  void setExeareaNull(){
     this.set(S_Exearea,null);
  }

  public String getExearea(){
       return DataType.getAsString(this.get(S_Exearea));
  
  }
  public String getExeareaInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Exearea));
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

  public void initDigType(String value){
     this.initProperty(S_DigType,value);
  }
  public  void setDigType(String value){
     this.set(S_DigType,value);
  }
  public  void setDigTypeNull(){
     this.set(S_DigType,null);
  }

  public String getDigType(){
       return DataType.getAsString(this.get(S_DigType));
  
  }
  public String getDigTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DigType));
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

  public void initPrestoreFee(String value){
     this.initProperty(S_PrestoreFee,value);
  }
  public  void setPrestoreFee(String value){
     this.set(S_PrestoreFee,value);
  }
  public  void setPrestoreFeeNull(){
     this.set(S_PrestoreFee,null);
  }

  public String getPrestoreFee(){
       return DataType.getAsString(this.get(S_PrestoreFee));
  
  }
  public String getPrestoreFeeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PrestoreFee));
      }

  public void initBase(String value){
     this.initProperty(S_Base,value);
  }
  public  void setBase(String value){
     this.set(S_Base,value);
  }
  public  void setBaseNull(){
     this.set(S_Base,null);
  }

  public String getBase(){
       return DataType.getAsString(this.get(S_Base));
  
  }
  public String getBaseInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Base));
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

  public void initBatchId(String value){
     this.initProperty(S_BatchId,value);
  }
  public  void setBatchId(String value){
     this.set(S_BatchId,value);
  }
  public  void setBatchIdNull(){
     this.set(S_BatchId,null);
  }

  public String getBatchId(){
       return DataType.getAsString(this.get(S_BatchId));
  
  }
  public String getBatchIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BatchId));
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

  public void initSaleMainCode(String value){
     this.initProperty(S_SaleMainCode,value);
  }
  public  void setSaleMainCode(String value){
     this.set(S_SaleMainCode,value);
  }
  public  void setSaleMainCodeNull(){
     this.set(S_SaleMainCode,null);
  }

  public String getSaleMainCode(){
       return DataType.getAsString(this.get(S_SaleMainCode));
  
  }
  public String getSaleMainCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleMainCode));
      }

  public void initLevelId(String value){
     this.initProperty(S_LevelId,value);
  }
  public  void setLevelId(String value){
     this.set(S_LevelId,value);
  }
  public  void setLevelIdNull(){
     this.set(S_LevelId,null);
  }

  public String getLevelId(){
       return DataType.getAsString(this.get(S_LevelId));
  
  }
  public String getLevelIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_LevelId));
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

  public void initGoodsNames(String value){
     this.initProperty(S_GoodsNames,value);
  }
  public  void setGoodsNames(String value){
     this.set(S_GoodsNames,value);
  }
  public  void setGoodsNamesNull(){
     this.set(S_GoodsNames,null);
  }

  public String getGoodsNames(){
       return DataType.getAsString(this.get(S_GoodsNames));
  
  }
  public String getGoodsNamesInitialValue(){
        return DataType.getAsString(this.getOldObj(S_GoodsNames));
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

  public void initPresentFee(String value){
     this.initProperty(S_PresentFee,value);
  }
  public  void setPresentFee(String value){
     this.set(S_PresentFee,value);
  }
  public  void setPresentFeeNull(){
     this.set(S_PresentFee,null);
  }

  public String getPresentFee(){
       return DataType.getAsString(this.get(S_PresentFee));
  
  }
  public String getPresentFeeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PresentFee));
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

  public void initLevelName(String value){
     this.initProperty(S_LevelName,value);
  }
  public  void setLevelName(String value){
     this.set(S_LevelName,value);
  }
  public  void setLevelNameNull(){
     this.set(S_LevelName,null);
  }

  public String getLevelName(){
       return DataType.getAsString(this.get(S_LevelName));
  
  }
  public String getLevelNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_LevelName));
      }


 
 }

