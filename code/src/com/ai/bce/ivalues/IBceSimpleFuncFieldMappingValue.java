package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceSimpleFuncFieldMappingValue extends DataStructInterface{

  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_FuncId = "FUNC_ID";
  public final static  String S_FieldId = "FIELD_ID";
  public final static  String S_FieldCode = "FIELD_CODE";
  public final static  String S_InsField = "INS_FIELD";
  public final static  String S_OrdField = "ORD_FIELD";

  public  Long  getModuleIdAsLong();

public long getModuleId();


  public  Integer  getStateAsInteger();

public int getState();


  public  Long  getFuncIdAsLong();

public long getFuncId();


  public  Long  getFieldIdAsLong();

public long getFieldId();



public String getFieldCode();



public String getInsField();



public String getOrdField();




  public  void setModuleId(Long value);

public  void setModuleId(long value);



  public  void setState(Integer value);

public  void setState(int value);



  public  void setFuncId(Long value);

public  void setFuncId(long value);



  public  void setFieldId(Long value);

public  void setFieldId(long value);




public  void setFieldCode(String value);




public  void setInsField(String value);




public  void setOrdField(String value);


}
