package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BcePageBean extends DataContainer implements DataContainerInterface,IBcePageValue{

  private static String  m_boName = "com.ai.bce.bo.BcePage";



  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_PageTemplate = "PAGE_TEMPLATE";
  public final static  String S_PageType = "PAGE_TYPE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_PageRulesetId = "PAGE_RULESET_ID";
  public final static  String S_PageId = "PAGE_ID";
  public final static  String S_IsDataMust = "IS_DATA_MUST";
  public final static  String S_PageUrl = "PAGE_URL";
  public final static  String S_PageLoadType = "PAGE_LOAD_TYPE";
  public final static  String S_IsGetPageData = "IS_GET_PAGE_DATA";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BcePageBean() throws AIException{
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

  public void initPageTemplate(String value){
     this.initProperty(S_PageTemplate,value);
  }
  public  void setPageTemplate(String value){
     this.set(S_PageTemplate,value);
  }

  
  
  public  void setPageTemplateNull(){
     this.set(S_PageTemplate,null);
  }

  public String getPageTemplate(){
       return DataType.getAsString(this.get(S_PageTemplate));
  
  }
  public String getPageTemplateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PageTemplate));
      }

  public void initPageType(int value){
     this.initProperty(S_PageType,new Integer(value));
  }
  public  void setPageType(int value){
     this.set(S_PageType,new Integer(value));
  }

  public  void setPageType(Integer value){
     this.set(S_PageType,value);
  }
  
  public  Integer  getPageTypeAsInteger(){
     return (Integer )this.get(S_PageType);
  }
  
  
  public  void setPageTypeNull(){
     this.set(S_PageType,null);
  }

  public int getPageType(){
        return DataType.getAsInt(this.get(S_PageType));
  
  }
  public int getPageTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_PageType));
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

  public void initPageRulesetId(long value){
     this.initProperty(S_PageRulesetId,new Long(value));
  }
  public  void setPageRulesetId(long value){
     this.set(S_PageRulesetId,new Long(value));
  }

  public  void setPageRulesetId(Long value){
     this.set(S_PageRulesetId,value);
  }
  
  public  Long  getPageRulesetIdAsLong(){
     return (Long )this.get(S_PageRulesetId);
  }
  
  
  public  void setPageRulesetIdNull(){
     this.set(S_PageRulesetId,null);
  }

  public long getPageRulesetId(){
        return DataType.getAsLong(this.get(S_PageRulesetId));
  
  }
  public long getPageRulesetIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PageRulesetId));
      }

  public void initPageId(long value){
     this.initProperty(S_PageId,new Long(value));
  }
  public  void setPageId(long value){
     this.set(S_PageId,new Long(value));
  }

  public  void setPageId(Long value){
     this.set(S_PageId,value);
  }
  
  public  Long  getPageIdAsLong(){
     return (Long )this.get(S_PageId);
  }
  
  
  public  void setPageIdNull(){
     this.set(S_PageId,null);
  }

  public long getPageId(){
        return DataType.getAsLong(this.get(S_PageId));
  
  }
  public long getPageIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PageId));
      }

  public void initIsDataMust(int value){
     this.initProperty(S_IsDataMust,new Integer(value));
  }
  public  void setIsDataMust(int value){
     this.set(S_IsDataMust,new Integer(value));
  }

  public  void setIsDataMust(Integer value){
     this.set(S_IsDataMust,value);
  }
  
  public  Integer  getIsDataMustAsInteger(){
     return (Integer )this.get(S_IsDataMust);
  }
  
  
  public  void setIsDataMustNull(){
     this.set(S_IsDataMust,null);
  }

  public int getIsDataMust(){
        return DataType.getAsInt(this.get(S_IsDataMust));
  
  }
  public int getIsDataMustInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_IsDataMust));
      }

  public void initPageUrl(String value){
     this.initProperty(S_PageUrl,value);
  }
  public  void setPageUrl(String value){
     this.set(S_PageUrl,value);
  }

  
  
  public  void setPageUrlNull(){
     this.set(S_PageUrl,null);
  }

  public String getPageUrl(){
       return DataType.getAsString(this.get(S_PageUrl));
  
  }
  public String getPageUrlInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PageUrl));
      }

  public void initPageLoadType(int value){
     this.initProperty(S_PageLoadType,new Integer(value));
  }
  public  void setPageLoadType(int value){
     this.set(S_PageLoadType,new Integer(value));
  }

  public  void setPageLoadType(Integer value){
     this.set(S_PageLoadType,value);
  }
  
  public  Integer  getPageLoadTypeAsInteger(){
     return (Integer )this.get(S_PageLoadType);
  }
  
  
  public  void setPageLoadTypeNull(){
     this.set(S_PageLoadType,null);
  }

  public int getPageLoadType(){
        return DataType.getAsInt(this.get(S_PageLoadType));
  
  }
  public int getPageLoadTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_PageLoadType));
      }

  public void initIsGetPageData(int value){
     this.initProperty(S_IsGetPageData,new Integer(value));
  }
  public  void setIsGetPageData(int value){
     this.set(S_IsGetPageData,new Integer(value));
  }

  public  void setIsGetPageData(Integer value){
     this.set(S_IsGetPageData,value);
  }
  
  public  Integer  getIsGetPageDataAsInteger(){
     return (Integer )this.get(S_IsGetPageData);
  }
  
  
  public  void setIsGetPageDataNull(){
     this.set(S_IsGetPageData,null);
  }

  public int getIsGetPageData(){
        return DataType.getAsInt(this.get(S_IsGetPageData));
  
  }
  public int getIsGetPageDataInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_IsGetPageData));
      }


 
 }

