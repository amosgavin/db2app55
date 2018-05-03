package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceFrameAreaFormBean extends DataContainer implements DataContainerInterface,IBceFrameAreaFormValue{

  private static String  m_boName = "com.ai.bce.bo.BceFrameAreaForm";



  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_IsInitial = "IS_INITIAL";
  public final static  String S_State = "STATE";
  public final static  String S_Cols = "COLS";
  public final static  String S_BceFrameId = "BCE_FRAME_ID";
  public final static  String S_OnDbclick = "ON_DBCLICK";
  public final static  String S_Validation = "VALIDATION";
  public final static  String S_MultSelect = "MULT_SELECT";
  public final static  String S_TemplateId = "TEMPLATE_ID";
  public final static  String S_FormId = "FORM_ID";
  public final static  String S_QueryMethod = "QUERY_METHOD";
  public final static  String S_ParameterName = "PARAMETER_NAME";
  public final static  String S_RowHeight = "ROW_HEIGHT";
  public final static  String S_IsEditable = "IS_EDITABLE";
  public final static  String S_ServiceName = "SERVICE_NAME";
  public final static  String S_OnValuechange = "ON_VALUECHANGE";
  public final static  String S_ConditionName = "CONDITION_NAME";
  public final static  String S_FootDisplay = "FOOT_DISPLAY";
  public final static  String S_FormType = "FORM_TYPE";
  public final static  String S_DataModel = "DATA_MODEL";
  public final static  String S_NeedRefresh = "NEED_REFRESH";
  public final static  String S_Height = "HEIGHT";
  public final static  String S_Operator = "OPERATOR";
  public final static  String S_OnRowchange = "ON_ROWCHANGE";
  public final static  String S_CountMethod = "COUNT_METHOD";
  public final static  String S_Mo = "MO";
  public final static  String S_PageSize = "PAGE_SIZE";
  public final static  String S_Width = "WIDTH";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceFrameAreaFormBean() throws AIException{
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

  public void initIsInitial(int value){
     this.initProperty(S_IsInitial,new Integer(value));
  }
  public  void setIsInitial(int value){
     this.set(S_IsInitial,new Integer(value));
  }

  public  void setIsInitial(Integer value){
     this.set(S_IsInitial,value);
  }
  
  public  Integer  getIsInitialAsInteger(){
     return (Integer )this.get(S_IsInitial);
  }
  
  
  public  void setIsInitialNull(){
     this.set(S_IsInitial,null);
  }

  public int getIsInitial(){
        return DataType.getAsInt(this.get(S_IsInitial));
  
  }
  public int getIsInitialInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_IsInitial));
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

  public void initCols(int value){
     this.initProperty(S_Cols,new Integer(value));
  }
  public  void setCols(int value){
     this.set(S_Cols,new Integer(value));
  }

  public  void setCols(Integer value){
     this.set(S_Cols,value);
  }
  
  public  Integer  getColsAsInteger(){
     return (Integer )this.get(S_Cols);
  }
  
  
  public  void setColsNull(){
     this.set(S_Cols,null);
  }

  public int getCols(){
        return DataType.getAsInt(this.get(S_Cols));
  
  }
  public int getColsInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Cols));
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

  public void initOnDbclick(String value){
     this.initProperty(S_OnDbclick,value);
  }
  public  void setOnDbclick(String value){
     this.set(S_OnDbclick,value);
  }

  
  
  public  void setOnDbclickNull(){
     this.set(S_OnDbclick,null);
  }

  public String getOnDbclick(){
       return DataType.getAsString(this.get(S_OnDbclick));
  
  }
  public String getOnDbclickInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OnDbclick));
      }

  public void initValidation(String value){
     this.initProperty(S_Validation,value);
  }
  public  void setValidation(String value){
     this.set(S_Validation,value);
  }

  
  
  public  void setValidationNull(){
     this.set(S_Validation,null);
  }

  public String getValidation(){
       return DataType.getAsString(this.get(S_Validation));
  
  }
  public String getValidationInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Validation));
      }

  public void initMultSelect(int value){
     this.initProperty(S_MultSelect,new Integer(value));
  }
  public  void setMultSelect(int value){
     this.set(S_MultSelect,new Integer(value));
  }

  public  void setMultSelect(Integer value){
     this.set(S_MultSelect,value);
  }
  
  public  Integer  getMultSelectAsInteger(){
     return (Integer )this.get(S_MultSelect);
  }
  
  
  public  void setMultSelectNull(){
     this.set(S_MultSelect,null);
  }

  public int getMultSelect(){
        return DataType.getAsInt(this.get(S_MultSelect));
  
  }
  public int getMultSelectInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_MultSelect));
      }

  public void initTemplateId(String value){
     this.initProperty(S_TemplateId,value);
  }
  public  void setTemplateId(String value){
     this.set(S_TemplateId,value);
  }

  
  
  public  void setTemplateIdNull(){
     this.set(S_TemplateId,null);
  }

  public String getTemplateId(){
       return DataType.getAsString(this.get(S_TemplateId));
  
  }
  public String getTemplateIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TemplateId));
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

  public void initQueryMethod(String value){
     this.initProperty(S_QueryMethod,value);
  }
  public  void setQueryMethod(String value){
     this.set(S_QueryMethod,value);
  }

  
  
  public  void setQueryMethodNull(){
     this.set(S_QueryMethod,null);
  }

  public String getQueryMethod(){
       return DataType.getAsString(this.get(S_QueryMethod));
  
  }
  public String getQueryMethodInitialValue(){
        return DataType.getAsString(this.getOldObj(S_QueryMethod));
      }

  public void initParameterName(String value){
     this.initProperty(S_ParameterName,value);
  }
  public  void setParameterName(String value){
     this.set(S_ParameterName,value);
  }

  
  
  public  void setParameterNameNull(){
     this.set(S_ParameterName,null);
  }

  public String getParameterName(){
       return DataType.getAsString(this.get(S_ParameterName));
  
  }
  public String getParameterNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ParameterName));
      }

  public void initRowHeight(String value){
     this.initProperty(S_RowHeight,value);
  }
  public  void setRowHeight(String value){
     this.set(S_RowHeight,value);
  }

  
  
  public  void setRowHeightNull(){
     this.set(S_RowHeight,null);
  }

  public String getRowHeight(){
       return DataType.getAsString(this.get(S_RowHeight));
  
  }
  public String getRowHeightInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RowHeight));
      }

  public void initIsEditable(int value){
     this.initProperty(S_IsEditable,new Integer(value));
  }
  public  void setIsEditable(int value){
     this.set(S_IsEditable,new Integer(value));
  }

  public  void setIsEditable(Integer value){
     this.set(S_IsEditable,value);
  }
  
  public  Integer  getIsEditableAsInteger(){
     return (Integer )this.get(S_IsEditable);
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

  public void initServiceName(String value){
     this.initProperty(S_ServiceName,value);
  }
  public  void setServiceName(String value){
     this.set(S_ServiceName,value);
  }

  
  
  public  void setServiceNameNull(){
     this.set(S_ServiceName,null);
  }

  public String getServiceName(){
       return DataType.getAsString(this.get(S_ServiceName));
  
  }
  public String getServiceNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ServiceName));
      }

  public void initOnValuechange(String value){
     this.initProperty(S_OnValuechange,value);
  }
  public  void setOnValuechange(String value){
     this.set(S_OnValuechange,value);
  }

  
  
  public  void setOnValuechangeNull(){
     this.set(S_OnValuechange,null);
  }

  public String getOnValuechange(){
       return DataType.getAsString(this.get(S_OnValuechange));
  
  }
  public String getOnValuechangeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OnValuechange));
      }

  public void initConditionName(String value){
     this.initProperty(S_ConditionName,value);
  }
  public  void setConditionName(String value){
     this.set(S_ConditionName,value);
  }

  
  
  public  void setConditionNameNull(){
     this.set(S_ConditionName,null);
  }

  public String getConditionName(){
       return DataType.getAsString(this.get(S_ConditionName));
  
  }
  public String getConditionNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ConditionName));
      }

  public void initFootDisplay(int value){
     this.initProperty(S_FootDisplay,new Integer(value));
  }
  public  void setFootDisplay(int value){
     this.set(S_FootDisplay,new Integer(value));
  }

  public  void setFootDisplay(Integer value){
     this.set(S_FootDisplay,value);
  }
  
  public  Integer  getFootDisplayAsInteger(){
     return (Integer )this.get(S_FootDisplay);
  }
  
  
  public  void setFootDisplayNull(){
     this.set(S_FootDisplay,null);
  }

  public int getFootDisplay(){
        return DataType.getAsInt(this.get(S_FootDisplay));
  
  }
  public int getFootDisplayInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_FootDisplay));
      }

  public void initFormType(int value){
     this.initProperty(S_FormType,new Integer(value));
  }
  public  void setFormType(int value){
     this.set(S_FormType,new Integer(value));
  }

  public  void setFormType(Integer value){
     this.set(S_FormType,value);
  }
  
  public  Integer  getFormTypeAsInteger(){
     return (Integer )this.get(S_FormType);
  }
  
  
  public  void setFormTypeNull(){
     this.set(S_FormType,null);
  }

  public int getFormType(){
        return DataType.getAsInt(this.get(S_FormType));
  
  }
  public int getFormTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_FormType));
      }

  public void initDataModel(String value){
     this.initProperty(S_DataModel,value);
  }
  public  void setDataModel(String value){
     this.set(S_DataModel,value);
  }

  
  
  public  void setDataModelNull(){
     this.set(S_DataModel,null);
  }

  public String getDataModel(){
       return DataType.getAsString(this.get(S_DataModel));
  
  }
  public String getDataModelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DataModel));
      }

  public void initNeedRefresh(int value){
     this.initProperty(S_NeedRefresh,new Integer(value));
  }
  public  void setNeedRefresh(int value){
     this.set(S_NeedRefresh,new Integer(value));
  }

  public  void setNeedRefresh(Integer value){
     this.set(S_NeedRefresh,value);
  }
  
  public  Integer  getNeedRefreshAsInteger(){
     return (Integer )this.get(S_NeedRefresh);
  }
  
  
  public  void setNeedRefreshNull(){
     this.set(S_NeedRefresh,null);
  }

  public int getNeedRefresh(){
        return DataType.getAsInt(this.get(S_NeedRefresh));
  
  }
  public int getNeedRefreshInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_NeedRefresh));
      }

  public void initHeight(String value){
     this.initProperty(S_Height,value);
  }
  public  void setHeight(String value){
     this.set(S_Height,value);
  }

  
  
  public  void setHeightNull(){
     this.set(S_Height,null);
  }

  public String getHeight(){
       return DataType.getAsString(this.get(S_Height));
  
  }
  public String getHeightInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Height));
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

  public void initOnRowchange(String value){
     this.initProperty(S_OnRowchange,value);
  }
  public  void setOnRowchange(String value){
     this.set(S_OnRowchange,value);
  }

  
  
  public  void setOnRowchangeNull(){
     this.set(S_OnRowchange,null);
  }

  public String getOnRowchange(){
       return DataType.getAsString(this.get(S_OnRowchange));
  
  }
  public String getOnRowchangeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OnRowchange));
      }

  public void initCountMethod(String value){
     this.initProperty(S_CountMethod,value);
  }
  public  void setCountMethod(String value){
     this.set(S_CountMethod,value);
  }

  
  
  public  void setCountMethodNull(){
     this.set(S_CountMethod,null);
  }

  public String getCountMethod(){
       return DataType.getAsString(this.get(S_CountMethod));
  
  }
  public String getCountMethodInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CountMethod));
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

  public void initPageSize(int value){
     this.initProperty(S_PageSize,new Integer(value));
  }
  public  void setPageSize(int value){
     this.set(S_PageSize,new Integer(value));
  }

  public  void setPageSize(Integer value){
     this.set(S_PageSize,value);
  }
  
  public  Integer  getPageSizeAsInteger(){
     return (Integer )this.get(S_PageSize);
  }
  
  
  public  void setPageSizeNull(){
     this.set(S_PageSize,null);
  }

  public int getPageSize(){
        return DataType.getAsInt(this.get(S_PageSize));
  
  }
  public int getPageSizeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_PageSize));
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


 
 }

