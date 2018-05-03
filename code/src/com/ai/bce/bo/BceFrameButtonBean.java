package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceFrameButtonBean extends DataContainer implements DataContainerInterface,IBceFrameButtonValue{

  private static String  m_boName = "com.ai.bce.bo.BceFrameButton";



  public final static  String S_BceFrameId = "BCE_FRAME_ID";
  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_Enable = "ENABLE";
  public final static  String S_EventClick = "EVENT_CLICK";
  public final static  String S_ButtonId = "BUTTON_ID";
  public final static  String S_Operator = "OPERATOR";
  public final static  String S_Mo = "MO";
  public final static  String S_AreaId = "AREA_ID";
  public final static  String S_SeqNo = "SEQ_NO";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceFrameButtonBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //Cannot reset ObjectType
   throw new AIException("Cannot reset ObjectType");
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

  public void initEnable(String value){
     this.initProperty(S_Enable,value);
  }
  public  void setEnable(String value){
     this.set(S_Enable,value);
  }
  public  void setEnableNull(){
     this.set(S_Enable,null);
  }

  public String getEnable(){
       return DataType.getAsString(this.get(S_Enable));
  
  }
  public String getEnableInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Enable));
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

  public void initButtonId(long value){
     this.initProperty(S_ButtonId,new Long(value));
  }
  public  void setButtonId(long value){
     this.set(S_ButtonId,new Long(value));
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


 
 }

