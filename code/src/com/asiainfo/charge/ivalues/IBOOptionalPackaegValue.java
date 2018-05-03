package com.asiainfo.charge.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOOptionalPackaegValue extends DataStructInterface{

  public final static  String S_Name = "NAME";
  public final static  String S_Id = "ID";


public String getName();

public String getId();


public  void setName(String value);

public  void setId(String value);
}
