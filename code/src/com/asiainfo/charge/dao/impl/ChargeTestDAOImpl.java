package com.asiainfo.charge.dao.impl;

import com.asiainfo.charge.bo.BOBusiSurpConfEngine;
import com.asiainfo.charge.bo.BOChargeTestEngine;
import com.asiainfo.charge.dao.interfaces.IChargeTestDAO;
import com.asiainfo.charge.ivalues.IBOChargeTestValue;

public class ChargeTestDAOImpl implements IChargeTestDAO {

	@Override
	public IBOChargeTestValue[] getChargeTestsByOrderId(String chargeOrderId,
			String flag, int startNum, int endNum) throws Exception {
		String condition = " order_id = " + chargeOrderId + " and flag='"
				+ flag + "'";
		return BOChargeTestEngine.getBeans(null, condition, null, startNum,
				endNum, false);
	}

	@Override
	public void save(IBOChargeTestValue[] testRc, String flag) throws Exception {
		if (testRc != null) {
			for (int i = 0; i < testRc.length; ++i) {
				if (testRc[i].isNew()) {
					testRc[i].setId(BOBusiSurpConfEngine.getNewId().intValue());
					testRc[i].setFlag(flag);
				}
			}
			BOChargeTestEngine.save(testRc);
		}
	}

	@Override
	public int getChargeTestCnByOrderId(String chargeOrderId, String flag)
			throws Exception {

		String condition = " order_id = " + chargeOrderId + " and flag='"
				+ flag + "'";
		return BOChargeTestEngine.getBeansCount(condition, null);
	}

}
