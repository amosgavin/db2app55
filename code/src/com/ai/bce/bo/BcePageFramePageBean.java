package com.ai.bce.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.ai.bce.ivalues.*;

public class BcePageFramePageBean extends DataContainer implements DataContainerInterface,IBcePageFramePageValue{

  private static String  m_boName = "com.ai.bce.bo.BcePageFramePage";



  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_PageId = "PAGE_ID";
  public final static  String S_IsDisplay = "IS_DISPLAY";
  public final static  String S_PageFramePageId = "PAGE_FRAME_PAGE_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_PageTitle = "PAGE_TITLE";
  public final static  String S_PageFrameId = "PAGE_FRAME_ID";
  public final static  String S_Height = "HEIGHT";
  public final static  String S_SeqNo = "SEQ_NO";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BcePageFramePageBean() throws AIException{
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

  public void initIsDisplay(int value){
     this.initProperty(S_IsDisplay,new Integer(value));
  }
  public  void setIsDisplay(int value){
     this.set(S_IsDisplay,new Integer(value));
  }
  public  void setIsDisplayNull(){
     this.set(S_IsDisplay,null);
  }

  public int getIsDisplay(){
        return DataType.getAsInt(this.get(S_IsDisplay));
  
  }
  public int getIsDisplayInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_IsDisplay));
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


 
 }

