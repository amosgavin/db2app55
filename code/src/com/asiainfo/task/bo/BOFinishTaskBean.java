package com.asiainfo.task.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.task.ivalues.*;

public class BOFinishTaskBean extends DataContainer implements DataContainerInterface,IBOFinishTaskValue{

  private static String  m_boName = "com.asiainfo.task.bo.BOFinishTask";



  public final static  String S_ApplyName = "APPLY_NAME";
  public final static  String S_WorkflowObjectId = "WORKFLOW_OBJECT_ID";
  public final static  String S_OrgName = "ORG_NAME";
  public final static  String S_CreateStaffId = "CREATE_STAFF_ID";
  public final static  String S_Label = "LABEL";
  public final static  String S_TemplateTag = "TEMPLATE_TAG";
  public final static  String S_WorkflowObjectType = "WORKFLOW_OBJECT_TYPE";
  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_ObjectTypeName = "OBJECT_TYPE_NAME";
  public final static  String S_StaffName = "STAFF_NAME";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_WorkflowId = "WORKFLOW_ID";
  public final static  String S_Department = "DEPARTMENT";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOFinishTaskBean() throws AIException{
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

  public void initDepartment(String value){
     this.initProperty(S_Department,value);
  }
  public  void setDepartment(String value){
     this.set(S_Department,value);
  }
  public  void setDepartmentNull(){
     this.set(S_Department,null);
  }

  public String getDepartment(){
       return DataType.getAsString(this.get(S_Department));
  
  }
  public String getDepartmentInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Department));
      }


 
 }

