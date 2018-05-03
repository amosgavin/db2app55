package com.ai.bce.auto.plugin.version.hand.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceVerHandValue extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_PubilshState = "PUBILSH_STATE";
  public final static  String S_VersionName = "VERSION_NAME";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_CreatDate = "CREAT_DATE";
  public final static  String S_ApplyUser = "APPLY_USER";
  public final static  String S_VersionId = "VERSION_ID";
  public final static  String S_VersionDesc = "VERSION_DESC";


public long getVersionId();

public String getVersionName();

public String getVersionDesc();

public int getState();

public String getPubilshState();

public Timestamp getCreatDate();

public String getApplyUser();

public String getRemarks();


public  void setVersionId(long value);

public  void setVersionName(String value);

public  void setVersionDesc(String value);

public  void setState(int value);

public  void setPubilshState(String value);

public  void setCreatDate(Timestamp value);

public  void setApplyUser(String value);

public  void setRemarks(String value);
}
