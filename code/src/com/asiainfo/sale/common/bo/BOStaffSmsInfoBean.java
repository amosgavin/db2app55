package com.asiainfo.sale.common.bo;

import java.sql.*;
import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.DataType;

import com.asiainfo.sale.common.ivalues.*;

public class BOStaffSmsInfoBean extends DataContainer implements DataContainerInterface,IBOStaffSmsInfoValue{

  private static String  m_boName = "com.asiainfo.sale.common.bo.BOStaffSmsInfo";



  public final static  String S_TryTimes = "TRY_TIMES";
  public final static  String S_LastLoginLogId = "LAST_LOGIN_LOG_ID";
  public final static  String S_EducationLevel = "EDUCATION_LEVEL";
  public final static  String S_IpmacFlag = "IPMAC_FLAG";
  public final static  String S_CharacterDesc = "CHARACTER_DESC";
  public final static  String S_IncomeLevel = "INCOME_LEVEL";
  public final static  String S_AlarmBillId = "ALARM_BILL_ID";
  public final static  String S_ValidDate = "VALID_DATE";
  public final static  String S_ChgPasswdAlarmDays = "CHG_PASSWD_ALARM_DAYS";
  public final static  String S_EnglishName = "ENGLISH_NAME";
  public final static  String S_Code = "CODE";
  public final static  String S_ExpireDate = "EXPIRE_DATE";
  public final static  String S_OpId = "OP_ID";
  public final static  String S_AllowChangePassword = "ALLOW_CHANGE_PASSWORD";
  public final static  String S_StaffLevel = "STAFF_LEVEL";
  public final static  String S_IsLogin = "IS_LOGIN";
  public final static  String S_OfficeTel = "OFFICE_TEL";
  public final static  String S_CancelDays = "CANCEL_DAYS";
  public final static  String S_WirelessCall = "WIRELESS_CALL";
  public final static  String S_DoneDate = "DONE_DATE";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_OrganizeId = "ORGANIZE_ID";
  public final static  String S_StaffType = "STAFF_TYPE";
  public final static  String S_PoliticsFace = "POLITICS_FACE";
  public final static  String S_NationalType = "NATIONAL_TYPE";
  public final static  String S_PasswordValidDate = "PASSWORD_VALID_DATE";
  public final static  String S_State = "STATE";
  public final static  String S_IsVpnLoginFlag = "IS_VPN_LOGIN_FLAG";
  public final static  String S_OperatorId = "OPERATOR_ID";
  public final static  String S_Postcode = "POSTCODE";
  public final static  String S_SecurityId = "SECURITY_ID";
  public final static  String S_ShortName = "SHORT_NAME";
  public final static  String S_IsAdmin = "IS_ADMIN";
  public final static  String S_ParentStaffId = "PARENT_STAFF_ID";
  public final static  String S_ContactAddress = "CONTACT_ADDRESS";
  public final static  String S_BcMgr = "BC_MGR";
  public final static  String S_HomeTel = "HOME_TEL";
  public final static  String S_CarNo = "CAR_NO";
  public final static  String S_AcctEffectDate = "ACCT_EFFECT_DATE";
  public final static  String S_CardNo = "CARD_NO";
  public final static  String S_MarryStatus = "MARRY_STATUS";
  public final static  String S_StaffName = "STAFF_NAME";
  public final static  String S_Email = "EMAIL";
  public final static  String S_CardTypeId = "CARD_TYPE_ID";
  public final static  String S_DoneCode = "DONE_CODE";
  public final static  String S_FaxId = "FAX_ID";
  public final static  String S_Password = "PASSWORD";
  public final static  String S_Notes = "NOTES";
  public final static  String S_Birthday = "BIRTHDAY";
  public final static  String S_LoginChannel = "LOGIN_CHANNEL";
  public final static  String S_RecentPassword = "RECENT_PASSWORD";
  public final static  String S_JobCompany = "JOB_COMPANY";
  public final static  String S_ChgPasswdFlag = "CHG_PASSWD_FLAG";
  public final static  String S_FamilyInfo = "FAMILY_INFO";
  public final static  String S_JobPosition = "JOB_POSITION";
  public final static  String S_OrgId = "ORG_ID";
  public final static  String S_StaffId = "STAFF_ID";
  public final static  String S_RecentPassTimes = "RECENT_PASS_TIMES";
  public final static  String S_Gender = "GENDER";
  public final static  String S_JobDesc = "JOB_DESC";
  public final static  String S_Religion = "RELIGION";
  public final static  String S_LockFlag = "LOCK_FLAG";
  public final static  String S_BillId = "BILL_ID";
  public final static  String S_AcctExpireDate = "ACCT_EXPIRE_DATE";

