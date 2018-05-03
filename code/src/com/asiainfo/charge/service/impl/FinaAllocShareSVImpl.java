package com.asiainfo.charge.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.charge.dao.interfaces.IFinaAllocShareDAO;
import com.asiainfo.charge.ivalues.IBOFinalShareValue;
import com.asiainfo.charge.service.interfaces.IFinaAllocShareSV;

public class FinaAllocShareSVImpl implements IFinaAllocShareSV {

	/**
	 * ��������̯������Ϣ
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
	 * ����chargeId��ѯ�����̯������Ϣ
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
