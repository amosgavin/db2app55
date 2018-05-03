package com.asiainfo.charge.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.charge.dao.interfaces.IChargeMainDeDAO;
import com.asiainfo.charge.ivalues.IBOChargeInfoValue;
import com.asiainfo.charge.service.interfaces.IChargeMainDeSV;

public class ChargeMainDeSVImpl implements IChargeMainDeSV{
	
	public String saveChargeMainDe(IBOChargeInfoValue chargeMainValue)
	throws Exception, RuntimeException{
		IChargeMainDeDAO chargeMainDAO = (IChargeMainDeDAO) ServiceFactory
		.getService(IChargeMainDeDAO.class);
		return chargeMainDAO.saveChargeMainDe(chargeMainValue);
	}

	@Override
	public IBOChargeInfoValue IChargeMainDeshow(String id) throws Exception, RuntimeException {
		IChargeMainDeDAO chargeMainDAO = (IChargeMainDeDAO) ServiceFactory
		.getService(IChargeMainDeDAO.class);
		 return chargeMainDAO.IChargeMainDeshow(id);
	}
	
	
}
