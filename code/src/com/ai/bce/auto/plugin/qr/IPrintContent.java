/**   
 * @Title: IPrintContent.java 
 * @Package com.ai.bce.auto.plugin.qr 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Qinjin Peng (Pengqj@asiainfo-linkage.com)   
 * @date 2011-4-3 上午10:52:36 
 * @version V1.0   
 */
package com.ai.bce.auto.plugin.qr;

import java.rmi.RemoteException;
import java.util.Map;

import com.ai.bce.ivalues.IBceData;

/**
 * 确认页接口类
 * 
 * @ClassName: IPrintContent
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Qinjin Peng
 * @date 2011-4-3 上午10:52:36
 * 
 */
public interface IPrintContent {

	/**
	 * @param bceFrameid 
	 * 获取配置数据内容
	 * 
	 * @Title: getContent
	 * @Description: TODO
	 * @param @param bceData
	 * @param @param customOrderId
	 * @param @return
	 * @param @throws RemoteException
	 * @param @throws Exception
	 * @return Map
	 * @throws
	 */
	public Map getContent(IBceData bceData, long customOrderId, long bceFrameid)
			throws RemoteException, Exception;
}
