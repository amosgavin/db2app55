package com.asiainfo.sale.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOProxyShowValue extends DataStructInterface{

  public final static  String S_ProxyDate = "PROXY_DATE";
  public final static  String S_State = "STATE";
  public final static  String S_AuthorOrganizeNameP = "AUTHOR_ORGANIZE_NAME_P";
  public final static  String S_ModifyTime = "MODIFY_TIME";
  public final static  String S_CreateStaffId = "CREATE_STAFF_ID";
  public final static  String S_Remark = "REMARK";
  public final static  String S_ProxyStaffId = "PROXY_STAFF_ID";
  public final static  String S_MFlag = "M_FLAG";
  public final static  String S_ProxyName = "PROXY_NAME";
  public final static  String S_ProxyOrganizeName = "PROXY_ORGANIZE_NAME";
  public final static  String S_AuthorStaffId = "AUTHOR_STAFF_ID";
  public final static  String S_AuthorName = "AUTHOR_NAME";
  public final static  String S_Id = "ID";
  public final static  String S_ProxyOrganizeNameP = "PROXY_ORGANIZE_NAME_P";
  public final static  String S_AuthorOrganizeName = "AUTHOR_ORGANIZE_NAME";
  public final static  String S_ParentId = "PARENT_ID";


public Timestamp getProxyDate();

public String getState();

public String getAuthorOrganizeNameP();

public Timestamp getModifyTime();

public String getCreateStaffId();

public String getRemark();

public String getProxyStaffId();

public String getMFlag();

public String getProxyName();

public String getProxyOrganizeName();

public String getAuthorStaffId();

public String getAuthorName();

public long getId();

public String getProxyOrganizeNameP();

public String getAuthorOrganizeName();

public long getParentId();


public  void setProxyDate(Timestamp value);

public  void setState(String value);

public  void setAuthorOrganizeNameP(String value);

public  void setModifyTime(Timestamp value);

public  void setCreateStaffId(String value);

public  void setRemark(String value);

public  void setProxyStaffId(String value);

public  void setMFlag(String value);

public  void setProxyName(String value);

public  void setProxyOrganizeName(String value);

public  void setAuthorStaffId(String value);

public  void setAuthorName(String value);

public  void setId(long value);

public  void setProxyOrganizeNameP(String value);

public  void setAuthorOrganizeName(String value);

public  void setParentId(long value);
}
