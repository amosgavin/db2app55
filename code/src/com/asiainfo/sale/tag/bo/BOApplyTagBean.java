package com.asiainfo.sale.tag.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.tag.ivalues.*;

public class BOApplyTagBean extends DataContainer implements DataContainerInterface,IBOApplyTagValue{

  private static String  m_boName = "com.asiainfo.sale.tag.bo.BOApplyTag";



  public final static  String S_Id = "ID";
  public final static  String S_FlowState = "FLOW_STATE";
  public final static  String S_PromoteManager = "PROMOTE_MANAGER";
  public final static  String S_Principal = "PRINCIPAL";
  public final static  String S_PromoteDepart = "PROMOTE_DEPART";
  public final static  String S_Case = "CASE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOApplyTagBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initId(int value){
     this.initProperty(S_Id,new Integer(value));
  }
  public  void setId(int value){
     this.set(S_Id,new Integer(value));
  }
  public  void setIdNull(){
     this.set(S_Id,null);
  }

  public int getId(){
        return DataType.getAsInt(this.get(S_Id));
  
  }
  public int getIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Id));
      }

  public void initFlowState(String value){
     this.initProperty(S_FlowState,value);
  }
  public  void setFlowState(String value){
     this.set(S_FlowState,value);
  }
  public  void setFlowStateNull(){
     this.set(S_FlowState,null);
  }

  public String getFlowState(){
       return DataType.getAsString(this.get(S_FlowState));
  
  }
  public String getFlowStateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FlowState));
      }

  public void initPromoteManager(String value){
     this.initProperty(S_PromoteManager,value);
  }
  public  void setPromoteManager(String value){
     this.set(S_PromoteManager,value);
  }
  public  void setPromoteManagerNull(){
     this.set(S_PromoteManager,null);
  }

  public String getPromoteManager(){
       return DataType.getAsString(this.get(S_PromoteManager));
  
  }
  public String getPromoteManagerInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PromoteManager));
      }

  public void initPrincipal(String value){
     this.initProperty(S_Principal,value);
  }
  public  void setPrincipal(String value){
     this.set(S_Principal,value);
  }
  public  void setPrincipalNull(){
     this.set(S_Principal,null);
  }

  public String getPrincipal(){
       return DataType.getAsString(this.get(S_Principal));
  
  }
  public String getPrincipalInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Principal));
      }

  public void initPromoteDepart(String value){
     this.initProperty(S_PromoteDepart,value);
  }
  public  void setPromoteDepart(String value){
     this.set(S_PromoteDepart,value);
  }
  public  void setPromoteDepartNull(){
     this.set(S_PromoteDepart,null);
  }

  public String getPromoteDepart(){
       return DataType.getAsString(this.get(S_PromoteDepart));
  
  }
  public String getPromoteDepartInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PromoteDepart));
      }

  public void initCase(String value){
     this.initProperty(S_Case,value);
  }
  public  void setCase(String value){
     this.set(S_Case,value);
  }
  public  void setCaseNull(){
     this.set(S_Case,null);
  }

  public String getCase(){
       return DataType.getAsString(this.get(S_Case));
  
  }
  public String getCaseInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Case));
      }


 
 }

