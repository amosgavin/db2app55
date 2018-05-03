package com.ai.bce.auto.plugin.version.hand.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.auto.plugin.version.hand.ivalues.*;

public class BceVerSyncScriptBean extends DataContainer implements DataContainerInterface,IBceVerSyncScriptValue{

  private static String  m_boName = "com.ai.bce.auto.plugin.version.hand.bo.BceVerSyncScript";



  public final static  String S_State = "STATE";
  public final static  String S_Sort = "SORT";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_SyncScript = "SYNC_SCRIPT";
  public final static  String S_OrdId = "ORD_ID";
  public final static  String S_RollbackScript = "ROLLBACK_SCRIPT";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceVerSyncScriptBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //Cannot reset ObjectType
   throw new AIException("Cannot reset ObjectType");
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

  public void initSort(String value){
     this.initProperty(S_Sort,value);
  }
  public  void setSort(String value){
     this.set(S_Sort,value);
  }
  public  void setSortNull(){
     this.set(S_Sort,null);
  }

  public String getSort(){
       return DataType.getAsString(this.get(S_Sort));
  
  }
  public String getSortInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Sort));
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

  public void initSyncScript(String value){
     this.initProperty(S_SyncScript,value);
  }
  public  void setSyncScript(String value){
     this.set(S_SyncScript,value);
  }
  public  void setSyncScriptNull(){
     this.set(S_SyncScript,null);
  }

  public String getSyncScript(){
       return DataType.getAsString(this.get(S_SyncScript));
  
  }
  public String getSyncScriptInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SyncScript));
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

  public void initRollbackScript(String value){
     this.initProperty(S_RollbackScript,value);
  }
  public  void setRollbackScript(String value){
     this.set(S_RollbackScript,value);
  }
  public  void setRollbackScriptNull(){
     this.set(S_RollbackScript,null);
  }

  public String getRollbackScript(){
       return DataType.getAsString(this.get(S_RollbackScript));
  
  }
  public String getRollbackScriptInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RollbackScript));
      }


 
 }

