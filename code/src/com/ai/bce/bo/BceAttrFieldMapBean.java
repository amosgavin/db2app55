package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceAttrFieldMapBean extends DataContainer implements DataContainerInterface,IBceAttrFieldMapValue{

  private static String  m_boName = "com.ai.bce.bo.BceAttrFieldMap";



  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_AttrType = "ATTR_TYPE";
  public final static  String S_ConfigId = "CONFIG_ID";
  public final static  String S_DestFieldName = "DEST_FIELD_NAME";
  public final static  String S_AttrId = "ATTR_ID";
  public final static  String S_DataType = "DATA_TYPE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_DestTableName = "DEST_TABLE_NAME";
  public final static  String S_BusinessId = "BUSINESS_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceAttrFieldMapBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //Cannot reset ObjectType
   throw new AIException("Cannot reset ObjectType");
 }


  public void initModuleId(long value){
     this.initProperty(S_ModuleId,new Long(value));
  }
  public  void setModuleId(long value){
     this.set(S_ModuleId,new Long(value));
  }
  public  void setModuleIdNull(){
     this.set(S_ModuleId,null);
  }

  public long getModuleId(){
        return DataType.getAsLong(this.get(S_ModuleId));
  
  }
  public long getModuleIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ModuleId));
      }

  public void initAttrType(String value){
     this.initProperty(S_AttrType,value);
  }
  public  void setAttrType(String value){
     this.set(S_AttrType,value);
  }
  public  void setAttrTypeNull(){
     this.set(S_AttrType,null);
  }

  public String getAttrType(){
       return DataType.getAsString(this.get(S_AttrType));
  
  }
  public String getAttrTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AttrType));
      }

  public void initConfigId(long value){
     this.initProperty(S_ConfigId,new Long(value));
  }
  public  void setConfigId(long value){
     this.set(S_ConfigId,new Long(value));
  }
  public  void setConfigIdNull(){
     this.set(S_ConfigId,null);
  }

  public long getConfigId(){
        return DataType.getAsLong(this.get(S_ConfigId));
  
  }
  public long getConfigIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ConfigId));
      }

  public void initDestFieldName(String value){
     this.initProperty(S_DestFieldName,value);
  }
  public  void setDestFieldName(String value){
     this.set(S_DestFieldName,value);
  }
  public  void setDestFieldNameNull(){
     this.set(S_DestFieldName,null);
  }

  public String getDestFieldName(){
       return DataType.getAsString(this.get(S_DestFieldName));
  
  }
  public String getDestFieldNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DestFieldName));
      }

  public void initAttrId(long value){
     this.initProperty(S_AttrId,new Long(value));
  }
  public  void setAttrId(long value){
     this.set(S_AttrId,new Long(value));
  }
  public  void setAttrIdNull(){
     this.set(S_AttrId,null);
  }

  public long getAttrId(){
        return DataType.getAsLong(this.get(S_AttrId));
  
  }
  public long getAttrIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AttrId));
      }

  public void initDataType(String value){
     this.initProperty(S_DataType,value);
  }
  public  void setDataType(String value){
     this.set(S_DataType,value);
  }
  public  void setDataTypeNull(){
     this.set(S_DataType,null);
  }

  public String getDataType(){
       return DataType.getAsString(this.get(S_DataType));
  
  }
  public String getDataTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DataType));
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

  public void initDestTableName(String value){
     this.initProperty(S_DestTableName,value);
  }
  public  void setDestTableName(String value){
     this.set(S_DestTableName,value);
  }
  public  void setDestTableNameNull(){
     this.set(S_DestTableName,null);
  }

  public String getDestTableName(){
       return DataType.getAsString(this.get(S_DestTableName));
  
  }
  public String getDestTableNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DestTableName));
      }

  public void initBusinessId(long value){
     this.initProperty(S_BusinessId,new Long(value));
  }
  public  void setBusinessId(long value){
     this.set(S_BusinessId,new Long(value));
  }
  public  void setBusinessIdNull(){
     this.set(S_BusinessId,null);
  }

  public long getBusinessId(){
        return DataType.getAsLong(this.get(S_BusinessId));
  
  }
  public long getBusinessIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BusinessId));
      }


 
 }

