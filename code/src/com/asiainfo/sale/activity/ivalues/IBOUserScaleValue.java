package com.asiainfo.sale.activity.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOUserScaleValue extends DataStructInterface{

  public final static  String S_StartTime = "START_TIME";
  public final static  String S_EndTime = "END_TIME";
  public final static  String S_MaxUsers = "MAX_USERS";
  public final static  String S_Id = "ID";
  public final static  String S_RelId = "REL_ID";
  public final static  String S_PreUsers = "PRE_USERS";
  public final static  String S_Region = "REGION";
  public final static  String S_InfoType = "INFO_TYPE";


public Timestamp getStartTime();

public Timestamp getEndTime();

public long getMaxUsers();

public long getId();

public long getRelId();

public long getPreUsers();

public String getRegion();

public String getInfoType();


public  void setStartTime(Timestamp value);

public  void setEndTime(Timestamp value);

public  void setMaxUsers(long value);

public  void setId(long value);

public  void setRelId(long value);

public  void setPreUsers(long value);

public  void setRegion(String value);

public  void setInfoType(String value);
}
