package com.asiainfo.sale.activity.dao.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOSaleHbHbValue;

public interface ISaleHbHbDAO {

	/**
	 * �������ȯӪ����Ͱ������Ϣ
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 */
	public String saveSaleHbHb(IBOSaleHbHbValue SaleHbHbValue)
			throws Exception;

	/**
	 * ����Ӫ������id���Ͱ�������Ͳ�ѯ����ȯӪ����Ͱ������Ϣ
	 * 
	 * @param mainId
	 *            ���
	 * @return
	 * @throws Exception
	 */
	public IBOSaleHbHbValue getSaleHbHbByMainId(String mainId) throws Exception;

	/**
	 * ����Ӫ������id��ѯ����ȯӪ����Ͱ������Ϣ
	 * 
	 * @param mainId
	 * @return
	 * @throws Exception
	 */
	public IBOSaleHbHbValue[] getSaleHbHbsByMainId(String mainId)
			throws Exception;

	/**
	 * ����oldMainId�����кͰ����
	 * 
	 * @param mainId
	 * @throws Exception
	 */
	public void cloneHbHbByMainId(String oldMainId, String newMainId)
			throws Exception;
}