  public static ObjectType S_TYPE = null;
  static{
    try {
      S_TYPE = ServiceManager.getObjectTypeFactory().getInstance(m_boName);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
  public BOStaffSmsInfoBean() throws AIException{
      super(S_TYPE);
  }

 public static ObjectType getObjectTypeStatic() throws AIException{
   return S_TYPE;
 }

 public void setObjectType(ObjectType  value) throws AIException{
   //此种数据容器不能重置业务对象类型
   throw new AIException("Cannot reset ObjectType");
 }


  public void initTryTimes(int value){
     this.initProperty(S_TryTimes,new Integer(value));
  }
  public  void setTryTimes(int value){
     this.set(S_TryTimes,new Integer(value));
  }
  public  void setTryTimesNull(){
     this.set(S_TryTimes,null);
  }

  public int getTryTimes(){
        return DataType.getAsInt(this.get(S_TryTimes));
  
  }
  public int getTryTimesInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_TryTimes));
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

  public void initEducationLevel(int value){
     this.initProperty(S_EducationLevel,new Integer(value));
  }
  public  void setEducationLevel(int value){
     this.set(S_EducationLevel,new Integer(value));
  }
  public  void setEducationLevelNull(){
     this.set(S_EducationLevel,null);
  }

  public int getEducationLevel(){
        return DataType.getAsInt(this.get(S_EducationLevel));
  
  }
  public int getEducationLevelInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_EducationLevel));
      }

  public void initIpmacFlag(String value){
     this.initProperty(S_IpmacFlag,value);
  }
  public  void setIpmacFlag(String value){
     this.set(S_IpmacFlag,value);
  }
  public  void setIpmacFlagNull(){
     this.set(S_IpmacFlag,null);
  }

  public String getIpmacFlag(){
       return DataType.getAsString(this.get(S_IpmacFlag));
  
  }
  public String getIpmacFlagInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IpmacFlag));
      }

  public void initCharacterDesc(String value){
     this.initProperty(S_CharacterDesc,value);
  }
  public  void setCharacterDesc(String value){
     this.set(S_CharacterDesc,value);
  }
  public  void setCharacterDescNull(){
     this.set(S_CharacterDesc,null);
  }

  public String getCharacterDesc(){
       return DataType.getAsString(this.get(S_CharacterDesc));
  
  }
  public String getCharacterDescInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CharacterDesc));
      }

  public void initIncomeLevel(long value){
     this.initProperty(S_IncomeLevel,new Long(value));
  }
  public  void setIncomeLevel(long value){
     this.set(S_IncomeLevel,new Long(value));
  }
  public  void setIncomeLevelNull(){
     this.set(S_IncomeLevel,null);
  }

  public long getIncomeLevel(){
        return DataType.getAsLong(this.get(S_IncomeLevel));
  
  }
  public long getIncomeLevelInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_IncomeLevel));
      }

  public void initAlarmBillId(String value){
     this.initProperty(S_AlarmBillId,value);
  }
  public  void setAlarmBillId(String value){
     this.set(S_AlarmBillId,value);
  }
  public  void setAlarmBillIdNull(){
     this.set(S_AlarmBillId,null);
  }

  public String getAlarmBillId(){
       return DataType.getAsString(this.get(S_AlarmBillId));
  
  }
  public String getAlarmBillIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_AlarmBillId));
      }

  public void initValidDate(Timestamp value){
     this.initProperty(S_ValidDate,value);
  }
  public  void setValidDate(Timestamp value){
     this.set(S_ValidDate,value);
  }
  public  void setValidDateNull(){
     this.set(S_ValidDate,null);
  }

  public Timestamp getValidDate(){
        return DataType.getAsDateTime(this.get(S_ValidDate));
  
  }
  public Timestamp getValidDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_ValidDate));
      }

  public void initChgPasswdAlarmDays(long value){
     this.initProperty(S_ChgPasswdAlarmDays,new Long(value));
  }
  public  void setChgPasswdAlarmDays(long value){
     this.set(S_ChgPasswdAlarmDays,new Long(value));
  }
  public  void setChgPasswdAlarmDaysNull(){
     this.set(S_ChgPasswdAlarmDays,null);
  }

  public long getChgPasswdAlarmDays(){
        return DataType.getAsLong(this.get(S_ChgPasswdAlarmDays));
  
  }
  public long getChgPasswdAlarmDaysInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ChgPasswdAlarmDays));
      }

  public void initEnglishName(String value){
     this.initProperty(S_EnglishName,value);
  }
  public  void setEnglishName(String value){
     this.set(S_EnglishName,value);
  }
  public  void setEnglishNameNull(){
     this.set(S_EnglishName,null);
  }

  public String getEnglishName(){
       return DataType.getAsString(this.get(S_EnglishName));
  
  }
  public String getEnglishNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_EnglishName));
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

  public void initOpId(long value){
     this.initProperty(S_OpId,new Long(value));
  }
  public  void setOpId(long value){
     this.set(S_OpId,new Long(value));
  }
  public  void setOpIdNull(){
     this.set(S_OpId,null);
  }

  public long getOpId(){
        return DataType.getAsLong(this.get(S_OpId));
  
  }
  public long getOpIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OpId));
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

  public void initStaffLevel(int value){
     this.initProperty(S_StaffLevel,new Integer(value));
  }
  public  void setStaffLevel(int value){
     this.set(S_StaffLevel,new Integer(value));
  }
  public  void setStaffLevelNull(){
     this.set(S_StaffLevel,null);
  }

  public int getStaffLevel(){
        return DataType.getAsInt(this.get(S_StaffLevel));
  
  }
  public int getStaffLevelInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_StaffLevel));
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

  public void initCancelDays(int value){
     this.initProperty(S_CancelDays,new Integer(value));
  }
  public  void setCancelDays(int value){
     this.set(S_CancelDays,new Integer(value));
  }
  public  void setCancelDaysNull(){
     this.set(S_CancelDays,null);
  }

  public int getCancelDays(){
        return DataType.getAsInt(this.get(S_CancelDays));
  
  }
  public int getCancelDaysInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_CancelDays));
      }

  public void initWirelessCall(String value){
     this.initProperty(S_WirelessCall,value);
  }
  public  void setWirelessCall(String value){
     this.set(S_WirelessCall,value);
  }
  public  void setWirelessCallNull(){
     this.set(S_WirelessCall,null);
  }

  public String getWirelessCall(){
       return DataType.getAsString(this.get(S_WirelessCall));
  
  }
  public String getWirelessCallInitialValue(){
        return DataType.getAsString(this.getOldObj(S_WirelessCall));
      }

  public void initDoneDate(Timestamp value){
     this.initProperty(S_DoneDate,value);
  }
  public  void setDoneDate(Timestamp value){
     this.set(S_DoneDate,value);
  }
  public  void setDoneDateNull(){
     this.set(S_DoneDate,null);
  }

  public Timestamp getDoneDate(){
        return DataType.getAsDateTime(this.get(S_DoneDate));
  
  }
  public Timestamp getDoneDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_DoneDate));
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

  public void initOrganizeId(String value){
     this.initProperty(S_OrganizeId,value);
  }
  public  void setOrganizeId(String value){
     this.set(S_OrganizeId,value);
  }
  public  void setOrganizeIdNull(){
     this.set(S_OrganizeId,null);
  }

  public String getOrganizeId(){
       return DataType.getAsString(this.get(S_OrganizeId));
  
  }
  public String getOrganizeIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_OrganizeId));
      }

  public void initStaffType(int value){
     this.initProperty(S_StaffType,new Integer(value));
  }
  public  void setStaffType(int value){
     this.set(S_StaffType,new Integer(value));
  }
  public  void setStaffTypeNull(){
     this.set(S_StaffType,null);
  }

  public int getStaffType(){
        return DataType.getAsInt(this.get(S_StaffType));
  
  }
  public int getStaffTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_StaffType));
      }

  public void initPoliticsFace(int value){
     this.initProperty(S_PoliticsFace,new Integer(value));
  }
  public  void setPoliticsFace(int value){
     this.set(S_PoliticsFace,new Integer(value));
  }
  public  void setPoliticsFaceNull(){
     this.set(S_PoliticsFace,null);
  }

  public int getPoliticsFace(){
        return DataType.getAsInt(this.get(S_PoliticsFace));
  
  }
  public int getPoliticsFaceInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_PoliticsFace));
      }

  public void initNationalType(int value){
     this.initProperty(S_NationalType,new Integer(value));
  }
  public  void setNationalType(int value){
     this.set(S_NationalType,new Integer(value));
  }
  public  void setNationalTypeNull(){
     this.set(S_NationalType,null);
  }

  public int getNationalType(){
        return DataType.getAsInt(this.get(S_NationalType));
  
  }
  public int getNationalTypeInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_NationalType));
      }

  public void initPasswordValidDate(Timestamp value){
     this.initProperty(S_PasswordValidDate,value);
  }
  public  void setPasswordValidDate(Timestamp value){
     this.set(S_PasswordValidDate,value);
  }
  public  void setPasswordValidDateNull(){
     this.set(S_PasswordValidDate,null);
  }

  public Timestamp getPasswordValidDate(){
        return DataType.getAsDateTime(this.get(S_PasswordValidDate));
  
  }
  public Timestamp getPasswordValidDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_PasswordValidDate));
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

  public void initIsVpnLoginFlag(long value){
     this.initProperty(S_IsVpnLoginFlag,new Long(value));
  }
  public  void setIsVpnLoginFlag(long value){
     this.set(S_IsVpnLoginFlag,new Long(value));
  }
  public  void setIsVpnLoginFlagNull(){
     this.set(S_IsVpnLoginFlag,null);
  }

  public long getIsVpnLoginFlag(){
        return DataType.getAsLong(this.get(S_IsVpnLoginFlag));
  
  }
  public long getIsVpnLoginFlagInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_IsVpnLoginFlag));
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

  public void initPostcode(long value){
     this.initProperty(S_Postcode,new Long(value));
  }
  public  void setPostcode(long value){
     this.set(S_Postcode,new Long(value));
  }
  public  void setPostcodeNull(){
     this.set(S_Postcode,null);
  }

  public long getPostcode(){
        return DataType.getAsLong(this.get(S_Postcode));
  
  }
  public long getPostcodeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_Postcode));
      }

  public void initSecurityId(String value){
     this.initProperty(S_SecurityId,value);
  }
  public  void setSecurityId(String value){
     this.set(S_SecurityId,value);
  }
  public  void setSecurityIdNull(){
     this.set(S_SecurityId,null);
  }

  public String getSecurityId(){
       return DataType.getAsString(this.get(S_SecurityId));
  
  }
  public String getSecurityIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_SecurityId));
      }

  public void initShortName(String value){
     this.initProperty(S_ShortName,value);
  }
  public  void setShortName(String value){
     this.set(S_ShortName,value);
  }
  public  void setShortNameNull(){
     this.set(S_ShortName,null);
  }

  public String getShortName(){
       return DataType.getAsString(this.get(S_ShortName));
  
  }
  public String getShortNameInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ShortName));
      }

  public void initIsAdmin(String value){
     this.initProperty(S_IsAdmin,value);
  }
  public  void setIsAdmin(String value){
     this.set(S_IsAdmin,value);
  }
  public  void setIsAdminNull(){
     this.set(S_IsAdmin,null);
  }

  public String getIsAdmin(){
       return DataType.getAsString(this.get(S_IsAdmin));
  
  }
  public String getIsAdminInitialValue(){
        return DataType.getAsString(this.getOldObj(S_IsAdmin));
      }

  public void initParentStaffId(long value){
     this.initProperty(S_ParentStaffId,new Long(value));
  }
  public  void setParentStaffId(long value){
     this.set(S_ParentStaffId,new Long(value));
  }
  public  void setParentStaffIdNull(){
     this.set(S_ParentStaffId,null);
  }

  public long getParentStaffId(){
        return DataType.getAsLong(this.get(S_ParentStaffId));
  
  }
  public long getParentStaffIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_ParentStaffId));
      }

  public void initContactAddress(String value){
     this.initProperty(S_ContactAddress,value);
  }
  public  void setContactAddress(String value){
     this.set(S_ContactAddress,value);
  }
  public  void setContactAddressNull(){
     this.set(S_ContactAddress,null);
  }

  public String getContactAddress(){
       return DataType.getAsString(this.get(S_ContactAddress));
  
  }
  public String getContactAddressInitialValue(){
        return DataType.getAsString(this.getOldObj(S_ContactAddress));
      }

  public void initBcMgr(String value){
     this.initProperty(S_BcMgr,value);
  }
  public  void setBcMgr(String value){
     this.set(S_BcMgr,value);
  }
  public  void setBcMgrNull(){
     this.set(S_BcMgr,null);
  }

  public String getBcMgr(){
       return DataType.getAsString(this.get(S_BcMgr));
  
  }
  public String getBcMgrInitialValue(){
        return DataType.getAsString(this.getOldObj(S_BcMgr));
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

  public void initCarNo(String value){
     this.initProperty(S_CarNo,value);
  }
  public  void setCarNo(String value){
     this.set(S_CarNo,value);
  }
  public  void setCarNoNull(){
     this.set(S_CarNo,null);
  }

  public String getCarNo(){
       return DataType.getAsString(this.get(S_CarNo));
  
  }
  public String getCarNoInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CarNo));
      }

  public void initAcctEffectDate(Timestamp value){
     this.initProperty(S_AcctEffectDate,value);
  }
  public  void setAcctEffectDate(Timestamp value){
     this.set(S_AcctEffectDate,value);
  }
  public  void setAcctEffectDateNull(){
     this.set(S_AcctEffectDate,null);
  }

  public Timestamp getAcctEffectDate(){
        return DataType.getAsDateTime(this.get(S_AcctEffectDate));
  
  }
  public Timestamp getAcctEffectDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_AcctEffectDate));
      }

  public void initCardNo(String value){
     this.initProperty(S_CardNo,value);
  }
  public  void setCardNo(String value){
     this.set(S_CardNo,value);
  }
  public  void setCardNoNull(){
     this.set(S_CardNo,null);
  }

  public String getCardNo(){
       return DataType.getAsString(this.get(S_CardNo));
  
  }
  public String getCardNoInitialValue(){
        return DataType.getAsString(this.getOldObj(S_CardNo));
      }

  public void initMarryStatus(int value){
     this.initProperty(S_MarryStatus,new Integer(value));
  }
  public  void setMarryStatus(int value){
     this.set(S_MarryStatus,new Integer(value));
  }
  public  void setMarryStatusNull(){
     this.set(S_MarryStatus,null);
  }

  public int getMarryStatus(){
        return DataType.getAsInt(this.get(S_MarryStatus));
  
  }
  public int getMarryStatusInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_MarryStatus));
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

  public void initCardTypeId(int value){
     this.initProperty(S_CardTypeId,new Integer(value));
  }
  public  void setCardTypeId(int value){
     this.set(S_CardTypeId,new Integer(value));
  }
  public  void setCardTypeIdNull(){
     this.set(S_CardTypeId,null);
  }

  public int getCardTypeId(){
        return DataType.getAsInt(this.get(S_CardTypeId));
  
  }
  public int getCardTypeIdInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_CardTypeId));
      }

  public void initDoneCode(long value){
     this.initProperty(S_DoneCode,new Long(value));
  }
  public  void setDoneCode(long value){
     this.set(S_DoneCode,new Long(value));
  }
  public  void setDoneCodeNull(){
     this.set(S_DoneCode,null);
  }

  public long getDoneCode(){
        return DataType.getAsLong(this.get(S_DoneCode));
  
  }
  public long getDoneCodeInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_DoneCode));
      }

  public void initFaxId(String value){
     this.initProperty(S_FaxId,value);
  }
  public  void setFaxId(String value){
     this.set(S_FaxId,value);
  }
  public  void setFaxIdNull(){
     this.set(S_FaxId,null);
  }

  public String getFaxId(){
       return DataType.getAsString(this.get(S_FaxId));
  
  }
  public String getFaxIdInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FaxId));
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

  public void initLoginChannel(int value){
     this.initProperty(S_LoginChannel,new Integer(value));
  }
  public  void setLoginChannel(int value){
     this.set(S_LoginChannel,new Integer(value));
  }
  public  void setLoginChannelNull(){
     this.set(S_LoginChannel,null);
  }

  public int getLoginChannel(){
        return DataType.getAsInt(this.get(S_LoginChannel));
  
  }
  public int getLoginChannelInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_LoginChannel));
      }

  public void initRecentPassword(String value){
     this.initProperty(S_RecentPassword,value);
  }
  public  void setRecentPassword(String value){
     this.set(S_RecentPassword,value);
  }
  public  void setRecentPasswordNull(){
     this.set(S_RecentPassword,null);
  }

  public String getRecentPassword(){
       return DataType.getAsString(this.get(S_RecentPassword));
  
  }
  public String getRecentPasswordInitialValue(){
        return DataType.getAsString(this.getOldObj(S_RecentPassword));
      }

  public void initJobCompany(String value){
     this.initProperty(S_JobCompany,value);
  }
  public  void setJobCompany(String value){
     this.set(S_JobCompany,value);
  }
  public  void setJobCompanyNull(){
     this.set(S_JobCompany,null);
  }

  public String getJobCompany(){
       return DataType.getAsString(this.get(S_JobCompany));
  
  }
  public String getJobCompanyInitialValue(){
        return DataType.getAsString(this.getOldObj(S_JobCompany));
      }

  public void initChgPasswdFlag(int value){
     this.initProperty(S_ChgPasswdFlag,new Integer(value));
  }
  public  void setChgPasswdFlag(int value){
     this.set(S_ChgPasswdFlag,new Integer(value));
  }
  public  void setChgPasswdFlagNull(){
     this.set(S_ChgPasswdFlag,null);
  }

  public int getChgPasswdFlag(){
        return DataType.getAsInt(this.get(S_ChgPasswdFlag));
  
  }
  public int getChgPasswdFlagInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_ChgPasswdFlag));
      }

  public void initFamilyInfo(String value){
     this.initProperty(S_FamilyInfo,value);
  }
  public  void setFamilyInfo(String value){
     this.set(S_FamilyInfo,value);
  }
  public  void setFamilyInfoNull(){
     this.set(S_FamilyInfo,null);
  }

  public String getFamilyInfo(){
       return DataType.getAsString(this.get(S_FamilyInfo));
  
  }
  public String getFamilyInfoInitialValue(){
        return DataType.getAsString(this.getOldObj(S_FamilyInfo));
      }

  public void initJobPosition(String value){
     this.initProperty(S_JobPosition,value);
  }
  public  void setJobPosition(String value){
     this.set(S_JobPosition,value);
  }
  public  void setJobPositionNull(){
     this.set(S_JobPosition,null);
  }

  public String getJobPosition(){
       return DataType.getAsString(this.get(S_JobPosition));
  
  }
  public String getJobPositionInitialValue(){
        return DataType.getAsString(this.getOldObj(S_JobPosition));
      }

  public void initOrgId(long value){
     this.initProperty(S_OrgId,new Long(value));
  }
  public  void setOrgId(long value){
     this.set(S_OrgId,new Long(value));
  }
  public  void setOrgIdNull(){
     this.set(S_OrgId,null);
  }

  public long getOrgId(){
        return DataType.getAsLong(this.get(S_OrgId));
  
  }
  public long getOrgIdInitialValue(){
        return DataType.getAsLong(this.getOldObj(S_OrgId));
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

  public void initRecentPassTimes(int value){
     this.initProperty(S_RecentPassTimes,new Integer(value));
  }
  public  void setRecentPassTimes(int value){
     this.set(S_RecentPassTimes,new Integer(value));
  }
  public  void setRecentPassTimesNull(){
     this.set(S_RecentPassTimes,null);
  }

  public int getRecentPassTimes(){
        return DataType.getAsInt(this.get(S_RecentPassTimes));
  
  }
  public int getRecentPassTimesInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_RecentPassTimes));
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

  public void initJobDesc(String value){
     this.initProperty(S_JobDesc,value);
  }
  public  void setJobDesc(String value){
     this.set(S_JobDesc,value);
  }
  public  void setJobDescNull(){
     this.set(S_JobDesc,null);
  }

  public String getJobDesc(){
       return DataType.getAsString(this.get(S_JobDesc));
  
  }
  public String getJobDescInitialValue(){
        return DataType.getAsString(this.getOldObj(S_JobDesc));
      }

  public void initReligion(int value){
     this.initProperty(S_Religion,new Integer(value));
  }
  public  void setReligion(int value){
     this.set(S_Religion,new Integer(value));
  }
  public  void setReligionNull(){
     this.set(S_Religion,null);
  }

  public int getReligion(){
        return DataType.getAsInt(this.get(S_Religion));
  
  }
  public int getReligionInitialValue(){
        return DataType.getAsInt(this.getOldObj(S_Religion));
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

  public void initAcctExpireDate(Timestamp value){
     this.initProperty(S_AcctExpireDate,value);
  }
  public  void setAcctExpireDate(Timestamp value){
     this.set(S_AcctExpireDate,value);
  }
  public  void setAcctExpireDateNull(){
     this.set(S_AcctExpireDate,null);
  }

  public Timestamp getAcctExpireDate(){
        return DataType.getAsDateTime(this.get(S_AcctExpireDate));
  
  }
  public Timestamp getAcctExpireDateInitialValue(){
        return DataType.getAsDateTime(this.getOldObj(S_AcctExpireDate));
      }


 
 }

