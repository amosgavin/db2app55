package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceQrTemplateValue extends DataStructInterface{

  public final static  String S_State = "STATE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_TemplateName = "TEMPLATE_NAME";
  public final static  String S_JsFile = "JS_FILE";
  public final static  String S_ContentClass = "CONTENT_CLASS";
  public final static  String S_JsFunction = "JS_FUNCTION";
  public final static  String S_TemplateId = "TEMPLATE_ID";
  public final static  String S_FilePath = "FILE_PATH";


public int getState();

public String getRemarks();

public String getTemplateName();

public String getJsFile();

public String getContentClass();

public String getJsFunction();

public long getTemplateId();

public String getFilePath();


public  void setState(int value);

public  void setRemarks(String value);

public  void setTemplateName(String value);

public  void setJsFile(String value);

public  void setContentClass(String value);

public  void setJsFunction(String value);

public  void setTemplateId(long value);

public  void setFilePath(String value);
}
