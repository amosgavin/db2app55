package com.ai.bce.valuebean;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.DataContainerInterface;
import com.ai.bce.ivalues.IBceData;
import com.ai.bce.util.LocaleResourceFactory;

public class BceDataBean implements IBceData{

	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;

	private transient static Log logger = LogFactory.getLog(BceDataBean.class);
			
  private final transient static Random RANDOM = new Random();

	private String sessionId;
	
	private long bceFrameId;
	
	private long keyValue;
	/**
	 * 是否是跨中心服务
	 */
	private boolean isCrossService;
	
	private Map normalRowsetInfoMap;
	
	private Map userDataMap;
	
	protected IBceData parentBceData;
	
	protected List subBceDatas = null;
	
	protected Timestamp validDate;
	
	protected Timestamp expireDate;
	
	protected final transient static Timestamp DEFAULT_EXP_TIME = Timestamp.valueOf("2099-12-31 23:59:59.1");
	
	public BceDataBean(){
		keyValue = genKeyValue();
	}
	
	public long getBceFrameId() {
		return bceFrameId;
	}

	public void setBceFrameId(long bceFrameId) {
		this.bceFrameId = bceFrameId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	public long getKeyValue(){
		
		return keyValue;
	}

	public long getKeyAttributeId(){
		
		return -1;
	}
	
	public IBceData[] getSubBceData(){
		if(subBceDatas != null){
			return (IBceData[])subBceDatas.toArray(new IBceData[0]);
		}
		return null;
	}
	
	public void setParentBceData(IBceData BceData) {
		this.parentBceData = BceData;
	}

	public IBceData getParentBceData(){
		if(this.parentBceData == null){
			//父数据对象尚未初始化
			logger.error(LocaleResourceFactory.getResource("BES0000003"));
		}
		return this.parentBceData;
	}
	
	public void addSubData(IBceData BceData){
		if(BceData == null){
			//受理数据对象为空!
			logger.error(LocaleResourceFactory.getResource("BES0000004"));
			return;
		}
		
		BceData.setParentBceData(this);
		subBceDatas.add(BceData);
	}
	
	public void removeSubData(IBceData BceData){
		subBceDatas.remove(BceData);
	}

	public IBceData containedSubData(long keyAttributeId){
		for (Iterator iterator = subBceDatas.iterator(); iterator.hasNext();) {
			IBceData subBceData = (IBceData) iterator.next();
			if(subBceData.getKeyAttributeId() >=0 && subBceData.getKeyAttributeId() == keyAttributeId){
				return subBceData;
			}
		}
		return null;
	}
	
	private long genKeyValue(){
		RANDOM.setSeed(((long)this.hashCode()) ^ System.currentTimeMillis());
		return Math.abs(RANDOM.nextLong());
	}
	
	public Map getNormalRowsets(){
		return normalRowsetInfoMap;
	}

  public DataContainerInterface[] getNormalRowsetInfo(String name){
  	if(normalRowsetInfoMap == null)
  		return null;
  	return (DataContainerInterface[])normalRowsetInfoMap.get(name);
  }
  
  public void addNormalRowsetInfo(String name,DataContainerInterface[] dcs){
  	if(normalRowsetInfoMap == null)
  		normalRowsetInfoMap = new HashMap();
  	normalRowsetInfoMap.put(name, dcs);
  }
  
  public Map getUserDatas(){
  	return userDataMap;
  }
  
  public String getUserData(String key){
  	if(userDataMap == null)
  		return null;
  	return (String)userDataMap.get(key);
  }
  
  public void addUserData(String key,String data){
  	if(userDataMap == null)
  		userDataMap = new HashMap();
  	userDataMap.put(key, data);
  }

public boolean isCrossService() {
	return isCrossService;
}

public void setCrossService(boolean isCrossService) {
	this.isCrossService = isCrossService;
}
 
	
	
}
