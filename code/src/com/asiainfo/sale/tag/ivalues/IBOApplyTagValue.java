package com.asiainfo.sale.tag.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOApplyTagValue extends DataStructInterface{

  public final static  String S_Id = "ID";
  public final static  String S_FlowState = "FLOW_STATE";
  public final static  String S_PromoteManager = "PROMOTE_MANAGER";
  public final static  String S_Principal = "PRINCIPAL";
  public final static  String S_PromoteDepart = "PROMOTE_DEPART";
  public final static  String S_Case = "CASE";


public int getId();

public String getFlowState();

public String getPromoteManager();

public String getPrincipal();

public String getPromoteDepart();

public String getCase();


public  void setId(int value);

public  void setFlowState(String value);

public  void setPromoteManager(String value);

public  void setPrincipal(String value);

public  void setPromoteDepart(String value);

public  void setCase(String value);
}
