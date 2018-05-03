package com.asiainfo.charge.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.charge.dao.interfaces.IChargeTestDAO;
import com.asiainfo.charge.ivalues.IBOChargeTestValue;
import com.asiainfo.charge.service.interfaces.IChargeTestSV;

public class ChargeTestSVImpl implements IChargeTestSV {

	@Override
	public IBOChargeTestValue[] getChargeTestsByOrderId(String chargeOrderId,
			String flag, int startNum, int endNum) throws Exception {

		return ((IChargeTestDAO) ServiceFactory
				.getService(IChargeTestDAO.class)).getChargeTestsByOrderId(
				chargeOrderId, flag, startNum, endNum);
	}

	@Override
	public void save(IBOChargeTestValue[] testRc, String flag) throws Exception {

		((IChargeTestDAO) ServiceFactory.getService(IChargeTestDAO.class))
				.save(testRc, flag);
	}

	@Override
	public int getChargeTestCnByOrderId(String chargeOrderId, String flag)
			throws Exception {

		return ((IChargeTestDAO) ServiceFactory
				.getService(IChargeTestDAO.class)).getChargeTestCnByOrderId(
				chargeOrderId, flag);
	}

}
