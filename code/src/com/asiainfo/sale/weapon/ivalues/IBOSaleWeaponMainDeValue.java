package com.asiainfo.sale.weapon.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOSaleWeaponMainDeValue extends DataStructInterface{

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


public String getApplyName();

public String getApplicant();

public String getOrganizeName();

public Timestamp getConfigTime();

public String getWid();

public Timestamp getModifyTime();

public Timestamp getCreateTime();

public String getRemark();

public String getPrincipal();

public String getId();

public String getStaffName();

public String getOrg();

public String getPromoteDepart();


public  void setApplyName(String value);

public  void setApplicant(String value);

public  void setOrganizeName(String value);

public  void setConfigTime(Timestamp value);

public  void setWid(String value);

public  void setModifyTime(Timestamp value);

public  void setCreateTime(Timestamp value);

public  void setRemark(String value);

public  void setPrincipal(String value);

public  void setId(String value);

public  void setStaffName(String value);

public  void setOrg(String value);

public  void setPromoteDepart(String value);
}
