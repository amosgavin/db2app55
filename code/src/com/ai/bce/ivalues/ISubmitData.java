package com.ai.bce.ivalues;

import java.io.Serializable;

public interface ISubmitData extends Serializable{

  INodeData[] getNodeDatas();

  INodeData getNodeData(String pNodeInfoName);
  
  String getName();
  
  public String getCurPageId();
 
  public String getNextPageId();

  public String getType();
}
