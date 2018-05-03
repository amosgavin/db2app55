package com.asiainfo.charge.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.charge.ivalues.*;

public class BOChargeConcessInfoBean extends DataContainer implements DataContainerInterface,IBOChargeConcessInfoValue{

  private static String  m_boName = "com.asiainfo.charge.bo.BOChargeConcessInfo";



  public final static  String S_ConcessType = "CONCESS_TYPE";
  public final static  String S_BusiType = "BUSI_TYPE";
  public final static  String S_Remark = "REMARK";
  public final static  String S_Concessid = "CONCESSID";
  public final static  String S_ChargeType = "CHARGE_TYPE";
  public final static  String S_Mid = "MID";
  public final static  String S_DisRate = "DIS_RATE";
  public final static  String S_Fee = "FEE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOChargeConcessInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initConcessType(String value){
     this.initProperty(S_ConcessType,value);
  }
  public  void setConcessType(String value){
     this.set(S_ConcessType,value);
  }
  public  void setConcessTypeNull(){
     this.set(S_ConcessType,null);
  }

  public String getConcessType(){
       return DataType.getAsString(this.get(S_ConcessType));
  
  }
  public String getConcessTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ConcessType));
      }

  public void initBusiType(String value){
     this.initProperty(S_BusiType,value);
  }
  public  void setBusiType(String value){
     this.set(S_BusiType,value);
  }
  public  void setBusiTypeNull(){
     this.set(S_BusiType,null);
  }

  public String getBusiType(){
       return DataType.getAsString(this.get(S_BusiType));
  
  }
  public String getBusiTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BusiType));
      }

  public void initRemark(String value){
     this.initProperty(S_Remark,value);
  }
  public  void setRemark(String value){
     this.set(S_Remark,value);
  }
  public  void setRemarkNull(){
     this.set(S_Remark,null);
  }

  public String getRemark(){
       return DataType.getAsString(this.get(S_Remark));
  
  }
  public String getRemarkInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark));
      }

  public void initConcessid(int value){
     this.initProperty(S_Concessid,new Integer(value));
  }
  public  void setConcessid(int value){
     this.set(S_Concessid,new Integer(value));
  }
  public  void setConcessidNull(){
     this.set(S_Concessid,null);
  }

  public int getConcessid(){
        return DataType.getAsInt(this.get(S_Concessid));
  
  }
  public int getConcessidInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Concessid));
      }

  public void initChargeType(String value){
     this.initProperty(S_ChargeType,value);
  }
  public  void setChargeType(String value){
     this.set(S_ChargeType,value);
  }
  public  void setChargeTypeNull(){
     this.set(S_ChargeType,null);
  }

  public String getChargeType(){
       return DataType.getAsString(this.get(S_ChargeType));
  
  }
  public String getChargeTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ChargeType));
      }

  public void initMid(int value){
     this.initProperty(S_Mid,new Integer(value));
  }
  public  void setMid(int value){
     this.set(S_Mid,new Integer(value));
  }
  public  void setMidNull(){
     this.set(S_Mid,null);
  }

  public int getMid(){
        return DataType.getAsInt(this.get(S_Mid));
  
  }
  public int getMidInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Mid));
      }

  public void initDisRate(int value){
     this.initProperty(S_DisRate,new Integer(value));
  }
  public  void setDisRate(int value){
     this.set(S_DisRate,new Integer(value));
  }
  public  void setDisRateNull(){
     this.set(S_DisRate,null);
  }

  public int getDisRate(){
        return DataType.getAsInt(this.get(S_DisRate));
  
  }
  public int getDisRateInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_DisRate));
      }

  public void initFee(int value){
     this.initProperty(S_Fee,new Integer(value));
  }
  public  void setFee(int value){
     this.set(S_Fee,new Integer(value));
  }
  public  void setFeeNull(){
     this.set(S_Fee,null);
  }

  public int getFee(){
        return DataType.getAsInt(this.get(S_Fee));
  
  }
  public int getFeeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Fee));
      }


 
 }

