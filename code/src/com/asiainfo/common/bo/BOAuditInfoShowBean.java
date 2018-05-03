package com.asiainfo.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.common.ivalues.*;

public class BOAuditInfoShowBean extends DataContainer implements DataContainerInterface,IBOAuditInfoShowValue{

  private static String  m_boName = "com.asiainfo.common.bo.BOAuditInfoShow";



  public final static  String S_DecisionResult = "DECISION_RESULT";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_Label = "LABEL";
  public final static  String S_StaffName = "STAFF_NAME";
  public final static  String S_Depart = "DEPART";
  public final static  String S_Org = "ORG";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOAuditInfoShowBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
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

  public void initOrg(String value){
     this.initProperty(S_Org,value);
  }
  public  void setOrg(String value){
     this.set(S_Org,value);
  }
  public  void setOrgNull(){
     this.set(S_Org,null);
  }

  public String getOrg(){
       return DataType.getAsString(this.get(S_Org));
  
  }
  public String getOrgInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Org));
      }


 
 }

