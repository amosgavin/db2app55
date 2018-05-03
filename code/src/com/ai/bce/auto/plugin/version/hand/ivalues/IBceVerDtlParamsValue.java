package com.ai.bce.auto.plugin.version.hand.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceVerDtlParamsValue extends DataStructInterface{

  public final static  String S_DtlParamId = "DTL_PARAM_ID";
  public final static  String S_DtlId = "DTL_ID";
  public final static  String S_State = "STATE";
  public final static  String S_ValueType = "VALUE_TYPE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_ColumnName = "COLUMN_NAME";
  public final static  String S_OldValue = "OLD_VALUE";
  public final static  String S_NewValue = "NEW_VALUE";
  public final static  String S_IsPk = "IS_PK";


public long getDtlParamId();

public long getDtlId();

public String getValueType();

public String getColumnName();

public String getNewValue();

public String getOldValue();

public int getIsPk();

public int getState();

public String getRemarks();


public  void setDtlParamId(long value);

public  void setDtlId(long value);

public  void setValueType(String value);

public  void setColumnName(String value);

public  void setNewValue(String value);

public  void setOldValue(String value);

public  void setIsPk(int value);

public  void setState(int value);

public  void setRemarks(String value);
}
