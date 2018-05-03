package com.asiainfo.sale.common.dao.interfaces;

import com.asiainfo.sale.common.ivalues.IBOProxyShowValue;
import com.asiainfo.sale.common.ivalues.IBOProxyValue;

public interface IProxyDAO {

	/**
	 * ��ȡ���������Ϣ(������֯�����ȹ�����Ϣ��չʾ��)
	 * 
	 * @param authorId
	 *            Ȩ��������ID
	 * @param createrId
	 *            ��Ȩ��ID
	 * @param proxyerId
	 *            ����Ȩ��ID
	 * @param mFlag
	 *            �ܷ�༶��Ȩ 1 ���� 0 ������
	 * @return
	 * @throws Exception
	 */
	public IBOProxyShowValue[] getProxyShow(String authorId, String createrId,
			String proxyerId, String mFlag, String state) throws Exception;
	
	/**
	 * ��ȡ���������Ϣ
	 * 
	 * @param authorId
	 *            Ȩ��������ID
	 * @param createrId
	 *            ��Ȩ��ID
	 * @param proxyerId
	 *            ����Ȩ��ID
	 * @param mFlag
	 *            �ܷ�༶��Ȩ 1 ���� 0 ������
	 * @return
	 * @throws Exception
	 */
	public IBOProxyValue[] getProxy(String authorId, String createrId,
			String proxyerId, String mFlag, String state) throws Exception;
	
	
	/**
	 * ���ݱ������˻�ȡ��������Ϣ
	 * 
	 * @param proxyerId
	 * @return
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public IBOProxyShowValue[] getParentProxyValue(String proxyerId)
			throws Exception;
	
	/**
	 * ���ݱ������˻�ȡ����������
	 * 
	 * @param proxyerId
	 * @return
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public int getParentProxyValueCount(String proxyerId)
			throws Exception;

	/**
	 * ���ݱ������˻�ȡ�¼�������Ϣ
	 * 
	 * @param proxyerId
	 * @return
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public IBOProxyShowValue getNextProxyValue(String proxyerId)
			throws Exception;


	/**
	 * ���߱�Ż�ȡ������Ϣ
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public IBOProxyShowValue getProxyById(String id) throws Exception;

	/**
	 * ���ݸ��ڵ��ȡ������Ϣ
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public IBOProxyShowValue getProxyByParentId(String id) throws Exception;

	/**
	 * ���ô�����
	 * 
	 * @param createrId
	 *            ��Ȩ��ID
	 * @param proxyerId
	 *            ����Ȩ��ID
	 * @param mFlag
	 *            �ܷ�༶��Ȩ 1 ���� 0 ������
	 * @return
	 * @throws Exception
	 */
	public String[] setProxy(String createrId, String proxyerId, String mFlag)
			throws Exception;

	/**
	 * ȡ������
	 * 
	 * @param createrId
	 *            Ҫ����Ȩ�޵Ĳ���ԱID
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public String[] delProxy(String createrId)
			throws Exception;
}
