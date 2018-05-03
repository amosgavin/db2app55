package com.asiainfo.sale.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOAnnounceInfoValue extends DataStructInterface{

  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_CancelTime = "CANCEL_TIME";
  public final static  String S_Title = "TITLE";
  public final static  String S_Content = "CONTENT";
  public final static  String S_Id = "ID";
  public final static  String S_Principle = "PRINCIPLE";
  public final static  String S_Flag = "FLAG";
  public final static  String S_ApplyTime = "APPLY_TIME";


public Timestamp getCreateTime();

public Timestamp getCancelTime();

public String getTitle();

public String getContent();

public int getId();

public String getPrinciple();

public String getFlag();

public Timestamp getApplyTime();


public  void setCreateTime(Timestamp value);

public  void setCancelTime(Timestamp value);

public  void setTitle(String value);

public  void setContent(String value);

public  void setId(int value);

public  void setPrinciple(String value);

public  void setFlag(String value);

public  void setApplyTime(Timestamp value);
}
