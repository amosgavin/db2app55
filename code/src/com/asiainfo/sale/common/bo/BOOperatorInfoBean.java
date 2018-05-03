package com.asiainfo.sale.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.common.ivalues.*;

public class BOOperatorInfoBean extends DataContainer implements DataContainerInterface,IBOOperatorInfoValue{

  private static String  m_boName = "com.asiainfo.sale.common.bo.BOOperatorInfo";



  public final static  String S_Birthday = "BIRTHDAY";
  public final static  String S_State = "STATE";
  public final static  String S_OrganizeName = "ORGANIZE_NAME";
  public final static  String S_OperatorId = "OPERATOR_ID";
  public final static  String S_StaffId = "STAFF_ID";
  public final static  String S_OrganizeIdP = "ORGANIZE_ID_P";
  public final static  String S_Gender = "GENDER";
  public final static  String S_Opstate = "OPSTATE";
  public final static  String S_StaffName = "STAFF_NAME";
  public final static  String S_BillId = "BILL_ID";
  public final static  String S_Email = "EMAIL";
  public final static  String S_OrganizeNameP = "ORGANIZE_NAME_P";
  public final static  String S_OrgCode = "ORG_CODE";
  public final static  String S_Notes = "NOTES";
  public final static  String S_OrganizeId = "ORGANIZE_ID";
  public final static  String S_Code = "CODE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOOperatorInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initBirthday(Timestamp value){
     this.initProperty(S_Birthday,value);
  }
  public  void setBirthday(Timestamp value){
     this.set(S_Birthday,value);
  }
  public  void setBirthdayNull(){
     this.set(S_Birthday,null);
  }

  public Timestamp getBirthday(){
        return DataType.getAsDateTime(this.get(S_Birthday));
  
  }
  public Timestamp getBirthdayInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_Birthday));
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

  public void initOperatorId(long value){
     this.initProperty(S_OperatorId,new Long(value));
  }
  public  void setOperatorId(long value){
     this.set(S_OperatorId,new Long(value));
  }
  public  void setOperatorIdNull(){
     this.set(S_OperatorId,null);
  }

  public long getOperatorId(){
        return DataType.getAsLong(this.get(S_OperatorId));
  
  }
  public long getOperatorIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OperatorId));
      }

  public void initStaffId(long value){
     this.initProperty(S_StaffId,new Long(value));
  }
  public  void setStaffId(long value){
     this.set(S_StaffId,new Long(value));
  }
  public  void setStaffIdNull(){
     this.set(S_StaffId,null);
  }

  public long getStaffId(){
        return DataType.getAsLong(this.get(S_StaffId));
  
  }
  public long getStaffIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_StaffId));
      }

  public void initOrganizeIdP(long value){
     this.initProperty(S_OrganizeIdP,new Long(value));
  }
  public  void setOrganizeIdP(long value){
     this.set(S_OrganizeIdP,new Long(value));
  }
  public  void setOrganizeIdPNull(){
     this.set(S_OrganizeIdP,null);
  }

  public long getOrganizeIdP(){
        return DataType.getAsLong(this.get(S_OrganizeIdP));
  
  }
  public long getOrganizeIdPInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OrganizeIdP));
      }

  public void initGender(int value){
     this.initProperty(S_Gender,new Integer(value));
  }
  public  void setGender(int value){
     this.set(S_Gender,new Integer(value));
  }
  public  void setGenderNull(){
     this.set(S_Gender,null);
  }

  public int getGender(){
        return DataType.getAsInt(this.get(S_Gender));
  
  }
  public int getGenderInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Gender));
      }

  public void initOpstate(int value){
     this.initProperty(S_Opstate,new Integer(value));
  }
  public  void setOpstate(int value){
     this.set(S_Opstate,new Integer(value));
  }
  public  void setOpstateNull(){
     this.set(S_Opstate,null);
  }

  public int getOpstate(){
        return DataType.getAsInt(this.get(S_Opstate));
  
  }
  public int getOpstateInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Opstate));
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

  public void initBillId(String value){
     this.initProperty(S_BillId,value);
  }
  public  void setBillId(String value){
     this.set(S_BillId,value);
  }
  public  void setBillIdNull(){
     this.set(S_BillId,null);
  }

  public String getBillId(){
       return DataType.getAsString(this.get(S_BillId));
  
  }
  public String getBillIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BillId));
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

  public void initOrganizeNameP(String value){
     this.initProperty(S_OrganizeNameP,value);
  }
  public  void setOrganizeNameP(String value){
     this.set(S_OrganizeNameP,value);
  }
  public  void setOrganizeNamePNull(){
     this.set(S_OrganizeNameP,null);
  }

  public String getOrganizeNameP(){
       return DataType.getAsString(this.get(S_OrganizeNameP));
  
  }
  public String getOrganizeNamePInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrganizeNameP));
      }

  public void initOrgCode(String value){
     this.initProperty(S_OrgCode,value);
  }
  public  void setOrgCode(String value){
     this.set(S_OrgCode,value);
  }
  public  void setOrgCodeNull(){
     this.set(S_OrgCode,null);
  }

  public String getOrgCode(){
       return DataType.getAsString(this.get(S_OrgCode));
  
  }
  public String getOrgCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrgCode));
      }

  public void initNotes(String value){
     this.initProperty(S_Notes,value);
  }
  public  void setNotes(String value){
     this.set(S_Notes,value);
  }
  public  void setNotesNull(){
     this.set(S_Notes,null);
  }

  public String getNotes(){
       return DataType.getAsString(this.get(S_Notes));
  
  }
  public String getNotesInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Notes));
      }

  public void initOrganizeId(long value){
     this.initProperty(S_OrganizeId,new Long(value));
  }
  public  void setOrganizeId(long value){
     this.set(S_OrganizeId,new Long(value));
  }
  public  void setOrganizeIdNull(){
     this.set(S_OrganizeId,null);
  }

  public long getOrganizeId(){
        return DataType.getAsLong(this.get(S_OrganizeId));
  
  }
  public long getOrganizeIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OrganizeId));
      }

  public void initCode(String value){
     this.initProperty(S_Code,value);
  }
  public  void setCode(String value){
     this.set(S_Code,value);
  }
  public  void setCodeNull(){
     this.set(S_Code,null);
  }

  public String getCode(){
       return DataType.getAsString(this.get(S_Code));
  
  }
  public String getCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Code));
      }


 
 }

