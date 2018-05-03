package com.asiainfo.charge.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOChargeApplyMainDeValue extends DataStructInterface{

  public final static  String S_ApplyName = "APPLY_NAME";
  public final static  String S_OrganizeName = "ORGANIZE_NAME";
  public final static  String S_ApplyModifyTime = "APPLY_MODIFY_TIME";
  public final static  String S_BackGround = "BACK_GROUND";
  public final static  String S_SaleFashion = "SALE_FASHION";
  public final static  String S_ApplyTime = "APPLY_TIME";
  public final static  String S_ExtendChannel = "EXTEND_CHANNEL";
  public final static  String S_Principle = "PRINCIPLE";
  public final static  String S_ApplyMark = "APPLY_MARK";
  public final static  String S_FeeType = "FEE_TYPE";
  public final static  String S_ConsumeAnalyse = "CONSUME_ANALYSE";
  public final static  String S_ApplyEndTime = "APPLY_END_TIME";
  public final static  String S_Flack = "FLACK";
  public final static  String S_StaffName = "STAFF_NAME";
  public final static  String S_IsSubmit = "IS_SUBMIT";
  public final static  String S_UserCircs = "USER_CIRCS";
  public final static  String S_ApplyId = "APPLY_ID";
  public final static  String S_Org = "ORG";


public String getApplyName();

public String getOrganizeName();

public Timestamp getApplyModifyTime();

public String getBackGround();

public String getSaleFashion();

public Timestamp getApplyTime();

public String getExtendChannel();

public String getPrinciple();

public String getApplyMark();

public String getFeeType();

public String getConsumeAnalyse();

public Timestamp getApplyEndTime();

public String getFlack();

public String getStaffName();

public String getIsSubmit();

public String getUserCircs();

public String getApplyId();

public String getOrg();


public  void setApplyName(String value);

public  void setOrganizeName(String value);

public  void setApplyModifyTime(Timestamp value);

public  void setBackGround(String value);

public  void setSaleFashion(String value);

public  void setApplyTime(Timestamp value);

public  void setExtendChannel(String value);

public  void setPrinciple(String value);

public  void setApplyMark(String value);

public  void setFeeType(String value);

public  void setConsumeAnalyse(String value);

public  void setApplyEndTime(Timestamp value);

public  void setFlack(String value);

public  void setStaffName(String value);

public  void setIsSubmit(String value);

public  void setUserCircs(String value);

public  void setApplyId(String value);

public  void setOrg(String value);
}
