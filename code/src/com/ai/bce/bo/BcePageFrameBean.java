package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BcePageFrameBean extends DataContainer implements DataContainerInterface,IBcePageFrameValue{

  private static String  m_boName = "com.ai.bce.bo.BcePageFrame";



  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_PageFrameId = "PAGE_FRAME_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_FrameType = "FRAME_TYPE";
  public final static  String S_PageFrameName = "PAGE_FRAME_NAME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BcePageFrameBean() throws AIException{
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

  public void initPageFrameId(long value){
     this.initProperty(S_PageFrameId,new Long(value));
  }
  public  void setPageFrameId(long value){
     this.set(S_PageFrameId,new Long(value));
  }

  public  void setPageFrameId(Long value){
     this.set(S_PageFrameId,value);
  }
  
  public  Long  getPageFrameIdAsLong(){
     return (Long )this.get(S_PageFrameId);
  }
  
  
  public  void setPageFrameIdNull(){
     this.set(S_PageFrameId,null);
  }

  public long getPageFrameId(){
        return DataType.getAsLong(this.get(S_PageFrameId));
  
  }
  public long getPageFrameIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PageFrameId));
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

  public void initFrameType(int value){
     this.initProperty(S_FrameType,new Integer(value));
  }
  public  void setFrameType(int value){
     this.set(S_FrameType,new Integer(value));
  }

  public  void setFrameType(Integer value){
     this.set(S_FrameType,value);
  }
  
  public  Integer  getFrameTypeAsInteger(){
     return (Integer )this.get(S_FrameType);
  }
  
  
  public  void setFrameTypeNull(){
     this.set(S_FrameType,null);
  }

  public int getFrameType(){
        return DataType.getAsInt(this.get(S_FrameType));
  
  }
  public int getFrameTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_FrameType));
      }

  public void initPageFrameName(String value){
     this.initProperty(S_PageFrameName,value);
  }
  public  void setPageFrameName(String value){
     this.set(S_PageFrameName,value);
  }

  
  
  public  void setPageFrameNameNull(){
     this.set(S_PageFrameName,null);
  }

  public String getPageFrameName(){
       return DataType.getAsString(this.get(S_PageFrameName));
  
  }
  public String getPageFrameNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PageFrameName));
      }


 
 }

