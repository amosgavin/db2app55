package com.asiainfo.bi.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.bi.ivalues.*;

public class BOStatisticsBean extends DataContainer implements DataContainerInterface,IBOStatisticsValue{

  private static String  m_boName = "com.asiainfo.bi.bo.BOStatistics";



  public final static  String S_A2 = "A2";
  public final static  String S_A1 = "A1";
  public final static  String S_A3 = "A3";
  public final static  String S_A = "A";
  public final static  String S_OrgId = "ORG_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOStatisticsBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initA2(long value){
     this.initProperty(S_A2,new Long(value));
  }
  public  void setA2(long value){
     this.set(S_A2,new Long(value));
  }
  public  void setA2Null(){
     this.set(S_A2,null);
  }

  public long getA2(){
        return DataType.getAsLong(this.get(S_A2));
  
  }
  public long getA2InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_A2));
      }

  public void initA1(long value){
     this.initProperty(S_A1,new Long(value));
  }
  public  void setA1(long value){
     this.set(S_A1,new Long(value));
  }
  public  void setA1Null(){
     this.set(S_A1,null);
  }

  public long getA1(){
        return DataType.getAsLong(this.get(S_A1));
  
  }
  public long getA1InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_A1));
      }

  public void initA3(long value){
     this.initProperty(S_A3,new Long(value));
  }
  public  void setA3(long value){
     this.set(S_A3,new Long(value));
  }
  public  void setA3Null(){
     this.set(S_A3,null);
  }

  public long getA3(){
        return DataType.getAsLong(this.get(S_A3));
  
  }
  public long getA3InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_A3));
      }

  public void initA(long value){
     this.initProperty(S_A,new Long(value));
  }
  public  void setA(long value){
     this.set(S_A,new Long(value));
  }
  public  void setANull(){
     this.set(S_A,null);
  }

  public long getA(){
        return DataType.getAsLong(this.get(S_A));
  
  }
  public long getAInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_A));
      }

  public void initOrgId(long value){
     this.initProperty(S_OrgId,new Long(value));
  }
  public  void setOrgId(long value){
     this.set(S_OrgId,new Long(value));
  }
  public  void setOrgIdNull(){
     this.set(S_OrgId,null);
  }

  public long getOrgId(){
        return DataType.getAsLong(this.get(S_OrgId));
  
  }
  public long getOrgIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OrgId));
      }


 
 }

