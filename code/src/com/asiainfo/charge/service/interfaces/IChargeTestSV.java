package com.asiainfo.charge.service.interfaces;

import com.asiainfo.charge.ivalues.IBOChargeTestValue;

public interface IChargeTestSV {

	public void save(IBOChargeTestValue[] testRc, String flag) throws Exception;

	public IBOChargeTestValue[] getChargeTestsByOrderId(String chargeOrderId,
			String flag, int startNum, int endNum) throws Exception;

	public int getChargeTestCnByOrderId(String chargeOrderId, String flag)
			throws Exception;
}
