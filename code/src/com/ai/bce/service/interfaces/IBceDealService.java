package com.ai.bce.service.interfaces;

import java.rmi.RemoteException;

import com.ai.bce.ivalues.IBceData;
import com.ai.bce.ivalues.IBceDealReturnData;

public interface IBceDealService {

	/**
	 * 处理业务逻辑
	 */
	public IBceDealReturnData deal(IBceData beData,long beFrameId)throws Exception,RemoteException;
	
	/**
	 * 构造返回到前台的CustomProperty
	 */
	public IBceDealReturnData createCustomProperty(IBceData beData,IBceDealReturnData data)throws Exception,RemoteException;
}
