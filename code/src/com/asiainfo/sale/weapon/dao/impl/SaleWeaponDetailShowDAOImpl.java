package com.asiainfo.sale.weapon.dao.impl;




import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import com.asiainfo.sale.activity.bo.BOSaleDetailShowEngine;
import com.asiainfo.sale.activity.ivalues.IBOSaleDetailShowValue;
import com.asiainfo.sale.weapon.bo.BOSaleWeaponDeEngine;
import com.asiainfo.sale.weapon.dao.interfaces.ISaleWeaponDetailShowDAO;
import com.asiainfo.sale.weapon.ivalues.IBOSaleWeaponDeValue;

public class SaleWeaponDetailShowDAOImpl implements ISaleWeaponDetailShowDAO {

	@Override
	public IBOSaleWeaponDeValue[] getSaleWeaponDetailShowValues(String id)
			throws Exception {
		String condition = " " + IBOSaleWeaponDeValue.S_Mid + " = :id";
		Map parameter = new HashedMap();
		parameter.put("id", id);
		return BOSaleWeaponDeEngine.getBeans(condition, parameter);
	}

	

}
