package com.ai.bce.configtool.service.impl;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import com.ai.bce.bo.BcePageEngine;
import com.ai.bce.bo.QBOBcePagePageFrameEngine;
import com.ai.bce.bo.QBOBcePageRelRowsetEngine;
import com.ai.bce.bo.QBOBcePageRulesetRuleEngine;
import com.ai.bce.bo.QBOBceRowsetPageEngine;
import com.ai.bce.configtool.service.interfaces.IConfPageSV;
import com.ai.bce.ivalues.IBcePageValue;
import com.ai.bce.ivalues.IQBOBcePagePageFrameValue;
import com.ai.bce.ivalues.IQBOBcePageRelRowsetValue;
import com.ai.bce.ivalues.IQBOBcePageRulesetRuleValue;
import com.ai.bce.ivalues.IQBOBceRowsetPageValue;
/**
 * 
 * Copyright: Copyright (c) 2010 Asiainfo-Linkage
 * 
 * @ClassName: ConfPageSVImpl.java
 * @Description: 页面服务实现类
 *
 * @version: v1.0.0
 * @author: ZhangWenqi
 * @date: Dec 10, 2010 10:43:20 AM 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * Dec 10, 2010     ZhangWenqi           v1.0.0               修改原因
 */
public class ConfPageSVImpl implements IConfPageSV {

	/**
	 * 根据条件获取页面信息
	 */
	public IBcePageValue[] getBcePageValues(String cond, int startNum, int endNum)throws Exception
	{
		return BcePageEngine.getBeans(null, cond, null, startNum, endNum, false);
	}
	/**
	 * 根据条件获取页面信息数量
	 */
	public int getBcePageCount(String cond) throws Exception, RemoteException
	{
		IBcePageValue[] values = BcePageEngine.getBeans(cond, null);
		if(values != null && values.length > 0)
		{
			return values.length;
		}
		return 0;
	}

	/**
	 * 根据数据集编号获取引用该数据集的所有页面信息
	 */
	public IQBOBceRowsetPageValue[] getRelatePagesByRowsetId(long rowsetId, int startNum, int endNum) throws Exception, RemoteException
	{
		Map map = new HashMap();
		map.put("rowsetId", new Long(rowsetId));
		return QBOBceRowsetPageEngine.getBeans(null, null, map, startNum, endNum, false);
	}
	/**
	 * 根据数据集编号获取引用该数据集的页面数量
	 */
	public int getRelatePageCountByRowsetId(long rowsetId) throws Exception, RemoteException
	{
		Map map = new HashMap();
		map.put("rowsetId", new Long(rowsetId));
		IQBOBceRowsetPageValue[] values = QBOBceRowsetPageEngine.getBeans(null, map);
		if(values != null && values.length > 0)
		{
			return values.length;
		}
		return 0;
	}
	/**
	 * 根据页面编号获取引用该页面的页面框架
	 */
	public IQBOBcePagePageFrameValue[] getRelatePageFramesByPageId(long pageId, int startNum, int endNum) throws Exception, RemoteException
	{
		Map map = new HashMap();
		map.put("pageId", new Long(pageId));
		return QBOBcePagePageFrameEngine.getBeans(null, null, map, startNum, endNum, false);
	}
	/**
	 * 根据页面编号获取引用该页面的页面框架数量
	 */
	public int getRelatePageFrameCount(long pageId)throws Exception, RemoteException
	{
		Map map = new HashMap();
		map.put("pageId", new Long(pageId));
		IQBOBcePagePageFrameValue[] values = QBOBcePagePageFrameEngine.getBeans(null, map);
		if(values != null && values.length > 0)
		{
			return values.length;
		}
		return 0;
	}
	/**
	 * 根据页面编号获取页面包含的规则
	 */
	public IQBOBcePageRulesetRuleValue[] getRelateRulesByPageId(long pageId, int start, int end) throws Exception, RemoteException
	{
		Map map = new HashMap();
		map.put("pageId", new Long(pageId));
		return QBOBcePageRulesetRuleEngine.getBeans(null, null, map, start, end, false);
	}
	/**
	 * 根据页面编号获取页面包含的规则数量
	 */
	public int getRelateRuleCountByPageId(long pageId) throws Exception, RemoteException
	{
		Map map = new HashMap();
		map.put("pageId", new Long(pageId));
		IQBOBcePageRulesetRuleValue[] values = QBOBcePageRulesetRuleEngine.getBeans(null, map);
		if(values != null && values.length > 0)
		{
			return values.length;
		}
		return 0;
	}
	/**
	 * 根据页面编号获取页面包含的数据集
	 */
	public IQBOBcePageRelRowsetValue[] getRelateRowsetsByPageId(long pageId, int start, int end) throws Exception, RemoteException
	{
		Map map = new HashMap();
		map.put("pageId", new Long(pageId));
		return QBOBcePageRelRowsetEngine.getBeans(null, null, map, start, end, false);
	}
	/**
	 * 根据页面编号获取页面包含的数据集数量
	 */
	public int getRelateRowsetCountByPageId(long pageId) throws Exception, RemoteException
	{
		Map map = new HashMap();
		map.put("pageId", new Long(pageId));
		IQBOBcePageRelRowsetValue[] values = QBOBcePageRelRowsetEngine.getBeans(null, map);
		if(values != null && values.length > 0)
		{
			return values.length;
		}
		return 0;
	}
	public IBcePageValue[] getBcePageValues(String cond) throws Exception,
			RemoteException {
		return getBcePageValues(cond ,-1,-1);
	}
	public IQBOBcePagePageFrameValue[] getRelatePageFramesByPageId(long pageId)
			throws Exception, RemoteException { 
		return getRelatePageFramesByPageId(pageId,-1,-1);
	}
	public IQBOBceRowsetPageValue[] getRelatePagesByRowsetId(long rowsetId)
			throws Exception, RemoteException { 
		return getRelatePagesByRowsetId(rowsetId ,-1,-1);
	}
	public IQBOBcePageRelRowsetValue[] getRelateRowsetsByPageId(long pageId)
			throws Exception, RemoteException { 
		return getRelateRowsetsByPageId(pageId,-1,-1);
	}
	public IQBOBcePageRulesetRuleValue[] getRelateRulesByPageId(long pageId)
			throws Exception, RemoteException { 
		return getRelateRulesByPageId(pageId ,-1,-1);
	}
	
	
}
