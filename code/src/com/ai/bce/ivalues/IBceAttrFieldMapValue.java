package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceAttrFieldMapValue extends DataStructInterface{

  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_AttrType = "ATTR_TYPE";
  public final static  String S_ConfigId = "CONFIG_ID";
  public final static  String S_DestFieldName = "DEST_FIELD_NAME";
  public final static  String S_AttrId = "ATTR_ID";
  public final static  String S_DataType = "DATA_TYPE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_DestTableName = "DEST_TABLE_NAME";
  public final static  String S_BusinessId = "BUSINESS_ID";


public long getModuleId();

public String getAttrType();

public long getConfigId();

public String getDestFieldName();

public long getAttrId();

public String getDataType();

public String getRemarks();

public String getDestTableName();

public long getBusinessId();


public  void setModuleId(long value);

public  void setAttrType(String value);

public  void setConfigId(long value);

public  void setDestFieldName(String value);

public  void setAttrId(long value);

public  void setDataType(String value);

public  void setRemarks(String value);

public  void setDestTableName(String value);

public  void setBusinessId(long value);
}
