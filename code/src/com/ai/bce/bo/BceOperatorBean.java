package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceOperatorBean extends DataContainer implements DataContainerInterface,IBceOperatorValue{

  private static String  m_boName = "com.ai.bce.bo.BceOperator";



  public final static  String S_State = "STATE";
  public final static  String S_Notes = "NOTES";
  public final static  String S_StateDate = "STATE_DATE";
  public final static  String S_SpanBusinessId = "SPAN_BUSINESS_ID";
  public final static  String S_FeeMsgFlag = "FEE_MSG_FLAG";
  public final static  String S_ModuleCode = "MODULE_CODE";
  public final static  String S_BusinessId = "BUSINESS_ID";
  public final static  String S_ConMsgFlag = "CON_MSG_FLAG";
  public final static  String S_ReportFlag = "REPORT_FLAG";
  public final static  String S_ReverseBusinessId = "REVERSE_BUSINESS_ID";
  public final static  String S_IncomeType = "INCOME_TYPE";
  public final static  String S_Name = "NAME";
  public final static  String S_LogFlag = "LOG_FLAG";
  public final static  String S_SpanFlag = "SPAN_FLAG";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceOperatorBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //Cannot reset ObjectType
   throw new AIException("Cannot reset ObjectType");
 }


  public void initState(String value){
     this.initProperty(S_State,value);
  }
  public  void setState(String value){
     this.set(S_State,value);
  }
  public  void setStateNull(){
     this.set(S_State,null);
  }

  public String getState(){
       return DataType.getAsString(this.get(S_State));
  
  }
  public String getStateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_State));
      }

  public void initNotes(String value){
     this.initProperty(S_Notes,value);
  }
  public  void setNotes(String value){
     this.set(S_Notes,value);
  }
  public  void setNotesNull(){
     this.set(S_Notes,null);
  }

  public String getNotes(){
       return DataType.getAsString(this.get(S_Notes));
  
  }
  public String getNotesInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Notes));
      }

  public void initStateDate(Timestamp value){
     this.initProperty(S_StateDate,value);
  }
  public  void setStateDate(Timestamp value){
     this.set(S_StateDate,value);
  }
  public  void setStateDateNull(){
     this.set(S_StateDate,null);
  }

  public Timestamp getStateDate(){
        return DataType.getAsDateTime(this.get(S_StateDate));
  
  }
  public Timestamp getStateDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_StateDate));
      }

  public void initSpanBusinessId(long value){
     this.initProperty(S_SpanBusinessId,new Long(value));
  }
  public  void setSpanBusinessId(long value){
     this.set(S_SpanBusinessId,new Long(value));
  }
  public  void setSpanBusinessIdNull(){
     this.set(S_SpanBusinessId,null);
  }

  public long getSpanBusinessId(){
        return DataType.getAsLong(this.get(S_SpanBusinessId));
  
  }
  public long getSpanBusinessIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SpanBusinessId));
      }

  public void initFeeMsgFlag(String value){
     this.initProperty(S_FeeMsgFlag,value);
  }
  public  void setFeeMsgFlag(String value){
     this.set(S_FeeMsgFlag,value);
  }
  public  void setFeeMsgFlagNull(){
     this.set(S_FeeMsgFlag,null);
  }

  public String getFeeMsgFlag(){
       return DataType.getAsString(this.get(S_FeeMsgFlag));
  
  }
  public String getFeeMsgFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FeeMsgFlag));
      }

  public void initModuleCode(String value){
     this.initProperty(S_ModuleCode,value);
  }
  public  void setModuleCode(String value){
     this.set(S_ModuleCode,value);
  }
  public  void setModuleCodeNull(){
     this.set(S_ModuleCode,null);
  }

  public String getModuleCode(){
       return DataType.getAsString(this.get(S_ModuleCode));
  
  }
  public String getModuleCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ModuleCode));
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

  public void initConMsgFlag(String value){
     this.initProperty(S_ConMsgFlag,value);
  }
  public  void setConMsgFlag(String value){
     this.set(S_ConMsgFlag,value);
  }
  public  void setConMsgFlagNull(){
     this.set(S_ConMsgFlag,null);
  }

  public String getConMsgFlag(){
       return DataType.getAsString(this.get(S_ConMsgFlag));
  
  }
  public String getConMsgFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ConMsgFlag));
      }

  public void initReportFlag(String value){
     this.initProperty(S_ReportFlag,value);
  }
  public  void setReportFlag(String value){
     this.set(S_ReportFlag,value);
  }
  public  void setReportFlagNull(){
     this.set(S_ReportFlag,null);
  }

  public String getReportFlag(){
       return DataType.getAsString(this.get(S_ReportFlag));
  
  }
  public String getReportFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ReportFlag));
      }

  public void initReverseBusinessId(long value){
     this.initProperty(S_ReverseBusinessId,new Long(value));
  }
  public  void setReverseBusinessId(long value){
     this.set(S_ReverseBusinessId,new Long(value));
  }
  public  void setReverseBusinessIdNull(){
     this.set(S_ReverseBusinessId,null);
  }

  public long getReverseBusinessId(){
        return DataType.getAsLong(this.get(S_ReverseBusinessId));
  
  }
  public long getReverseBusinessIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ReverseBusinessId));
      }

  public void initIncomeType(int value){
     this.initProperty(S_IncomeType,new Integer(value));
  }
  public  void setIncomeType(int value){
     this.set(S_IncomeType,new Integer(value));
  }
  public  void setIncomeTypeNull(){
     this.set(S_IncomeType,null);
  }

  public int getIncomeType(){
        return DataType.getAsInt(this.get(S_IncomeType));
  
  }
  public int getIncomeTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_IncomeType));
      }

  public void initName(String value){
     this.initProperty(S_Name,value);
  }
  public  void setName(String value){
     this.set(S_Name,value);
  }
  public  void setNameNull(){
     this.set(S_Name,null);
  }

  public String getName(){
       return DataType.getAsString(this.get(S_Name));
  
  }
  public String getNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Name));
      }

  public void initLogFlag(String value){
     this.initProperty(S_LogFlag,value);
  }
  public  void setLogFlag(String value){
     this.set(S_LogFlag,value);
  }
  public  void setLogFlagNull(){
     this.set(S_LogFlag,null);
  }

  public String getLogFlag(){
       return DataType.getAsString(this.get(S_LogFlag));
  
  }
  public String getLogFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_LogFlag));
      }

  public void initSpanFlag(String value){
     this.initProperty(S_SpanFlag,value);
  }
  public  void setSpanFlag(String value){
     this.set(S_SpanFlag,value);
  }
  public  void setSpanFlagNull(){
     this.set(S_SpanFlag,null);
  }

  public String getSpanFlag(){
       return DataType.getAsString(this.get(S_SpanFlag));
  
  }
  public String getSpanFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SpanFlag));
      }


 
 }

