package com.asiainfo.charge.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.StringUtils;
import com.asiainfo.charge.bo.BOChargeInfoEngine;
import com.asiainfo.charge.bo.BOChargeNodeDateEngine;
import com.asiainfo.charge.dao.interfaces.IChargeNodeDateDAO;
import com.asiainfo.charge.ivalues.IBOChargeNodeDateValue;

public class ChargeNodeDateDAOImpl implements IChargeNodeDateDAO {

	public void delChargeNodeDate(String mid) throws Exception{
		IBOChargeNodeDateValue[] chargeNodeDateValue=this.getChargeNodeDateValuesByChargeId(mid);
		if(chargeNodeDateValue.length>0){
			for (int i = 0; i < chargeNodeDateValue.length; i++) {
				//chargeNodeDateValue[i].delete();
			}
		}
		BOChargeNodeDateEngine.save(chargeNodeDateValue);
	}
	@Override
	public IBOChargeNodeDateValue[] getChargeNodeDateValuesByChargeId(
			String chargeId) throws Exception {
		if (StringUtils.isNotBlank(chargeId)) {
			Map parameter = new HashMap();
			StringBuffer condition = new StringBuffer(" 1 = 1 ");
			condition.append(" AND " + IBOChargeNodeDateValue.S_ChargeId + " = :chargeId");
			parameter.put("chargeId", chargeId);
			return BOChargeNodeDateEngine.getBeans(condition.toString(), parameter);
		} else {
			return new IBOChargeNodeDateValue[0];
		}
	}

	@Override
	public void saveChargeNodeDate(IBOChargeNodeDateValue chargeNodeDateValue)
			throws Exception {
		BOChargeNodeDateEngine.save(chargeNodeDateValue);
	}
}
