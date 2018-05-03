package com.ai.bce.ivalues;

import java.io.Serializable;

public interface INodeData extends Serializable{

  String getName();
  String getInfotype();
  String getUserData(String pParaName);
  public String[][] getUserDatas();
  INodeXmlData[] getNodeXmlDatas();
  INodeXmlData getNodeXmlData(String pNodexmlName);
  ISubmitData[] getChildSubmitData();
}
