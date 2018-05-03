package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceRulesetBean extends DataContainer implements DataContainerInterface,IBceRulesetValue{

  private static String  m_boName = "com.ai.bce.bo.BceRuleset";



  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_RulesetId = "RULESET_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_RulesetType = "RULESET_TYPE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceRulesetBean() throws AIException{
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

  public void initRulesetId(long value){
     this.initProperty(S_RulesetId,new Long(value));
  }
  public  void setRulesetId(long value){
     this.set(S_RulesetId,new Long(value));
  }

  public  void setRulesetId(Long value){
     this.set(S_RulesetId,value);
  }
  
  public  Long  getRulesetIdAsLong(){
     return (Long )this.get(S_RulesetId);
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

  public void initRulesetType(int value){
     this.initProperty(S_RulesetType,new Integer(value));
  }
  public  void setRulesetType(int value){
     this.set(S_RulesetType,new Integer(value));
  }

  public  void setRulesetType(Integer value){
     this.set(S_RulesetType,value);
  }
  
  public  Integer  getRulesetTypeAsInteger(){
     return (Integer )this.get(S_RulesetType);
  }
  
  
  public  void setRulesetTypeNull(){
     this.set(S_RulesetType,null);
  }

  public int getRulesetType(){
        return DataType.getAsInt(this.get(S_RulesetType));
  
  }
  public int getRulesetTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_RulesetType));
      }


 
 }

