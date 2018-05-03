package com.ai.bce.service.interfaces;

import java.rmi.RemoteException;

import com.ai.bce.ivalues.IBceData;
import com.ai.bce.ivalues.IBceDealReturnData;

public interface IBceDealService {

	/**
	 * ����ҵ���߼�
	 */
	public IBceDealReturnData deal(IBceData beData,long beFrameId)throws Exception,RemoteException;
	
	/**
	 * ���췵�ص�ǰ̨��CustomProperty
	 */
	public IBceDealReturnData createCustomProperty(IBceData beData,IBceDealReturnData data)throws Exception,RemoteException;
}
