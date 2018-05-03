package com.ai.bce.plugin.grid.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.plugin.grid.ivalues.*;

public class BceTagPGridBean extends DataContainer implements DataContainerInterface,IBceTagPGridValue{

  private static String  m_boName = "com.ai.bce.plugin.grid.bo.BceTagPGrid";



  public final static  String S_State = "STATE";
  public final static  String S_IsInitial = "IS_INITIAL";
  public final static  String S_Editable = "EDITABLE";
  public final static  String S_FootDisplay = "FOOT_DISPLAY";
  public final static  String S_MultSelect = "MULT_SELECT";
  public final static  String S_ObjectId = "OBJECT_ID";
  public final static  String S_SetName = "SET_NAME";
  public final static  String S_QueryMethod = "QUERY_METHOD";
  public final static  String S_DataModel = "DATA_MODEL";
  public final static  String S_GridId = "GRID_ID";
  public final static  String S_RowHeight = "ROW_HEIGHT";
  public final static  String S_NeedRefresh = "NEED_REFRESH";
  public final static  String S_Height = "HEIGHT";
  public final static  String S_Operator = "OPERATOR";
  public final static  String S_ServiceName = "SERVICE_NAME";
  public final static  String S_CountMethod = "COUNT_METHOD";
  public final static  String S_PageSize = "PAGE_SIZE";
  public final static  String S_Mo = "MO";
  public final static  String S_Width = "WIDTH";
  public final static  String S_ConditionName = "CONDITION_NAME";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceTagPGridBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //Cannot reset ObjectType
   throw new AIException("Cannot reset ObjectType");
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

  public void initIsInitial(int value){
     this.initProperty(S_IsInitial,new Integer(value));
  }
  public  void setIsInitial(int value){
     this.set(S_IsInitial,new Integer(value));
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

  public void initEditable(int value){
     this.initProperty(S_Editable,new Integer(value));
  }
  public  void setEditable(int value){
     this.set(S_Editable,new Integer(value));
  }
  public  void setEditableNull(){
     this.set(S_Editable,null);
  }

  public int getEditable(){
        return DataType.getAsInt(this.get(S_Editable));
  
  }
  public int getEditableInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Editable));
      }

  public void initFootDisplay(int value){
     this.initProperty(S_FootDisplay,new Integer(value));
  }
  public  void setFootDisplay(int value){
     this.set(S_FootDisplay,new Integer(value));
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

  public void initMultSelect(int value){
     this.initProperty(S_MultSelect,new Integer(value));
  }
  public  void setMultSelect(int value){
     this.set(S_MultSelect,new Integer(value));
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

  public void initObjectId(long value){
     this.initProperty(S_ObjectId,new Long(value));
  }
  public  void setObjectId(long value){
     this.set(S_ObjectId,new Long(value));
  }
  public  void setObjectIdNull(){
     this.set(S_ObjectId,null);
  }

  public long getObjectId(){
        return DataType.getAsLong(this.get(S_ObjectId));
  
  }
  public long getObjectIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ObjectId));
      }

  public void initSetName(String value){
     this.initProperty(S_SetName,value);
  }
  public  void setSetName(String value){
     this.set(S_SetName,value);
  }
  public  void setSetNameNull(){
     this.set(S_SetName,null);
  }

  public String getSetName(){
       return DataType.getAsString(this.get(S_SetName));
  
  }
  public String getSetNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SetName));
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

  public void initGridId(String value){
     this.initProperty(S_GridId,value);
  }
  public  void setGridId(String value){
     this.set(S_GridId,value);
  }
  public  void setGridIdNull(){
     this.set(S_GridId,null);
  }

  public String getGridId(){
       return DataType.getAsString(this.get(S_GridId));
  
  }
  public String getGridIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_GridId));
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

  public void initNeedRefresh(int value){
     this.initProperty(S_NeedRefresh,new Integer(value));
  }
  public  void setNeedRefresh(int value){
     this.set(S_NeedRefresh,new Integer(value));
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

  public void initPageSize(int value){
     this.initProperty(S_PageSize,new Integer(value));
  }
  public  void setPageSize(int value){
     this.set(S_PageSize,new Integer(value));
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


 
 }

