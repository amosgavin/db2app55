package com.ai.bce.util.define;

import java.rmi.RemoteException;

import com.ai.bce.ivalues.IBceData;
import com.ai.bce.ivalues.IBceDealReturnData;

/**
 * 
 * 
 * @since 1.0
 * @ClassName: IBceDealAction.java
 * @Description: TODO(������һ�仰��������������)
 * @author Qinjin Peng
 * @date 2011-6-18 ����09:32:22
 * @version 1.0
 */
public interface IBceDealAction {
	/**
	 * ����Action����
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
