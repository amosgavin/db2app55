package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BcePageRowsetRelBean extends DataContainer implements DataContainerInterface,IBcePageRowsetRelValue{

  private static String  m_boName = "com.ai.bce.bo.BcePageRowsetRel";



  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_PageFramePageId = "PAGE_FRAME_PAGE_ID";
  public final static  String S_RowsetId = "ROWSET_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BcePageRowsetRelBean() throws AIException{
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

  public void initPageFramePageId(long value){
     this.initProperty(S_PageFramePageId,new Long(value));
  }
  public  void setPageFramePageId(long value){
     this.set(S_PageFramePageId,new Long(value));
  }

  public  void setPageFramePageId(Long value){
     this.set(S_PageFramePageId,value);
  }
  
  public  Long  getPageFramePageIdAsLong(){
     return (Long )this.get(S_PageFramePageId);
  }
  
  
  public  void setPageFramePageIdNull(){
     this.set(S_PageFramePageId,null);
  }

  public long getPageFramePageId(){
        return DataType.getAsLong(this.get(S_PageFramePageId));
  
  }
  public long getPageFramePageIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PageFramePageId));
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


 
 }

