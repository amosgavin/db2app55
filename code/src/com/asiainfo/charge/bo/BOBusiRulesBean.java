package com.asiainfo.charge.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.charge.ivalues.*;

public class BOBusiRulesBean extends DataContainer implements DataContainerInterface,IBOBusiRulesValue{

  private static String  m_boName = "com.asiainfo.charge.bo.BOBusiRules";



  public final static  String S_OverlappedPackage = "OVERLAPPED_PACKAGE";
  public final static  String S_Id = "ID";
  public final static  String S_EffectiveRules = "EFFECTIVE_RULES";
  public final static  String S_BillingRules = "BILLING_RULES";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOBusiRulesBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initOverlappedPackage(String value){
     this.initProperty(S_OverlappedPackage,value);
  }
  public  void setOverlappedPackage(String value){
     this.set(S_OverlappedPackage,value);
  }
  public  void setOverlappedPackageNull(){
     this.set(S_OverlappedPackage,null);
  }

  public String getOverlappedPackage(){
       return DataType.getAsString(this.get(S_OverlappedPackage));
  
  }
  public String getOverlappedPackageInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OverlappedPackage));
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

  public void initEffectiveRules(String value){
     this.initProperty(S_EffectiveRules,value);
  }
  public  void setEffectiveRules(String value){
     this.set(S_EffectiveRules,value);
  }
  public  void setEffectiveRulesNull(){
     this.set(S_EffectiveRules,null);
  }

  public String getEffectiveRules(){
       return DataType.getAsString(this.get(S_EffectiveRules));
  
  }
  public String getEffectiveRulesInitialValue(){
        return DataType.getAsString(this.getOldObj(S_EffectiveRules));
      }

  public void initBillingRules(String value){
     this.initProperty(S_BillingRules,value);
  }
  public  void setBillingRules(String value){
     this.set(S_BillingRules,value);
  }
  public  void setBillingRulesNull(){
     this.set(S_BillingRules,null);
  }

  public String getBillingRules(){
       return DataType.getAsString(this.get(S_BillingRules));
  
  }
  public String getBillingRulesInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BillingRules));
      }


 
 }

