package com.asiainfo.task.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.task.ivalues.*;

public class BORoleOpBean extends DataContainer implements DataContainerInterface,IBORoleOpValue{

  private static String  m_boName = "com.asiainfo.task.bo.BORoleOp";



  public final static  String S_OperatorId = "OPERATOR_ID";
  public final static  String S_StationId = "STATION_ID";
  public final static  String S_RoleId = "ROLE_ID";
  public final static  String S_OpStationId = "OP_STATION_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BORoleOpBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initOperatorId(long value){
     this.initProperty(S_OperatorId,new Long(value));
  }
  public  void setOperatorId(long value){
     this.set(S_OperatorId,new Long(value));
  }
  public  void setOperatorIdNull(){
     this.set(S_OperatorId,null);
  }

  public long getOperatorId(){
        return DataType.getAsLong(this.get(S_OperatorId));
  
  }
  public long getOperatorIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OperatorId));
      }

  public void initStationId(long value){
     this.initProperty(S_StationId,new Long(value));
  }
  public  void setStationId(long value){
     this.set(S_StationId,new Long(value));
  }
  public  void setStationIdNull(){
     this.set(S_StationId,null);
  }

  public long getStationId(){
        return DataType.getAsLong(this.get(S_StationId));
  
  }
  public long getStationIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_StationId));
      }

  public void initRoleId(long value){
     this.initProperty(S_RoleId,new Long(value));
  }
  public  void setRoleId(long value){
     this.set(S_RoleId,new Long(value));
  }
  public  void setRoleIdNull(){
     this.set(S_RoleId,null);
  }

  public long getRoleId(){
        return DataType.getAsLong(this.get(S_RoleId));
  
  }
  public long getRoleIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RoleId));
      }

  public void initOpStationId(long value){
     this.initProperty(S_OpStationId,new Long(value));
  }
  public  void setOpStationId(long value){
     this.set(S_OpStationId,new Long(value));
  }
  public  void setOpStationIdNull(){
     this.set(S_OpStationId,null);
  }

  public long getOpStationId(){
        return DataType.getAsLong(this.get(S_OpStationId));
  
  }
  public long getOpStationIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OpStationId));
      }


 
 }

