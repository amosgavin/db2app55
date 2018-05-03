package com.asiainfo.bi.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.bi.ivalues.*;

public class BOTaskDurationBean extends DataContainer implements DataContainerInterface,IBOTaskDurationValue{

  private static String  m_boName = "com.asiainfo.bi.bo.BOTaskDuration";



  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_AvgTime1 = "AVG_TIME1";
  public final static  String S_AvgTime5 = "AVG_TIME5";
  public final static  String S_AvgTime4 = "AVG_TIME4";
  public final static  String S_AvgTime3 = "AVG_TIME3";
  public final static  String S_AvgTime2 = "AVG_TIME2";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOTaskDurationBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initRegionId(String value){
     this.initProperty(S_RegionId,value);
  }
  public  void setRegionId(String value){
     this.set(S_RegionId,value);
  }
  public  void setRegionIdNull(){
     this.set(S_RegionId,null);
  }

  public String getRegionId(){
       return DataType.getAsString(this.get(S_RegionId));
  
  }
  public String getRegionIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RegionId));
      }

  public void initAvgTime1(double value){
     this.initProperty(S_AvgTime1,new Double(value));
  }
  public  void setAvgTime1(double value){
     this.set(S_AvgTime1,new Double(value));
  }
  public  void setAvgTime1Null(){
     this.set(S_AvgTime1,null);
  }

  public double getAvgTime1(){
        return DataType.getAsDouble(this.get(S_AvgTime1));
  
  }
  public double getAvgTime1InitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_AvgTime1));
      }

  public void initAvgTime5(double value){
     this.initProperty(S_AvgTime5,new Double(value));
  }
  public  void setAvgTime5(double value){
     this.set(S_AvgTime5,new Double(value));
  }
  public  void setAvgTime5Null(){
     this.set(S_AvgTime5,null);
  }

  public double getAvgTime5(){
        return DataType.getAsDouble(this.get(S_AvgTime5));
  
  }
  public double getAvgTime5InitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_AvgTime5));
      }

  public void initAvgTime4(double value){
     this.initProperty(S_AvgTime4,new Double(value));
  }
  public  void setAvgTime4(double value){
     this.set(S_AvgTime4,new Double(value));
  }
  public  void setAvgTime4Null(){
     this.set(S_AvgTime4,null);
  }

  public double getAvgTime4(){
        return DataType.getAsDouble(this.get(S_AvgTime4));
  
  }
  public double getAvgTime4InitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_AvgTime4));
      }

  public void initAvgTime3(double value){
     this.initProperty(S_AvgTime3,new Double(value));
  }
  public  void setAvgTime3(double value){
     this.set(S_AvgTime3,new Double(value));
  }
  public  void setAvgTime3Null(){
     this.set(S_AvgTime3,null);
  }

  public double getAvgTime3(){
        return DataType.getAsDouble(this.get(S_AvgTime3));
  
  }
  public double getAvgTime3InitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_AvgTime3));
      }

  public void initAvgTime2(double value){
     this.initProperty(S_AvgTime2,new Double(value));
  }
  public  void setAvgTime2(double value){
     this.set(S_AvgTime2,new Double(value));
  }
  public  void setAvgTime2Null(){
     this.set(S_AvgTime2,null);
  }

  public double getAvgTime2(){
        return DataType.getAsDouble(this.get(S_AvgTime2));
  
  }
  public double getAvgTime2InitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_AvgTime2));
      }


 
 }

