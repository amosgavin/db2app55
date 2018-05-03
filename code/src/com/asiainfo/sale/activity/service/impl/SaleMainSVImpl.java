package com.asiainfo.sale.activity.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.activity.dao.interfaces.ISaleMainDAO;
import com.asiainfo.sale.activity.ivalues.IBOSaleDetailValue;
import com.asiainfo.sale.activity.ivalues.IBOSaleMainValue;
import com.asiainfo.sale.activity.service.interfaces.ISaleDetailSV;
import com.asiainfo.sale.activity.service.interfaces.ISaleMainSV;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponValue;
import com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponSV;

public class SaleMainSVImpl implements ISaleMainSV {

	public void delSaleMain(IBOSaleMainValue[] SaleMainValues)
			throws Exception, RuntimeException {
		((ISaleMainDAO) ServiceFactory.getService(ISaleMainDAO.class))
				.delSaleMain(SaleMainValues);
	}

	public int getCount(String name, String applicant, String org)
			throws Exception, RuntimeException {
		return ((ISaleMainDAO) ServiceFactory.getService(ISaleMainDAO.class))
				.getCount(name, applicant, org);
	}

	public IBOSaleMainValue[] getSaleMain(String name, String applicant,
			String org, int startNum, int endNum) throws Exception,
			RuntimeException {
		return ((ISaleMainDAO) ServiceFactory.getService(ISaleMainDAO.class))
				.getSaleMain(name, applicant, org, startNum, endNum);
	}

	public IBOSaleMainValue getSaleMainById(String id) throws Exception,
			RuntimeException {
		return ((ISaleMainDAO) ServiceFactory.getService(ISaleMainDAO.class))
				.getSaleMainById(id);
	}

	public void saveSaleMain(IBOSaleMainValue[] SaleMainValues)
			throws Exception, RuntimeException {
		((ISaleMainDAO) ServiceFactory.getService(ISaleMainDAO.class))
				.saveSaleMain(SaleMainValues);
	}

	public String saveSaleMain(IBOSaleMainValue saleMainValue)
			throws Exception, RuntimeException {
		return ((ISaleMainDAO) ServiceFactory.getService(ISaleMainDAO.class))
				.saveSaleMain(saleMainValue);
	}

	public void setWeaponState(String mainId) throws Exception,
			RuntimeException {
		ISaleDetailSV iSaleDetailSV = (ISaleDetailSV) ServiceFactory
				.getService(ISaleDetailSV.class);
		IBOSaleDetailValue[] detailValues = iSaleDetailSV
				.getSaleDetailByMainId(mainId, -1, -1);
		ISaleWeaponSV saleWeaponSV = (ISaleWeaponSV) ServiceFactory
				.getService(ISaleWeaponSV.class);
		String saleFlagString = null;
		for (IBOSaleDetailValue iboSaleDetailValue : detailValues) {
			IBOSaleWeaponValue iboSaleWeaponValue = saleWeaponSV
					.getSaleWeaponByID(iboSaleDetailValue.getWeaponId(), -1, -1)[0];
			saleFlagString = iboSaleWeaponValue.getSaleFlag();
			if ("16".equals(saleFlagString)) {
				// 8.21需求变更
				iboSaleWeaponValue.setState("N");
			}
			saleWeaponSV
					.saveSaleWeapon(new IBOSaleWeaponValue[] { iboSaleWeaponValue });
		}
	}

	@Override
	public void cloneSaleMain(String mainId, String orderId) throws Exception,
			RuntimeException {
		((ISaleMainDAO) ServiceFactory.getService(ISaleMainDAO.class))
				.cloneSaleMain(mainId, orderId);
	}

	@Override
	public void changeStsToAgreen(String mainId) throws Exception,
			RuntimeException {

		((ISaleMainDAO) ServiceFactory.getService(ISaleMainDAO.class))
				.changeStsToAgreen(mainId);
	}

	@Override
	public void changeStsToNo(String mainId) throws Exception, RuntimeException {

		((ISaleMainDAO) ServiceFactory.getService(ISaleMainDAO.class))
				.changeStsToNo(mainId);
	}

	@Override
	public void deleteSaleMainByMainId(String mainId) throws Exception {

		((ISaleMainDAO) ServiceFactory.getService(ISaleMainDAO.class))
				.deleteSaleMainByMainId(mainId);
	}

	@Override
	public void changeStsTo(String mainId, String state) throws Exception,
			RuntimeException {

		((ISaleMainDAO) ServiceFactory.getService(ISaleMainDAO.class))
				.changeStsTo(mainId, state);
	}

	@Override
	public String getNewACTCode(IBOSaleMainValue saleMain) throws Exception,
			RuntimeException {

		return ((ISaleMainDAO) ServiceFactory.getService(ISaleMainDAO.class))
				.getNewACTCode(saleMain);
	}

	@Override
	public boolean IsHasSameBossId(String actBossid, String orderId)
			throws Exception {

		return ((ISaleMainDAO) ServiceFactory.getService(ISaleMainDAO.class))
				.IsHasSameBossId(actBossid, orderId);
	}

	@Override
	public boolean hasEmptyExplantStatistic(String orderId) throws Exception {

		return ((ISaleMainDAO) ServiceFactory.getService(ISaleMainDAO.class))
				.hasEmptyExplantStatistic(orderId);
	}

	@Override
	public boolean hasEitAppriseToWrite(String orderId) throws Exception {

		return ((ISaleMainDAO) ServiceFactory.getService(ISaleMainDAO.class))
				.hasEitAppriseToWrite(orderId);
	}

	@Override
	public boolean hasEitInSale(String orderId) throws Exception {

		return ((ISaleMainDAO) ServiceFactory.getService(ISaleMainDAO.class))
				.hasEitInSale(orderId);
	}

	@Override
	public String checksalemaintype(String orderId) throws Exception{
		
		return ((ISaleMainDAO) ServiceFactory.getService(ISaleMainDAO.class))
		.checksalemaintype(orderId);
	}
}
