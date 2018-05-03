package com.ai.bce.plugin.grid.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.plugin.grid.ivalues.*;

public class BceTagPGridFieldBean extends DataContainer implements DataContainerInterface,IBceTagPGridFieldValue{

  private static String  m_boName = "com.ai.bce.plugin.grid.bo.BceTagPGridField";



  public final static  String S_FieldName = "FIELD_NAME";
  public final static  String S_State = "STATE";
  public final static  String S_Title = "TITLE";
  public final static  String S_Visible = "VISIBLE";
  public final static  String S_Editable = "EDITABLE";
  public final static  String S_Validation = "VALIDATION";
  public final static  String S_ObjectId = "OBJECT_ID";
  public final static  String S_Width = "WIDTH";
  public final static  String S_EditType = "EDIT_TYPE";
  public final static  String S_SeqNo = "SEQ_NO";
  public final static  String S_TitleI18n = "TITLE_I18N";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceTagPGridFieldBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //Cannot reset ObjectType
   throw new AIException("Cannot reset ObjectType");
 }


  public void initFieldName(String value){
     this.initProperty(S_FieldName,value);
  }
  public  void setFieldName(String value){
     this.set(S_FieldName,value);
  }
  public  void setFieldNameNull(){
     this.set(S_FieldName,null);
  }

  public String getFieldName(){
       return DataType.getAsString(this.get(S_FieldName));
  
  }
  public String getFieldNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FieldName));
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

  public void initTitle(String value){
     this.initProperty(S_Title,value);
  }
  public  void setTitle(String value){
     this.set(S_Title,value);
  }
  public  void setTitleNull(){
     this.set(S_Title,null);
  }

  public String getTitle(){
       return DataType.getAsString(this.get(S_Title));
  
  }
  public String getTitleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Title));
      }

  public void initVisible(int value){
     this.initProperty(S_Visible,new Integer(value));
  }
  public  void setVisible(int value){
     this.set(S_Visible,new Integer(value));
  }
  public  void setVisibleNull(){
     this.set(S_Visible,null);
  }

  public int getVisible(){
        return DataType.getAsInt(this.get(S_Visible));
  
  }
  public int getVisibleInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Visible));
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

  public void initValidation(String value){
     this.initProperty(S_Validation,value);
  }
  public  void setValidation(String value){
     this.set(S_Validation,value);
  }
  public  void setValidationNull(){
     this.set(S_Validation,null);
  }

  public String getValidation(){
       return DataType.getAsString(this.get(S_Validation));
  
  }
  public String getValidationInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Validation));
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

  public void initWidth(String value){
     this.initProperty(S_Width,value);
  }
  public  void setWidth(String value){
     this.set(S_Width,value);
  }
  public  void setWidthNull(){
     this.set(S_Width,null);
  }

  public String getWidth(){
       return DataType.getAsString(this.get(S_Width));
  
  }
  public String getWidthInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Width));
      }

  public void initEditType(String value){
     this.initProperty(S_EditType,value);
  }
  public  void setEditType(String value){
     this.set(S_EditType,value);
  }
  public  void setEditTypeNull(){
     this.set(S_EditType,null);
  }

  public String getEditType(){
       return DataType.getAsString(this.get(S_EditType));
  
  }
  public String getEditTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_EditType));
      }

  public void initSeqNo(int value){
     this.initProperty(S_SeqNo,new Integer(value));
  }
  public  void setSeqNo(int value){
     this.set(S_SeqNo,new Integer(value));
  }
  public  void setSeqNoNull(){
     this.set(S_SeqNo,null);
  }

  public int getSeqNo(){
        return DataType.getAsInt(this.get(S_SeqNo));
  
  }
  public int getSeqNoInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_SeqNo));
      }

  public void initTitleI18n(String value){
     this.initProperty(S_TitleI18n,value);
  }
  public  void setTitleI18n(String value){
     this.set(S_TitleI18n,value);
  }
  public  void setTitleI18nNull(){
     this.set(S_TitleI18n,null);
  }

  public String getTitleI18n(){
       return DataType.getAsString(this.get(S_TitleI18n));
  
  }
  public String getTitleI18nInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TitleI18n));
      }


 
 }

