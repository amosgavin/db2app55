package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class QPageFramePageBean extends DataContainer implements DataContainerInterface,IQPageFramePageValue{

  private static String  m_boName = "com.ai.bce.bo.QPageFramePage";



  public final static  String S_PageUrl = "PAGE_URL";
  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_IsDisplay = "IS_DISPLAY";
  public final static  String S_PageRulesetId = "PAGE_RULESET_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_Height = "HEIGHT";
  public final static  String S_SeqNo = "SEQ_NO";
  public final static  String S_PageTemplate = "PAGE_TEMPLATE";
  public final static  String S_IsDataMust = "IS_DATA_MUST";
  public final static  String S_PageId = "PAGE_ID";
  public final static  String S_PageFramePageId = "PAGE_FRAME_PAGE_ID";
  public final static  String S_PageTitle = "PAGE_TITLE";
  public final static  String S_PageFrameId = "PAGE_FRAME_ID";
  public final static  String S_PageLoadType = "PAGE_LOAD_TYPE";
  public final static  String S_IsGetPageData = "IS_GET_PAGE_DATA";
  public final static  String S_PageType = "PAGE_TYPE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public QPageFramePageBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
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

  public void initState(long value){
     this.initProperty(S_State,new Long(value));
  }
  public  void setState(long value){
     this.set(S_State,new Long(value));
  }
  public  void setStateNull(){
     this.set(S_State,null);
  }

  public long getState(){
        return DataType.getAsLong(this.get(S_State));
  
  }
  public long getStateInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_State));
      }

  public void initIsDisplay(long value){
     this.initProperty(S_IsDisplay,new Long(value));
  }
  public  void setIsDisplay(long value){
     this.set(S_IsDisplay,new Long(value));
  }
  public  void setIsDisplayNull(){
     this.set(S_IsDisplay,null);
  }

  public long getIsDisplay(){
        return DataType.getAsLong(this.get(S_IsDisplay));
  
  }
  public long getIsDisplayInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_IsDisplay));
      }

  public void initPageRulesetId(long value){
     this.initProperty(S_PageRulesetId,new Long(value));
  }
  public  void setPageRulesetId(long value){
     this.set(S_PageRulesetId,new Long(value));
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

  public void initSeqNo(long value){
     this.initProperty(S_SeqNo,new Long(value));
  }
  public  void setSeqNo(long value){
     this.set(S_SeqNo,new Long(value));
  }
  public  void setSeqNoNull(){
     this.set(S_SeqNo,null);
  }

  public long getSeqNo(){
        return DataType.getAsLong(this.get(S_SeqNo));
  
  }
  public long getSeqNoInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SeqNo));
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

  public void initIsDataMust(long value){
     this.initProperty(S_IsDataMust,new Long(value));
  }
  public  void setIsDataMust(long value){
     this.set(S_IsDataMust,new Long(value));
  }
  public  void setIsDataMustNull(){
     this.set(S_IsDataMust,null);
  }

  public long getIsDataMust(){
        return DataType.getAsLong(this.get(S_IsDataMust));
  
  }
  public long getIsDataMustInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_IsDataMust));
      }

  public void initPageId(long value){
     this.initProperty(S_PageId,new Long(value));
  }
  public  void setPageId(long value){
     this.set(S_PageId,new Long(value));
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

  public void initPageFramePageId(long value){
     this.initProperty(S_PageFramePageId,new Long(value));
  }
  public  void setPageFramePageId(long value){
     this.set(S_PageFramePageId,new Long(value));
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

  public void initPageFrameId(long value){
     this.initProperty(S_PageFrameId,new Long(value));
  }
  public  void setPageFrameId(long value){
     this.set(S_PageFrameId,new Long(value));
  }
  public  void setPageFrameIdNull(){
     this.set(S_PageFrameId,null);
  }

  public long getPageFrameId(){
        return DataType.getAsLong(this.get(S_PageFrameId));
  
  }
  public long getPageFrameIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PageFrameId));
      }

  public void initPageLoadType(long value){
     this.initProperty(S_PageLoadType,new Long(value));
  }
  public  void setPageLoadType(long value){
     this.set(S_PageLoadType,new Long(value));
  }
  public  void setPageLoadTypeNull(){
     this.set(S_PageLoadType,null);
  }

  public long getPageLoadType(){
        return DataType.getAsLong(this.get(S_PageLoadType));
  
  }
  public long getPageLoadTypeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PageLoadType));
      }

  public void initIsGetPageData(long value){
     this.initProperty(S_IsGetPageData,new Long(value));
  }
  public  void setIsGetPageData(long value){
     this.set(S_IsGetPageData,new Long(value));
  }
  public  void setIsGetPageDataNull(){
     this.set(S_IsGetPageData,null);
  }

  public long getIsGetPageData(){
        return DataType.getAsLong(this.get(S_IsGetPageData));
  
  }
  public long getIsGetPageDataInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_IsGetPageData));
      }

  public void initPageType(long value){
     this.initProperty(S_PageType,new Long(value));
  }
  public  void setPageType(long value){
     this.set(S_PageType,new Long(value));
  }
  public  void setPageTypeNull(){
     this.set(S_PageType,null);
  }

  public long getPageType(){
        return DataType.getAsLong(this.get(S_PageType));
  
  }
  public long getPageTypeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PageType));
      }


 
 }

