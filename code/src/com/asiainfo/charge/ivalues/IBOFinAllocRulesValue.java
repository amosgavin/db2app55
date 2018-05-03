package com.asiainfo.charge.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOFinAllocRulesValue extends DataStructInterface{

  public final static  String S_CallingExpense = "CALLING_EXPENSE";
  public final static  String S_SmsExpense = "SMS_EXPENSE";
  public final static  String S_MobilesecretaryExpense = "MOBILESECRETARY_EXPENSE";
  public final static  String S_MonthfixedExpense = "MONTHFIXED_EXPENSE";
  public final static  String S_ChargeId = "CHARGE_ID";
  public final static  String S_IncomingshowExpense = "INCOMINGSHOW_EXPENSE";
  public final static  String S_MmsExpense = "MMS_EXPENSE";
  public final static  String S_WapsmsExpense = "WAPSMS_EXPENSE";
  public final static  String S_RingtonesExpense = "RINGTONES_EXPENSE";
  public final static  String S_ElineExpense = "ELINE_EXPENSE";
  public final static  String S_GloabalcallingExpense = "GLOABALCALLING_EXPENSE";
  public final static  String S_WapgprsExpense = "WAPGPRS_EXPENSE";
  public final static  String S_Id = "ID";
  public final static  String S_CalltransferExpense = "CALLTRANSFER_EXPENSE";
  public final static  String S_Others = "OTHERS";


public String getCallingExpense();

public String getSmsExpense();

public String getMobilesecretaryExpense();

public String getMonthfixedExpense();

public String getChargeId();

public String getIncomingshowExpense();

public String getMmsExpense();

public String getWapsmsExpense();

public String getRingtonesExpense();

public String getElineExpense();

public String getGloabalcallingExpense();

public String getWapgprsExpense();

public String getId();

public String getCalltransferExpense();

public String getOthers();


public  void setCallingExpense(String value);

public  void setSmsExpense(String value);

public  void setMobilesecretaryExpense(String value);

public  void setMonthfixedExpense(String value);

public  void setChargeId(String value);

public  void setIncomingshowExpense(String value);

public  void setMmsExpense(String value);

public  void setWapsmsExpense(String value);

public  void setRingtonesExpense(String value);

public  void setElineExpense(String value);

public  void setGloabalcallingExpense(String value);

public  void setWapgprsExpense(String value);

public  void setId(String value);

public  void setCalltransferExpense(String value);

public  void setOthers(String value);
}
