package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBcePageFramePageValue extends DataStructInterface{

  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_PageId = "PAGE_ID";
  public final static  String S_IsDisplay = "IS_DISPLAY";
  public final static  String S_PageFramePageId = "PAGE_FRAME_PAGE_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_PageTitle = "PAGE_TITLE";
  public final static  String S_PageFrameId = "PAGE_FRAME_ID";
  public final static  String S_Height = "HEIGHT";
  public final static  String S_SeqNo = "SEQ_NO";


public long getModuleId();

public int getState();

public long getPageId();

public int getIsDisplay();

public long getPageFramePageId();

public String getRemarks();

public String getPageTitle();

public long getPageFrameId();

public String getHeight();

public int getSeqNo();


public  void setModuleId(long value);

public  void setState(int value);

public  void setPageId(long value);

public  void setIsDisplay(int value);

public  void setPageFramePageId(long value);

public  void setRemarks(String value);

public  void setPageTitle(String value);

public  void setPageFrameId(long value);

public  void setHeight(String value);

public  void setSeqNo(int value);
}
