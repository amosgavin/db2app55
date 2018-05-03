package com.asiainfo.sale.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOWFOperatorValue extends DataStructInterface{

  public final static  String S_EducationLevel = "EDUCATION_LEVEL";
  public final static  String S_CharacterDesc = "CHARACTER_DESC";
  public final static  String S_IncomeLevel = "INCOME_LEVEL";
  public final static  String S_RoleId = "ROLE_ID";
  public final static  String S_AlarmBillId = "ALARM_BILL_ID";
  public final static  String S_ValidDate = "VALID_DATE";
  public final static  String S_EnglishName = "ENGLISH_NAME";
  public final static  String S_Code = "CODE";
  public final static  String S_ExpireDate = "EXPIRE_DATE";
  public final static  String S_OpId = "OP_ID";
  public final static  String S_OrganizeName = "ORGANIZE_NAME";
  public final static  String S_StaffLevel = "STAFF_LEVEL";
  public final static  String S_OfficeTel = "OFFICE_TEL";
  public final static  String S_WirelessCall = "WIRELESS_CALL";
  public final static  String S_DoneDate = "DONE_DATE";
  public final static  String S_OrganizeNameP = "ORGANIZE_NAME_P";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_OrganizeId = "ORGANIZE_ID";
  public final static  String S_NationalType = "NATIONAL_TYPE";
  public final static  String S_PoliticsFace = "POLITICS_FACE";
  public final static  String S_StaffType = "STAFF_TYPE";
  public final static  String S_State = "STATE";
  public final static  String S_OperatorId = "OPERATOR_ID";
  public final static  String S_Postcode = "POSTCODE";
  public final static  String S_SecurityId = "SECURITY_ID";
  public final static  String S_ShortName = "SHORT_NAME";
  public final static  String S_ParentStaffId = "PARENT_STAFF_ID";
  public final static  String S_HomeTel = "HOME_TEL";
  public final static  String S_BcMgr = "BC_MGR";
  public final static  String S_ContactAddress = "CONTACT_ADDRESS";
  public final static  String S_CarNo = "CAR_NO";
  public final static  String S_CardNo = "CARD_NO";
  public final static  String S_MarryStatus = "MARRY_STATUS";
  public final static  String S_StaffName = "STAFF_NAME";
  public final static  String S_Email = "EMAIL";
  public final static  String S_CardTypeId = "CARD_TYPE_ID";
  public final static  String S_DoneCode = "DONE_CODE";
  public final static  String S_FaxId = "FAX_ID";
  public final static  String S_Notes = "NOTES";
  public final static  String S_Birthday = "BIRTHDAY";
  public final static  String S_JobCompany = "JOB_COMPANY";
  public final static  String S_FamilyInfo = "FAMILY_INFO";
  public final static  String S_JobPosition = "JOB_POSITION";
  public final static  String S_OrgId = "ORG_ID";
  public final static  String S_StaffId = "STAFF_ID";
  public final static  String S_OrganizeIdP = "ORGANIZE_ID_P";
  public final static  String S_JobDesc = "JOB_DESC";
  public final static  String S_Gender = "GENDER";
  public final static  String S_Religion = "RELIGION";
  public final static  String S_BillId = "BILL_ID";


public int getEducationLevel();

public String getCharacterDesc();

public long getIncomeLevel();

public long getRoleId();

public String getAlarmBillId();

public Timestamp getValidDate();

public String getEnglishName();

public String getCode();

public Timestamp getExpireDate();

public long getOpId();

public String getOrganizeName();

public int getStaffLevel();

public String getOfficeTel();

public String getWirelessCall();

public Timestamp getDoneDate();

public String getOrganizeNameP();

public Timestamp getCreateDate();

public String getOrganizeId();

public int getNationalType();

public int getPoliticsFace();

public int getStaffType();

public int getState();

public long getOperatorId();

public long getPostcode();

public String getSecurityId();

public String getShortName();

public long getParentStaffId();

public String getHomeTel();

public String getBcMgr();

public String getContactAddress();

public String getCarNo();

public String getCardNo();

public int getMarryStatus();

public String getStaffName();

public String getEmail();

public int getCardTypeId();

public long getDoneCode();

public String getFaxId();

public String getNotes();

public Timestamp getBirthday();

public String getJobCompany();

public String getFamilyInfo();

public String getJobPosition();

public long getOrgId();

public long getStaffId();

public long getOrganizeIdP();

public String getJobDesc();

public int getGender();

public int getReligion();

public String getBillId();


public  void setEducationLevel(int value);

public  void setCharacterDesc(String value);

public  void setIncomeLevel(long value);

public  void setRoleId(long value);

public  void setAlarmBillId(String value);

public  void setValidDate(Timestamp value);

public  void setEnglishName(String value);

public  void setCode(String value);

public  void setExpireDate(Timestamp value);

public  void setOpId(long value);

public  void setOrganizeName(String value);

public  void setStaffLevel(int value);

public  void setOfficeTel(String value);

public  void setWirelessCall(String value);

public  void setDoneDate(Timestamp value);

public  void setOrganizeNameP(String value);

public  void setCreateDate(Timestamp value);

public  void setOrganizeId(String value);

public  void setNationalType(int value);

public  void setPoliticsFace(int value);

public  void setStaffType(int value);

public  void setState(int value);

public  void setOperatorId(long value);

public  void setPostcode(long value);

public  void setSecurityId(String value);

public  void setShortName(String value);

public  void setParentStaffId(long value);

public  void setHomeTel(String value);

public  void setBcMgr(String value);

public  void setContactAddress(String value);

public  void setCarNo(String value);

public  void setCardNo(String value);

public  void setMarryStatus(int value);

public  void setStaffName(String value);

public  void setEmail(String value);

public  void setCardTypeId(int value);

public  void setDoneCode(long value);

public  void setFaxId(String value);

public  void setNotes(String value);

public  void setBirthday(Timestamp value);

public  void setJobCompany(String value);

public  void setFamilyInfo(String value);

public  void setJobPosition(String value);

public  void setOrgId(long value);

public  void setStaffId(long value);

public  void setOrganizeIdP(long value);

public  void setJobDesc(String value);

public  void setGender(int value);

public  void setReligion(int value);

public  void setBillId(String value);
}
