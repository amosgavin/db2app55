package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class QBOBcePageRulesetRuleBean extends DataContainer implements DataContainerInterface,IQBOBcePageRulesetRuleValue{

  private static String  m_boName = "com.ai.bce.bo.QBOBcePageRulesetRule";



  public final static  String S_EventName = "EVENT_NAME";
  public final static  String S_ParamValueList = "PARAM_VALUE_LIST";
  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_RuleId = "RULE_ID";
  public final static  String S_RuleType = "RULE_TYPE";
  public final static  String S_ParamList = "PARAM_LIST";
  public final static  String S_RuleTriggerType = "RULE_TRIGGER_TYPE";
  public final static  String S_RuleKind = "RULE_KIND";
  public final static  String S_ObjName = "OBJ_NAME";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_ChildObjName = "CHILD_OBJ_NAME";
  public final static  String S_RelateId = "RELATE_ID";
  public final static  String S_VerifyType = "VERIFY_TYPE";
  public final static  String S_AlertMessage = "ALERT_MESSAGE";
  public final static  String S_FileName = "FILE_NAME";
  public final static  String S_RuleName = "RULE_NAME";
  public final static  String S_FuncName = "FUNC_NAME";
  public final static  String S_EventObjType = "EVENT_OBJ_TYPE";
  public final static  String S_RulesetId = "RULESET_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QBOBcePageRulesetRuleBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //Cannot reset ObjectType
   throw new AIException("Cannot reset ObjectType");
 }


  public void initEventName(String value){
     this.initProperty(S_EventName,value);
  }
  public  void setEventName(String value){
     this.set(S_EventName,value);
  }
  public  void setEventNameNull(){
     this.set(S_EventName,null);
  }

  public String getEventName(){
       return DataType.getAsString(this.get(S_EventName));
  
  }
  public String getEventNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_EventName));
      }

  public void initParamValueList(String value){
     this.initProperty(S_ParamValueList,value);
  }
  public  void setParamValueList(String value){
     this.set(S_ParamValueList,value);
  }
  public  void setParamValueListNull(){
     this.set(S_ParamValueList,null);
  }

  public String getParamValueList(){
       return DataType.getAsString(this.get(S_ParamValueList));
  
  }
  public String getParamValueListInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ParamValueList));
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

  public void initState(long value){
     this.initProperty(S_State,new Long(value));
  }
  public  void setState(long value){
     this.set(S_State,new Long(value));
  }
  public  void setStateNull(){
     this.set(S_State,null);
  }

  public long getState(){
        return DataType.getAsLong(this.get(S_State));
  
  }
  public long getStateInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_State));
      }

  public void initRuleId(long value){
     this.initProperty(S_RuleId,new Long(value));
  }
  public  void setRuleId(long value){
     this.set(S_RuleId,new Long(value));
  }
  public  void setRuleIdNull(){
     this.set(S_RuleId,null);
  }

  public long getRuleId(){
        return DataType.getAsLong(this.get(S_RuleId));
  
  }
  public long getRuleIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RuleId));
      }

  public void initRuleType(long value){
     this.initProperty(S_RuleType,new Long(value));
  }
  public  void setRuleType(long value){
     this.set(S_RuleType,new Long(value));
  }
  public  void setRuleTypeNull(){
     this.set(S_RuleType,null);
  }

  public long getRuleType(){
        return DataType.getAsLong(this.get(S_RuleType));
  
  }
  public long getRuleTypeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RuleType));
      }

  public void initParamList(String value){
     this.initProperty(S_ParamList,value);
  }
  public  void setParamList(String value){
     this.set(S_ParamList,value);
  }
  public  void setParamListNull(){
     this.set(S_ParamList,null);
  }

  public String getParamList(){
       return DataType.getAsString(this.get(S_ParamList));
  
  }
  public String getParamListInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ParamList));
      }

  public void initRuleTriggerType(long value){
     this.initProperty(S_RuleTriggerType,new Long(value));
  }
  public  void setRuleTriggerType(long value){
     this.set(S_RuleTriggerType,new Long(value));
  }
  public  void setRuleTriggerTypeNull(){
     this.set(S_RuleTriggerType,null);
  }

  public long getRuleTriggerType(){
        return DataType.getAsLong(this.get(S_RuleTriggerType));
  
  }
  public long getRuleTriggerTypeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RuleTriggerType));
      }

  public void initRuleKind(long value){
     this.initProperty(S_RuleKind,new Long(value));
  }
  public  void setRuleKind(long value){
     this.set(S_RuleKind,new Long(value));
  }
  public  void setRuleKindNull(){
     this.set(S_RuleKind,null);
  }

  public long getRuleKind(){
        return DataType.getAsLong(this.get(S_RuleKind));
  
  }
  public long getRuleKindInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RuleKind));
      }

  public void initObjName(String value){
     this.initProperty(S_ObjName,value);
  }
  public  void setObjName(String value){
     this.set(S_ObjName,value);
  }
  public  void setObjNameNull(){
     this.set(S_ObjName,null);
  }

  public String getObjName(){
       return DataType.getAsString(this.get(S_ObjName));
  
  }
  public String getObjNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ObjName));
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

  public void initChildObjName(String value){
     this.initProperty(S_ChildObjName,value);
  }
  public  void setChildObjName(String value){
     this.set(S_ChildObjName,value);
  }
  public  void setChildObjNameNull(){
     this.set(S_ChildObjName,null);
  }

  public String getChildObjName(){
       return DataType.getAsString(this.get(S_ChildObjName));
  
  }
  public String getChildObjNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ChildObjName));
      }

  public void initRelateId(long value){
     this.initProperty(S_RelateId,new Long(value));
  }
  public  void setRelateId(long value){
     this.set(S_RelateId,new Long(value));
  }
  public  void setRelateIdNull(){
     this.set(S_RelateId,null);
  }

  public long getRelateId(){
        return DataType.getAsLong(this.get(S_RelateId));
  
  }
  public long getRelateIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RelateId));
      }

  public void initVerifyType(long value){
     this.initProperty(S_VerifyType,new Long(value));
  }
  public  void setVerifyType(long value){
     this.set(S_VerifyType,new Long(value));
  }
  public  void setVerifyTypeNull(){
     this.set(S_VerifyType,null);
  }

  public long getVerifyType(){
        return DataType.getAsLong(this.get(S_VerifyType));
  
  }
  public long getVerifyTypeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_VerifyType));
      }

  public void initAlertMessage(String value){
     this.initProperty(S_AlertMessage,value);
  }
  public  void setAlertMessage(String value){
     this.set(S_AlertMessage,value);
  }
  public  void setAlertMessageNull(){
     this.set(S_AlertMessage,null);
  }

  public String getAlertMessage(){
       return DataType.getAsString(this.get(S_AlertMessage));
  
  }
  public String getAlertMessageInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AlertMessage));
      }

  public void initFileName(String value){
     this.initProperty(S_FileName,value);
  }
  public  void setFileName(String value){
     this.set(S_FileName,value);
  }
  public  void setFileNameNull(){
     this.set(S_FileName,null);
  }

  public String getFileName(){
       return DataType.getAsString(this.get(S_FileName));
  
  }
  public String getFileNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FileName));
      }

  public void initRuleName(String value){
     this.initProperty(S_RuleName,value);
  }
  public  void setRuleName(String value){
     this.set(S_RuleName,value);
  }
  public  void setRuleNameNull(){
     this.set(S_RuleName,null);
  }

  public String getRuleName(){
       return DataType.getAsString(this.get(S_RuleName));
  
  }
  public String getRuleNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RuleName));
      }

  public void initFuncName(String value){
     this.initProperty(S_FuncName,value);
  }
  public  void setFuncName(String value){
     this.set(S_FuncName,value);
  }
  public  void setFuncNameNull(){
     this.set(S_FuncName,null);
  }

  public String getFuncName(){
       return DataType.getAsString(this.get(S_FuncName));
  
  }
  public String getFuncNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FuncName));
      }

  public void initEventObjType(long value){
     this.initProperty(S_EventObjType,new Long(value));
  }
  public  void setEventObjType(long value){
     this.set(S_EventObjType,new Long(value));
  }
  public  void setEventObjTypeNull(){
     this.set(S_EventObjType,null);
  }

  public long getEventObjType(){
        return DataType.getAsLong(this.get(S_EventObjType));
  
  }
  public long getEventObjTypeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_EventObjType));
      }

  public void initRulesetId(long value){
     this.initProperty(S_RulesetId,new Long(value));
  }
  public  void setRulesetId(long value){
     this.set(S_RulesetId,new Long(value));
  }
  public  void setRulesetIdNull(){
     this.set(S_RulesetId,null);
  }

  public long getRulesetId(){
        return DataType.getAsLong(this.get(S_RulesetId));
  
  }
  public long getRulesetIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_RulesetId));
      }


 
 }

