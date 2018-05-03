package com.asiainfo.charge.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOProductExtDescValue extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_ExtName = "EXT_NAME";
  public final static  String S_IsCanModify = "IS_CAN_MODIFY";
  public final static  String S_ModifyDate = "MODIFY_DATE";
  public final static  String S_StaffId = "STAFF_ID";
  public final static  String S_ExtCode = "EXT_CODE";
  public final static  String S_ExtType = "EXT_TYPE";
  public final static  String S_Ext5 = "EXT5";
  public final static  String S_Ext6 = "EXT6";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_Ext3 = "EXT3";
  public final static  String S_Ext4 = "EXT4";


public String getState();

public String getExtName();

public String getIsCanModify();

public Timestamp getModifyDate();

public String getStaffId();

public String getExtCode();

public String getExtType();

public String getExt5();

public Timestamp getExt6();

public Timestamp getCreateDate();

public Timestamp getExt1();

public String getExt2();

public String getExt3();

public String getExt4();


public  void setState(String value);

public  void setExtName(String value);

public  void setIsCanModify(String value);

public  void setModifyDate(Timestamp value);

public  void setStaffId(String value);

public  void setExtCode(String value);

public  void setExtType(String value);

public  void setExt5(String value);

public  void setExt6(Timestamp value);

public  void setCreateDate(Timestamp value);

public  void setExt1(Timestamp value);

public  void setExt2(String value);

public  void setExt3(String value);

public  void setExt4(String value);
}
