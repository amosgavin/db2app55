package com.asiainfo.sale.tag.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.tag.ivalues.*;

public class BOZFQPromationTagBean extends DataContainer implements DataContainerInterface,IBOZFQPromationTagValue{

  private static String  m_boName = "com.asiainfo.sale.tag.bo.BOZFQPromationTag";



  public final static  String S_TagType = "TAG_TYPE";
  public final static  String S_State = "STATE";
  public final static  String S_Name = "NAME";
  public final static  String S_Area = "AREA";
  public final static  String S_Pid = "PID";
  public final static  String S_Sumcharge = "SUMCHARGE";
  public final static  String S_Id = "ID";
  public final static  String S_TagCode = "TAG_CODE";
  public final static  String S_Charge = "CHARGE";
  public final static  String S_Cycle = "CYCLE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOZFQPromationTagBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initTagType(String value){
     this.initProperty(S_TagType,value);
  }
  public  void setTagType(String value){
     this.set(S_TagType,value);
  }
  public  void setTagTypeNull(){
     this.set(S_TagType,null);
  }

  public String getTagType(){
       return DataType.getAsString(this.get(S_TagType));
  
  }
  public String getTagTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TagType));
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

  public void initName(String value){
     this.initProperty(S_Name,value);
  }
  public  void setName(String value){
     this.set(S_Name,value);
  }
  public  void setNameNull(){
     this.set(S_Name,null);
  }

  public String getName(){
       return DataType.getAsString(this.get(S_Name));
  
  }
  public String getNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Name));
      }

  public void initArea(String value){
     this.initProperty(S_Area,value);
  }
  public  void setArea(String value){
     this.set(S_Area,value);
  }
  public  void setAreaNull(){
     this.set(S_Area,null);
  }

  public String getArea(){
       return DataType.getAsString(this.get(S_Area));
  
  }
  public String getAreaInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Area));
      }

  public void initPid(int value){
     this.initProperty(S_Pid,new Integer(value));
  }
  public  void setPid(int value){
     this.set(S_Pid,new Integer(value));
  }
  public  void setPidNull(){
     this.set(S_Pid,null);
  }

  public int getPid(){
        return DataType.getAsInt(this.get(S_Pid));
  
  }
  public int getPidInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Pid));
      }

  public void initSumcharge(double value){
     this.initProperty(S_Sumcharge,new Double(value));
  }
  public  void setSumcharge(double value){
     this.set(S_Sumcharge,new Double(value));
  }
  public  void setSumchargeNull(){
     this.set(S_Sumcharge,null);
  }

  public double getSumcharge(){
        return DataType.getAsDouble(this.get(S_Sumcharge));
  
  }
  public double getSumchargeInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_Sumcharge));
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

  public void initTagCode(String value){
     this.initProperty(S_TagCode,value);
  }
  public  void setTagCode(String value){
     this.set(S_TagCode,value);
  }
  public  void setTagCodeNull(){
     this.set(S_TagCode,null);
  }

  public String getTagCode(){
       return DataType.getAsString(this.get(S_TagCode));
  
  }
  public String getTagCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TagCode));
      }

  public void initCharge(double value){
     this.initProperty(S_Charge,new Double(value));
  }
  public  void setCharge(double value){
     this.set(S_Charge,new Double(value));
  }
  public  void setChargeNull(){
     this.set(S_Charge,null);
  }

  public double getCharge(){
        return DataType.getAsDouble(this.get(S_Charge));
  
  }
  public double getChargeInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_Charge));
      }

  public void initCycle(int value){
     this.initProperty(S_Cycle,new Integer(value));
  }
  public  void setCycle(int value){
     this.set(S_Cycle,new Integer(value));
  }
  public  void setCycleNull(){
     this.set(S_Cycle,null);
  }

  public int getCycle(){
        return DataType.getAsInt(this.get(S_Cycle));
  
  }
  public int getCycleInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Cycle));
      }


 
 }

