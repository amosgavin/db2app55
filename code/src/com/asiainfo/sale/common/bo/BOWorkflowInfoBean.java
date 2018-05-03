package com.asiainfo.sale.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.common.ivalues.*;

public class BOWorkflowInfoBean extends DataContainer implements DataContainerInterface,IBOWorkflowInfoValue{

  private static String  m_boName = "com.asiainfo.sale.common.bo.BOWorkflowInfo";



  public final static  String S_State = "STATE";
  public final static  String S_WorkflowObjectId = "WORKFLOW_OBJECT_ID";
  public final static  String S_CreateStaffId = "CREATE_STAFF_ID";
  public final static  String S_EngineWorkflowId = "ENGINE_WORKFLOW_ID";
  public final static  String S_StateDate = "STATE_DATE";
  public final static  String S_WarningTimes = "WARNING_TIMES";
  public final static  String S_TaskId = "TASK_ID";
  public final static  String S_FinishDate = "FINISH_DATE";
  public final static  String S_Vars = "VARS";
  public final static  String S_QueueId = "QUEUE_ID";
  public final static  String S_EngineType = "ENGINE_TYPE";
  public final static  String S_TemplateVersionId = "TEMPLATE_VERSION_ID";
  public final static  String S_WorkflowKind = "WORKFLOW_KIND";
  public final static  String S_WorkflowId = "WORKFLOW_ID";
  public final static  String S_Duration = "DURATION";
  public final static  String S_WarningDate = "WARNING_DATE";
  public final static  String S_ParentTaskId = "PARENT_TASK_ID";
  public final static  String S_UserTaskCount = "USER_TASK_COUNT";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Label = "LABEL";
  public final static  String S_CurrentTaskId = "CURRENT_TASK_ID";
  public final static  String S_TemplateTag = "TEMPLATE_TAG";
  public final static  String S_WorkflowObjectType = "WORKFLOW_OBJECT_TYPE";
  public final static  String S_ErrorMessage = "ERROR_MESSAGE";
  public final static  String S_SuspendState = "SUSPEND_STATE";
  public final static  String S_WorkflowType = "WORKFLOW_TYPE";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_StartDate = "START_DATE";
  public final static  String S_OpStaffId = "OP_STAFF_ID";
  public final static  String S_ErrorCount = "ERROR_COUNT";
  public final static  String S_CreateDate = "CREATE_DATE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOWorkflowInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
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

  public void initCreateStaffId(String value){
     this.initProperty(S_CreateStaffId,value);
  }
  public  void setCreateStaffId(String value){
     this.set(S_CreateStaffId,value);
  }
  public  void setCreateStaffIdNull(){
     this.set(S_CreateStaffId,null);
  }

