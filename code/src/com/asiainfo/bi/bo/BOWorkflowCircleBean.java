package com.asiainfo.bi.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.bi.ivalues.*;

public class BOWorkflowCircleBean extends DataContainer implements DataContainerInterface,IBOWorkflowCircleValue{

  private static String  m_boName = "com.asiainfo.bi.bo.BOWorkflowCircle";



  public final static  String S_Pass = "PASS";
  public final static  String S_Scb = "SCB";
  public final static  String S_False = "FALSE";
  public final static  String S_Total = "TOTAL";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_Hdpz = "HDPZ";
  public final static  String S_Qrsz = "QRSZ";
  public final static  String S_Nbsh = "NBSH";
  public final static  String S_Yzpz = "YZPZ";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOWorkflowCircleBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initPass(long value){
     this.initProperty(S_Pass,new Long(value));
  }
  public  void setPass(long value){
     this.set(S_Pass,new Long(value));
  }
  public  void setPassNull(){
     this.set(S_Pass,null);
  }

  public long getPass(){
        return DataType.getAsLong(this.get(S_Pass));
  
  }
  public long getPassInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Pass));
      }

  public void initScb(long value){
     this.initProperty(S_Scb,new Long(value));
  }
  public  void setScb(long value){
     this.set(S_Scb,new Long(value));
  }
  public  void setScbNull(){
     this.set(S_Scb,null);
  }

  public long getScb(){
        return DataType.getAsLong(this.get(S_Scb));
  
  }
  public long getScbInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Scb));
      }

  public void initFalse(long value){
     this.initProperty(S_False,new Long(value));
  }
  public  void setFalse(long value){
     this.set(S_False,new Long(value));
  }
  public  void setFalseNull(){
     this.set(S_False,null);
  }

  public long getFalse(){
        return DataType.getAsLong(this.get(S_False));
  
  }
  public long getFalseInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_False));
      }

  public void initTotal(long value){
     this.initProperty(S_Total,new Long(value));
  }
  public  void setTotal(long value){
     this.set(S_Total,new Long(value));
  }
  public  void setTotalNull(){
     this.set(S_Total,null);
  }

  public long getTotal(){
        return DataType.getAsLong(this.get(S_Total));
  
  }
  public long getTotalInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Total));
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

  public void initHdpz(long value){
     this.initProperty(S_Hdpz,new Long(value));
  }
  public  void setHdpz(long value){
     this.set(S_Hdpz,new Long(value));
  }
  public  void setHdpzNull(){
     this.set(S_Hdpz,null);
  }

  public long getHdpz(){
        return DataType.getAsLong(this.get(S_Hdpz));
  
  }
  public long getHdpzInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Hdpz));
      }

  public void initQrsz(long value){
     this.initProperty(S_Qrsz,new Long(value));
  }
  public  void setQrsz(long value){
     this.set(S_Qrsz,new Long(value));
  }
  public  void setQrszNull(){
     this.set(S_Qrsz,null);
  }

  public long getQrsz(){
        return DataType.getAsLong(this.get(S_Qrsz));
  
  }
  public long getQrszInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Qrsz));
      }

  public void initNbsh(long value){
     this.initProperty(S_Nbsh,new Long(value));
  }
  public  void setNbsh(long value){
     this.set(S_Nbsh,new Long(value));
  }
  public  void setNbshNull(){
     this.set(S_Nbsh,null);
  }

  public long getNbsh(){
        return DataType.getAsLong(this.get(S_Nbsh));
  
  }
  public long getNbshInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Nbsh));
      }

  public void initYzpz(long value){
     this.initProperty(S_Yzpz,new Long(value));
  }
  public  void setYzpz(long value){
     this.set(S_Yzpz,new Long(value));
  }
  public  void setYzpzNull(){
     this.set(S_Yzpz,null);
  }

  public long getYzpz(){
        return DataType.getAsLong(this.get(S_Yzpz));
  
  }
  public long getYzpzInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Yzpz));
      }


 
 }

