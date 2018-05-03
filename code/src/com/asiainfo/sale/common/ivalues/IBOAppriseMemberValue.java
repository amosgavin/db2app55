package com.asiainfo.sale.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOAppriseMemberValue extends DataStructInterface{

  public final static  String S_Remark1 = "REMARK1";
  public final static  String S_Remark2 = "REMARK2";
  public final static  String S_OperatorId = "OPERATOR_ID";
  public final static  String S_Remark3 = "REMARK3";
  public final static  String S_Remark4 = "REMARK4";
  public final static  String S_SendTime = "SEND_TIME";
  public final static  String S_IsReaded = "IS_READED";
  public final static  String S_ReadTime = "READ_TIME";
  public final static  String S_DealTime = "DEAL_TIME";
  public final static  String S_SenderInfo = "SENDER_INFO";
  public final static  String S_Content = "CONTENT";
  public final static  String S_LastOperatorId = "LAST_OPERATOR_ID";
  public final static  String S_Id = "ID";
  public final static  String S_AppriseFlag = "APPRISE_FLAG";
  public final static  String S_WorkflowId = "WORKFLOW_ID";


public String getRemark1();

public String getRemark2();

public int getOperatorId();

public String getRemark3();

public String getRemark4();

public Timestamp getSendTime();

public String getIsReaded();

public Timestamp getReadTime();

public Timestamp getDealTime();

public String getSenderInfo();

public String getContent();

public int getLastOperatorId();

public int getId();

public String getAppriseFlag();

public String getWorkflowId();


public  void setRemark1(String value);

public  void setRemark2(String value);

public  void setOperatorId(int value);

public  void setRemark3(String value);

public  void setRemark4(String value);

public  void setSendTime(Timestamp value);

public  void setIsReaded(String value);

public  void setReadTime(Timestamp value);

public  void setDealTime(Timestamp value);

public  void setSenderInfo(String value);

public  void setContent(String value);

public  void setLastOperatorId(int value);

public  void setId(int value);

public  void setAppriseFlag(String value);

public  void setWorkflowId(String value);
}
