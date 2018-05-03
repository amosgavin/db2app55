package com.asiainfo.sale.activity.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.activity.ivalues.*;

public class BOSaleResourceAllotBean extends DataContainer implements DataContainerInterface,IBOSaleResourceAllotValue{

  private static String  m_boName = "com.asiainfo.sale.activity.bo.BOSaleResourceAllot";



  public final static  String S_CityCode = "CITY_CODE";
  public final static  String S_LTerm = "L_TERM";
  public final static  String S_CityId = "CITY_ID";
  public final static  String S_PDisc = "P_DISC";
  public final static  String S_ThresholdV4 = "THRESHOLD_V4";
  public final static  String S_ThresholdV2 = "THRESHOLD_V2";
  public final static  String S_ThresholdV3 = "THRESHOLD_V3";
  public final static  String S_LPoints = "L_POINTS";
  public final static  String S_PPoints = "P_POINTS";
  public final static  String S_LDisc = "L_DISC";
  public final static  String S_ThresholdV1 = "THRESHOLD_V1";
  public final static  String S_CityName = "CITY_NAME";
  public final static  String S_PPromt = "P_PROMT";
  public final static  String S_PTerm = "P_TERM";
  public final static  String S_QuarterS = "QUARTER_S";
  public final static  String S_LPromt = "L_PROMT";
  public final static  String S_YearS = "YEAR_S";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOSaleResourceAllotBean() throws AIException{
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

  public void initLTerm(double value){
     this.initProperty(S_LTerm,new Double(value));
  }
  public  void setLTerm(double value){
     this.set(S_LTerm,new Double(value));
  }
  public  void setLTermNull(){
     this.set(S_LTerm,null);
  }

  public double getLTerm(){
        return DataType.getAsDouble(this.get(S_LTerm));
  
  }
  public double getLTermInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_LTerm));
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

  public void initPDisc(double value){
     this.initProperty(S_PDisc,new Double(value));
  }
  public  void setPDisc(double value){
     this.set(S_PDisc,new Double(value));
  }
  public  void setPDiscNull(){
     this.set(S_PDisc,null);
  }

  public double getPDisc(){
        return DataType.getAsDouble(this.get(S_PDisc));
  
  }
  public double getPDiscInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PDisc));
      }

  public void initThresholdV4(double value){
     this.initProperty(S_ThresholdV4,new Double(value));
  }
  public  void setThresholdV4(double value){
     this.set(S_ThresholdV4,new Double(value));
  }
  public  void setThresholdV4Null(){
     this.set(S_ThresholdV4,null);
  }

  public double getThresholdV4(){
        return DataType.getAsDouble(this.get(S_ThresholdV4));
  
  }
  public double getThresholdV4InitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_ThresholdV4));
      }

  public void initThresholdV2(double value){
     this.initProperty(S_ThresholdV2,new Double(value));
  }
  public  void setThresholdV2(double value){
     this.set(S_ThresholdV2,new Double(value));
  }
  public  void setThresholdV2Null(){
     this.set(S_ThresholdV2,null);
  }

  public double getThresholdV2(){
        return DataType.getAsDouble(this.get(S_ThresholdV2));
  
  }
  public double getThresholdV2InitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_ThresholdV2));
      }

  public void initThresholdV3(double value){
     this.initProperty(S_ThresholdV3,new Double(value));
  }
  public  void setThresholdV3(double value){
     this.set(S_ThresholdV3,new Double(value));
  }
  public  void setThresholdV3Null(){
     this.set(S_ThresholdV3,null);
  }

  public double getThresholdV3(){
        return DataType.getAsDouble(this.get(S_ThresholdV3));
  
  }
  public double getThresholdV3InitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_ThresholdV3));
      }

  public void initLPoints(double value){
     this.initProperty(S_LPoints,new Double(value));
  }
  public  void setLPoints(double value){
     this.set(S_LPoints,new Double(value));
  }
  public  void setLPointsNull(){
     this.set(S_LPoints,null);
  }

  public double getLPoints(){
        return DataType.getAsDouble(this.get(S_LPoints));
  
  }
  public double getLPointsInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_LPoints));
      }

  public void initPPoints(double value){
     this.initProperty(S_PPoints,new Double(value));
  }
  public  void setPPoints(double value){
     this.set(S_PPoints,new Double(value));
  }
  public  void setPPointsNull(){
     this.set(S_PPoints,null);
  }

  public double getPPoints(){
        return DataType.getAsDouble(this.get(S_PPoints));
  
  }
  public double getPPointsInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PPoints));
      }

  public void initLDisc(double value){
     this.initProperty(S_LDisc,new Double(value));
  }
  public  void setLDisc(double value){
     this.set(S_LDisc,new Double(value));
  }
  public  void setLDiscNull(){
     this.set(S_LDisc,null);
  }

  public double getLDisc(){
        return DataType.getAsDouble(this.get(S_LDisc));
  
  }
  public double getLDiscInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_LDisc));
      }

  public void initThresholdV1(double value){
     this.initProperty(S_ThresholdV1,new Double(value));
  }
  public  void setThresholdV1(double value){
     this.set(S_ThresholdV1,new Double(value));
  }
  public  void setThresholdV1Null(){
     this.set(S_ThresholdV1,null);
  }

  public double getThresholdV1(){
        return DataType.getAsDouble(this.get(S_ThresholdV1));
  
  }
  public double getThresholdV1InitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_ThresholdV1));
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

  public void initPPromt(double value){
     this.initProperty(S_PPromt,new Double(value));
  }
  public  void setPPromt(double value){
     this.set(S_PPromt,new Double(value));
  }
  public  void setPPromtNull(){
     this.set(S_PPromt,null);
  }

  public double getPPromt(){
        return DataType.getAsDouble(this.get(S_PPromt));
  
  }
  public double getPPromtInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PPromt));
      }

  public void initPTerm(double value){
     this.initProperty(S_PTerm,new Double(value));
  }
  public  void setPTerm(double value){
     this.set(S_PTerm,new Double(value));
  }
  public  void setPTermNull(){
     this.set(S_PTerm,null);
  }

  public double getPTerm(){
        return DataType.getAsDouble(this.get(S_PTerm));
  
  }
  public double getPTermInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PTerm));
      }

  public void initQuarterS(String value){
     this.initProperty(S_QuarterS,value);
  }
  public  void setQuarterS(String value){
     this.set(S_QuarterS,value);
  }
  public  void setQuarterSNull(){
     this.set(S_QuarterS,null);
  }

  public String getQuarterS(){
       return DataType.getAsString(this.get(S_QuarterS));
  
  }
  public String getQuarterSInitialValue(){
        return DataType.getAsString(this.getOldObj(S_QuarterS));
      }

  public void initLPromt(double value){
     this.initProperty(S_LPromt,new Double(value));
  }
  public  void setLPromt(double value){
     this.set(S_LPromt,new Double(value));
  }
  public  void setLPromtNull(){
     this.set(S_LPromt,null);
  }

  public double getLPromt(){
        return DataType.getAsDouble(this.get(S_LPromt));
  
  }
  public double getLPromtInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_LPromt));
      }

  public void initYearS(String value){
     this.initProperty(S_YearS,value);
  }
  public  void setYearS(String value){
     this.set(S_YearS,value);
  }
  public  void setYearSNull(){
     this.set(S_YearS,null);
  }

  public String getYearS(){
       return DataType.getAsString(this.get(S_YearS));
  
  }
  public String getYearSInitialValue(){
        return DataType.getAsString(this.getOldObj(S_YearS));
      }


 
 }

