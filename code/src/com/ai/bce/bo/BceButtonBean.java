package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceButtonBean extends DataContainer implements DataContainerInterface,IBceButtonValue{

  private static String  m_boName = "com.ai.bce.bo.BceButton";



  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_I18nRes = "I18N_RES";
  public final static  String S_ButtonName = "BUTTON_NAME";
  public final static  String S_ButtonId = "BUTTON_ID";
  public final static  String S_ButtonCode = "BUTTON_CODE";
  public final static  String S_Width = "WIDTH";
  public final static  String S_EventClick = "EVENT_CLICK";
  public final static  String S_Text = "TEXT";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceButtonBean() throws AIException{
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

  public void initI18nRes(String value){
     this.initProperty(S_I18nRes,value);
  }
  public  void setI18nRes(String value){
     this.set(S_I18nRes,value);
  }

  
  
  public  void setI18nResNull(){
     this.set(S_I18nRes,null);
  }

  public String getI18nRes(){
       return DataType.getAsString(this.get(S_I18nRes));
  
  }
  public String getI18nResInitialValue(){
        return DataType.getAsString(this.getOldObj(S_I18nRes));
      }

  public void initButtonName(String value){
     this.initProperty(S_ButtonName,value);
  }
  public  void setButtonName(String value){
     this.set(S_ButtonName,value);
  }

  
  
  public  void setButtonNameNull(){
     this.set(S_ButtonName,null);
  }

  public String getButtonName(){
       return DataType.getAsString(this.get(S_ButtonName));
  
  }
  public String getButtonNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ButtonName));
      }

  public void initButtonId(long value){
     this.initProperty(S_ButtonId,new Long(value));
  }
  public  void setButtonId(long value){
     this.set(S_ButtonId,new Long(value));
  }

  public  void setButtonId(Long value){
     this.set(S_ButtonId,value);
  }
  
  public  Long  getButtonIdAsLong(){
     return (Long )this.get(S_ButtonId);
  }
  
  
  public  void setButtonIdNull(){
     this.set(S_ButtonId,null);
  }

  public long getButtonId(){
        return DataType.getAsLong(this.get(S_ButtonId));
  
  }
  public long getButtonIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ButtonId));
      }

  public void initButtonCode(String value){
     this.initProperty(S_ButtonCode,value);
  }
  public  void setButtonCode(String value){
     this.set(S_ButtonCode,value);
  }

  
  
  public  void setButtonCodeNull(){
     this.set(S_ButtonCode,null);
  }

  public String getButtonCode(){
       return DataType.getAsString(this.get(S_ButtonCode));
  
  }
  public String getButtonCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ButtonCode));
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

  public void initEventClick(String value){
     this.initProperty(S_EventClick,value);
  }
  public  void setEventClick(String value){
     this.set(S_EventClick,value);
  }

  
  
  public  void setEventClickNull(){
     this.set(S_EventClick,null);
  }

  public String getEventClick(){
       return DataType.getAsString(this.get(S_EventClick));
  
  }
  public String getEventClickInitialValue(){
        return DataType.getAsString(this.getOldObj(S_EventClick));
      }

  public void initText(String value){
     this.initProperty(S_Text,value);
  }
  public  void setText(String value){
     this.set(S_Text,value);
  }

  
  
  public  void setTextNull(){
     this.set(S_Text,null);
  }

  public String getText(){
       return DataType.getAsString(this.get(S_Text));
  
  }
  public String getTextInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Text));
      }


 
 }

