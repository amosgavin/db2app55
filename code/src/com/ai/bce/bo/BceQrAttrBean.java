package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceQrAttrBean extends DataContainer implements DataContainerInterface,IBceQrAttrValue{

  private static String  m_boName = "com.ai.bce.bo.BceQrAttr";



  public final static  String S_ParamRe = "PARAM_RE";
  public final static  String S_State = "STATE";
  public final static  String S_AliasName = "ALIAS_NAME";
  public final static  String S_AttrName = "ATTR_NAME";
  public final static  String S_IsList = "IS_LIST";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_BceGetRule = "BCE_GET_RULE";
  public final static  String S_TemplateId = "TEMPLATE_ID";
  public final static  String S_PreAttrId = "PRE_ATTR_ID";
  public final static  String S_TempString = "TEMP_STRING";
  public final static  String S_DefaultValue = "DEFAULT_VALUE";
  public final static  String S_AttrId = "ATTR_ID";
  public final static  String S_IsPre = "IS_PRE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceQrAttrBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initParamRe(String value){
     this.initProperty(S_ParamRe,value);
  }
  public  void setParamRe(String value){
     this.set(S_ParamRe,value);
  }
  public  void setParamReNull(){
     this.set(S_ParamRe,null);
  }

  public String getParamRe(){
       return DataType.getAsString(this.get(S_ParamRe));
  
  }
  public String getParamReInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ParamRe));
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

  public void initAliasName(String value){
     this.initProperty(S_AliasName,value);
  }
  public  void setAliasName(String value){
     this.set(S_AliasName,value);
  }
  public  void setAliasNameNull(){
     this.set(S_AliasName,null);
  }

  public String getAliasName(){
       return DataType.getAsString(this.get(S_AliasName));
  
  }
  public String getAliasNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AliasName));
      }

  public void initAttrName(String value){
     this.initProperty(S_AttrName,value);
  }
  public  void setAttrName(String value){
     this.set(S_AttrName,value);
  }
  public  void setAttrNameNull(){
     this.set(S_AttrName,null);
  }

  public String getAttrName(){
       return DataType.getAsString(this.get(S_AttrName));
  
  }
  public String getAttrNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AttrName));
      }

  public void initIsList(int value){
     this.initProperty(S_IsList,new Integer(value));
  }
  public  void setIsList(int value){
     this.set(S_IsList,new Integer(value));
  }
  public  void setIsListNull(){
     this.set(S_IsList,null);
  }

  public int getIsList(){
        return DataType.getAsInt(this.get(S_IsList));
  
  }
  public int getIsListInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_IsList));
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

  public void initBceGetRule(String value){
     this.initProperty(S_BceGetRule,value);
  }
  public  void setBceGetRule(String value){
     this.set(S_BceGetRule,value);
  }
  public  void setBceGetRuleNull(){
     this.set(S_BceGetRule,null);
  }

  public String getBceGetRule(){
       return DataType.getAsString(this.get(S_BceGetRule));
  
  }
  public String getBceGetRuleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BceGetRule));
      }

  public void initTemplateId(long value){
     this.initProperty(S_TemplateId,new Long(value));
  }
  public  void setTemplateId(long value){
     this.set(S_TemplateId,new Long(value));
  }
  public  void setTemplateIdNull(){
     this.set(S_TemplateId,null);
  }

  public long getTemplateId(){
        return DataType.getAsLong(this.get(S_TemplateId));
  
  }
  public long getTemplateIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TemplateId));
      }

  public void initPreAttrId(long value){
     this.initProperty(S_PreAttrId,new Long(value));
  }
  public  void setPreAttrId(long value){
     this.set(S_PreAttrId,new Long(value));
  }
  public  void setPreAttrIdNull(){
     this.set(S_PreAttrId,null);
  }

  public long getPreAttrId(){
        return DataType.getAsLong(this.get(S_PreAttrId));
  
  }
  public long getPreAttrIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PreAttrId));
      }

  public void initTempString(String value){
     this.initProperty(S_TempString,value);
  }
  public  void setTempString(String value){
     this.set(S_TempString,value);
  }
  public  void setTempStringNull(){
     this.set(S_TempString,null);
  }

  public String getTempString(){
       return DataType.getAsString(this.get(S_TempString));
  
  }
  public String getTempStringInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TempString));
      }

  public void initDefaultValue(String value){
     this.initProperty(S_DefaultValue,value);
  }
  public  void setDefaultValue(String value){
     this.set(S_DefaultValue,value);
  }
  public  void setDefaultValueNull(){
     this.set(S_DefaultValue,null);
  }

  public String getDefaultValue(){
       return DataType.getAsString(this.get(S_DefaultValue));
  
  }
  public String getDefaultValueInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DefaultValue));
      }

  public void initAttrId(long value){
     this.initProperty(S_AttrId,new Long(value));
  }
  public  void setAttrId(long value){
     this.set(S_AttrId,new Long(value));
  }
  public  void setAttrIdNull(){
     this.set(S_AttrId,null);
  }

  public long getAttrId(){
        return DataType.getAsLong(this.get(S_AttrId));
  
  }
  public long getAttrIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_AttrId));
      }

  public void initIsPre(int value){
     this.initProperty(S_IsPre,new Integer(value));
  }
  public  void setIsPre(int value){
     this.set(S_IsPre,new Integer(value));
  }
  public  void setIsPreNull(){
     this.set(S_IsPre,null);
  }

  public int getIsPre(){
        return DataType.getAsInt(this.get(S_IsPre));
  
  }
  public int getIsPreInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_IsPre));
      }


 
 }

