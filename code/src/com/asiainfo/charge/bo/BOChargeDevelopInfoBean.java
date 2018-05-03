package com.asiainfo.charge.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.charge.ivalues.*;

public class BOChargeDevelopInfoBean extends DataContainer implements DataContainerInterface,IBOChargeDevelopInfoValue{

  private static String  m_boName = "com.asiainfo.charge.bo.BOChargeDevelopInfo";



  public final static  String S_State = "STATE";
  public final static  String S_PlanDate = "PLAN_DATE";
  public final static  String S_Id = "ID";
  public final static  String S_ChargeId = "CHARGE_ID";
  public final static  String S_FinishDate = "FINISH_DATE";
  public final static  String S_Principal = "PRINCIPAL";
  public final static  String S_Code = "CODE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOChargeDevelopInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initState(String value){
     this.initProperty(S_State,value);
  }
  public  void setState(String value){
     this.set(S_State,value);
  }
  public  void setStateNull(){
     this.set(S_State,null);
  }

  public String getState(){
       return DataType.getAsString(this.get(S_State));
  
  }
  public String getStateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_State));
      }

  public void initPlanDate(Timestamp value){
     this.initProperty(S_PlanDate,value);
  }
  public  void setPlanDate(Timestamp value){
     this.set(S_PlanDate,value);
  }
  public  void setPlanDateNull(){
     this.set(S_PlanDate,null);
  }

  public Timestamp getPlanDate(){
        return DataType.getAsDateTime(this.get(S_PlanDate));
  
  }
  public Timestamp getPlanDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_PlanDate));
      }

  public void initId(int value){
     this.initProperty(S_Id,new Integer(value));
  }
  public  void setId(int value){
     this.set(S_Id,new Integer(value));
  }
  public  void setIdNull(){
     this.set(S_Id,null);
  }

  public int getId(){
        return DataType.getAsInt(this.get(S_Id));
  
  }
  public int getIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Id));
      }

  public void initChargeId(int value){
     this.initProperty(S_ChargeId,new Integer(value));
  }
  public  void setChargeId(int value){
     this.set(S_ChargeId,new Integer(value));
  }
  public  void setChargeIdNull(){
     this.set(S_ChargeId,null);
  }

  public int getChargeId(){
        return DataType.getAsInt(this.get(S_ChargeId));
  
  }
  public int getChargeIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_ChargeId));
      }

  public void initFinishDate(Timestamp value){
     this.initProperty(S_FinishDate,value);
  }
  public  void setFinishDate(Timestamp value){
     this.set(S_FinishDate,value);
  }
  public  void setFinishDateNull(){
     this.set(S_FinishDate,null);
  }

  public Timestamp getFinishDate(){
        return DataType.getAsDateTime(this.get(S_FinishDate));
  
  }
  public Timestamp getFinishDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_FinishDate));
      }

  public void initPrincipal(String value){
     this.initProperty(S_Principal,value);
  }
  public  void setPrincipal(String value){
     this.set(S_Principal,value);
  }
  public  void setPrincipalNull(){
     this.set(S_Principal,null);
  }

  public String getPrincipal(){
       return DataType.getAsString(this.get(S_Principal));
  
  }
  public String getPrincipalInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Principal));
      }

  public void initCode(String value){
     this.initProperty(S_Code,value);
  }
  public  void setCode(String value){
     this.set(S_Code,value);
  }
  public  void setCodeNull(){
     this.set(S_Code,null);
  }

  public String getCode(){
       return DataType.getAsString(this.get(S_Code));
  
  }
  public String getCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Code));
      }


 
 }

