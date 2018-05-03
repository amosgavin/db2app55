package com.asiainfo.sale.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBONewAttachValue extends DataStructInterface{

  public final static  String S_Staffname = "STAFFNAME";
  public final static  String S_OrganizeName = "ORGANIZE_NAME";
  public final static  String S_Itemid = "ITEMID";
  public final static  String S_Label = "LABEL";
  public final static  String S_UploadTime = "UPLOAD_TIME";
  public final static  String S_Filename = "FILENAME";
  public final static  String S_Attachid = "ATTACHID";
  public final static  String S_Depart = "DEPART";
  public final static  String S_Itemtype = "ITEMTYPE";


public String getStaffname();

public String getOrganizeName();

public long getItemid();

public String getLabel();

public Timestamp getUploadTime();

public String getFilename();

public long getAttachid();

public String getDepart();

public String getItemtype();


public  void setStaffname(String value);

public  void setOrganizeName(String value);

public  void setItemid(long value);

public  void setLabel(String value);

public  void setUploadTime(Timestamp value);

public  void setFilename(String value);

public  void setAttachid(long value);

public  void setDepart(String value);

public  void setItemtype(String value);
}
