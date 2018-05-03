package com.asiainfo.charge.dao.interfaces;

import com.asiainfo.charge.ivalues.IBOChargeInfoValue;

public interface IChargeMainDeDAO {
	
	public String saveChargeMainDe(IBOChargeInfoValue chargeMainValue)
	throws Exception, RuntimeException;
	
	public IBOChargeInfoValue IChargeMainDeshow(String id) 
	throws Exception, RuntimeException ;
}
