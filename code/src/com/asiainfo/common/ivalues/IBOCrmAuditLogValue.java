package com.asiainfo.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOCrmAuditLogValue extends DataStructInterface{

  public final static  String S_BossCode = "BOSS_CODE";
  public final static  String S_Content = "CONTENT";
  public final static  String S_AuditFlag = "AUDIT_FLAG";
  public final static  String S_ModeId = "MODE_ID";
  public final static  String S_InterfaceId = "INTERFACE_ID";
  public final static  String S_AuditDate = "AUDIT_DATE";
  public final static  String S_Id = "ID";


public String getBossCode();

public String getContent();

public String getAuditFlag();

public String getModeId();

public String getInterfaceId();

public Timestamp getAuditDate();

public int getId();


public  void setBossCode(String value);

public  void setContent(String value);

public  void setAuditFlag(String value);

public  void setModeId(String value);

public  void setInterfaceId(String value);

public  void setAuditDate(Timestamp value);

public  void setId(int value);
}
