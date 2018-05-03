package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceBatInputFieldFormatBean extends DataContainer implements DataContainerInterface,IBceBatInputFieldFormatValue{

  private static String  m_boName = "com.ai.bce.bo.BceBatInputFieldFormat";



  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_FieldName = "FIELD_NAME";
  public final static  String S_State = "STATE";
  public final static  String S_ListType = "LIST_TYPE";
  public final static  String S_Title = "TITLE";
  public final static  String S_ConfigId = "CONFIG_ID";
  public final static  String S_VerifySrvname = "VERIFY_SRVNAME";
  public final static  String S_SeqNo = "SEQ_NO";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceBatInputFieldFormatBean() throws AIException{
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

  public void initFieldName(String value){
     this.initProperty(S_FieldName,value);
  }
  public  void setFieldName(String value){
     this.set(S_FieldName,value);
  }
  public  void setFieldNameNull(){
     this.set(S_FieldName,null);
  }

  public String getFieldName(){
       return DataType.getAsString(this.get(S_FieldName));
  
  }
  public String getFieldNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FieldName));
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

  public void initListType(int value){
     this.initProperty(S_ListType,new Integer(value));
  }
  public  void setListType(int value){
     this.set(S_ListType,new Integer(value));
  }
  public  void setListTypeNull(){
     this.set(S_ListType,null);
  }

  public int getListType(){
        return DataType.getAsInt(this.get(S_ListType));
  
  }
  public int getListTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_ListType));
      }

  public void initTitle(String value){
     this.initProperty(S_Title,value);
  }
  public  void setTitle(String value){
     this.set(S_Title,value);
  }
  public  void setTitleNull(){
     this.set(S_Title,null);
  }

  public String getTitle(){
       return DataType.getAsString(this.get(S_Title));
  
  }
  public String getTitleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Title));
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

  public void initVerifySrvname(String value){
     this.initProperty(S_VerifySrvname,value);
  }
  public  void setVerifySrvname(String value){
     this.set(S_VerifySrvname,value);
  }
  public  void setVerifySrvnameNull(){
     this.set(S_VerifySrvname,null);
  }

  public String getVerifySrvname(){
       return DataType.getAsString(this.get(S_VerifySrvname));
  
  }
  public String getVerifySrvnameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_VerifySrvname));
      }

  public void initSeqNo(int value){
     this.initProperty(S_SeqNo,new Integer(value));
  }
  public  void setSeqNo(int value){
     this.set(S_SeqNo,new Integer(value));
  }
  public  void setSeqNoNull(){
     this.set(S_SeqNo,null);
  }

  public int getSeqNo(){
        return DataType.getAsInt(this.get(S_SeqNo));
  
  }
  public int getSeqNoInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_SeqNo));
      }


 
 }

