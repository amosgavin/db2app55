package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceQrTemplateBean extends DataContainer implements DataContainerInterface,IBceQrTemplateValue{

  private static String  m_boName = "com.ai.bce.bo.BceQrTemplate";



  public final static  String S_State = "STATE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_TemplateName = "TEMPLATE_NAME";
  public final static  String S_JsFile = "JS_FILE";
  public final static  String S_ContentClass = "CONTENT_CLASS";
  public final static  String S_JsFunction = "JS_FUNCTION";
  public final static  String S_TemplateId = "TEMPLATE_ID";
  public final static  String S_FilePath = "FILE_PATH";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceQrTemplateBean() throws AIException{
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

  public void initTemplateName(String value){
     this.initProperty(S_TemplateName,value);
  }
  public  void setTemplateName(String value){
     this.set(S_TemplateName,value);
  }
  public  void setTemplateNameNull(){
     this.set(S_TemplateName,null);
  }

  public String getTemplateName(){
       return DataType.getAsString(this.get(S_TemplateName));
  
  }
  public String getTemplateNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TemplateName));
      }

  public void initJsFile(String value){
     this.initProperty(S_JsFile,value);
  }
  public  void setJsFile(String value){
     this.set(S_JsFile,value);
  }
  public  void setJsFileNull(){
     this.set(S_JsFile,null);
  }

  public String getJsFile(){
       return DataType.getAsString(this.get(S_JsFile));
  
  }
  public String getJsFileInitialValue(){
        return DataType.getAsString(this.getOldObj(S_JsFile));
      }

  public void initContentClass(String value){
     this.initProperty(S_ContentClass,value);
  }
  public  void setContentClass(String value){
     this.set(S_ContentClass,value);
  }
  public  void setContentClassNull(){
     this.set(S_ContentClass,null);
  }

  public String getContentClass(){
       return DataType.getAsString(this.get(S_ContentClass));
  
  }
  public String getContentClassInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ContentClass));
      }

  public void initJsFunction(String value){
     this.initProperty(S_JsFunction,value);
  }
  public  void setJsFunction(String value){
     this.set(S_JsFunction,value);
  }
  public  void setJsFunctionNull(){
     this.set(S_JsFunction,null);
  }

  public String getJsFunction(){
       return DataType.getAsString(this.get(S_JsFunction));
  
  }
  public String getJsFunctionInitialValue(){
        return DataType.getAsString(this.getOldObj(S_JsFunction));
      }

  public void initTemplateId(long value){
     this.initProperty(S_TemplateId,new Long(value));
  }
  public  void setTemplateId(long value){
     this.set(S_TemplateId,new Long(value));
  }
  public  void setTemplateIdNull(){
     this.set(S_TemplateId,null);
  }

  public long getTemplateId(){
        return DataType.getAsLong(this.get(S_TemplateId));
  
  }
  public long getTemplateIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TemplateId));
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


 
 }

