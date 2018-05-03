package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceWorkflowBean extends DataContainer implements DataContainerInterface,IBceWorkflowValue{

  private static String  m_boName = "com.ai.bce.bo.BceWorkflow";



  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_OfferId = "OFFER_ID";
  public final static  String S_BceWorkflowId = "BCE_WORKFLOW_ID";
  public final static  String S_ProdSpecId = "PROD_SPEC_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_WorkflowCode = "WORKFLOW_CODE";
  public final static  String S_BusinessId = "BUSINESS_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceWorkflowBean() throws AIException{
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

  public void initOfferId(long value){
     this.initProperty(S_OfferId,new Long(value));
  }
  public  void setOfferId(long value){
     this.set(S_OfferId,new Long(value));
  }
  public  void setOfferIdNull(){
     this.set(S_OfferId,null);
  }

  public long getOfferId(){
        return DataType.getAsLong(this.get(S_OfferId));
  
  }
  public long getOfferIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OfferId));
      }

  public void initBceWorkflowId(long value){
     this.initProperty(S_BceWorkflowId,new Long(value));
  }
  public  void setBceWorkflowId(long value){
     this.set(S_BceWorkflowId,new Long(value));
  }
  public  void setBceWorkflowIdNull(){
     this.set(S_BceWorkflowId,null);
  }

  public long getBceWorkflowId(){
        return DataType.getAsLong(this.get(S_BceWorkflowId));
  
  }
  public long getBceWorkflowIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BceWorkflowId));
      }

  public void initProdSpecId(long value){
     this.initProperty(S_ProdSpecId,new Long(value));
  }
  public  void setProdSpecId(long value){
     this.set(S_ProdSpecId,new Long(value));
  }
  public  void setProdSpecIdNull(){
     this.set(S_ProdSpecId,null);
  }

  public long getProdSpecId(){
        return DataType.getAsLong(this.get(S_ProdSpecId));
  
  }
  public long getProdSpecIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ProdSpecId));
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

  public void initWorkflowCode(String value){
     this.initProperty(S_WorkflowCode,value);
  }
  public  void setWorkflowCode(String value){
     this.set(S_WorkflowCode,value);
  }
  public  void setWorkflowCodeNull(){
     this.set(S_WorkflowCode,null);
  }

  public String getWorkflowCode(){
       return DataType.getAsString(this.get(S_WorkflowCode));
  
  }
  public String getWorkflowCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WorkflowCode));
      }

  public void initBusinessId(long value){
     this.initProperty(S_BusinessId,new Long(value));
  }
  public  void setBusinessId(long value){
     this.set(S_BusinessId,new Long(value));
  }
  public  void setBusinessIdNull(){
     this.set(S_BusinessId,null);
  }

  public long getBusinessId(){
        return DataType.getAsLong(this.get(S_BusinessId));
  
  }
  public long getBusinessIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BusinessId));
      }


 
 }

