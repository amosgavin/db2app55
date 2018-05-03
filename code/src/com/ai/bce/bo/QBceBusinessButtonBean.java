package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class QBceBusinessButtonBean extends DataContainer implements DataContainerInterface,IQBceBusinessButtonValue{

  private static String  m_boName = "com.ai.bce.bo.QBceBusinessButton";



  public final static  String S_BceFrameId = "BCE_FRAME_ID";
  public final static  String S_I18nRes = "I18N_RES";
  public final static  String S_Enable = "ENABLE";
  public final static  String S_Text = "TEXT";
  public final static  String S_EventClick = "EVENT_CLICK";
  public final static  String S_ButtonCode = "BUTTON_CODE";
  public final static  String S_Operator = "OPERATOR";
  public final static  String S_Mo = "MO";
  public final static  String S_AreaId = "AREA_ID";
  public final static  String S_Width = "WIDTH";
  public final static  String S_SeqNo = "SEQ_NO";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QBceBusinessButtonBean() throws AIException{
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

  public void initSeqNo(long value){
     this.initProperty(S_SeqNo,new Long(value));
  }
  public  void setSeqNo(long value){
     this.set(S_SeqNo,new Long(value));
  }
  public  void setSeqNoNull(){
     this.set(S_SeqNo,null);
  }

  public long getSeqNo(){
        return DataType.getAsLong(this.get(S_SeqNo));
  
  }
  public long getSeqNoInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SeqNo));
      }


 
 }

