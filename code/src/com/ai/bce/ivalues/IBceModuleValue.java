package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceModuleValue extends DataStructInterface{

  public final static  String S_ModuleId = "MODULE_ID";
  public final static  String S_State = "STATE";
  public final static  String S_HtmlDir = "HTML_DIR";
  public final static  String S_ConfigDatasource = "CONFIG_DATASOURCE";
  public final static  String S_IconUrl = "ICON_URL";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_RunDatasource = "RUN_DATASOURCE";
  public final static  String S_ModuleName = "MODULE_NAME";
  public final static  String S_JavaPackage = "JAVA_PACKAGE";

  public  Long  getModuleIdAsLong();

public long getModuleId();


  public  Integer  getStateAsInteger();

public int getState();



public String getHtmlDir();



public String getConfigDatasource();



public String getIconUrl();



public String getRemarks();



public String getRunDatasource();



public String getModuleName();



public String getJavaPackage();




  public  void setModuleId(Long value);

public  void setModuleId(long value);



  public  void setState(Integer value);

public  void setState(int value);




public  void setHtmlDir(String value);




public  void setConfigDatasource(String value);




public  void setIconUrl(String value);




public  void setRemarks(String value);




public  void setRunDatasource(String value);




public  void setModuleName(String value);




public  void setJavaPackage(String value);


}
