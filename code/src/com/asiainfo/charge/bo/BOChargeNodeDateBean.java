package com.asiainfo.charge.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.charge.ivalues.*;

public class BOChargeNodeDateBean extends DataContainer implements DataContainerInterface,IBOChargeNodeDateValue{

  private static String  m_boName = "com.asiainfo.charge.bo.BOChargeNodeDate";



  public final static  String S_Id = "ID";
  public final static  String S_ChargeId = "CHARGE_ID";
  public final static  String S_Remark = "REMARK";
  public final static  String S_NodeId = "NODE_ID";
  public final static  String S_NodeValue = "NODE_VALUE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOChargeNodeDateBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
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

  public void initNodeId(String value){
     this.initProperty(S_NodeId,value);
  }
  public  void setNodeId(String value){
     this.set(S_NodeId,value);
  }
  public  void setNodeIdNull(){
     this.set(S_NodeId,null);
  }

  public String getNodeId(){
       return DataType.getAsString(this.get(S_NodeId));
  
  }
  public String getNodeIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_NodeId));
      }

  public void initNodeValue(String value){
     this.initProperty(S_NodeValue,value);
  }
  public  void setNodeValue(String value){
     this.set(S_NodeValue,value);
  }
  public  void setNodeValueNull(){
     this.set(S_NodeValue,null);
  }

  public String getNodeValue(){
       return DataType.getAsString(this.get(S_NodeValue));
  
  }
  public String getNodeValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_NodeValue));
      }


 
 }

