package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceFrameSpecialPageBean extends DataContainer implements DataContainerInterface,IBceFrameSpecialPageValue{

  private static String  m_boName = "com.ai.bce.bo.BceFrameSpecialPage";



  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_PageParam = "PAGE_PARAM";
  public final static  String S_BceFrameId = "BCE_FRAME_ID";
  public final static  String S_PageFramePageId = "PAGE_FRAME_PAGE_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_PageRulesetId = "PAGE_RULESET_ID";
  public final static  String S_PageTitle = "PAGE_TITLE";
  public final static  String S_IsDataMust = "IS_DATA_MUST";
  public final static  String S_IsGetPageData = "IS_GET_PAGE_DATA";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceFrameSpecialPageBean() throws AIException{
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

  public void initPageParam(String value){
     this.initProperty(S_PageParam,value);
  }
  public  void setPageParam(String value){
     this.set(S_PageParam,value);
  }

  
  
  public  void setPageParamNull(){
     this.set(S_PageParam,null);
  }

  public String getPageParam(){
       return DataType.getAsString(this.get(S_PageParam));
  
  }
  public String getPageParamInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PageParam));
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

  public void initPageFramePageId(long value){
     this.initProperty(S_PageFramePageId,new Long(value));
  }
  public  void setPageFramePageId(long value){
     this.set(S_PageFramePageId,new Long(value));
  }

  public  void setPageFramePageId(Long value){
     this.set(S_PageFramePageId,value);
  }
  
  public  Long  getPageFramePageIdAsLong(){
     return (Long )this.get(S_PageFramePageId);
  }
  
  
  public  void setPageFramePageIdNull(){
     this.set(S_PageFramePageId,null);
  }

  public long getPageFramePageId(){
        return DataType.getAsLong(this.get(S_PageFramePageId));
  
  }
  public long getPageFramePageIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PageFramePageId));
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

  public void initPageTitle(String value){
     this.initProperty(S_PageTitle,value);
  }
  public  void setPageTitle(String value){
     this.set(S_PageTitle,value);
  }

  
  
  public  void setPageTitleNull(){
     this.set(S_PageTitle,null);
  }

  public String getPageTitle(){
       return DataType.getAsString(this.get(S_PageTitle));
  
  }
  public String getPageTitleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PageTitle));
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

