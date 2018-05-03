package com.asiainfo.costWarn.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.costWarn.ivalues.*;

public class BOWarnResultBean extends DataContainer implements DataContainerInterface,IBOWarnResultValue{

  private static String  m_boName = "com.asiainfo.costWarn.bo.BOWarnResult";



  public final static  String S_Remark1 = "REMARK1";
  public final static  String S_CityCode = "CITY_CODE";
  public final static  String S_Remark2 = "REMARK2";
  public final static  String S_Remark3 = "REMARK3";
  public final static  String S_TerminalCost = "TERMINAL_COST";
  public final static  String S_Remark4 = "REMARK4";
  public final static  String S_SaleActiveName = "SALE_ACTIVE_NAME";
  public final static  String S_InsertTime = "INSERT_TIME";
  public final static  String S_PerPromoteScore = "PER_PROMOTE_SCORE";
  public final static  String S_SaleActiveCode = "SALE_ACTIVE_CODE";
  public final static  String S_IsDelete = "IS_DELETE";
  public final static  String S_PerActionOut = "PER_ACTION_OUT";
  public final static  String S_PerTerminalCost = "PER_TERMINAL_COST";
  public final static  String S_SaleMainName = "SALE_MAIN_NAME";
  public final static  String S_SalePoint = "SALE_POINT";
  public final static  String S_SaleMainCode = "SALE_MAIN_CODE";
  public final static  String S_ActionOut = "ACTION_OUT";
  public final static  String S_PromoteScore = "PROMOTE_SCORE";
  public final static  String S_PerSalePoint = "PER_SALE_POINT";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOWarnResultBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initRemark1(String value){
     this.initProperty(S_Remark1,value);
  }
  public  void setRemark1(String value){
     this.set(S_Remark1,value);
  }
  public  void setRemark1Null(){
     this.set(S_Remark1,null);
  }

