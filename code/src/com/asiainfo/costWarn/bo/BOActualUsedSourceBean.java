package com.asiainfo.costWarn.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.costWarn.ivalues.*;

public class BOActualUsedSourceBean extends DataContainer implements DataContainerInterface,IBOActualUsedSourceValue{

  private static String  m_boName = "com.asiainfo.costWarn.bo.BOActualUsedSource";



  public final static  String S_JtZdUserCnt = "JT_ZD_USER_CNT";
  public final static  String S_Zdbt = "ZDBT";
  public final static  String S_CityId = "CITY_ID";
  public final static  String S_PreEndpoint = "PRE_ENDPOINT";
  public final static  String S_CityName = "CITY_NAME";
  public final static  String S_UsedSalebase = "USED_SALEBASE";
  public final static  String S_PreFee = "PRE_FEE";
  public final static  String S_UsedEndpoint = "USED_ENDPOINT";
  public final static  String S_UsedFee = "USED_FEE";
  public final static  String S_ProgressEndpoint = "PROGRESS_ENDPOINT";
  public final static  String S_ProgressFee = "PROGRESS_FEE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOActualUsedSourceBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initJtZdUserCnt(long value){
     this.initProperty(S_JtZdUserCnt,new Long(value));
  }
  public  void setJtZdUserCnt(long value){
     this.set(S_JtZdUserCnt,new Long(value));
  }
  public  void setJtZdUserCntNull(){
     this.set(S_JtZdUserCnt,null);
  }

  public long getJtZdUserCnt(){
        return DataType.getAsLong(this.get(S_JtZdUserCnt));
  
  }
  public long getJtZdUserCntInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_JtZdUserCnt));
      }

  public void initZdbt(double value){
     this.initProperty(S_Zdbt,new Double(value));
  }
  public  void setZdbt(double value){
     this.set(S_Zdbt,new Double(value));
  }
  public  void setZdbtNull(){
     this.set(S_Zdbt,null);
  }

  public double getZdbt(){
        return DataType.getAsDouble(this.get(S_Zdbt));
  
  }
  public double getZdbtInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_Zdbt));
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

  public void initPreEndpoint(String value){
     this.initProperty(S_PreEndpoint,value);
  }
  public  void setPreEndpoint(String value){
     this.set(S_PreEndpoint,value);
  }
  public  void setPreEndpointNull(){
     this.set(S_PreEndpoint,null);
  }

  public String getPreEndpoint(){
       return DataType.getAsString(this.get(S_PreEndpoint));
  
  }
  public String getPreEndpointInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PreEndpoint));
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

  public void initUsedSalebase(String value){
     this.initProperty(S_UsedSalebase,value);
  }
  public  void setUsedSalebase(String value){
     this.set(S_UsedSalebase,value);
  }
  public  void setUsedSalebaseNull(){
     this.set(S_UsedSalebase,null);
  }

  public String getUsedSalebase(){
       return DataType.getAsString(this.get(S_UsedSalebase));
  
  }
  public String getUsedSalebaseInitialValue(){
        return DataType.getAsString(this.getOldObj(S_UsedSalebase));
      }

  public void initPreFee(String value){
     this.initProperty(S_PreFee,value);
  }
  public  void setPreFee(String value){
     this.set(S_PreFee,value);
  }
  public  void setPreFeeNull(){
     this.set(S_PreFee,null);
  }

  public String getPreFee(){
       return DataType.getAsString(this.get(S_PreFee));
  
  }
  public String getPreFeeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PreFee));
      }

  public void initUsedEndpoint(String value){
     this.initProperty(S_UsedEndpoint,value);
  }
  public  void setUsedEndpoint(String value){
     this.set(S_UsedEndpoint,value);
  }
  public  void setUsedEndpointNull(){
     this.set(S_UsedEndpoint,null);
  }

  public String getUsedEndpoint(){
       return DataType.getAsString(this.get(S_UsedEndpoint));
  
  }
  public String getUsedEndpointInitialValue(){
        return DataType.getAsString(this.getOldObj(S_UsedEndpoint));
      }

  public void initUsedFee(String value){
     this.initProperty(S_UsedFee,value);
  }
  public  void setUsedFee(String value){
     this.set(S_UsedFee,value);
  }
  public  void setUsedFeeNull(){
     this.set(S_UsedFee,null);
  }

  public String getUsedFee(){
       return DataType.getAsString(this.get(S_UsedFee));
  
  }
  public String getUsedFeeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_UsedFee));
      }

  public void initProgressEndpoint(String value){
     this.initProperty(S_ProgressEndpoint,value);
  }
  public  void setProgressEndpoint(String value){
     this.set(S_ProgressEndpoint,value);
  }
  public  void setProgressEndpointNull(){
     this.set(S_ProgressEndpoint,null);
  }

  public String getProgressEndpoint(){
       return DataType.getAsString(this.get(S_ProgressEndpoint));
  
  }
  public String getProgressEndpointInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ProgressEndpoint));
      }

  public void initProgressFee(String value){
     this.initProperty(S_ProgressFee,value);
  }
  public  void setProgressFee(String value){
     this.set(S_ProgressFee,value);
  }
  public  void setProgressFeeNull(){
     this.set(S_ProgressFee,null);
  }

  public String getProgressFee(){
       return DataType.getAsString(this.get(S_ProgressFee));
  
  }
  public String getProgressFeeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ProgressFee));
      }


 
 }

