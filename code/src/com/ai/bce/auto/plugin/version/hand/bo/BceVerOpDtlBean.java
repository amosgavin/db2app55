package com.ai.bce.auto.plugin.version.hand.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.auto.plugin.version.hand.ivalues.*;

public class BceVerOpDtlBean extends DataContainer implements DataContainerInterface,IBceVerOpDtlValue{

  private static String  m_boName = "com.ai.bce.auto.plugin.version.hand.bo.BceVerOpDtl";



  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_OpId = "OP_ID";
  public final static  String S_State = "STATE";
  public final static  String S_ObjName = "OBJ_NAME";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_YearM = "YEAR_M";
  public final static  String S_TabName = "TAB_NAME";
  public final static  String S_OldValue = "OLD_VALUE";
  public final static  String S_KeyValue = "KEY_VALUE";
  public final static  String S_NewValue = "NEW_VALUE";
  public final static  String S_SyncStatus = "SYNC_STATUS";
  public final static  String S_DtlId = "DTL_ID";
  public final static  String S_Creater = "CREATER";
  public final static  String S_ModId = "MOD_ID";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_OperType = "OPER_TYPE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceVerOpDtlBean() throws AIException{
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

  public void initObjName(String value){
     this.initProperty(S_ObjName,value);
  }
  public  void setObjName(String value){
     this.set(S_ObjName,value);
  }
  public  void setObjNameNull(){
     this.set(S_ObjName,null);
  }

  public String getObjName(){
       return DataType.getAsString(this.get(S_ObjName));
  
  }
  public String getObjNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ObjName));
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

  public void initTabName(String value){
     this.initProperty(S_TabName,value);
  }
  public  void setTabName(String value){
     this.set(S_TabName,value);
  }
  public  void setTabNameNull(){
     this.set(S_TabName,null);
  }

  public String getTabName(){
       return DataType.getAsString(this.get(S_TabName));
  
  }
  public String getTabNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TabName));
      }

  public void initOldValue(String value){
     this.initProperty(S_OldValue,value);
  }
  public  void setOldValue(String value){
     this.set(S_OldValue,value);
  }
  public  void setOldValueNull(){
     this.set(S_OldValue,null);
  }

  public String getOldValue(){
       return DataType.getAsString(this.get(S_OldValue));
  
  }
  public String getOldValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OldValue));
      }

  public void initKeyValue(String value){
     this.initProperty(S_KeyValue,value);
  }
  public  void setKeyValue(String value){
     this.set(S_KeyValue,value);
  }
  public  void setKeyValueNull(){
     this.set(S_KeyValue,null);
  }

  public String getKeyValue(){
       return DataType.getAsString(this.get(S_KeyValue));
  
  }
  public String getKeyValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_KeyValue));
      }

  public void initNewValue(String value){
     this.initProperty(S_NewValue,value);
  }
  public  void setNewValue(String value){
     this.set(S_NewValue,value);
  }
  public  void setNewValueNull(){
     this.set(S_NewValue,null);
  }

  public String getNewValue(){
       return DataType.getAsString(this.get(S_NewValue));
  
  }
  public String getNewValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_NewValue));
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

  public void initDtlId(long value){
     this.initProperty(S_DtlId,new Long(value));
  }
  public  void setDtlId(long value){
     this.set(S_DtlId,new Long(value));
  }
  public  void setDtlIdNull(){
     this.set(S_DtlId,null);
  }

  public long getDtlId(){
        return DataType.getAsLong(this.get(S_DtlId));
  
  }
  public long getDtlIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_DtlId));
      }

  public void initCreater(long value){
     this.initProperty(S_Creater,new Long(value));
  }
  public  void setCreater(long value){
     this.set(S_Creater,new Long(value));
  }
  public  void setCreaterNull(){
     this.set(S_Creater,null);
  }

  public long getCreater(){
        return DataType.getAsLong(this.get(S_Creater));
  
  }
  public long getCreaterInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Creater));
      }

  public void initModId(int value){
     this.initProperty(S_ModId,new Integer(value));
  }
  public  void setModId(int value){
     this.set(S_ModId,new Integer(value));
  }
  public  void setModIdNull(){
     this.set(S_ModId,null);
  }

  public int getModId(){
        return DataType.getAsInt(this.get(S_ModId));
  
  }
  public int getModIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_ModId));
      }

  public void initCreateDate(Timestamp value){
     this.initProperty(S_CreateDate,value);
  }
  public  void setCreateDate(Timestamp value){
     this.set(S_CreateDate,value);
  }
  public  void setCreateDateNull(){
     this.set(S_CreateDate,null);
  }

  public Timestamp getCreateDate(){
        return DataType.getAsDateTime(this.get(S_CreateDate));
  
  }
  public Timestamp getCreateDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CreateDate));
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


 
 }

