package com.asiainfo.sale.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOAppriseMarkValue extends DataStructInterface{

  public final static  String S_OrganizeName = "ORGANIZE_NAME";
  public final static  String S_DealTime = "DEAL_TIME";
  public final static  String S_SendTime = "SEND_TIME";
  public final static  String S_StaffName = "STAFF_NAME";
  public final static  String S_ReadTime = "READ_TIME";
  public final static  String S_IsReaded = "IS_READED";
  public final static  String S_AppriseFlag = "APPRISE_FLAG";
  public final static  String S_Depart = "DEPART";
  public final static  String S_OrganizeId = "ORGANIZE_ID";


public String getOrganizeName();

public Timestamp getDealTime();

public Timestamp getSendTime();

public String getStaffName();

public Timestamp getReadTime();

public String getIsReaded();

public String getAppriseFlag();

public String getDepart();

public String getOrganizeId();


public  void setOrganizeName(String value);

public  void setDealTime(Timestamp value);

public  void setSendTime(Timestamp value);

public  void setStaffName(String value);

public  void setReadTime(Timestamp value);

public  void setIsReaded(String value);

public  void setAppriseFlag(String value);

public  void setDepart(String value);

public  void setOrganizeId(String value);
}
