package com.ai.bce.auto.plugin.version.hand.dao.interfaces;

import java.rmi.RemoteException;

import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerDtlParamsValue;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerHandValue;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerOpDtlValue;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerOpValue;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerOrdValue;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerTabinfoValue;

/**
 * 
 * �汾�������ݿ��ӿ�ʵ����
 * <p>
 * Copyright (c) 2010 Asiainfo-Linkage
 * </p>
 * 
 * @ClassName: IHandLogDAO.java
 * @Description: ����Ĺ�������
 * 
 * @version: v1.0.0
 * @author: Qinjin Peng
 * @date: Feb 1, 2011 7:38:38 PM
 */
public interface IHandLogDAO {
	/**
	 * �������󵥲���
	 * 
	 * @Title:
	 * @Description: TODO(������һ�仰�����������������)
	 * @param opValue
	 * @throws Exception
	 * @throws RemoteException
	 *             �趨�ļ�
	 * @return ��������
	 */
	public IBceVerOpValue saveVerOp(IBceVerOpValue opValue) throws Exception,
			RemoteException;

	/**
	 * �����������ϸ
	 * 
	 * @Title:
	 * @Description: TODO(������һ�仰�����������������)
	 * @param opDtlValue
	 * @param dtlParamsValues
	 * @throws Exception
	 * @throws RemoteException
	 *             �趨�ļ�
	 * @return ��������
	 */
	public void saveVerOpDtl(IBceVerOpDtlValue opDtlValue,
			IBceVerDtlParamsValue[] dtlParamsValues) throws Exception,
			RemoteException;
	
	public IBceVerOrdValue createOrder(IBceVerOrdValue verOrdValue)
	throws Exception, RemoteException;

	public void createVerHand(IBceVerHandValue verHandValue) throws Exception, RemoteException;

	public IBceVerOpDtlValue[] getOpDtlValuesByOpId(long opId, boolean isHf) throws Exception;

	public IBceVerOpValue[] getOpValuesByOrdId(long ordId, boolean isHf) throws Exception;

	public IBceVerDtlParamsValue[] getOpParamsByDtlId(long dtlId) throws Exception;

	public IBceVerOrdValue getOrdValueByOrdId(long ordId) throws Exception;

	public IBceVerTabinfoValue[] getBceVerTabInfoValuesByTabName(
			String tableName) throws Exception;
}
