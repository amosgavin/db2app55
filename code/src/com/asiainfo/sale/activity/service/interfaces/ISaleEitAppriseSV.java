package com.asiainfo.sale.activity.service.interfaces;

import com.asiainfo.sale.activity.ivalues.IBoSaleEitAppriseValue;

public interface ISaleEitAppriseSV {

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
	 * ����Ӫ������id��ѯ����ȯӪ�����浥��Ϣ
	 * 
	 * @param mainId
	 *            ���
	 * @return
	 * @throws Exception
	 */
	public IBoSaleEitAppriseValue getSaleEitAppriseByMainId(String mainId,
			String appriseType) throws Exception;

}
