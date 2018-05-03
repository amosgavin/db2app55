package com.asiainfo.sale.weapon.dao.interfaces;

import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponDeValue;


public interface ISaleWeaponDetailShowDAO {
	public IBOSaleWeaponDeValue[] getSaleWeaponDetailShowValues(String id)
	throws Exception;
}
