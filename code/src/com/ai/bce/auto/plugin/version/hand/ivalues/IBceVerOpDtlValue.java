package com.ai.bce.auto.plugin.version.hand.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceVerOpDtlValue extends DataStructInterface{

  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_OpId = "OP_ID";
  public final static  String S_State = "STATE";
  public final static  String S_ObjName = "OBJ_NAME";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_YearM = "YEAR_M";
  public final static  String S_TabName = "TAB_NAME";
  public final static  String S_OldValue = "OLD_VALUE";
  public final static  String S_KeyValue = "KEY_VALUE";
  public final static  String S_NewValue = "NEW_VALUE";
  public final static  String S_SyncStatus = "SYNC_STATUS";
  public final static  String S_DtlId = "DTL_ID";
  public final static  String S_Creater = "CREATER";
  public final static  String S_ModId = "MOD_ID";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_OperType = "OPER_TYPE";


public long getModuleId();

public long getOpId();

public int getState();

public String getObjName();

public String getRemarks();

public String getYearM();

public String getTabName();

public String getOldValue();

public String getKeyValue();

public String getNewValue();

public int getSyncStatus();

public long getDtlId();

public long getCreater();

public int getModId();

public Timestamp getCreateDate();

public String getOperType();


public  void setModuleId(long value);

public  void setOpId(long value);

public  void setState(int value);

public  void setObjName(String value);

public  void setRemarks(String value);

public  void setYearM(String value);

public  void setTabName(String value);

public  void setOldValue(String value);

public  void setKeyValue(String value);

public  void setNewValue(String value);

public  void setSyncStatus(int value);

public  void setDtlId(long value);

public  void setCreater(long value);

public  void setModId(int value);

public  void setCreateDate(Timestamp value);

public  void setOperType(String value);
}
