package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceExtTableConfigValue extends DataStructInterface{

  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_ExtTableName = "EXT_TABLE_NAME";
  public final static  String S_ConfigId = "CONFIG_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_RelColName = "REL_COL_NAME";
  public final static  String S_RelType = "REL_TYPE";
  public final static  String S_BoName = "BO_NAME";


public long getModuleId();

public int getState();

public String getExtTableName();

public long getConfigId();

public String getRemarks();

public String getRelColName();

public String getRelType();

public String getBoName();


public  void setModuleId(long value);

public  void setState(int value);

public  void setExtTableName(String value);

public  void setConfigId(long value);

public  void setRemarks(String value);

public  void setRelColName(String value);

public  void setRelType(String value);

public  void setBoName(String value);
}
