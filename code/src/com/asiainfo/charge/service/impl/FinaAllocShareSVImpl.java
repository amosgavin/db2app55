package com.asiainfo.charge.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.charge.dao.interfaces.IFinaAllocShareDAO;
import com.asiainfo.charge.ivalues.IBOFinalShareValue;
import com.asiainfo.charge.service.interfaces.IFinaAllocShareSV;

public class FinaAllocShareSVImpl implements IFinaAllocShareSV {

	/**
	 * 保存财务分摊规则信息
	 * 
	 * @param finaAllocShareValue
	 * @return
	 * @throws Exception
	 * @throws RuntimeException
	 */
	public Long saveFinaAllocShareInfo(IBOFinalShareValue[] finaAllocShareValues)
			throws Exception, RuntimeException {
		IFinaAllocShareDAO finaAllocShareDAO = (IFinaAllocShareDAO) ServiceFactory
				.getService(IFinaAllocShareDAO.class);
		return finaAllocShareDAO.saveFinaAllocShareInfo(finaAllocShareValues);
	}

	/**
	 * 根据chargeId查询财务分摊规则信息
	 * 
	 * @param chargeId
	 * @return
	 * @throws Exception
	 */
	public IBOFinalShareValue[] queryFinaAllocShare(String chargeId)
			throws Exception {
		IFinaAllocShareDAO finaAllocShareDAO = (IFinaAllocShareDAO) ServiceFactory
				.getService(IFinaAllocShareDAO.class);
		return finaAllocShareDAO.queryFinaAllocShare(chargeId);
	}

	@Override
	public boolean haveEmptyFinalShareInCharge(String orderId) throws Exception {

		return ((IFinaAllocShareDAO) ServiceFactory
				.getService(IFinaAllocShareDAO.class))
				.haveEmptyFinalShareInCharge(orderId);
	}

}
