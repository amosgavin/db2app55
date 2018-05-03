package com.asiainfo.sale.tag.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOZFQPromationTagValue extends DataStructInterface{

  public final static  String S_TagType = "TAG_TYPE";
  public final static  String S_State = "STATE";
  public final static  String S_Name = "NAME";
  public final static  String S_Area = "AREA";
  public final static  String S_Pid = "PID";
  public final static  String S_Sumcharge = "SUMCHARGE";
  public final static  String S_Id = "ID";
  public final static  String S_TagCode = "TAG_CODE";
  public final static  String S_Charge = "CHARGE";
  public final static  String S_Cycle = "CYCLE";


public String getTagType();

public String getState();

public String getName();

public String getArea();

public int getPid();

public double getSumcharge();

public int getId();

public String getTagCode();

public double getCharge();

public int getCycle();


public  void setTagType(String value);

public  void setState(String value);

public  void setName(String value);

public  void setArea(String value);

public  void setPid(int value);

public  void setSumcharge(double value);

public  void setId(int value);

public  void setTagCode(String value);

public  void setCharge(double value);

public  void setCycle(int value);
}
