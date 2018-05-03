package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceFramePageRoleBean extends DataContainer implements DataContainerInterface,IBceFramePageRoleValue{

  private static String  m_boName = "com.ai.bce.bo.BceFramePageRole";



  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_MaxNum = "MAX_NUM";
  public final static  String S_RoleId = "ROLE_ID";
  public final static  String S_BceFrameId = "BCE_FRAME_ID";
  public final static  String S_PageFramePageId = "PAGE_FRAME_PAGE_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_SeqNo = "SEQ_NO";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceFramePageRoleBean() throws AIException{
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

  public void initMaxNum(int value){
     this.initProperty(S_MaxNum,new Integer(value));
  }
  public  void setMaxNum(int value){
     this.set(S_MaxNum,new Integer(value));
  }

  public  void setMaxNum(Integer value){
     this.set(S_MaxNum,value);
  }
  
  public  Integer  getMaxNumAsInteger(){
     return (Integer )this.get(S_MaxNum);
  }
  
  
  public  void setMaxNumNull(){
     this.set(S_MaxNum,null);
  }

  public int getMaxNum(){
        return DataType.getAsInt(this.get(S_MaxNum));
  
  }
  public int getMaxNumInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_MaxNum));
      }

  public void initRoleId(long value){
     this.initProperty(S_RoleId,new Long(value));
  }
  public  void setRoleId(long value){
     this.set(S_RoleId,new Long(value));
  }

  public  void setRoleId(Long value){
     this.set(S_RoleId,value);
  }
  
  public  Long  getRoleIdAsLong(){
     return (Long )this.get(S_RoleId);
  }
  
  
  public  void setRoleIdNull(){
     this.set(S_RoleId,null);
  }

  public long getRoleId(){
        return DataType.getAsLong(this.get(S_RoleId));
  
  }
  public long getRoleIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RoleId));
      }

  public void initBceFrameId(long value){
     this.initProperty(S_BceFrameId,new Long(value));
  }
  public  void setBceFrameId(long value){
     this.set(S_BceFrameId,new Long(value));
  }

  public  void setBceFrameId(Long value){
     this.set(S_BceFrameId,value);
  }
  
  public  Long  getBceFrameIdAsLong(){
     return (Long )this.get(S_BceFrameId);
  }
  
  
  public  void setBceFrameIdNull(){
     this.set(S_BceFrameId,null);
  }

  public long getBceFrameId(){
        return DataType.getAsLong(this.get(S_BceFrameId));
  
  }
  public long getBceFrameIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BceFrameId));
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

  public void initSeqNo(int value){
     this.initProperty(S_SeqNo,new Integer(value));
  }
  public  void setSeqNo(int value){
     this.set(S_SeqNo,new Integer(value));
  }

  public  void setSeqNo(Integer value){
     this.set(S_SeqNo,value);
  }
  
  public  Integer  getSeqNoAsInteger(){
     return (Integer )this.get(S_SeqNo);
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

