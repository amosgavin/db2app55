package com.asiainfo.charge.dao.impl;

import java.util.HashMap;

import com.asiainfo.charge.bo.BOFinaAllocRulesEngine;
import com.asiainfo.charge.dao.interfaces.IFinaAllocRulesDAO;
import com.asiainfo.charge.ivalues.IBOBillingCheckValue;
import com.asiainfo.charge.ivalues.IBOFinaAllocRulesValue;

public class FinaAllocRulesDAOImpl implements IFinaAllocRulesDAO {
	//�����ʷ�IDɾ��
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
	 * ��������̯������Ϣ
	 * 
	 * @param finaAllocRulesValue
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public String saveFinaAllocRulesInfo(
			IBOFinaAllocRulesValue finaAllocRulesValue) throws Exception {

		if (finaAllocRulesValue != null) {
			// ��������ҪȡID
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
	 * ����chargeId��ѯ�����̯������Ϣ
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
