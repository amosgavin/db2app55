package com.asiainfo.sale.weapon.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.weapon.ivalues.*;

public class BOSaleWeaponMainDeBean extends DataContainer implements DataContainerInterface,IBOSaleWeaponMainDeValue{

  private static String  m_boName = "com.asiainfo.sale.weapon.bo.BOSaleWeaponMainDe";



  public final static  String S_ApplyName = "APPLY_NAME";
  public final static  String S_Applicant = "APPLICANT";
  public final static  String S_OrganizeName = "ORGANIZE_NAME";
  public final static  String S_ConfigTime = "CONFIG_TIME";
  public final static  String S_Wid = "WID";
  public final static  String S_ModifyTime = "MODIFY_TIME";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_Remark = "REMARK";
  public final static  String S_Principal = "PRINCIPAL";
  public final static  String S_Id = "ID";
  public final static  String S_StaffName = "STAFF_NAME";
  public final static  String S_Org = "ORG";
  public final static  String S_PromoteDepart = "PROMOTE_DEPART";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOSaleWeaponMainDeBean() throws AIException{
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

  public void initApplicant(String value){
     this.initProperty(S_Applicant,value);
  }
  public  void setApplicant(String value){
     this.set(S_Applicant,value);
  }
  public  void setApplicantNull(){
     this.set(S_Applicant,null);
  }

  public String getApplicant(){
       return DataType.getAsString(this.get(S_Applicant));
  
  }
  public String getApplicantInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Applicant));
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

  public void initConfigTime(Timestamp value){
     this.initProperty(S_ConfigTime,value);
  }
  public  void setConfigTime(Timestamp value){
     this.set(S_ConfigTime,value);
  }
  public  void setConfigTimeNull(){
     this.set(S_ConfigTime,null);
  }

  public Timestamp getConfigTime(){
        return DataType.getAsDateTime(this.get(S_ConfigTime));
  
  }
  public Timestamp getConfigTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ConfigTime));
      }

  public void initWid(String value){
     this.initProperty(S_Wid,value);
  }
  public  void setWid(String value){
     this.set(S_Wid,value);
  }
  public  void setWidNull(){
     this.set(S_Wid,null);
  }

  public String getWid(){
       return DataType.getAsString(this.get(S_Wid));
  
  }
  public String getWidInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Wid));
      }

  public void initModifyTime(Timestamp value){
     this.initProperty(S_ModifyTime,value);
  }
  public  void setModifyTime(Timestamp value){
     this.set(S_ModifyTime,value);
  }
  public  void setModifyTimeNull(){
     this.set(S_ModifyTime,null);
  }

  public Timestamp getModifyTime(){
        return DataType.getAsDateTime(this.get(S_ModifyTime));
  
  }
  public Timestamp getModifyTimeInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ModifyTime));
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

  public void initRemark(String value){
     this.initProperty(S_Remark,value);
  }
  public  void setRemark(String value){
     this.set(S_Remark,value);
  }
  public  void setRemarkNull(){
     this.set(S_Remark,null);
  }

  public String getRemark(){
       return DataType.getAsString(this.get(S_Remark));
  
  }
  public String getRemarkInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Remark));
      }

  public void initPrincipal(String value){
     this.initProperty(S_Principal,value);
  }
  public  void setPrincipal(String value){
     this.set(S_Principal,value);
  }
  public  void setPrincipalNull(){
     this.set(S_Principal,null);
  }

  public String getPrincipal(){
       return DataType.getAsString(this.get(S_Principal));
  
  }
  public String getPrincipalInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Principal));
      }

  public void initId(String value){
     this.initProperty(S_Id,value);
  }
  public  void setId(String value){
     this.set(S_Id,value);
  }
  public  void setIdNull(){
     this.set(S_Id,null);
  }

  public String getId(){
       return DataType.getAsString(this.get(S_Id));
  
  }
  public String getIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Id));
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

  public void initPromoteDepart(String value){
     this.initProperty(S_PromoteDepart,value);
  }
  public  void setPromoteDepart(String value){
     this.set(S_PromoteDepart,value);
  }
  public  void setPromoteDepartNull(){
     this.set(S_PromoteDepart,null);
  }

  public String getPromoteDepart(){
       return DataType.getAsString(this.get(S_PromoteDepart));
  
  }
  public String getPromoteDepartInitialValue(){
        return DataType.getAsString(this.getOldObj(S_PromoteDepart));
      }


 
 }

