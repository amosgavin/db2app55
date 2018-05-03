package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceFrameButtonValue extends DataStructInterface{

  public final static  String S_BceFrameId = "BCE_FRAME_ID";
  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_Enable = "ENABLE";
  public final static  String S_EventClick = "EVENT_CLICK";
  public final static  String S_ButtonId = "BUTTON_ID";
  public final static  String S_Operator = "OPERATOR";
  public final static  String S_Mo = "MO";
  public final static  String S_AreaId = "AREA_ID";
  public final static  String S_SeqNo = "SEQ_NO";


public long getBceFrameId();

public long getModuleId();

public int getState();

public String getEnable();

public String getEventClick();

public long getButtonId();

public String getOperator();

public String getMo();

public String getAreaId();

public int getSeqNo();


public  void setBceFrameId(long value);

public  void setModuleId(long value);

public  void setState(int value);

public  void setEnable(String value);

public  void setEventClick(String value);

public  void setButtonId(long value);

public  void setOperator(String value);

public  void setMo(String value);

public  void setAreaId(String value);

public  void setSeqNo(int value);
}
