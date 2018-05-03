package com.asiainfo.sale.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.common.ivalues.*;

public class BOAppriseTaskBean extends DataContainer implements DataContainerInterface,IBOAppriseTaskValue{

  private static String  m_boName = "com.asiainfo.sale.common.bo.BOAppriseTask";



  public final static  String S_ApplyName = "APPLY_NAME";
  public final static  String S_OrganizeName = "ORGANIZE_NAME";
  public final static  String S_SendTime = "SEND_TIME";
  public final static  String S_WorkflowObjectType = "WORKFLOW_OBJECT_TYPE";
  public final static  String S_IsReaded = "IS_READED";
  public final static  String S_ReadTime = "READ_TIME";
  public final static  String S_TaskId = "TASK_ID";
  public final static  String S_Depart = "DEPART";
  public final static  String S_TaskLabel = "TASK_LABEL";
  public final static  String S_DealTime = "DEAL_TIME";
  public final static  String S_Aid = "AID";
  public final static  String S_StaffName = "STAFF_NAME";
  public final static  String S_AppriseFlag = "APPRISE_FLAG";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_WorkflowId = "WORKFLOW_ID";
  public final static  String S_WfLabel = "WF_LABEL";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOAppriseTaskBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
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

  public void initOrganizeName(String value){
     this.initProperty(S_OrganizeName,value);
  }
  public  void setOrganizeName(String value){
     this.set(S_OrganizeName,value);
  }
  public  void setOrganizeNameNull(){
     this.set(S_OrganizeName,null);
  }

  public String getOrganizeName(){
       return DataType.getAsString(this.get(S_OrganizeName));
  
  }
  public String getOrganizeNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrganizeName));
      }

  public void initSendTime(Timestamp value){
     this.initProperty(S_SendTime,value);
  }
  public  void setSendTime(Timestamp value){
     this.set(S_SendTime,value);
  }
  public  void setSendTimeNull(){
     this.set(S_SendTime,null);
  }

  public Timestamp getSendTime(){
        return DataType.getAsDateTime(this.get(S_SendTime));
  
  }
  public Timestamp getSendTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_SendTime));
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

  public void initIsReaded(String value){
     this.initProperty(S_IsReaded,value);
  }
  public  void setIsReaded(String value){
     this.set(S_IsReaded,value);
  }
  public  void setIsReadedNull(){
     this.set(S_IsReaded,null);
  }

  public String getIsReaded(){
       return DataType.getAsString(this.get(S_IsReaded));
  
  }
  public String getIsReadedInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsReaded));
      }

  public void initReadTime(Timestamp value){
     this.initProperty(S_ReadTime,value);
  }
  public  void setReadTime(Timestamp value){
     this.set(S_ReadTime,value);
  }
  public  void setReadTimeNull(){
     this.set(S_ReadTime,null);
  }

  public Timestamp getReadTime(){
        return DataType.getAsDateTime(this.get(S_ReadTime));
  
  }
  public Timestamp getReadTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ReadTime));
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

  public void initDepart(String value){
     this.initProperty(S_Depart,value);
  }
  public  void setDepart(String value){
     this.set(S_Depart,value);
  }
  public  void setDepartNull(){
     this.set(S_Depart,null);
  }

  public String getDepart(){
       return DataType.getAsString(this.get(S_Depart));
  
  }
  public String getDepartInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Depart));
      }

  public void initTaskLabel(String value){
     this.initProperty(S_TaskLabel,value);
  }
  public  void setTaskLabel(String value){
     this.set(S_TaskLabel,value);
  }
  public  void setTaskLabelNull(){
     this.set(S_TaskLabel,null);
  }

  public String getTaskLabel(){
       return DataType.getAsString(this.get(S_TaskLabel));
  
  }
  public String getTaskLabelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_TaskLabel));
      }

  public void initDealTime(Timestamp value){
     this.initProperty(S_DealTime,value);
  }
  public  void setDealTime(Timestamp value){
     this.set(S_DealTime,value);
  }
  public  void setDealTimeNull(){
     this.set(S_DealTime,null);
  }

  public Timestamp getDealTime(){
        return DataType.getAsDateTime(this.get(S_DealTime));
  
  }
  public Timestamp getDealTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_DealTime));
      }

  public void initAid(long value){
     this.initProperty(S_Aid,new Long(value));
  }
  public  void setAid(long value){
     this.set(S_Aid,new Long(value));
  }
  public  void setAidNull(){
     this.set(S_Aid,null);
  }

  public long getAid(){
        return DataType.getAsLong(this.get(S_Aid));
  
  }
  public long getAidInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Aid));
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

  public void initAppriseFlag(String value){
     this.initProperty(S_AppriseFlag,value);
  }
  public  void setAppriseFlag(String value){
     this.set(S_AppriseFlag,value);
  }
  public  void setAppriseFlagNull(){
     this.set(S_AppriseFlag,null);
  }

  public String getAppriseFlag(){
       return DataType.getAsString(this.get(S_AppriseFlag));
  
  }
  public String getAppriseFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AppriseFlag));
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

  public void initWfLabel(String value){
     this.initProperty(S_WfLabel,value);
  }
  public  void setWfLabel(String value){
     this.set(S_WfLabel,value);
  }
  public  void setWfLabelNull(){
     this.set(S_WfLabel,null);
  }

  public String getWfLabel(){
       return DataType.getAsString(this.get(S_WfLabel));
  
  }
  public String getWfLabelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WfLabel));
      }


 
 }

