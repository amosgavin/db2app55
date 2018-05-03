package com.ai.bce.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBceWarnRelateValue extends DataStructInterface{

  public final static  String S_RegionId = "REGION_ID";
  public final static  String S_BceFrameId = "BCE_FRAME_ID";
  public final static  String S_BusinessId = "BUSINESS_ID";
  public final static  String S_State = "STATE";
  public final static  String S_ChangeNewValue = "CHANGE_NEW_VALUE";
  public final static  String S_Remarks = "REMARKS";
  public final static  String S_ChangeName = "CHANGE_NAME";
  public final static  String S_WarnId = "WARN_ID";
  public final static  String S_RelateId = "RELATE_ID";


public String getRegionId();

public long getBceFrameId();

public String getBusinessId();

public int getState();

public String getChangeNewValue();

public String getRemarks();

public String getChangeName();

public long getWarnId();

public long getRelateId();


public  void setRegionId(String value);

public  void setBceFrameId(long value);

public  void setBusinessId(String value);

public  void setState(int value);

public  void setChangeNewValue(String value);

public  void setRemarks(String value);

public  void setChangeName(String value);

public  void setWarnId(long value);

public  void setRelateId(long value);
}
