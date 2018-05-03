package com.asiainfo.charge.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.charge.dao.interfaces.IBillingCheckDAO;
import com.asiainfo.charge.ivalues.IBOBillingCheckValue;
import com.asiainfo.charge.service.interfaces.IBillingCheckSV;

public class BillingCheckSVImpl implements IBillingCheckSV {

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
			int startNum, int endNum) throws Exception {
		IBOBillingCheckValue[] billingCheck = null;

		billingCheck = ((IBillingCheckDAO) ServiceFactory
				.getService(IBillingCheckDAO.class)).queryBillingCheckInfo(
				chargeId, startNum, endNum);

		return billingCheck;
	}

	/**
	 * 根据资费ID获取资费对比总记录数
	 * 
	 * @param chargeId
	 *            资费ID
	 * @return
	 * @throws Exception
	 */
	public int countBillingCheckInfo(String chargeId) throws Exception {
		int cnt = ((IBillingCheckDAO) ServiceFactory
				.getService(IBillingCheckDAO.class))
				.countBillingCheckInfo(chargeId);

		return cnt;
	}

	/**
	 * 保存资费对比信息（多个billingCheckValues对象）
	 * 
	 * @param billingCheckValues
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public void saveBillingCheckInfo(IBOBillingCheckValue[] billingCheckValues)
			throws Exception, RuntimeException {
		IBillingCheckDAO billingCheckDAO = (IBillingCheckDAO) ServiceFactory
				.getService(IBillingCheckDAO.class);
		billingCheckDAO.saveBillingCheckInfo(billingCheckValues);

	}

	/**
	 * 保存资费对比信息（单个billingCheckValues对象）
	 * 
	 * @param billingCheckValues
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public String saveBillingCheckInfo(IBOBillingCheckValue billingCheckValues)
			throws Exception, RuntimeException {
		IBillingCheckDAO billingCheckDAO = (IBillingCheckDAO) ServiceFactory
				.getService(IBillingCheckDAO.class);
		return billingCheckDAO.saveBillingCheckInfo(billingCheckValues);
	}

}
