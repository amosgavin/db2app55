package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceAttrBean extends DataContainer implements DataContainerInterface,IBceAttrValue{

  private static String  m_boName = "com.ai.bce.bo.BceAttr";



  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_RuleId = "RULE_ID";
  public final static  String S_AttrName = "ATTR_NAME";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_ObjName = "OBJ_NAME";
  public final static  String S_ValueClass = "VALUE_CLASS";
  public final static  String S_EditType = "EDIT_TYPE";
  public final static  String S_MaxLength = "MAX_LENGTH";
  public final static  String S_ResSrc = "RES_SRC";
  public final static  String S_EffType = "EFF_TYPE";
  public final static  String S_FieldWidth = "FIELD_WIDTH";
  public final static  String S_IsNullable = "IS_NULLABLE";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_MutiFlag = "MUTI_FLAG";
  public final static  String S_ColSpan = "COL_SPAN";
  public final static  String S_FieldType = "FIELD_TYPE";
  public final static  String S_I18nRes = "I18N_RES";
  public final static  String S_AttrCode = "ATTR_CODE";
  public final static  String S_IsMultivalueable = "IS_MULTIVALUEABLE";
  public final static  String S_DefaultValue = "DEFAULT_VALUE";
  public final static  String S_FieldHeight = "FIELD_HEIGHT";
  public final static  String S_AttrId = "ATTR_ID";
  public final static  String S_ResParam = "RES_PARAM";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceAttrBean() throws AIException{
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

  public void initRuleId(String value){
     this.initProperty(S_RuleId,value);
  }
  public  void setRuleId(String value){
     this.set(S_RuleId,value);
  }
  public  void setRuleIdNull(){
     this.set(S_RuleId,null);
  }

  public String getRuleId(){
       return DataType.getAsString(this.get(S_RuleId));
  
  }
  public String getRuleIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RuleId));
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

  public void initValueClass(String value){
     this.initProperty(S_ValueClass,value);
  }
  public  void setValueClass(String value){
     this.set(S_ValueClass,value);
  }
  public  void setValueClassNull(){
     this.set(S_ValueClass,null);
  }

  public String getValueClass(){
       return DataType.getAsString(this.get(S_ValueClass));
  
  }
  public String getValueClassInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ValueClass));
      }

  public void initEditType(int value){
     this.initProperty(S_EditType,new Integer(value));
  }
  public  void setEditType(int value){
     this.set(S_EditType,new Integer(value));
  }
  public  void setEditTypeNull(){
     this.set(S_EditType,null);
  }

  public int getEditType(){
        return DataType.getAsInt(this.get(S_EditType));
  
  }
  public int getEditTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_EditType));
      }

  public void initMaxLength(int value){
     this.initProperty(S_MaxLength,new Integer(value));
  }
  public  void setMaxLength(int value){
     this.set(S_MaxLength,new Integer(value));
  }
  public  void setMaxLengthNull(){
     this.set(S_MaxLength,null);
  }

  public int getMaxLength(){
        return DataType.getAsInt(this.get(S_MaxLength));
  
  }
  public int getMaxLengthInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_MaxLength));
      }

  public void initResSrc(String value){
     this.initProperty(S_ResSrc,value);
  }
  public  void setResSrc(String value){
     this.set(S_ResSrc,value);
  }
  public  void setResSrcNull(){
     this.set(S_ResSrc,null);
  }

  public String getResSrc(){
       return DataType.getAsString(this.get(S_ResSrc));
  
  }
  public String getResSrcInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ResSrc));
      }

  public void initEffType(int value){
     this.initProperty(S_EffType,new Integer(value));
  }
  public  void setEffType(int value){
     this.set(S_EffType,new Integer(value));
  }
  public  void setEffTypeNull(){
     this.set(S_EffType,null);
  }

  public int getEffType(){
        return DataType.getAsInt(this.get(S_EffType));
  
  }
  public int getEffTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_EffType));
      }

  public void initFieldWidth(String value){
     this.initProperty(S_FieldWidth,value);
  }
  public  void setFieldWidth(String value){
     this.set(S_FieldWidth,value);
  }
  public  void setFieldWidthNull(){
     this.set(S_FieldWidth,null);
  }

  public String getFieldWidth(){
       return DataType.getAsString(this.get(S_FieldWidth));
  
  }
  public String getFieldWidthInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FieldWidth));
      }

  public void initIsNullable(int value){
     this.initProperty(S_IsNullable,new Integer(value));
  }
  public  void setIsNullable(int value){
     this.set(S_IsNullable,new Integer(value));
  }
  public  void setIsNullableNull(){
     this.set(S_IsNullable,null);
  }

  public int getIsNullable(){
        return DataType.getAsInt(this.get(S_IsNullable));
  
  }
  public int getIsNullableInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_IsNullable));
      }

  public void initRegionId(String value){
     this.initProperty(S_RegionId,value);
  }
  public  void setRegionId(String value){
     this.set(S_RegionId,value);
  }
  public  void setRegionIdNull(){
     this.set(S_RegionId,null);
  }

  public String getRegionId(){
       return DataType.getAsString(this.get(S_RegionId));
  
  }
  public String getRegionIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RegionId));
      }

  public void initMutiFlag(int value){
     this.initProperty(S_MutiFlag,new Integer(value));
  }
  public  void setMutiFlag(int value){
     this.set(S_MutiFlag,new Integer(value));
  }
  public  void setMutiFlagNull(){
     this.set(S_MutiFlag,null);
  }

  public int getMutiFlag(){
        return DataType.getAsInt(this.get(S_MutiFlag));
  
  }
  public int getMutiFlagInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_MutiFlag));
      }

  public void initColSpan(int value){
     this.initProperty(S_ColSpan,new Integer(value));
  }
  public  void setColSpan(int value){
     this.set(S_ColSpan,new Integer(value));
  }
  public  void setColSpanNull(){
     this.set(S_ColSpan,null);
  }

  public int getColSpan(){
        return DataType.getAsInt(this.get(S_ColSpan));
  
  }
  public int getColSpanInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_ColSpan));
      }

  public void initFieldType(String value){
     this.initProperty(S_FieldType,value);
  }
  public  void setFieldType(String value){
     this.set(S_FieldType,value);
  }
  public  void setFieldTypeNull(){
     this.set(S_FieldType,null);
  }

  public String getFieldType(){
       return DataType.getAsString(this.get(S_FieldType));
  
  }
  public String getFieldTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FieldType));
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

  public void initAttrCode(String value){
     this.initProperty(S_AttrCode,value);
  }
  public  void setAttrCode(String value){
     this.set(S_AttrCode,value);
  }
  public  void setAttrCodeNull(){
     this.set(S_AttrCode,null);
  }

  public String getAttrCode(){
       return DataType.getAsString(this.get(S_AttrCode));
  
  }
  public String getAttrCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AttrCode));
      }

  public void initIsMultivalueable(int value){
     this.initProperty(S_IsMultivalueable,new Integer(value));
  }
  public  void setIsMultivalueable(int value){
     this.set(S_IsMultivalueable,new Integer(value));
  }
  public  void setIsMultivalueableNull(){
     this.set(S_IsMultivalueable,null);
  }

  public int getIsMultivalueable(){
        return DataType.getAsInt(this.get(S_IsMultivalueable));
  
  }
  public int getIsMultivalueableInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_IsMultivalueable));
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

  public void initFieldHeight(String value){
     this.initProperty(S_FieldHeight,value);
  }
  public  void setFieldHeight(String value){
     this.set(S_FieldHeight,value);
  }
  public  void setFieldHeightNull(){
     this.set(S_FieldHeight,null);
  }

  public String getFieldHeight(){
       return DataType.getAsString(this.get(S_FieldHeight));
  
  }
  public String getFieldHeightInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FieldHeight));
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

  public void initResParam(String value){
     this.initProperty(S_ResParam,value);
  }
  public  void setResParam(String value){
     this.set(S_ResParam,value);
  }
  public  void setResParamNull(){
     this.set(S_ResParam,null);
  }

  public String getResParam(){
       return DataType.getAsString(this.get(S_ResParam));
  
  }
  public String getResParamInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ResParam));
      }


 
 }

