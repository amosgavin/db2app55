package com.asiainfo.workflow.util.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface ITaskRouteValue extends DataStructInterface{

  public final static  String condition = null;
  public final static  long gotoItemId = 0;
  public final static  String lable = null;


public long getSortId();

public String getCodeName();

public int getIsUsed();

public String getCodeNameNls();

public String getCodeId();

public String getExternCode();

public String getCodeType();


public  void setSortId(int value);

public  void setCodeName(String value);

public  void setIsUsed(int value);

public  void setCodeNameNls(String value);

public  void setCodeId(String value);

public  void setExternCode(String value);

public  void setCodeType(String value);
}
