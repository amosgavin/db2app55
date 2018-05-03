package com.asiainfo.sale.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOStaffSmsInfoValue extends DataStructInterface{

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


public int getTryTimes();

public long getLastLoginLogId();

public int getEducationLevel();

public String getIpmacFlag();

public String getCharacterDesc();

public long getIncomeLevel();

public String getAlarmBillId();

public Timestamp getValidDate();

public long getChgPasswdAlarmDays();

public String getEnglishName();

public String getCode();

public Timestamp getExpireDate();

public long getOpId();

public String getAllowChangePassword();

public int getStaffLevel();

public String getIsLogin();

public String getOfficeTel();

public int getCancelDays();

public String getWirelessCall();

public Timestamp getDoneDate();

public Timestamp getCreateDate();

public String getOrganizeId();

public int getStaffType();

public int getPoliticsFace();

public int getNationalType();

public Timestamp getPasswordValidDate();

public int getState();

public long getIsVpnLoginFlag();

public long getOperatorId();

public long getPostcode();

public String getSecurityId();

public String getShortName();

public String getIsAdmin();

public long getParentStaffId();

public String getContactAddress();

public String getBcMgr();

public String getHomeTel();

public String getCarNo();

public Timestamp getAcctEffectDate();

public String getCardNo();

public int getMarryStatus();

public String getStaffName();

public String getEmail();

public int getCardTypeId();

public long getDoneCode();

public String getFaxId();

public String getPassword();

public String getNotes();

public Timestamp getBirthday();

public int getLoginChannel();

public String getRecentPassword();

public String getJobCompany();

public int getChgPasswdFlag();

public String getFamilyInfo();

public String getJobPosition();

public long getOrgId();

public long getStaffId();

public int getRecentPassTimes();

public int getGender();

public String getJobDesc();

public int getReligion();

public String getLockFlag();

public String getBillId();

public Timestamp getAcctExpireDate();


public  void setTryTimes(int value);

public  void setLastLoginLogId(long value);

public  void setEducationLevel(int value);

public  void setIpmacFlag(String value);

public  void setCharacterDesc(String value);

public  void setIncomeLevel(long value);

public  void setAlarmBillId(String value);

public  void setValidDate(Timestamp value);

public  void setChgPasswdAlarmDays(long value);

public  void setEnglishName(String value);

public  void setCode(String value);

public  void setExpireDate(Timestamp value);

public  void setOpId(long value);

public  void setAllowChangePassword(String value);

public  void setStaffLevel(int value);

public  void setIsLogin(String value);

public  void setOfficeTel(String value);

public  void setCancelDays(int value);

public  void setWirelessCall(String value);

public  void setDoneDate(Timestamp value);

public  void setCreateDate(Timestamp value);

public  void setOrganizeId(String value);

public  void setStaffType(int value);

public  void setPoliticsFace(int value);

public  void setNationalType(int value);

public  void setPasswordValidDate(Timestamp value);

public  void setState(int value);

public  void setIsVpnLoginFlag(long value);

public  void setOperatorId(long value);

public  void setPostcode(long value);

public  void setSecurityId(String value);

public  void setShortName(String value);

public  void setIsAdmin(String value);

public  void setParentStaffId(long value);

public  void setContactAddress(String value);

public  void setBcMgr(String value);

public  void setHomeTel(String value);

public  void setCarNo(String value);

public  void setAcctEffectDate(Timestamp value);

public  void setCardNo(String value);

public  void setMarryStatus(int value);

public  void setStaffName(String value);

public  void setEmail(String value);

public  void setCardTypeId(int value);

public  void setDoneCode(long value);

public  void setFaxId(String value);

public  void setPassword(String value);

public  void setNotes(String value);

public  void setBirthday(Timestamp value);

public  void setLoginChannel(int value);

public  void setRecentPassword(String value);

public  void setJobCompany(String value);

public  void setChgPasswdFlag(int value);

public  void setFamilyInfo(String value);

public  void setJobPosition(String value);

public  void setOrgId(long value);

public  void setStaffId(long value);

public  void setRecentPassTimes(int value);

public  void setGender(int value);

public  void setJobDesc(String value);

public  void setReligion(int value);

public  void setLockFlag(String value);

public  void setBillId(String value);

public  void setAcctExpireDate(Timestamp value);
}
