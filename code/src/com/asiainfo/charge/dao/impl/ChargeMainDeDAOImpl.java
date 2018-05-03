package com.asiainfo.charge.dao.impl;

import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.StringUtils;
import com.asiainfo.charge.bo.BOChargeInfoEngine;
import com.asiainfo.charge.dao.interfaces.IChargeMainDeDAO;
import com.asiainfo.charge.ivalues.IBOChargeInfoValue;



public class ChargeMainDeDAOImpl implements IChargeMainDeDAO{
	
	public String saveChargeMainDe(IBOChargeInfoValue chargeMainValue)
	throws Exception, RuntimeException {
		if(chargeMainValue != null)
		{
			// 新增，需要取ID
			if(chargeMainValue.isNew())
			{
				chargeMainValue.setMid(BOChargeInfoEngine.getNewId().toString());
				chargeMainValue.setExt6(1); //新增资费档次，展示的资费结构树也是新的。
				chargeMainValue.setStsToNew();
				BOChargeInfoEngine.save(chargeMainValue);
			}else if(chargeMainValue.isDeleted()){
				chargeMainValue.unDelete();
				chargeMainValue.setIsDelete("1");
				BOChargeInfoEngine.save(chargeMainValue);
			}else{
				BOChargeInfoEngine.save(chargeMainValue);
			}
			
			return chargeMainValue.getApplyId();
		}
		return null;
		}

	@Override
	public IBOChargeInfoValue IChargeMainDeshow(String id) throws Exception, RuntimeException {
		if(StringUtils.isNotBlank(id)){
			return BOChargeInfoEngine.getBean(id); 
		}
		return null;
	}
}
