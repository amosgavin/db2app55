package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceModuleBean extends DataContainer implements DataContainerInterface,IBceModuleValue{

  private static String  m_boName = "com.ai.bce.bo.BceModule";



  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_HtmlDir = "HTML_DIR";
  public final static  String S_ConfigDatasource = "CONFIG_DATASOURCE";
  public final static  String S_IconUrl = "ICON_URL";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_RunDatasource = "RUN_DATASOURCE";
  public final static  String S_ModuleName = "MODULE_NAME";
  public final static  String S_JavaPackage = "JAVA_PACKAGE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceModuleBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   throw new AIException("Cannot reset ObjectType");
 }


  public void initModuleId(long value){
     this.initProperty(S_ModuleId,new Long(value));
  }
  public  void setModuleId(long value){
     this.set(S_ModuleId,new Long(value));
  }

  public  void setModuleId(Long value){
     this.set(S_ModuleId,value);
  }
  
  public  Long  getModuleIdAsLong(){
     return (Long )this.get(S_ModuleId);
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

  public void initState(int value){
     this.initProperty(S_State,new Integer(value));
  }
  public  void setState(int value){
     this.set(S_State,new Integer(value));
  }

  public  void setState(Integer value){
     this.set(S_State,value);
  }
  
  public  Integer  getStateAsInteger(){
     return (Integer )this.get(S_State);
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

  public void initHtmlDir(String value){
     this.initProperty(S_HtmlDir,value);
  }
  public  void setHtmlDir(String value){
     this.set(S_HtmlDir,value);
  }

  
  
  public  void setHtmlDirNull(){
     this.set(S_HtmlDir,null);
  }

  public String getHtmlDir(){
       return DataType.getAsString(this.get(S_HtmlDir));
  
  }
  public String getHtmlDirInitialValue(){
        return DataType.getAsString(this.getOldObj(S_HtmlDir));
      }

  public void initConfigDatasource(String value){
     this.initProperty(S_ConfigDatasource,value);
  }
  public  void setConfigDatasource(String value){
     this.set(S_ConfigDatasource,value);
  }

  
  
  public  void setConfigDatasourceNull(){
     this.set(S_ConfigDatasource,null);
  }

  public String getConfigDatasource(){
       return DataType.getAsString(this.get(S_ConfigDatasource));
  
  }
  public String getConfigDatasourceInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ConfigDatasource));
      }

  public void initIconUrl(String value){
     this.initProperty(S_IconUrl,value);
  }
  public  void setIconUrl(String value){
     this.set(S_IconUrl,value);
  }

  
  
  public  void setIconUrlNull(){
     this.set(S_IconUrl,null);
  }

  public String getIconUrl(){
       return DataType.getAsString(this.get(S_IconUrl));
  
  }
  public String getIconUrlInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IconUrl));
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

  public void initRunDatasource(String value){
     this.initProperty(S_RunDatasource,value);
  }
  public  void setRunDatasource(String value){
     this.set(S_RunDatasource,value);
  }

  
  
  public  void setRunDatasourceNull(){
     this.set(S_RunDatasource,null);
  }

  public String getRunDatasource(){
       return DataType.getAsString(this.get(S_RunDatasource));
  
  }
  public String getRunDatasourceInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RunDatasource));
      }

  public void initModuleName(String value){
     this.initProperty(S_ModuleName,value);
  }
  public  void setModuleName(String value){
     this.set(S_ModuleName,value);
  }

  
  
  public  void setModuleNameNull(){
     this.set(S_ModuleName,null);
  }

  public String getModuleName(){
       return DataType.getAsString(this.get(S_ModuleName));
  
  }
  public String getModuleNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ModuleName));
      }

  public void initJavaPackage(String value){
     this.initProperty(S_JavaPackage,value);
  }
  public  void setJavaPackage(String value){
     this.set(S_JavaPackage,value);
  }

  
  
  public  void setJavaPackageNull(){
     this.set(S_JavaPackage,null);
  }

  public String getJavaPackage(){
       return DataType.getAsString(this.get(S_JavaPackage));
  
  }
  public String getJavaPackageInitialValue(){
        return DataType.getAsString(this.getOldObj(S_JavaPackage));
      }


 
 }

