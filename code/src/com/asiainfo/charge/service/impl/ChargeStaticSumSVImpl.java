package com.asiainfo.charge.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.charge.bo.BOChargeStaticSumBean;
import com.asiainfo.charge.dao.interfaces.IChargeStaticSumDAO;
import com.asiainfo.charge.ivalues.IBOChargeStaticSumShowValue;
import com.asiainfo.charge.service.interfaces.IChargeStaticSumSV;

public class ChargeStaticSumSVImpl implements IChargeStaticSumSV {

	@Override
	public void save(String sums) throws Exception {

		((IChargeStaticSumDAO) ServiceFactory
				.getService(IChargeStaticSumDAO.class)).save(sums);
	}

	@Override
	public IBOChargeStaticSumShowValue[] getStaticSumByGrandId(String grandId)
			throws Exception {

		return ((IChargeStaticSumDAO) ServiceFactory
				.getService(IChargeStaticSumDAO.class))
				.getStaticSumByGrandId(grandId);
	}

	@Override
	public int getStaticSumCount(String grandId) throws Exception {

		return ((IChargeStaticSumDAO) ServiceFactory
				.getService(IChargeStaticSumDAO.class))
				.getStaticSumCount(grandId);
	}

	@Override
	public String getSaveRecords(String grandId) throws Exception {

		return ((IChargeStaticSumDAO) ServiceFactory
				.getService(IChargeStaticSumDAO.class))
				.getSaveRecords(grandId);
	}

	@Override
	public BOChargeStaticSumBean[] getStaticSumValueByGrandId(String grandId)
			throws Exception {

		return ((IChargeStaticSumDAO) ServiceFactory
				.getService(IChargeStaticSumDAO.class))
				.getStaticSumValueByGrandId(grandId);
	}

}
