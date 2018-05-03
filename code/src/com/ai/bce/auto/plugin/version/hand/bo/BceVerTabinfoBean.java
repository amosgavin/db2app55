package com.ai.bce.auto.plugin.version.hand.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.auto.plugin.version.hand.ivalues.*;

public class BceVerTabinfoBean extends DataContainer implements DataContainerInterface,IBceVerTabinfoValue{

  private static String  m_boName = "com.ai.bce.auto.plugin.version.hand.bo.BceVerTabinfo";



  public final static  String S_TableName = "TABLE_NAME";
  public final static  String S_State = "STATE";
  public final static  String S_Sort = "SORT";
  public final static  String S_TabInfoId = "TAB_INFO_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_PrimaryCol = "PRIMARY_COL";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceVerTabinfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //Cannot reset ObjectType
   throw new AIException("Cannot reset ObjectType");
 }


  public void initTableName(String value){
     this.initProperty(S_TableName,value);
  }
  public  void setTableName(String value){
     this.set(S_TableName,value);
  }
  public  void setTableNameNull(){
     this.set(S_TableName,null);
  }

  public String getTableName(){
       return DataType.getAsString(this.get(S_TableName));
  
  }
  public String getTableNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TableName));
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

  public void initSort(String value){
     this.initProperty(S_Sort,value);
  }
  public  void setSort(String value){
     this.set(S_Sort,value);
  }
  public  void setSortNull(){
     this.set(S_Sort,null);
  }

  public String getSort(){
       return DataType.getAsString(this.get(S_Sort));
  
  }
  public String getSortInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Sort));
      }

  public void initTabInfoId(long value){
     this.initProperty(S_TabInfoId,new Long(value));
  }
  public  void setTabInfoId(long value){
     this.set(S_TabInfoId,new Long(value));
  }
  public  void setTabInfoIdNull(){
     this.set(S_TabInfoId,null);
  }

  public long getTabInfoId(){
        return DataType.getAsLong(this.get(S_TabInfoId));
  
  }
  public long getTabInfoIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TabInfoId));
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

  public void initPrimaryCol(String value){
     this.initProperty(S_PrimaryCol,value);
  }
  public  void setPrimaryCol(String value){
     this.set(S_PrimaryCol,value);
  }
  public  void setPrimaryColNull(){
     this.set(S_PrimaryCol,null);
  }

  public String getPrimaryCol(){
       return DataType.getAsString(this.get(S_PrimaryCol));
  
  }
  public String getPrimaryColInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PrimaryCol));
      }


 
 }

