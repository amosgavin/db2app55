package com.asiainfo.costWarn.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.costWarn.ivalues.*;

public class BOSaleLevelSourceBean extends DataContainer implements DataContainerInterface,IBOSaleLevelSourceValue{

  private static String  m_boName = "com.asiainfo.costWarn.bo.BOSaleLevelSource";



  public final static  String S_ProSource = "PRO_SOURCE";
  public final static  String S_CityId = "CITY_ID";
  public final static  String S_PrePerson = "PRE_PERSON";
  public final static  String S_Person = "PERSON";
  public final static  String S_LevelCode = "LEVEL_CODE";
  public final static  String S_CityName = "CITY_NAME";
  public final static  String S_SaleName = "SALE_NAME";
  public final static  String S_LevelName = "LEVEL_NAME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOSaleLevelSourceBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initProSource(long value){
     this.initProperty(S_ProSource,new Long(value));
  }
  public  void setProSource(long value){
     this.set(S_ProSource,new Long(value));
  }
  public  void setProSourceNull(){
     this.set(S_ProSource,null);
  }

  public long getProSource(){
        return DataType.getAsLong(this.get(S_ProSource));
  
  }
  public long getProSourceInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ProSource));
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

  public void initPrePerson(long value){
     this.initProperty(S_PrePerson,new Long(value));
  }
  public  void setPrePerson(long value){
     this.set(S_PrePerson,new Long(value));
  }
  public  void setPrePersonNull(){
     this.set(S_PrePerson,null);
  }

  public long getPrePerson(){
        return DataType.getAsLong(this.get(S_PrePerson));
  
  }
  public long getPrePersonInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PrePerson));
      }

  public void initPerson(long value){
     this.initProperty(S_Person,new Long(value));
  }
  public  void setPerson(long value){
     this.set(S_Person,new Long(value));
  }
  public  void setPersonNull(){
     this.set(S_Person,null);
  }

  public long getPerson(){
        return DataType.getAsLong(this.get(S_Person));
  
  }
  public long getPersonInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Person));
      }

  public void initLevelCode(String value){
     this.initProperty(S_LevelCode,value);
  }
  public  void setLevelCode(String value){
     this.set(S_LevelCode,value);
  }
  public  void setLevelCodeNull(){
     this.set(S_LevelCode,null);
  }

  public String getLevelCode(){
       return DataType.getAsString(this.get(S_LevelCode));
  
  }
  public String getLevelCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_LevelCode));
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

  public void initSaleName(String value){
     this.initProperty(S_SaleName,value);
  }
  public  void setSaleName(String value){
     this.set(S_SaleName,value);
  }
  public  void setSaleNameNull(){
     this.set(S_SaleName,null);
  }

  public String getSaleName(){
       return DataType.getAsString(this.get(S_SaleName));
  
  }
  public String getSaleNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleName));
      }

  public void initLevelName(String value){
     this.initProperty(S_LevelName,value);
  }
  public  void setLevelName(String value){
     this.set(S_LevelName,value);
  }
  public  void setLevelNameNull(){
     this.set(S_LevelName,null);
  }

  public String getLevelName(){
       return DataType.getAsString(this.get(S_LevelName));
  
  }
  public String getLevelNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_LevelName));
      }


 
 }

