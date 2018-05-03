package com.asiainfo.costWarn.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.costWarn.ivalues.*;

public class BOSendWarnLogBean extends DataContainer implements DataContainerInterface,IBOSendWarnLogValue{

  private static String  m_boName = "com.asiainfo.costWarn.bo.BOSendWarnLog";



  public final static  String S_CityId = "CITY_ID";
  public final static  String S_Grade = "GRADE";
  public final static  String S_InsertTime = "INSERT_TIME";
  public final static  String S_Line1Value = "LINE1_VALUE";
  public final static  String S_Line3Value = "LINE3_VALUE";
  public final static  String S_Line2Values = "LINE2_VALUES";
  public final static  String S_LogId = "LOG_ID";
  public final static  String S_Content = "CONTENT";
  public final static  String S_Target = "TARGET";
  public final static  String S_Seserve4 = "SESERVE4";
  public final static  String S_Reserve1 = "RESERVE1";
  public final static  String S_LevelId = "LEVEL_ID";
  public final static  String S_Reserve3 = "RESERVE3";
  public final static  String S_BillId = "BILL_ID";
  public final static  String S_Email = "EMAIL";
  public final static  String S_Reserve2 = "RESERVE2";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOSendWarnLogBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
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

  public void initGrade(String value){
     this.initProperty(S_Grade,value);
  }
  public  void setGrade(String value){
     this.set(S_Grade,value);
  }
  public  void setGradeNull(){
     this.set(S_Grade,null);
  }

  public String getGrade(){
       return DataType.getAsString(this.get(S_Grade));
  
  }
  public String getGradeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Grade));
      }

  public void initInsertTime(Timestamp value){
     this.initProperty(S_InsertTime,value);
  }
  public  void setInsertTime(Timestamp value){
     this.set(S_InsertTime,value);
  }
  public  void setInsertTimeNull(){
     this.set(S_InsertTime,null);
  }

  public Timestamp getInsertTime(){
        return DataType.getAsDateTime(this.get(S_InsertTime));
  
  }
  public Timestamp getInsertTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_InsertTime));
      }

  public void initLine1Value(double value){
     this.initProperty(S_Line1Value,new Double(value));
  }
  public  void setLine1Value(double value){
     this.set(S_Line1Value,new Double(value));
  }
  public  void setLine1ValueNull(){
     this.set(S_Line1Value,null);
  }

  public double getLine1Value(){
        return DataType.getAsDouble(this.get(S_Line1Value));
  
  }
  public double getLine1ValueInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_Line1Value));
      }

  public void initLine3Value(double value){
     this.initProperty(S_Line3Value,new Double(value));
  }
  public  void setLine3Value(double value){
     this.set(S_Line3Value,new Double(value));
  }
  public  void setLine3ValueNull(){
     this.set(S_Line3Value,null);
  }

  public double getLine3Value(){
        return DataType.getAsDouble(this.get(S_Line3Value));
  
  }
  public double getLine3ValueInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_Line3Value));
      }

  public void initLine2Values(double value){
     this.initProperty(S_Line2Values,new Double(value));
  }
  public  void setLine2Values(double value){
     this.set(S_Line2Values,new Double(value));
  }
  public  void setLine2ValuesNull(){
     this.set(S_Line2Values,null);
  }

  public double getLine2Values(){
        return DataType.getAsDouble(this.get(S_Line2Values));
  
  }
  public double getLine2ValuesInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_Line2Values));
      }

  public void initLogId(int value){
     this.initProperty(S_LogId,new Integer(value));
  }
  public  void setLogId(int value){
     this.set(S_LogId,new Integer(value));
  }
  public  void setLogIdNull(){
     this.set(S_LogId,null);
  }

  public int getLogId(){
        return DataType.getAsInt(this.get(S_LogId));
  
  }
  public int getLogIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_LogId));
      }

  public void initContent(String value){
     this.initProperty(S_Content,value);
  }
  public  void setContent(String value){
     this.set(S_Content,value);
  }
  public  void setContentNull(){
     this.set(S_Content,null);
  }

  public String getContent(){
       return DataType.getAsString(this.get(S_Content));
  
  }
  public String getContentInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Content));
      }

  public void initTarget(String value){
     this.initProperty(S_Target,value);
  }
  public  void setTarget(String value){
     this.set(S_Target,value);
  }
  public  void setTargetNull(){
     this.set(S_Target,null);
  }

  public String getTarget(){
       return DataType.getAsString(this.get(S_Target));
  
  }
  public String getTargetInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Target));
      }

  public void initSeserve4(String value){
     this.initProperty(S_Seserve4,value);
  }
  public  void setSeserve4(String value){
     this.set(S_Seserve4,value);
  }
  public  void setSeserve4Null(){
     this.set(S_Seserve4,null);
  }

  public String getSeserve4(){
       return DataType.getAsString(this.get(S_Seserve4));
  
  }
  public String getSeserve4InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Seserve4));
      }

  public void initReserve1(String value){
     this.initProperty(S_Reserve1,value);
  }
  public  void setReserve1(String value){
     this.set(S_Reserve1,value);
  }
  public  void setReserve1Null(){
     this.set(S_Reserve1,null);
  }

  public String getReserve1(){
       return DataType.getAsString(this.get(S_Reserve1));
  
  }
  public String getReserve1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Reserve1));
      }

  public void initLevelId(String value){
     this.initProperty(S_LevelId,value);
  }
  public  void setLevelId(String value){
     this.set(S_LevelId,value);
  }
  public  void setLevelIdNull(){
     this.set(S_LevelId,null);
  }

  public String getLevelId(){
       return DataType.getAsString(this.get(S_LevelId));
  
  }
  public String getLevelIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_LevelId));
      }

  public void initReserve3(String value){
     this.initProperty(S_Reserve3,value);
  }
  public  void setReserve3(String value){
     this.set(S_Reserve3,value);
  }
  public  void setReserve3Null(){
     this.set(S_Reserve3,null);
  }

  public String getReserve3(){
       return DataType.getAsString(this.get(S_Reserve3));
  
  }
  public String getReserve3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Reserve3));
      }

  public void initBillId(String value){
     this.initProperty(S_BillId,value);
  }
  public  void setBillId(String value){
     this.set(S_BillId,value);
  }
  public  void setBillIdNull(){
     this.set(S_BillId,null);
  }

  public String getBillId(){
       return DataType.getAsString(this.get(S_BillId));
  
  }
  public String getBillIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BillId));
      }

  public void initEmail(String value){
     this.initProperty(S_Email,value);
  }
  public  void setEmail(String value){
     this.set(S_Email,value);
  }
  public  void setEmailNull(){
     this.set(S_Email,null);
  }

  public String getEmail(){
       return DataType.getAsString(this.get(S_Email));
  
  }
  public String getEmailInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Email));
      }

  public void initReserve2(String value){
     this.initProperty(S_Reserve2,value);
  }
  public  void setReserve2(String value){
     this.set(S_Reserve2,value);
  }
  public  void setReserve2Null(){
     this.set(S_Reserve2,null);
  }

  public String getReserve2(){
       return DataType.getAsString(this.get(S_Reserve2));
  
  }
  public String getReserve2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Reserve2));
      }


 
 }

