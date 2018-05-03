package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BcePageRelConfigBean extends DataContainer implements DataContainerInterface,IBcePageRelConfigValue{

  private static String  m_boName = "com.ai.bce.bo.BcePageRelConfig";



  public final static  String S_State = "STATE";
  public final static  String S_PreRelateId = "PRE_RELATE_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_PageRelId = "PAGE_REL_ID";
  public final static  String S_PageId = "PAGE_ID";
  public final static  String S_TemplateId = "TEMPLATE_ID";
  public final static  String S_RelateType = "RELATE_TYPE";
  public final static  String S_SeqNo = "SEQ_NO";
  public final static  String S_RelateObjId = "RELATE_OBJ_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BcePageRelConfigBean() throws AIException{
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

  public void initPreRelateId(long value){
     this.initProperty(S_PreRelateId,new Long(value));
  }
  public  void setPreRelateId(long value){
     this.set(S_PreRelateId,new Long(value));
  }

  public  void setPreRelateId(Long value){
     this.set(S_PreRelateId,value);
  }
  
  public  Long  getPreRelateIdAsLong(){
     return (Long )this.get(S_PreRelateId);
  }
  
  
  public  void setPreRelateIdNull(){
     this.set(S_PreRelateId,null);
  }

  public long getPreRelateId(){
        return DataType.getAsLong(this.get(S_PreRelateId));
  
  }
  public long getPreRelateIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PreRelateId));
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

  public void initPageRelId(long value){
     this.initProperty(S_PageRelId,new Long(value));
  }
  public  void setPageRelId(long value){
     this.set(S_PageRelId,new Long(value));
  }

  public  void setPageRelId(Long value){
     this.set(S_PageRelId,value);
  }
  
  public  Long  getPageRelIdAsLong(){
     return (Long )this.get(S_PageRelId);
  }
  
  
  public  void setPageRelIdNull(){
     this.set(S_PageRelId,null);
  }

  public long getPageRelId(){
        return DataType.getAsLong(this.get(S_PageRelId));
  
  }
  public long getPageRelIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PageRelId));
      }

  public void initPageId(long value){
     this.initProperty(S_PageId,new Long(value));
  }
  public  void setPageId(long value){
     this.set(S_PageId,new Long(value));
  }

  public  void setPageId(Long value){
     this.set(S_PageId,value);
  }
  
  public  Long  getPageIdAsLong(){
     return (Long )this.get(S_PageId);
  }
  
  
  public  void setPageIdNull(){
     this.set(S_PageId,null);
  }

  public long getPageId(){
        return DataType.getAsLong(this.get(S_PageId));
  
  }
  public long getPageIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PageId));
      }

  public void initTemplateId(String value){
     this.initProperty(S_TemplateId,value);
  }
  public  void setTemplateId(String value){
     this.set(S_TemplateId,value);
  }

  
  
  public  void setTemplateIdNull(){
     this.set(S_TemplateId,null);
  }

  public String getTemplateId(){
       return DataType.getAsString(this.get(S_TemplateId));
  
  }
  public String getTemplateIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TemplateId));
      }

  public void initRelateType(String value){
     this.initProperty(S_RelateType,value);
  }
  public  void setRelateType(String value){
     this.set(S_RelateType,value);
  }

  
  
  public  void setRelateTypeNull(){
     this.set(S_RelateType,null);
  }

  public String getRelateType(){
       return DataType.getAsString(this.get(S_RelateType));
  
  }
  public String getRelateTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RelateType));
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

  public void initRelateObjId(long value){
     this.initProperty(S_RelateObjId,new Long(value));
  }
  public  void setRelateObjId(long value){
     this.set(S_RelateObjId,new Long(value));
  }

  public  void setRelateObjId(Long value){
     this.set(S_RelateObjId,value);
  }
  
  public  Long  getRelateObjIdAsLong(){
     return (Long )this.get(S_RelateObjId);
  }
  
  
  public  void setRelateObjIdNull(){
     this.set(S_RelateObjId,null);
  }

  public long getRelateObjId(){
        return DataType.getAsLong(this.get(S_RelateObjId));
  
  }
  public long getRelateObjIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RelateObjId));
      }


 
 }

