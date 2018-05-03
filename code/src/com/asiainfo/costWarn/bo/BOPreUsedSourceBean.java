package com.asiainfo.costWarn.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.costWarn.ivalues.*;

public class BOPreUsedSourceBean extends DataContainer implements DataContainerInterface,IBOPreUsedSourceValue{

  private static String  m_boName = "com.asiainfo.costWarn.bo.BOPreUsedSource";



  public final static  String S_PrePrefee = "PRE_PREFEE";
  public final static  String S_CityId = "CITY_ID";
  public final static  String S_ProgressPrefee = "PROGRESS_PREFEE";
  public final static  String S_CityName = "CITY_NAME";
  public final static  String S_UsedPrefee = "USED_PREFEE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOPreUsedSourceBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initPrePrefee(long value){
     this.initProperty(S_PrePrefee,new Long(value));
  }
  public  void setPrePrefee(long value){
     this.set(S_PrePrefee,new Long(value));
  }
  public  void setPrePrefeeNull(){
     this.set(S_PrePrefee,null);
  }

  public long getPrePrefee(){
        return DataType.getAsLong(this.get(S_PrePrefee));
  
  }
  public long getPrePrefeeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PrePrefee));
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

  public void initProgressPrefee(long value){
     this.initProperty(S_ProgressPrefee,new Long(value));
  }
  public  void setProgressPrefee(long value){
     this.set(S_ProgressPrefee,new Long(value));
  }
  public  void setProgressPrefeeNull(){
     this.set(S_ProgressPrefee,null);
  }

  public long getProgressPrefee(){
        return DataType.getAsLong(this.get(S_ProgressPrefee));
  
  }
  public long getProgressPrefeeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ProgressPrefee));
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

  public void initUsedPrefee(long value){
     this.initProperty(S_UsedPrefee,new Long(value));
  }
  public  void setUsedPrefee(long value){
     this.set(S_UsedPrefee,new Long(value));
  }
  public  void setUsedPrefeeNull(){
     this.set(S_UsedPrefee,null);
  }

  public long getUsedPrefee(){
        return DataType.getAsLong(this.get(S_UsedPrefee));
  
  }
  public long getUsedPrefeeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_UsedPrefee));
      }


 
 }

