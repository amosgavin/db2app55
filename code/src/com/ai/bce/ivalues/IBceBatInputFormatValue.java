package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceBatInputFormatValue extends DataStructInterface{

  public final static  String S_MaxNo = "MAX_NO";
  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_SplitChar = "SPLIT_CHAR";
  public final static  String S_InputType = "INPUT_TYPE";
  public final static  String S_RoleId = "ROLE_ID";
  public final static  String S_ParseService = "PARSE_SERVICE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_BusiService = "BUSI_SERVICE";
  public final static  String S_BusinessId = "BUSINESS_ID";
  public final static  String S_StyleImg = "STYLE_IMG";
  public final static  String S_ConfigId = "CONFIG_ID";
  public final static  String S_Extra1 = "EXTRA_1";
  public final static  String S_StyleDesc = "STYLE_DESC";
  public final static  String S_RetChar = "RET_CHAR";
  public final static  String S_ProdSpecId = "PROD_SPEC_ID";
  public final static  String S_Extra2 = "EXTRA_2";


public int getMaxNo();

public long getModuleId();

public int getState();

public String getSplitChar();

public int getInputType();

public long getRoleId();

public String getParseService();

public String getRemarks();

public String getBusiService();

public long getBusinessId();

public String getStyleImg();

public long getConfigId();

public String getExtra1();

public String getStyleDesc();

public String getRetChar();

public long getProdSpecId();

public String getExtra2();


public  void setMaxNo(int value);

public  void setModuleId(long value);

public  void setState(int value);

public  void setSplitChar(String value);

public  void setInputType(int value);

public  void setRoleId(long value);

public  void setParseService(String value);

public  void setRemarks(String value);

public  void setBusiService(String value);

public  void setBusinessId(long value);

public  void setStyleImg(String value);

public  void setConfigId(long value);

public  void setExtra1(String value);

public  void setStyleDesc(String value);

public  void setRetChar(String value);

public  void setProdSpecId(long value);

public  void setExtra2(String value);
}
