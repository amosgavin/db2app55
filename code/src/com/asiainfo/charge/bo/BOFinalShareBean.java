package com.asiainfo.charge.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.charge.ivalues.*;

public class BOFinalShareBean extends DataContainer implements DataContainerInterface,IBOFinalShareValue{

  private static String  m_boName = "com.asiainfo.charge.bo.BOFinalShare";



  public final static  String S_Reserv2 = "RESERV2";
  public final static  String S_Reserv1 = "RESERV1";
  public final static  String S_Final = "FINAL";
  public final static  String S_Reserv3 = "RESERV3";
  public final static  String S_Id = "ID";
  public final static  String S_FinalTaxrate = "FINAL_TAXRATE";
  public final static  String S_ChargeId = "CHARGE_ID";
  public final static  String S_FinalRate = "FINAL_RATE";
  public final static  String S_AmountItem = "AMOUNT_ITEM";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOFinalShareBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initReserv2(String value){
     this.initProperty(S_Reserv2,value);
  }
  public  void setReserv2(String value){
     this.set(S_Reserv2,value);
  }
  public  void setReserv2Null(){
     this.set(S_Reserv2,null);
  }

  public String getReserv2(){
       return DataType.getAsString(this.get(S_Reserv2));
  
  }
  public String getReserv2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Reserv2));
      }

  public void initReserv1(String value){
     this.initProperty(S_Reserv1,value);
  }
  public  void setReserv1(String value){
     this.set(S_Reserv1,value);
  }
  public  void setReserv1Null(){
     this.set(S_Reserv1,null);
  }

  public String getReserv1(){
       return DataType.getAsString(this.get(S_Reserv1));
  
  }
  public String getReserv1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Reserv1));
      }

  public void initFinal(String value){
     this.initProperty(S_Final,value);
  }
  public  void setFinal(String value){
     this.set(S_Final,value);
  }
  public  void setFinalNull(){
     this.set(S_Final,null);
  }

  public String getFinal(){
       return DataType.getAsString(this.get(S_Final));
  
  }
  public String getFinalInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Final));
      }

  public void initReserv3(String value){
     this.initProperty(S_Reserv3,value);
  }
  public  void setReserv3(String value){
     this.set(S_Reserv3,value);
  }
  public  void setReserv3Null(){
     this.set(S_Reserv3,null);
  }

  public String getReserv3(){
       return DataType.getAsString(this.get(S_Reserv3));
  
  }
  public String getReserv3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Reserv3));
      }

  public void initId(long value){
     this.initProperty(S_Id,new Long(value));
  }
  public  void setId(long value){
     this.set(S_Id,new Long(value));
  }
  public  void setIdNull(){
     this.set(S_Id,null);
  }

  public long getId(){
        return DataType.getAsLong(this.get(S_Id));
  
  }
  public long getIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Id));
      }

  public void initFinalTaxrate(double value){
     this.initProperty(S_FinalTaxrate,new Double(value));
  }
  public  void setFinalTaxrate(double value){
     this.set(S_FinalTaxrate,new Double(value));
  }
  public  void setFinalTaxrateNull(){
     this.set(S_FinalTaxrate,null);
  }

  public double getFinalTaxrate(){
        return DataType.getAsDouble(this.get(S_FinalTaxrate));
  
  }
  public double getFinalTaxrateInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_FinalTaxrate));
      }

  public void initChargeId(String value){
     this.initProperty(S_ChargeId,value);
  }
  public  void setChargeId(String value){
     this.set(S_ChargeId,value);
  }
  public  void setChargeIdNull(){
     this.set(S_ChargeId,null);
  }

  public String getChargeId(){
       return DataType.getAsString(this.get(S_ChargeId));
  
  }
  public String getChargeIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ChargeId));
      }

  public void initFinalRate(double value){
     this.initProperty(S_FinalRate,new Double(value));
  }
  public  void setFinalRate(double value){
     this.set(S_FinalRate,new Double(value));
  }
  public  void setFinalRateNull(){
     this.set(S_FinalRate,null);
  }

  public double getFinalRate(){
        return DataType.getAsDouble(this.get(S_FinalRate));
  
  }
  public double getFinalRateInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_FinalRate));
      }

  public void initAmountItem(String value){
     this.initProperty(S_AmountItem,value);
  }
  public  void setAmountItem(String value){
     this.set(S_AmountItem,value);
  }
  public  void setAmountItemNull(){
     this.set(S_AmountItem,null);
  }

  public String getAmountItem(){
       return DataType.getAsString(this.get(S_AmountItem));
  
  }
  public String getAmountItemInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AmountItem));
      }


 
 }

