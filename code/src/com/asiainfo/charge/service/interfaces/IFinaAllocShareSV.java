package com.asiainfo.charge.service.interfaces;

import com.asiainfo.charge.ivalues.IBOFinalShareValue;

public interface IFinaAllocShareSV {

	/**
	 * 保存财务分摊规则信息
	 * 
	 * @param finaAllocShareValue
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public Long saveFinaAllocShareInfo(IBOFinalShareValue[] finaAllocShareValues)
			throws Exception, RuntimeException;

	/**
	 * 根据chargeId查询财务分摊规则信息
	 * 
	 * @param chargeId
	 * @return
	 * @throws Exception
	 */
	public IBOFinalShareValue[] queryFinaAllocShare(String chargeId)
			throws Exception;

	/**
	 * 判断是否每个资费明细都填写了财务分摊规则
	 * 
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public boolean haveEmptyFinalShareInCharge(String orderId) throws Exception;

}
