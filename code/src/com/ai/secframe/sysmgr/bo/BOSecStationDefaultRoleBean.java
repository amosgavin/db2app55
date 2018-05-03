package com.ai.secframe.sysmgr.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.secframe.sysmgr.ivalues.*;

public class BOSecStationDefaultRoleBean extends DataContainer implements DataContainerInterface,IBOSecStationDefaultRoleValue{

  private static String  m_boName = "com.ai.secframe.sysmgr.bo.BOSecStationDefaultRole";



  public final static  String S_OpId = "OP_ID";
  public final static  String S_State = "STATE";
  public final static  String S_DefaultId = "DEFAULT_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_StationId = "STATION_ID";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_RoleId = "ROLE_ID";
  public final static  String S_Ext3 = "EXT3";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOSecStationDefaultRoleBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initOpId(String value){
     this.initProperty(S_OpId,value);
  }
  public  void setOpId(String value){
     this.set(S_OpId,value);
  }
  public  void setOpIdNull(){
     this.set(S_OpId,null);
  }

  public String getOpId(){
       return DataType.getAsString(this.get(S_OpId));
  
  }
  public String getOpIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OpId));
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

  public void initDefaultId(long value){
     this.initProperty(S_DefaultId,new Long(value));
  }
  public  void setDefaultId(long value){
     this.set(S_DefaultId,new Long(value));
  }
  public  void setDefaultIdNull(){
     this.set(S_DefaultId,null);
  }

  public long getDefaultId(){
        return DataType.getAsLong(this.get(S_DefaultId));
  
  }
  public long getDefaultIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_DefaultId));
      }

  public void initRemarks(String value){
     this.initProperty(S_Remarks,value);
  }
  public  void setRemarks(String value){
     this.set(S_Remarks,value);
  }
  public  void setRemarksNull(){
     this.set(S_Remarks,null);
  }

  public String getRemarks(){
       return DataType.getAsString(this.get(S_Remarks));
  
  }
  public String getRemarksInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remarks));
      }

  public void initStationId(String value){
     this.initProperty(S_StationId,value);
  }
  public  void setStationId(String value){
     this.set(S_StationId,value);
  }
  public  void setStationIdNull(){
     this.set(S_StationId,null);
  }

  public String getStationId(){
       return DataType.getAsString(this.get(S_StationId));
  
  }
  public String getStationIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_StationId));
      }

  public void initExt1(String value){
     this.initProperty(S_Ext1,value);
  }
  public  void setExt1(String value){
     this.set(S_Ext1,value);
  }
  public  void setExt1Null(){
     this.set(S_Ext1,null);
  }

  public String getExt1(){
       return DataType.getAsString(this.get(S_Ext1));
  
  }
  public String getExt1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext1));
      }

  public void initExt2(String value){
     this.initProperty(S_Ext2,value);
  }
  public  void setExt2(String value){
     this.set(S_Ext2,value);
  }
  public  void setExt2Null(){
     this.set(S_Ext2,null);
  }

  public String getExt2(){
       return DataType.getAsString(this.get(S_Ext2));
  
  }
  public String getExt2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext2));
      }

  public void initRoleId(String value){
     this.initProperty(S_RoleId,value);
  }
  public  void setRoleId(String value){
     this.set(S_RoleId,value);
  }
  public  void setRoleIdNull(){
     this.set(S_RoleId,null);
  }

  public String getRoleId(){
       return DataType.getAsString(this.get(S_RoleId));
  
  }
  public String getRoleIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RoleId));
      }

  public void initExt3(String value){
     this.initProperty(S_Ext3,value);
  }
  public  void setExt3(String value){
     this.set(S_Ext3,value);
  }
  public  void setExt3Null(){
     this.set(S_Ext3,null);
  }

  public String getExt3(){
       return DataType.getAsString(this.get(S_Ext3));
  
  }
  public String getExt3InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext3));
      }


 
 }

