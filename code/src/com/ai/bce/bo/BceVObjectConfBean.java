package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceVObjectConfBean extends DataContainer implements DataContainerInterface,IBceVObjectConfValue{

  private static String  m_boName = "com.ai.bce.bo.BceVObjectConf";



  public final static  String S_State = "STATE";
  public final static  String S_ImplClass = "IMPL_CLASS";
  public final static  String S_ObjTypeId = "OBJ_TYPE_ID";
  public final static  String S_TypeDesc = "TYPE_DESC";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_IsSelfDefine = "IS_SELF_DEFINE";
  public final static  String S_TypeTagValue = "TYPE_TAG_VALUE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceVObjectConfBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("Cannot reset ObjectType");
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

  public void initImplClass(String value){
     this.initProperty(S_ImplClass,value);
  }
  public  void setImplClass(String value){
     this.set(S_ImplClass,value);
  }

  
  
  public  void setImplClassNull(){
     this.set(S_ImplClass,null);
  }

  public String getImplClass(){
       return DataType.getAsString(this.get(S_ImplClass));
  
  }
  public String getImplClassInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ImplClass));
      }

  public void initObjTypeId(String value){
     this.initProperty(S_ObjTypeId,value);
  }
  public  void setObjTypeId(String value){
     this.set(S_ObjTypeId,value);
  }

  
  
  public  void setObjTypeIdNull(){
     this.set(S_ObjTypeId,null);
  }

  public String getObjTypeId(){
       return DataType.getAsString(this.get(S_ObjTypeId));
  
  }
  public String getObjTypeIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ObjTypeId));
      }

  public void initTypeDesc(String value){
     this.initProperty(S_TypeDesc,value);
  }
  public  void setTypeDesc(String value){
     this.set(S_TypeDesc,value);
  }

  
  
  public  void setTypeDescNull(){
     this.set(S_TypeDesc,null);
  }

  public String getTypeDesc(){
       return DataType.getAsString(this.get(S_TypeDesc));
  
  }
  public String getTypeDescInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TypeDesc));
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

  public void initIsSelfDefine(int value){
     this.initProperty(S_IsSelfDefine,new Integer(value));
  }
  public  void setIsSelfDefine(int value){
     this.set(S_IsSelfDefine,new Integer(value));
  }

  public  void setIsSelfDefine(Integer value){
     this.set(S_IsSelfDefine,value);
  }
  
  public  Integer  getIsSelfDefineAsInteger(){
     return (Integer )this.get(S_IsSelfDefine);
  }
  
  
  public  void setIsSelfDefineNull(){
     this.set(S_IsSelfDefine,null);
  }

  public int getIsSelfDefine(){
        return DataType.getAsInt(this.get(S_IsSelfDefine));
  
  }
  public int getIsSelfDefineInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_IsSelfDefine));
      }

  public void initTypeTagValue(String value){
     this.initProperty(S_TypeTagValue,value);
  }
  public  void setTypeTagValue(String value){
     this.set(S_TypeTagValue,value);
  }

  
  
  public  void setTypeTagValueNull(){
     this.set(S_TypeTagValue,null);
  }

  public String getTypeTagValue(){
       return DataType.getAsString(this.get(S_TypeTagValue));
  
  }
  public String getTypeTagValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TypeTagValue));
      }


 
 }

