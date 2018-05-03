package com.asiainfo.sale.tag.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOHPApplyValue extends DataStructInterface{

  public final static  String S_Recordid = "RECORDID";
  public final static  String S_ApplyName = "APPLY_NAME";
  public final static  String S_Principal = "PRINCIPAL";
  public final static  String S_ApplyTime = "APPLY_TIME";


public String getRecordid();

public String getApplyName();

public String getPrincipal();

public Timestamp getApplyTime();


public  void setRecordid(String value);

public  void setApplyName(String value);

public  void setPrincipal(String value);

public  void setApplyTime(Timestamp value);
}
