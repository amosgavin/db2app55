package com.asiainfo.sale.common.dao.interfaces;

import com.asiainfo.sale.common.ivalues.IBOProxyShowValue;
import com.asiainfo.sale.common.ivalues.IBOProxyValue;

public interface IProxyDAO {

	/**
	 * 获取代理相关信息(带有组织机构等关联信息，展示用)
	 * 
	 * @param authorId
	 *            权限所有人ID
	 * @param createrId
	 *            授权人ID
	 * @param proxyerId
	 *            被授权人ID
	 * @param mFlag
	 *            能否多级授权 1 允许 0 不允许
	 * @return
	 * @throws Exception
	 */
	public IBOProxyShowValue[] getProxyShow(String authorId, String createrId,
			String proxyerId, String mFlag, String state) throws Exception;
	
	/**
	 * 获取代理相关信息
	 * 
	 * @param authorId
	 *            权限所有人ID
	 * @param createrId
	 *            授权人ID
	 * @param proxyerId
	 *            被授权人ID
	 * @param mFlag
	 *            能否多级授权 1 允许 0 不允许
	 * @return
	 * @throws Exception
	 */
	public IBOProxyValue[] getProxy(String authorId, String createrId,
			String proxyerId, String mFlag, String state) throws Exception;
	
	
	/**
	 * 根据被代理人获取代理人信息
	 * 
	 * @param proxyerId
	 * @return
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public IBOProxyShowValue[] getParentProxyValue(String proxyerId)
			throws Exception;
	
	/**
	 * 根据被代理人获取代理人数量
	 * 
	 * @param proxyerId
	 * @return
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public int getParentProxyValueCount(String proxyerId)
			throws Exception;

	/**
	 * 根据被代理人获取下级代理信息
	 * 
	 * @param proxyerId
	 * @return
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public IBOProxyShowValue getNextProxyValue(String proxyerId)
			throws Exception;


	/**
	 * 更具编号获取代理信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public IBOProxyShowValue getProxyById(String id) throws Exception;

	/**
	 * 根据父节点获取代理信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public IBOProxyShowValue getProxyByParentId(String id) throws Exception;

	/**
	 * 设置代理人
	 * 
	 * @param createrId
	 *            授权人ID
	 * @param proxyerId
	 *            被授权人ID
	 * @param mFlag
	 *            能否多级授权 1 允许 0 不允许
	 * @return
	 * @throws Exception
	 */
	public String[] setProxy(String createrId, String proxyerId, String mFlag)
			throws Exception;

	/**
	 * 取消代理
	 * 
	 * @param createrId
	 *            要回收权限的操作员ID
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public String[] delProxy(String createrId)
			throws Exception;
}
