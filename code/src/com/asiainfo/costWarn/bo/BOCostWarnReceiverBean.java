package com.asiainfo.costWarn.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.costWarn.ivalues.*;

public class BOCostWarnReceiverBean extends DataContainer implements DataContainerInterface,IBOCostWarnReceiverValue{

  private static String  m_boName = "com.asiainfo.costWarn.bo.BOCostWarnReceiver";



  public final static  String S_CityId = "CITY_ID";
  public final static  String S_Reserve5 = "RESERVE5";
  public final static  String S_Grade = "GRADE";
  public final static  String S_Reserve4 = "RESERVE4";
  public final static  String S_Target = "TARGET";
  public final static  String S_PersonId = "PERSON_ID";
  public final static  String S_Reserve1 = "RESERVE1";
  public final static  String S_LevelId = "LEVEL_ID";
  public final static  String S_Reserve3 = "RESERVE3";
  public final static  String S_Email = "EMAIL";
  public final static  String S_BillId = "BILL_ID";
  public final static  String S_Reserve2 = "RESERVE2";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOCostWarnReceiverBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initCityId(int value){
     this.initProperty(S_CityId,new Integer(value));
  }
  public  void setCityId(int value){
     this.set(S_CityId,new Integer(value));
  }
  public  void setCityIdNull(){
     this.set(S_CityId,null);
  }

  public int getCityId(){
        return DataType.getAsInt(this.get(S_CityId));
  
  }
  public int getCityIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_CityId));
      }

  public void initReserve5(String value){
     this.initProperty(S_Reserve5,value);
  }
  public  void setReserve5(String value){
     this.set(S_Reserve5,value);
  }
  public  void setReserve5Null(){
     this.set(S_Reserve5,null);
  }

  public String getReserve5(){
       return DataType.getAsString(this.get(S_Reserve5));
  
  }
  public String getReserve5InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Reserve5));
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

  public void initPersonId(int value){
     this.initProperty(S_PersonId,new Integer(value));
  }
  public  void setPersonId(int value){
     this.set(S_PersonId,new Integer(value));
  }
  public  void setPersonIdNull(){
     this.set(S_PersonId,null);
  }

  public int getPersonId(){
        return DataType.getAsInt(this.get(S_PersonId));
  
  }
  public int getPersonIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_PersonId));
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

  public void initBillId(long value){
     this.initProperty(S_BillId,new Long(value));
  }
  public  void setBillId(long value){
     this.set(S_BillId,new Long(value));
  }
  public  void setBillIdNull(){
     this.set(S_BillId,null);
  }

  public long getBillId(){
        return DataType.getAsLong(this.get(S_BillId));
  
  }
  public long getBillIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BillId));
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

