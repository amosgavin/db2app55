package com.asiainfo.task.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.task.ivalues.*;

public class BOVmTaskTsBean extends DataContainer implements DataContainerInterface,IBOVmTaskTsValue{

  private static String  m_boName = "com.asiainfo.task.bo.BOVmTaskTs";



  public final static  String S_LockStaffId = "LOCK_STAFF_ID";
  public final static  String S_DecisionResult = "DECISION_RESULT";
  public final static  String S_State = "STATE";
  public final static  String S_TaskBaseType = "TASK_BASE_TYPE";
  public final static  String S_StateDate = "STATE_DATE";
  public final static  String S_WarningTimes = "WARNING_TIMES";
  public final static  String S_TaskId = "TASK_ID";
  public final static  String S_FinishDate = "FINISH_DATE";
  public final static  String S_QueueId = "QUEUE_ID";
  public final static  String S_TaskType = "TASK_TYPE";
  public final static  String S_DestTaskTemplateId = "DEST_TASK_TEMPLATE_ID";
  public final static  String S_WorkflowId = "WORKFLOW_ID";
  public final static  String S_Duration = "DURATION";
  public final static  String S_TaskStaffId = "TASK_STAFF_ID";
  public final static  String S_WarningDate = "WARNING_DATE";
  public final static  String S_ParentTaskId = "PARENT_TASK_ID";
  public final static  String S_TaskTemplateId = "TASK_TEMPLATE_ID";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_StationId = "STATION_ID";
  public final static  String S_DestType = "DEST_TYPE";
  public final static  String S_Label = "LABEL";
  public final static  String S_IsCurrentTask = "IS_CURRENT_TASK";
  public final static  String S_ErrorMessage = "ERROR_MESSAGE";
  public final static  String S_LockDate = "LOCK_DATE";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_FinishStaffId = "FINISH_STAFF_ID";
  public final static  String S_TaskTag = "TASK_TAG";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOVmTaskTsBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //��������������������ҵ���������
   throw new AIException("Cannot reset ObjectType");
 }


  public void initLockStaffId(String value){
     this.initProperty(S_LockStaffId,value);
  }
  public  void setLockStaffId(String value){
     this.set(S_LockStaffId,value);
  }
  public  void setLockStaffIdNull(){
     this.set(S_LockStaffId,null);
  }

  public String getLockStaffId(){
       return DataType.getAsString(this.get(S_LockStaffId));
  
  }
  public String getLockStaffIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_LockStaffId));
      }

  public void initDecisionResult(String value){
     this.initProperty(S_DecisionResult,value);
  }
  public  void setDecisionResult(String value){
     this.set(S_DecisionResult,value);
  }
  public  void setDecisionResultNull(){
     this.set(S_DecisionResult,null);
  }

  public String getDecisionResult(){
       return DataType.getAsString(this.get(S_DecisionResult));
  
  }
  public String getDecisionResultInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DecisionResult));
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

  public void initTaskBaseType(String value){
     this.initProperty(S_TaskBaseType,value);
  }
  public  void setTaskBaseType(String value){
     this.set(S_TaskBaseType,value);
  }
  public  void setTaskBaseTypeNull(){
     this.set(S_TaskBaseType,null);
  }

  public String getTaskBaseType(){
       return DataType.getAsString(this.get(S_TaskBaseType));
  
  }
  public String getTaskBaseTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TaskBaseType));
      }

  public void initStateDate(Timestamp value){
     this.initProperty(S_StateDate,value);
  }
  public  void setStateDate(Timestamp value){
     this.set(S_StateDate,value);
  }
  public  void setStateDateNull(){
     this.set(S_StateDate,null);
  }

  public Timestamp getStateDate(){
        return DataType.getAsDateTime(this.get(S_StateDate));
  
  }
  public Timestamp getStateDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_StateDate));
      }

  public void initWarningTimes(int value){
     this.initProperty(S_WarningTimes,new Integer(value));
  }
  public  void setWarningTimes(int value){
     this.set(S_WarningTimes,new Integer(value));
  }
  public  void setWarningTimesNull(){
     this.set(S_WarningTimes,null);
  }

  public int getWarningTimes(){
        return DataType.getAsInt(this.get(S_WarningTimes));
  
  }
  public int getWarningTimesInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_WarningTimes));
      }

  public void initTaskId(String value){
     this.initProperty(S_TaskId,value);
  }
  public  void setTaskId(String value){
     this.set(S_TaskId,value);
  }
  public  void setTaskIdNull(){
     this.set(S_TaskId,null);
  }

  public String getTaskId(){
       return DataType.getAsString(this.get(S_TaskId));
  
  }
  public String getTaskIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TaskId));
      }

  public void initFinishDate(Timestamp value){
     this.initProperty(S_FinishDate,value);
  }
  public  void setFinishDate(Timestamp value){
     this.set(S_FinishDate,value);
  }
  public  void setFinishDateNull(){
     this.set(S_FinishDate,null);
  }

  public Timestamp getFinishDate(){
        return DataType.getAsDateTime(this.get(S_FinishDate));
  
  }
  public Timestamp getFinishDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_FinishDate));
      }

  public void initQueueId(String value){
     this.initProperty(S_QueueId,value);
  }
  public  void setQueueId(String value){
     this.set(S_QueueId,value);
  }
  public  void setQueueIdNull(){
     this.set(S_QueueId,null);
  }

  public String getQueueId(){
       return DataType.getAsString(this.get(S_QueueId));
  
  }
  public String getQueueIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_QueueId));
      }

  public void initTaskType(String value){
     this.initProperty(S_TaskType,value);
  }
  public  void setTaskType(String value){
     this.set(S_TaskType,value);
  }
  public  void setTaskTypeNull(){
     this.set(S_TaskType,null);
  }

  public String getTaskType(){
       return DataType.getAsString(this.get(S_TaskType));
  
  }
  public String getTaskTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TaskType));
      }

  public void initDestTaskTemplateId(long value){
     this.initProperty(S_DestTaskTemplateId,new Long(value));
  }
  public  void setDestTaskTemplateId(long value){
     this.set(S_DestTaskTemplateId,new Long(value));
  }
  public  void setDestTaskTemplateIdNull(){
     this.set(S_DestTaskTemplateId,null);
  }

  public long getDestTaskTemplateId(){
        return DataType.getAsLong(this.get(S_DestTaskTemplateId));
  
  }
  public long getDestTaskTemplateIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_DestTaskTemplateId));
      }

  public void initWorkflowId(String value){
     this.initProperty(S_WorkflowId,value);
  }
  public  void setWorkflowId(String value){
     this.set(S_WorkflowId,value);
  }
  public  void setWorkflowIdNull(){
     this.set(S_WorkflowId,null);
  }

  public String getWorkflowId(){
       return DataType.getAsString(this.get(S_WorkflowId));
  
  }
  public String getWorkflowIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WorkflowId));
      }

  public void initDuration(long value){
     this.initProperty(S_Duration,new Long(value));
  }
  public  void setDuration(long value){
     this.set(S_Duration,new Long(value));
  }
  public  void setDurationNull(){
     this.set(S_Duration,null);
  }

  public long getDuration(){
        return DataType.getAsLong(this.get(S_Duration));
  
  }
  public long getDurationInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Duration));
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

  public void initWarningDate(Timestamp value){
     this.initProperty(S_WarningDate,value);
  }
  public  void setWarningDate(Timestamp value){
     this.set(S_WarningDate,value);
  }
  public  void setWarningDateNull(){
     this.set(S_WarningDate,null);
  }

  public Timestamp getWarningDate(){
        return DataType.getAsDateTime(this.get(S_WarningDate));
  
  }
  public Timestamp getWarningDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_WarningDate));
      }

  public void initParentTaskId(String value){
     this.initProperty(S_ParentTaskId,value);
  }
  public  void setParentTaskId(String value){
     this.set(S_ParentTaskId,value);
  }
  public  void setParentTaskIdNull(){
     this.set(S_ParentTaskId,null);
  }

  public String getParentTaskId(){
       return DataType.getAsString(this.get(S_ParentTaskId));
  
  }
  public String getParentTaskIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ParentTaskId));
      }

  public void initTaskTemplateId(long value){
     this.initProperty(S_TaskTemplateId,new Long(value));
  }
  public  void setTaskTemplateId(long value){
     this.set(S_TaskTemplateId,new Long(value));
  }
  public  void setTaskTemplateIdNull(){
     this.set(S_TaskTemplateId,null);
  }

  public long getTaskTemplateId(){
        return DataType.getAsLong(this.get(S_TaskTemplateId));
  
  }
  public long getTaskTemplateIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TaskTemplateId));
      }

  public void initDescription(String value){
     this.initProperty(S_Description,value);
  }
  public  void setDescription(String value){
     this.set(S_Description,value);
  }
  public  void setDescriptionNull(){
     this.set(S_Description,null);
  }

  public String getDescription(){
       return DataType.getAsString(this.get(S_Description));
  
  }
  public String getDescriptionInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Description));
      }

  public void initStationId(String value){
     this.initProperty(S_StationId,value);
  }
  public  void setStationId(String value){
     this.set(S_StationId,value);
  }
  public  void setStationIdNull(){
     this.set(S_StationId,null);
  }

  public String getStationId(){
       return DataType.getAsString(this.get(S_StationId));
  
  }
  public String getStationIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_StationId));
      }

  public void initDestType(String value){
     this.initProperty(S_DestType,value);
  }
  public  void setDestType(String value){
     this.set(S_DestType,value);
  }
  public  void setDestTypeNull(){
     this.set(S_DestType,null);
  }

  public String getDestType(){
       return DataType.getAsString(this.get(S_DestType));
  
  }
  public String getDestTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_DestType));
      }

  public void initLabel(String value){
     this.initProperty(S_Label,value);
  }
  public  void setLabel(String value){
     this.set(S_Label,value);
  }
  public  void setLabelNull(){
     this.set(S_Label,null);
  }

  public String getLabel(){
       return DataType.getAsString(this.get(S_Label));
  
  }
  public String getLabelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Label));
      }

  public void initIsCurrentTask(String value){
     this.initProperty(S_IsCurrentTask,value);
  }
  public  void setIsCurrentTask(String value){
     this.set(S_IsCurrentTask,value);
  }
  public  void setIsCurrentTaskNull(){
     this.set(S_IsCurrentTask,null);
  }

  public String getIsCurrentTask(){
       return DataType.getAsString(this.get(S_IsCurrentTask));
  
  }
  public String getIsCurrentTaskInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsCurrentTask));
      }

  public void initErrorMessage(String value){
     this.initProperty(S_ErrorMessage,value);
  }
  public  void setErrorMessage(String value){
     this.set(S_ErrorMessage,value);
  }
  public  void setErrorMessageNull(){
     this.set(S_ErrorMessage,null);
  }

  public String getErrorMessage(){
       return DataType.getAsString(this.get(S_ErrorMessage));
  
  }
  public String getErrorMessageInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ErrorMessage));
      }

  public void initLockDate(Timestamp value){
     this.initProperty(S_LockDate,value);
  }
  public  void setLockDate(Timestamp value){
     this.set(S_LockDate,value);
  }
  public  void setLockDateNull(){
     this.set(S_LockDate,null);
  }

  public Timestamp getLockDate(){
        return DataType.getAsDateTime(this.get(S_LockDate));
  
  }
  public Timestamp getLockDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_LockDate));
      }

  public void initRegionId(String value){
     this.initProperty(S_RegionId,value);
  }
  public  void setRegionId(String value){
     this.set(S_RegionId,value);
  }
  public  void setRegionIdNull(){
     this.set(S_RegionId,null);
  }

  public String getRegionId(){
       return DataType.getAsString(this.get(S_RegionId));
  
  }
  public String getRegionIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RegionId));
      }

  public void initCreateDate(Timestamp value){
     this.initProperty(S_CreateDate,value);
  }
  public  void setCreateDate(Timestamp value){
     this.set(S_CreateDate,value);
  }
  public  void setCreateDateNull(){
     this.set(S_CreateDate,null);
  }

  public Timestamp getCreateDate(){
        return DataType.getAsDateTime(this.get(S_CreateDate));
  
  }
  public Timestamp getCreateDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CreateDate));
      }

  public void initFinishStaffId(String value){
     this.initProperty(S_FinishStaffId,value);
  }
  public  void setFinishStaffId(String value){
     this.set(S_FinishStaffId,value);
  }
  public  void setFinishStaffIdNull(){
     this.set(S_FinishStaffId,null);
  }

  public String getFinishStaffId(){
       return DataType.getAsString(this.get(S_FinishStaffId));
  
  }
  public String getFinishStaffIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FinishStaffId));
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


 
 }

