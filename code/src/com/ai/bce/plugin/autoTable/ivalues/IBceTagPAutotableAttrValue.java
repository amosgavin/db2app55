package com.ai.bce.plugin.autoTable.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceTagPAutotableAttrValue extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_DispalyColumn = "DISPALY_COLUMN";
  public final static  String S_AttrId = "ATTR_ID";
  public final static  String S_DisplayType = "DISPLAY_TYPE";
  public final static  String S_Rowspan = "ROWSPAN";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_Style = "STYLE";
  public final static  String S_Rowes = "ROWES";
  public final static  String S_Col = "COL";
  public final static  String S_AutotableId = "AUTOTABLE_ID";
  public final static  String S_Height = "HEIGHT";
  public final static  String S_Align = "ALIGN";
  public final static  String S_Name = "NAME";
  public final static  String S_RelConfigId = "REL_CONFIG_ID";
  public final static  String S_Width = "WIDTH";
  public final static  String S_Colspan = "COLSPAN";


public int getState();

public String getDispalyColumn();

public long getAttrId();

public int getDisplayType();

public int getRowspan();

public String getRemarks();

public String getStyle();

public int getRowes();

public int getCol();

public long getAutotableId();

public String getHeight();

public String getAlign();

public String getName();

public long getRelConfigId();

public String getWidth();

public int getColspan();


public  void setState(int value);

public  void setDispalyColumn(String value);

public  void setAttrId(long value);

public  void setDisplayType(int value);

public  void setRowspan(int value);

public  void setRemarks(String value);

public  void setStyle(String value);

public  void setRowes(int value);

public  void setCol(int value);

public  void setAutotableId(long value);

public  void setHeight(String value);

public  void setAlign(String value);

public  void setName(String value);

public  void setRelConfigId(long value);

public  void setWidth(String value);

public  void setColspan(int value);
}
