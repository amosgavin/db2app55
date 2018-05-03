package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceWarnValue extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_WarnName = "WARN_NAME";
  public final static  String S_WarnContent = "WARN_CONTENT";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_WarnId = "WARN_ID";
  public final static  String S_WarnParams = "WARN_PARAMS";
  public final static  String S_FilePath = "FILE_PATH";
  public final static  String S_WarnType = "WARN_TYPE";


public int getState();

public String getWarnName();

public String getWarnContent();

public String getRemarks();

public long getWarnId();

public String getWarnParams();

public String getFilePath();

public int getWarnType();


public  void setState(int value);

public  void setWarnName(String value);

public  void setWarnContent(String value);

public  void setRemarks(String value);

public  void setWarnId(long value);

public  void setWarnParams(String value);

public  void setFilePath(String value);

public  void setWarnType(int value);
}
