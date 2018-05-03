package com.ai.bce.configtool.service.impl;

import java.rmi.RemoteException;

import com.ai.bce.bo.BcePageRowsetRelEngine;
import com.ai.bce.bo.BceRowsetEngine;
import com.ai.bce.bo.QBOBcePageRowsetEngine;
import com.ai.bce.configtool.service.interfaces.IConfRowsetSV;
import com.ai.bce.ivalues.IBcePageRowsetRelValue;
import com.ai.bce.ivalues.IBceRowsetValue;
import com.ai.bce.ivalues.IQBOBcePageRowsetValue;
/**
 * 
 * Copyright: Copyright (c) 2010 Asiainfo-Linkage
 * 
 * @ClassName: BceRowsetSVImpl.java
 * @Description: ���ݼ�����ʵ����
 *
 * @version: v1.0.0
 * @author: ZhangWenqi
 * @date: Dec 10, 2010 11:49:35 AM 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * Dec 10, 2010     ZhangWenqi           v1.0.0               �޸�ԭ��
 */
public class ConfRowsetSVImpl implements IConfRowsetSV {

	/**
	 * ���ݲ�ѯ������ȡ���ݼ���������Ϣ
	 */
	public IQBOBcePageRowsetValue[] getPageRowsetValues(String cond, int startNum, int endNum) throws Exception, RemoteException
	{
		return QBOBcePageRowsetEngine.getBeans(null, cond, null, startNum, endNum, false);
	}
	/**
	 * ���ݲ�ѯ������ȡ���ݼ���������Ϣ����
	 */
	public int getPageRowsetCount(String cond) throws Exception, RemoteException
	{
		IQBOBcePageRowsetValue[] values = QBOBcePageRowsetEngine.getBeans(cond, null);
		if(values != null && values.length > 0)
		{
			return values.length;
		}
		return 0;
	}
	/**
	 * ����������ȡ���ݼ���Ϣ
	 */
	public IBceRowsetValue[] getRowsetValues(String cond, int startNum, int endNum) throws Exception,	RemoteException 
	{
		return BceRowsetEngine.getBeans(null, cond, null, startNum, endNum, false);
	}
	/**
	 * ����������ȡ���ݼ�����
	 */
	public int getRowsetCount(String cond) throws Exception, RemoteException
	{
		IBceRowsetValue[] values = BceRowsetEngine.getBeans(cond, null);
		if(values != null && values.length > 0)
		{
			return values.length;
		}
		return 0;
	}
	public IBcePageRowsetRelValue getPageRowsetRelValueById(
			String pageFramePageId, String rowsetId) throws Exception {
		long _PageFramePageId = Long.parseLong(pageFramePageId);
		long _RowsetId = Long.parseLong(rowsetId);
		return BcePageRowsetRelEngine.getBean(_PageFramePageId, _RowsetId);
	}
	
	public IQBOBcePageRowsetValue[] getPageRowsetValues(String cond)
			throws Exception, RemoteException { 
		return getPageRowsetValues(cond,-1,-1);
	}
	
	public IBceRowsetValue[] getRowsetValues(String cond) throws Exception,
			RemoteException { 
		return getRowsetValues(cond ,-1 ,-1);
	}
	
	
}
