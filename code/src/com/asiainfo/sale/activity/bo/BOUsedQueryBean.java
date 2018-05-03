package com.asiainfo.sale.activity.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.activity.ivalues.*;

public class BOUsedQueryBean extends DataContainer implements DataContainerInterface,IBOUsedQueryValue{

  private static String  m_boName = "com.asiainfo.sale.activity.bo.BOUsedQuery";



  public final static  String S_ActionOutYearPer = "ACTION_OUT_YEAR_PER";
  public final static  String S_CityCode = "CITY_CODE";
  public final static  String S_TerminalCostYearPer = "TERMINAL_COST_YEAR_PER";
  public final static  String S_CxpCostYear = "CXP_COST_YEAR";
  public final static  String S_CxpCostYearPer = "CXP_COST_YEAR_PER";
  public final static  String S_JfDzqCostYearPer = "JF_DZQ_COST_YEAR_PER";
  public final static  String S_Createorg = "CREATEORG";
  public final static  String S_TerminalCostYear = "TERMINAL_COST_YEAR";
  public final static  String S_ActionOutYear = "ACTION_OUT_YEAR";
  public final static  String S_FjfDzqCostYear = "FJF_DZQ_COST_YEAR";
  public final static  String S_FjfDzqCostYearPer = "FJF_DZQ_COST_YEAR_PER";
  public final static  String S_PrivsetidName = "PRIVSETID_NAME";
  public final static  String S_JfDzqCostYear = "JF_DZQ_COST_YEAR";
  public final static  String S_UserNum = "USER_NUM";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOUsedQueryBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initActionOutYearPer(long value){
     this.initProperty(S_ActionOutYearPer,new Long(value));
  }
  public  void setActionOutYearPer(long value){
     this.set(S_ActionOutYearPer,new Long(value));
  }
  public  void setActionOutYearPerNull(){
     this.set(S_ActionOutYearPer,null);
  }

