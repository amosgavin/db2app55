package com.asiainfo.costWarn.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.costWarn.ivalues.*;

public class BOCostWarnStaticDataBean extends DataContainer implements DataContainerInterface,IBOCostWarnStaticDataValue{

  private static String  m_boName = "com.asiainfo.costWarn.bo.BOCostWarnStaticData";



  public final static  String S_CityCode = "CITY_CODE";
  public final static  String S_DiscountFee = "DISCOUNT_FEE";
  public final static  String S_CityId = "CITY_ID";
  public final static  String S_Reserve4 = "RESERVE4";
  public final static  String S_CityName = "CITY_NAME";
  public final static  String S_Reserve1 = "RESERVE1";
  public final static  String S_EndpointSub = "ENDPOINT_SUB";
  public final static  String S_Seserve5 = "SESERVE5";
  public final static  String S_Reserve3 = "RESERVE3";
  public final static  String S_Reserve2 = "RESERVE2";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOCostWarnStaticDataBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initCityCode(String value){
     this.initProperty(S_CityCode,value);
  }
  public  void setCityCode(String value){
     this.set(S_CityCode,value);
  }
  public  void setCityCodeNull(){
     this.set(S_CityCode,null);
  }

  public String getCityCode(){
       return DataType.getAsString(this.get(S_CityCode));
  
  }
  public String getCityCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CityCode));
      }

  public void initDiscountFee(double value){
     this.initProperty(S_DiscountFee,new Double(value));
  }
  public  void setDiscountFee(double value){
     this.set(S_DiscountFee,new Double(value));
  }
  public  void setDiscountFeeNull(){
     this.set(S_DiscountFee,null);
  }

  public double getDiscountFee(){
        return DataType.getAsDouble(this.get(S_DiscountFee));
  
  }
  public double getDiscountFeeInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_DiscountFee));
      }

  public void initCityId(String value){
     this.initProperty(S_CityId,value);
  }
  public  void setCityId(String value){
     this.set(S_CityId,value);
  }
  public  void setCityIdNull(){
     this.set(S_CityId,null);
  }

  public String getCityId(){
       return DataType.getAsString(this.get(S_CityId));
  
  }
  public String getCityIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CityId));
      }

  public void initReserve4(String value){
     this.initProperty(S_Reserve4,value);
  }
  public  void setReserve4(String value){
     this.set(S_Reserve4,value);
  }
  public  void setReserve4Null(){
     this.set(S_Reserve4,null);
  }

  public String getReserve4(){
       return DataType.getAsString(this.get(S_Reserve4));
  
  }
  public String getReserve4InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Reserve4));
      }

  public void initCityName(String value){
     this.initProperty(S_CityName,value);
  }
  public  void setCityName(String value){
     this.set(S_CityName,value);
  }
  public  void setCityNameNull(){
     this.set(S_CityName,null);
  }

  public String getCityName(){
       return DataType.getAsString(this.get(S_CityName));
  
  }
  public String getCityNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CityName));
      }

  public void initReserve1(double value){
     this.initProperty(S_Reserve1,new Double(value));
  }
  public  void setReserve1(double value){
     this.set(S_Reserve1,new Double(value));
  }
  public  void setReserve1Null(){
     this.set(S_Reserve1,null);
  }

  public double getReserve1(){
        return DataType.getAsDouble(this.get(S_Reserve1));
  
  }
  public double getReserve1InitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_Reserve1));
      }

  public void initEndpointSub(double value){
     this.initProperty(S_EndpointSub,new Double(value));
  }
  public  void setEndpointSub(double value){
     this.set(S_EndpointSub,new Double(value));
  }
  public  void setEndpointSubNull(){
     this.set(S_EndpointSub,null);
  }

  public double getEndpointSub(){
        return DataType.getAsDouble(this.get(S_EndpointSub));
  
  }
  public double getEndpointSubInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_EndpointSub));
      }

  public void initSeserve5(String value){
     this.initProperty(S_Seserve5,value);
  }
  public  void setSeserve5(String value){
     this.set(S_Seserve5,value);
  }
  public  void setSeserve5Null(){
     this.set(S_Seserve5,null);
  }

  public String getSeserve5(){
       return DataType.getAsString(this.get(S_Seserve5));
  
  }
  public String getSeserve5InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Seserve5));
      }

  public void initReserve3(double value){
     this.initProperty(S_Reserve3,new Double(value));
  }
  public  void setReserve3(double value){
     this.set(S_Reserve3,new Double(value));
  }
  public  void setReserve3Null(){
     this.set(S_Reserve3,null);
  }

  public double getReserve3(){
        return DataType.getAsDouble(this.get(S_Reserve3));
  
  }
  public double getReserve3InitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_Reserve3));
      }

  public void initReserve2(double value){
     this.initProperty(S_Reserve2,new Double(value));
  }
  public  void setReserve2(double value){
     this.set(S_Reserve2,new Double(value));
  }
  public  void setReserve2Null(){
     this.set(S_Reserve2,null);
  }

  public double getReserve2(){
        return DataType.getAsDouble(this.get(S_Reserve2));
  
  }
  public double getReserve2InitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_Reserve2));
      }


 
 }

