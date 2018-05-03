package com.asiainfo.sale.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IBOPersonSetValue extends DataStructInterface{

  public final static  String S_OperatorId = "OPERATOR_ID";
  public final static  String S_SysSmsFlag = "SYS_SMS_FLAG";
  public final static  String S_Id = "ID";
  public final static  String S_ReceiveSmsFlag = "RECEIVE_SMS_FLAG";


public int getOperatorId();

public String getSysSmsFlag();

public int getId();

public String getReceiveSmsFlag();


public  void setOperatorId(int value);

public  void setSysSmsFlag(String value);

public  void setId(int value);

public  void setReceiveSmsFlag(String value);
}