  public long getActionOutYearPer(){
        return DataType.getAsLong(this.get(S_ActionOutYearPer));
  
  }
  public long getActionOutYearPerInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ActionOutYearPer));
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

  public void initTerminalCostYearPer(long value){
     this.initProperty(S_TerminalCostYearPer,new Long(value));
  }
  public  void setTerminalCostYearPer(long value){
     this.set(S_TerminalCostYearPer,new Long(value));
  }
  public  void setTerminalCostYearPerNull(){
     this.set(S_TerminalCostYearPer,null);
  }

  public long getTerminalCostYearPer(){
        return DataType.getAsLong(this.get(S_TerminalCostYearPer));
  
  }
  public long getTerminalCostYearPerInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TerminalCostYearPer));
      }

  public void initCxpCostYear(long value){
     this.initProperty(S_CxpCostYear,new Long(value));
  }
  public  void setCxpCostYear(long value){
     this.set(S_CxpCostYear,new Long(value));
  }
  public  void setCxpCostYearNull(){
     this.set(S_CxpCostYear,null);
  }

  public long getCxpCostYear(){
        return DataType.getAsLong(this.get(S_CxpCostYear));
  
  }
  public long getCxpCostYearInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_CxpCostYear));
      }

  public void initCxpCostYearPer(long value){
     this.initProperty(S_CxpCostYearPer,new Long(value));
  }
  public  void setCxpCostYearPer(long value){
     this.set(S_CxpCostYearPer,new Long(value));
  }
  public  void setCxpCostYearPerNull(){
     this.set(S_CxpCostYearPer,null);
  }

  public long getCxpCostYearPer(){
        return DataType.getAsLong(this.get(S_CxpCostYearPer));
  
  }
  public long getCxpCostYearPerInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_CxpCostYearPer));
      }

  public void initJfDzqCostYearPer(long value){
     this.initProperty(S_JfDzqCostYearPer,new Long(value));
  }
  public  void setJfDzqCostYearPer(long value){
     this.set(S_JfDzqCostYearPer,new Long(value));
  }
  public  void setJfDzqCostYearPerNull(){
     this.set(S_JfDzqCostYearPer,null);
  }

  public long getJfDzqCostYearPer(){
        return DataType.getAsLong(this.get(S_JfDzqCostYearPer));
  
  }
  public long getJfDzqCostYearPerInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_JfDzqCostYearPer));
      }

  public void initCreateorg(String value){
     this.initProperty(S_Createorg,value);
  }
  public  void setCreateorg(String value){
     this.set(S_Createorg,value);
  }
  public  void setCreateorgNull(){
     this.set(S_Createorg,null);
  }

  public String getCreateorg(){
       return DataType.getAsString(this.get(S_Createorg));
  
  }
  public String getCreateorgInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Createorg));
      }

  public void initTerminalCostYear(long value){
     this.initProperty(S_TerminalCostYear,new Long(value));
  }
  public  void setTerminalCostYear(long value){
     this.set(S_TerminalCostYear,new Long(value));
  }
  public  void setTerminalCostYearNull(){
     this.set(S_TerminalCostYear,null);
  }

  public long getTerminalCostYear(){
        return DataType.getAsLong(this.get(S_TerminalCostYear));
  
  }
  public long getTerminalCostYearInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TerminalCostYear));
      }

  public void initActionOutYear(long value){
     this.initProperty(S_ActionOutYear,new Long(value));
  }
  public  void setActionOutYear(long value){
     this.set(S_ActionOutYear,new Long(value));
  }
  public  void setActionOutYearNull(){
     this.set(S_ActionOutYear,null);
  }

  public long getActionOutYear(){
        return DataType.getAsLong(this.get(S_ActionOutYear));
  
  }
  public long getActionOutYearInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ActionOutYear));
      }

  public void initFjfDzqCostYear(long value){
     this.initProperty(S_FjfDzqCostYear,new Long(value));
  }
  public  void setFjfDzqCostYear(long value){
     this.set(S_FjfDzqCostYear,new Long(value));
  }
  public  void setFjfDzqCostYearNull(){
     this.set(S_FjfDzqCostYear,null);
  }

  public long getFjfDzqCostYear(){
        return DataType.getAsLong(this.get(S_FjfDzqCostYear));
  
  }
  public long getFjfDzqCostYearInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_FjfDzqCostYear));
      }

  public void initFjfDzqCostYearPer(long value){
     this.initProperty(S_FjfDzqCostYearPer,new Long(value));
  }
  public  void setFjfDzqCostYearPer(long value){
     this.set(S_FjfDzqCostYearPer,new Long(value));
  }
  public  void setFjfDzqCostYearPerNull(){
     this.set(S_FjfDzqCostYearPer,null);
  }

  public long getFjfDzqCostYearPer(){
        return DataType.getAsLong(this.get(S_FjfDzqCostYearPer));
  
  }
  public long getFjfDzqCostYearPerInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_FjfDzqCostYearPer));
      }

  public void initPrivsetidName(String value){
     this.initProperty(S_PrivsetidName,value);
  }
  public  void setPrivsetidName(String value){
     this.set(S_PrivsetidName,value);
  }
  public  void setPrivsetidNameNull(){
     this.set(S_PrivsetidName,null);
  }

  public String getPrivsetidName(){
       return DataType.getAsString(this.get(S_PrivsetidName));
  
  }
  public String getPrivsetidNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PrivsetidName));
      }

  public void initJfDzqCostYear(long value){
     this.initProperty(S_JfDzqCostYear,new Long(value));
  }
  public  void setJfDzqCostYear(long value){
     this.set(S_JfDzqCostYear,new Long(value));
  }
  public  void setJfDzqCostYearNull(){
     this.set(S_JfDzqCostYear,null);
  }

  public long getJfDzqCostYear(){
        return DataType.getAsLong(this.get(S_JfDzqCostYear));
  
  }
  public long getJfDzqCostYearInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_JfDzqCostYear));
      }

  public void initUserNum(long value){
     this.initProperty(S_UserNum,new Long(value));
  }
  public  void setUserNum(long value){
     this.set(S_UserNum,new Long(value));
  }
  public  void setUserNumNull(){
     this.set(S_UserNum,null);
  }

  public long getUserNum(){
        return DataType.getAsLong(this.get(S_UserNum));
  
  }
  public long getUserNumInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_UserNum));
      }


 
 }

