package com.asiainfo.sale.common.dao.interfaces;

import com.asiainfo.sale.common.ivalues.IBOSaleStaticDataValue;

public interface ISaleStaticDataDAO {

	/**
	 * ��ȡ��̬����
	 * 
	 * @param codeType
	 * @return IBOSecStaticDataValue[]
	 * @throws Exception
	 * @throws RemoteException
	 */
	public IBOSaleStaticDataValue[] getSaleStaticData(String codeType)
			throws Exception;

	/**
	 * ���Ӿ�̬�������ͺͱ�Ż�ȡ����
	 * 
	 * @param codeType
	 *            long
	 * @param codeId
	 *            long
	 * @throws Exception
	 * @throws RemoteException
	 * @return ISysStaticDataValue[]
	 */
	public IBOSaleStaticDataValue getSaleStaticData(String codeType, String codeId)
			throws Exception;
	
	/**
	 * ��ʼ������
	 * 
	 * @throws Exception
	 */
	public void initCache() throws Exception;
	 //��ѯר��
	 public IBOSaleStaticDataValue[] getSaleStaticDatas( String codeType ,String name) throws Exception;
	 
	 public int queryStaticDateCount(String codeType ,String name)throws Exception;
}
