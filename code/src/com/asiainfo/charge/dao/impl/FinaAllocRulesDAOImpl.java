package com.asiainfo.charge.dao.impl;

import java.util.HashMap;

import com.asiainfo.charge.bo.BOFinaAllocRulesEngine;
import com.asiainfo.charge.dao.interfaces.IFinaAllocRulesDAO;
import com.asiainfo.charge.ivalues.IBOBillingCheckValue;
import com.asiainfo.charge.ivalues.IBOFinaAllocRulesValue;

public class FinaAllocRulesDAOImpl implements IFinaAllocRulesDAO {
	//根据资费ID删除
	public void delFinaAllocRules(String chargeId)
	throws Exception {
		IBOFinaAllocRulesValue[] finaAllocRulesValue=this.queryFinaAllocRules(chargeId);
		if(finaAllocRulesValue.length>0){
			for(int i=0;i<finaAllocRulesValue.length;i++){
				finaAllocRulesValue[i].delete();
			}
			BOFinaAllocRulesEngine.save(finaAllocRulesValue);
		}
	}
	/**
	 * 保存财务分摊规则信息
	 * 
	 * @param finaAllocRulesValue
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public String saveFinaAllocRulesInfo(
			IBOFinaAllocRulesValue finaAllocRulesValue) throws Exception {

		if (finaAllocRulesValue != null) {
			// 新增，需要取ID
			if (finaAllocRulesValue.isNew()) {
				finaAllocRulesValue.setId(BOFinaAllocRulesEngine.getNewId()
						.toString());
				finaAllocRulesValue.setStsToNew();
			}

			BOFinaAllocRulesEngine.save(finaAllocRulesValue);
			return finaAllocRulesValue.getId();
		}
		return null;
	}

	/**
	 * 根据chargeId查询财务分摊规则信息
	 * 
	 * @param chargeId
	 * @return
	 * @throws Exception
	 */
	public IBOFinaAllocRulesValue[] queryFinaAllocRules(String chargeId)
			throws Exception {
		HashMap<String, String> parameter = new HashMap<String, String>();
		
		StringBuffer sqlCondition = new StringBuffer();
		sqlCondition.append("1=1");
		
		if (!chargeId.equals("")) {
			sqlCondition.append(" and " + IBOFinaAllocRulesValue.S_ChargeId
					+ " =:chargeId");
			parameter.put("chargeId", chargeId);
		}
		
		return BOFinaAllocRulesEngine.getBeans(sqlCondition.toString(), parameter);
	}

}
