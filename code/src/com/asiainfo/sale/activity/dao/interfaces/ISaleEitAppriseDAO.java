package com.asiainfo.sale.activity.dao.interfaces;

import com.asiainfo.sale.activity.ivalues.IBoSaleEitAppriseValue;

public interface ISaleEitAppriseDAO {

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
	 * 根据营销案主id、申告单类型查询电子券营销活动申告单信息
	 * 
	 * @param mainId
	 *            编号
	 * @return
	 * @throws Exception
	 */
	public IBoSaleEitAppriseValue getSaleEitAppriseByMainId(String mainId,
			String appriseType) throws Exception;

	/**
	 * 根据营销案主id查询电子券营销活动申告单信息
	 * 
	 * @param mainId
	 * @return
	 * @throws Exception
	 */
	public IBoSaleEitAppriseValue[] getSaleEitApprisesByMainId(String mainId)
			throws Exception;

	/**
	 * 复制oldMainId的所有申告单
	 * 
	 * @param mainId
	 * @throws Exception
	 */
	public void cloneEitAppriseByMainId(String oldMainId, String newMainId)
			throws Exception;
}
