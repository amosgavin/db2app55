package com.asiainfo.bi.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.bi.ivalues.*;

public class BOTaskDurationCountBean extends DataContainer implements DataContainerInterface,IBOTaskDurationCountValue{

  private static String  m_boName = "com.asiainfo.bi.bo.BOTaskDurationCount";



  public final static  String S_Scb = "SCB";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_Nbsh = "NBSH";
  public final static  String S_Qrsx = "QRSX";
  public final static  String S_Hdpz = "HDPZ";
  public final static  String S_Yzpz = "YZPZ";
  public final static  String S_False = "FALSE";
  public final static  String S_WorkflowObjectType = "WORKFLOW_OBJECT_TYPE";
  public final static  String S_Total = "TOTAL";
  public final static  String S_Pass = "PASS";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOTaskDurationCountBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initScb(int value){
     this.initProperty(S_Scb,new Integer(value));
  }
  public  void setScb(int value){
     this.set(S_Scb,new Integer(value));
  }
  public  void setScbNull(){
     this.set(S_Scb,null);
  }

  public int getScb(){
        return DataType.getAsInt(this.get(S_Scb));
  
  }
  public int getScbInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Scb));
      }

  public void initRegionId(String value){
     this.initProperty(S_RegionId,value);
  }
  public  void setRegionId(String value){
     this.set(S_RegionId,value);
  }
  public  void setRegionIdNull(){
     this.set(S_RegionId,null);
  }

  public String getRegionId(){
       return DataType.getAsString(this.get(S_RegionId));
  
  }
  public String getRegionIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RegionId));
      }

  public void initNbsh(int value){
     this.initProperty(S_Nbsh,new Integer(value));
  }
  public  void setNbsh(int value){
     this.set(S_Nbsh,new Integer(value));
  }
  public  void setNbshNull(){
     this.set(S_Nbsh,null);
  }

  public int getNbsh(){
        return DataType.getAsInt(this.get(S_Nbsh));
  
  }
  public int getNbshInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Nbsh));
      }

  public void initQrsx(int value){
     this.initProperty(S_Qrsx,new Integer(value));
  }
  public  void setQrsx(int value){
     this.set(S_Qrsx,new Integer(value));
  }
  public  void setQrsxNull(){
     this.set(S_Qrsx,null);
  }

  public int getQrsx(){
        return DataType.getAsInt(this.get(S_Qrsx));
  
  }
  public int getQrsxInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Qrsx));
      }

  public void initHdpz(int value){
     this.initProperty(S_Hdpz,new Integer(value));
  }
  public  void setHdpz(int value){
     this.set(S_Hdpz,new Integer(value));
  }
  public  void setHdpzNull(){
     this.set(S_Hdpz,null);
  }

  public int getHdpz(){
        return DataType.getAsInt(this.get(S_Hdpz));
  
  }
  public int getHdpzInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Hdpz));
      }

  public void initYzpz(int value){
     this.initProperty(S_Yzpz,new Integer(value));
  }
  public  void setYzpz(int value){
     this.set(S_Yzpz,new Integer(value));
  }
  public  void setYzpzNull(){
     this.set(S_Yzpz,null);
  }

  public int getYzpz(){
        return DataType.getAsInt(this.get(S_Yzpz));
  
  }
  public int getYzpzInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Yzpz));
      }

  public void initFalse(int value){
     this.initProperty(S_False,new Integer(value));
  }
  public  void setFalse(int value){
     this.set(S_False,new Integer(value));
  }
  public  void setFalseNull(){
     this.set(S_False,null);
  }

  public int getFalse(){
        return DataType.getAsInt(this.get(S_False));
  
  }
  public int getFalseInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_False));
      }

  public void initWorkflowObjectType(String value){
     this.initProperty(S_WorkflowObjectType,value);
  }
  public  void setWorkflowObjectType(String value){
     this.set(S_WorkflowObjectType,value);
  }
  public  void setWorkflowObjectTypeNull(){
     this.set(S_WorkflowObjectType,null);
  }

  public String getWorkflowObjectType(){
       return DataType.getAsString(this.get(S_WorkflowObjectType));
  
  }
  public String getWorkflowObjectTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WorkflowObjectType));
      }

  public void initTotal(int value){
     this.initProperty(S_Total,new Integer(value));
  }
  public  void setTotal(int value){
     this.set(S_Total,new Integer(value));
  }
  public  void setTotalNull(){
     this.set(S_Total,null);
  }

  public int getTotal(){
        return DataType.getAsInt(this.get(S_Total));
  
  }
  public int getTotalInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Total));
      }

  public void initPass(int value){
     this.initProperty(S_Pass,new Integer(value));
  }
  public  void setPass(int value){
     this.set(S_Pass,new Integer(value));
  }
  public  void setPassNull(){
     this.set(S_Pass,null);
  }

  public int getPass(){
        return DataType.getAsInt(this.get(S_Pass));
  
  }
  public int getPassInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Pass));
      }


 
 }

