package com.asiainfo.charge.dao.impl;

import java.util.HashMap;

import com.asiainfo.charge.bo.BOChargeInfoEngine;
import com.asiainfo.charge.bo.BOFinalShareEngine;
import com.asiainfo.charge.dao.interfaces.IFinaAllocShareDAO;
import com.asiainfo.charge.ivalues.IBOFinalShareValue;

public class FinaAllocShareDAOImpl implements IFinaAllocShareDAO {
	// 根据资费ID删除
	public void delFinaAllocShare(String chargeId) throws Exception {
		IBOFinalShareValue[] finaAllocShareValue = this
				.queryFinaAllocShare(chargeId);
		if (finaAllocShareValue.length > 0) {
			for (int i = 0; i < finaAllocShareValue.length; i++) {
				finaAllocShareValue[i].delete();
			}
			BOFinalShareEngine.save(finaAllocShareValue);
		}
	}

	/**
	 * 保存财务分摊规则信息
	 * 
	 * @param finaAllocShareValue
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public Long saveFinaAllocShareInfo(IBOFinalShareValue[] finaAllocShareValues)
			throws Exception {

		if (finaAllocShareValues != null && finaAllocShareValues.length >=1) {
			// 新增，需要取ID
			for (IBOFinalShareValue allocShare : finaAllocShareValues) {

				if (allocShare.isNew()) {
					allocShare.setId(BOFinalShareEngine.getNewId().intValue());
					allocShare.setStsToNew();
				}
			}
			BOFinalShareEngine.save(finaAllocShareValues);
		}
		return 0L;
	}

	/**
	 * 根据chargeId查询财务分摊规则信息
	 * 
	 * @param chargeId
	 * @return
	 * @throws Exception
	 */
	public IBOFinalShareValue[] queryFinaAllocShare(String chargeId)
			throws Exception {
		HashMap<String, String> parameter = new HashMap<String, String>();

		StringBuffer sqlCondition = new StringBuffer();
		sqlCondition.append(" 1=1 ");

		if (!chargeId.equals("")) {
			sqlCondition.append(" and " + IBOFinalShareValue.S_ChargeId
					+ " =:chargeId");
			parameter.put("chargeId", chargeId);
		}
		return BOFinalShareEngine.getBeans(sqlCondition.toString(), parameter);
	}

	@Override
	public boolean haveEmptyFinalShareInCharge(String orderId) throws Exception {

		String condition = " apply_id IN (SELECT cm.apply_id FROM HBSALE.CHARGE_APPLY_MAIN_T cm WHERE cm.main_id = '"
				+ orderId
				+ "') AND mid NOT IN (SELECT charge_id FROM HBSALE.CHARGE_FINALLOCATION_SHARE)";
		return BOChargeInfoEngine.getBeansCount(condition, null) >= 1 ? true
				: false;
	}
}
