package com.ai.bce.auto.plugin.version.hand.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceVerSyncScriptValue extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_Sort = "SORT";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_SyncScript = "SYNC_SCRIPT";
  public final static  String S_OrdId = "ORD_ID";
  public final static  String S_RollbackScript = "ROLLBACK_SCRIPT";


public long getOrdId();

public String getSyncScript();

public String getRollbackScript();

public String getSort();

public int getState();

public String getRemarks();


public  void setOrdId(long value);

public  void setSyncScript(String value);

public  void setRollbackScript(String value);

public  void setSort(String value);

public  void setState(int value);

public  void setRemarks(String value);
}
