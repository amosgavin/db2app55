package com.asiainfo.sale.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
public interface IBOAttachValue extends DataStructInterface{

  public final static  String S_Filepath = "FILEPATH";
  public final static  String S_Itemid = "ITEMID";
  public final static  String S_Savename = "SAVENAME";
  public final static  String S_ItemType = "ITEM_TYPE";
  public final static  String S_Id = "ID";
  public final static  String S_Filename = "FILENAME";


public String getFilepath();

public int getItemid();

public String getSavename();

public String getItemType();

public int getId();

public String getFilename();


public  void setFilepath(String value);

public  void setItemid(int value);

public  void setSavename(String value);

public  void setItemType(String value);

public  void setId(int value);

public  void setFilename(String value);
}
