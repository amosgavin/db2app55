package com.asiainfo.sale.tag.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOPromationTagValue extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_Firstcharge = "FIRSTCHARGE";
  public final static  String S_Name = "NAME";
  public final static  String S_Area = "AREA";
  public final static  String S_IsSp = "IS_SP";
  public final static  String S_Pid = "PID";
  public final static  String S_TagCode = "TAG_CODE";
  public final static  String S_Remark = "REMARK";
  public final static  String S_Charge = "CHARGE";
  public final static  String S_StandbyNum1 = "STANDBY_NUM1";
  public final static  String S_AccountType = "ACCOUNT_TYPE";
  public final static  String S_Cycle = "CYCLE";
  public final static  String S_StandbyNum2 = "STANDBY_NUM2";
  public final static  String S_StandbyNum3 = "STANDBY_NUM3";
  public final static  String S_RemarkTag = "REMARK_TAG";
  public final static  String S_TagType = "TAG_TYPE";
  public final static  String S_AddMonthcharge = "ADD_MONTHCHARGE";
  public final static  String S_Sumcharge = "SUMCHARGE";
  public final static  String S_Lastcharge = "LASTCHARGE";
  public final static  String S_AccountRow = "ACCOUNT_ROW";
  public final static  String S_Id = "ID";
  public final static  String S_SubjectName = "SUBJECT_NAME";
  public final static  String S_ReturnType = "RETURN_TYPE";
  public final static  String S_LimType = "LIM_TYPE";

public String getState();

public String getFirstcharge();

public String getName();

public String getArea();

public String getIsSp();

public int getPid();

public String getTagCode();

public String getRemark();

public double getCharge();

public String getStandbyNum1();

public String getAccountType();

public int getCycle();

public String getStandbyNum2();

public String getStandbyNum3();

public String getRemarkTag();

public String getTagType();

public String getAddMonthcharge();

public double getSumcharge();

public String getLastcharge();

public String getAccountRow();

public int getId();

public String getSubjectName();

public String getReturnType();

public String getLimType();


public  void setState(String value);

public  void setFirstcharge(String value);

public  void setName(String value);

public  void setArea(String value);

public  void setIsSp(String value);

public  void setPid(int value);

public  void setTagCode(String value);

public  void setRemark(String value);

public  void setCharge(double value);

public  void setStandbyNum1(String value);

public  void setAccountType(String value);

public  void setCycle(int value);

public  void setStandbyNum2(String value);

public  void setStandbyNum3(String value);

public  void setRemarkTag(String value);

public  void setTagType(String value);

public  void setAddMonthcharge(String value);

public  void setSumcharge(double value);

public  void setLastcharge(String value);

public  void setAccountRow(String value);

public  void setId(int value);

public  void setSubjectName(String value);

public  void setReturnType(String value);

public void setLimType(String value);
}
