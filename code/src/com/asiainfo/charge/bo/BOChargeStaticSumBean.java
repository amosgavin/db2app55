package com.asiainfo.charge.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.charge.ivalues.*;

public class BOChargeStaticSumBean extends DataContainer implements DataContainerInterface,IBOChargeStaticSumValue{

  private static String  m_boName = "com.asiainfo.charge.bo.BOChargeStaticSum";



  public final static  String S_BeforeChange = "BEFORE_CHANGE";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_SwitchUser = "SWITCH_USER";
  public final static  String S_AfterChange = "AFTER_CHANGE";
  public final static  String S_Item = "ITEM";
  public final static  String S_GrandId = "GRAND_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOChargeStaticSumBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initBeforeChange(double value){
     this.initProperty(S_BeforeChange,new Double(value));
  }
  public  void setBeforeChange(double value){
     this.set(S_BeforeChange,new Double(value));
  }
  public  void setBeforeChangeNull(){
     this.set(S_BeforeChange,null);
  }

  public double getBeforeChange(){
        return DataType.getAsDouble(this.get(S_BeforeChange));
  
  }
  public double getBeforeChangeInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_BeforeChange));
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

  public void initSwitchUser(int value){
     this.initProperty(S_SwitchUser,new Integer(value));
  }
  public  void setSwitchUser(int value){
     this.set(S_SwitchUser,new Integer(value));
  }
  public  void setSwitchUserNull(){
     this.set(S_SwitchUser,null);
  }

  public int getSwitchUser(){
        return DataType.getAsInt(this.get(S_SwitchUser));
  
  }
  public int getSwitchUserInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_SwitchUser));
      }

  public void initAfterChange(double value){
     this.initProperty(S_AfterChange,new Double(value));
  }
  public  void setAfterChange(double value){
     this.set(S_AfterChange,new Double(value));
  }
  public  void setAfterChangeNull(){
     this.set(S_AfterChange,null);
  }

  public double getAfterChange(){
        return DataType.getAsDouble(this.get(S_AfterChange));
  
  }
  public double getAfterChangeInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_AfterChange));
      }

  public void initItem(String value){
     this.initProperty(S_Item,value);
  }
  public  void setItem(String value){
     this.set(S_Item,value);
  }
  public  void setItemNull(){
     this.set(S_Item,null);
  }

  public String getItem(){
       return DataType.getAsString(this.get(S_Item));
  
  }
  public String getItemInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Item));
      }

  public void initGrandId(String value){
     this.initProperty(S_GrandId,value);
  }
  public  void setGrandId(String value){
     this.set(S_GrandId,value);
  }
  public  void setGrandIdNull(){
     this.set(S_GrandId,null);
  }

  public String getGrandId(){
       return DataType.getAsString(this.get(S_GrandId));
  
  }
  public String getGrandIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_GrandId));
      }


 
 }

