package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class QBOBcePageRelRowsetBean extends DataContainer implements DataContainerInterface,IQBOBcePageRelRowsetValue{

  private static String  m_boName = "com.ai.bce.bo.QBOBcePageRelRowset";



  public final static  String S_RowsetMethod = "ROWSET_METHOD";
  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_RowsetId = "ROWSET_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_RowsetKey = "ROWSET_KEY";
  public final static  String S_RowsetType = "ROWSET_TYPE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QBOBcePageRelRowsetBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("Cannot reset ObjectType");
 }


  public void initRowsetMethod(String value){
     this.initProperty(S_RowsetMethod,value);
  }
  public  void setRowsetMethod(String value){
     this.set(S_RowsetMethod,value);
  }

  
  
  public  void setRowsetMethodNull(){
     this.set(S_RowsetMethod,null);
  }

  public String getRowsetMethod(){
       return DataType.getAsString(this.get(S_RowsetMethod));
  
  }
  public String getRowsetMethodInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RowsetMethod));
      }

  public void initModuleId(long value){
     this.initProperty(S_ModuleId,new Long(value));
  }
  public  void setModuleId(long value){
     this.set(S_ModuleId,new Long(value));
  }

  public  void setModuleId(Long value){
     this.set(S_ModuleId,value);
  }
  
  public  Long  getModuleIdAsLong(){
     return (Long )this.get(S_ModuleId);
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

  public void initState(long value){
     this.initProperty(S_State,new Long(value));
  }
  public  void setState(long value){
     this.set(S_State,new Long(value));
  }

  public  void setState(Long value){
     this.set(S_State,value);
  }
  
  public  Long  getStateAsLong(){
     return (Long )this.get(S_State);
  }
  
  
  public  void setStateNull(){
     this.set(S_State,null);
  }

  public long getState(){
        return DataType.getAsLong(this.get(S_State));
  
  }
  public long getStateInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_State));
      }

  public void initRowsetId(long value){
     this.initProperty(S_RowsetId,new Long(value));
  }
  public  void setRowsetId(long value){
     this.set(S_RowsetId,new Long(value));
  }

  public  void setRowsetId(Long value){
     this.set(S_RowsetId,value);
  }
  
  public  Long  getRowsetIdAsLong(){
     return (Long )this.get(S_RowsetId);
  }
  
  
  public  void setRowsetIdNull(){
     this.set(S_RowsetId,null);
  }

  public long getRowsetId(){
        return DataType.getAsLong(this.get(S_RowsetId));
  
  }
  public long getRowsetIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RowsetId));
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

  public void initRowsetKey(String value){
     this.initProperty(S_RowsetKey,value);
  }
  public  void setRowsetKey(String value){
     this.set(S_RowsetKey,value);
  }

  
  
  public  void setRowsetKeyNull(){
     this.set(S_RowsetKey,null);
  }

  public String getRowsetKey(){
       return DataType.getAsString(this.get(S_RowsetKey));
  
  }
  public String getRowsetKeyInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RowsetKey));
      }

  public void initRowsetType(long value){
     this.initProperty(S_RowsetType,new Long(value));
  }
  public  void setRowsetType(long value){
     this.set(S_RowsetType,new Long(value));
  }

  public  void setRowsetType(Long value){
     this.set(S_RowsetType,value);
  }
  
  public  Long  getRowsetTypeAsLong(){
     return (Long )this.get(S_RowsetType);
  }
  
  
  public  void setRowsetTypeNull(){
     this.set(S_RowsetType,null);
  }

  public long getRowsetType(){
        return DataType.getAsLong(this.get(S_RowsetType));
  
  }
  public long getRowsetTypeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RowsetType));
      }


 
 }

