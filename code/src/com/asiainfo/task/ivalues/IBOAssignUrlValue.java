package com.asiainfo.task.ivalues;
import com.ai.appframe2.common.DataStructInterface;
import java.sql.Timestamp;
public interface IBOAssignUrlValue extends DataStructInterface{

  public final static  String S_NodeTag = "NODE_TAG";
  public final static  String S_Id = "ID";
  public final static  String S_NodeName = "NODE_NAME";
  public final static  String S_FlowName = "FLOW_NAME";
  public final static  String S_Url = "URL";


public String getNodeTag();

public int getId();

public String getNodeName();

public String getFlowName();

public String getUrl();


public  void setNodeTag(String value);

public  void setId(int value);

public  void setNodeName(String value);

public  void setFlowName(String value);

public  void setUrl(String value);
}
