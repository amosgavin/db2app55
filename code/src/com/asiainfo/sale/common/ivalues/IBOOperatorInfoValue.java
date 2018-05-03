package com.asiainfo.sale.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOOperatorInfoValue extends DataStructInterface{

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


public Timestamp getBirthday();

public int getState();

public String getOrganizeName();

public long getOperatorId();

public long getStaffId();

public long getOrganizeIdP();

public int getGender();

public int getOpstate();

public String getStaffName();

public String getBillId();

public String getEmail();

public String getOrganizeNameP();

public String getOrgCode();

public String getNotes();

public long getOrganizeId();

public String getCode();


public  void setBirthday(Timestamp value);

public  void setState(int value);

public  void setOrganizeName(String value);

public  void setOperatorId(long value);

public  void setStaffId(long value);

public  void setOrganizeIdP(long value);

public  void setGender(int value);

public  void setOpstate(int value);

public  void setStaffName(String value);

public  void setBillId(String value);

public  void setEmail(String value);

public  void setOrganizeNameP(String value);

public  void setOrgCode(String value);

public  void setNotes(String value);

public  void setOrganizeId(long value);

public  void setCode(String value);
}
