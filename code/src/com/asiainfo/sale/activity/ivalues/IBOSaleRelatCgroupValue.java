package com.asiainfo.sale.activity.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOSaleRelatCgroupValue extends DataStructInterface{

  public final static  String S_RelatType = "RELAT_TYPE";
  public final static  String S_OrderId = "ORDER_ID";
  public final static  String S_CgroupRegion = "CGROUP_REGION";
  public final static  String S_CgroupId = "CGROUP_ID";
  public final static  String S_Id = "ID";
  public final static  String S_CgroupTab = "CGROUP_TAB";
  public final static  String S_CgroupName = "CGROUP_NAME";
  public final static  String S_CgroupEndTime = "CGROUP_END_TIME";
  public final static  String S_RelatId = "RELAT_ID";
  public final static  String S_CgroupBeginTime = "CGROUP_BEGIN_TIME";
  public final static  String S_CgroupFlag = "CGROUP_FLAG";
  public final static  String S_CgroupUsernum = "CGROUP_USERNUM";


public String getRelatType();

public String getOrderId();

public String getCgroupRegion();

public String getCgroupId();

public int getId();

public String getCgroupTab();

public String getCgroupName();

public Timestamp getCgroupEndTime();

public String getRelatId();

public Timestamp getCgroupBeginTime();

public String getCgroupFlag();

public String getCgroupUsernum();


public  void setRelatType(String value);

public  void setOrderId(String value);

public  void setCgroupRegion(String value);

public  void setCgroupId(String value);

public  void setId(int value);

public  void setCgroupTab(String value);

public  void setCgroupName(String value);

public  void setCgroupEndTime(Timestamp value);

public  void setRelatId(String value);

public  void setCgroupBeginTime(Timestamp value);

public  void setCgroupFlag(String value);

public  void setCgroupUsernum(String value);
}
