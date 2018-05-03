package com.ai.bce.plugin.autoTable.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceTagPAutotableValue extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_AutotableId = "AUTOTABLE_ID";
  public final static  String S_Height = "HEIGHT";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_ObjectId = "OBJECT_ID";
  public final static  String S_Name = "NAME";
  public final static  String S_Align = "ALIGN";
  public final static  String S_Width = "WIDTH";
  public final static  String S_Border = "BORDER";
  public final static  String S_TId = "T_ID";


public int getState();

public long getAutotableId();

public String getHeight();

public String getRemarks();

public long getObjectId();

public String getName();

public String getAlign();

public String getWidth();

public String getBorder();

public String getTId();


public  void setState(int value);

public  void setAutotableId(long value);

public  void setHeight(String value);

public  void setRemarks(String value);

public  void setObjectId(long value);

public  void setName(String value);

public  void setAlign(String value);

public  void setWidth(String value);

public  void setBorder(String value);

public  void setTId(String value);
}
