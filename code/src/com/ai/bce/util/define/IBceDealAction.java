package com.ai.bce.util.define;

import java.rmi.RemoteException;

import com.ai.bce.ivalues.IBceData;
import com.ai.bce.ivalues.IBceDealReturnData;

/**
 * 
 * 
 * @since 1.0
 * @ClassName: IBceDealAction.java
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Qinjin Peng
 * @date 2011-6-18 下午09:32:22
 * @version 1.0
 */
public interface IBceDealAction {
	/**
	 * 服务Action处理
	 * 
	 * @param beFrameId
	 * @param bceData
	 * @param is_CONFIRM
	 * @param orderCode
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public IBceDealReturnData dealService(long beFrameId, IBceData bceData,
			boolean is_CONFIRM, String orderCode) throws Exception,
			RemoteException;
}
