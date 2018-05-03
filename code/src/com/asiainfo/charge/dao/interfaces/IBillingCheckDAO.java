package com.asiainfo.charge.dao.interfaces;

import com.asiainfo.charge.ivalues.IBOBillingCheckValue;

public interface IBillingCheckDAO {

	/**
	 * 根据资费ID查询资费对比信息
	 * 
	 * @param chargeId
	 *            资费ID
	 * @param startNum
	 *            分页记录开始索引
	 * @param endNum
	 *            分页记录结束索引
	 * @return
	 * @throws Exception
	 */
	public IBOBillingCheckValue[] queryBillingCheckInfo(String chargeId,
			int startNum, int endNum) throws Exception;

	/**
	 * 获取财务分摊规则信息总记录数
	 * 
	 * @param chargeId
	 *            资费ID
	 * @return
	 * @throws Exception
	 */
	public int countBillingCheckInfo(String chargeId) throws Exception;

	/**
	 * 保存资费对比信息（多个billingCheckValues对象）
	 * 
	 * @param billingCheckValues
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void saveBillingCheckInfo(IBOBillingCheckValue[] billingCheckValues)
			throws Exception, RuntimeException;

	/**
	 * 保存资费对比信息（单个billingCheckValues对象）
	 * 
	 * @param billingCheckValues
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public String saveBillingCheckInfo(IBOBillingCheckValue billingCheckValues)
			throws Exception, RuntimeException;

}
