package com.ai.bce.plugin.form.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.plugin.form.ivalues.*;

public class BceTagPFormBean extends DataContainer implements DataContainerInterface,IBceTagPFormValue{

  private static String  m_boName = "com.ai.bce.plugin.form.bo.BceTagPForm";



  public final static  String S_State = "STATE";
  public final static  String S_IsInitial = "IS_INITIAL";
  public final static  String S_Cols = "COLS";
  public final static  String S_Editable = "EDITABLE";
  public final static  String S_FieldStyle = "FIELD_STYLE";
  public final static  String S_ObjectId = "OBJECT_ID";
  public final static  String S_TableStyle = "TABLE_STYLE";
  public final static  String S_FormId = "FORM_ID";
  public final static  String S_SetName = "SET_NAME";
  public final static  String S_QueryMethod = "QUERY_METHOD";
  public final static  String S_DataModel = "DATA_MODEL";
  public final static  String S_TitleStyle = "TITLE_STYLE";
  public final static  String S_Operator = "OPERATOR";
  public final static  String S_ServiceName = "SERVICE_NAME";
  public final static  String S_Mo = "MO";
  public final static  String S_ConditionName = "CONDITION_NAME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceTagPFormBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //Cannot reset ObjectType
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

  public void initIsInitial(int value){
     this.initProperty(S_IsInitial,new Integer(value));
  }
  public  void setIsInitial(int value){
     this.set(S_IsInitial,new Integer(value));
  }
  public  void setIsInitialNull(){
     this.set(S_IsInitial,null);
  }

  public int getIsInitial(){
        return DataType.getAsInt(this.get(S_IsInitial));
  
  }
  public int getIsInitialInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_IsInitial));
      }

  public void initCols(int value){
     this.initProperty(S_Cols,new Integer(value));
  }
  public  void setCols(int value){
     this.set(S_Cols,new Integer(value));
  }
  public  void setColsNull(){
     this.set(S_Cols,null);
  }

  public int getCols(){
        return DataType.getAsInt(this.get(S_Cols));
  
  }
  public int getColsInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Cols));
      }

  public void initEditable(int value){
     this.initProperty(S_Editable,new Integer(value));
  }
  public  void setEditable(int value){
     this.set(S_Editable,new Integer(value));
  }
  public  void setEditableNull(){
     this.set(S_Editable,null);
  }

  public int getEditable(){
        return DataType.getAsInt(this.get(S_Editable));
  
  }
  public int getEditableInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Editable));
      }

  public void initFieldStyle(String value){
     this.initProperty(S_FieldStyle,value);
  }
  public  void setFieldStyle(String value){
     this.set(S_FieldStyle,value);
  }
  public  void setFieldStyleNull(){
     this.set(S_FieldStyle,null);
  }

  public String getFieldStyle(){
       return DataType.getAsString(this.get(S_FieldStyle));
  
  }
  public String getFieldStyleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FieldStyle));
      }

  public void initObjectId(long value){
     this.initProperty(S_ObjectId,new Long(value));
  }
  public  void setObjectId(long value){
     this.set(S_ObjectId,new Long(value));
  }
  public  void setObjectIdNull(){
     this.set(S_ObjectId,null);
  }

  public long getObjectId(){
        return DataType.getAsLong(this.get(S_ObjectId));
  
  }
  public long getObjectIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ObjectId));
      }

  public void initTableStyle(String value){
     this.initProperty(S_TableStyle,value);
  }
  public  void setTableStyle(String value){
     this.set(S_TableStyle,value);
  }
  public  void setTableStyleNull(){
     this.set(S_TableStyle,null);
  }

  public String getTableStyle(){
       return DataType.getAsString(this.get(S_TableStyle));
  
  }
  public String getTableStyleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TableStyle));
      }

  public void initFormId(String value){
     this.initProperty(S_FormId,value);
  }
  public  void setFormId(String value){
     this.set(S_FormId,value);
  }
  public  void setFormIdNull(){
     this.set(S_FormId,null);
  }

  public String getFormId(){
       return DataType.getAsString(this.get(S_FormId));
  
  }
  public String getFormIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FormId));
      }

  public void initSetName(String value){
     this.initProperty(S_SetName,value);
  }
  public  void setSetName(String value){
     this.set(S_SetName,value);
  }
  public  void setSetNameNull(){
     this.set(S_SetName,null);
  }

  public String getSetName(){
       return DataType.getAsString(this.get(S_SetName));
  
  }
  public String getSetNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SetName));
      }

  public void initQueryMethod(String value){
     this.initProperty(S_QueryMethod,value);
  }
  public  void setQueryMethod(String value){
     this.set(S_QueryMethod,value);
  }
  public  void setQueryMethodNull(){
     this.set(S_QueryMethod,null);
  }

  public String getQueryMethod(){
       return DataType.getAsString(this.get(S_QueryMethod));
  
  }
  public String getQueryMethodInitialValue(){
        return DataType.getAsString(this.getOldObj(S_QueryMethod));
      }

  public void initDataModel(String value){
     this.initProperty(S_DataModel,value);
  }
  public  void setDataModel(String value){
     this.set(S_DataModel,value);
  }
  public  void setDataModelNull(){
     this.set(S_DataModel,null);
  }

  public String getDataModel(){
       return DataType.getAsString(this.get(S_DataModel));
  
  }
  public String getDataModelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DataModel));
      }

  public void initTitleStyle(String value){
     this.initProperty(S_TitleStyle,value);
  }
  public  void setTitleStyle(String value){
     this.set(S_TitleStyle,value);
  }
  public  void setTitleStyleNull(){
     this.set(S_TitleStyle,null);
  }

  public String getTitleStyle(){
       return DataType.getAsString(this.get(S_TitleStyle));
  
  }
  public String getTitleStyleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TitleStyle));
      }

  public void initOperator(String value){
     this.initProperty(S_Operator,value);
  }
  public  void setOperator(String value){
     this.set(S_Operator,value);
  }
  public  void setOperatorNull(){
     this.set(S_Operator,null);
  }

  public String getOperator(){
       return DataType.getAsString(this.get(S_Operator));
  
  }
  public String getOperatorInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Operator));
      }

  public void initServiceName(String value){
     this.initProperty(S_ServiceName,value);
  }
  public  void setServiceName(String value){
     this.set(S_ServiceName,value);
  }
  public  void setServiceNameNull(){
     this.set(S_ServiceName,null);
  }

  public String getServiceName(){
       return DataType.getAsString(this.get(S_ServiceName));
  
  }
  public String getServiceNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ServiceName));
      }

  public void initMo(String value){
     this.initProperty(S_Mo,value);
  }
  public  void setMo(String value){
     this.set(S_Mo,value);
  }
  public  void setMoNull(){
     this.set(S_Mo,null);
  }

  public String getMo(){
       return DataType.getAsString(this.get(S_Mo));
  
  }
  public String getMoInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Mo));
      }

  public void initConditionName(String value){
     this.initProperty(S_ConditionName,value);
  }
  public  void setConditionName(String value){
     this.set(S_ConditionName,value);
  }
  public  void setConditionNameNull(){
     this.set(S_ConditionName,null);
  }

  public String getConditionName(){
       return DataType.getAsString(this.get(S_ConditionName));
  
  }
  public String getConditionNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ConditionName));
      }


 
 }

