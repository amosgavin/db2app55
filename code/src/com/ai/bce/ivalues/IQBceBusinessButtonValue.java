package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IQBceBusinessButtonValue extends DataStructInterface{

  public final static  String S_BceFrameId = "BCE_FRAME_ID";
  public final static  String S_I18nRes = "I18N_RES";
  public final static  String S_Enable = "ENABLE";
  public final static  String S_Text = "TEXT";
  public final static  String S_EventClick = "EVENT_CLICK";
  public final static  String S_ButtonCode = "BUTTON_CODE";
  public final static  String S_Operator = "OPERATOR";
  public final static  String S_Mo = "MO";
  public final static  String S_AreaId = "AREA_ID";
  public final static  String S_Width = "WIDTH";
  public final static  String S_SeqNo = "SEQ_NO";


public long getBceFrameId();

public String getI18nRes();

public String getEnable();

public String getText();

public String getEventClick();

public String getButtonCode();

public String getOperator();

public String getMo();

public String getAreaId();

public String getWidth();

public long getSeqNo();


public  void setBceFrameId(long value);

public  void setI18nRes(String value);

public  void setEnable(String value);

public  void setText(String value);

public  void setEventClick(String value);

public  void setButtonCode(String value);

public  void setOperator(String value);

public  void setMo(String value);

public  void setAreaId(String value);

public  void setWidth(String value);

public  void setSeqNo(long value);
}
