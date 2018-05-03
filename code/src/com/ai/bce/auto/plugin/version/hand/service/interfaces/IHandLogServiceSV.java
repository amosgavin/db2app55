package com.ai.bce.auto.plugin.version.hand.service.interfaces;

import java.rmi.RemoteException;

import com.ai.bce.auto.plugin.version.hand.bean.HandAttrBean;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerHandValue;
import com.ai.bce.auto.plugin.version.hand.ivalues.IBceVerOpValue;

/**
 * 服务接口类
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
	 * 输出SQL支持
	 * 
	 * @Title:
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param
	 * @param ordId
	 * @param
	 * @param isHf
	 * @param
	 * @return
	 * @param
	 * @throws Exception
	 *             设定文件
	 * @return 返回类型
	 * @throws
	 */
	public String exportSQlByOrdId(long ordId, boolean isHf) throws Exception;

	public boolean logService(HandAttrBean handAttrBean) throws Exception,
			RemoteException;

	/**
	 * 创建订单服务
	 * 
	 * @Title:
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param
	 * @param handAttrBean
	 * @param
	 * @return
	 * @param
	 * @throws Exception
	 * @param
	 * @throws RemoteException
	 *             设定文件
	 * @return 返回类型
	 * @throws
	 */
	public IBceVerOpValue logServiceOrd(HandAttrBean handAttrBean)
			throws Exception, RemoteException;

	/**
	 * 创建版本
	 * 
	 * @Title:
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param
	 * @param verHandValue
	 * @param
	 * @return
	 * @param
	 * @throws Exception
	 * @param
	 * @throws RemoteException
	 *             设定文件
	 * @return 返回类型
	 * @throws
	 */
	public IBceVerHandValue lodServiceHand(IBceVerHandValue verHandValue)
			throws Exception, RemoteException;

	/**
	 * 设置需求单编号
	 * 
	 * @Title:
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param
	 * @param ordSn
	 * @param
	 * @return
	 * @param
	 * @throws Exception
	 * @param
	 * @throws RemoteException
	 *             设定文件
	 * @return 返回类型
	 * @throws
	 */
	public boolean setVerOrdSn(String ordSn) throws Exception, RemoteException;
}
