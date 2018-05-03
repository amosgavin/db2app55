package com.ai.secframe.sysmgr.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOSecStationDefaultRoleValue extends DataStructInterface{

  public final static  String S_OpId = "OP_ID";
  public final static  String S_State = "STATE";
  public final static  String S_DefaultId = "DEFAULT_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_StationId = "STATION_ID";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_RoleId = "ROLE_ID";
  public final static  String S_Ext3 = "EXT3";


public String getOpId();

public String getState();

public long getDefaultId();

public String getRemarks();

public String getStationId();

public String getExt1();

public String getExt2();

public String getRoleId();

public String getExt3();


public  void setOpId(String value);

public  void setState(String value);

public  void setDefaultId(long value);

public  void setRemarks(String value);

public  void setStationId(String value);

public  void setExt1(String value);

public  void setExt2(String value);

public  void setRoleId(String value);

public  void setExt3(String value);
}
