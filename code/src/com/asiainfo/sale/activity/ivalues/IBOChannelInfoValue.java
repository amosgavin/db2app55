package com.asiainfo.sale.activity.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOChannelInfoValue extends DataStructInterface{

  public final static  String S_RelId = "REL_ID";
  public final static  String S_RelType = "REL_TYPE";
  public final static  String S_ChannelCode = "CHANNEL_CODE";
  public final static  String S_Operation = "OPERATION";
  public final static  String S_Id = "ID";
  public final static  String S_Region = "REGION";


public int getRelId();

public String getRelType();

public String getChannelCode();

public String getOperation();

public int getId();

public String getRegion();


public  void setRelId(int value);

public  void setRelType(String value);

public  void setChannelCode(String value);

public  void setOperation(String value);

public  void setId(int value);

public  void setRegion(String value);
}
