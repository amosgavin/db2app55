package com.asiainfo.crm.exercise.staff.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.crm.exercise.staff.ivalues.*;

public class BOOrganizeBean extends DataContainer implements DataContainerInterface,IBOOrganizeValue{

  private static String  m_boName = "com.asiainfo.crm.exercise.staff.bo.BOOrganize";



  public final static  String S_State = "STATE";
  public final static  String S_DistrictId = "DISTRICT_ID";
  public final static  String S_ContactTel = "CONTACT_TEL";
  public final static  String S_OrganizeId = "ORGANIZE_ID";
  public final static  String S_ManageStaffId = "MANAGE_STAFF_ID";
  public final static  String S_ParentOrganizeId = "PARENT_ORGANIZE_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_Name = "NAME";
  public final static  String S_Fax = "FAX";
  public final static  String S_Contact = "CONTACT";
  public final static  String S_OrganizeTypeId = "ORGANIZE_TYPE_ID";
  public final static  String S_Email = "EMAIL";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOOrganizeBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initState(String value){
     this.initProperty(S_State,value);
  }
  public  void setState(String value){
     this.set(S_State,value);
  }
  public  void setStateNull(){
     this.set(S_State,null);
  }

  public String getState(){
       return DataType.getAsString(this.get(S_State));
  
  }
  public String getStateInitialValue(){
        return DataType.getAsString(this.getOldObj(S_State));
      }

  public void initDistrictId(int value){
     this.initProperty(S_DistrictId,new Integer(value));
  }
  public  void setDistrictId(int value){
     this.set(S_DistrictId,new Integer(value));
  }
  public  void setDistrictIdNull(){
     this.set(S_DistrictId,null);
  }

  public int getDistrictId(){
        return DataType.getAsInt(this.get(S_DistrictId));
  
  }
  public int getDistrictIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_DistrictId));
      }

  public void initContactTel(String value){
     this.initProperty(S_ContactTel,value);
  }
  public  void setContactTel(String value){
     this.set(S_ContactTel,value);
  }
  public  void setContactTelNull(){
     this.set(S_ContactTel,null);
  }

  public String getContactTel(){
       return DataType.getAsString(this.get(S_ContactTel));
  
  }
  public String getContactTelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ContactTel));
      }

  public void initOrganizeId(int value){
     this.initProperty(S_OrganizeId,new Integer(value));
  }
  public  void setOrganizeId(int value){
     this.set(S_OrganizeId,new Integer(value));
  }
  public  void setOrganizeIdNull(){
     this.set(S_OrganizeId,null);
  }

  public int getOrganizeId(){
        return DataType.getAsInt(this.get(S_OrganizeId));
  
  }
  public int getOrganizeIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_OrganizeId));
      }

  public void initManageStaffId(int value){
     this.initProperty(S_ManageStaffId,new Integer(value));
  }
  public  void setManageStaffId(int value){
     this.set(S_ManageStaffId,new Integer(value));
  }
  public  void setManageStaffIdNull(){
     this.set(S_ManageStaffId,null);
  }

  public int getManageStaffId(){
        return DataType.getAsInt(this.get(S_ManageStaffId));
  
  }
  public int getManageStaffIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_ManageStaffId));
      }

  public void initParentOrganizeId(int value){
     this.initProperty(S_ParentOrganizeId,new Integer(value));
  }
  public  void setParentOrganizeId(int value){
     this.set(S_ParentOrganizeId,new Integer(value));
  }
  public  void setParentOrganizeIdNull(){
     this.set(S_ParentOrganizeId,null);
  }

  public int getParentOrganizeId(){
        return DataType.getAsInt(this.get(S_ParentOrganizeId));
  
  }
  public int getParentOrganizeIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_ParentOrganizeId));
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

  public void initName(String value){
     this.initProperty(S_Name,value);
  }
  public  void setName(String value){
     this.set(S_Name,value);
  }
  public  void setNameNull(){
     this.set(S_Name,null);
  }

  public String getName(){
       return DataType.getAsString(this.get(S_Name));
  
  }
  public String getNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Name));
      }

  public void initFax(String value){
     this.initProperty(S_Fax,value);
  }
  public  void setFax(String value){
     this.set(S_Fax,value);
  }
  public  void setFaxNull(){
     this.set(S_Fax,null);
  }

  public String getFax(){
       return DataType.getAsString(this.get(S_Fax));
  
  }
  public String getFaxInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Fax));
      }

  public void initContact(String value){
     this.initProperty(S_Contact,value);
  }
  public  void setContact(String value){
     this.set(S_Contact,value);
  }
  public  void setContactNull(){
     this.set(S_Contact,null);
  }

  public String getContact(){
       return DataType.getAsString(this.get(S_Contact));
  
  }
  public String getContactInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Contact));
      }

  public void initOrganizeTypeId(int value){
     this.initProperty(S_OrganizeTypeId,new Integer(value));
  }
  public  void setOrganizeTypeId(int value){
     this.set(S_OrganizeTypeId,new Integer(value));
  }
  public  void setOrganizeTypeIdNull(){
     this.set(S_OrganizeTypeId,null);
  }

  public int getOrganizeTypeId(){
        return DataType.getAsInt(this.get(S_OrganizeTypeId));
  
  }
  public int getOrganizeTypeIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_OrganizeTypeId));
      }

  public void initEmail(String value){
     this.initProperty(S_Email,value);
  }
  public  void setEmail(String value){
     this.set(S_Email,value);
  }
  public  void setEmailNull(){
     this.set(S_Email,null);
  }

  public String getEmail(){
       return DataType.getAsString(this.get(S_Email));
  
  }
  public String getEmailInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Email));
      }


 
 }

