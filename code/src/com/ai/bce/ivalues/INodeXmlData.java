package com.ai.bce.ivalues;

import java.io.Serializable;

import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.web.DataContainerList;

public interface INodeXmlData extends Serializable{

	String getName();

  String getXmltype();
  
  DataContainerList[] getDataContainerLists(Class[] dataContainerClass) throws Exception;

  DataContainerInterface[] getDataContainers() throws Exception;
}
