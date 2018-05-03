package com.asiainfo.task.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.task.ivalues.*;

public class BOWebTaskQueryBean extends DataContainer implements DataContainerInterface,IBOWebTaskQueryValue{

  private static String  m_boName = "com.asiainfo.task.bo.BOWebTaskQuery";



  public final static  String S_State = "STATE";
  public final static  String S_WorkflowObjectId = "WORKFLOW_OBJECT_ID";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_OrgName = "ORG_NAME";
  public final static  String S_CreateStaffId = "CREATE_STAFF_ID";
  public final static  String S_TaskId = "TASK_ID";
  public final static  String S_FinishDate = "FINISH_DATE";
  public final static  String S_CreateCorporation = "CREATE_CORPORATION";
  public final static  String S_StateName = "STATE_NAME";
  public final static  String S_ObjectTypeName = "OBJECT_TYPE_NAME";
  public final static  String S_StaffName = "STAFF_NAME";
  public final static  String S_WorkflowId = "WORKFLOW_ID";
  public final static  String S_Corporation = "CORPORATION";
  public final static  String S_TaskStaffId = "TASK_STAFF_ID";
  public final static  String S_ApplyName = "APPLY_NAME";
  public final static  String S_Tlabel = "TLABEL";
  public final static  String S_TaskTemplateId = "TASK_TEMPLATE_ID";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_StationId = "STATION_ID";
  public final static  String S_TemplateTag = "TEMPLATE_TAG";
  public final static  String S_Label = "LABEL";
  public final static  String S_WorkflowObjectType = "WORKFLOW_OBJECT_TYPE";
  public final static  String S_NextTask = "NEXT_TASK";
  public final static  String S_ErrorMessage = "ERROR_MESSAGE";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_TaskStaffName = "TASK_STAFF_NAME";
  public final static  String S_TaskDate = "TASK_DATE";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_FinishStaffId = "FINISH_STAFF_ID";
  public final static  String S_CreateStaffName = "CREATE_STAFF_NAME";
  public final static  String S_TaskTag = "TASK_TAG";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOWebTaskQueryBean() throws AIException{
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

  public void initCreateTime(Timestamp value){
     this.initProperty(S_CreateTime,value);
  }
  public  void setCreateTime(Timestamp value){
     this.set(S_CreateTime,value);
  }
  public  void setCreateTimeNull(){
     this.set(S_CreateTime,null);
  }

  public Timestamp getCreateTime(){
        return DataType.getAsDateTime(this.get(S_CreateTime));
  
  }
  public Timestamp getCreateTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_CreateTime));
      }

  public void initOrgName(String value){
     this.initProperty(S_OrgName,value);
  }
  public  void setOrgName(String value){
     this.set(S_OrgName,value);
  }
  public  void setOrgNameNull(){
     this.set(S_OrgName,null);
  }

  public String getOrgName(){
       return DataType.getAsString(this.get(S_OrgName));
  
  }
  public String getOrgNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrgName));
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

  public void initCreateCorporation(String value){
     this.initProperty(S_CreateCorporation,value);
  }
  public  void setCreateCorporation(String value){
     this.set(S_CreateCorporation,value);
  }
  public  void setCreateCorporationNull(){
     this.set(S_CreateCorporation,null);
  }

  public String getCreateCorporation(){
       return DataType.getAsString(this.get(S_CreateCorporation));
  
  }
  public String getCreateCorporationInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CreateCorporation));
      }

  public void initStateName(String value){
     this.initProperty(S_StateName,value);
  }
  public  void setStateName(String value){
     this.set(S_StateName,value);
  }
  public  void setStateNameNull(){
     this.set(S_StateName,null);
  }

  public String getStateName(){
       return DataType.getAsString(this.get(S_StateName));
  
  }
  public String getStateNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_StateName));
      }

  public void initObjectTypeName(String value){
     this.initProperty(S_ObjectTypeName,value);
  }
  public  void setObjectTypeName(String value){
     this.set(S_ObjectTypeName,value);
  }
  public  void setObjectTypeNameNull(){
     this.set(S_ObjectTypeName,null);
  }

  public String getObjectTypeName(){
       return DataType.getAsString(this.get(S_ObjectTypeName));
  
  }
  public String getObjectTypeNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ObjectTypeName));
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

  public void initCorporation(String value){
     this.initProperty(S_Corporation,value);
  }
  public  void setCorporation(String value){
     this.set(S_Corporation,value);
  }
  public  void setCorporationNull(){
     this.set(S_Corporation,null);
  }

  public String getCorporation(){
       return DataType.getAsString(this.get(S_Corporation));
  
  }
  public String getCorporationInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Corporation));
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

  public void initApplyName(String value){
     this.initProperty(S_ApplyName,value);
  }
  public  void setApplyName(String value){
     this.set(S_ApplyName,value);
  }
  public  void setApplyNameNull(){
     this.set(S_ApplyName,null);
  }

  public String getApplyName(){
       return DataType.getAsString(this.get(S_ApplyName));
  
  }
  public String getApplyNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ApplyName));
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

  public void initNextTask(String value){
     this.initProperty(S_NextTask,value);
  }
  public  void setNextTask(String value){
     this.set(S_NextTask,value);
  }
  public  void setNextTaskNull(){
     this.set(S_NextTask,null);
  }

  public String getNextTask(){
       return DataType.getAsString(this.get(S_NextTask));
  
  }
  public String getNextTaskInitialValue(){
        return DataType.getAsString(this.getOldObj(S_NextTask));
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

  public void initTaskStaffName(String value){
     this.initProperty(S_TaskStaffName,value);
  }
  public  void setTaskStaffName(String value){
     this.set(S_TaskStaffName,value);
  }
  public  void setTaskStaffNameNull(){
     this.set(S_TaskStaffName,null);
  }

  public String getTaskStaffName(){
       return DataType.getAsString(this.get(S_TaskStaffName));
  
  }
  public String getTaskStaffNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TaskStaffName));
      }

  public void initTaskDate(Timestamp value){
     this.initProperty(S_TaskDate,value);
  }
  public  void setTaskDate(Timestamp value){
     this.set(S_TaskDate,value);
  }
  public  void setTaskDateNull(){
     this.set(S_TaskDate,null);
  }

  public Timestamp getTaskDate(){
        return DataType.getAsDateTime(this.get(S_TaskDate));
  
  }
  public Timestamp getTaskDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_TaskDate));
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

  public void initCreateStaffName(String value){
     this.initProperty(S_CreateStaffName,value);
  }
  public  void setCreateStaffName(String value){
     this.set(S_CreateStaffName,value);
  }
  public  void setCreateStaffNameNull(){
     this.set(S_CreateStaffName,null);
  }

  public String getCreateStaffName(){
       return DataType.getAsString(this.get(S_CreateStaffName));
  
  }
  public String getCreateStaffNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CreateStaffName));
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

