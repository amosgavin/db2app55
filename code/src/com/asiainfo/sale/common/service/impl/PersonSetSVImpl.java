package com.asiainfo.sale.common.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.common.dao.interfaces.IPersonSetDAO;
import com.asiainfo.sale.common.service.interfaces.IPersonSetSV;

public class PersonSetSVImpl implements IPersonSetSV {

	@Override
	public void savePersonInfo(int operatorId, String isReceiveSMS,
			String isReceiveSysInfo) throws Exception {

		((IPersonSetDAO) ServiceFactory.getService(IPersonSetDAO.class))
				.savePersonInfo(operatorId, isReceiveSMS, isReceiveSysInfo);
	}

	@Override
	public boolean isReceiveSMS(int operatorId) throws Exception {

		return ((IPersonSetDAO) ServiceFactory.getService(IPersonSetDAO.class))
				.isReceiveSMS(operatorId);
	}
}
