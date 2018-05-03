package com.asiainfo.bi.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOOrderCfgTraceValue extends DataStructInterface{

  public final static  String S_CfgStaff = "CFG_STAFF";
  public final static  String S_OrganizeName = "ORGANIZE_NAME";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_ApplyStaff = "APPLY_STAFF";
  public final static  String S_PcId = "PC_ID";
  public final static  String S_DcCode = "DC_CODE";
  public final static  String S_DcName = "DC_NAME";
  public final static  String S_FinishDate = "FINISH_DATE";
  public final static  String S_OrderName = "ORDER_NAME";
  public final static  String S_PcName = "PC_NAME";


public String getCfgStaff();

public String getOrganizeName();

public long getOrderId();

public String getApplyStaff();

public String getPcId();

public String getDcCode();

public String getDcName();

public Timestamp getFinishDate();

public String getOrderName();

public String getPcName();


public  void setCfgStaff(String value);

public  void setOrganizeName(String value);

public  void setOrderId(long value);

public  void setApplyStaff(String value);

public  void setPcId(String value);

public  void setDcCode(String value);

public  void setDcName(String value);

public  void setFinishDate(Timestamp value);

public  void setOrderName(String value);

public  void setPcName(String value);
}
