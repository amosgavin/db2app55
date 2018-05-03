package com.asiainfo.sale.common.service.interfaces;

import com.asiainfo.sale.common.ivalues.IBOProxyShowValue;

public interface IProxySV {
	/**
	 * 设置代理人
	 * 
	 * @param createrId
	 *            当前操作员ID
	 * @param proxyerId
	 *            要代理的操作员ID
	 * @param mFlag
	 *            能否多级授权 1 允许 0 不允许
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public String[] setProxy(String createrId, String proxyerId, String mFlag)
			throws RuntimeException, Exception;

	/**
	 * 取消代理
	 * 
	 * @param createrId
	 *            要回收权限的操作员ID
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public String[] delProxy(String createrId) throws RuntimeException,
			Exception;

	/**
	 * 根据被代理人获取上级代理信息
	 * 
	 * @param proxyerId
	 * @return
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public IBOProxyShowValue[] getParentProxyValue(String proxyerId)
			throws RuntimeException, Exception;
	
	/**
	 * 根据被代理人获取上级代理个数
	 * 
	 * @param proxyerId
	 * @return
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public int getParentProxyValueCount(String proxyerId)
			throws RuntimeException, Exception;

	/**
	 * 根据被代理人获取下级代理信息
	 * 
	 * @param proxyerId
	 * @return
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public IBOProxyShowValue getNextProxyValue(String proxyerId)
			throws RuntimeException, Exception;

	/**
	 * 根据被代理人获取所有上级代理信息
	 * 
	 * @param proxyerId
	 *            被代理人ID
	 * @return
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public IBOProxyShowValue[] getAllProxyValue(String proxyerId)
			throws RuntimeException, Exception;
}
