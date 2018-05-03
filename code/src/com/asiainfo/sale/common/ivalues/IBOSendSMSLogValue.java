package com.asiainfo.sale.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOSendSMSLogValue extends DataStructInterface{

  public final static  String S_Sender = "SENDER";
  public final static  String S_Content = "CONTENT";
  public final static  String S_Receiver = "RECEIVER";
  public final static  String S_SendTime = "SEND_TIME";
  public final static  String S_Id = "ID";
  public final static  String S_TaskId = "TASK_ID";


public int getSender();

public String getContent();

public int getReceiver();

public Timestamp getSendTime();

public int getId();

public String getTaskId();


public  void setSender(int value);

public  void setContent(String value);

public  void setReceiver(int value);

public  void setSendTime(Timestamp value);

public  void setId(int value);

public  void setTaskId(String value);
}
