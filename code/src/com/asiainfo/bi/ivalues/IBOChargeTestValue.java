package com.asiainfo.bi.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOChargeTestValue extends DataStructInterface{

  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_Reason = "REASON";
  public final static  String S_Id = "ID";
  public final static  String S_TestFactor = "TEST_FACTOR";
  public final static  String S_TestResult = "TEST_RESULT";
  public final static  String S_Flag = "FLAG";


public int getOrderId();

public String getReason();

public int getId();

public String getTestFactor();

public String getTestResult();

public String getFlag();


public  void setOrderId(int value);

public  void setReason(String value);

public  void setId(int value);

public  void setTestFactor(String value);

public  void setTestResult(String value);

public  void setFlag(String value);
}
