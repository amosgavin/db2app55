package com.asiainfo.charge.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.charge.dao.interfaces.IChargeInfoExtDAO;
import com.asiainfo.charge.ivalues.IBOChargeInfoExtValue;
import com.asiainfo.charge.service.interfaces.IChargeInfoExtSV;

public class ChargeInfoExtSVImpl implements IChargeInfoExtSV {

	@Override
	public IBOChargeInfoExtValue[] getChargeInfoExt(String applyId,
			String type)throws Exception{
		
		return getDao().getChargeInfoExt( applyId, type);
	
	}
	
	IChargeInfoExtDAO getDao()throws Exception{
		return (IChargeInfoExtDAO) ServiceFactory.getService(IChargeInfoExtDAO.class);
	}

	@Override
	public void saveChargeInfoExt(IBOChargeInfoExtValue[] infoExtValues)
			throws Exception {
		getDao().saveChargeInfoExt(infoExtValues);
		
	}
	
	
	
	
	

}
