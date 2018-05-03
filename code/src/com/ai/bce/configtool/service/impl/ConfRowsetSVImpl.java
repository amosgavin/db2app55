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
 * @Description: 数据集服务实现类
 *
 * @version: v1.0.0
 * @author: ZhangWenqi
 * @date: Dec 10, 2010 11:49:35 AM 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * Dec 10, 2010     ZhangWenqi           v1.0.0               修改原因
 */
public class ConfRowsetSVImpl implements IConfRowsetSV {

	/**
	 * 根据查询条件获取数据集及关联信息
	 */
	public IQBOBcePageRowsetValue[] getPageRowsetValues(String cond, int startNum, int endNum) throws Exception, RemoteException
	{
		return QBOBcePageRowsetEngine.getBeans(null, cond, null, startNum, endNum, false);
	}
	/**
	 * 根据查询条件获取数据集及关联信息数量
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
	 * 根据条件获取数据集信息
	 */
	public IBceRowsetValue[] getRowsetValues(String cond, int startNum, int endNum) throws Exception,	RemoteException 
	{
		return BceRowsetEngine.getBeans(null, cond, null, startNum, endNum, false);
	}
	/**
	 * 根据条件获取数据集数量
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
