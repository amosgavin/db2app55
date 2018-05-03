package com.ai.bce.configtool.service.interfaces;

import java.rmi.RemoteException;

import com.ai.bce.ivalues.IBcePageRowsetRelValue;
import com.ai.bce.ivalues.IBceRowsetValue;
import com.ai.bce.ivalues.IQBOBcePageRowsetValue;

/**
 * 
 * Copyright: Copyright (c) 2010 Asiainfo-Linkage
 * 
 * @ClassName: IBceRowsetSV.java
 * @Description: 数据集服务接口
 *
 * @version: v1.0.0
 * @author: ZhangWenqi
 * @date: Dec 10, 2010 11:17:11 AM 
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * Dec 10, 2010     ZhangWenqi           v1.0.0               修改原因
 */
public interface IConfRowsetSV {

	/**
	 * 
	 * @Function: getPageRowsetValues
	 * @Description: 根据查询条件获取数据集及关联信息
	 *
	 * @param: cond 查询条件
	 * @return：IQBOBcePageRowsetValue[] 数据集及关联信息
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 8, 2010 9:14:17 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 8, 2010     ZhangWenqi           v1.0.0               修改原因
	 */
	public IQBOBcePageRowsetValue[] getPageRowsetValues(String cond, int startNum, int endNum) throws Exception, RemoteException;
	public IQBOBcePageRowsetValue[] getPageRowsetValues(String cond ) throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getPageRowsetCount
	 * @Description: 根据查询条件获取数据集及关联信息数量
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 16, 2010 3:36:04 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 16, 2010     ZhangWenqi           v1.0.0               修改原因
	 */
	public int getPageRowsetCount(String cond) throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getRowsetValues
	 * @Description: 根据条件获取数据集信息
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 10, 2010 3:01:01 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 10, 2010     ZhangWenqi           v1.0.0               修改原因
	 */
	public IBceRowsetValue[] getRowsetValues(String cond, int startNum, int endNum) throws Exception, RemoteException;
	public IBceRowsetValue[] getRowsetValues(String cond ) throws Exception, RemoteException;
	/**
	 * 
	 * @Function: getRowsetCount
	 * @Description: 根据条件获取数据集数量
	 *
	 * @param:参数描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: ZhangWenqi
	 * @date: Dec 16, 2010 2:33:09 PM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 16, 2010     ZhangWenqi           v1.0.0               修改原因
	 */
	public int getRowsetCount(String cond) throws Exception, RemoteException;

	public IBcePageRowsetRelValue getPageRowsetRelValueById(String pageFramePageId,String rowsetId) throws Exception;
}
