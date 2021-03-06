package com.asiainfo.sale.access.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOBusiChangeValue extends DataStructInterface{

  public final static  String S_ApplyName = "APPLY_NAME";
  public final static  String S_Remark1 = "REMARK1";
  public final static  String S_Remark2 = "REMARK2";
  public final static  String S_State = "STATE";
  public final static  String S_Remark3 = "REMARK3";
  public final static  String S_Remark4 = "REMARK4";
  public final static  String S_Description = "DESCRIPTION";
  public final static  String S_OrgName = "ORG_NAME";
  public final static  String S_PropTime = "PROP_TIME";
  public final static  String S_Principle = "PRINCIPLE";
  public final static  String S_PropStaff = "PROP_STAFF";
  public final static  String S_Tel = "TEL";
  public final static  String S_BusiId = "BUSI_ID";
  public final static  String S_Org = "ORG";
public  void setIsDelete(String value);
public void unDelete();
public String getApplyName();

public String getRemark1();

public String getRemark2();

public String getState();

public String getRemark3();

public String getRemark4();

public String getDescription();

public String getOrgName();

public Timestamp getPropTime();

public String getPrinciple();

public String getPropStaff();

public String getTel();

public int getBusiId();

public String getOrg();


public  void setApplyName(String value);

public  void setRemark1(String value);

public  void setRemark2(String value);

public  void setState(String value);

public  void setRemark3(String value);

public  void setRemark4(String value);

public  void setDescription(String value);

public  void setOrgName(String value);

public  void setPropTime(Timestamp value);

public  void setPrinciple(String value);

public  void setPropStaff(String value);

public  void setTel(String value);

public  void setBusiId(int value);

public  void setOrg(String value);
}
