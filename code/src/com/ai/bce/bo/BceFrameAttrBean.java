package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceFrameAttrBean extends DataContainer implements DataContainerInterface,IBceFrameAttrValue{

  private static String  m_boName = "com.ai.bce.bo.BceFrameAttr";



  public final static  String S_IsVisible = "IS_VISIBLE";
  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_AttrName = "ATTR_NAME";
  public final static  String S_EditType = "EDIT_TYPE";
  public final static  String S_IsLog = "IS_LOG";
  public final static  String S_MaxLength = "MAX_LENGTH";
  public final static  String S_FieldWidth = "FIELD_WIDTH";
  public final static  String S_IsNullable = "IS_NULLABLE";
  public final static  String S_SeqNo = "SEQ_NO";
  public final static  String S_IsEditable = "IS_EDITABLE";
  public final static  String S_I18nRes = "I18N_RES";
  public final static  String S_IsMultivalueable = "IS_MULTIVALUEABLE";
  public final static  String S_AttrId = "ATTR_ID";
  public final static  String S_IsValidate = "IS_VALIDATE";
  public final static  String S_GroupId = "GROUP_ID";
  public final static  String S_FormId = "FORM_ID";
  public final static  String S_ValueClass = "VALUE_CLASS";
  public final static  String S_ResSrc = "RES_SRC";
  public final static  String S_EffType = "EFF_TYPE";
  public final static  String S_Ext1 = "EXT_1";
  public final static  String S_BceFrameId = "BCE_FRAME_ID";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_ColSpan = "COL_SPAN";
  public final static  String S_MutiFlag = "MUTI_FLAG";
  public final static  String S_Ext3 = "EXT_3";
  public final static  String S_Ext2 = "EXT_2";
  public final static  String S_DefaultValue = "DEFAULT_VALUE";
  public final static  String S_FieldHeight = "FIELD_HEIGHT";
  public final static  String S_ResParam = "RES_PARAM";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceFrameAttrBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initIsVisible(int value){
     this.initProperty(S_IsVisible,new Integer(value));
  }
  public  void setIsVisible(int value){
     this.set(S_IsVisible,new Integer(value));
  }
  public  void setIsVisibleNull(){
     this.set(S_IsVisible,null);
  }

  public int getIsVisible(){
        return DataType.getAsInt(this.get(S_IsVisible));
  
  }
  public int getIsVisibleInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_IsVisible));
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

  public void initIsLog(int value){
     this.initProperty(S_IsLog,new Integer(value));
  }
  public  void setIsLog(int value){
     this.set(S_IsLog,new Integer(value));
  }
  public  void setIsLogNull(){
     this.set(S_IsLog,null);
  }

  public int getIsLog(){
        return DataType.getAsInt(this.get(S_IsLog));
  
  }
  public int getIsLogInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_IsLog));
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

  public void initIsEditable(int value){
     this.initProperty(S_IsEditable,new Integer(value));
  }
  public  void setIsEditable(int value){
     this.set(S_IsEditable,new Integer(value));
  }
  public  void setIsEditableNull(){
     this.set(S_IsEditable,null);
  }

  public int getIsEditable(){
        return DataType.getAsInt(this.get(S_IsEditable));
  
  }
  public int getIsEditableInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_IsEditable));
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

  public void initIsValidate(int value){
     this.initProperty(S_IsValidate,new Integer(value));
  }
  public  void setIsValidate(int value){
     this.set(S_IsValidate,new Integer(value));
  }
  public  void setIsValidateNull(){
     this.set(S_IsValidate,null);
  }

  public int getIsValidate(){
        return DataType.getAsInt(this.get(S_IsValidate));
  
  }
  public int getIsValidateInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_IsValidate));
      }

  public void initGroupId(long value){
     this.initProperty(S_GroupId,new Long(value));
  }
  public  void setGroupId(long value){
     this.set(S_GroupId,new Long(value));
  }
  public  void setGroupIdNull(){
     this.set(S_GroupId,null);
  }

  public long getGroupId(){
        return DataType.getAsLong(this.get(S_GroupId));
  
  }
  public long getGroupIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_GroupId));
      }

  public void initFormId(String value){
     this.initProperty(S_FormId,value);
  }
  public  void setFormId(String value){
     this.set(S_FormId,value);
  }
  public  void setFormIdNull(){
     this.set(S_FormId,null);
  }

  public String getFormId(){
       return DataType.getAsString(this.get(S_FormId));
  
  }
  public String getFormIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FormId));
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

  public void initExt1(String value){
     this.initProperty(S_Ext1,value);
  }
  public  void setExt1(String value){
     this.set(S_Ext1,value);
  }
  public  void setExt1Null(){
     this.set(S_Ext1,null);
  }

  public String getExt1(){
       return DataType.getAsString(this.get(S_Ext1));
  
  }
  public String getExt1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext1));
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

  public void initExt3(long value){
     this.initProperty(S_Ext3,new Long(value));
  }
  public  void setExt3(long value){
     this.set(S_Ext3,new Long(value));
  }
  public  void setExt3Null(){
     this.set(S_Ext3,null);
  }

  public long getExt3(){
        return DataType.getAsLong(this.get(S_Ext3));
  
  }
  public long getExt3InitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Ext3));
      }

  public void initExt2(String value){
     this.initProperty(S_Ext2,value);
  }
  public  void setExt2(String value){
     this.set(S_Ext2,value);
  }
  public  void setExt2Null(){
     this.set(S_Ext2,null);
  }

  public String getExt2(){
       return DataType.getAsString(this.get(S_Ext2));
  
  }
  public String getExt2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Ext2));
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

