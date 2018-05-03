package com.ai.bce.auto.plugin.version.hand.service.interfaces;

import java.rmi.RemoteException;

import com.ai.bce.auto.plugin.version.hand.bean.HandAttrBean;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerHandValue;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerOpValue;

/**
 * ����ӿ���
 * 
 * <p>
 * Copyright (c) 2010
 * </p>
 * 
 * @ClassName: IHandLogServiceSV.java
 * @version: v1.0.0
 * @author: Qinjin Peng
 * @date: Dec 20, 2010 1:45:57 PM
 */
public interface IHandLogServiceSV {
	/**
	 * ���SQL֧��
	 * 
	 * @Title:
	 * @Description: TODO(������һ�仰�����������������)
	 * @param
	 * @param ordId
	 * @param
	 * @param isHf
	 * @param
	 * @return
	 * @param
	 * @throws Exception
	 *             �趨�ļ�
	 * @return ��������
	 * @throws
	 */
	public String exportSQlByOrdId(long ordId, boolean isHf) throws Exception;

	public boolean logService(HandAttrBean handAttrBean) throws Exception,
			RemoteException;

	/**
	 * ������������
	 * 
	 * @Title:
	 * @Description: TODO(������һ�仰�����������������)
	 * @param
	 * @param handAttrBean
	 * @param
	 * @return
	 * @param
	 * @throws Exception
	 * @param
	 * @throws RemoteException
	 *             �趨�ļ�
	 * @return ��������
	 * @throws
	 */
	public IBceVerOpValue logServiceOrd(HandAttrBean handAttrBean)
			throws Exception, RemoteException;

	/**
	 * �����汾
	 * 
	 * @Title:
	 * @Description: TODO(������һ�仰�����������������)
	 * @param
	 * @param verHandValue
	 * @param
	 * @return
	 * @param
	 * @throws Exception
	 * @param
	 * @throws RemoteException
	 *             �趨�ļ�
	 * @return ��������
	 * @throws
	 */
	public IBceVerHandValue lodServiceHand(IBceVerHandValue verHandValue)
			throws Exception, RemoteException;

	/**
	 * �������󵥱��
	 * 
	 * @Title:
	 * @Description: TODO(������һ�仰�����������������)
	 * @param
	 * @param ordSn
	 * @param
	 * @return
	 * @param
	 * @throws Exception
	 * @param
	 * @throws RemoteException
	 *             �趨�ļ�
	 * @return ��������
	 * @throws
	 */
	public boolean setVerOrdSn(String ordSn) throws Exception, RemoteException;
}
