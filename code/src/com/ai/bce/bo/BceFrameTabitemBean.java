package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceFrameTabitemBean extends DataContainer implements DataContainerInterface,IBceFrameTabitemValue{

  private static String  m_boName = "com.ai.bce.bo.BceFrameTabitem";



  public final static  String S_Isdeletable = "ISDELETABLE";
  public final static  String S_Isinitial = "ISINITIAL";
  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_Onclose = "ONCLOSE";
  public final static  String S_Mo = "MO";
  public final static  String S_Operator = "OPERATOR";
  public final static  String S_Src = "SRC";
  public final static  String S_TabId = "TAB_ID";
  public final static  String S_Width = "WIDTH";
  public final static  String S_I18nres = "I18NRES";
  public final static  String S_SrcParams = "SRC_PARAMS";
  public final static  String S_Title = "TITLE";
  public final static  String S_TabItemId = "TAB_ITEM_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceFrameTabitemBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initIsdeletable(String value){
     this.initProperty(S_Isdeletable,value);
  }
  public  void setIsdeletable(String value){
     this.set(S_Isdeletable,value);
  }
  public  void setIsdeletableNull(){
     this.set(S_Isdeletable,null);
  }

  public String getIsdeletable(){
       return DataType.getAsString(this.get(S_Isdeletable));
  
  }
  public String getIsdeletableInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Isdeletable));
      }

  public void initIsinitial(int value){
     this.initProperty(S_Isinitial,new Integer(value));
  }
  public  void setIsinitial(int value){
     this.set(S_Isinitial,new Integer(value));
  }
  public  void setIsinitialNull(){
     this.set(S_Isinitial,null);
  }

  public int getIsinitial(){
        return DataType.getAsInt(this.get(S_Isinitial));
  
  }
  public int getIsinitialInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Isinitial));
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

  public void initOnclose(String value){
     this.initProperty(S_Onclose,value);
  }
  public  void setOnclose(String value){
     this.set(S_Onclose,value);
  }
  public  void setOncloseNull(){
     this.set(S_Onclose,null);
  }

  public String getOnclose(){
       return DataType.getAsString(this.get(S_Onclose));
  
  }
  public String getOncloseInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Onclose));
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

  public void initSrc(String value){
     this.initProperty(S_Src,value);
  }
  public  void setSrc(String value){
     this.set(S_Src,value);
  }
  public  void setSrcNull(){
     this.set(S_Src,null);
  }

  public String getSrc(){
       return DataType.getAsString(this.get(S_Src));
  
  }
  public String getSrcInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Src));
      }

  public void initTabId(long value){
     this.initProperty(S_TabId,new Long(value));
  }
  public  void setTabId(long value){
     this.set(S_TabId,new Long(value));
  }
  public  void setTabIdNull(){
     this.set(S_TabId,null);
  }

  public long getTabId(){
        return DataType.getAsLong(this.get(S_TabId));
  
  }
  public long getTabIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TabId));
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

  public void initI18nres(String value){
     this.initProperty(S_I18nres,value);
  }
  public  void setI18nres(String value){
     this.set(S_I18nres,value);
  }
  public  void setI18nresNull(){
     this.set(S_I18nres,null);
  }

  public String getI18nres(){
       return DataType.getAsString(this.get(S_I18nres));
  
  }
  public String getI18nresInitialValue(){
        return DataType.getAsString(this.getOldObj(S_I18nres));
      }

  public void initSrcParams(String value){
     this.initProperty(S_SrcParams,value);
  }
  public  void setSrcParams(String value){
     this.set(S_SrcParams,value);
  }
  public  void setSrcParamsNull(){
     this.set(S_SrcParams,null);
  }

  public String getSrcParams(){
       return DataType.getAsString(this.get(S_SrcParams));
  
  }
  public String getSrcParamsInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SrcParams));
      }

  public void initTitle(String value){
     this.initProperty(S_Title,value);
  }
  public  void setTitle(String value){
     this.set(S_Title,value);
  }
  public  void setTitleNull(){
     this.set(S_Title,null);
  }

  public String getTitle(){
       return DataType.getAsString(this.get(S_Title));
  
  }
  public String getTitleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Title));
      }

  public void initTabItemId(long value){
     this.initProperty(S_TabItemId,new Long(value));
  }
  public  void setTabItemId(long value){
     this.set(S_TabItemId,new Long(value));
  }
  public  void setTabItemIdNull(){
     this.set(S_TabItemId,null);
  }

  public long getTabItemId(){
        return DataType.getAsLong(this.get(S_TabItemId));
  
  }
  public long getTabItemIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TabItemId));
      }


 
 }

