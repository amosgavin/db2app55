package com.asiainfo.sale.common.service.interfaces;

import com.asiainfo.sale.common.ivalues.IBOProxyShowValue;

public interface IProxySV {
	/**
	 * ���ô�����
	 * 
	 * @param createrId
	 *            ��ǰ����ԱID
	 * @param proxyerId
	 *            Ҫ����Ĳ���ԱID
	 * @param mFlag
	 *            �ܷ�༶��Ȩ 1 ���� 0 ������
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public String[] setProxy(String createrId, String proxyerId, String mFlag)
			throws RuntimeException, Exception;

	/**
	 * ȡ������
	 * 
	 * @param createrId
	 *            Ҫ����Ȩ�޵Ĳ���ԱID
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public String[] delProxy(String createrId) throws RuntimeException,
			Exception;

	/**
	 * ���ݱ������˻�ȡ�ϼ�������Ϣ
	 * 
	 * @param proxyerId
	 * @return
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public IBOProxyShowValue[] getParentProxyValue(String proxyerId)
			throws RuntimeException, Exception;
	
	/**
	 * ���ݱ������˻�ȡ�ϼ��������
	 * 
	 * @param proxyerId
	 * @return
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public int getParentProxyValueCount(String proxyerId)
			throws RuntimeException, Exception;

	/**
	 * ���ݱ������˻�ȡ�¼�������Ϣ
	 * 
	 * @param proxyerId
	 * @return
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public IBOProxyShowValue getNextProxyValue(String proxyerId)
			throws RuntimeException, Exception;

	/**
	 * ���ݱ������˻�ȡ�����ϼ�������Ϣ
	 * 
	 * @param proxyerId
	 *            ��������ID
	 * @return
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public IBOProxyShowValue[] getAllProxyValue(String proxyerId)
			throws RuntimeException, Exception;
}
