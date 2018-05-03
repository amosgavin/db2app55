package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceFrameJavaRulesetRelBean extends DataContainer implements DataContainerInterface,IBceFrameJavaRulesetRelValue{

  private static String  m_boName = "com.ai.bce.bo.BceFrameJavaRulesetRel";



  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_RelateId = "RELATE_ID";
  public final static  String S_BceFrameId = "BCE_FRAME_ID";
  public final static  String S_RulesetId = "RULESET_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_ParamData = "PARAM_DATA";
  public final static  String S_RulesetType = "RULESET_TYPE";
  public final static  String S_CheckType = "CHECK_TYPE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceFrameJavaRulesetRelBean() throws AIException{
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

  public void initRelateId(long value){
     this.initProperty(S_RelateId,new Long(value));
  }
  public  void setRelateId(long value){
     this.set(S_RelateId,new Long(value));
  }

  public  void setRelateId(Long value){
     this.set(S_RelateId,value);
  }
  
  public  Long  getRelateIdAsLong(){
     return (Long )this.get(S_RelateId);
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

  public void initBceFrameId(long value){
     this.initProperty(S_BceFrameId,new Long(value));
  }
  public  void setBceFrameId(long value){
     this.set(S_BceFrameId,new Long(value));
  }

  public  void setBceFrameId(Long value){
     this.set(S_BceFrameId,value);
  }
  
  public  Long  getBceFrameIdAsLong(){
     return (Long )this.get(S_BceFrameId);
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

  public void initParamData(String value){
     this.initProperty(S_ParamData,value);
  }
  public  void setParamData(String value){
     this.set(S_ParamData,value);
  }

  
  
  public  void setParamDataNull(){
     this.set(S_ParamData,null);
  }

  public String getParamData(){
       return DataType.getAsString(this.get(S_ParamData));
  
  }
  public String getParamDataInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ParamData));
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

  public void initCheckType(int value){
     this.initProperty(S_CheckType,new Integer(value));
  }
  public  void setCheckType(int value){
     this.set(S_CheckType,new Integer(value));
  }

  public  void setCheckType(Integer value){
     this.set(S_CheckType,value);
  }
  
  public  Integer  getCheckTypeAsInteger(){
     return (Integer )this.get(S_CheckType);
  }
  
  
  public  void setCheckTypeNull(){
     this.set(S_CheckType,null);
  }

  public int getCheckType(){
        return DataType.getAsInt(this.get(S_CheckType));
  
  }
  public int getCheckTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_CheckType));
      }


 
 }

