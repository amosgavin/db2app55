package com.asiainfo.sale.activity.service.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOSaleDetailGroupBySaleTypeValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleDetailValue;

public interface ISaleDetailSV {

	/**
	 * 保存营销活动信息
	 * 
	 * @param saveSaleDetail
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public String saveSaleDetail(IBOSaleDetailValue[] saleDetailValues)
			throws Exception, RuntimeException;

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
	 * @throws RuntimeException
	 */
	public IBOSaleDetailValue getSaleDetailById(String id) throws Exception,
			RuntimeException;

	/**
	 * 根据营销案编号查询营销活动信息
	 * 
	 * @param mainId
	 *            活动编号
	 * @param startNum
	 *            分页开始页码
	 * @param endNum
	 *            分页结束页码
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleDetailValue[] getSaleDetailByMainId(String mainId,
			int startNum, int endNum) throws Exception, RuntimeException;

	/**
	 * 查询营销案编号查询营销活动信息条数
	 * 
	 * @param mainId
	 *            活动编号
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getCount(String mainId) throws Exception, RuntimeException;

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
	 * @throws RuntimeException
	 */
	public IBOSaleDetailValue[] getSaleDetailBySaleFlag(String mainId,
			String saleFlag, int startNum, int endNum) throws Exception,
			RuntimeException;

	/**
	 * 查询营销案编号查询营销活动信息条数
	 * 
	 * @param mainId
	 *            营销案编号
	 * @param saleFlag
	 *            活动类型
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getCountBySaleFlag(String mainId, String saleFlag)
			throws Exception, RuntimeException;

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
	 * @throws RuntimeException
	 */
	public IBOSaleDetailGroupBySaleTypeValue[] getSaleDetailGroupBySaleTypeValues(
			String mainId, int startNum, int endNum) throws Exception,
			RuntimeException;

	/**
	 * 查询营销活动案活动类型分类信息条数
	 * 
	 * @param mainId
	 *            活动编号
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getCountGroupBySaleType(String mainId) throws Exception,
			RuntimeException;

	/**
	 * 删除营销活动信息
	 * 
	 * @param SaleDetailValues
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void delSaleDetail(IBOSaleDetailValue[] saleDetailValues)
			throws Exception, RuntimeException;

	/**
	 * 判断填写档次bossid是否存在相同的
	 */
	public boolean IsHasSameBossId(String levBossid, String orderId)
			throws Exception;
}
