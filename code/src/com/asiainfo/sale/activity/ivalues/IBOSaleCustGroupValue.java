package com.asiainfo.sale.activity.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOSaleCustGroupValue extends DataStructInterface{

  public final static  String S_ActiveTempletId = "ACTIVE_TEMPLET_ID";
  public final static  String S_CustGroupDesc = "CUST_GROUP_DESC";
  public final static  String S_CustGroupAccessToken = "CUST_GROUP_ACCESS_TOKEN";
  public final static  String S_CityId = "CITY_ID";
  public final static  String S_CustGroupTabName = "CUST_GROUP_TAB_NAME";
  public final static  String S_CustGroupType = "CUST_GROUP_TYPE";
  public final static  String S_CustGroupSourceId = "CUST_GROUP_SOURCE_ID";
  public final static  String S_CustGroupName = "CUST_GROUP_NAME";
  public final static  String S_CustTypeId = "CUST_TYPE_ID";
  public final static  String S_CustTypeSystem = "CUST_TYPE_SYSTEM";
  public final static  String S_CreateUserId = "CREATE_USER_ID";
  public final static  String S_CustGroupStatus = "CUST_GROUP_STATUS";
  public final static  String S_CustGroupTag = "CUST_GROUP_TAG";
  public final static  String S_SelectSql = "SELECT_SQL";
  public final static  String S_CustGroupNum = "CUST_GROUP_NUM";
  public final static  String S_CustFrequency = "CUST_FREQUENCY";
  public final static  String S_Ext5 = "EXT5";
  public final static  String S_CustBaseMonth = "CUST_BASE_MONTH";
  public final static  String S_CustGroupId = "CUST_GROUP_ID";
  public final static  String S_CustBaseDay = "CUST_BASE_DAY";
  public final static  String S_CreateDate = "CREATE_DATE";
  public final static  String S_Ext1 = "EXT1";
  public final static  String S_Ext2 = "EXT2";
  public final static  String S_Ext3 = "EXT3";
  public final static  String S_Ext4 = "EXT4";


public String getActiveTempletId();

public String getCustGroupDesc();

public int getCustGroupAccessToken();

public String getCityId();

public String getCustGroupTabName();

public int getCustGroupType();

public String getCustGroupSourceId();

public String getCustGroupName();

public int getCustTypeId();

public String getCustTypeSystem();

public String getCreateUserId();

public int getCustGroupStatus();

public String getCustGroupTag();

public String getSelectSql();

public int getCustGroupNum();

public String getCustFrequency();

public String getExt5();

public String getCustBaseMonth();

public String getCustGroupId();

public String getCustBaseDay();

public String getCreateDate();

public String getExt1();

public String getExt2();

public String getExt3();

public String getExt4();


public  void setActiveTempletId(String value);

public  void setCustGroupDesc(String value);

public  void setCustGroupAccessToken(int value);

public  void setCityId(String value);

public  void setCustGroupTabName(String value);

public  void setCustGroupType(int value);

public  void setCustGroupSourceId(String value);

public  void setCustGroupName(String value);

public  void setCustTypeId(int value);

public  void setCustTypeSystem(String value);

public  void setCreateUserId(String value);

public  void setCustGroupStatus(int value);

public  void setCustGroupTag(String value);

public  void setSelectSql(String value);

public  void setCustGroupNum(int value);

public  void setCustFrequency(String value);

public  void setExt5(String value);

public  void setCustBaseMonth(String value);

public  void setCustGroupId(String value);

public  void setCustBaseDay(String value);

public  void setCreateDate(String value);

public  void setExt1(String value);

public  void setExt2(String value);

public  void setExt3(String value);

public  void setExt4(String value);
}
