package com.asiainfo.sale.activity.dao.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOSaleDetailGroupBySaleTypeValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleDetailValue;

public interface ISaleDetailDAO {

	/**
	 * 保存营销活动信息
	 * 
	 * @param saveSaleDetail
	 * @throws Exception
	 */
	public String saveSaleDetail(IBOSaleDetailValue[] saleDetailValues)
			throws Exception;

	/*
	 * 
	 */
	public String getNewSaleDetailId() throws Exception;

	/**
	 * 根据编号查询营销活动信息
	 * 
	 * @param id
	 *            编号
	 * @return
	 * @throws Exception
	 */
	public IBOSaleDetailValue getSaleDetailById(String id) throws Exception;

	/**
	 * 根据营销案编号查询营销活动信息
	 * 
	 * @param id
	 *            营销案编号
	 * @param startNum
	 *            分页开始页码
	 * @param endNum
	 *            分页结束页码
	 * @return
	 * @throws Exception
	 */
	public IBOSaleDetailValue[] getSaleDetailByMainId(String mainId,
			int startNum, int endNum) throws Exception;

	/**
	 * 根据营销案编号查询营销活动信息
	 * 
	 * @param id
	 *            营销案编号
	 * @param startNum
	 *            分页开始页码
	 * @param endNum
	 *            分页结束页码
	 * @return
	 * @throws Exception
	 */
	public int getCount(String mainId) throws Exception;

	/**
	 * 删除营销活动信息
	 * 
	 * @param SaleDetailValues
	 * @throws Exception
	 */
	public void delSaleDetail(IBOSaleDetailValue[] saleDetailValues)
			throws Exception;

	/**
	 * 查询营销活动案活动类型分类信息
	 * 
	 * @param mainId
	 *            活动编号
	 * @param startNum
	 *            分页开始页码
	 * @param endNum
	 *            分页结束页码
	 * @return
	 * @throws Exception
	 */
	public IBOSaleDetailGroupBySaleTypeValue[] getSaleDetailGroupBySaleTypeValues(
			String mainId, int startNum, int endNum) throws Exception;

	/**
	 * 查询营销活动案活动类型分类信息条数
	 * 
	 * @param mainId
	 *            活动编号
	 * @return
	 * @throws Exception
	 */
	public int getCountGroupBySaleType(String mainId) throws Exception;

	/**
	 * 根据活动类型查询营销活动信息
	 * 
	 * @param mainId
	 *            营销案编号
	 * @param saleFlag
	 *            活动类型
	 * @param startNum
	 *            分页开始页码
	 * @param endNum
	 *            分页结束页码
	 * @return
	 * @throws Exception
	 */
	public IBOSaleDetailValue[] getSaleDetailBySaleFlag(String mainId,
			String saleFlag, int startNum, int endNum) throws Exception;

	/**
	 * 查询营销案编号查询营销活动信息条数
	 * 
	 * @param mainId
	 *            营销案编号
	 * @param saleFlag
	 *            活动类型
	 * @return
	 * @throws Exception
	 */
	public int getCountBySaleFlag(String mainId, String saleFlag)
			throws Exception;

	/**
	 * 生成营销档次编码
	 * 
	 * @param saleDetailValue
	 * @return
	 * @throws Exception
	 */
	public String getSaleDetailCode(IBOSaleDetailValue saleDetailValue)
			throws Exception;

	/**
	 * 通过营销案申请mainId删除档次
	 */
	public void deleteSaleDetailByMainId(String mainId) throws Exception;

	/**
	 * 判断填写档次bossid是否存在相同的
	 */
	public boolean IsHasSameBossId(String levBossid, String orderId)
			throws Exception;
}
