package com.asiainfo.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.common.ivalues.*;

public class BOProductAttachCfgBean extends DataContainer implements DataContainerInterface,IBOProductAttachCfgValue{

  private static String  m_boName = "com.asiainfo.common.bo.BOProductAttachCfg";



  public final static  String S_RelaOrderId = "RELA_ORDER_ID";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_RelaOrderType = "RELA_ORDER_TYPE";
  public final static  String S_Id = "ID";
  public final static  String S_Principle = "PRINCIPLE";
  public final static  String S_Flag = "FLAG";
  public final static  String S_OrgId = "ORG_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOProductAttachCfgBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initRelaOrderId(String value){
     this.initProperty(S_RelaOrderId,value);
  }
  public  void setRelaOrderId(String value){
     this.set(S_RelaOrderId,value);
  }
  public  void setRelaOrderIdNull(){
     this.set(S_RelaOrderId,null);
  }

  public String getRelaOrderId(){
       return DataType.getAsString(this.get(S_RelaOrderId));
  
  }
  public String getRelaOrderIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RelaOrderId));
      }

  public void initCreateTime(Timestamp value){
     this.initProperty(S_CreateTime,value);
  }
  public  void setCreateTime(Timestamp value){
     this.set(S_CreateTime,value);
  }
  public  void setCreateTimeNull(){
     this.set(S_CreateTime,null);
  }

  public Timestamp getCreateTime(){
        return DataType.getAsDateTime(this.get(S_CreateTime));
  
  }
  public Timestamp getCreateTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CreateTime));
      }

  public void initRelaOrderType(String value){
     this.initProperty(S_RelaOrderType,value);
  }
  public  void setRelaOrderType(String value){
     this.set(S_RelaOrderType,value);
  }
  public  void setRelaOrderTypeNull(){
     this.set(S_RelaOrderType,null);
  }

  public String getRelaOrderType(){
       return DataType.getAsString(this.get(S_RelaOrderType));
  
  }
  public String getRelaOrderTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RelaOrderType));
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

  public void initPrinciple(String value){
     this.initProperty(S_Principle,value);
  }
  public  void setPrinciple(String value){
     this.set(S_Principle,value);
  }
  public  void setPrincipleNull(){
     this.set(S_Principle,null);
  }

  public String getPrinciple(){
       return DataType.getAsString(this.get(S_Principle));
  
  }
  public String getPrincipleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Principle));
      }

  public void initFlag(String value){
     this.initProperty(S_Flag,value);
  }
  public  void setFlag(String value){
     this.set(S_Flag,value);
  }
  public  void setFlagNull(){
     this.set(S_Flag,null);
  }

  public String getFlag(){
       return DataType.getAsString(this.get(S_Flag));
  
  }
  public String getFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Flag));
      }

  public void initOrgId(String value){
     this.initProperty(S_OrgId,value);
  }
  public  void setOrgId(String value){
     this.set(S_OrgId,value);
  }
  public  void setOrgIdNull(){
     this.set(S_OrgId,null);
  }

  public String getOrgId(){
       return DataType.getAsString(this.get(S_OrgId));
  
  }
  public String getOrgIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrgId));
      }


 
 }

