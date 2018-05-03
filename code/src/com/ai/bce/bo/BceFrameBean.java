package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BceFrameBean extends DataContainer implements DataContainerInterface,IBceFrameValue{

  private static String  m_boName = "com.ai.bce.bo.BceFrame";



  public final static  String S_SrcSystemType = "SRC_SYSTEM_TYPE";
  public final static  String S_BusinessId = "BUSINESS_ID";
  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_PrintTemplateId = "PRINT_TEMPLATE_ID";
  public final static  String S_EntryPageUrl = "ENTRY_PAGE_URL";
  public final static  String S_WorkflowCode = "WORKFLOW_CODE";
  public final static  String S_BceFrameId = "BCE_FRAME_ID";
  public final static  String S_DataParser = "DATA_PARSER";
  public final static  String S_IsLockOffer = "IS_LOCK_OFFER";
  public final static  String S_ParamData = "PARAM_DATA";
  public final static  String S_PageFrameId = "PAGE_FRAME_ID";
  public final static  String S_DealService = "DEAL_SERVICE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BceFrameBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initSrcSystemType(int value){
     this.initProperty(S_SrcSystemType,new Integer(value));
  }
  public  void setSrcSystemType(int value){
     this.set(S_SrcSystemType,new Integer(value));
  }
  public  void setSrcSystemTypeNull(){
     this.set(S_SrcSystemType,null);
  }

  public int getSrcSystemType(){
        return DataType.getAsInt(this.get(S_SrcSystemType));
  
  }
  public int getSrcSystemTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_SrcSystemType));
      }

  public void initBusinessId(long value){
     this.initProperty(S_BusinessId,new Long(value));
  }
  public  void setBusinessId(long value){
     this.set(S_BusinessId,new Long(value));
  }
  public  void setBusinessIdNull(){
     this.set(S_BusinessId,null);
  }

  public long getBusinessId(){
        return DataType.getAsLong(this.get(S_BusinessId));
  
  }
  public long getBusinessIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_BusinessId));
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

  public void initPrintTemplateId(long value){
     this.initProperty(S_PrintTemplateId,new Long(value));
  }
  public  void setPrintTemplateId(long value){
     this.set(S_PrintTemplateId,new Long(value));
  }
  public  void setPrintTemplateIdNull(){
     this.set(S_PrintTemplateId,null);
  }

  public long getPrintTemplateId(){
        return DataType.getAsLong(this.get(S_PrintTemplateId));
  
  }
  public long getPrintTemplateIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_PrintTemplateId));
      }

  public void initEntryPageUrl(String value){
     this.initProperty(S_EntryPageUrl,value);
  }
  public  void setEntryPageUrl(String value){
     this.set(S_EntryPageUrl,value);
  }
  public  void setEntryPageUrlNull(){
     this.set(S_EntryPageUrl,null);
  }

  public String getEntryPageUrl(){
       return DataType.getAsString(this.get(S_EntryPageUrl));
  
  }
  public String getEntryPageUrlInitialValue(){
        return DataType.getAsString(this.getOldObj(S_EntryPageUrl));
      }

  public void initWorkflowCode(String value){
     this.initProperty(S_WorkflowCode,value);
  }
  public  void setWorkflowCode(String value){
     this.set(S_WorkflowCode,value);
  }
  public  void setWorkflowCodeNull(){
     this.set(S_WorkflowCode,null);
  }

  public String getWorkflowCode(){
       return DataType.getAsString(this.get(S_WorkflowCode));
  
  }
  public String getWorkflowCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WorkflowCode));
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

  public void initDataParser(String value){
     this.initProperty(S_DataParser,value);
  }
  public  void setDataParser(String value){
     this.set(S_DataParser,value);
  }
  public  void setDataParserNull(){
     this.set(S_DataParser,null);
  }

  public String getDataParser(){
       return DataType.getAsString(this.get(S_DataParser));
  
  }
  public String getDataParserInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DataParser));
      }

  public void initIsLockOffer(int value){
     this.initProperty(S_IsLockOffer,new Integer(value));
  }
  public  void setIsLockOffer(int value){
     this.set(S_IsLockOffer,new Integer(value));
  }
  public  void setIsLockOfferNull(){
     this.set(S_IsLockOffer,null);
  }

  public int getIsLockOffer(){
        return DataType.getAsInt(this.get(S_IsLockOffer));
  
  }
  public int getIsLockOfferInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_IsLockOffer));
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

  public void initDealService(String value){
     this.initProperty(S_DealService,value);
  }
  public  void setDealService(String value){
     this.set(S_DealService,value);
  }
  public  void setDealServiceNull(){
     this.set(S_DealService,null);
  }

  public String getDealService(){
       return DataType.getAsString(this.get(S_DealService));
  
  }
  public String getDealServiceInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DealService));
      }


 
 }

