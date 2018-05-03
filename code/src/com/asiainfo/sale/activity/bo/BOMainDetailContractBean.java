package com.asiainfo.sale.activity.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.activity.ivalues.*;

public class BOMainDetailContractBean extends DataContainer implements DataContainerInterface,IBOMainDetailContractValue{

  private static String  m_boName = "com.asiainfo.sale.activity.bo.BOMainDetailContract";



  public final static  String S_SaleMainName = "SALE_MAIN_NAME";
  public final static  String S_SaleActiveName = "SALE_ACTIVE_NAME";
  public final static  String S_IsContract = "IS_CONTRACT";
  public final static  String S_SaleMainCode = "SALE_MAIN_CODE";
  public final static  String S_SaleActiveCode = "SALE_ACTIVE_CODE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOMainDetailContractBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
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

  public void initIsContract(String value){
     this.initProperty(S_IsContract,value);
  }
  public  void setIsContract(String value){
     this.set(S_IsContract,value);
  }
  public  void setIsContractNull(){
     this.set(S_IsContract,null);
  }

  public String getIsContract(){
       return DataType.getAsString(this.get(S_IsContract));
  
  }
  public String getIsContractInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsContract));
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


 
 }

