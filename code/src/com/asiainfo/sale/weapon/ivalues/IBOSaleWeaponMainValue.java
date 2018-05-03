package com.asiainfo.sale.weapon.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOSaleWeaponMainValue extends DataStructInterface{

  public final static  String S_ApplyName = "APPLY_NAME";
  public final static  String S_Applicant = "APPLICANT";
  public final static  String S_Wid = "WID";
  public final static  String S_ConfigTime = "CONFIG_TIME";
  public final static  String S_ModifyTime = "MODIFY_TIME";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_Id = "ID";
  public final static  String S_Remark = "REMARK";
  public final static  String S_Principal = "PRINCIPAL";
  public final static  String S_PromoteDepart = "PROMOTE_DEPART";
  public final static  String S_Org = "ORG";


public String getApplyName();

public String getApplicant();

public String getWid();

public Timestamp getConfigTime();

public Timestamp getModifyTime();

public Timestamp getCreateTime();

public String getId();

public String getRemark();

public String getPrincipal();

public String getPromoteDepart();

public String getOrg();


public  void setApplyName(String value);

public  void setApplicant(String value);

public  void setWid(String value);

public  void setConfigTime(Timestamp value);

public  void setModifyTime(Timestamp value);

public  void setCreateTime(Timestamp value);

public  void setId(String value);

public  void setRemark(String value);

public  void setPrincipal(String value);

public  void setPromoteDepart(String value);

public  void setOrg(String value);
}
