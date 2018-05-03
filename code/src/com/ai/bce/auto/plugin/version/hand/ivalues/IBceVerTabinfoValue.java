package com.ai.bce.auto.plugin.version.hand.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceVerTabinfoValue extends DataStructInterface{

  public final static  String S_TableName = "TABLE_NAME";
  public final static  String S_State = "STATE";
  public final static  String S_Sort = "SORT";
  public final static  String S_TabInfoId = "TAB_INFO_ID";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_PrimaryCol = "PRIMARY_COL";


public String getTableName();

public int getState();

public String getSort();

public long getTabInfoId();

public String getRemarks();

public String getPrimaryCol();


public  void setTableName(String value);

public  void setState(int value);

public  void setSort(String value);

public  void setTabInfoId(long value);

public  void setRemarks(String value);

public  void setPrimaryCol(String value);
}
