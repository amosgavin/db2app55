package com.asiainfo.sale.access.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.access.dao.interfaces.IBusiChangeDAO;
import com.asiainfo.sale.access.ivalues.IBOBusiChangeValue;
import com.asiainfo.sale.access.service.interfaces.IBusiChangeSV;

public class BusiChangeSVImpl implements IBusiChangeSV {

	@Override
	public IBOBusiChangeValue getBusiChargeById(String busiId) throws Exception {

		return ((IBusiChangeDAO) ServiceFactory
				.getService(IBusiChangeDAO.class)).getBusiChargeById(busiId);
	}

	@Override
	public IBOBusiChangeValue[] queryBusiChangeValue(String busiId,
			String applyName, String principle, String cityId, String state,
			String beginTime, String endTime, int startNum, int endNum)
			throws Exception {

		return ((IBusiChangeDAO) ServiceFactory
				.getService(IBusiChangeDAO.class)).queryBusiChangeValue(busiId,
				applyName, principle, cityId, state, beginTime, endTime,
				startNum, endNum);
	}

	@Override
	public int queryBusiChangeCount(String busiId, String applyName,
			String principle, String cityId, String state, String beginTime,
			String endTime) throws Exception {

		return ((IBusiChangeDAO) ServiceFactory
				.getService(IBusiChangeDAO.class)).queryBusiChangeCount(busiId,
				applyName, principle, cityId, state, beginTime, endTime);
	}

	@Override
	public int saveBusiChange(IBOBusiChangeValue busiChangeValue)
			throws Exception {

		return ((IBusiChangeDAO) ServiceFactory
				.getService(IBusiChangeDAO.class))
				.saveBusiChange(busiChangeValue);
	}

	@Override
	public void deleteBusiChangeMainRecords(
			IBOBusiChangeValue[] busiChangeValues) throws Exception {

		((IBusiChangeDAO) ServiceFactory.getService(IBusiChangeDAO.class))
				.saveBusiChangeBatch(busiChangeValues);
	}

	@Override
	public void changeStateTo(String busiId, String state) throws Exception {

		((IBusiChangeDAO) ServiceFactory.getService(IBusiChangeDAO.class))
				.changeStateTo(busiId, state);
	}

	@Override
	public void changeStateToNoPass(String busiId) throws Exception {

		changeStateTo(busiId, "4");
	}

	@Override
	public void changeStateToPass(String busiId) throws Exception {

		changeStateTo(busiId, "3");
	}

	@Override
	public boolean isHasTicketChange(String busiId) throws Exception {

		return ((IBusiChangeDAO) ServiceFactory
				.getService(IBusiChangeDAO.class)).isHasTicketChange(busiId);
	}

	@Override
	public void changeStateTo2(String busiId) throws Exception {

		changeStateTo(busiId, "2");
	}

	@Override
	public String checkdq_kf(String busiId) throws Exception {
		return ((IBusiChangeDAO) ServiceFactory
				.getService(IBusiChangeDAO.class)).checkdq_kf(busiId);
	}

}
