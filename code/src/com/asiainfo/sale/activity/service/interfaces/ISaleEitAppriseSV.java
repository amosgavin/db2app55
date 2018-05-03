package com.asiainfo.sale.activity.service.interfaces;

import com.asiainfo.sale.activity.ivalues.IBoSaleEitAppriseValue;

public interface ISaleEitAppriseSV {

	/**
	 * 保存电子券营销活动申告单信息
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 */
	public String saveSaleEitApprise(IBoSaleEitAppriseValue SaleEitAppriseValue)
			throws Exception;

	/**
	 * 根据营销案主id查询电子券营销活动申告单信息
	 * 
	 * @param mainId
	 *            编号
	 * @return
	 * @throws Exception
	 */
	public IBoSaleEitAppriseValue getSaleEitAppriseByMainId(String mainId,
			String appriseType) throws Exception;

}
