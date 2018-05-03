package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceOperatorValue extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_Notes = "NOTES";
  public final static  String S_StateDate = "STATE_DATE";
  public final static  String S_SpanBusinessId = "SPAN_BUSINESS_ID";
  public final static  String S_FeeMsgFlag = "FEE_MSG_FLAG";
  public final static  String S_ModuleCode = "MODULE_CODE";
  public final static  String S_BusinessId = "BUSINESS_ID";
  public final static  String S_ConMsgFlag = "CON_MSG_FLAG";
  public final static  String S_ReportFlag = "REPORT_FLAG";
  public final static  String S_ReverseBusinessId = "REVERSE_BUSINESS_ID";
  public final static  String S_IncomeType = "INCOME_TYPE";
  public final static  String S_Name = "NAME";
  public final static  String S_LogFlag = "LOG_FLAG";
  public final static  String S_SpanFlag = "SPAN_FLAG";


public String getState();

public String getNotes();

public Timestamp getStateDate();

public long getSpanBusinessId();

public String getFeeMsgFlag();

public String getModuleCode();

public long getBusinessId();

public String getConMsgFlag();

public String getReportFlag();

public long getReverseBusinessId();

public int getIncomeType();

public String getName();

public String getLogFlag();

public String getSpanFlag();


public  void setState(String value);

public  void setNotes(String value);

public  void setStateDate(Timestamp value);

public  void setSpanBusinessId(long value);

public  void setFeeMsgFlag(String value);

public  void setModuleCode(String value);

public  void setBusinessId(long value);

public  void setConMsgFlag(String value);

public  void setReportFlag(String value);

public  void setReverseBusinessId(long value);

public  void setIncomeType(int value);

public  void setName(String value);

public  void setLogFlag(String value);

public  void setSpanFlag(String value);
}
