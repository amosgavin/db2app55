package com.asiainfo.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOItemOtherInfoValue extends DataStructInterface{

  public final static  String S_Date1 = "DATE_1";
  public final static  String S_InsertDate = "INSERT_DATE";
  public final static  String S_DelayReason = "DELAY_REASON";
  public final static  String S_Id = "ID";
  public final static  String S_ApproveFlag = "APPROVE_FLAG";
  public final static  String S_AdviseDealTime = "ADVISE_DEAL_TIME";
  public final static  String S_Content1 = "CONTENT_1";
  public final static  String S_ItemId = "ITEM_ID";
  public final static  String S_TaskTag = "TASK_TAG";
  public final static  String S_Content2 = "CONTENT_2";


public Timestamp getDate1();

public Timestamp getInsertDate();

public String getDelayReason();

public int getId();

public String getApproveFlag();

public Timestamp getAdviseDealTime();

public String getContent1();

public int getItemId();

public String getTaskTag();

public String getContent2();


public  void setDate1(Timestamp value);

public  void setInsertDate(Timestamp value);

public  void setDelayReason(String value);

public  void setId(int value);

public  void setApproveFlag(String value);

public  void setAdviseDealTime(Timestamp value);

public  void setContent1(String value);

public  void setItemId(int value);

public  void setTaskTag(String value);

public  void setContent2(String value);
}
