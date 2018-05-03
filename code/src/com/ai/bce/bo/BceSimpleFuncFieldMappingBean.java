package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceSimpleFuncFieldMappingBean extends DataContainer implements DataContainerInterface,IBceSimpleFuncFieldMappingValue{

  private static String  m_boName = "com.ai.bce.bo.BceSimpleFuncFieldMapping";



  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_FuncId = "FUNC_ID";
  public final static  String S_FieldId = "FIELD_ID";
  public final static  String S_FieldCode = "FIELD_CODE";
  public final static  String S_InsField = "INS_FIELD";
  public final static  String S_OrdField = "ORD_FIELD";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceSimpleFuncFieldMappingBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("Cannot reset ObjectType");
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

  public void initState(int value){
     this.initProperty(S_State,new Integer(value));
  }
  public  void setState(int value){
     this.set(S_State,new Integer(value));
  }

  public  void setState(Integer value){
     this.set(S_State,value);
  }
  
  public  Integer  getStateAsInteger(){
     return (Integer )this.get(S_State);
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

  public void initFuncId(long value){
     this.initProperty(S_FuncId,new Long(value));
  }
  public  void setFuncId(long value){
     this.set(S_FuncId,new Long(value));
  }

  public  void setFuncId(Long value){
     this.set(S_FuncId,value);
  }
  
  public  Long  getFuncIdAsLong(){
     return (Long )this.get(S_FuncId);
  }
  
  
  public  void setFuncIdNull(){
     this.set(S_FuncId,null);
  }

  public long getFuncId(){
        return DataType.getAsLong(this.get(S_FuncId));
  
  }
  public long getFuncIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_FuncId));
      }

  public void initFieldId(long value){
     this.initProperty(S_FieldId,new Long(value));
  }
  public  void setFieldId(long value){
     this.set(S_FieldId,new Long(value));
  }

  public  void setFieldId(Long value){
     this.set(S_FieldId,value);
  }
  
  public  Long  getFieldIdAsLong(){
     return (Long )this.get(S_FieldId);
  }
  
  
  public  void setFieldIdNull(){
     this.set(S_FieldId,null);
  }

  public long getFieldId(){
        return DataType.getAsLong(this.get(S_FieldId));
  
  }
  public long getFieldIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_FieldId));
      }

  public void initFieldCode(String value){
     this.initProperty(S_FieldCode,value);
  }
  public  void setFieldCode(String value){
     this.set(S_FieldCode,value);
  }

  
  
  public  void setFieldCodeNull(){
     this.set(S_FieldCode,null);
  }

  public String getFieldCode(){
       return DataType.getAsString(this.get(S_FieldCode));
  
  }
  public String getFieldCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FieldCode));
      }

  public void initInsField(String value){
     this.initProperty(S_InsField,value);
  }
  public  void setInsField(String value){
     this.set(S_InsField,value);
  }

  
  
  public  void setInsFieldNull(){
     this.set(S_InsField,null);
  }

  public String getInsField(){
       return DataType.getAsString(this.get(S_InsField));
  
  }
  public String getInsFieldInitialValue(){
        return DataType.getAsString(this.getOldObj(S_InsField));
      }

  public void initOrdField(String value){
     this.initProperty(S_OrdField,value);
  }
  public  void setOrdField(String value){
     this.set(S_OrdField,value);
  }

  
  
  public  void setOrdFieldNull(){
     this.set(S_OrdField,null);
  }

  public String getOrdField(){
       return DataType.getAsString(this.get(S_OrdField));
  
  }
  public String getOrdFieldInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrdField));
      }


 
 }

