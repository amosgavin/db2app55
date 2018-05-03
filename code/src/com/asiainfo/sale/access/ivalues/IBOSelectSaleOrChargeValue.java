package com.asiainfo.sale.access.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOSelectSaleOrChargeValue extends DataStructInterface{

  public final static  String S_BossBatchCode = "BOSS_BATCH_CODE";
  public final static  String S_BatchType = "BATCH_TYPE";
  public final static  String S_BossLevCode = "BOSS_LEV_CODE";
  public final static  String S_BatchName = "BATCH_NAME";
  public final static  String S_OrgName = "ORG_NAME";
  public final static  String S_OrgId = "ORG_ID";
  public final static  String S_SysLevCode = "SYS_LEV_CODE";
  public final static  String S_SysBatchCode = "SYS_BATCH_CODE";
  public final static  String S_BeginTime = "BEGIN_TIME";
  public final static  String S_BatchId = "BATCH_ID";
  public final static  String S_LevelId = "LEVEL_ID";
  public final static  String S_StaffName = "STAFF_NAME";
  public final static  String S_EndTime = "END_TIME";
  public final static  String S_LevelName = "LEVEL_NAME";


public String getBossBatchCode();

public String getBatchType();

public String getBossLevCode();

public String getBatchName();

public String getOrgName();

public String getOrgId();

public String getSysLevCode();

public String getSysBatchCode();

public Timestamp getBeginTime();

public String getBatchId();

public String getLevelId();

public String getStaffName();

public Timestamp getEndTime();

public String getLevelName();


public  void setBossBatchCode(String value);

public  void setBatchType(String value);

public  void setBossLevCode(String value);

public  void setBatchName(String value);

public  void setOrgName(String value);

public  void setOrgId(String value);

public  void setSysLevCode(String value);

public  void setSysBatchCode(String value);

public  void setBeginTime(Timestamp value);

public  void setBatchId(String value);

public  void setLevelId(String value);

public  void setStaffName(String value);

public  void setEndTime(Timestamp value);

public  void setLevelName(String value);
}
