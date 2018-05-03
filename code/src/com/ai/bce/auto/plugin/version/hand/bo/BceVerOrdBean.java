package com.ai.bce.auto.plugin.version.hand.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.auto.plugin.version.hand.ivalues.*;

public class BceVerOrdBean extends DataContainer implements DataContainerInterface,IBceVerOrdValue{

  private static String  m_boName = "com.ai.bce.auto.plugin.version.hand.bo.BceVerOrd";



  public final static  String S_State = "STATE";
  public final static  String S_PubilshState = "PUBILSH_STATE";
  public final static  String S_OrdUser = "ORD_USER";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_CreatDate = "CREAT_DATE";
  public final static  String S_OrdUseId = "ORD_USE_ID";
  public final static  String S_ApplyUser = "APPLY_USER";
  public final static  String S_VersionId = "VERSION_ID";
  public final static  String S_OrdId = "ORD_ID";
  public final static  String S_OrdName = "ORD_NAME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceVerOrdBean() throws AIException{
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

  public void initPubilshState(String value){
     this.initProperty(S_PubilshState,value);
  }
  public  void setPubilshState(String value){
     this.set(S_PubilshState,value);
  }
  public  void setPubilshStateNull(){
     this.set(S_PubilshState,null);
  }

  public String getPubilshState(){
       return DataType.getAsString(this.get(S_PubilshState));
  
  }
  public String getPubilshStateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PubilshState));
      }

  public void initOrdUser(long value){
     this.initProperty(S_OrdUser,new Long(value));
  }
  public  void setOrdUser(long value){
     this.set(S_OrdUser,new Long(value));
  }
  public  void setOrdUserNull(){
     this.set(S_OrdUser,null);
  }

  public long getOrdUser(){
        return DataType.getAsLong(this.get(S_OrdUser));
  
  }
  public long getOrdUserInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OrdUser));
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

  public void initCreatDate(Timestamp value){
     this.initProperty(S_CreatDate,value);
  }
  public  void setCreatDate(Timestamp value){
     this.set(S_CreatDate,value);
  }
  public  void setCreatDateNull(){
     this.set(S_CreatDate,null);
  }

  public Timestamp getCreatDate(){
        return DataType.getAsDateTime(this.get(S_CreatDate));
  
  }
  public Timestamp getCreatDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CreatDate));
      }

  public void initOrdUseId(String value){
     this.initProperty(S_OrdUseId,value);
  }
  public  void setOrdUseId(String value){
     this.set(S_OrdUseId,value);
  }
  public  void setOrdUseIdNull(){
     this.set(S_OrdUseId,null);
  }

  public String getOrdUseId(){
       return DataType.getAsString(this.get(S_OrdUseId));
  
  }
  public String getOrdUseIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrdUseId));
      }

  public void initApplyUser(String value){
     this.initProperty(S_ApplyUser,value);
  }
  public  void setApplyUser(String value){
     this.set(S_ApplyUser,value);
  }
  public  void setApplyUserNull(){
     this.set(S_ApplyUser,null);
  }

  public String getApplyUser(){
       return DataType.getAsString(this.get(S_ApplyUser));
  
  }
  public String getApplyUserInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ApplyUser));
      }

  public void initVersionId(long value){
     this.initProperty(S_VersionId,new Long(value));
  }
  public  void setVersionId(long value){
     this.set(S_VersionId,new Long(value));
  }
  public  void setVersionIdNull(){
     this.set(S_VersionId,null);
  }

  public long getVersionId(){
        return DataType.getAsLong(this.get(S_VersionId));
  
  }
  public long getVersionIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_VersionId));
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

  public void initOrdName(String value){
     this.initProperty(S_OrdName,value);
  }
  public  void setOrdName(String value){
     this.set(S_OrdName,value);
  }
  public  void setOrdNameNull(){
     this.set(S_OrdName,null);
  }

  public String getOrdName(){
       return DataType.getAsString(this.get(S_OrdName));
  
  }
  public String getOrdNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrdName));
      }


 
 }

