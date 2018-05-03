package com.asiainfo.sale.common.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOApplyInfoValue extends DataStructInterface{

  public final static  String S_ApplyName = "APPLY_NAME";
  public final static  String S_CreateTime = "CREATE_TIME";
  public final static  String S_Recordid = "RECORDID";
  public final static  String S_CreateStaffName = "CREATE_STAFF_NAME";
  public final static  String S_Principal = "PRINCIPAL";
  public final static  String S_Orgname = "ORGNAME";


public String getApplyName();

public Timestamp getCreateTime();

public String getRecordid();

public String getCreateStaffName();

public String getPrincipal();

public String getOrgname();


public  void setApplyName(String value);

public  void setCreateTime(Timestamp value);

public  void setRecordid(String value);

public  void setCreateStaffName(String value);

public  void setPrincipal(String value);

public  void setOrgname(String value);
}
