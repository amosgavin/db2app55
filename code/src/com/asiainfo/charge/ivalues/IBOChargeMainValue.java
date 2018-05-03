package com.asiainfo.charge.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOChargeMainValue extends DataStructInterface{

  public final static  String S_Reamrk1 = "REAMRK_1";
  public final static  String S_Reamrk2 = "REAMRK_2";
  public final static  String S_State = "STATE";
  public final static  String S_Reamrk5 = "REAMRK_5";
  public final static  String S_ModifyTime = "MODIFY_TIME";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_Reamrk3 = "REAMRK_3";
  public final static  String S_Reamrk4 = "REAMRK_4";
  public final static  String S_IsDelete = "IS_DELETE";
  public final static  String S_Principle = "PRINCIPLE";
  public final static  String S_Org = "ORG";
  public final static  String S_MainId = "MAIN_ID";

	public void unDelete();
public String getReamrk1();

public String getReamrk2();

public String getState();

public String getReamrk5();

public Timestamp getModifyTime();

public Timestamp getCreateTime();

public String getReamrk3();

public String getReamrk4();

public String getIsDelete();

public String getPrinciple();

public String getOrg();

public String getMainId();


public  void setReamrk1(String value);

public  void setReamrk2(String value);

public  void setState(String value);

public  void setReamrk5(String value);

public  void setModifyTime(Timestamp value);

public  void setCreateTime(Timestamp value);

public  void setReamrk3(String value);

public  void setReamrk4(String value);

public  void setIsDelete(String value);

public  void setPrinciple(String value);

public  void setOrg(String value);

public  void setMainId(String value);
}
