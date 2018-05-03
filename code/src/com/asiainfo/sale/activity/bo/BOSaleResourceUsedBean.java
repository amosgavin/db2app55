package com.asiainfo.sale.activity.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.activity.ivalues.*;

public class BOSaleResourceUsedBean extends DataContainer implements DataContainerInterface,IBOSaleResourceUsedValue{

  private static String  m_boName = "com.asiainfo.sale.activity.bo.BOSaleResourceUsed";



  public final static  String S_PFjfUsed = "P_FJF_USED";
  public final static  String S_LTermUsed = "L_TERM_USED";
  public final static  String S_LJfUsed = "L_JF_USED";
  public final static  String S_LFjfUsed = "L_FJF_USED";
  public final static  String S_PJfUsed = "P_JF_USED";
  public final static  String S_PTermUsed = "P_TERM_USED";
  public final static  String S_CityName = "CITY_NAME";
  public final static  String S_PPromtUsed = "P_PROMT_USED";
  public final static  String S_LPromtUsed = "L_PROMT_USED";
  public final static  String S_LDiscUsed = "L_DISC_USED";
  public final static  String S_PDiscUsed = "P_DISC_USED";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOSaleResourceUsedBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initPFjfUsed(long value){
     this.initProperty(S_PFjfUsed,new Long(value));
  }
  public  void setPFjfUsed(long value){
     this.set(S_PFjfUsed,new Long(value));
  }
  public  void setPFjfUsedNull(){
     this.set(S_PFjfUsed,null);
  }

  public long getPFjfUsed(){
        return DataType.getAsLong(this.get(S_PFjfUsed));
  
  }
  public long getPFjfUsedInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PFjfUsed));
      }

  public void initLTermUsed(long value){
     this.initProperty(S_LTermUsed,new Long(value));
  }
  public  void setLTermUsed(long value){
     this.set(S_LTermUsed,new Long(value));
  }
  public  void setLTermUsedNull(){
     this.set(S_LTermUsed,null);
  }

  public long getLTermUsed(){
        return DataType.getAsLong(this.get(S_LTermUsed));
  
  }
  public long getLTermUsedInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_LTermUsed));
      }

  public void initLJfUsed(long value){
     this.initProperty(S_LJfUsed,new Long(value));
  }
  public  void setLJfUsed(long value){
     this.set(S_LJfUsed,new Long(value));
  }
  public  void setLJfUsedNull(){
     this.set(S_LJfUsed,null);
  }

  public long getLJfUsed(){
        return DataType.getAsLong(this.get(S_LJfUsed));
  
  }
  public long getLJfUsedInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_LJfUsed));
      }

  public void initLFjfUsed(long value){
     this.initProperty(S_LFjfUsed,new Long(value));
  }
  public  void setLFjfUsed(long value){
     this.set(S_LFjfUsed,new Long(value));
  }
  public  void setLFjfUsedNull(){
     this.set(S_LFjfUsed,null);
  }

  public long getLFjfUsed(){
        return DataType.getAsLong(this.get(S_LFjfUsed));
  
  }
  public long getLFjfUsedInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_LFjfUsed));
      }

  public void initPJfUsed(long value){
     this.initProperty(S_PJfUsed,new Long(value));
  }
  public  void setPJfUsed(long value){
     this.set(S_PJfUsed,new Long(value));
  }
  public  void setPJfUsedNull(){
     this.set(S_PJfUsed,null);
  }

  public long getPJfUsed(){
        return DataType.getAsLong(this.get(S_PJfUsed));
  
  }
  public long getPJfUsedInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PJfUsed));
      }

  public void initPTermUsed(long value){
     this.initProperty(S_PTermUsed,new Long(value));
  }
  public  void setPTermUsed(long value){
     this.set(S_PTermUsed,new Long(value));
  }
  public  void setPTermUsedNull(){
     this.set(S_PTermUsed,null);
  }

  public long getPTermUsed(){
        return DataType.getAsLong(this.get(S_PTermUsed));
  
  }
  public long getPTermUsedInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PTermUsed));
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

  public void initPPromtUsed(long value){
     this.initProperty(S_PPromtUsed,new Long(value));
  }
  public  void setPPromtUsed(long value){
     this.set(S_PPromtUsed,new Long(value));
  }
  public  void setPPromtUsedNull(){
     this.set(S_PPromtUsed,null);
  }

  public long getPPromtUsed(){
        return DataType.getAsLong(this.get(S_PPromtUsed));
  
  }
  public long getPPromtUsedInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PPromtUsed));
      }

  public void initLPromtUsed(long value){
     this.initProperty(S_LPromtUsed,new Long(value));
  }
  public  void setLPromtUsed(long value){
     this.set(S_LPromtUsed,new Long(value));
  }
  public  void setLPromtUsedNull(){
     this.set(S_LPromtUsed,null);
  }

  public long getLPromtUsed(){
        return DataType.getAsLong(this.get(S_LPromtUsed));
  
  }
  public long getLPromtUsedInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_LPromtUsed));
      }

  public void initLDiscUsed(long value){
     this.initProperty(S_LDiscUsed,new Long(value));
  }
  public  void setLDiscUsed(long value){
     this.set(S_LDiscUsed,new Long(value));
  }
  public  void setLDiscUsedNull(){
     this.set(S_LDiscUsed,null);
  }

  public long getLDiscUsed(){
        return DataType.getAsLong(this.get(S_LDiscUsed));
  
  }
  public long getLDiscUsedInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_LDiscUsed));
      }

  public void initPDiscUsed(long value){
     this.initProperty(S_PDiscUsed,new Long(value));
  }
  public  void setPDiscUsed(long value){
     this.set(S_PDiscUsed,new Long(value));
  }
  public  void setPDiscUsedNull(){
     this.set(S_PDiscUsed,null);
  }

  public long getPDiscUsed(){
        return DataType.getAsLong(this.get(S_PDiscUsed));
  
  }
  public long getPDiscUsedInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PDiscUsed));
      }


 
 }

