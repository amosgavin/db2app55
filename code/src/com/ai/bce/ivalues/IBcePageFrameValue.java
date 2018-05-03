package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBcePageFrameValue extends DataStructInterface{

  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_PageFrameId = "PAGE_FRAME_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_FrameType = "FRAME_TYPE";
  public final static  String S_PageFrameName = "PAGE_FRAME_NAME";

  public  Long  getModuleIdAsLong();

public long getModuleId();


  public  Integer  getStateAsInteger();

public int getState();


  public  Long  getPageFrameIdAsLong();

public long getPageFrameId();



public String getRemarks();


  public  Integer  getFrameTypeAsInteger();

public int getFrameType();



public String getPageFrameName();




  public  void setModuleId(Long value);

public  void setModuleId(long value);



  public  void setState(Integer value);

public  void setState(int value);



  public  void setPageFrameId(Long value);

public  void setPageFrameId(long value);




public  void setRemarks(String value);



  public  void setFrameType(Integer value);

public  void setFrameType(int value);




public  void setPageFrameName(String value);


}
