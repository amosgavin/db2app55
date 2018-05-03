package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceWarnBean extends DataContainer implements DataContainerInterface,IBceWarnValue{

  private static String  m_boName = "com.ai.bce.bo.BceWarn";



  public final static  String S_State = "STATE";
  public final static  String S_WarnName = "WARN_NAME";
  public final static  String S_WarnContent = "WARN_CONTENT";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_WarnId = "WARN_ID";
  public final static  String S_WarnParams = "WARN_PARAMS";
  public final static  String S_FilePath = "FILE_PATH";
  public final static  String S_WarnType = "WARN_TYPE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceWarnBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initState(int value){
     this.initProperty(S_State,new Integer(value));
  }
  public  void setState(int value){
     this.set(S_State,new Integer(value));
  }
  public  void setStateNull(){
     this.set(S_State,null);
  }

  public int getState(){
        return DataType.getAsInt(this.get(S_State));
  
  }
  public int getStateInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_State));
      }

  public void initWarnName(String value){
     this.initProperty(S_WarnName,value);
  }
  public  void setWarnName(String value){
     this.set(S_WarnName,value);
  }
  public  void setWarnNameNull(){
     this.set(S_WarnName,null);
  }

  public String getWarnName(){
       return DataType.getAsString(this.get(S_WarnName));
  
  }
  public String getWarnNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WarnName));
      }

  public void initWarnContent(String value){
     this.initProperty(S_WarnContent,value);
  }
  public  void setWarnContent(String value){
     this.set(S_WarnContent,value);
  }
  public  void setWarnContentNull(){
     this.set(S_WarnContent,null);
  }

  public String getWarnContent(){
       return DataType.getAsString(this.get(S_WarnContent));
  
  }
  public String getWarnContentInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WarnContent));
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

  public void initWarnId(long value){
     this.initProperty(S_WarnId,new Long(value));
  }
  public  void setWarnId(long value){
     this.set(S_WarnId,new Long(value));
  }
  public  void setWarnIdNull(){
     this.set(S_WarnId,null);
  }

  public long getWarnId(){
        return DataType.getAsLong(this.get(S_WarnId));
  
  }
  public long getWarnIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_WarnId));
      }

  public void initWarnParams(String value){
     this.initProperty(S_WarnParams,value);
  }
  public  void setWarnParams(String value){
     this.set(S_WarnParams,value);
  }
  public  void setWarnParamsNull(){
     this.set(S_WarnParams,null);
  }

  public String getWarnParams(){
       return DataType.getAsString(this.get(S_WarnParams));
  
  }
  public String getWarnParamsInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WarnParams));
      }

  public void initFilePath(String value){
     this.initProperty(S_FilePath,value);
  }
  public  void setFilePath(String value){
     this.set(S_FilePath,value);
  }
  public  void setFilePathNull(){
     this.set(S_FilePath,null);
  }

  public String getFilePath(){
       return DataType.getAsString(this.get(S_FilePath));
  
  }
  public String getFilePathInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FilePath));
      }

  public void initWarnType(int value){
     this.initProperty(S_WarnType,new Integer(value));
  }
  public  void setWarnType(int value){
     this.set(S_WarnType,new Integer(value));
  }
  public  void setWarnTypeNull(){
     this.set(S_WarnType,null);
  }

  public int getWarnType(){
        return DataType.getAsInt(this.get(S_WarnType));
  
  }
  public int getWarnTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_WarnType));
      }


 
 }

