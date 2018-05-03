package com.asiainfo.sale.activity.dao.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOSaleHbHbValue;

public interface ISaleHbHbDAO {

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
	 * 根据营销案主id、和包红包类型查询电子券营销活动和包红包信息
	 * 
	 * @param mainId
	 *            编号
	 * @return
	 * @throws Exception
	 */
	public IBOSaleHbHbValue getSaleHbHbByMainId(String mainId) throws Exception;

	/**
	 * 根据营销案主id查询电子券营销活动和包红包信息
	 * 
	 * @param mainId
	 * @return
	 * @throws Exception
	 */
	public IBOSaleHbHbValue[] getSaleHbHbsByMainId(String mainId)
			throws Exception;

	/**
	 * 复制oldMainId的所有和包红包
	 * 
	 * @param mainId
	 * @throws Exception
	 */
	public void cloneHbHbByMainId(String oldMainId, String newMainId)
			throws Exception;
}
