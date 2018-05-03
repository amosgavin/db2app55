package com.asiainfo.sale.access.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOAccessChangeValue extends DataStructInterface{

  public final static  String S_Remark = "REMARK";
  public final static  String S_AccesDetail = "ACCES_DETAIL";
  public final static  String S_Org = "ORG";
  public final static  String S_ETime = "E_TIME";
  public final static  String S_Scale = "SCALE";
  public final static  String S_BTime = "B_TIME";
  public final static  String S_OType = "O_TYPE";
  public final static  String S_OldBand = "OLD_BAND";
  public final static  String S_Dep = "DEP";
  public final static  String S_OObject = "O_OBJECT";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_State = "STATE";
  public final static  String S_NewBand = "NEW_BAND";
  public final static  String S_AccessId = "ACCESS_ID";
  public final static  String S_Tel = "TEL";
  public final static  String S_Principle = "PRINCIPLE";
  public final static  String S_ApplyName = "APPLY_NAME";


public String getRemark();

public String getAccesDetail();

public String getOrg();

public Timestamp getETime();

public String getScale();

public Timestamp getBTime();

public String getOType();

public String getOldBand();

public String getDep();

public String getOObject();

public Timestamp getCreateTime();

public String getState();

public String getNewBand();

public int getAccessId();

public String getTel();

public String getPrinciple();

public String getApplyName();


public  void setRemark(String value);

public  void setAccesDetail(String value);

public  void setOrg(String value);

public  void setETime(Timestamp value);

public  void setScale(String value);

public  void setBTime(Timestamp value);

public  void setOType(String value);

public  void setOldBand(String value);

public  void setDep(String value);

public  void setOObject(String value);

public  void setCreateTime(Timestamp value);

public  void setState(String value);

public  void setNewBand(String value);

public  void setAccessId(int value);

public  void setTel(String value);

public  void setPrinciple(String value);

public  void setApplyName(String value);
}
