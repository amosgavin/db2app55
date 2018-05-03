package com.asiainfo.task.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBORoleOpValue extends DataStructInterface{

  public final static  String S_OperatorId = "OPERATOR_ID";
  public final static  String S_StationId = "STATION_ID";
  public final static  String S_RoleId = "ROLE_ID";
  public final static  String S_OpStationId = "OP_STATION_ID";


public long getOperatorId();

public long getStationId();

public long getRoleId();

public long getOpStationId();


public  void setOperatorId(long value);

public  void setStationId(long value);

public  void setRoleId(long value);

public  void setOpStationId(long value);
}
