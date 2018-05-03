package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceButtonValue extends DataStructInterface{

  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_I18nRes = "I18N_RES";
  public final static  String S_ButtonName = "BUTTON_NAME";
  public final static  String S_ButtonId = "BUTTON_ID";
  public final static  String S_ButtonCode = "BUTTON_CODE";
  public final static  String S_Width = "WIDTH";
  public final static  String S_EventClick = "EVENT_CLICK";
  public final static  String S_Text = "TEXT";

  public  Long  getModuleIdAsLong();

public long getModuleId();


  public  Integer  getStateAsInteger();

public int getState();



public String getI18nRes();



public String getButtonName();


  public  Long  getButtonIdAsLong();

public long getButtonId();



public String getButtonCode();



public String getWidth();



public String getEventClick();



public String getText();




  public  void setModuleId(Long value);

public  void setModuleId(long value);



  public  void setState(Integer value);

public  void setState(int value);




public  void setI18nRes(String value);




public  void setButtonName(String value);



  public  void setButtonId(Long value);

public  void setButtonId(long value);




public  void setButtonCode(String value);




public  void setWidth(String value);




public  void setEventClick(String value);




public  void setText(String value);


}
