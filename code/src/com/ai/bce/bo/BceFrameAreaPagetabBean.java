package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceFrameAreaPagetabBean extends DataContainer implements DataContainerInterface,IBceFrameAreaPagetabValue{

  private static String  m_boName = "com.ai.bce.bo.BceFrameAreaPagetab";



  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_Getparameter = "GETPARAMETER";
  public final static  String S_State = "STATE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_Height = "HEIGHT";
  public final static  String S_AreaId = "AREA_ID";
  public final static  String S_TabType = "TAB_TYPE";
  public final static  String S_TabId = "TAB_ID";
  public final static  String S_Width = "WIDTH";
  public final static  String S_BceFrameId = "BCE_FRAME_ID";
  public final static  String S_Beforesettab = "BEFORESETTAB";
  public final static  String S_Aftersettab = "AFTERSETTAB";
  public final static  String S_Vmfile = "VMFILE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceFrameAreaPagetabBean() throws AIException{
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

  public void initGetparameter(String value){
     this.initProperty(S_Getparameter,value);
  }
  public  void setGetparameter(String value){
     this.set(S_Getparameter,value);
  }
  public  void setGetparameterNull(){
     this.set(S_Getparameter,null);
  }

  public String getGetparameter(){
       return DataType.getAsString(this.get(S_Getparameter));
  
  }
  public String getGetparameterInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Getparameter));
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

  public void initHeight(String value){
     this.initProperty(S_Height,value);
  }
  public  void setHeight(String value){
     this.set(S_Height,value);
  }
  public  void setHeightNull(){
     this.set(S_Height,null);
  }

  public String getHeight(){
       return DataType.getAsString(this.get(S_Height));
  
  }
  public String getHeightInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Height));
      }

  public void initAreaId(String value){
     this.initProperty(S_AreaId,value);
  }
  public  void setAreaId(String value){
     this.set(S_AreaId,value);
  }
  public  void setAreaIdNull(){
     this.set(S_AreaId,null);
  }

  public String getAreaId(){
       return DataType.getAsString(this.get(S_AreaId));
  
  }
  public String getAreaIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AreaId));
      }

  public void initTabType(String value){
     this.initProperty(S_TabType,value);
  }
  public  void setTabType(String value){
     this.set(S_TabType,value);
  }
  public  void setTabTypeNull(){
     this.set(S_TabType,null);
  }

  public String getTabType(){
       return DataType.getAsString(this.get(S_TabType));
  
  }
  public String getTabTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TabType));
      }

  public void initTabId(long value){
     this.initProperty(S_TabId,new Long(value));
  }
  public  void setTabId(long value){
     this.set(S_TabId,new Long(value));
  }
  public  void setTabIdNull(){
     this.set(S_TabId,null);
  }

  public long getTabId(){
        return DataType.getAsLong(this.get(S_TabId));
  
  }
  public long getTabIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TabId));
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

  public void initBceFrameId(long value){
     this.initProperty(S_BceFrameId,new Long(value));
  }
  public  void setBceFrameId(long value){
     this.set(S_BceFrameId,new Long(value));
  }
  public  void setBceFrameIdNull(){
     this.set(S_BceFrameId,null);
  }

  public long getBceFrameId(){
        return DataType.getAsLong(this.get(S_BceFrameId));
  
  }
  public long getBceFrameIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BceFrameId));
      }

  public void initBeforesettab(String value){
     this.initProperty(S_Beforesettab,value);
  }
  public  void setBeforesettab(String value){
     this.set(S_Beforesettab,value);
  }
  public  void setBeforesettabNull(){
     this.set(S_Beforesettab,null);
  }

  public String getBeforesettab(){
       return DataType.getAsString(this.get(S_Beforesettab));
  
  }
  public String getBeforesettabInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Beforesettab));
      }

  public void initAftersettab(String value){
     this.initProperty(S_Aftersettab,value);
  }
  public  void setAftersettab(String value){
     this.set(S_Aftersettab,value);
  }
  public  void setAftersettabNull(){
     this.set(S_Aftersettab,null);
  }

  public String getAftersettab(){
       return DataType.getAsString(this.get(S_Aftersettab));
  
  }
  public String getAftersettabInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Aftersettab));
      }

  public void initVmfile(String value){
     this.initProperty(S_Vmfile,value);
  }
  public  void setVmfile(String value){
     this.set(S_Vmfile,value);
  }
  public  void setVmfileNull(){
     this.set(S_Vmfile,null);
  }

  public String getVmfile(){
       return DataType.getAsString(this.get(S_Vmfile));
  
  }
  public String getVmfileInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Vmfile));
      }


 
 }

