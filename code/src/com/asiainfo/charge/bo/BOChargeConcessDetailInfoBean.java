package com.asiainfo.charge.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.charge.ivalues.*;

public class BOChargeConcessDetailInfoBean extends DataContainer implements DataContainerInterface,IBOChargeConcessDetailInfoValue{

  private static String  m_boName = "com.asiainfo.charge.bo.BOChargeConcessDetailInfo";



  public final static  String S_DetailType = "DETAIL_TYPE";
  public final static  String S_Price = "PRICE";
  public final static  String S_Unit = "UNIT";
  public final static  String S_ChargeOut = "CHARGE_OUT";
  public final static  String S_Cnt = "CNT";
  public final static  String S_Id = "ID";
  public final static  String S_Remark = "REMARK";
  public final static  String S_Conssid = "CONSSID";
  public final static  String S_ChargeIn = "CHARGE_IN";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOChargeConcessDetailInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initDetailType(String value){
     this.initProperty(S_DetailType,value);
  }
  public  void setDetailType(String value){
     this.set(S_DetailType,value);
  }
  public  void setDetailTypeNull(){
     this.set(S_DetailType,null);
  }

  public String getDetailType(){
       return DataType.getAsString(this.get(S_DetailType));
  
  }
  public String getDetailTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DetailType));
      }

  public void initPrice(int value){
     this.initProperty(S_Price,new Integer(value));
  }
  public  void setPrice(int value){
     this.set(S_Price,new Integer(value));
  }
  public  void setPriceNull(){
     this.set(S_Price,null);
  }

  public int getPrice(){
        return DataType.getAsInt(this.get(S_Price));
  
  }
  public int getPriceInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Price));
      }

  public void initUnit(String value){
     this.initProperty(S_Unit,value);
  }
  public  void setUnit(String value){
     this.set(S_Unit,value);
  }
  public  void setUnitNull(){
     this.set(S_Unit,null);
  }

  public String getUnit(){
       return DataType.getAsString(this.get(S_Unit));
  
  }
  public String getUnitInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Unit));
      }

  public void initChargeOut(int value){
     this.initProperty(S_ChargeOut,new Integer(value));
  }
  public  void setChargeOut(int value){
     this.set(S_ChargeOut,new Integer(value));
  }
  public  void setChargeOutNull(){
     this.set(S_ChargeOut,null);
  }

  public int getChargeOut(){
        return DataType.getAsInt(this.get(S_ChargeOut));
  
  }
  public int getChargeOutInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_ChargeOut));
      }

  public void initCnt(int value){
     this.initProperty(S_Cnt,new Integer(value));
  }
  public  void setCnt(int value){
     this.set(S_Cnt,new Integer(value));
  }
  public  void setCntNull(){
     this.set(S_Cnt,null);
  }

  public int getCnt(){
        return DataType.getAsInt(this.get(S_Cnt));
  
  }
  public int getCntInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Cnt));
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

  public void initConssid(int value){
     this.initProperty(S_Conssid,new Integer(value));
  }
  public  void setConssid(int value){
     this.set(S_Conssid,new Integer(value));
  }
  public  void setConssidNull(){
     this.set(S_Conssid,null);
  }

  public int getConssid(){
        return DataType.getAsInt(this.get(S_Conssid));
  
  }
  public int getConssidInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Conssid));
      }

  public void initChargeIn(int value){
     this.initProperty(S_ChargeIn,new Integer(value));
  }
  public  void setChargeIn(int value){
     this.set(S_ChargeIn,new Integer(value));
  }
  public  void setChargeInNull(){
     this.set(S_ChargeIn,null);
  }

  public int getChargeIn(){
        return DataType.getAsInt(this.get(S_ChargeIn));
  
  }
  public int getChargeInInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_ChargeIn));
      }


 
 }

