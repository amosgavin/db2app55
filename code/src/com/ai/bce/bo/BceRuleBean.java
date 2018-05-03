package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceRuleBean extends DataContainer implements DataContainerInterface,IBceRuleValue{

  private static String  m_boName = "com.ai.bce.bo.BceRule";



  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_RuleId = "RULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_ParamList = "PARAM_LIST";
  public final static  String S_RuleType = "RULE_TYPE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_RuleKind = "RULE_KIND";
  public final static  String S_CenterType = "CENTER_TYPE";
  public final static  String S_CenterValueIndex = "CENTER_VALUE_INDEX";
  public final static  String S_AlertMessage = "ALERT_MESSAGE";
  public final static  String S_FileName = "FILE_NAME";
  public final static  String S_RuleName = "RULE_NAME";
  public final static  String S_FuncName = "FUNC_NAME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceRuleBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
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

  public void initCenterType(String value){
     this.initProperty(S_CenterType,value);
  }
  public  void setCenterType(String value){
     this.set(S_CenterType,value);
  }
  public  void setCenterTypeNull(){
     this.set(S_CenterType,null);
  }

  public String getCenterType(){
       return DataType.getAsString(this.get(S_CenterType));
  
  }
  public String getCenterTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CenterType));
      }

  public void initCenterValueIndex(String value){
     this.initProperty(S_CenterValueIndex,value);
  }
  public  void setCenterValueIndex(String value){
     this.set(S_CenterValueIndex,value);
  }
  public  void setCenterValueIndexNull(){
     this.set(S_CenterValueIndex,null);
  }

  public String getCenterValueIndex(){
       return DataType.getAsString(this.get(S_CenterValueIndex));
  
  }
  public String getCenterValueIndexInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CenterValueIndex));
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


 
 }

