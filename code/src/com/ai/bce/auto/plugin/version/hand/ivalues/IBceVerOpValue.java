package com.ai.bce.auto.plugin.version.hand.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceVerOpValue extends DataStructInterface{

  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_OpId = "OP_ID";
  public final static  String S_OpDate = "OP_DATE";
  public final static  String S_State = "STATE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_YearM = "YEAR_M";
  public final static  String S_OpUser = "OP_USER";
  public final static  String S_ServiceId = "SERVICE_ID";
  public final static  String S_SyncStatus = "SYNC_STATUS";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_OrdId = "ORD_ID";
  public final static  String S_SyncType = "SYNC_TYPE";
  public final static  String S_MethodName = "METHOD_NAME";


public long getModuleId();

public long getOpId();

public Timestamp getOpDate();

public int getState();

public String getRemarks();

public String getYearM();

public long getOpUser();

public String getServiceId();

public int getSyncStatus();

public Timestamp getModifyDate();

public long getOrdId();

public int getSyncType();

public String getMethodName();


public  void setModuleId(long value);

public  void setOpId(long value);

public  void setOpDate(Timestamp value);

public  void setState(int value);

public  void setRemarks(String value);

public  void setYearM(String value);

public  void setOpUser(long value);

public  void setServiceId(String value);

public  void setSyncStatus(int value);

public  void setModifyDate(Timestamp value);

public  void setOrdId(long value);

public  void setSyncType(int value);

public  void setMethodName(String value);
}
