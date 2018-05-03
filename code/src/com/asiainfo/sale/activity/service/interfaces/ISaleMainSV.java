package com.asiainfo.sale.activity.service.interfaces;

import com.asiainfo.sale.activity.ivalues.IBOSaleMainValue;

public interface ISaleMainSV {

	/**
	 * 保存一个营销案信息
	 * 
	 * @param saleMainValue
	 * @return 操作员编号 0 失败
	 * @throws Exception
	 */
	public String saveSaleMain(IBOSaleMainValue saleMainValue)
			throws Exception, RuntimeException;

	/**
	 * 保存营销案信息
	 * 
	 * @param SaleMainValues
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void saveSaleMain(IBOSaleMainValue[] saleMainValues)
			throws Exception, RuntimeException;

	/**
	 * 根据订单编号查询营销案信息
	 * 
	 * @param id
	 *            编号
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleMainValue getSaleMainById(String id) throws Exception,
			RuntimeException;

	/**
	 * 根据营销案名称、申请人名称、组织机构查询营销案信息
	 * 
	 * @param name
	 *            营销案名称
	 * @param applicant
	 *            申请人名称
	 * @param org
	 *            组织机构
	 * @param startNum
	 *            分页开始页码
	 * @param endNum
	 *            分页结束页码
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public IBOSaleMainValue[] getSaleMain(String name, String applicant,
			String org, int startNum, int endNum) throws Exception,
			RuntimeException;

	/**
	 * 根据营销案名称、申请人名称、组织机构查询营销案条数
	 * 
	 * @param name
	 *            营销案名称
	 * @param applicant
	 *            申请人名称
	 * @param org
	 *            组织机构
	 * @param startNum
	 *            分页开始页码
	 * @param endNum
	 *            分页结束页码
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public int getCount(String name, String applicant, String org)
			throws Exception, RuntimeException;

	/**
	 * 删除营销案信息
	 * 
	 * @param SaleMainValues
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void delSaleMain(IBOSaleMainValue[] saleMainValues)
			throws Exception, RuntimeException;

	/**
	 * 设置武器状态（电子券武器只能使用一次，需要在提交流程后调用此方法更新状态）
	 * 
	 * @param mainId
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void setWeaponState(String mainId) throws Exception,
			RuntimeException;

	/**
	 * 复制营销案
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void cloneSaleMain(String mainId, String orderId) throws Exception,
			RuntimeException;

	/**
	 * 同意-修改营销案状态
	 * 
	 * @param mainId
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void changeStsToAgreen(String mainId) throws Exception,
			RuntimeException;

	/**
	 * 不同意-修改营销案状态
	 * 
	 * @param mainId
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void changeStsToNo(String mainId) throws Exception, RuntimeException;

	/**
	 * 删除营销案申请信息
	 * 
	 * @param mainId
	 * @throws Exception
	 */
	public void deleteSaleMainByMainId(String mainId) throws Exception;

	public void changeStsTo(String mainId, String state) throws Exception,
			RuntimeException;

	public String getNewACTCode(IBOSaleMainValue saleMain) throws Exception,
			RuntimeException;

	/**
	 * 判断填写批次bossid是否存在相同的
	 * 
	 * @param actBossid
	 * @return
	 * @throws Exception
	 */
	public boolean IsHasSameBossId(String actBossid, String orderId)
			throws Exception;

	/**
	 * 检查所有批次手否都填写了财务和业务稽核方案
	 * 
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public boolean hasEmptyExplantStatistic(String orderId) throws Exception;

	/**
	 * 检查所有包含电子券的批次都填写了电子申告单
	 * 
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public boolean hasEitAppriseToWrite(String orderId) throws Exception;
	
	/**
	 * 判断营销活动是否包含电子券
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public boolean hasEitInSale(String orderId) throws Exception;

	public String checksalemaintype(String orderId) throws Exception;
	/**
	 * 判断营销案的活动类型
	 * 
	 */
}
