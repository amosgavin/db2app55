package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceBatInputFieldFormatValue extends DataStructInterface{

  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_FieldName = "FIELD_NAME";
  public final static  String S_State = "STATE";
  public final static  String S_ListType = "LIST_TYPE";
  public final static  String S_Title = "TITLE";
  public final static  String S_ConfigId = "CONFIG_ID";
  public final static  String S_VerifySrvname = "VERIFY_SRVNAME";
  public final static  String S_SeqNo = "SEQ_NO";


public long getModuleId();

public String getFieldName();

public int getState();

public int getListType();

public String getTitle();

public long getConfigId();

public String getVerifySrvname();

public int getSeqNo();


public  void setModuleId(long value);

public  void setFieldName(String value);

public  void setState(int value);

public  void setListType(int value);

public  void setTitle(String value);

public  void setConfigId(long value);

public  void setVerifySrvname(String value);

public  void setSeqNo(int value);
}
