package com.ai.bce.valuebean;

import org.apache.commons.lang.StringUtils;

import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.web.DataContainerList;
import com.ai.appframe2.web.HttpUtil;
import com.ai.bce.ivalues.INodeXmlData;

public class NodeXmlDataBean implements INodeXmlData{

	private String name;
  private String xmltype;
  private String xmlstring;
  //private DataContainerList dataContainerList = null;

  public String getName() {
      // TODO Auto-generated method stub
      return name;
  }

  public String getXmlstring() {
      return xmlstring;
  }

  public void setXmlstring(String xmlstring) {
      this.xmlstring = xmlstring;
  }

  public String getXmltype() {
      // TODO Auto-generated method stub
      return xmltype;
  }

  public DataContainerList[] getDataContainerLists(Class[] dataContainerClass)
          throws Exception {
      if (StringUtils.isNotBlank(this.xmlstring)) {
          return HttpUtil.getDataContainerLists(HttpUtil.getXmlDeclare() + this.xmlstring, dataContainerClass);
      } else {
          return null;
      }
  }

  public DataContainerInterface[] getDataContainers() throws Exception {
      DataContainerList[] dcList = this.getDataContainerLists(null);
      if (dcList != null && dcList.length > 0&&null!=dcList[0]) {
    	  //将BO中没有的属性设置进去
    	  DataContainerInterface[] allDcs= dcList[0].getAllDataContainerInterface();
    	  DataContainerInterface[] rtnDcs= dcList[0].getColDataContainerInterface(0);
    	 for(int i=0;i<rtnDcs.length;i++){
    		 for(int j=0;j<allDcs[i].getPropertyNames().length;j++){
    			 String propertyName=allDcs[i].getPropertyNames()[j];
    			 if(!rtnDcs[i].hasPropertyName(propertyName)){
    				 rtnDcs[i].setExtAttr(propertyName, allDcs[i].get(propertyName));
    			 }
    		 }
    	 }
    	  return rtnDcs;
      }
      return null;
  }

  public void setName(String name) {
      this.name = name;
  }

  public void setXmltype(String xmltype) {
      this.xmltype = xmltype;
  }
}
