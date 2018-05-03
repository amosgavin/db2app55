package com.ai.bce.valuebean;

import java.util.ArrayList;
import java.util.List;

import com.ai.bce.ivalues.INodeData;
import com.ai.bce.ivalues.ISubmitData;

public class SubmitDataBean implements ISubmitData{

	private String name;
  private String curPageId;
  private String nextPageId;
  private String type;
  private List nodeInfoList = new ArrayList();

  public void setName(String name) {
      this.name = name;
  }

  public INodeData[] getNodeDatas() {
      // TODO Auto-generated method stub
      return (INodeData[]) nodeInfoList.toArray(new INodeData[0]);
  }

  public INodeData getNodeData(String pNodeInfoName) {
  	  INodeData reVal = null;
      for (int i = 0; i < this.nodeInfoList.size(); i++) {
          if (((INodeData) this.nodeInfoList.get(i)).getName().equals(pNodeInfoName)) {
              reVal = ((INodeData) this.nodeInfoList.get(i));
              break;
          }
      }
      return reVal;
  }

  public String getName() {
      // TODO Auto-generated method stub
      return name;
  }

  public void addNodeInfo(INodeData nodeInfo) {
      this.nodeInfoList.add(nodeInfo);
  }

  /**
   * @return the curPageId
   */
  public String getCurPageId() {
      return curPageId;
  }

  /**
   * @param curPageId the curPageId to set
   */
  public void setCurPageId(String curPageId) {
      this.curPageId = curPageId;
  }

  /**
   * @return the nextPageId
   */
  public String getNextPageId() {
      return nextPageId;
  }

  /**
   * @param nextPageId the nextPageId to set
   */
  public void setNextPageId(String nextPageId) {
      this.nextPageId = nextPageId;
  }

  public String getType () {
	  return type;
  }

  public void setType(String type) {
      this.type = type;
  }
}
