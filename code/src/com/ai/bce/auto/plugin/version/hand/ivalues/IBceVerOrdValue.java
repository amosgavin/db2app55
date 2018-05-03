package com.ai.bce.auto.plugin.version.hand.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceVerOrdValue extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_PubilshState = "PUBILSH_STATE";
  public final static  String S_OrdUser = "ORD_USER";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_CreatDate = "CREAT_DATE";
  public final static  String S_OrdUseId = "ORD_USE_ID";
  public final static  String S_ApplyUser = "APPLY_USER";
  public final static  String S_VersionId = "VERSION_ID";
  public final static  String S_OrdId = "ORD_ID";
  public final static  String S_OrdName = "ORD_NAME";


public int getState();

public String getPubilshState();

public long getOrdUser();

public String getRemarks();

public Timestamp getCreatDate();

public String getOrdUseId();

public String getApplyUser();

public long getVersionId();

public long getOrdId();

public String getOrdName();


public  void setState(int value);

public  void setPubilshState(String value);

public  void setOrdUser(long value);

public  void setRemarks(String value);

public  void setCreatDate(Timestamp value);

public  void setOrdUseId(String value);

public  void setApplyUser(String value);

public  void setVersionId(long value);

public  void setOrdId(long value);

public  void setOrdName(String value);
}
