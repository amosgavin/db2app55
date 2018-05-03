package com.asiainfo.sale.weapon.service.impl;

import java.rmi.RemoteException;

import com.ai.appframe2.service.ServiceFactory;
import com.asiainfo.sale.weapon.dao.interfaces.ISaleWeaponCommonDAO;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponStaticDataValue;
import com.asiainfo.sale.weapon.service.interfaces.ISaleWeaponCommonSV;

public class SaleWeaponCommonSVImpl implements ISaleWeaponCommonSV {

	
	public IBOSaleWeaponStaticDataValue[] getSaleWeaponStaticData(
			String codeType, String marketType) throws Exception, RemoteException {
		ISaleWeaponCommonDAO saleWeaponCommonDAO = (ISaleWeaponCommonDAO) ServiceFactory
				.getService(ISaleWeaponCommonDAO.class);
		return saleWeaponCommonDAO.getSaleWeaponStaticData(codeType, marketType);
	}
}
