package com.asiainfo.charge.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.charge.ivalues.*;

public class BOChargeStaticSumShowBean extends DataContainer implements DataContainerInterface,IBOChargeStaticSumShowValue{

  private static String  m_boName = "com.asiainfo.charge.bo.BOChargeStaticSumShow";



  public final static  String S_BeforeChange = "BEFORE_CHANGE";
  public final static  String S_SwitchUser = "SWITCH_USER";
  public final static  String S_AfterChange = "AFTER_CHANGE";
  public final static  String S_Item = "ITEM";
  public final static  String S_SumChange = "SUM_CHANGE";
  public final static  String S_Fluctuate = "FLUCTUATE";
  public final static  String S_UserChange = "USER_CHANGE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOChargeStaticSumShowBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initBeforeChange(long value){
     this.initProperty(S_BeforeChange,new Long(value));
  }
  public  void setBeforeChange(long value){
     this.set(S_BeforeChange,new Long(value));
  }
  public  void setBeforeChangeNull(){
     this.set(S_BeforeChange,null);
  }

  public long getBeforeChange(){
        return DataType.getAsLong(this.get(S_BeforeChange));
  
  }
  public long getBeforeChangeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BeforeChange));
      }

  public void initSwitchUser(long value){
     this.initProperty(S_SwitchUser,new Long(value));
  }
  public  void setSwitchUser(long value){
     this.set(S_SwitchUser,new Long(value));
  }
  public  void setSwitchUserNull(){
     this.set(S_SwitchUser,null);
  }

  public long getSwitchUser(){
        return DataType.getAsLong(this.get(S_SwitchUser));
  
  }
  public long getSwitchUserInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SwitchUser));
      }

  public void initAfterChange(long value){
     this.initProperty(S_AfterChange,new Long(value));
  }
  public  void setAfterChange(long value){
     this.set(S_AfterChange,new Long(value));
  }
  public  void setAfterChangeNull(){
     this.set(S_AfterChange,null);
  }

  public long getAfterChange(){
        return DataType.getAsLong(this.get(S_AfterChange));
  
  }
  public long getAfterChangeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AfterChange));
      }

  public void initItem(String value){
     this.initProperty(S_Item,value);
  }
  public  void setItem(String value){
     this.set(S_Item,value);
  }
  public  void setItemNull(){
     this.set(S_Item,null);
  }

  public String getItem(){
       return DataType.getAsString(this.get(S_Item));
  
  }
  public String getItemInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Item));
      }

  public void initSumChange(long value){
     this.initProperty(S_SumChange,new Long(value));
  }
  public  void setSumChange(long value){
     this.set(S_SumChange,new Long(value));
  }
  public  void setSumChangeNull(){
     this.set(S_SumChange,null);
  }

  public long getSumChange(){
        return DataType.getAsLong(this.get(S_SumChange));
  
  }
  public long getSumChangeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SumChange));
      }

  public void initFluctuate(long value){
     this.initProperty(S_Fluctuate,new Long(value));
  }
  public  void setFluctuate(long value){
     this.set(S_Fluctuate,new Long(value));
  }
  public  void setFluctuateNull(){
     this.set(S_Fluctuate,null);
  }

  public long getFluctuate(){
        return DataType.getAsLong(this.get(S_Fluctuate));
  
  }
  public long getFluctuateInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Fluctuate));
      }

  public void initUserChange(long value){
     this.initProperty(S_UserChange,new Long(value));
  }
  public  void setUserChange(long value){
     this.set(S_UserChange,new Long(value));
  }
  public  void setUserChangeNull(){
     this.set(S_UserChange,null);
  }

  public long getUserChange(){
        return DataType.getAsLong(this.get(S_UserChange));
  
  }
  public long getUserChangeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_UserChange));
      }


 
 }

