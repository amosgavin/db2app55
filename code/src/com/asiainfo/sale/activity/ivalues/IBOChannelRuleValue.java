package com.asiainfo.sale.activity.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOChannelRuleValue extends DataStructInterface{

  public final static  String S_Remark1 = "REMARK1";
  public final static  String S_RuleId = "RULE_ID";
  public final static  String S_Remark2 = "REMARK2";
  public final static  String S_Remark3 = "REMARK3";
  public final static  String S_ChannelType = "CHANNEL_TYPE";
  public final static  String S_ConfMode = "CONF_MODE";
  public final static  String S_ChannelLevType = "CHANNEL_LEV_TYPE";
  public final static  String S_DetailId = "DETAIL_ID";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_ChannelPosType = "CHANNEL_POS_TYPE";


public String getRemark1();

public int getRuleId();

public String getRemark2();

public String getRemark3();

public String getChannelType();

public String getConfMode();

public String getChannelLevType();

public int getDetailId();

public Timestamp getCreateDate();

public String getChannelPosType();


public  void setRemark1(String value);

public  void setRuleId(int value);

public  void setRemark2(String value);

public  void setRemark3(String value);

public  void setChannelType(String value);

public  void setConfMode(String value);

public  void setChannelLevType(String value);

public  void setDetailId(int value);

public  void setCreateDate(Timestamp value);

public  void setChannelPosType(String value);
}