  public String getCreateStaffId(){
       return DataType.getAsString(this.get(S_CreateStaffId));
  
  }
  public String getCreateStaffIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CreateStaffId));
      }

  public void initEngineWorkflowId(String value){
     this.initProperty(S_EngineWorkflowId,value);
  }
  public  void setEngineWorkflowId(String value){
     this.set(S_EngineWorkflowId,value);
  }
  public  void setEngineWorkflowIdNull(){
     this.set(S_EngineWorkflowId,null);
  }

  public String getEngineWorkflowId(){
       return DataType.getAsString(this.get(S_EngineWorkflowId));
  
  }
  public String getEngineWorkflowIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_EngineWorkflowId));
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

  public void initWarningTimes(long value){
     this.initProperty(S_WarningTimes,new Long(value));
  }
  public  void setWarningTimes(long value){
     this.set(S_WarningTimes,new Long(value));
  }
  public  void setWarningTimesNull(){
     this.set(S_WarningTimes,null);
  }

  public long getWarningTimes(){
        return DataType.getAsLong(this.get(S_WarningTimes));
  
  }
  public long getWarningTimesInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_WarningTimes));
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

  public void initVars(String value){
     this.initProperty(S_Vars,value);
  }
  public  void setVars(String value){
     this.set(S_Vars,value);
  }
  public  void setVarsNull(){
     this.set(S_Vars,null);
  }

  public String getVars(){
       return DataType.getAsString(this.get(S_Vars));
  
  }
  public String getVarsInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Vars));
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

  public void initEngineType(String value){
     this.initProperty(S_EngineType,value);
  }
  public  void setEngineType(String value){
     this.set(S_EngineType,value);
  }
  public  void setEngineTypeNull(){
     this.set(S_EngineType,null);
  }

  public String getEngineType(){
       return DataType.getAsString(this.get(S_EngineType));
  
  }
  public String getEngineTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_EngineType));
      }

  public void initTemplateVersionId(long value){
     this.initProperty(S_TemplateVersionId,new Long(value));
  }
  public  void setTemplateVersionId(long value){
     this.set(S_TemplateVersionId,new Long(value));
  }
  public  void setTemplateVersionIdNull(){
     this.set(S_TemplateVersionId,null);
  }

  public long getTemplateVersionId(){
        return DataType.getAsLong(this.get(S_TemplateVersionId));
  
  }
  public long getTemplateVersionIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TemplateVersionId));
      }

  public void initWorkflowKind(long value){
     this.initProperty(S_WorkflowKind,new Long(value));
  }
  public  void setWorkflowKind(long value){
     this.set(S_WorkflowKind,new Long(value));
  }
  public  void setWorkflowKindNull(){
     this.set(S_WorkflowKind,null);
  }

  public long getWorkflowKind(){
        return DataType.getAsLong(this.get(S_WorkflowKind));
  
  }
  public long getWorkflowKindInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_WorkflowKind));
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

  public void initUserTaskCount(long value){
     this.initProperty(S_UserTaskCount,new Long(value));
  }
  public  void setUserTaskCount(long value){
     this.set(S_UserTaskCount,new Long(value));
  }
  public  void setUserTaskCountNull(){
     this.set(S_UserTaskCount,null);
  }

  public long getUserTaskCount(){
        return DataType.getAsLong(this.get(S_UserTaskCount));
  
  }
  public long getUserTaskCountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_UserTaskCount));
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

  public void initCurrentTaskId(String value){
     this.initProperty(S_CurrentTaskId,value);
  }
  public  void setCurrentTaskId(String value){
     this.set(S_CurrentTaskId,value);
  }
  public  void setCurrentTaskIdNull(){
     this.set(S_CurrentTaskId,null);
  }

  public String getCurrentTaskId(){
       return DataType.getAsString(this.get(S_CurrentTaskId));
  
  }
  public String getCurrentTaskIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CurrentTaskId));
      }

  public void initTemplateTag(String value){
     this.initProperty(S_TemplateTag,value);
  }
  public  void setTemplateTag(String value){
     this.set(S_TemplateTag,value);
  }
  public  void setTemplateTagNull(){
     this.set(S_TemplateTag,null);
  }

  public String getTemplateTag(){
       return DataType.getAsString(this.get(S_TemplateTag));
  
  }
  public String getTemplateTagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TemplateTag));
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

  public void initSuspendState(long value){
     this.initProperty(S_SuspendState,new Long(value));
  }
  public  void setSuspendState(long value){
     this.set(S_SuspendState,new Long(value));
  }
  public  void setSuspendStateNull(){
     this.set(S_SuspendState,null);
  }

  public long getSuspendState(){
        return DataType.getAsLong(this.get(S_SuspendState));
  
  }
  public long getSuspendStateInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_SuspendState));
      }

  public void initWorkflowType(String value){
     this.initProperty(S_WorkflowType,value);
  }
  public  void setWorkflowType(String value){
     this.set(S_WorkflowType,value);
  }
  public  void setWorkflowTypeNull(){
     this.set(S_WorkflowType,null);
  }

  public String getWorkflowType(){
       return DataType.getAsString(this.get(S_WorkflowType));
  
  }
  public String getWorkflowTypeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WorkflowType));
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

  public void initStartDate(Timestamp value){
     this.initProperty(S_StartDate,value);
  }
  public  void setStartDate(Timestamp value){
     this.set(S_StartDate,value);
  }
  public  void setStartDateNull(){
     this.set(S_StartDate,null);
  }

  public Timestamp getStartDate(){
        return DataType.getAsDateTime(this.get(S_StartDate));
  
  }
  public Timestamp getStartDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_StartDate));
      }

  public void initOpStaffId(String value){
     this.initProperty(S_OpStaffId,value);
  }
  public  void setOpStaffId(String value){
     this.set(S_OpStaffId,value);
  }
  public  void setOpStaffIdNull(){
     this.set(S_OpStaffId,null);
  }

  public String getOpStaffId(){
       return DataType.getAsString(this.get(S_OpStaffId));
  
  }
  public String getOpStaffIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OpStaffId));
      }

  public void initErrorCount(long value){
     this.initProperty(S_ErrorCount,new Long(value));
  }
  public  void setErrorCount(long value){
     this.set(S_ErrorCount,new Long(value));
  }
  public  void setErrorCountNull(){
     this.set(S_ErrorCount,null);
  }

  public long getErrorCount(){
        return DataType.getAsLong(this.get(S_ErrorCount));
  
  }
  public long getErrorCountInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ErrorCount));
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


 
 }

