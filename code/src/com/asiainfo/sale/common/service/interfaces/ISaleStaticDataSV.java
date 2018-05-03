package com.asiainfo.sale.common.service.interfaces;

import com.asiainfo.sale.common.ivalues.IBOSaleStaticDataValue;

public interface ISaleStaticDataSV {

	/**
	 * ��ʼ������
	 * 
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void initCache() throws Exception, RuntimeException;

	/**
	 * ��ȡ��̬����
	 * 
	 * @param codeType
	 * @return IBOSecStaticDataValue[]
	 * @throws Exception
	 * @throws RemoteException
	 */
	public IBOSaleStaticDataValue[] getSaleStaticData(String codeType)
			throws Exception, RuntimeException;

	/**
	 * ���ݾ�̬�������ͺͱ�Ż�ȡ����
	 * 
	 * @param codeType
	 *            long
	 * @param codeId
	 *            long
	 * @throws Exception
	 * @throws RemoteException
	 * @return ISysStaticDataValue[]
	 */
	public IBOSaleStaticDataValue getSaleStaticData(String codeType,
			String codeId) throws Exception, RuntimeException;

	/**
	 * ��ȡƷ��
	 * 
	 * @param codeType
	 * @return IBOSecStaticDataValue[]
	 * @throws Exception
	 * @throws RemoteException
	 */
	public IBOSaleStaticDataValue[] getBrand() throws Exception,
			RuntimeException;

	/**
	 * ��ȡϸ���г�
	 * 
	 * @param codeType
	 * @return IBOSecStaticDataValue[]
	 * @throws Exception
	 * @throws RemoteException
	 */
	public IBOSaleStaticDataValue[] getMarket() throws Exception,
			RuntimeException;

	
	public IBOSaleStaticDataValue[] getGroupType() throws Exception,
			RuntimeException;
	
	public IBOSaleStaticDataValue[] getActivity() throws Exception,
	RuntimeException;
	
	/**
	 * ��ȡ����
	 * 
	 * @param codeType
	 * @return IBOSecStaticDataValue[]
	 * @throws Exception
	 * @throws RemoteException
	 */
	public IBOSaleStaticDataValue[] getChannel() throws Exception,
			RuntimeException;

	// ��ȡҵ��������
	public IBOSaleStaticDataValue[] getBusiChangeType() throws Exception,
			RuntimeException;

	// ��ȡҵ������������
	public IBOSaleStaticDataValue[] getChannelType() throws Exception,
			RuntimeException;
	
	// ��ȡҵ��������Ʒ������
	public IBOSaleStaticDataValue[] getOpenBrand() throws Exception,
			RuntimeException;
	
	// ��ȡ����λ������
	public IBOSaleStaticDataValue[] getGeoPosType() throws Exception,
			RuntimeException;
	
	// ��ȡ�����Ǽ�����
	public IBOSaleStaticDataValue[] getStarLevel() throws Exception,
	RuntimeException;
	/**
	 * ��ȡ����
	 * 
	 * @param codeType
	 * @return IBOSecStaticDataValue[]
	 * @throws Exception
	 * @throws RemoteException
	 */
	public IBOSaleStaticDataValue[] area_type() throws Exception,
			RuntimeException;

	/**
	 * ����Ӫ����
	 * 
	 * @param codeType
	 * @return IBOSecStaticDataValue[]
	 * @throws Exception
	 * @throws RemoteException
	 */
	public IBOSaleStaticDataValue[] getZDYXD() throws Exception,
			RuntimeException;

	public IBOSaleStaticDataValue[] getSaleStaticDatas(String codeType,
			String name) throws Exception;

	public int queryStaticDateCount(String codeType, String name)
			throws Exception;
	
	// ��ȡboss�ʷ����α���
	public IBOSaleStaticDataValue[] getBatchCode() throws Exception,
	RuntimeException;
	
	// ��ȡboss�ʷ���������
	public IBOSaleStaticDataValue[] getBatchName() throws Exception,
	RuntimeException;
}
