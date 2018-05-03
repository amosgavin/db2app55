package com.ai.bce.ivalues;

import java.io.Serializable;
import java.util.Map;

import com.ai.appframe2.common.DataContainerInterface;

public interface IBceData extends Serializable{
	
	public long getBceFrameId();
	public void setBceFrameId(long bceFrameId);
	
	public long getKeyValue();
	//获取父对象
	public IBceData getParentBceData();
	
	public long getKeyAttributeId();
			
	public void setParentBceData(IBceData BceData);
	//增加子对象
	public void addSubData(IBceData BceData);
	
	public void removeSubData(IBceData BceData);
	
	public IBceData containedSubData(long keyAttributeId);
	//获取子对象
	public IBceData[] getSubBceData();
	
  void setSessionId(String id);
  
  String getSessionId();
  //获取全部通用数据集
  public Map getNormalRowsets();
  //获取指定的通用数据集
  public DataContainerInterface[] getNormalRowsetInfo(String name);
  
  public void addNormalRowsetInfo(String name,DataContainerInterface[] dcs);
  
  public Map getUserDatas();
  
  public String getUserData(String key);
  //获取单字段值
  public void addUserData(String key,String data);
}
