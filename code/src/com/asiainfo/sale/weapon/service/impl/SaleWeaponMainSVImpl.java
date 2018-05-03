package com.asiainfo.sale.weapon.service.impl;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.weapon.dao.interfaces.ISaleWeaponMainDAO;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponInfoValue;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponMainDeValue;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponMainValue;
import com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponMainSV;

public class SaleWeaponMainSVImpl implements ISaleWeaponMainSV {
	public void delSaleWeaponMain(String mid)
	throws Exception, RuntimeException{
		ISaleWeaponMainDAO saleWeaponMainDAO = (ISaleWeaponMainDAO) ServiceFactory
		.getService(ISaleWeaponMainDAO.class);
		saleWeaponMainDAO.delSaleWeaponMain(mid);
	}
	
	public void delSaleWeaponMain(IBOSaleWeaponMainValue[] saleWeaponMainValues)
			throws Exception, RuntimeException {
		ISaleWeaponMainDAO saleWeaponMainDAO = (ISaleWeaponMainDAO) ServiceFactory
				.getService(ISaleWeaponMainDAO.class);
		saleWeaponMainDAO.delSaleWeaponMain(saleWeaponMainValues);
	}

	
	public int getCount(String name, String applicant, String org) throws Exception, RuntimeException {
		ISaleWeaponMainDAO saleWeaponMainDAO = (ISaleWeaponMainDAO) ServiceFactory
				.getService(ISaleWeaponMainDAO.class);
		return saleWeaponMainDAO.getCount(name, applicant, org);
	}

	
	public int getCountById(String id)
			throws Exception, RuntimeException {
		ISaleWeaponMainDAO saleWeaponMainDAO = (ISaleWeaponMainDAO) ServiceFactory
				.getService(ISaleWeaponMainDAO.class);
		return saleWeaponMainDAO.getCountById(id);
	}

	
	public IBOSaleWeaponMainValue[] getSaleWeaponMain(String name,
			String applicant, String org, int startNum, int endNum)
			throws Exception, RuntimeException {
		ISaleWeaponMainDAO saleWeaponMainDAO = (ISaleWeaponMainDAO) ServiceFactory
				.getService(ISaleWeaponMainDAO.class);
		return saleWeaponMainDAO.getSaleWeaponMain(name, applicant, org,
				startNum, endNum);
	}

	
	public IBOSaleWeaponMainValue[] getSaleWeaponMainById(String id,
			int startNum, int endNum) throws Exception, RuntimeException {
		ISaleWeaponMainDAO saleWeaponMainDAO = (ISaleWeaponMainDAO) ServiceFactory
				.getService(ISaleWeaponMainDAO.class);
		return saleWeaponMainDAO.getSaleWeaponMainById(id, startNum, endNum);
	}

	public IBOSaleWeaponMainValue[] getSaleWeaponMainById(String id) throws Exception, RuntimeException {
		ISaleWeaponMainDAO saleWeaponMainDAO = (ISaleWeaponMainDAO) ServiceFactory
				.getService(ISaleWeaponMainDAO.class);
		return saleWeaponMainDAO.getSaleWeaponMainById(id);
	}
	
	public void saveSaleWeaponMain(IBOSaleWeaponMainValue[] saleWeaponMainValues)
			throws Exception, RuntimeException {
		ISaleWeaponMainDAO saleWeaponMainDAO = (ISaleWeaponMainDAO) ServiceFactory
				.getService(ISaleWeaponMainDAO.class);
		saleWeaponMainDAO.saveSaleWeaponMain(saleWeaponMainValues);
	}


	@Override
	public IBOSaleWeaponInfoValue getSaleWeaponInfoValue(String id) throws Exception,
			RuntimeException {
		ISaleWeaponMainDAO saleWeaponMainDAO = (ISaleWeaponMainDAO) ServiceFactory
		.getService(ISaleWeaponMainDAO.class);
        return saleWeaponMainDAO.getSaleWeaponInfoValue(id);
	}
	
	public IBOSaleWeaponMainDeValue[] getSaleWeaponMainDeById(String id) throws Exception{
		ISaleWeaponMainDAO saleWeaponMainDAO = (ISaleWeaponMainDAO) ServiceFactory
		.getService(ISaleWeaponMainDAO.class);
        return saleWeaponMainDAO.getSaleWeaponMainDeById(id);
	}


	

	
		
	}


