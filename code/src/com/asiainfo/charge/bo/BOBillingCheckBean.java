package com.asiainfo.charge.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.charge.ivalues.*;

public class BOBillingCheckBean extends DataContainer implements DataContainerInterface,IBOBillingCheckValue{

  private static String  m_boName = "com.asiainfo.charge.bo.BOBillingCheck";



  public final static  String S_BillingContent = "BILLING_CONTENT";
  public final static  String S_BillingSellingpoint = "BILLING_SELLINGPOINT";
  public final static  String S_Slogan = "SLOGAN";
  public final static  String S_SchemeName = "SCHEME_NAME";
  public final static  String S_Id = "ID";
  public final static  String S_ChargeId = "CHARGE_ID";
  public final static  String S_TargetMarket = "TARGET_MARKET";
  public final static  String S_CheckItem = "CHECK_ITEM";
  public final static  String S_Brand = "BRAND";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOBillingCheckBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initBillingContent(String value){
     this.initProperty(S_BillingContent,value);
  }
  public  void setBillingContent(String value){
     this.set(S_BillingContent,value);
  }
  public  void setBillingContentNull(){
     this.set(S_BillingContent,null);
  }

  public String getBillingContent(){
       return DataType.getAsString(this.get(S_BillingContent));
  
  }
  public String getBillingContentInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BillingContent));
      }

  public void initBillingSellingpoint(String value){
     this.initProperty(S_BillingSellingpoint,value);
  }
  public  void setBillingSellingpoint(String value){
     this.set(S_BillingSellingpoint,value);
  }
  public  void setBillingSellingpointNull(){
     this.set(S_BillingSellingpoint,null);
  }

  public String getBillingSellingpoint(){
       return DataType.getAsString(this.get(S_BillingSellingpoint));
  
  }
  public String getBillingSellingpointInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BillingSellingpoint));
      }

  public void initSlogan(String value){
     this.initProperty(S_Slogan,value);
  }
  public  void setSlogan(String value){
     this.set(S_Slogan,value);
  }
  public  void setSloganNull(){
     this.set(S_Slogan,null);
  }

  public String getSlogan(){
       return DataType.getAsString(this.get(S_Slogan));
  
  }
  public String getSloganInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Slogan));
      }

  public void initSchemeName(String value){
     this.initProperty(S_SchemeName,value);
  }
  public  void setSchemeName(String value){
     this.set(S_SchemeName,value);
  }
  public  void setSchemeNameNull(){
     this.set(S_SchemeName,null);
  }

  public String getSchemeName(){
       return DataType.getAsString(this.get(S_SchemeName));
  
  }
  public String getSchemeNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SchemeName));
      }

  public void initId(String value){
     this.initProperty(S_Id,value);
  }
  public  void setId(String value){
     this.set(S_Id,value);
  }
  public  void setIdNull(){
     this.set(S_Id,null);
  }

  public String getId(){
       return DataType.getAsString(this.get(S_Id));
  
  }
  public String getIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Id));
      }

  public void initChargeId(String value){
     this.initProperty(S_ChargeId,value);
  }
  public  void setChargeId(String value){
     this.set(S_ChargeId,value);
  }
  public  void setChargeIdNull(){
     this.set(S_ChargeId,null);
  }

  public String getChargeId(){
       return DataType.getAsString(this.get(S_ChargeId));
  
  }
  public String getChargeIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ChargeId));
      }

  public void initTargetMarket(String value){
     this.initProperty(S_TargetMarket,value);
  }
  public  void setTargetMarket(String value){
     this.set(S_TargetMarket,value);
  }
  public  void setTargetMarketNull(){
     this.set(S_TargetMarket,null);
  }

  public String getTargetMarket(){
       return DataType.getAsString(this.get(S_TargetMarket));
  
  }
  public String getTargetMarketInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TargetMarket));
      }

  public void initCheckItem(String value){
     this.initProperty(S_CheckItem,value);
  }
  public  void setCheckItem(String value){
     this.set(S_CheckItem,value);
  }
  public  void setCheckItemNull(){
     this.set(S_CheckItem,null);
  }

  public String getCheckItem(){
       return DataType.getAsString(this.get(S_CheckItem));
  
  }
  public String getCheckItemInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CheckItem));
      }

  public void initBrand(String value){
     this.initProperty(S_Brand,value);
  }
  public  void setBrand(String value){
     this.set(S_Brand,value);
  }
  public  void setBrandNull(){
     this.set(S_Brand,null);
  }

  public String getBrand(){
       return DataType.getAsString(this.get(S_Brand));
  
  }
  public String getBrandInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Brand));
      }


 
 }

