package com.asiainfo.sale.access.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.access.ivalues.*;

public class BOSelectSaleOrChargeBean extends DataContainer implements DataContainerInterface,IBOSelectSaleOrChargeValue{

  private static String  m_boName = "com.asiainfo.sale.access.bo.BOSelectSaleOrCharge";



  public final static  String S_BossBatchCode = "BOSS_BATCH_CODE";
  public final static  String S_BatchType = "BATCH_TYPE";
  public final static  String S_BossLevCode = "BOSS_LEV_CODE";
  public final static  String S_BatchName = "BATCH_NAME";
  public final static  String S_OrgName = "ORG_NAME";
  public final static  String S_OrgId = "ORG_ID";
  public final static  String S_SysLevCode = "SYS_LEV_CODE";
  public final static  String S_SysBatchCode = "SYS_BATCH_CODE";
  public final static  String S_BeginTime = "BEGIN_TIME";
  public final static  String S_BatchId = "BATCH_ID";
  public final static  String S_LevelId = "LEVEL_ID";
  public final static  String S_StaffName = "STAFF_NAME";
  public final static  String S_EndTime = "END_TIME";
  public final static  String S_LevelName = "LEVEL_NAME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOSelectSaleOrChargeBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initBossBatchCode(String value){
     this.initProperty(S_BossBatchCode,value);
  }
  public  void setBossBatchCode(String value){
     this.set(S_BossBatchCode,value);
  }
  public  void setBossBatchCodeNull(){
     this.set(S_BossBatchCode,null);
  }

  public String getBossBatchCode(){
       return DataType.getAsString(this.get(S_BossBatchCode));
  
  }
  public String getBossBatchCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BossBatchCode));
      }

  public void initBatchType(String value){
     this.initProperty(S_BatchType,value);
  }
  public  void setBatchType(String value){
     this.set(S_BatchType,value);
  }
  public  void setBatchTypeNull(){
     this.set(S_BatchType,null);
  }

  public String getBatchType(){
       return DataType.getAsString(this.get(S_BatchType));
  
  }
  public String getBatchTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BatchType));
      }

  public void initBossLevCode(String value){
     this.initProperty(S_BossLevCode,value);
  }
  public  void setBossLevCode(String value){
     this.set(S_BossLevCode,value);
  }
  public  void setBossLevCodeNull(){
     this.set(S_BossLevCode,null);
  }

  public String getBossLevCode(){
       return DataType.getAsString(this.get(S_BossLevCode));
  
  }
  public String getBossLevCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BossLevCode));
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

  public void initOrgName(String value){
     this.initProperty(S_OrgName,value);
  }
  public  void setOrgName(String value){
     this.set(S_OrgName,value);
  }
  public  void setOrgNameNull(){
     this.set(S_OrgName,null);
  }

  public String getOrgName(){
       return DataType.getAsString(this.get(S_OrgName));
  
  }
  public String getOrgNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrgName));
      }

  public void initOrgId(String value){
     this.initProperty(S_OrgId,value);
  }
  public  void setOrgId(String value){
     this.set(S_OrgId,value);
  }
  public  void setOrgIdNull(){
     this.set(S_OrgId,null);
  }

  public String getOrgId(){
       return DataType.getAsString(this.get(S_OrgId));
  
  }
  public String getOrgIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrgId));
      }

  public void initSysLevCode(String value){
     this.initProperty(S_SysLevCode,value);
  }
  public  void setSysLevCode(String value){
     this.set(S_SysLevCode,value);
  }
  public  void setSysLevCodeNull(){
     this.set(S_SysLevCode,null);
  }

  public String getSysLevCode(){
       return DataType.getAsString(this.get(S_SysLevCode));
  
  }
  public String getSysLevCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SysLevCode));
      }

  public void initSysBatchCode(String value){
     this.initProperty(S_SysBatchCode,value);
  }
  public  void setSysBatchCode(String value){
     this.set(S_SysBatchCode,value);
  }
  public  void setSysBatchCodeNull(){
     this.set(S_SysBatchCode,null);
  }

  public String getSysBatchCode(){
       return DataType.getAsString(this.get(S_SysBatchCode));
  
  }
  public String getSysBatchCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SysBatchCode));
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

  public void initStaffName(String value){
     this.initProperty(S_StaffName,value);
  }
  public  void setStaffName(String value){
     this.set(S_StaffName,value);
  }
  public  void setStaffNameNull(){
     this.set(S_StaffName,null);
  }

  public String getStaffName(){
       return DataType.getAsString(this.get(S_StaffName));
  
  }
  public String getStaffNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_StaffName));
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

