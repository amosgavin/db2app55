package com.ai.bce.valuebean;

import java.util.ArrayList;
import java.util.List;

import com.ai.appframe2.web.CustomProperty;
import com.ai.bce.ivalues.INodeData;
import com.ai.bce.ivalues.INodeXmlData;
import com.ai.bce.ivalues.ISubmitData;

public class NodeDataBean implements INodeData{

	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;
	private String name;
  private String infotype;
  private CustomProperty cp = CustomProperty.getInstance();
  private List NodexmlList = new ArrayList();
  private List childSubmitDataList = new ArrayList();

  public String getName() {

      return name;
  }

  public String getInfotype() {
     
      return infotype;
  }

  public String getUserData(String pParaName) {
      return cp.get(pParaName);
  }

  public String[][] getUserDatas() {
      String[][] reVal = null;
      Object[] keyArray = cp.getKeyArray();
      if (keyArray != null && keyArray.length > 0) {
          reVal = new String[keyArray.length][2];
          for (int i = 0; i < keyArray.length; i++) {
              reVal[i][0] = (String) keyArray[i];
              reVal[i][1] = (String) cp.get((String) keyArray[i]);
          }
      }
      return reVal;
  }

  public INodeXmlData[] getNodeXmlDatas() {

      return (INodeXmlData[]) NodexmlList.toArray(new INodeXmlData[0]);
  }

  public INodeXmlData getNodeXmlData(String pNodexmlName) {
     
  	INodeXmlData reVal = null;
      for (int i = 0; i < this.NodexmlList.size(); i++) {
          if (((INodeXmlData) this.NodexmlList.get(i)).getName().equals(pNodexmlName)) {
              reVal = (INodeXmlData) this.NodexmlList.get(i);
              break;
          }
      }
      return reVal;
  }

  public void setInfotype(String infotype) {
      this.infotype = infotype;
  }

  public void setName(String name) {
      this.name = name;
  }

  public void AddNodexml(INodeXmlData pNodexml) {
      this.NodexmlList.add(pNodexml);
  }

  public void setUserData(String pName, String pValue) {
      this.cp.set(pName, pValue);
  }

  public void setUserData(CustomProperty cp) {
      this.cp = cp;
  }

  public ISubmitData[] getChildSubmitData() {
      return (ISubmitData[]) (this.childSubmitDataList.toArray(new ISubmitData[0]));
  }

  public void addChildSubmitData(ISubmitData submitData) {
      this.childSubmitDataList.add(submitData);
  }
}