  public String getRemark1(){
       return DataType.getAsString(this.get(S_Remark1));
  
  }
  public String getRemark1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark1));
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

  public void initRemark2(String value){
     this.initProperty(S_Remark2,value);
  }
  public  void setRemark2(String value){
     this.set(S_Remark2,value);
  }
  public  void setRemark2Null(){
     this.set(S_Remark2,null);
  }

  public String getRemark2(){
       return DataType.getAsString(this.get(S_Remark2));
  
  }
  public String getRemark2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark2));
      }

  public void initRemark3(String value){
     this.initProperty(S_Remark3,value);
  }
  public  void setRemark3(String value){
     this.set(S_Remark3,value);
  }
  public  void setRemark3Null(){
     this.set(S_Remark3,null);
  }

  public String getRemark3(){
       return DataType.getAsString(this.get(S_Remark3));
  
  }
  public String getRemark3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark3));
      }

  public void initTerminalCost(double value){
     this.initProperty(S_TerminalCost,new Double(value));
  }
  public  void setTerminalCost(double value){
     this.set(S_TerminalCost,new Double(value));
  }
  public  void setTerminalCostNull(){
     this.set(S_TerminalCost,null);
  }

  public double getTerminalCost(){
        return DataType.getAsDouble(this.get(S_TerminalCost));
  
  }
  public double getTerminalCostInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_TerminalCost));
      }

  public void initRemark4(String value){
     this.initProperty(S_Remark4,value);
  }
  public  void setRemark4(String value){
     this.set(S_Remark4,value);
  }
  public  void setRemark4Null(){
     this.set(S_Remark4,null);
  }

  public String getRemark4(){
       return DataType.getAsString(this.get(S_Remark4));
  
  }
  public String getRemark4InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark4));
      }

  public void initSaleActiveName(String value){
     this.initProperty(S_SaleActiveName,value);
  }
  public  void setSaleActiveName(String value){
     this.set(S_SaleActiveName,value);
  }
  public  void setSaleActiveNameNull(){
     this.set(S_SaleActiveName,null);
  }

  public String getSaleActiveName(){
       return DataType.getAsString(this.get(S_SaleActiveName));
  
  }
  public String getSaleActiveNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleActiveName));
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

  public void initPerPromoteScore(double value){
     this.initProperty(S_PerPromoteScore,new Double(value));
  }
  public  void setPerPromoteScore(double value){
     this.set(S_PerPromoteScore,new Double(value));
  }
  public  void setPerPromoteScoreNull(){
     this.set(S_PerPromoteScore,null);
  }

  public double getPerPromoteScore(){
        return DataType.getAsDouble(this.get(S_PerPromoteScore));
  
  }
  public double getPerPromoteScoreInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PerPromoteScore));
      }

  public void initSaleActiveCode(String value){
     this.initProperty(S_SaleActiveCode,value);
  }
  public  void setSaleActiveCode(String value){
     this.set(S_SaleActiveCode,value);
  }
  public  void setSaleActiveCodeNull(){
     this.set(S_SaleActiveCode,null);
  }

  public String getSaleActiveCode(){
       return DataType.getAsString(this.get(S_SaleActiveCode));
  
  }
  public String getSaleActiveCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleActiveCode));
      }

  public void initIsDelete(String value){
     this.initProperty(S_IsDelete,value);
  }
  public  void setIsDelete(String value){
     this.set(S_IsDelete,value);
  }
  public  void setIsDeleteNull(){
     this.set(S_IsDelete,null);
  }

  public String getIsDelete(){
       return DataType.getAsString(this.get(S_IsDelete));
  
  }
  public String getIsDeleteInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsDelete));
      }

  public void initPerActionOut(double value){
     this.initProperty(S_PerActionOut,new Double(value));
  }
  public  void setPerActionOut(double value){
     this.set(S_PerActionOut,new Double(value));
  }
  public  void setPerActionOutNull(){
     this.set(S_PerActionOut,null);
  }

  public double getPerActionOut(){
        return DataType.getAsDouble(this.get(S_PerActionOut));
  
  }
  public double getPerActionOutInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PerActionOut));
      }

  public void initPerTerminalCost(double value){
     this.initProperty(S_PerTerminalCost,new Double(value));
  }
  public  void setPerTerminalCost(double value){
     this.set(S_PerTerminalCost,new Double(value));
  }
  public  void setPerTerminalCostNull(){
     this.set(S_PerTerminalCost,null);
  }

  public double getPerTerminalCost(){
        return DataType.getAsDouble(this.get(S_PerTerminalCost));
  
  }
  public double getPerTerminalCostInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PerTerminalCost));
      }

  public void initSaleMainName(String value){
     this.initProperty(S_SaleMainName,value);
  }
  public  void setSaleMainName(String value){
     this.set(S_SaleMainName,value);
  }
  public  void setSaleMainNameNull(){
     this.set(S_SaleMainName,null);
  }

  public String getSaleMainName(){
       return DataType.getAsString(this.get(S_SaleMainName));
  
  }
  public String getSaleMainNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleMainName));
      }

  public void initSalePoint(double value){
     this.initProperty(S_SalePoint,new Double(value));
  }
  public  void setSalePoint(double value){
     this.set(S_SalePoint,new Double(value));
  }
  public  void setSalePointNull(){
     this.set(S_SalePoint,null);
  }

  public double getSalePoint(){
        return DataType.getAsDouble(this.get(S_SalePoint));
  
  }
  public double getSalePointInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_SalePoint));
      }

  public void initSaleMainCode(String value){
     this.initProperty(S_SaleMainCode,value);
  }
  public  void setSaleMainCode(String value){
     this.set(S_SaleMainCode,value);
  }
  public  void setSaleMainCodeNull(){
     this.set(S_SaleMainCode,null);
  }

  public String getSaleMainCode(){
       return DataType.getAsString(this.get(S_SaleMainCode));
  
  }
  public String getSaleMainCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SaleMainCode));
      }

  public void initActionOut(double value){
     this.initProperty(S_ActionOut,new Double(value));
  }
  public  void setActionOut(double value){
     this.set(S_ActionOut,new Double(value));
  }
  public  void setActionOutNull(){
     this.set(S_ActionOut,null);
  }

  public double getActionOut(){
        return DataType.getAsDouble(this.get(S_ActionOut));
  
  }
  public double getActionOutInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_ActionOut));
      }

  public void initPromoteScore(double value){
     this.initProperty(S_PromoteScore,new Double(value));
  }
  public  void setPromoteScore(double value){
     this.set(S_PromoteScore,new Double(value));
  }
  public  void setPromoteScoreNull(){
     this.set(S_PromoteScore,null);
  }

  public double getPromoteScore(){
        return DataType.getAsDouble(this.get(S_PromoteScore));
  
  }
  public double getPromoteScoreInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PromoteScore));
      }

  public void initPerSalePoint(double value){
     this.initProperty(S_PerSalePoint,new Double(value));
  }
  public  void setPerSalePoint(double value){
     this.set(S_PerSalePoint,new Double(value));
  }
  public  void setPerSalePointNull(){
     this.set(S_PerSalePoint,null);
  }

  public double getPerSalePoint(){
        return DataType.getAsDouble(this.get(S_PerSalePoint));
  
  }
  public double getPerSalePointInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PerSalePoint));
      }


 
 }

