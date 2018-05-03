package com.asiainfo.charge.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOChargeNodeDateValue extends DataStructInterface{

  public final static  String S_Id = "ID";
  public final static  String S_ChargeId = "CHARGE_ID";
  public final static  String S_Remark = "REMARK";
  public final static  String S_NodeId = "NODE_ID";
  public final static  String S_NodeValue = "NODE_VALUE";


public String getId();

public String getChargeId();

public String getRemark();

public String getNodeId();

public String getNodeValue();


public  void setId(String value);

public  void setChargeId(String value);

public  void setRemark(String value);

public  void setNodeId(String value);

public  void setNodeValue(String value);
}
