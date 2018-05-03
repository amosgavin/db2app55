package com.asiainfo.sale.activity.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.activity.dao.interfaces.ISaleOrderDAO;
import com.asiainfo.sale.activity.ivalues.IBOSaleDetailValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleMainValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleOrderValue;
import com.asiainfo.sale.activity.service.interfaces.ISaleOrderSV;
import com.asiainfo.sale.weapon.dao.interfaces.ISaleWeaponDAO;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponValue;

public class SaleOrderSVImpl implements ISaleOrderSV {

	@Override
	public IBOSaleOrderValue[] getSaleOrderInfo(String orderId,
			String orderName, String pinciple, String staffName, String orgId,
			String orgName, String state, String beginTime, String endTime,
			int startNum, int endNum) throws Exception {

		return ((ISaleOrderDAO) ServiceFactory.getService(ISaleOrderDAO.class))
				.getSaleOrderInfo(orderId, orderName, pinciple, staffName,
						orgId, orgName, state, beginTime, endTime, startNum,
						endNum);
	}

	@Override
	public int saveSaleOrderInfo(IBOSaleOrderValue saleOrderValue)
			throws Exception {
		return ((ISaleOrderDAO) ServiceFactory.getService(ISaleOrderDAO.class))
				.saveSaleOrderInfo(saleOrderValue);
	}

	@Override
	public IBOSaleMainValue[] getSaleMainByOrderId(String orderId,
			int startNum, int endNum) throws Exception {

		return ((ISaleOrderDAO) ServiceFactory.getService(ISaleOrderDAO.class))
				.getSaleMainByOrderId(orderId, startNum, endNum);
	}

	@Override
	public int getSaleMainCountByOrderId(String orderId) throws Exception {

		return ((ISaleOrderDAO) ServiceFactory.getService(ISaleOrderDAO.class))
				.getSaleMainCountByOrderId(orderId);
	}

	@Override
	public int getSaleOrderCount(String orderId, String orderName,
			String pinciple, String staffName, String orgId, String orgName,
			String state, String beginTime, String endTime) throws Exception {

		return ((ISaleOrderDAO) ServiceFactory.getService(ISaleOrderDAO.class))
				.getSaleOrderCount(orderId, orderName, pinciple, staffName,
						orgId, orgName, state, beginTime, endTime);
	}

	@Override
	public void cloneSaleOrder(String orderId, String operatorId,
			String staffName, String orgId, String orgName) throws Exception {

		((ISaleOrderDAO) ServiceFactory.getService(ISaleOrderDAO.class))
				.cloneSaleOrder(orderId, operatorId, staffName, orgId, orgName);
	}

	@Override
	public IBOSaleOrderValue getSaleOrderInfo(String orderId) throws Exception {

		return ((ISaleOrderDAO) ServiceFactory.getService(ISaleOrderDAO.class))
				.getSaleOrderInfo(orderId);
	}

	@Override
	public void changeStsTo(String orderId, String state) throws Exception,
			RuntimeException {

		((ISaleOrderDAO) ServiceFactory.getService(ISaleOrderDAO.class))
				.changeStsTo(orderId, state);
	}

	@Override
	public void changeStsToAgreen(String orderId) throws Exception,
			RuntimeException {

		((ISaleOrderDAO) ServiceFactory.getService(ISaleOrderDAO.class))
				.changeStsToAgreen(orderId);
	}

	@Override
	public void changeStsToNo(String orderId) throws Exception,
			RuntimeException {

		((ISaleOrderDAO) ServiceFactory.getService(ISaleOrderDAO.class))
				.changeStsToNo(orderId);
	}

	@Override
	public IBOSaleDetailValue[] getSaleDetailByOrderId(String orderId,
			int startNum, int endNum) throws Exception {

		return ((ISaleOrderDAO) ServiceFactory.getService(ISaleOrderDAO.class))
				.getSaleDetailByOrderId(orderId, startNum, endNum);
	}

	@Override
	public int getSaleDetailCountByOrderId(String orderId) throws Exception {

		return ((ISaleOrderDAO) ServiceFactory.getService(ISaleOrderDAO.class))
				.getSaleDetailCountByOrderId(orderId);
	}

	@Override
	public void changeWeaponStateTo(String orderId, String state)
			throws Exception, RuntimeException {
		ISaleWeaponDAO wpSV = (ISaleWeaponDAO) ServiceFactory
				.getService(ISaleWeaponDAO.class);
		IBOSaleWeaponValue[] wps = wpSV.getSaleWeaponByActivityId(orderId);
		for (IBOSaleWeaponValue wp : wps) {
			wp.setState(state);
		}
		wpSV.saveSaleWeapon(wps);
	}

	@Override
	public IBOSaleOrderValue[] getRelatSaleOrderByWpId(String wpId,
			int startNum, int endNum) throws Exception, RuntimeException {

		return ((ISaleOrderDAO) ServiceFactory.getService(ISaleOrderDAO.class))
				.getRelatSaleOrderByWpId(wpId, startNum, endNum);
	}

	@Override
	public int getRelatSaleOrderCnByWpId(String wpId)
			throws Exception, RuntimeException {

		return ((ISaleOrderDAO) ServiceFactory.getService(ISaleOrderDAO.class))
				.getRelatSaleOrderCnByWpId(wpId);
	}

	@Override
	public int getSaleOrderCountBySql(String orderId, String orderName,
			String pinciple, String staffName, String orgId, String orgName,
			String state, String beginTime, String endTime) throws Exception {

		return ((ISaleOrderDAO) ServiceFactory.getService(ISaleOrderDAO.class))
		.getSaleOrderCountBySql(orderId, orderName, pinciple, staffName,
				orgId, orgName, state, beginTime, endTime);
	}

	@Override
	public IBOSaleOrderValue[] getSaleOrderInfoBySql(String orderId,
			String orderName, String pinciple, String staffName, String orgId,
			String orgName, String state, String beginTime, String endTime,
			int startNum, int endNum) throws Exception {

		return ((ISaleOrderDAO) ServiceFactory.getService(ISaleOrderDAO.class))
		.getSaleOrderInfoBySql(orderId, orderName, pinciple, staffName,
				orgId, orgName, state, beginTime, endTime, startNum,
				endNum);
	}

}
