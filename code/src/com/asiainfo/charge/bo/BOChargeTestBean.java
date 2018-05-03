package com.asiainfo.charge.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.charge.ivalues.*;

public class BOChargeTestBean extends DataContainer implements DataContainerInterface,IBOChargeTestValue{

  private static String  m_boName = "com.asiainfo.charge.bo.BOChargeTest";



  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_Reason = "REASON";
  public final static  String S_Id = "ID";
  public final static  String S_TestFactor = "TEST_FACTOR";
  public final static  String S_TestResult = "TEST_RESULT";
  public final static  String S_Flag = "FLAG";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOChargeTestBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
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

  public void initReason(String value){
     this.initProperty(S_Reason,value);
  }
  public  void setReason(String value){
     this.set(S_Reason,value);
  }
  public  void setReasonNull(){
     this.set(S_Reason,null);
  }

  public String getReason(){
       return DataType.getAsString(this.get(S_Reason));
  
  }
  public String getReasonInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Reason));
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

  public void initTestFactor(String value){
     this.initProperty(S_TestFactor,value);
  }
  public  void setTestFactor(String value){
     this.set(S_TestFactor,value);
  }
  public  void setTestFactorNull(){
     this.set(S_TestFactor,null);
  }

  public String getTestFactor(){
       return DataType.getAsString(this.get(S_TestFactor));
  
  }
  public String getTestFactorInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TestFactor));
      }

  public void initTestResult(String value){
     this.initProperty(S_TestResult,value);
  }
  public  void setTestResult(String value){
     this.set(S_TestResult,value);
  }
  public  void setTestResultNull(){
     this.set(S_TestResult,null);
  }

  public String getTestResult(){
       return DataType.getAsString(this.get(S_TestResult));
  
  }
  public String getTestResultInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TestResult));
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


 
 }

