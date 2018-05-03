package com.asiainfo.sale.complain.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.complain.ivalues.*;

public class BOOrderComplainsDetailBean extends DataContainer implements DataContainerInterface,IBOOrderComplainsDetailValue{

  private static String  m_boName = "com.asiainfo.sale.complain.bo.BOOrderComplainsDetail";



  public final static  String S_ComplainsType = "COMPLAINS_TYPE";
  public final static  String S_ComplainsReason = "COMPLAINS_REASON";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_OrderStaff = "ORDER_STAFF";
  public final static  String S_BossId = "BOSS_ID";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_OrderTime = "ORDER_TIME";
  public final static  String S_Id = "ID";
  public final static  String S_IsDelete = "IS_DELETE";
  public final static  String S_Principle = "PRINCIPLE";
  public final static  String S_OrderName = "ORDER_NAME";
  public final static  String S_ComplainsId = "COMPLAINS_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOOrderComplainsDetailBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initComplainsType(String value){
     this.initProperty(S_ComplainsType,value);
  }
  public  void setComplainsType(String value){
     this.set(S_ComplainsType,value);
  }
  public  void setComplainsTypeNull(){
     this.set(S_ComplainsType,null);
  }

  public String getComplainsType(){
       return DataType.getAsString(this.get(S_ComplainsType));
  
  }
  public String getComplainsTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ComplainsType));
      }

  public void initComplainsReason(String value){
     this.initProperty(S_ComplainsReason,value);
  }
  public  void setComplainsReason(String value){
     this.set(S_ComplainsReason,value);
  }
  public  void setComplainsReasonNull(){
     this.set(S_ComplainsReason,null);
  }

  public String getComplainsReason(){
       return DataType.getAsString(this.get(S_ComplainsReason));
  
  }
  public String getComplainsReasonInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ComplainsReason));
      }

  public void initOrderId(int value){
     this.initProperty(S_OrderId,new Integer(value));
  }
  public  void setOrderId(int value){
     this.set(S_OrderId,new Integer(value));
  }
  public  void setOrderIdNull(){
     this.set(S_OrderId,null);
  }

  public int getOrderId(){
        return DataType.getAsInt(this.get(S_OrderId));
  
  }
  public int getOrderIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_OrderId));
      }

  public void initOrderStaff(String value){
     this.initProperty(S_OrderStaff,value);
  }
  public  void setOrderStaff(String value){
     this.set(S_OrderStaff,value);
  }
  public  void setOrderStaffNull(){
     this.set(S_OrderStaff,null);
  }

  public String getOrderStaff(){
       return DataType.getAsString(this.get(S_OrderStaff));
  
  }
  public String getOrderStaffInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrderStaff));
      }

  public void initBossId(String value){
     this.initProperty(S_BossId,value);
  }
  public  void setBossId(String value){
     this.set(S_BossId,value);
  }
  public  void setBossIdNull(){
     this.set(S_BossId,null);
  }

  public String getBossId(){
       return DataType.getAsString(this.get(S_BossId));
  
  }
  public String getBossIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BossId));
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

  public void initOrderTime(Timestamp value){
     this.initProperty(S_OrderTime,value);
  }
  public  void setOrderTime(Timestamp value){
     this.set(S_OrderTime,value);
  }
  public  void setOrderTimeNull(){
     this.set(S_OrderTime,null);
  }

  public Timestamp getOrderTime(){
        return DataType.getAsDateTime(this.get(S_OrderTime));
  
  }
  public Timestamp getOrderTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_OrderTime));
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

  public void initIsDelete(String value){
     this.initProperty(S_IsDelete,value);
  }
  public  void setIsDelete(String value){
     this.set(S_IsDelete,value);
  }
  public  void setIsDeleteNull(){
     this.set(S_IsDelete,null);
  }

  public String getIsDelete(){
       return DataType.getAsString(this.get(S_IsDelete));
  
  }
  public String getIsDeleteInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsDelete));
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

  public void initOrderName(String value){
     this.initProperty(S_OrderName,value);
  }
  public  void setOrderName(String value){
     this.set(S_OrderName,value);
  }
  public  void setOrderNameNull(){
     this.set(S_OrderName,null);
  }

  public String getOrderName(){
       return DataType.getAsString(this.get(S_OrderName));
  
  }
  public String getOrderNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrderName));
      }

  public void initComplainsId(int value){
     this.initProperty(S_ComplainsId,new Integer(value));
  }
  public  void setComplainsId(int value){
     this.set(S_ComplainsId,new Integer(value));
  }
  public  void setComplainsIdNull(){
     this.set(S_ComplainsId,null);
  }

  public int getComplainsId(){
        return DataType.getAsInt(this.get(S_ComplainsId));
  
  }
  public int getComplainsIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_ComplainsId));
      }

  public void undelete(){
	  super.m_isDeleted=false;
  }
 
 }

