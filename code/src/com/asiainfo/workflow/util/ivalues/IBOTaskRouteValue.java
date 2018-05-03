package com.asiainfo.workflow.util.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOTaskRouteValue extends DataStructInterface{

  public final static  String S_Userid = "USERID";
  public final static  String S_Tasktype = "TASKTYPE";
  public final static  String S_Taskid = "TASKID";
  public final static  String S_Lable = "LABLE";
  public final static  String S_Usertype = "USERTYPE";
  public final static  String S_Condition = "CONDITION";


public String getUserid();

public String getTasktype();

public long getTaskid();

public String getLable();

public String getUsertype();

public String getCondition();


public  void setUserid(String value);

public  void setTasktype(String value);

public  void setTaskid(long value);

public  void setLable(String value);

public  void setUsertype(String value);

public  void setCondition(String value);
}
