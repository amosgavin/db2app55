package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IQModuleMenuRelateValue extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_Ext3 = "EXT3";
  public final static  String S_MenuName = "MENU_NAME";
  public final static  String S_Ext5 = "EXT5";
  public final static  String S_MenuUrl = "MENU_URL";
  public final static  String S_Ext4 = "EXT4";
  public final static  String S_MenuLevel = "MENU_LEVEL";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_PageTitle = "PAGE_TITLE";
  public final static  String S_MenuId = "MENU_ID";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_MenuIcon = "MENU_ICON";

  public  Long  getStateAsLong();

public long getState();



public String getExt3();



public String getMenuName();



public String getExt5();



public String getMenuUrl();



public String getExt4();


  public  Long  getMenuLevelAsLong();

public long getMenuLevel();



public String getExt2();



public String getPageTitle();


  public  Long  getMenuIdAsLong();

public long getMenuId();



public String getExt1();



public String getMenuIcon();




  public  void setState(Long value);

public  void setState(long value);




public  void setExt3(String value);




public  void setMenuName(String value);




public  void setExt5(String value);




public  void setMenuUrl(String value);




public  void setExt4(String value);



  public  void setMenuLevel(Long value);

public  void setMenuLevel(long value);




public  void setExt2(String value);




public  void setPageTitle(String value);



  public  void setMenuId(Long value);

public  void setMenuId(long value);




public  void setExt1(String value);




public  void setMenuIcon(String value);


}
