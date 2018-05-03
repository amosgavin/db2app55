package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceFramePageRoleValue extends DataStructInterface{

  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_MaxNum = "MAX_NUM";
  public final static  String S_RoleId = "ROLE_ID";
  public final static  String S_BceFrameId = "BCE_FRAME_ID";
  public final static  String S_PageFramePageId = "PAGE_FRAME_PAGE_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_SeqNo = "SEQ_NO";

  public  Long  getModuleIdAsLong();

public long getModuleId();


  public  Integer  getStateAsInteger();

public int getState();


  public  Integer  getMaxNumAsInteger();

public int getMaxNum();


  public  Long  getRoleIdAsLong();

public long getRoleId();


  public  Long  getBceFrameIdAsLong();

public long getBceFrameId();


  public  Long  getPageFramePageIdAsLong();

public long getPageFramePageId();



public String getRemarks();


  public  Integer  getSeqNoAsInteger();

public int getSeqNo();




  public  void setModuleId(Long value);

public  void setModuleId(long value);



  public  void setState(Integer value);

public  void setState(int value);



  public  void setMaxNum(Integer value);

public  void setMaxNum(int value);



  public  void setRoleId(Long value);

public  void setRoleId(long value);



  public  void setBceFrameId(Long value);

public  void setBceFrameId(long value);



  public  void setPageFramePageId(Long value);

public  void setPageFramePageId(long value);




public  void setRemarks(String value);



  public  void setSeqNo(Integer value);

public  void setSeqNo(int value);


}
