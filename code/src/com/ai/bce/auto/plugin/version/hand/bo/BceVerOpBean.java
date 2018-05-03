package com.ai.bce.auto.plugin.version.hand.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.auto.plugin.version.hand.ivalues.*;

public class BceVerOpBean extends DataContainer implements DataContainerInterface,IBceVerOpValue{

  private static String  m_boName = "com.ai.bce.auto.plugin.version.hand.bo.BceVerOp";



  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_OpId = "OP_ID";
  public final static  String S_OpDate = "OP_DATE";
  public final static  String S_State = "STATE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_YearM = "YEAR_M";
  public final static  String S_OpUser = "OP_USER";
  public final static  String S_ServiceId = "SERVICE_ID";
  public final static  String S_SyncStatus = "SYNC_STATUS";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_OrdId = "ORD_ID";
  public final static  String S_SyncType = "SYNC_TYPE";
  public final static  String S_MethodName = "METHOD_NAME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceVerOpBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initModuleId(long value){
     this.initProperty(S_ModuleId,new Long(value));
  }
  public  void setModuleId(long value){
     this.set(S_ModuleId,new Long(value));
  }
  public  void setModuleIdNull(){
     this.set(S_ModuleId,null);
  }

  public long getModuleId(){
        return DataType.getAsLong(this.get(S_ModuleId));
  
  }
  public long getModuleIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ModuleId));
      }

  public void initOpId(long value){
     this.initProperty(S_OpId,new Long(value));
  }
  public  void setOpId(long value){
     this.set(S_OpId,new Long(value));
  }
  public  void setOpIdNull(){
     this.set(S_OpId,null);
  }

  public long getOpId(){
        return DataType.getAsLong(this.get(S_OpId));
  
  }
  public long getOpIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OpId));
      }

  public void initOpDate(Timestamp value){
     this.initProperty(S_OpDate,value);
  }
  public  void setOpDate(Timestamp value){
     this.set(S_OpDate,value);
  }
  public  void setOpDateNull(){
     this.set(S_OpDate,null);
  }

  public Timestamp getOpDate(){
        return DataType.getAsDateTime(this.get(S_OpDate));
  
  }
  public Timestamp getOpDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_OpDate));
      }

  public void initState(int value){
     this.initProperty(S_State,new Integer(value));
  }
  public  void setState(int value){
     this.set(S_State,new Integer(value));
  }
  public  void setStateNull(){
     this.set(S_State,null);
  }

  public int getState(){
        return DataType.getAsInt(this.get(S_State));
  
  }
  public int getStateInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_State));
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

  public void initYearM(String value){
     this.initProperty(S_YearM,value);
  }
  public  void setYearM(String value){
     this.set(S_YearM,value);
  }
  public  void setYearMNull(){
     this.set(S_YearM,null);
  }

  public String getYearM(){
       return DataType.getAsString(this.get(S_YearM));
  
  }
  public String getYearMInitialValue(){
        return DataType.getAsString(this.getOldObj(S_YearM));
      }

  public void initOpUser(long value){
     this.initProperty(S_OpUser,new Long(value));
  }
  public  void setOpUser(long value){
     this.set(S_OpUser,new Long(value));
  }
  public  void setOpUserNull(){
     this.set(S_OpUser,null);
  }

  public long getOpUser(){
        return DataType.getAsLong(this.get(S_OpUser));
  
  }
  public long getOpUserInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OpUser));
      }

  public void initServiceId(String value){
     this.initProperty(S_ServiceId,value);
  }
  public  void setServiceId(String value){
     this.set(S_ServiceId,value);
  }
  public  void setServiceIdNull(){
     this.set(S_ServiceId,null);
  }

  public String getServiceId(){
       return DataType.getAsString(this.get(S_ServiceId));
  
  }
  public String getServiceIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ServiceId));
      }

  public void initSyncStatus(int value){
     this.initProperty(S_SyncStatus,new Integer(value));
  }
  public  void setSyncStatus(int value){
     this.set(S_SyncStatus,new Integer(value));
  }
  public  void setSyncStatusNull(){
     this.set(S_SyncStatus,null);
  }

  public int getSyncStatus(){
        return DataType.getAsInt(this.get(S_SyncStatus));
  
  }
  public int getSyncStatusInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_SyncStatus));
      }

  public void initModifyDate(Timestamp value){
     this.initProperty(S_ModifyDate,value);
  }
  public  void setModifyDate(Timestamp value){
     this.set(S_ModifyDate,value);
  }
  public  void setModifyDateNull(){
     this.set(S_ModifyDate,null);
  }

  public Timestamp getModifyDate(){
        return DataType.getAsDateTime(this.get(S_ModifyDate));
  
  }
  public Timestamp getModifyDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ModifyDate));
      }

  public void initOrdId(long value){
     this.initProperty(S_OrdId,new Long(value));
  }
  public  void setOrdId(long value){
     this.set(S_OrdId,new Long(value));
  }
  public  void setOrdIdNull(){
     this.set(S_OrdId,null);
  }

  public long getOrdId(){
        return DataType.getAsLong(this.get(S_OrdId));
  
  }
  public long getOrdIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OrdId));
      }

  public void initSyncType(int value){
     this.initProperty(S_SyncType,new Integer(value));
  }
  public  void setSyncType(int value){
     this.set(S_SyncType,new Integer(value));
  }
  public  void setSyncTypeNull(){
     this.set(S_SyncType,null);
  }

  public int getSyncType(){
        return DataType.getAsInt(this.get(S_SyncType));
  
  }
  public int getSyncTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_SyncType));
      }

  public void initMethodName(String value){
     this.initProperty(S_MethodName,value);
  }
  public  void setMethodName(String value){
     this.set(S_MethodName,value);
  }
  public  void setMethodNameNull(){
     this.set(S_MethodName,null);
  }

  public String getMethodName(){
       return DataType.getAsString(this.get(S_MethodName));
  
  }
  public String getMethodNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MethodName));
      }


 
 }

