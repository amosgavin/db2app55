package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IQBOBcePagePageFrameValue extends DataStructInterface{

  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_FrameType = "FRAME_TYPE";
  public final static  String S_State = "STATE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_PageFrameId = "PAGE_FRAME_ID";
  public final static  String S_PageFrameName = "PAGE_FRAME_NAME";


public long getModuleId();

public long getFrameType();

public long getState();

public String getRemarks();

public long getPageFrameId();

public String getPageFrameName();


public  void setModuleId(long value);

public  void setFrameType(long value);

public  void setState(long value);

public  void setRemarks(String value);

public  void setPageFrameId(long value);

public  void setPageFrameName(String value);
}
