package com.asiainfo.bi.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.bi.ivalues.*;

public class BOTaskNodeDTBean extends DataContainer implements DataContainerInterface,IBOTaskNodeDTValue{

  private static String  m_boName = "com.asiainfo.bi.bo.BOTaskNodeDT";



  public final static  String S_DiffDay = "DIFF_DAY";
  public final static  String S_WorkflowObjectId = "WORKFLOW_OBJECT_ID";
  public final static  String S_Tlabel = "TLABEL";
  public final static  String S_WfName = "WF_NAME";
  public final static  String S_DelayReason = "DELAY_REASON";
  public final static  String S_WorkflowObjectType = "WORKFLOW_OBJECT_TYPE";
  public final static  String S_IsDelay = "IS_DELAY";
  public final static  String S_ApproveFlag = "APPROVE_FLAG";
  public final static  String S_AdviseDealTime = "ADVISE_DEAL_TIME";
  public final static  String S_StaffName = "STAFF_NAME";
  public final static  String S_TaskEndTime = "TASK_END_TIME";
  public final static  String S_TaskRecTime = "TASK_REC_TIME";
  public final static  String S_TaskTag = "TASK_TAG";
  public final static  String S_TaskStaffId = "TASK_STAFF_ID";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOTaskNodeDTBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initDiffDay(long value){
     this.initProperty(S_DiffDay,new Long(value));
  }
  public  void setDiffDay(long value){
     this.set(S_DiffDay,new Long(value));
  }
  public  void setDiffDayNull(){
     this.set(S_DiffDay,null);
  }

  public long getDiffDay(){
        return DataType.getAsLong(this.get(S_DiffDay));
  
  }
  public long getDiffDayInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_DiffDay));
      }

  public void initWorkflowObjectId(String value){
     this.initProperty(S_WorkflowObjectId,value);
  }
  public  void setWorkflowObjectId(String value){
     this.set(S_WorkflowObjectId,value);
  }
  public  void setWorkflowObjectIdNull(){
     this.set(S_WorkflowObjectId,null);
  }

  public String getWorkflowObjectId(){
       return DataType.getAsString(this.get(S_WorkflowObjectId));
  
  }
  public String getWorkflowObjectIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WorkflowObjectId));
      }

  public void initTlabel(String value){
     this.initProperty(S_Tlabel,value);
  }
  public  void setTlabel(String value){
     this.set(S_Tlabel,value);
  }
  public  void setTlabelNull(){
     this.set(S_Tlabel,null);
  }

  public String getTlabel(){
       return DataType.getAsString(this.get(S_Tlabel));
  
  }
  public String getTlabelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Tlabel));
      }

  public void initWfName(String value){
     this.initProperty(S_WfName,value);
  }
  public  void setWfName(String value){
     this.set(S_WfName,value);
  }
  public  void setWfNameNull(){
     this.set(S_WfName,null);
  }

  public String getWfName(){
       return DataType.getAsString(this.get(S_WfName));
  
  }
  public String getWfNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WfName));
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

  public void initWorkflowObjectType(String value){
     this.initProperty(S_WorkflowObjectType,value);
  }
  public  void setWorkflowObjectType(String value){
     this.set(S_WorkflowObjectType,value);
  }
  public  void setWorkflowObjectTypeNull(){
     this.set(S_WorkflowObjectType,null);
  }

  public String getWorkflowObjectType(){
       return DataType.getAsString(this.get(S_WorkflowObjectType));
  
  }
  public String getWorkflowObjectTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WorkflowObjectType));
      }

  public void initIsDelay(long value){
     this.initProperty(S_IsDelay,new Long(value));
  }
  public  void setIsDelay(long value){
     this.set(S_IsDelay,new Long(value));
  }
  public  void setIsDelayNull(){
     this.set(S_IsDelay,null);
  }

  public long getIsDelay(){
        return DataType.getAsLong(this.get(S_IsDelay));
  
  }
  public long getIsDelayInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_IsDelay));
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

  public void initStaffName(String value){
     this.initProperty(S_StaffName,value);
  }
  public  void setStaffName(String value){
     this.set(S_StaffName,value);
  }
  public  void setStaffNameNull(){
     this.set(S_StaffName,null);
  }

  public String getStaffName(){
       return DataType.getAsString(this.get(S_StaffName));
  
  }
  public String getStaffNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_StaffName));
      }

  public void initTaskEndTime(Timestamp value){
     this.initProperty(S_TaskEndTime,value);
  }
  public  void setTaskEndTime(Timestamp value){
     this.set(S_TaskEndTime,value);
  }
  public  void setTaskEndTimeNull(){
     this.set(S_TaskEndTime,null);
  }

  public Timestamp getTaskEndTime(){
        return DataType.getAsDateTime(this.get(S_TaskEndTime));
  
  }
  public Timestamp getTaskEndTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_TaskEndTime));
      }

  public void initTaskRecTime(Timestamp value){
     this.initProperty(S_TaskRecTime,value);
  }
  public  void setTaskRecTime(Timestamp value){
     this.set(S_TaskRecTime,value);
  }
  public  void setTaskRecTimeNull(){
     this.set(S_TaskRecTime,null);
  }

  public Timestamp getTaskRecTime(){
        return DataType.getAsDateTime(this.get(S_TaskRecTime));
  
  }
  public Timestamp getTaskRecTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_TaskRecTime));
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

  public void initTaskStaffId(String value){
     this.initProperty(S_TaskStaffId,value);
  }
  public  void setTaskStaffId(String value){
     this.set(S_TaskStaffId,value);
  }
  public  void setTaskStaffIdNull(){
     this.set(S_TaskStaffId,null);
  }

  public String getTaskStaffId(){
       return DataType.getAsString(this.get(S_TaskStaffId));
  
  }
  public String getTaskStaffIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TaskStaffId));
      }


 
 }

