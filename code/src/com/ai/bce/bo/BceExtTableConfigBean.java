package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceExtTableConfigBean extends DataContainer implements DataContainerInterface,IBceExtTableConfigValue{

  private static String  m_boName = "com.ai.bce.bo.BceExtTableConfig";



  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_ExtTableName = "EXT_TABLE_NAME";
  public final static  String S_ConfigId = "CONFIG_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_RelColName = "REL_COL_NAME";
  public final static  String S_RelType = "REL_TYPE";
  public final static  String S_BoName = "BO_NAME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceExtTableConfigBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //Cannot reset ObjectType
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

  public void initExtTableName(String value){
     this.initProperty(S_ExtTableName,value);
  }
  public  void setExtTableName(String value){
     this.set(S_ExtTableName,value);
  }
  public  void setExtTableNameNull(){
     this.set(S_ExtTableName,null);
  }

  public String getExtTableName(){
       return DataType.getAsString(this.get(S_ExtTableName));
  
  }
  public String getExtTableNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ExtTableName));
      }

  public void initConfigId(long value){
     this.initProperty(S_ConfigId,new Long(value));
  }
  public  void setConfigId(long value){
     this.set(S_ConfigId,new Long(value));
  }
  public  void setConfigIdNull(){
     this.set(S_ConfigId,null);
  }

  public long getConfigId(){
        return DataType.getAsLong(this.get(S_ConfigId));
  
  }
  public long getConfigIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ConfigId));
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

  public void initRelColName(String value){
     this.initProperty(S_RelColName,value);
  }
  public  void setRelColName(String value){
     this.set(S_RelColName,value);
  }
  public  void setRelColNameNull(){
     this.set(S_RelColName,null);
  }

  public String getRelColName(){
       return DataType.getAsString(this.get(S_RelColName));
  
  }
  public String getRelColNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RelColName));
      }

  public void initRelType(String value){
     this.initProperty(S_RelType,value);
  }
  public  void setRelType(String value){
     this.set(S_RelType,value);
  }
  public  void setRelTypeNull(){
     this.set(S_RelType,null);
  }

  public String getRelType(){
       return DataType.getAsString(this.get(S_RelType));
  
  }
  public String getRelTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RelType));
      }

  public void initBoName(String value){
     this.initProperty(S_BoName,value);
  }
  public  void setBoName(String value){
     this.set(S_BoName,value);
  }
  public  void setBoNameNull(){
     this.set(S_BoName,null);
  }

  public String getBoName(){
       return DataType.getAsString(this.get(S_BoName));
  
  }
  public String getBoNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BoName));
      }


 
 }

