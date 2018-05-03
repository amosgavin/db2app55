package com.ai.bce.auto.plugin.version.hand.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.auto.plugin.version.hand.ivalues.*;

public class BceVerDtlParamsBean extends DataContainer implements DataContainerInterface,IBceVerDtlParamsValue{

  private static String  m_boName = "com.ai.bce.auto.plugin.version.hand.bo.BceVerDtlParams";



  public final static  String S_DtlParamId = "DTL_PARAM_ID";
  public final static  String S_DtlId = "DTL_ID";
  public final static  String S_State = "STATE";
  public final static  String S_ValueType = "VALUE_TYPE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_ColumnName = "COLUMN_NAME";
  public final static  String S_OldValue = "OLD_VALUE";
  public final static  String S_NewValue = "NEW_VALUE";
  public final static  String S_IsPk = "IS_PK";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceVerDtlParamsBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //Cannot reset ObjectType
   throw new AIException("Cannot reset ObjectType");
 }


  public void initDtlParamId(long value){
     this.initProperty(S_DtlParamId,new Long(value));
  }
  public  void setDtlParamId(long value){
     this.set(S_DtlParamId,new Long(value));
  }
  public  void setDtlParamIdNull(){
     this.set(S_DtlParamId,null);
  }

  public long getDtlParamId(){
        return DataType.getAsLong(this.get(S_DtlParamId));
  
  }
  public long getDtlParamIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_DtlParamId));
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

  public void initValueType(String value){
     this.initProperty(S_ValueType,value);
  }
  public  void setValueType(String value){
     this.set(S_ValueType,value);
  }
  public  void setValueTypeNull(){
     this.set(S_ValueType,null);
  }

  public String getValueType(){
       return DataType.getAsString(this.get(S_ValueType));
  
  }
  public String getValueTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ValueType));
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

  public void initColumnName(String value){
     this.initProperty(S_ColumnName,value);
  }
  public  void setColumnName(String value){
     this.set(S_ColumnName,value);
  }
  public  void setColumnNameNull(){
     this.set(S_ColumnName,null);
  }

  public String getColumnName(){
       return DataType.getAsString(this.get(S_ColumnName));
  
  }
  public String getColumnNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ColumnName));
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

  public void initIsPk(int value){
     this.initProperty(S_IsPk,new Integer(value));
  }
  public  void setIsPk(int value){
     this.set(S_IsPk,new Integer(value));
  }
  public  void setIsPkNull(){
     this.set(S_IsPk,null);
  }

  public int getIsPk(){
        return DataType.getAsInt(this.get(S_IsPk));
  
  }
  public int getIsPkInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_IsPk));
      }


 
 }

