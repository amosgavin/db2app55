package com.asiainfo.crm.exercise.staff.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOStaffValue extends DataStructInterface{

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


public String getState();

public String getIsLogin();

public int getStaffId();

public long getLastLoginLogId();

public int getStaffTypeId();

public String getRemarks();

public Timestamp getCreateDate();

public String getCertifiCode();

public String getEmail();

public String getOfficeTel();

public String getCheckFlag();

public int getOrganizeId();

public String getHomeTel();

public String getLockFlag();

public String getIsAllRecord();

public String getMultiLoginFlag();

public String getMobileTele();

public String getAddrId();

public int getCertifiTypeId();

public String getPassword();

public long getTryTimes();

public int getReportToStaffId();

public Timestamp getExpireDate();

public int getEducationTypeId();

public String getCode();

public String getName();

public Timestamp getEffectDate();

public int getWorkTypeId();

public String getAllowChangePassword();


public  void setState(String value);

public  void setIsLogin(String value);

public  void setStaffId(int value);

public  void setLastLoginLogId(long value);

public  void setStaffTypeId(int value);

public  void setRemarks(String value);

public  void setCreateDate(Timestamp value);

public  void setCertifiCode(String value);

public  void setEmail(String value);

public  void setOfficeTel(String value);

public  void setCheckFlag(String value);

public  void setOrganizeId(int value);

public  void setHomeTel(String value);

public  void setLockFlag(String value);

public  void setIsAllRecord(String value);

public  void setMultiLoginFlag(String value);

public  void setMobileTele(String value);

public  void setAddrId(String value);

public  void setCertifiTypeId(int value);

public  void setPassword(String value);

public  void setTryTimes(long value);

public  void setReportToStaffId(int value);

public  void setExpireDate(Timestamp value);

public  void setEducationTypeId(int value);

public  void setCode(String value);

public  void setName(String value);

public  void setEffectDate(Timestamp value);

public  void setWorkTypeId(int value);

public  void setAllowChangePassword(String value);
}
