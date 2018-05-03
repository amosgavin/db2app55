package com.asiainfo.charge.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.charge.ivalues.*;

public class BOBusiSurpConfBean extends DataContainer implements DataContainerInterface,IBOBusiSurpConfValue{

  private static String  m_boName = "com.asiainfo.charge.bo.BOBusiSurpConf";



  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_Reason = "REASON";
  public final static  String S_Mold = "MOLD";
  public final static  String S_Desc = "DESC";
  public final static  String S_Id = "ID";
  public final static  String S_Mode = "MODE";
  public final static  String S_Factor = "FACTOR";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOBusiSurpConfBean() throws AIException{
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

  public void initMold(String value){
     this.initProperty(S_Mold,value);
  }
  public  void setMold(String value){
     this.set(S_Mold,value);
  }
  public  void setMoldNull(){
     this.set(S_Mold,null);
  }

  public String getMold(){
       return DataType.getAsString(this.get(S_Mold));
  
  }
  public String getMoldInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Mold));
      }

  public void initDesc(String value){
     this.initProperty(S_Desc,value);
  }
  public  void setDesc(String value){
     this.set(S_Desc,value);
  }
  public  void setDescNull(){
     this.set(S_Desc,null);
  }

  public String getDesc(){
       return DataType.getAsString(this.get(S_Desc));
  
  }
  public String getDescInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Desc));
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

  public void initMode(String value){
     this.initProperty(S_Mode,value);
  }
  public  void setMode(String value){
     this.set(S_Mode,value);
  }
  public  void setModeNull(){
     this.set(S_Mode,null);
  }

  public String getMode(){
       return DataType.getAsString(this.get(S_Mode));
  
  }
  public String getModeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Mode));
      }

  public void initFactor(String value){
     this.initProperty(S_Factor,value);
  }
  public  void setFactor(String value){
     this.set(S_Factor,value);
  }
  public  void setFactorNull(){
     this.set(S_Factor,null);
  }

  public String getFactor(){
       return DataType.getAsString(this.get(S_Factor));
  
  }
  public String getFactorInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Factor));
      }


 
 }

