package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBcePageRowsetRelValue extends DataStructInterface{

  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_PageFramePageId = "PAGE_FRAME_PAGE_ID";
  public final static  String S_RowsetId = "ROWSET_ID";

  public  Long  getModuleIdAsLong();

public long getModuleId();


  public  Integer  getStateAsInteger();

public int getState();


  public  Long  getPageFramePageIdAsLong();

public long getPageFramePageId();


  public  Long  getRowsetIdAsLong();

public long getRowsetId();




  public  void setModuleId(Long value);

public  void setModuleId(long value);



  public  void setState(Integer value);

public  void setState(int value);



  public  void setPageFramePageId(Long value);

public  void setPageFramePageId(long value);



  public  void setRowsetId(Long value);

public  void setRowsetId(long value);


}
