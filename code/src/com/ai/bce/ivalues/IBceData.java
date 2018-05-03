package com.ai.bce.ivalues;

import java.io.Serializable;
import java.util.Map;

import com.ai.appframe2.common.DataContainerInterface;

public interface IBceData extends Serializable{
	
	public long getBceFrameId();
	public void setBceFrameId(long bceFrameId);
	
	public long getKeyValue();
	//��ȡ������
	public IBceData getParentBceData();
	
	public long getKeyAttributeId();
			
	public void setParentBceData(IBceData BceData);
	//�����Ӷ���
	public void addSubData(IBceData BceData);
	
	public void removeSubData(IBceData BceData);
	
	public IBceData containedSubData(long keyAttributeId);
	//��ȡ�Ӷ���
	public IBceData[] getSubBceData();
	
  void setSessionId(String id);
  
  String getSessionId();
  //��ȡȫ��ͨ�����ݼ�
  public Map getNormalRowsets();
  //��ȡָ����ͨ�����ݼ�
  public DataContainerInterface[] getNormalRowsetInfo(String name);
  
  public void addNormalRowsetInfo(String name,DataContainerInterface[] dcs);
  
  public Map getUserDatas();
  
  public String getUserData(String key);
  //��ȡ���ֶ�ֵ
  public void addUserData(String key,String data);
}
