package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceViewObjectAttrBean extends DataContainer implements DataContainerInterface,IBceViewObjectAttrValue{

  private static String  m_boName = "com.ai.bce.bo.BceViewObjectAttr";



  public final static  String S_State = "STATE";
  public final static  String S_AttrId = "ATTR_ID";
  public final static  String S_AttrValue = "ATTR_VALUE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_ObjectId = "OBJECT_ID";
  public final static  String S_AttrParam = "ATTR_PARAM";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceViewObjectAttrBean() throws AIException{
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

  public void initAttrId(long value){
     this.initProperty(S_AttrId,new Long(value));
  }
  public  void setAttrId(long value){
     this.set(S_AttrId,new Long(value));
  }

  public  void setAttrId(Long value){
     this.set(S_AttrId,value);
  }
  
  public  Long  getAttrIdAsLong(){
     return (Long )this.get(S_AttrId);
  }
  
  
  public  void setAttrIdNull(){
     this.set(S_AttrId,null);
  }

  public long getAttrId(){
        return DataType.getAsLong(this.get(S_AttrId));
  
  }
  public long getAttrIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AttrId));
      }

  public void initAttrValue(String value){
     this.initProperty(S_AttrValue,value);
  }
  public  void setAttrValue(String value){
     this.set(S_AttrValue,value);
  }

  
  
  public  void setAttrValueNull(){
     this.set(S_AttrValue,null);
  }

  public String getAttrValue(){
       return DataType.getAsString(this.get(S_AttrValue));
  
  }
  public String getAttrValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AttrValue));
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

  public void initObjectId(long value){
     this.initProperty(S_ObjectId,new Long(value));
  }
  public  void setObjectId(long value){
     this.set(S_ObjectId,new Long(value));
  }

  public  void setObjectId(Long value){
     this.set(S_ObjectId,value);
  }
  
  public  Long  getObjectIdAsLong(){
     return (Long )this.get(S_ObjectId);
  }
  
  
  public  void setObjectIdNull(){
     this.set(S_ObjectId,null);
  }

  public long getObjectId(){
        return DataType.getAsLong(this.get(S_ObjectId));
  
  }
  public long getObjectIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ObjectId));
      }

  public void initAttrParam(String value){
     this.initProperty(S_AttrParam,value);
  }
  public  void setAttrParam(String value){
     this.set(S_AttrParam,value);
  }

  
  
  public  void setAttrParamNull(){
     this.set(S_AttrParam,null);
  }

  public String getAttrParam(){
       return DataType.getAsString(this.get(S_AttrParam));
  
  }
  public String getAttrParamInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AttrParam));
      }


 
 }

