package com.asiainfo.sale.activity.service.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOSaleHbHbValue;

public interface ISaleHbHbSV {

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
	 * ����Ӫ������id��ѯ����ȯӪ����Ͱ������Ϣ
	 * 
	 * @param mainId
	 *            ���
	 * @return
	 * @throws Exception
	 */
	public IBOSaleHbHbValue getSaleHbHbByMainId(String mainId) throws Exception;

}
