package com.asiainfo.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.common.ivalues.*;

public class BOItemOtherInfoBean extends DataContainer implements DataContainerInterface,IBOItemOtherInfoValue{

  private static String  m_boName = "com.asiainfo.common.bo.BOItemOtherInfo";



  public final static  String S_Date1 = "DATE_1";
  public final static  String S_InsertDate = "INSERT_DATE";
  public final static  String S_DelayReason = "DELAY_REASON";
  public final static  String S_Id = "ID";
  public final static  String S_ApproveFlag = "APPROVE_FLAG";
  public final static  String S_AdviseDealTime = "ADVISE_DEAL_TIME";
  public final static  String S_Content1 = "CONTENT_1";
  public final static  String S_ItemId = "ITEM_ID";
  public final static  String S_TaskTag = "TASK_TAG";
  public final static  String S_Content2 = "CONTENT_2";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOItemOtherInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initDate1(Timestamp value){
     this.initProperty(S_Date1,value);
  }
  public  void setDate1(Timestamp value){
     this.set(S_Date1,value);
  }
  public  void setDate1Null(){
     this.set(S_Date1,null);
  }

  public Timestamp getDate1(){
        return DataType.getAsDateTime(this.get(S_Date1));
  
  }
  public Timestamp getDate1InitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_Date1));
      }

  public void initInsertDate(Timestamp value){
     this.initProperty(S_InsertDate,value);
  }
  public  void setInsertDate(Timestamp value){
     this.set(S_InsertDate,value);
  }
  public  void setInsertDateNull(){
     this.set(S_InsertDate,null);
  }

  public Timestamp getInsertDate(){
        return DataType.getAsDateTime(this.get(S_InsertDate));
  
  }
  public Timestamp getInsertDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_InsertDate));
      }

  public void initDelayReason(String value){
     this.initProperty(S_DelayReason,value);
  }
  public  void setDelayReason(String value){
     this.set(S_DelayReason,value);
  }
  public  void setDelayReasonNull(){
     this.set(S_DelayReason,null);
  }

  public String getDelayReason(){
       return DataType.getAsString(this.get(S_DelayReason));
  
  }
  public String getDelayReasonInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DelayReason));
      }

  public void initId(int value){
     this.initProperty(S_Id,new Integer(value));
  }
  public  void setId(int value){
     this.set(S_Id,new Integer(value));
  }
  public  void setIdNull(){
     this.set(S_Id,null);
  }

  public int getId(){
        return DataType.getAsInt(this.get(S_Id));
  
  }
  public int getIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Id));
      }

  public void initApproveFlag(String value){
     this.initProperty(S_ApproveFlag,value);
  }
  public  void setApproveFlag(String value){
     this.set(S_ApproveFlag,value);
  }
  public  void setApproveFlagNull(){
     this.set(S_ApproveFlag,null);
  }

  public String getApproveFlag(){
       return DataType.getAsString(this.get(S_ApproveFlag));
  
  }
  public String getApproveFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ApproveFlag));
      }

  public void initAdviseDealTime(Timestamp value){
     this.initProperty(S_AdviseDealTime,value);
  }
  public  void setAdviseDealTime(Timestamp value){
     this.set(S_AdviseDealTime,value);
  }
  public  void setAdviseDealTimeNull(){
     this.set(S_AdviseDealTime,null);
  }

  public Timestamp getAdviseDealTime(){
        return DataType.getAsDateTime(this.get(S_AdviseDealTime));
  
  }
  public Timestamp getAdviseDealTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_AdviseDealTime));
      }

  public void initContent1(String value){
     this.initProperty(S_Content1,value);
  }
  public  void setContent1(String value){
     this.set(S_Content1,value);
  }
  public  void setContent1Null(){
     this.set(S_Content1,null);
  }

  public String getContent1(){
       return DataType.getAsString(this.get(S_Content1));
  
  }
  public String getContent1InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Content1));
      }

  public void initItemId(int value){
     this.initProperty(S_ItemId,new Integer(value));
  }
  public  void setItemId(int value){
     this.set(S_ItemId,new Integer(value));
  }
  public  void setItemIdNull(){
     this.set(S_ItemId,null);
  }

  public int getItemId(){
        return DataType.getAsInt(this.get(S_ItemId));
  
  }
  public int getItemIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_ItemId));
      }

  public void initTaskTag(String value){
     this.initProperty(S_TaskTag,value);
  }
  public  void setTaskTag(String value){
     this.set(S_TaskTag,value);
  }
  public  void setTaskTagNull(){
     this.set(S_TaskTag,null);
  }

  public String getTaskTag(){
       return DataType.getAsString(this.get(S_TaskTag));
  
  }
  public String getTaskTagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TaskTag));
      }

  public void initContent2(String value){
     this.initProperty(S_Content2,value);
  }
  public  void setContent2(String value){
     this.set(S_Content2,value);
  }
  public  void setContent2Null(){
     this.set(S_Content2,null);
  }

  public String getContent2(){
       return DataType.getAsString(this.get(S_Content2));
  
  }
  public String getContent2InitialValue(){
        return DataType.getAsString(this.getOldObj(S_Content2));
      }


 
 }

