package com.ai.bce.configtool.service.interfaces;

import java.rmi.RemoteException;

import com.ai.bce.ivalues.IBcePageValue;
import com.ai.bce.ivalues.IQBOBcePagePageFrameValue;
import com.ai.bce.ivalues.IQBOBcePageRelRowsetValue;
import com.ai.bce.ivalues.IQBOBcePageRulesetRuleValue;
import com.ai.bce.ivalues.IQBOBceRowsetPageValue;
/**
 * 
 * Copyright: Copyright (c) 2010 Asiainfo-Linkage
 * 
 * @ClassName: IBcePageSV.java
 * @Description: 页面服务接口
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
public interface IConfPageSV {

	/**
	 * 
	 * @Function: getBcePageValues
	 * @Description: 根据条件获取页面信息
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 10, 2010 10:51:46 AM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 10, 2010     ZhangWenqi           v1.0.0               修改原因
	 */
	public IBcePageValue[] getBcePageValues(String cond, int startNum, int endNum)throws Exception, RemoteException;
	
	public IBcePageValue[] getBcePageValues(String cond)throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getBcePageCount
	 * @Description: 根据条件获取页面信息
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 16, 2010 3:06:30 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 16, 2010     ZhangWenqi           v1.0.0               修改原因
	 */
	public int getBcePageCount(String cond) throws Exception, RemoteException;
	
	/**
	 * 
	 * @Function: getRelatePagesByRowsetId
	 * @Description: 根据数据集编号获取引用该数据集的所有页面信息
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 14, 2010 8:13:38 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 14, 2010     ZhangWenqi           v1.0.0               修改原因
	 */
	public IQBOBceRowsetPageValue[] getRelatePagesByRowsetId(long rowsetId, int startNum, int endNum) throws Exception, RemoteException;
	public IQBOBceRowsetPageValue[] getRelatePagesByRowsetId(long rowsetId) throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getRelatePageCountByRowsetId
	 * @Description: 根据数据集编号获取引用该数据集的页面数量
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 16, 2010 11:34:48 AM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 16, 2010     ZhangWenqi           v1.0.0               修改原因
	 */
	public int getRelatePageCountByRowsetId(long rowsetId) throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getRelatePageFramesByPageId
	 * @Description: 根据页面编号获取引用该页面的页面框架
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 15, 2010 9:49:06 AM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 15, 2010     ZhangWenqi           v1.0.0               修改原因
	 */
	public IQBOBcePagePageFrameValue[] getRelatePageFramesByPageId(long pageId, int startNum, int endNum) throws Exception, RemoteException;
	public IQBOBcePagePageFrameValue[] getRelatePageFramesByPageId(long pageId) throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getRelatePageFrameCount
	 * @Description: 根据页面编号获取引用该页面的页面框架数量
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 16, 2010 3:12:03 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 16, 2010     ZhangWenqi           v1.0.0               修改原因
	 */
	public int getRelatePageFrameCount(long pageId)throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getRelateRulesByPageId
	 * @Description: 根据页面编号获取页面包含的规则
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 15, 2010 11:16:30 AM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 15, 2010     ZhangWenqi           v1.0.0               修改原因
	 */
	public IQBOBcePageRulesetRuleValue[] getRelateRulesByPageId(long pageId, int start, int end) throws Exception, RemoteException;
	public IQBOBcePageRulesetRuleValue[] getRelateRulesByPageId(long pageId) throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getRelateRuleCountByPageId
	 * @Description: 根据页面编号获取页面包含的规则数量
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 15, 2010 11:17:47 AM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 15, 2010     ZhangWenqi           v1.0.0               修改原因
	 */
	public int getRelateRuleCountByPageId(long pageId) throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getRelateRowsetsByPageId
	 * @Description: 根据页面编号获取页面包含的数据集
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 15, 2010 2:23:25 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 15, 2010     ZhangWenqi           v1.0.0               修改原因
	 */
	public IQBOBcePageRelRowsetValue[] getRelateRowsetsByPageId(long pageId, int start, int end) throws Exception, RemoteException;
	public IQBOBcePageRelRowsetValue[] getRelateRowsetsByPageId(long pageId) throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getRelateRowsetCountByPageId
	 * @Description: 根据页面编号获取页面包含的数据集数量
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 15, 2010 2:22:45 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 15, 2010     ZhangWenqi           v1.0.0               修改原因
	 */
	public int getRelateRowsetCountByPageId(long pageId) throws Exception, RemoteException;
}
