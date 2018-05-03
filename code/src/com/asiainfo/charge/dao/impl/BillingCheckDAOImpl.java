package com.asiainfo.charge.dao.impl;

import java.util.HashMap;

import com.asiainfo.charge.bo.BOBillingCheckEngine;
import com.asiainfo.charge.bo.BOChargeStaticSumEngine;
import com.asiainfo.charge.dao.interfaces.IBillingCheckDAO;
import com.asiainfo.charge.ivalues.IBOBillingCheckValue;

public class BillingCheckDAOImpl implements IBillingCheckDAO {
	
	//根据资费档次ID删除
	public void delBillingCheckInfo(String chargeId,
			int startNum, int endNum) throws Exception {
		IBOBillingCheckValue[] billingCheckValue=this.queryBillingCheckInfo(chargeId, -1, -1);
		if(billingCheckValue.length>0){
			for (int i = 0; i < billingCheckValue.length; i++) {
				billingCheckValue[i].delete();
			}
			BOBillingCheckEngine.save(billingCheckValue);
		}
	}
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
		IBOBillingCheckValue[] billingCheckList;
		HashMap<String, String> parameter = new HashMap<String, String>();

		StringBuffer sqlCondition = new StringBuffer();
		sqlCondition.append("1=1");

		if (!chargeId.equals("")) {
			sqlCondition.append(" and " + IBOBillingCheckValue.S_ChargeId
					+ " =:chargeId");
			parameter.put("chargeId", chargeId);
		}

		sqlCondition.append("order by id");

		billingCheckList = BOBillingCheckEngine.getBeans(null, sqlCondition
				.toString(), parameter, startNum, endNum, false);
		return billingCheckList;
	}

	/**
	 * 获取资费对比总记录数
	 * 
	 * @param chargeId
	 *            资费ID
	 * @return
	 * @throws Exception
	 */
	public int countBillingCheckInfo(String chargeId) throws Exception {
		StringBuffer sqlCondition = new StringBuffer("1=1");
		HashMap<String, String> parameter = new HashMap<String, String>();

		if (!chargeId.equals("")) {
			sqlCondition.append(" and " + IBOBillingCheckValue.S_ChargeId
					+ " =:chargeId");
			parameter.put("chargeId", chargeId);
		}

		return BOBillingCheckEngine.getBeansCount(sqlCondition.toString(),
				parameter);
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
		for (int i = 0; i < billingCheckValues.length; i++) {
			if (billingCheckValues[i].isNew()) {
				billingCheckValues[i].setId(BOBillingCheckEngine.getNewId()
						.toString());
				billingCheckValues[i].setStsToNew();
			}
		}
		BOBillingCheckEngine.save(billingCheckValues);
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
		if (billingCheckValues != null) {
			// 新增，需要取ID
			if (billingCheckValues.isNew()) {
				billingCheckValues.setId(BOBillingCheckEngine.getNewId()
						.toString());
				billingCheckValues.setStsToNew();
			}

			BOBillingCheckEngine.save(billingCheckValues);
			return billingCheckValues.getId();
		}
		return null;
	}
}
