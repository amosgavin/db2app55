package com.asiainfo.sale.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IBOApprisePrimeValue extends DataStructInterface{

  public final static  String S_Content = "CONTENT";
  public final static  String S_SenderId = "SENDER_ID";
  public final static  String S_Id = "ID";
  public final static  String S_WorkflowId = "WORKFLOW_ID";


public String getContent();

public int getSenderId();

public int getId();

public int getWorkflowId();


public  void setContent(String value);

public  void setSenderId(int value);

public  void setId(int value);

public  void setWorkflowId(int value);
}
