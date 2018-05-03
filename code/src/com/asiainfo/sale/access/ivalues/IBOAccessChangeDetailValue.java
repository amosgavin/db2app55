package com.asiainfo.sale.access.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOAccessChangeDetailValue extends DataStructInterface{

  public final static  String S_Remark = "REMARK";
  public final static  String S_RwName = "RW_NAME";
  public final static  String S_RwId = "RW_ID";
  public final static  String S_AccessId = "ACCESS_ID";
  public final static  String S_YxPcName = "YX_PC_NAME";
  public final static  String S_YxPcCode = "YX_PC_CODE";
  public final static  String S_YxDcName = "YX_DC_NAME";
  public final static  String S_Id = "ID";
  public final static  String S_YxDcCode = "YX_DC_CODE";
  public final static  String S_ZfName = "ZF_NAME";
  public final static  String S_ZfId = "ZF_ID";


public String getRemark();

public String getRwName();

public String getRwId();

public long getAccessId();

public String getYxPcName();

public String getYxPcCode();

public String getYxDcName();

public long getId();

public String getYxDcCode();

public String getZfName();

public String getZfId();


public  void setRemark(String value);

public  void setRwName(String value);

public  void setRwId(String value);

public  void setAccessId(long value);

public  void setYxPcName(String value);

public  void setYxPcCode(String value);

public  void setYxDcName(String value);

public  void setId(long value);

public  void setYxDcCode(String value);

public  void setZfName(String value);

public  void setZfId(String value);
}
