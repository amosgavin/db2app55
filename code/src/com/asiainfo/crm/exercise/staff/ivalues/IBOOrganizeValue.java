package com.asiainfo.crm.exercise.staff.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOOrganizeValue extends DataStructInterface{

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


public String getState();

public int getDistrictId();

public String getContactTel();

public int getOrganizeId();

public int getManageStaffId();

public int getParentOrganizeId();

public String getRemarks();

public String getName();

public String getFax();

public String getContact();

public int getOrganizeTypeId();

public String getEmail();


public  void setState(String value);

public  void setDistrictId(int value);

public  void setContactTel(String value);

public  void setOrganizeId(int value);

public  void setManageStaffId(int value);

public  void setParentOrganizeId(int value);

public  void setRemarks(String value);

public  void setName(String value);

public  void setFax(String value);

public  void setContact(String value);

public  void setOrganizeTypeId(int value);

public  void setEmail(String value);
}
