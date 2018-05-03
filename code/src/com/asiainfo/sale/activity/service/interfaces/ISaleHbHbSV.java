package com.asiainfo.sale.activity.service.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOSaleHbHbValue;

public interface ISaleHbHbSV {

	/**
	 * 保存电子券营销活动和包红包信息
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 */
	public String saveSaleHbHb(IBOSaleHbHbValue SaleHbHbValue)
			throws Exception;

	/**
	 * 根据营销案主id查询电子券营销活动和包红包信息
	 * 
	 * @param mainId
	 *            编号
	 * @return
	 * @throws Exception
	 */
	public IBOSaleHbHbValue getSaleHbHbByMainId(String mainId) throws Exception;

}
