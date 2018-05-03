package com.asiainfo.sale.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOProxyValue extends DataStructInterface{

  public final static  String S_ProxyDate = "PROXY_DATE";
  public final static  String S_State = "STATE";
  public final static  String S_ModifyTime = "MODIFY_TIME";
  public final static  String S_AuthorStaffId = "AUTHOR_STAFF_ID";
  public final static  String S_Id = "ID";
  public final static  String S_CreateStaffId = "CREATE_STAFF_ID";
  public final static  String S_Remark = "REMARK";
  public final static  String S_ProxyStaffId = "PROXY_STAFF_ID";
  public final static  String S_ParentId = "PARENT_ID";
  public final static  String S_MFlag = "M_FLAG";


public Timestamp getProxyDate();

public String getState();

public Timestamp getModifyTime();

public String getAuthorStaffId();

public long getId();

public String getCreateStaffId();

public String getRemark();

public String getProxyStaffId();

public long getParentId();

public String getMFlag();


public  void setProxyDate(Timestamp value);

public  void setState(String value);

public  void setModifyTime(Timestamp value);

public  void setAuthorStaffId(String value);

public  void setId(long value);

public  void setCreateStaffId(String value);

public  void setRemark(String value);

public  void setProxyStaffId(String value);

public  void setParentId(long value);

public  void setMFlag(String value);
}
