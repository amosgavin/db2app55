package com.asiainfo.crm.exercise.staff.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.crm.exercise.staff.ivalues.*;

public class BOStaffBean extends DataContainer implements DataContainerInterface,IBOStaffValue{

  private static String  m_boName = "com.asiainfo.crm.exercise.staff.bo.BOStaff";



  public final static  String S_State = "STATE";
  public final static  String S_IsLogin = "IS_LOGIN";
  public final static  String S_StaffId = "STAFF_ID";
  public final static  String S_LastLoginLogId = "LAST_LOGIN_LOG_ID";
  public final static  String S_StaffTypeId = "STAFF_TYPE_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_CertifiCode = "CERTIFI_CODE";
  public final static  String S_Email = "EMAIL";
  public final static  String S_OfficeTel = "OFFICE_TEL";
  public final static  String S_CheckFlag = "CHECK_FLAG";
  public final static  String S_OrganizeId = "ORGANIZE_ID";
  public final static  String S_HomeTel = "HOME_TEL";
  public final static  String S_LockFlag = "LOCK_FLAG";
  public final static  String S_IsAllRecord = "IS_ALL_RECORD";
  public final static  String S_MultiLoginFlag = "MULTI_LOGIN_FLAG";
  public final static  String S_MobileTele = "MOBILE_TELE";
  public final static  String S_AddrId = "ADDR_ID";
  public final static  String S_CertifiTypeId = "CERTIFI_TYPE_ID";
  public final static  String S_Password = "PASSWORD";
  public final static  String S_TryTimes = "TRY_TIMES";
  public final static  String S_ReportToStaffId = "REPORT_TO_STAFF_ID";
  public final static  String S_ExpireDate = "EXPIRE_DATE";
  public final static  String S_EducationTypeId = "EDUCATION_TYPE_ID";
  public final static  String S_Code = "CODE";
  public final static  String S_Name = "NAME";
  public final static  String S_EffectDate = "EFFECT_DATE";
  public final static  String S_WorkTypeId = "WORK_TYPE_ID";
  public final static  String S_AllowChangePassword = "ALLOW_CHANGE_PASSWORD";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOStaffBean() throws AIException{
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

  public void initIsLogin(String value){
     this.initProperty(S_IsLogin,value);
  }
  public  void setIsLogin(String value){
     this.set(S_IsLogin,value);
  }
  public  void setIsLoginNull(){
     this.set(S_IsLogin,null);
  }

  public String getIsLogin(){
       return DataType.getAsString(this.get(S_IsLogin));
  
  }
  public String getIsLoginInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsLogin));
      }

  public void initStaffId(int value){
     this.initProperty(S_StaffId,new Integer(value));
  }
  public  void setStaffId(int value){
     this.set(S_StaffId,new Integer(value));
  }
  public  void setStaffIdNull(){
     this.set(S_StaffId,null);
  }

  public int getStaffId(){
        return DataType.getAsInt(this.get(S_StaffId));
  
  }
  public int getStaffIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_StaffId));
      }

  public void initLastLoginLogId(long value){
     this.initProperty(S_LastLoginLogId,new Long(value));
  }
  public  void setLastLoginLogId(long value){
     this.set(S_LastLoginLogId,new Long(value));
  }
  public  void setLastLoginLogIdNull(){
     this.set(S_LastLoginLogId,null);
  }

  public long getLastLoginLogId(){
        return DataType.getAsLong(this.get(S_LastLoginLogId));
  
  }
  public long getLastLoginLogIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_LastLoginLogId));
      }

  public void initStaffTypeId(int value){
     this.initProperty(S_StaffTypeId,new Integer(value));
  }
  public  void setStaffTypeId(int value){
     this.set(S_StaffTypeId,new Integer(value));
  }
  public  void setStaffTypeIdNull(){
     this.set(S_StaffTypeId,null);
  }

  public int getStaffTypeId(){
        return DataType.getAsInt(this.get(S_StaffTypeId));
  
  }
  public int getStaffTypeIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_StaffTypeId));
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

  public void initCertifiCode(String value){
     this.initProperty(S_CertifiCode,value);
  }
  public  void setCertifiCode(String value){
     this.set(S_CertifiCode,value);
  }
  public  void setCertifiCodeNull(){
     this.set(S_CertifiCode,null);
  }

  public String getCertifiCode(){
       return DataType.getAsString(this.get(S_CertifiCode));
  
  }
  public String getCertifiCodeInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CertifiCode));
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

  public void initOfficeTel(String value){
     this.initProperty(S_OfficeTel,value);
  }
  public  void setOfficeTel(String value){
     this.set(S_OfficeTel,value);
  }
  public  void setOfficeTelNull(){
     this.set(S_OfficeTel,null);
  }

  public String getOfficeTel(){
       return DataType.getAsString(this.get(S_OfficeTel));
  
  }
  public String getOfficeTelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OfficeTel));
      }

  public void initCheckFlag(String value){
     this.initProperty(S_CheckFlag,value);
  }
  public  void setCheckFlag(String value){
     this.set(S_CheckFlag,value);
  }
  public  void setCheckFlagNull(){
     this.set(S_CheckFlag,null);
  }

  public String getCheckFlag(){
       return DataType.getAsString(this.get(S_CheckFlag));
  
  }
  public String getCheckFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CheckFlag));
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

  public void initHomeTel(String value){
     this.initProperty(S_HomeTel,value);
  }
  public  void setHomeTel(String value){
     this.set(S_HomeTel,value);
  }
  public  void setHomeTelNull(){
     this.set(S_HomeTel,null);
  }

  public String getHomeTel(){
       return DataType.getAsString(this.get(S_HomeTel));
  
  }
  public String getHomeTelInitialValue(){
        return DataType.getAsString(this.getOldObj(S_HomeTel));
      }

  public void initLockFlag(String value){
     this.initProperty(S_LockFlag,value);
  }
  public  void setLockFlag(String value){
     this.set(S_LockFlag,value);
  }
  public  void setLockFlagNull(){
     this.set(S_LockFlag,null);
  }

  public String getLockFlag(){
       return DataType.getAsString(this.get(S_LockFlag));
  
  }
  public String getLockFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_LockFlag));
      }

  public void initIsAllRecord(String value){
     this.initProperty(S_IsAllRecord,value);
  }
  public  void setIsAllRecord(String value){
     this.set(S_IsAllRecord,value);
  }
  public  void setIsAllRecordNull(){
     this.set(S_IsAllRecord,null);
  }

  public String getIsAllRecord(){
       return DataType.getAsString(this.get(S_IsAllRecord));
  
  }
  public String getIsAllRecordInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsAllRecord));
      }

  public void initMultiLoginFlag(String value){
     this.initProperty(S_MultiLoginFlag,value);
  }
  public  void setMultiLoginFlag(String value){
     this.set(S_MultiLoginFlag,value);
  }
  public  void setMultiLoginFlagNull(){
     this.set(S_MultiLoginFlag,null);
  }

  public String getMultiLoginFlag(){
       return DataType.getAsString(this.get(S_MultiLoginFlag));
  
  }
  public String getMultiLoginFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MultiLoginFlag));
      }

  public void initMobileTele(String value){
     this.initProperty(S_MobileTele,value);
  }
  public  void setMobileTele(String value){
     this.set(S_MobileTele,value);
  }
  public  void setMobileTeleNull(){
     this.set(S_MobileTele,null);
  }

  public String getMobileTele(){
       return DataType.getAsString(this.get(S_MobileTele));
  
  }
  public String getMobileTeleInitialValue(){
        return DataType.getAsString(this.getOldObj(S_MobileTele));
      }

  public void initAddrId(String value){
     this.initProperty(S_AddrId,value);
  }
  public  void setAddrId(String value){
     this.set(S_AddrId,value);
  }
  public  void setAddrIdNull(){
     this.set(S_AddrId,null);
  }

  public String getAddrId(){
       return DataType.getAsString(this.get(S_AddrId));
  
  }
  public String getAddrIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AddrId));
      }

  public void initCertifiTypeId(int value){
     this.initProperty(S_CertifiTypeId,new Integer(value));
  }
  public  void setCertifiTypeId(int value){
     this.set(S_CertifiTypeId,new Integer(value));
  }
  public  void setCertifiTypeIdNull(){
     this.set(S_CertifiTypeId,null);
  }

  public int getCertifiTypeId(){
        return DataType.getAsInt(this.get(S_CertifiTypeId));
  
  }
  public int getCertifiTypeIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_CertifiTypeId));
      }

  public void initPassword(String value){
     this.initProperty(S_Password,value);
  }
  public  void setPassword(String value){
     this.set(S_Password,value);
  }
  public  void setPasswordNull(){
     this.set(S_Password,null);
  }

  public String getPassword(){
       return DataType.getAsString(this.get(S_Password));
  
  }
  public String getPasswordInitialValue(){
        return DataType.getAsString(this.getOldObj(S_Password));
      }

  public void initTryTimes(long value){
     this.initProperty(S_TryTimes,new Long(value));
  }
  public  void setTryTimes(long value){
     this.set(S_TryTimes,new Long(value));
  }
  public  void setTryTimesNull(){
     this.set(S_TryTimes,null);
  }

  public long getTryTimes(){
        return DataType.getAsLong(this.get(S_TryTimes));
  
  }
  public long getTryTimesInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_TryTimes));
      }

  public void initReportToStaffId(int value){
     this.initProperty(S_ReportToStaffId,new Integer(value));
  }
  public  void setReportToStaffId(int value){
     this.set(S_ReportToStaffId,new Integer(value));
  }
  public  void setReportToStaffIdNull(){
     this.set(S_ReportToStaffId,null);
  }

  public int getReportToStaffId(){
        return DataType.getAsInt(this.get(S_ReportToStaffId));
  
  }
  public int getReportToStaffIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_ReportToStaffId));
      }

  public void initExpireDate(Timestamp value){
     this.initProperty(S_ExpireDate,value);
  }
  public  void setExpireDate(Timestamp value){
     this.set(S_ExpireDate,value);
  }
  public  void setExpireDateNull(){
     this.set(S_ExpireDate,null);
  }

  public Timestamp getExpireDate(){
        return DataType.getAsDateTime(this.get(S_ExpireDate));
  
  }
  public Timestamp getExpireDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ExpireDate));
      }

  public void initEducationTypeId(int value){
     this.initProperty(S_EducationTypeId,new Integer(value));
  }
  public  void setEducationTypeId(int value){
     this.set(S_EducationTypeId,new Integer(value));
  }
  public  void setEducationTypeIdNull(){
     this.set(S_EducationTypeId,null);
  }

  public int getEducationTypeId(){
        return DataType.getAsInt(this.get(S_EducationTypeId));
  
  }
  public int getEducationTypeIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_EducationTypeId));
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

  public void initEffectDate(Timestamp value){
     this.initProperty(S_EffectDate,value);
  }
  public  void setEffectDate(Timestamp value){
     this.set(S_EffectDate,value);
  }
  public  void setEffectDateNull(){
     this.set(S_EffectDate,null);
  }

  public Timestamp getEffectDate(){
        return DataType.getAsDateTime(this.get(S_EffectDate));
  
  }
  public Timestamp getEffectDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_EffectDate));
      }

  public void initWorkTypeId(int value){
     this.initProperty(S_WorkTypeId,new Integer(value));
  }
  public  void setWorkTypeId(int value){
     this.set(S_WorkTypeId,new Integer(value));
  }
  public  void setWorkTypeIdNull(){
     this.set(S_WorkTypeId,null);
  }

  public int getWorkTypeId(){
        return DataType.getAsInt(this.get(S_WorkTypeId));
  
  }
  public int getWorkTypeIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_WorkTypeId));
      }

  public void initAllowChangePassword(String value){
     this.initProperty(S_AllowChangePassword,value);
  }
  public  void setAllowChangePassword(String value){
     this.set(S_AllowChangePassword,value);
  }
  public  void setAllowChangePasswordNull(){
     this.set(S_AllowChangePassword,null);
  }

  public String getAllowChangePassword(){
       return DataType.getAsString(this.get(S_AllowChangePassword));
  
  }
  public String getAllowChangePasswordInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AllowChangePassword));
      }


 
 }

