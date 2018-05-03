package com.asiainfo.sale.activity.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.activity.ivalues.*;

public class BOResourceChangeDetailBean extends DataContainer implements DataContainerInterface,IBOResourceChangeDetailValue{

  private static String  m_boName = "com.asiainfo.sale.activity.bo.BOResourceChangeDetail";



  public final static  String S_LTerm = "L_TERM";
  public final static  String S_CTerm = "C_TERM";
  public final static  String S_PDisc = "P_DISC";
  public final static  String S_CPoints = "C_POINTS";
  public final static  String S_ResourceId = "RESOURCE_ID";
  public final static  String S_ResourcedId = "RESOURCED_ID";
  public final static  String S_LPoints = "L_POINTS";
  public final static  String S_PPoints = "P_POINTS";
  public final static  String S_LDisc = "L_DISC";
  public final static  String S_PPromt = "P_PROMT";
  public final static  String S_PTerm = "P_TERM";
  public final static  String S_LPromt = "L_PROMT";
  public final static  String S_CDisc = "C_DISC";
  public final static  String S_CPromt = "C_PROMT";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOResourceChangeDetailBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initLTerm(double value){
     this.initProperty(S_LTerm,new Double(value));
  }
  public  void setLTerm(double value){
     this.set(S_LTerm,new Double(value));
  }
  public  void setLTermNull(){
     this.set(S_LTerm,null);
  }

  public double getLTerm(){
        return DataType.getAsDouble(this.get(S_LTerm));
  
  }
  public double getLTermInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_LTerm));
      }

  public void initCTerm(double value){
     this.initProperty(S_CTerm,new Double(value));
  }
  public  void setCTerm(double value){
     this.set(S_CTerm,new Double(value));
  }
  public  void setCTermNull(){
     this.set(S_CTerm,null);
  }

  public double getCTerm(){
        return DataType.getAsDouble(this.get(S_CTerm));
  
  }
  public double getCTermInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_CTerm));
      }

  public void initPDisc(double value){
     this.initProperty(S_PDisc,new Double(value));
  }
  public  void setPDisc(double value){
     this.set(S_PDisc,new Double(value));
  }
  public  void setPDiscNull(){
     this.set(S_PDisc,null);
  }

  public double getPDisc(){
        return DataType.getAsDouble(this.get(S_PDisc));
  
  }
  public double getPDiscInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PDisc));
      }

  public void initCPoints(double value){
     this.initProperty(S_CPoints,new Double(value));
  }
  public  void setCPoints(double value){
     this.set(S_CPoints,new Double(value));
  }
  public  void setCPointsNull(){
     this.set(S_CPoints,null);
  }

  public double getCPoints(){
        return DataType.getAsDouble(this.get(S_CPoints));
  
  }
  public double getCPointsInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_CPoints));
      }

  public void initResourceId(int value){
     this.initProperty(S_ResourceId,new Integer(value));
  }
  public  void setResourceId(int value){
     this.set(S_ResourceId,new Integer(value));
  }
  public  void setResourceIdNull(){
     this.set(S_ResourceId,null);
  }

  public int getResourceId(){
        return DataType.getAsInt(this.get(S_ResourceId));
  
  }
  public int getResourceIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_ResourceId));
      }

  public void initResourcedId(int value){
     this.initProperty(S_ResourcedId,new Integer(value));
  }
  public  void setResourcedId(int value){
     this.set(S_ResourcedId,new Integer(value));
  }
  public  void setResourcedIdNull(){
     this.set(S_ResourcedId,null);
  }

  public int getResourcedId(){
        return DataType.getAsInt(this.get(S_ResourcedId));
  
  }
  public int getResourcedIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_ResourcedId));
      }

  public void initLPoints(double value){
     this.initProperty(S_LPoints,new Double(value));
  }
  public  void setLPoints(double value){
     this.set(S_LPoints,new Double(value));
  }
  public  void setLPointsNull(){
     this.set(S_LPoints,null);
  }

  public double getLPoints(){
        return DataType.getAsDouble(this.get(S_LPoints));
  
  }
  public double getLPointsInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_LPoints));
      }

  public void initPPoints(double value){
     this.initProperty(S_PPoints,new Double(value));
  }
  public  void setPPoints(double value){
     this.set(S_PPoints,new Double(value));
  }
  public  void setPPointsNull(){
     this.set(S_PPoints,null);
  }

  public double getPPoints(){
        return DataType.getAsDouble(this.get(S_PPoints));
  
  }
  public double getPPointsInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PPoints));
      }

  public void initLDisc(double value){
     this.initProperty(S_LDisc,new Double(value));
  }
  public  void setLDisc(double value){
     this.set(S_LDisc,new Double(value));
  }
  public  void setLDiscNull(){
     this.set(S_LDisc,null);
  }

  public double getLDisc(){
        return DataType.getAsDouble(this.get(S_LDisc));
  
  }
  public double getLDiscInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_LDisc));
      }

  public void initPPromt(double value){
     this.initProperty(S_PPromt,new Double(value));
  }
  public  void setPPromt(double value){
     this.set(S_PPromt,new Double(value));
  }
  public  void setPPromtNull(){
     this.set(S_PPromt,null);
  }

  public double getPPromt(){
        return DataType.getAsDouble(this.get(S_PPromt));
  
  }
  public double getPPromtInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PPromt));
      }

  public void initPTerm(double value){
     this.initProperty(S_PTerm,new Double(value));
  }
  public  void setPTerm(double value){
     this.set(S_PTerm,new Double(value));
  }
  public  void setPTermNull(){
     this.set(S_PTerm,null);
  }

  public double getPTerm(){
        return DataType.getAsDouble(this.get(S_PTerm));
  
  }
  public double getPTermInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_PTerm));
      }

  public void initLPromt(double value){
     this.initProperty(S_LPromt,new Double(value));
  }
  public  void setLPromt(double value){
     this.set(S_LPromt,new Double(value));
  }
  public  void setLPromtNull(){
     this.set(S_LPromt,null);
  }

  public double getLPromt(){
        return DataType.getAsDouble(this.get(S_LPromt));
  
  }
  public double getLPromtInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_LPromt));
      }

  public void initCDisc(double value){
     this.initProperty(S_CDisc,new Double(value));
  }
  public  void setCDisc(double value){
     this.set(S_CDisc,new Double(value));
  }
  public  void setCDiscNull(){
     this.set(S_CDisc,null);
  }

  public double getCDisc(){
        return DataType.getAsDouble(this.get(S_CDisc));
  
  }
  public double getCDiscInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_CDisc));
      }

  public void initCPromt(double value){
     this.initProperty(S_CPromt,new Double(value));
  }
  public  void setCPromt(double value){
     this.set(S_CPromt,new Double(value));
  }
  public  void setCPromtNull(){
     this.set(S_CPromt,null);
  }

  public double getCPromt(){
        return DataType.getAsDouble(this.get(S_CPromt));
  
  }
  public double getCPromtInitialValue(){
        return DataType.getAsDouble(this.getOldObj(S_CPromt));
      }


 
 }

