package com.asiainfo.sale.activity.dao.interfaces;

import com.asiainfo.sale.activity.ivalues.IBoSaleEitAppriseValue;

public interface ISaleEitAppriseDAO {

	/**
	 * �������ȯӪ�����浥��Ϣ
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 */
	public String saveSaleEitApprise(IBoSaleEitAppriseValue SaleEitAppriseValue)
			throws Exception;

	/**
	 * ����Ӫ������id����浥���Ͳ�ѯ����ȯӪ�����浥��Ϣ
	 * 
	 * @param mainId
	 *            ���
	 * @return
	 * @throws Exception
	 */
	public IBoSaleEitAppriseValue getSaleEitAppriseByMainId(String mainId,
			String appriseType) throws Exception;

	/**
	 * ����Ӫ������id��ѯ����ȯӪ�����浥��Ϣ
	 * 
	 * @param mainId
	 * @return
	 * @throws Exception
	 */
	public IBoSaleEitAppriseValue[] getSaleEitApprisesByMainId(String mainId)
			throws Exception;

	/**
	 * ����oldMainId��������浥
	 * 
	 * @param mainId
	 * @throws Exception
	 */
	public void cloneEitAppriseByMainId(String oldMainId, String newMainId)
			throws Exception;
}
