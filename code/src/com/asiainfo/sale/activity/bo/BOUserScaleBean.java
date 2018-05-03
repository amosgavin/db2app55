package com.asiainfo.sale.activity.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.activity.ivalues.*;

public class BOUserScaleBean extends DataContainer implements DataContainerInterface,IBOUserScaleValue{

  private static String  m_boName = "com.asiainfo.sale.activity.bo.BOUserScale";



  public final static  String S_StartTime = "START_TIME";
  public final static  String S_EndTime = "END_TIME";
  public final static  String S_MaxUsers = "MAX_USERS";
  public final static  String S_Id = "ID";
  public final static  String S_RelId = "REL_ID";
  public final static  String S_PreUsers = "PRE_USERS";
  public final static  String S_Region = "REGION";
  public final static  String S_InfoType = "INFO_TYPE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOUserScaleBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initStartTime(Timestamp value){
     this.initProperty(S_StartTime,value);
  }
  public  void setStartTime(Timestamp value){
     this.set(S_StartTime,value);
  }
  public  void setStartTimeNull(){
     this.set(S_StartTime,null);
  }

  public Timestamp getStartTime(){
        return DataType.getAsDateTime(this.get(S_StartTime));
  
  }
  public Timestamp getStartTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_StartTime));
      }

  public void initEndTime(Timestamp value){
     this.initProperty(S_EndTime,value);
  }
  public  void setEndTime(Timestamp value){
     this.set(S_EndTime,value);
  }
  public  void setEndTimeNull(){
     this.set(S_EndTime,null);
  }

  public Timestamp getEndTime(){
        return DataType.getAsDateTime(this.get(S_EndTime));
  
  }
  public Timestamp getEndTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_EndTime));
      }

  public void initMaxUsers(long value){
     this.initProperty(S_MaxUsers,new Long(value));
  }
  public  void setMaxUsers(long value){
     this.set(S_MaxUsers,new Long(value));
  }
  public  void setMaxUsersNull(){
     this.set(S_MaxUsers,null);
  }

  public long getMaxUsers(){
        return DataType.getAsLong(this.get(S_MaxUsers));
  
  }
  public long getMaxUsersInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_MaxUsers));
      }

  public void initId(long value){
     this.initProperty(S_Id,new Long(value));
  }
  public  void setId(long value){
     this.set(S_Id,new Long(value));
  }
  public  void setIdNull(){
     this.set(S_Id,null);
  }

  public long getId(){
        return DataType.getAsLong(this.get(S_Id));
  
  }
  public long getIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Id));
      }

  public void initRelId(long value){
     this.initProperty(S_RelId,new Long(value));
  }
  public  void setRelId(long value){
     this.set(S_RelId,new Long(value));
  }
  public  void setRelIdNull(){
     this.set(S_RelId,null);
  }

  public long getRelId(){
        return DataType.getAsLong(this.get(S_RelId));
  
  }
  public long getRelIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RelId));
      }

  public void initPreUsers(long value){
     this.initProperty(S_PreUsers,new Long(value));
  }
  public  void setPreUsers(long value){
     this.set(S_PreUsers,new Long(value));
  }
  public  void setPreUsersNull(){
     this.set(S_PreUsers,null);
  }

  public long getPreUsers(){
        return DataType.getAsLong(this.get(S_PreUsers));
  
  }
  public long getPreUsersInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PreUsers));
      }

  public void initRegion(String value){
     this.initProperty(S_Region,value);
  }
  public  void setRegion(String value){
     this.set(S_Region,value);
  }
  public  void setRegionNull(){
     this.set(S_Region,null);
  }

  public String getRegion(){
       return DataType.getAsString(this.get(S_Region));
  
  }
  public String getRegionInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Region));
      }

  public void initInfoType(String value){
	     this.initProperty(S_InfoType,value);
	  }
	  public  void setInfoType(String value){
	     this.set(S_InfoType,value);
	  }
	  public  void setInfoTypeNull(){
	     this.set(S_InfoType,null);
	  }

	  public String getInfoType(){
	        return DataType.getAsString(this.get(S_InfoType));
	  
	  }
	  public String getInfoTypeInitialValue(){
	        return DataType.getAsString(this.getOldObj(S_InfoType));
	      }

 
 }

